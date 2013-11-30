package mattparks.mods.starcraft.core;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.core.blocks.*;
import mattparks.mods.starcraft.core.network.SCCorePacketHandlerServer;
import mattparks.mods.starcraft.eris.GCEris;
import mattparks.mods.starcraft.eris.items.GCErisItems;
import mattparks.mods.starcraft.jupiter.GCJupiter;
import mattparks.mods.starcraft.mercury.GCMercury;
import mattparks.mods.starcraft.pluto.GCPluto;
import mattparks.mods.starcraft.sedna.GCSedna;
import mattparks.mods.starcraft.venus.GCVenus;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
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

@Mod(name = StarcraftCore.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = StarcraftCore.MODID, dependencies = "required-after:Forge@[9.10.0.837,); after:ICBM|Explosion; after:IC2; after:BuildCraft|Core; after:BuildCraft|Energy; after:IC2")
@NetworkMod(channels = { StarcraftCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class StarcraftCore
{
    public static final String NAME = "Starcraft Core";
    public static final String MODID = "StarcraftCore";
    public static final String CHANNEL = "GCStarcraftCore";
    public static final String CHANNELENTITIES = "SCCoreEntities";

    public static final int LOCALMAJVERSION = 0;
    public static final int LOCALMINVERSION = 0;
    public static final int LOCALBUILDVERSION = 2;
    public static int remoteMajVer;
    public static int remoteMinVer;
    public static int remoteBuildVer;

//    public static final String LANGUAGE_PATH = "/assets/starcraftcore/lang/";
//    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.core.client.ClientProxy", serverSide = "mattparks.mods.starcraft.core.CommonProxy")
    public static CommonProxy proxy;

    @Instance(StarcraftCore.MODID)
    public static StarcraftCore instance;

//    public static final String ASSET_DOMAIN = "starcraftcore";
//    public static final String ASSET_PREFIX = StarcraftCore.ASSET_DOMAIN + ":";
    
//    public static long tick;
//    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new StarcraftCoreConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/core.conf"));

//        SCCoreItem.initItems();
        
        StarcraftCore.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
//        int languages = 0;
//
//        for (String language : StarcraftCore2.LANGUAGES_SUPPORTED)
//        {
//            LanguageRegistry.instance().loadLocalization(StarcraftCore2.LANGUAGE_PATH + language + ".lang", language, false);
//
//            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
//            {
//                try
//                {
//                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");
//
//                    for (String child : children)
//                    {
//                        if (child != "" || child != null)
//                        {
//                            LanguageRegistry.instance().loadLocalization(StarcraftCore2.LANGUAGE_PATH + language + ".lang", child, false);
//                            languages++;
//                        }
//                    }
//                }
//                catch (Exception e)
//                {
//                    FMLLog.severe("Failed to load a child language file.");
//                    e.printStackTrace();
//                }
//            }
//
//            languages++;
//        }
//
//        GCLog.info("Starcraft Core Loaded: " + languages + " Languages.");

//        SchematicRegistry.registerSchematicRecipe(new GCVenusSchematicRocketT3());
        // TODO add Tier 3-6 to crafting bench  
        
        NetworkRegistry.instance().registerGuiHandler(StarcraftCore.instance, StarcraftCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        StarcraftCore.proxy.init(event);
//        GalacticraftRegistry.addDungeonLoot(2, new ItemStack(SCCoreItems.schematic, 1, 0));
        // TODO add Tier 3-6 schematics to dungeons       
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new SCCorePacketHandlerServer(), StarcraftCore.CHANNEL, Side.SERVER);
    }

    public void registerTileEntities()
    {
    	;
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerOtherEntities()
    {
    	;
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        StarcraftCore.proxy.postInit(event);
        StarcraftCore.proxy.registerRenderInformation();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, StarcraftCore.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
