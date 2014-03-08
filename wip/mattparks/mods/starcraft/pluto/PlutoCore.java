package mattparks.mods.starcraft.pluto;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.Version;
import mattparks.mods.starcraft.pluto.blocks.PlutoBlocks;
import mattparks.mods.starcraft.pluto.dimension.SCPlutoTeleportType;
import mattparks.mods.starcraft.pluto.dimension.SCPlutoWorldProvider;
import mattparks.mods.starcraft.pluto.items.PlutoItems;
import mattparks.mods.starcraft.pluto.network.SCPlutoPacketHandlerServer;
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

@Mod(name = PlutoCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = PlutoCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { PlutoCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class PlutoCore
{
    public static final String NAME = "Starcraft Pluto";
    public static final String MODID = "SCPluto";
    public static final String CHANNEL = "SCPluto";
    public static final String CHANNELENTITIES = "SCPlutoEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftpluto/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.pluto.client.ClientProxyPluto", serverSide = "mattparks.mods.starcraft.pluto.CommonProxyPluto")
    public static CommonProxyPluto proxy;

    @Instance(PlutoCore.MODID)
    public static PlutoCore instance;

    public static final String ASSET_DOMAIN = "starcraftpluto";
    public static final String ASSET_PREFIX = PlutoCore.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
	public static CreativeTabs starcraftPlutoTab = new CreativeTabs("starcraftPlutoTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(PlutoBlocks.PlutoBrick, 1, 0);
		}
	};
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : PlutoCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(PlutoCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(PlutoCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        NetworkRegistry.instance().registerGuiHandler(PlutoCore.instance, PlutoCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        PlutoCore.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(SCPlutoWorldProvider.class, new SCPlutoTeleportType());
        GalacticraftRegistry.registerCelestialBody(new SCPlutoPlanet());
        GalacticraftRegistry.registerRocketGui(SCPlutoWorldProvider.class, new ResourceLocation(PlutoCore.ASSET_DOMAIN, "textures/gui/plutoRocketGui.png"));
        
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        PlutoCore.proxy.postInit(event);
        PlutoCore.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new SCPlutoConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/pluto.conf"));

        PlutoItems.initItems();

        PlutoCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, PlutoCore.instance, 80, 3, true);
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
        NetworkRegistry.instance().registerChannel(new SCPlutoPacketHandlerServer(), PlutoCore.CHANNEL, Side.SERVER);
    }
}
