package mattparks.mods.starcraft.eris;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.Version;
import mattparks.mods.starcraft.eris.blocks.ErisBlocks;
import mattparks.mods.starcraft.eris.dimension.SCErisTeleportType;
import mattparks.mods.starcraft.eris.dimension.SCErisWorldProvider;
import mattparks.mods.starcraft.eris.items.ErisItems;
import mattparks.mods.starcraft.eris.network.SCErisPacketHandlerServer;
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

@Mod(name = ErisCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = ErisCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { ErisCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class ErisCore
{
    public static final String NAME = "Starcraft Eris";
    public static final String MODID = "GCEris";
    public static final String CHANNEL = "GCEris";
    public static final String CHANNELENTITIES = "GCErisEntities";

    public static final String LANGUAGE_PATH = "/assets/starcrafteris/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" , "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.eris.client.ClientProxyEris", serverSide = "mattparks.mods.starcraft.eris.CommonProxyEris")
    public static CommonProxyEris proxy;

    @Instance(ErisCore.MODID)
    public static ErisCore instance;

    public static final String ASSET_DOMAIN = "starcrafteris";
    public static final String ASSET_PREFIX = ErisCore.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
	public static CreativeTabs starcraftErisTab = new CreativeTabs("starcraftErisTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(ErisBlocks.ErisGrass, 1, 0);
		}
	};
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : ErisCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(ErisCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(ErisCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Eris Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(ErisCore.instance, ErisCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        ErisCore.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(SCErisWorldProvider.class, new SCErisTeleportType());
        GalacticraftRegistry.registerCelestialBody(new SCErisPlanet());
        GalacticraftRegistry.registerRocketGui(SCErisWorldProvider.class, new ResourceLocation(ErisCore.ASSET_DOMAIN, "textures/gui/erisRocketGui.png"));    
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        ErisCore.proxy.postInit(event);
        ErisCore.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new SCErisConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/eris.conf"));

        ErisItems.initItems();

        ErisCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, ErisCore.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
    
    public void registerOtherEntities()
    {
    	;
    }

    public void registerTileEntities()
    {
    	;
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new SCErisPacketHandlerServer(), ErisCore.CHANNEL, Side.SERVER);
    }
}
