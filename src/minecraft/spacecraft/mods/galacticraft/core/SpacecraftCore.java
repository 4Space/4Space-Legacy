package spacecraft.mods.galacticraft.core;

import java.io.File;
import java.util.HashMap;

import spacecraft.mods.galacticraft.core.entities.SCCoreEntityRocketT3;
import spacecraft.mods.galacticraft.core.items.SCCoreItems;
import spacecraft.mods.galacticraft.core.network.SCCorePacketHandlerServer;
import spacecraft.mods.galacticraft.core.recipe.SCCoreRecipeManager;
import spacecraft.mods.galacticraft.core.schematic.SCCoreSchematicRocketT3;
import spacecraft.mods.galacticraft.spacecraftBlocks.SpacecraftBlocks;
import spacecraft.mods.galacticraft.venus.items.GCVenusItems;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.blocks.GCCoreBlocks;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityAlienVillager;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntitySpider;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityZombie;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.world.gen.GCCoreOverworldGenerator;
import micdoodle8.mods.galacticraft.moon.items.GCMoonItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
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

@Mod(name = SpacecraftCore.NAME, version = GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION, useMetadata = true, modid = SpacecraftCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { SpacecraftCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class SpacecraftCore
{
    public static final String NAME = "Spacecraft Core";
    public static final String MODID = "SpacecraftCore";
    public static final String CHANNEL = "GCSpacecraftCore";
    public static final String CHANNELENTITIES = "SCCoreEntities";

    public static final String LANGUAGE_PATH = "/assets/spacecraftcore/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "spacecraft.mods.galacticraft.core.client.ClientProxySCCore", serverSide = "spacecraft.mods.galacticraft.core.CommonProxySCCore")
    public static CommonProxySCCore proxy;

    @Instance(SpacecraftCore.MODID)
    public static SpacecraftCore instance;
    
	public static CreativeTabs starcraftCoreTab = new CreativeTabs("spacecraftCoreTab") {
		public ItemStack getIconItemStack() {
			return new ItemStack(SCCoreItems.spaceship, 1, 0);
		}
	};
	
	public static CreativeTabs starcraftMercuryTab = new CreativeTabs("spacecraftMercuryTab") {
		public ItemStack getIconItemStack() {
			return new ItemStack(SpacecraftBlocks.MercuryGrass, 1, 0);
		}
	};
	
	public static CreativeTabs starcraftVenusTab = new CreativeTabs("spacecraftVenusTab") {
		public ItemStack getIconItemStack() {
			return new ItemStack(SpacecraftBlocks.VenusGrass, 1, 0);
		}
	};
	
	public static CreativeTabs starcraftGasTab = new CreativeTabs("spacecraftGasTab") {
		public ItemStack getIconItemStack() {
			return new ItemStack(SpacecraftBlocks.JupiterMediumGas, 1, 0);
		}
	};

	public static CreativeTabs starcraftPlutoTab = new CreativeTabs("spacecraftPlutoTab") {
		public ItemStack getIconItemStack() {
			return new ItemStack(SpacecraftBlocks.PlutoGrass, 1, 0);
		}
	};
	
    public static final String TEXTURE_DOMAIN = "spacecraftcore";
    public static final String TEXTURE_PREFIX = SpacecraftCore.TEXTURE_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new SCCoreConfigManager(new File(event.getModConfigurationDirectory(), "spacecraft/core.conf"));

//        GCVenusBlocks.initBlocks();
//        GCVenusBlocks.setHarvestLevels();

        SCCoreItems.initItems();

        SpacecraftCore.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : SpacecraftCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(SpacecraftCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(SpacecraftCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Spacecraft Core Loaded: " + languages + " Languages.");

        SchematicRegistry.registerSchematicRecipe(new SCCoreSchematicRocketT3());

        NetworkRegistry.instance().registerGuiHandler(SpacecraftCore.instance, SpacecraftCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        SpacecraftCore.proxy.init(event);
        GalacticraftRegistry.addDungeonLoot(2, new ItemStack(SCCoreItems.schematic, 1, 0));
        
//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 3), new ItemStack(GCCoreItems.heavyPlatingTier1), new ItemStack(GCMoonItems.meteoricIronIngot, 1, 1));
//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 5), new ItemStack(GCVenusItems.venusItemBasic, 1, 2));
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new SCCorePacketHandlerServer(), SpacecraftCore.CHANNEL, Side.SERVER);
    }

    public void registerTileEntities()
    {
    }

    public void registerCreatures()
    {
    }

    public void registerOtherEntities()
    {
    	this.registerGalacticraftNonMobEntity(SCCoreEntityRocketT3.class, "SpaceshipT3", SCCoreConfigManager.idEntitySpaceshipTier3, 150, 1, true);    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        SpacecraftCore.proxy.postInit(event);
        SpacecraftCore.proxy.registerRenderInformation();
        SCCoreRecipeManager.loadRecipes();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, SpacecraftCore.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
