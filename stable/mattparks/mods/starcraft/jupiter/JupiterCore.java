package mattparks.mods.starcraft.jupiter;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.Version;
import mattparks.mods.starcraft.jupiter.dimension.SCJupiterTeleportType;
import mattparks.mods.starcraft.jupiter.dimension.SCJupiterWorldProvider;
import mattparks.mods.starcraft.jupiter.entities.SCJupiterEntityRocketT5;
import mattparks.mods.starcraft.jupiter.items.JupiterItems;
import mattparks.mods.starcraft.jupiter.network.SCJupiterPacketHandlerServer;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(name = JupiterCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = JupiterCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { JupiterCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class JupiterCore
{
    public static final String NAME = "Starcraft Jupiter";
    public static final String MODID = "GCJupiter";
    public static final String CHANNEL = "GCJupiter";
    public static final String CHANNELENTITIES = "GCJupiterEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftjupiter/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.jupiter.client.ClientProxyJupiter", serverSide = "mattparks.mods.starcraft.jupiter.CommonProxyJupiter")
    public static CommonProxyJupiter proxy;

    @Instance(JupiterCore.MODID)
    public static JupiterCore instance;

    public static final String ASSET_DOMAIN = "starcraftjupiter";
    public static final String ASSET_PREFIX = JupiterCore.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
	public static CreativeTabs starcraftGasTab = new CreativeTabs("starcraftGasTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(JupiterItems.spaceshipT5, 1, 0);
		}
	};
	
	public static SCJupiterPlanet jupiter;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : JupiterCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(JupiterCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(JupiterCore.LANGUAGE_PATH + language + ".lang", child, false);
                            languages++;
                        }
                    }
                }
                catch (Exception e)
                {
                    FMLLog.severe("Failed to load a child language file.");
                    e.printStackTrace();
                }
            }

            languages++;
        }

        GCLog.info("Starcraft Jupiter Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(JupiterCore.instance, JupiterCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        JupiterCore.proxy.init(event);
        JupiterCore.jupiter = new SCJupiterPlanet();
        GalacticraftRegistry.registerTeleportType(SCJupiterWorldProvider.class, new SCJupiterTeleportType());
        GalacticraftRegistry.registerCelestialBody(JupiterCore.jupiter);
        GalacticraftRegistry.registerRocketGui(SCJupiterWorldProvider.class, new ResourceLocation(JupiterCore.ASSET_DOMAIN, "textures/gui/mercuryRocketGui.png"));

    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        JupiterCore.proxy.postInit(event);
        JupiterCore.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new SCJupiterConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/jupiter.conf"));

        JupiterItems.initItems();
        
        JupiterCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, JupiterCore.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
    
    public void registerOtherEntities()
    {
    	this.registerGalacticraftNonMobEntity(SCJupiterEntityRocketT5.class, "SpaceshipT5", SCJupiterConfigManager.idEntitySpaceshipTier5, 150, 1, true);
    }

    public void registerTileEntities()
    {
    	;
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new SCJupiterPacketHandlerServer(), JupiterCore.CHANNEL, Side.SERVER);
    }
}
