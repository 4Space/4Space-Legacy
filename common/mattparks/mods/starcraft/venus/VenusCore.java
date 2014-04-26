package mattparks.mods.starcraft.venus;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mattparks.mods.MattCore.Version;
import mattparks.mods.starcraft.venus.blocks.VenusBlocks;
import mattparks.mods.starcraft.venus.dimension.SCVenusTeleportType;
import mattparks.mods.starcraft.venus.dimension.SCVenusWorldProvider;
import mattparks.mods.starcraft.venus.entities.SCVenusEntityEvolvedBlaze;
import mattparks.mods.starcraft.venus.entities.SCVenusEntityFlameling;
import mattparks.mods.starcraft.venus.entities.SCVenusEntityRocketT3;
import mattparks.mods.starcraft.venus.entities.SCVenusEntityVenusianVillager;
import mattparks.mods.starcraft.venus.items.VenusItems;
import mattparks.mods.starcraft.venus.network.SCVenusPacketHandlerServer;
import mattparks.mods.starcraft.venus.recipe.SCVenusRecipeManager;
import mattparks.mods.starcraft.venus.schematic.SCVenusSchematicRocketT3;
import mattparks.mods.starcraft.venus.tile.SCVenusTileEntityTreasureChest;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.mars.items.GCMarsItems;
import micdoodle8.mods.galacticraft.mars.schematic.GCMarsSchematicRocketT2;
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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(name = VenusCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = VenusCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { VenusCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class VenusCore
{
    public static final String NAME = "Venus Core";
    public static final String MODID = "SCVenusCore";
    public static final String CHANNEL = "SCVenus";
    public static final String CHANNELENTITIES = "SCVenusCoreEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftvenus/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "cs_CZ", "de_DE", "en_US", "es_ES", "fi_FI", "fr_FR", "nl_NL", "pl_PL", "ru_RU", "tr_TR" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.venus.client.ClientProxyVenus", serverSide = "mattparks.mods.starcraft.venus.CommonProxyVenus")
    public static CommonProxyVenus proxy;

    @Instance(VenusCore.MODID)
    public static VenusCore instance;

	public static CreativeTabs starcraftVenusTab = new CreativeTabs("starcraftVenusTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(VenusBlocks.EvolvedBlazeEgg, 1, 0);
		}
	};

    public static final String ASSET_DOMAIN = "starcraftvenus";
    public static final String ASSET_PREFIX = VenusCore.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

	private static List<INasaWorkbenchRecipe> rocketBenchT3Recipes = new ArrayList<INasaWorkbenchRecipe>();
	
	public static List<INasaWorkbenchRecipe> getRocketT3Recipes()
	{
		return VenusCore.rocketBenchT3Recipes;
	}
	
	public static void addT3RocketRecipe(INasaWorkbenchRecipe recipe)
	{
		VenusCore.rocketBenchT3Recipes.add(recipe);
	}
	
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	SchematicRegistry.registerSchematicRecipe(new SCVenusSchematicRocketT3());
    	GalacticraftRegistry.addDungeonLoot(2, new ItemStack(VenusItems.T3Schematic, 1, 0));
    	
    	
        int languages = 0;
        
        for (String language : VenusCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(VenusCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(VenusCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        NetworkRegistry.instance().registerGuiHandler(VenusCore.instance, VenusCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        VenusCore.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(SCVenusWorldProvider.class, new SCVenusTeleportType());
        GalacticraftRegistry.registerCelestialBody(new SCVenusPlanet());
        GalacticraftRegistry.registerRocketGui(SCVenusWorldProvider.class, new ResourceLocation(VenusCore.ASSET_DOMAIN, "textures/gui/venusRocketGui.png"));
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        VenusCore.proxy.postInit(event);
        VenusCore.proxy.registerRenderInformation();
        SCVenusRecipeManager.loadRecipes();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new SCVenusConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/venus.conf"));

        VenusItems.initItems();

        VenusCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
        GCCoreUtil.registerGalacticraftCreature(SCVenusEntityVenusianVillager.class, "VenusianVillager", SCVenusConfigManager.idEntityVenusianVillager, GCCoreUtil.convertTo32BitColor(255, 103, 181, 145), 12422002);
        GCCoreUtil.registerGalacticraftCreature(SCVenusEntityEvolvedBlaze.class, "EvolvedBlaze", SCVenusConfigManager.idEntityEvolvedBlaze, 44975, 7969893);
        GCCoreUtil.registerGalacticraftCreature(SCVenusEntityFlameling.class, "Flameling", SCVenusConfigManager.idEntityFlameling, 44975, 7969893);
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, VenusCore.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
    
    public void registerOtherEntities()
    {
    	this.registerGalacticraftNonMobEntity(SCVenusEntityRocketT3.class, "SpaceshipT3", SCVenusConfigManager.idEntitySpaceshipTier3, 150, 1, true);
    }

    public void registerTileEntities()
    {
    	GameRegistry.registerTileEntity(SCVenusTileEntityTreasureChest.class, "Tier 3 Treasure Chest");
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new SCVenusPacketHandlerServer(), VenusCore.CHANNEL, Side.SERVER);
    }
}