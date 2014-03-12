package mattparks.mods.starcraft.saturn;

import java.util.HashMap;

import mattparks.mods.starcraft.Version;
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

@Mod(name = SaturnCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = SaturnCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { SaturnCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class SaturnCore
{
    public static final String NAME = "Starcraft Saturn";
    public static final String MODID = "SCSaturn";
    public static final String CHANNEL = "SCSaturn";
    public static final String CHANNELENTITIES = "SCSaturnEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftsaturn/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.saturn.client.ClientProxySaturn", serverSide = "mattparks.mods.starcraft.saturn.CommonProxySaturn")
    public static CommonProxySaturn proxy;

    @Instance(SaturnCore.MODID)
    public static SaturnCore instance;

    public static final String ASSET_DOMAIN = "starcraftsaturn";
    public static final String ASSET_PREFIX = SaturnCore.ASSET_DOMAIN + ":";

    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    public static SCSaturnPlanet saturn;
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : SaturnCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(SaturnCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(SaturnCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        NetworkRegistry.instance().registerGuiHandler(SaturnCore.instance, SaturnCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        SaturnCore.proxy.init(event);

        SaturnCore.saturn = new SCSaturnPlanet();
        GalacticraftRegistry.registerCelestialBody(SaturnCore.saturn);
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        SaturnCore.proxy.postInit(event);
        SaturnCore.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        SaturnCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, SaturnCore.instance, 80, 3, true);
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
