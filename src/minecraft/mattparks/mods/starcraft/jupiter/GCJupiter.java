package mattparks.mods.starcraft.jupiter;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.core.SCCoreConfigManager;
import mattparks.mods.starcraft.jupiter.dimension.GCJupiterTeleportType;
import mattparks.mods.starcraft.jupiter.dimension.GCJupiterWorldProvider;
import mattparks.mods.starcraft.jupiter.entities.SCCoreEntityRocketT5;
import mattparks.mods.starcraft.jupiter.items.GCJupiterItems;
import mattparks.mods.starcraft.jupiter.network.GCJupiterPacketHandlerServer;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
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

@Mod(name = GCJupiter.NAME, version = GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCJupiter.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCJupiter.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCJupiter
{
    public static final String NAME = "Starcraft Jupiter";
    public static final String MODID = "GCJupiter";
    public static final String CHANNEL = "GCJupiter";
    public static final String CHANNELENTITIES = "GCJupiterEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftjupiter/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.jupiter.client.ClientProxyJupiter", serverSide = "mattparks.mods.starcraft.jupiter.CommonProxyJupiter")
    public static CommonProxyJupiter proxy;

    @Instance(GCJupiter.MODID)
    public static GCJupiter instance;

    public static final String ASSET_DOMAIN = "starcraftjupiter";
    public static final String ASSET_PREFIX = GCJupiter.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCJupiterConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/jupiter.conf"));

        GCJupiterItems.initItems();
        
        GCJupiter.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCJupiter.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCJupiter.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCJupiter.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Jupiter Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCJupiter.instance, GCJupiter.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCJupiter.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCJupiterWorldProvider.class, new GCJupiterTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCJupiterPlanet());
        GalacticraftRegistry.registerRocketGui(GCJupiterWorldProvider.class, new ResourceLocation(GCJupiter.ASSET_DOMAIN, "textures/gui/mercuryRocketGui.png"));

    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCJupiterPacketHandlerServer(), GCJupiter.CHANNEL, Side.SERVER);
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
    	this.registerGalacticraftNonMobEntity(SCCoreEntityRocketT5.class, "SpaceshipT5", GCJupiterConfigManager.idEntitySpaceshipTier5, 150, 1, true);
    }
    
    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCJupiter.proxy.postInit(event);
        GCJupiter.proxy.registerRenderInformation();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCJupiter.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
