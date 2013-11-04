package mattparks.mods.starcraft.eris;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.eris.dimension.GCErisTeleportType;
import mattparks.mods.starcraft.eris.dimension.GCErisWorldProvider;
import mattparks.mods.starcraft.eris.items.GCErisItems;
import mattparks.mods.starcraft.eris.network.GCErisPacketHandlerServer;
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

@Mod(name = GCEris.NAME, version = GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCEris.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCEris.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCEris
{
    public static final String NAME = "Starcraft Eris";
    public static final String MODID = "GCEris";
    public static final String CHANNEL = "GCEris";
    public static final String CHANNELENTITIES = "GCErisEntities";

    public static final String LANGUAGE_PATH = "/assets/starcrafteris/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" , "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.eris.client.ClientProxyEris", serverSide = "mattparks.mods.starcraft.eris.CommonProxyEris")
    public static CommonProxyEris proxy;

    @Instance(GCEris.MODID)
    public static GCEris instance;

    public static final String ASSET_DOMAIN = "starcrafteris";
    public static final String ASSET_PREFIX = GCEris.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCErisConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/eris.conf"));

        GCErisItems.initItems();

        GCEris.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCEris.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCEris.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCEris.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Eris Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCEris.instance, GCEris.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCEris.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCErisWorldProvider.class, new GCErisTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCErisPlanet());
        GalacticraftRegistry.registerRocketGui(GCErisWorldProvider.class, new ResourceLocation(GCEris.ASSET_DOMAIN, "textures/gui/erisRocketGui.png"));
        
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCErisPacketHandlerServer(), GCEris.CHANNEL, Side.SERVER);
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
        GCEris.proxy.postInit(event);
        GCEris.proxy.registerRenderInformation();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCEris.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
