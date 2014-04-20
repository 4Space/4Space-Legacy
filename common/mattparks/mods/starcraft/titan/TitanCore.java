package mattparks.mods.starcraft.titan;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.MattCore.Version;
import mattparks.mods.starcraft.titan.dimension.SCTitanTeleportType;
import mattparks.mods.starcraft.titan.dimension.SCTitanWorldProvider;
import mattparks.mods.starcraft.titan.network.SCTitanPacketHandlerServer;
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

@Mod(name = TitanCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = TitanCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { TitanCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class TitanCore
{
    public static final String NAME = "Starcraft Titan";
    public static final String MODID = "GCTitan";
    public static final String CHANNEL = "GCTitan";
    public static final String CHANNELENTITIES = "GCTitanEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftTitan/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.titan.client.ClientProxyTitan", serverSide = "mattparks.mods.starcraft.titan.CommonProxyTitan")
    public static CommonProxyTitan proxy;

    @Instance(TitanCore.MODID)
    public static TitanCore instance;

    public static final String ASSET_DOMAIN = "starcrafttitan";
    public static final String ASSET_PREFIX = TitanCore.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : TitanCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(TitanCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(TitanCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Titan Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(TitanCore.instance, TitanCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        TitanCore.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(SCTitanWorldProvider.class, new SCTitanTeleportType());
        GalacticraftRegistry.registerCelestialBody(new SCTitanPlanet());
        GalacticraftRegistry.registerRocketGui(SCTitanWorldProvider.class, new ResourceLocation(TitanCore.ASSET_DOMAIN, "textures/gui/TitanRocketGui.png"));
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        TitanCore.proxy.postInit(event);
        TitanCore.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new SCTitanConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/titan.conf"));

        TitanCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, TitanCore.instance, 80, 3, true);
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
        NetworkRegistry.instance().registerChannel(new SCTitanPacketHandlerServer(), TitanCore.CHANNEL, Side.SERVER);
    }
}
