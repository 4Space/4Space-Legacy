package mattparks.mods.starcraft.venus;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.core.StarcraftVenus;
import mattparks.mods.starcraft.venus.dimension.GCVenusTeleportType;
import mattparks.mods.starcraft.venus.dimension.GCVenusWorldProvider;
import mattparks.mods.starcraft.venus.entities.GCVenusEntityEvolvedBlaze;
import mattparks.mods.starcraft.venus.entities.GCVenusEntityFlameling;
import mattparks.mods.starcraft.venus.entities.GCVenusEntityVenusianVillager;
import mattparks.mods.starcraft.venus.entities.SCCoreEntityRocketT3;
import mattparks.mods.starcraft.venus.items.GCVenusItems;
import mattparks.mods.starcraft.venus.network.GCVenusPacketHandlerServer;
import mattparks.mods.starcraft.venus.recipe.GCVenusRecipeManager;
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

@Mod(name = GCVenus.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCVenus.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCVenus.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCVenus
{
    public static final String NAME = "Starcraft Venus";
    public static final String MODID = "GCVenus";
    public static final String CHANNEL = "GCVenus";
    public static final String CHANNELENTITIES = "GCVenusEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftvenus/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.venus.client.ClientProxyVenus", serverSide = "mattparks.mods.starcraft.venus.CommonProxyVenus")
    public static CommonProxyVenus proxy;

    @Instance(GCVenus.MODID)
    public static GCVenus instance;
	
	public static CreativeTabs starcraftVenusTab = new CreativeTabs("starcraftVenusTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(StarcraftVenus.EvolvedBlazeEgg, 1, 0);
		}
	};
	
    public static final String ASSET_DOMAIN = "starcraftvenus";
    public static final String ASSET_PREFIX = GCVenus.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCVenus.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCVenus.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCVenus.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Venus Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCVenus.instance, GCVenus.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCVenus.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCVenusWorldProvider.class, new GCVenusTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCVenusPlanet());
        GalacticraftRegistry.registerRocketGui(GCVenusWorldProvider.class, new ResourceLocation(GCVenus.ASSET_DOMAIN, "textures/gui/venusRocketGui.png"));
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCVenus.proxy.postInit(event);
        GCVenus.proxy.registerRenderInformation();
        GCVenusRecipeManager.loadRecipes();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCVenusConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/venus.conf"));

        GCVenusItems.initItems();

        GCVenus.proxy.preInit(event);
    }

    public void registerCreatures()
    {
        GCCoreUtil.registerGalacticraftCreature(GCVenusEntityVenusianVillager.class, "VenusianVillager", GCVenusConfigManager.idEntityVenusianVillager, GCCoreUtil.convertTo32BitColor(255, 103, 181, 145), 12422002);
        GCCoreUtil.registerGalacticraftCreature(GCVenusEntityEvolvedBlaze.class, "EvolvedBlaze", GCVenusConfigManager.idEntityEvolvedBlaze, 44975, 7969893);
        GCCoreUtil.registerGalacticraftCreature(GCVenusEntityFlameling.class, "Flameling", GCVenusConfigManager.idEntityFlameling, 44975, 7969893);
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCVenus.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
    
    public void registerOtherEntities()
    {
    	this.registerGalacticraftNonMobEntity(SCCoreEntityRocketT3.class, "SpaceshipT3", GCVenusConfigManager.idEntitySpaceshipTier3, 150, 1, true);
    }

    public void registerTileEntities()
    {
            ;
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCVenusPacketHandlerServer(), GCVenus.CHANNEL, Side.SERVER);
    }
}