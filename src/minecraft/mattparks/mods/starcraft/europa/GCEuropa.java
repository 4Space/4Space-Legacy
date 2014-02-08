package mattparks.mods.starcraft.europa;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.europa.dimension.GCEuropaTeleportType;
import mattparks.mods.starcraft.europa.dimension.GCEuropaWorldProvider;
import mattparks.mods.starcraft.europa.network.GCEuropaPacketHandlerServer;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GCLog;
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

@Mod(modid="StarcraftEuropa", name="StarcraftEuropa", version="0.0.1", dependencies = "required-after:GalacticraftCore;required-after:GCJupiter")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GCEuropa
{
    public static final String NAME = "Starcraft Europa";
    public static final String MODID = "GCEuropa";
    public static final String CHANNEL = "GCEuropa";
    public static final String CHANNELENTITIES = "GCEuropaEntities";

    public static final String LANGUAGE_PATH = "/assets/starcrafteuropa/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.europa.client.ClientProxyEuropa", serverSide = "mattparks.mods.starcraft.europa.CommonProxyEuropa")
    public static CommonProxyEuropa proxy;

    @Instance(GCEuropa.MODID)
    public static GCEuropa instance;

    public static final String ASSET_DOMAIN = "starcrafteuropa";
    public static final String ASSET_PREFIX = GCEuropa.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCEuropa.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCEuropa.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCEuropa.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Europa Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCEuropa.instance, GCEuropa.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCEuropa.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCEuropaWorldProvider.class, new GCEuropaTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCEuropaPlanet());
        GalacticraftRegistry.registerRocketGui(GCEuropaWorldProvider.class, new ResourceLocation(GCEuropa.ASSET_DOMAIN, "textures/gui/EuropaRocketGui.png"));
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCEuropa.proxy.postInit(event);
        GCEuropa.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCEuropaConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/europa.conf"));

        GCEuropa.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCEuropa.instance, 80, 3, true);
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
        NetworkRegistry.instance().registerChannel(new GCEuropaPacketHandlerServer(), GCEuropa.CHANNEL, Side.SERVER);
    }
}
