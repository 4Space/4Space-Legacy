package mattparks.mods.starcraft.sedna;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.Version;
import mattparks.mods.starcraft.sedna.dimension.SCSednaTeleportType;
import mattparks.mods.starcraft.sedna.dimension.SCSednaWorldProvider;
import mattparks.mods.starcraft.sedna.entities.SCSednaEntityRocketT6;
import mattparks.mods.starcraft.sedna.entity.monster.SCSednaEntityEvolvedEnderman;
import mattparks.mods.starcraft.sedna.items.SednaItems;
import mattparks.mods.starcraft.sedna.network.SCSednaPacketHandlerServer;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
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

@Mod(name = SednaCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = SednaCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { SednaCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class SednaCore
{
    public static final String NAME = "Starcraft sedna";
    public static final String MODID = "GCsedna";
    public static final String CHANNEL = "GCsedna";
    public static final String CHANNELENTITIES = "GCsednaEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftsedna/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.sedna.client.ClientProxySedna", serverSide = "mattparks.mods.starcraft.sedna.CommonProxySedna")
    public static CommonProxySedna proxy;

    @Instance(SednaCore.MODID)
    public static SednaCore instance;

    public static final String ASSET_DOMAIN = "starcraftsedna";
    public static final String ASSET_PREFIX = SednaCore.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
	public static CreativeTabs starcraftSednaTab = new CreativeTabs("starcraftSednaTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(SednaItems.gravityBoots, 1, 0);
		}
	};
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : SednaCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(SednaCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(SednaCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft sedna Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(SednaCore.instance, SednaCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        SednaCore.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(SCSednaWorldProvider.class, new SCSednaTeleportType());
        GalacticraftRegistry.registerCelestialBody(new SCSednaPlanet());
        GalacticraftRegistry.registerRocketGui(SCSednaWorldProvider.class, new ResourceLocation(SednaCore.ASSET_DOMAIN, "textures/gui/sednaRocketGui.png"));
        
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        SednaCore.proxy.postInit(event);
        SednaCore.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new SCSednaConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/sedna.conf"));

        SednaItems.initItems();

        SednaCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
        GCCoreUtil.registerGalacticraftCreature(SCSednaEntityEvolvedEnderman.class, "EvolvedEnderman", SCSednaConfigManager.idEntityEvolvedEnderman, 44975, 7969893);
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, SednaCore.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
    
    public void registerOtherEntities()
    {
    	this.registerGalacticraftNonMobEntity(SCSednaEntityRocketT6.class, "SpaceshipT6", SCSednaConfigManager.idEntitySpaceshipTier6, 150, 1, true);
    }

    public void registerTileEntities()
    {
    	;
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new SCSednaPacketHandlerServer(), SednaCore.CHANNEL, Side.SERVER);
    }
}
