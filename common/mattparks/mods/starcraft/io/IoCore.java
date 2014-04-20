package mattparks.mods.starcraft.io;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.MattCore.Version;
import mattparks.mods.starcraft.io.dimension.SCIoTeleportType;
import mattparks.mods.starcraft.io.dimension.SCIoWorldProvider;
import mattparks.mods.starcraft.io.network.SCIoPacketHandlerServer;
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

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod(name = IoCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = IoCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { IoCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class IoCore
{
    public static final String NAME = "Starcraft Io";
    public static final String MODID = "GCIo";
    public static final String CHANNEL = "GCIo";
    public static final String CHANNELENTITIES = "GCIoEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftIo/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.io.client.ClientProxyIo", serverSide = "mattparks.mods.starcraft.io.CommonProxyIo")
    public static CommonProxyIo proxy;

    @Instance(IoCore.MODID)
    public static IoCore instance;

    public static final String ASSET_DOMAIN = "starcraftio";
    public static final String ASSET_PREFIX = IoCore.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : IoCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(IoCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(IoCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Io Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(IoCore.instance, IoCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        IoCore.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(SCIoWorldProvider.class, new SCIoTeleportType());
        GalacticraftRegistry.registerCelestialBody(new SCIoPlanet());
        GalacticraftRegistry.registerRocketGui(SCIoWorldProvider.class, new ResourceLocation(IoCore.ASSET_DOMAIN, "textures/gui/IoRocketGui.png"));
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        IoCore.proxy.postInit(event);
        IoCore.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new SCIoConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/io.conf"));

        IoCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, IoCore.instance, 80, 3, true);
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
        NetworkRegistry.instance().registerChannel(new SCIoPacketHandlerServer(), IoCore.CHANNEL, Side.SERVER);
    }
}
