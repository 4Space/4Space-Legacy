package mattparks.mods.starcraft.makemake;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.makemake.dimension.GCMakemakeTeleportType;
import mattparks.mods.starcraft.makemake.dimension.GCMakemakeWorldProvider;
import mattparks.mods.starcraft.makemake.network.GCMakemakePacketHandlerServer;
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

@Mod(modid="StarcraftMakemake", name="StarcraftMakemake", version="0.0.1", dependencies = "required-after:GalacticraftCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GCMakemake
{
    public static final String NAME = "Starcraft Makemake";
    public static final String MODID = "GCMakeMake";
    public static final String CHANNEL = "GCMakeMake";
    public static final String CHANNELENTITIES = "GCMakeMakeEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftmakemake/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.makemake.client.ClientProxyMakemake", serverSide = "mattparks.mods.starcraft.makemake.CommonProxyMakemake")
    public static CommonProxyMakemake proxy;

    @Instance(GCMakemake.MODID)
    public static GCMakemake instance;

    public static final String ASSET_DOMAIN = "starcraftmakemake";
    public static final String ASSET_PREFIX = GCMakemake.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
	public static CreativeTabs starcraftMakemakeTab = new CreativeTabs("starcraftMakemakeTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(GCMakemakeBlocks.MakemakeDirt, 1, 0);
		}
	};
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCMakemake.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCMakemake.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCMakemake.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Makemake Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCMakemake.instance, GCMakemake.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCMakemake.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCMakemakeWorldProvider.class, new GCMakemakeTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCMakemakePlanet());
        GalacticraftRegistry.registerRocketGui(GCMakemakeWorldProvider.class, new ResourceLocation(GCMakemake.ASSET_DOMAIN, "textures/gui/MakemakeRocketGui.png"));
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCMakemake.proxy.postInit(event);
        GCMakemake.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCMakemakeConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/saturn.conf"));

        GCMakemake.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCMakemake.instance, 80, 3, true);
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
        NetworkRegistry.instance().registerChannel(new GCMakemakePacketHandlerServer(), GCMakemake.CHANNEL, Side.SERVER);
    }
}
