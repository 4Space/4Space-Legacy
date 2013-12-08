package mattparks.mods.starcraft.pluto;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.core.StarcraftBlocks;
import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.pluto.dimension.GCPlutoTeleportType;
import mattparks.mods.starcraft.pluto.dimension.GCPlutoWorldProvider;
import mattparks.mods.starcraft.pluto.items.GCPlutoItems;
import mattparks.mods.starcraft.pluto.network.GCPlutoPacketHandlerServer;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import net.minecraft.creativetab.CreativeTabs;
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

@Mod(name = GCPluto.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCPluto.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCPluto.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCPluto
{
    public static final String NAME = "Starcraft Pluto";
    public static final String MODID = "GCPluto";
    public static final String CHANNEL = "GCPluto";
    public static final String CHANNELENTITIES = "GCPlutoEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftpluto/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.pluto.client.ClientProxyPluto", serverSide = "mattparks.mods.starcraft.pluto.CommonProxyPluto")
    public static CommonProxyPluto proxy;

    @Instance(GCPluto.MODID)
    public static GCPluto instance;

    public static final String ASSET_DOMAIN = "starcraftpluto";
    public static final String ASSET_PREFIX = GCPluto.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
	public static CreativeTabs starcraftPlutoTab = new CreativeTabs("starcraftPlutoTab") {
		public ItemStack getIconItemStack() {
			return new ItemStack(StarcraftBlocks.PlutoBrick, 1, 0);
		}
	};
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCPlutoConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/pluto.conf"));

        GCPlutoItems.initItems();

        GCPluto.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCPluto.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCPluto.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCPluto.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Pluto Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCPluto.instance, GCPluto.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCPluto.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCPlutoWorldProvider.class, new GCPlutoTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCPlutoPlanet());
        GalacticraftRegistry.registerRocketGui(GCPlutoWorldProvider.class, new ResourceLocation(GCPluto.ASSET_DOMAIN, "textures/gui/plutoRocketGui.png"));
        
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCPlutoPacketHandlerServer(), GCPluto.CHANNEL, Side.SERVER);
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
        GCPluto.proxy.postInit(event);
        GCPluto.proxy.registerRenderInformation();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCPluto.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
