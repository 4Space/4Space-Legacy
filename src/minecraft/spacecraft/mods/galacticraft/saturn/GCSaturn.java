package spacecraft.mods.galacticraft.saturn;

import java.io.File;
import java.util.HashMap;

import spacecraft.mods.galacticraft.saturn.dimension.GCSaturnTeleportType;
import spacecraft.mods.galacticraft.saturn.dimension.GCSaturnWorldProvider;
import spacecraft.mods.galacticraft.saturn.network.GCSaturnPacketHandlerServer;
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

@Mod(name = GCSaturn.NAME, version = GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCSaturn.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCSaturn.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCSaturn
{
    public static final String NAME = "Spacecraft Saturn";
    public static final String MODID = "GCSaturn";
    public static final String CHANNEL = "GCSaturn";
    public static final String CHANNELENTITIES = "GCSaturnEntities";

    public static final String LANGUAGE_PATH = "/assets/spacecraftsaturn/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "spacecraft.mods.galacticraft.saturn.client.ClientProxySaturn", serverSide = "spacecraft.mods.galacticraft.saturn.CommonProxySaturn")
    public static CommonProxySaturn proxy;

    @Instance(GCSaturn.MODID)
    public static GCSaturn instance;

    public static final String TEXTURE_DOMAIN = "spacecraftsaturn";
    public static final String TEXTURE_PREFIX = GCSaturn.TEXTURE_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCSaturnConfigManager(new File(event.getModConfigurationDirectory(), "spacecraft/saturn.conf"));

//        GCVenusBlocks.initBlocks();
//        GCVenusBlocks.setHarvestLevels();

        GCSaturn.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCSaturn.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCSaturn.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCSaturn.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Spacecraft Saturn Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCSaturn.instance, GCSaturn.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCSaturn.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCSaturnWorldProvider.class, new GCSaturnTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCSaturnPlanet());
        GalacticraftRegistry.registerRocketGui(GCSaturnWorldProvider.class, new ResourceLocation(GCSaturn.TEXTURE_DOMAIN, "textures/gui/saturnRocketGui.png"));

//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 3), new ItemStack(GCCoreItems.heavyPlatingTier1), new ItemStack(GCMoonItems.meteoricIronIngot, 1, 1));
//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 5), new ItemStack(GCVenusItems.venusItemBasic, 1, 2));
    
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(PlutoBlocks.MercuryRedGemOre, 5, 24, 0, 75, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(MercuryBlocks.MercuryDirt, 5, 24, 0, 75, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(PlutoBlocks.MercuryCoalOre, 7, 18, 0, 45, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(PlutoBlocks.MercuryTinOre, 8, 3, 0, 25, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(PlutoBlocks.MercuryCopperOre, 8, 3, 0, 25, 7));
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCSaturnPacketHandlerServer(), GCSaturn.CHANNEL, Side.SERVER);
    }

    public void registerTileEntities()
    {
    }

    public void registerCreatures()
    {
    }

    public void registerOtherEntities()
    {
    }
    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCSaturn.proxy.postInit(event);
        GCSaturn.proxy.registerRenderInformation();
//        GCSaturnRecipeManager.loadRecipes();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCSaturn.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
