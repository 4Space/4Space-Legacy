package spacecraft.mods.galacticraft.venus;

import java.io.File;
import java.util.HashMap;

import spacecraft.mods.galacticraft.venus.blocks.*;
import spacecraft.mods.galacticraft.venus.dimension.GCVenusTeleportType;
import spacecraft.mods.galacticraft.venus.dimension.GCVenusWorldProvider;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityEvolvedBlaze;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityFlameling;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityVenusianVillager;
import spacecraft.mods.galacticraft.venus.items.GCVenusItems;
import spacecraft.mods.galacticraft.venus.network.GCVenusPacketHandlerServer;
import spacecraft.mods.galacticraft.venus.recipe.GCVenusRecipeManager;
import spacecraft.mods.galacticraft.spacecraftBlocks.SpacecraftBlocks;
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

@Mod(name = GCVenus.NAME, version = GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCVenus.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCVenus.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCVenus
{
    public static final String NAME = "Galacticraft Venus";
    public static final String MODID = "GCVenus";
    public static final String CHANNEL = "GCVenus";
    public static final String CHANNELENTITIES = "GCVenusEntities";

    public static final String LANGUAGE_PATH = "/assets/spacecraftvenus/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "spacecraft.mods.galacticraft.venus.client.ClientProxyVenus", serverSide = "spacecraft.mods.galacticraft.venus.CommonProxyVenus")
    public static CommonProxyVenus proxy;

    @Instance(GCVenus.MODID)
    public static GCVenus instance;

    public static final String TEXTURE_DOMAIN = "spacecraftvenus";
    public static final String TEXTURE_PREFIX = GCVenus.TEXTURE_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCVenusConfigManager(new File(event.getModConfigurationDirectory(), "spacecraft/venus.conf"));

//        GCVenusBlocks.initBlocks();
//        GCVenusBlocks.setHarvestLevels();

        GCVenusItems.initItems();

        GCVenus.proxy.preInit(event);
    }

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

        GCLog.info("Spacecraft Venus Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCVenus.instance, GCVenus.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCVenus.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCVenusWorldProvider.class, new GCVenusTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCVenusPlanet());
        GalacticraftRegistry.registerRocketGui(GCVenusWorldProvider.class, new ResourceLocation(GCVenus.TEXTURE_DOMAIN, "textures/gui/venusRocketGui.png"));

//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 3), new ItemStack(GCCoreItems.heavyPlatingTier1), new ItemStack(GCMoonItems.meteoricIronIngot, 1, 1));
//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 5), new ItemStack(GCVenusItems.venusItemBasic, 1, 2));
    
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(SpacecraftBlocks.VenusRedGemOre, 5, 24, 0, 75, 7));
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(SpacecraftBlocks.VenusMeteorOre, 6, 22, 0, 60, 7));
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(SpacecraftBlocks.VenusSulferOre, 7, 18, 0, 45, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(SpacecraftBlocks.VenusDirt, 5, 24, 0, 75, 7));
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(SpacecraftBlocks.VenusIronOre, 6, 22, 0, 60, 7));
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(SpacecraftBlocks.VenusCoalOre, 7, 18, 0, 45, 7));
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(SpacecraftBlocks.VenusTinOre, 8, 3, 0, 25, 7));
        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(SpacecraftBlocks.VenusCopperOre, 8, 3, 0, 25, 7));
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCVenusPacketHandlerServer(), GCVenus.CHANNEL, Side.SERVER);
    }

    public void registerTileEntities()
    {
    }

    public void registerCreatures()
    {
    	GCCoreUtil.registerGalacticraftCreature(GCVenusEntityVenusianVillager.class, "VenusianVillager", GCVenusConfigManager.idEntityVenusianVillager, GCCoreUtil.convertTo32BitColor(255, 103, 181, 145), 12422002);
        GCCoreUtil.registerGalacticraftCreature(GCVenusEntityEvolvedBlaze.class, "EvolvedBlaze", GCVenusConfigManager.idEntityEvolvedBlaze, 44975, 7969893);
        GCCoreUtil.registerGalacticraftCreature(GCVenusEntityFlameling.class, "Flameling", GCVenusConfigManager.idEntityFlameling, 44975, 7969893);
    }

    public void registerOtherEntities()
    {
    }
    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCVenus.proxy.postInit(event);
        GCVenus.proxy.registerRenderInformation();
        GCVenusRecipeManager.loadRecipes();
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
}
