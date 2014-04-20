package mattparks.mods.starcraft.uranus;

import java.util.HashMap;

import mattparks.mods.MattCore.Version;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
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
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(name = UranusCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = UranusCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { UranusCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class UranusCore
{
    public static final String NAME = "Starcraft Uranus";
    public static final String MODID = "GCUranus";
    public static final String CHANNEL = "GCUranus";
    public static final String CHANNELENTITIES = "GCUranusEntities";

    public static final String LANGUAGE_PATH = "/assets/starcrafturanus/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.uranus.client.ClientProxyUranus", serverSide = "mattparks.mods.starcraft.uranus.CommonProxyUranus")
    public static CommonProxyUranus proxy;

    @Instance(UranusCore.MODID)
    public static UranusCore instance;

    public static final String ASSET_DOMAIN = "starcrafturanus";
    public static final String ASSET_PREFIX = UranusCore.ASSET_DOMAIN + ":";

    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    public static SCUranusPlanet uranus;
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : UranusCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(UranusCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(UranusCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Uranus Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(UranusCore.instance, UranusCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        UranusCore.proxy.init(event);

        UranusCore.uranus = new SCUranusPlanet();
        GalacticraftRegistry.registerCelestialBody(UranusCore.uranus);
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        UranusCore.proxy.postInit(event);
        UranusCore.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        UranusCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, UranusCore.instance, 80, 3, true);
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
    		;
    }
}
