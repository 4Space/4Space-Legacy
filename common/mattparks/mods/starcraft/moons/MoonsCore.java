package mattparks.mods.starcraft.moons;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.MattCore.Version;
import mattparks.mods.starcraft.moons.entities.SCJupiterEntityRocketT5;
import mattparks.mods.starcraft.moons.items.JupiterItems;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import net.minecraft.creativetab.CreativeTabs;
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

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
 
@Mod(name = MoonsCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = MoonsCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { MoonsCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class MoonsCore
{
    public static final String NAME = "Starcraft Moons";
    public static final String MODID = "GCMoons";
    public static final String CHANNEL = "GCMoons";
    public static final String CHANNELENTITIES = "GCMoonsEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftjupiter/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.moons.client.ClientProxyMoons", serverSide = "mattparks.mods.starcraft.moons.CommonProxyMoons")
    public static CommonProxyMoons proxy;

    @Instance(MoonsCore.MODID)
    public static MoonsCore instance;

    public static final String ASSET_DOMAIN = "starcraftjupiter";
    public static final String ASSET_PREFIX = MoonsCore.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
	public static CreativeTabs starcraftMoonsTab = new CreativeTabs("starcraftMoonsTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(JupiterItems.spaceshipT5, 1, 0);
		}
	};

    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : MoonsCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(MoonsCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(MoonsCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Moons Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(MoonsCore.instance, MoonsCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        MoonsCore.proxy.init(event);
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        MoonsCore.proxy.postInit(event);
        MoonsCore.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new SCJupiterConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/jupiter.conf"));

        JupiterItems.initItems();
        
        MoonsCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, MoonsCore.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
    
    public void registerOtherEntities()
    {
    	this.registerGalacticraftNonMobEntity(SCJupiterEntityRocketT5.class, "SpaceshipT5", SCJupiterConfigManager.idEntitySpaceshipTier5, 150, 1, true);
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
