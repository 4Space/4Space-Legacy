package mattparks.mods.starcraft.vesta;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.vesta.dimension.GCVestaTeleportType;
import mattparks.mods.starcraft.vesta.dimension.GCVestaWorldProvider;
import mattparks.mods.starcraft.vesta.network.GCVestaPacketHandlerServer;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GCLog;
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

@Mod(modid="StarcraftVesta", name="StarcraftVesta", version="0.0.1", dependencies = "required-after:GalacticraftCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GCVesta
{
    public static final String NAME = "Starcraft Vesta";
    public static final String MODID = "GCVesta";
    public static final String CHANNEL = "GCVesta";
    public static final String CHANNELENTITIES = "GCVestaEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftvesta/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.vesta.client.ClientProxyVesta", serverSide = "mattparks.mods.starcraft.vesta.CommonProxyVesta")
    public static CommonProxyVesta proxy;

    @Instance(GCVesta.MODID)
    public static GCVesta instance;

    public static final String ASSET_DOMAIN = "starcraftvesta";
    public static final String ASSET_PREFIX = GCVesta.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
	public static CreativeTabs starcraftVestaTab = new CreativeTabs("starcraftVestaTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(GCVestaBlocks.VestaDirt, 1, 0);
		}
	};
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCVesta.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCVesta.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCVesta.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Saturn Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCVesta.instance, GCVesta.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCVesta.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCVestaWorldProvider.class, new GCVestaTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCVestaPlanet());
        GalacticraftRegistry.registerRocketGui(GCVestaWorldProvider.class, new ResourceLocation(GCVesta.ASSET_DOMAIN, "textures/gui/vestaRocketGui.png"));
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCVesta.proxy.postInit(event);
        GCVesta.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCVestaConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/saturn.conf"));

        GCVesta.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCVesta.instance, 80, 3, true);
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
        NetworkRegistry.instance().registerChannel(new GCVestaPacketHandlerServer(), GCVesta.CHANNEL, Side.SERVER);
    }
}
