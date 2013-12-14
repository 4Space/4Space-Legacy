package mattparks.mods.starcraft.sedna;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.sedna.dimension.GCSednaTeleportType;
import mattparks.mods.starcraft.sedna.dimension.GCSednaWorldProvider;
import mattparks.mods.starcraft.sedna.entity.monster.EntityEvolvedEnderman;
import mattparks.mods.starcraft.sedna.items.GCSednaItems;
import mattparks.mods.starcraft.sedna.network.GCSednaPacketHandlerServer;
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

@Mod(name = GCSedna.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCSedna.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCSedna.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCSedna
{
    public static final String NAME = "Starcraft sedna";
    public static final String MODID = "GCsedna";
    public static final String CHANNEL = "GCsedna";
    public static final String CHANNELENTITIES = "GCsednaEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftsedna/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.sedna.client.ClientProxySedna", serverSide = "mattparks.mods.starcraft.sedna.CommonProxySedna")
    public static CommonProxySedna proxy;

    @Instance(GCSedna.MODID)
    public static GCSedna instance;

    public static final String ASSET_DOMAIN = "starcraftsedna";
    public static final String ASSET_PREFIX = GCSedna.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
	public static CreativeTabs starcraftSednaTab = new CreativeTabs("starcraftSednaTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(GCSednaItems.gravityBoots, 1, 0);
		}
	};
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCSedna.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCSedna.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCSedna.LANGUAGE_PATH + language + ".lang", child, false);
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

        NetworkRegistry.instance().registerGuiHandler(GCSedna.instance, GCSedna.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCSedna.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCSednaWorldProvider.class, new GCSednaTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCSednaPlanet());
        GalacticraftRegistry.registerRocketGui(GCSednaWorldProvider.class, new ResourceLocation(GCSedna.ASSET_DOMAIN, "textures/gui/sednaRocketGui.png"));
        
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCSedna.proxy.postInit(event);
        GCSedna.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCSednaConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/sedna.conf"));

        GCSednaItems.initItems();

        GCSedna.proxy.preInit(event);
    }

    public void registerCreatures()
    {
        GCCoreUtil.registerGalacticraftCreature(EntityEvolvedEnderman.class, "EvolvedEnderman", GCSednaConfigManager.idEntityEvolvedEnderman, 44975, 7969893);
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCSedna.instance, 80, 3, true);
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
        NetworkRegistry.instance().registerChannel(new GCSednaPacketHandlerServer(), GCSedna.CHANNEL, Side.SERVER);
    }
}
