package mattparks.mods.starcraft.neptune;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.neptune.dimension.GCNeptuneTeleportType;
import mattparks.mods.starcraft.neptune.dimension.GCNeptuneWorldProvider;
import mattparks.mods.starcraft.neptune.network.GCNeptunePacketHandlerServer;
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

@Mod(name = GCNeptune.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCNeptune.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCNeptune.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCNeptune
{
    public static final String NAME = "Starcraft Neptune";
    public static final String MODID = "GCNeptune";
    public static final String CHANNEL = "GCNeptune";
    public static final String CHANNELENTITIES = "GCNeptuneEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftneptune/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.neptune.client.ClientProxyNeptune", serverSide = "mattparks.mods.starcraft.neptune.CommonProxyNeptune")
    public static CommonProxyNeptune proxy;

    @Instance(GCNeptune.MODID)
    public static GCNeptune instance;

    public static final String ASSET_DOMAIN = "starcraftneptune";
    public static final String ASSET_PREFIX = GCNeptune.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCNeptuneConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/neptune.conf"));

        GCNeptune.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCNeptune.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCNeptune.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCNeptune.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Neptune Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCNeptune.instance, GCNeptune.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCNeptune.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCNeptuneWorldProvider.class, new GCNeptuneTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCNeptunePlanet());
        GalacticraftRegistry.registerRocketGui(GCNeptuneWorldProvider.class, new ResourceLocation(GCNeptune.ASSET_DOMAIN, "textures/gui/saturnRocketGui.png"));
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCNeptunePacketHandlerServer(), GCNeptune.CHANNEL, Side.SERVER);
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
        GCNeptune.proxy.postInit(event);
        GCNeptune.proxy.registerRenderInformation();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCNeptune.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
