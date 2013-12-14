package mattparks.mods.starcraft.saturn;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.saturn.dimension.GCSaturnTeleportType;
import mattparks.mods.starcraft.saturn.dimension.GCSaturnWorldProvider;
import mattparks.mods.starcraft.saturn.network.GCSaturnPacketHandlerServer;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import mattparks.mods.starcraft.core.network.GCCoreConnectionHandler;
import mattparks.mods.starcraft.core.network.GCCorePacketManager;
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

@Mod(name = GCSaturn.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCSaturn.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCSaturn.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCSaturn
{
    public static final String NAME = "Starcraft Saturn";
    public static final String MODID = "GCSaturn";
    public static final String CHANNEL = "GCSaturn";
    public static final String CHANNELENTITIES = "GCSaturnEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftsaturn/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.saturn.client.ClientProxySaturn", serverSide = "mattparks.mods.starcraft.saturn.CommonProxySaturn")
    public static CommonProxySaturn proxy;

    @Instance(GCSaturn.MODID)
    public static GCSaturn instance;

    public static final String ASSET_DOMAIN = "starcraftsaturn";
    public static final String ASSET_PREFIX = GCSaturn.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

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

        GCLog.info("Starcraft Saturn Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCSaturn.instance, GCSaturn.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCSaturn.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCSaturnWorldProvider.class, new GCSaturnTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCSaturnPlanet());
        GalacticraftRegistry.registerRocketGui(GCSaturnWorldProvider.class, new ResourceLocation(GCSaturn.ASSET_DOMAIN, "textures/gui/saturnRocketGui.png"));
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCSaturn.proxy.postInit(event);
        GCSaturn.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCSaturnConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/saturn.conf"));

        GCSaturn.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
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
        NetworkRegistry.instance().registerChannel(new GCSaturnPacketHandlerServer(), GCSaturn.CHANNEL, Side.SERVER);
    }
}
