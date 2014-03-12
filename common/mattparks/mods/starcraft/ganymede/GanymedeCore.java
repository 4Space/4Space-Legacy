package mattparks.mods.starcraft.ganymede;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.Version;
import mattparks.mods.starcraft.ganymede.dimension.SCGanymedeTeleportType;
import mattparks.mods.starcraft.ganymede.dimension.SCGanymedeWorldProvider;
import mattparks.mods.starcraft.ganymede.network.SCGanymedePacketHandlerServer;
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

@Mod(name = GanymedeCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = GanymedeCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GanymedeCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GanymedeCore
{
    public static final String NAME = "Starcraft Ganymede";
    public static final String MODID = "GCGanymede";
    public static final String CHANNEL = "GCGanymede";
    public static final String CHANNELENTITIES = "GCGanymedeEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftGanymede/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.ganymede.client.ClientProxyGanymede", serverSide = "mattparks.mods.starcraft.ganymede.CommonProxyGanymede")
    public static CommonProxyGanymede proxy;

    @Instance(GanymedeCore.MODID)
    public static GanymedeCore instance;

    public static final String ASSET_DOMAIN = "starcraftganymede";
    public static final String ASSET_PREFIX = GanymedeCore.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GanymedeCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GanymedeCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GanymedeCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Ganymede Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GanymedeCore.instance, GanymedeCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GanymedeCore.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(SCGanymedeWorldProvider.class, new SCGanymedeTeleportType());
        GalacticraftRegistry.registerCelestialBody(new SCGanymedePlanet());
        GalacticraftRegistry.registerRocketGui(SCGanymedeWorldProvider.class, new ResourceLocation(GanymedeCore.ASSET_DOMAIN, "textures/gui/GanymedeRocketGui.png"));
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GanymedeCore.proxy.postInit(event);
        GanymedeCore.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new SCGanymedeConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/ganymede.conf"));

        GanymedeCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GanymedeCore.instance, 80, 3, true);
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
        NetworkRegistry.instance().registerChannel(new SCGanymedePacketHandlerServer(), GanymedeCore.CHANNEL, Side.SERVER);
    }
}
