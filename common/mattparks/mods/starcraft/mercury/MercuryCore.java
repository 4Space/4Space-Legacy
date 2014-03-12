package mattparks.mods.starcraft.mercury;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.Version;
import mattparks.mods.starcraft.mercury.blocks.MercuryBlocks;
import mattparks.mods.starcraft.mercury.dimension.SCMercuryTeleportType;
import mattparks.mods.starcraft.mercury.dimension.SCMercuryWorldProvider;
import mattparks.mods.starcraft.mercury.entities.SCMercuryEntityRocketT4;
import mattparks.mods.starcraft.mercury.items.MercuryItems;
import mattparks.mods.starcraft.mercury.network.SCMercuryPacketHandlerServer;
import mattparks.mods.starcraft.mercury.recipe.SCMercuryRecipeManager;
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

@Mod(name = MercuryCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = MercuryCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { MercuryCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class MercuryCore
{
    public static final String NAME = "Starcraft Mercury";
    public static final String MODID = "GCMercury";
    public static final String CHANNEL = "GCMercury";
    public static final String CHANNELENTITIES = "GCMercuryEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftmercury/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.mercury.client.ClientProxyMercury", serverSide = "mattparks.mods.starcraft.mercury.CommonProxyMercury")
    public static CommonProxyMercury proxy;

    @Instance(MercuryCore.MODID)
    public static MercuryCore instance;
    
	public static CreativeTabs starcraftMercuryTab = new CreativeTabs("starcraftMercuryTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(MercuryBlocks.BlueGlowstone, 1, 0);
		}
	};

    public static final String ASSET_DOMAIN = "starcraftmercury";
    public static final String ASSET_PREFIX = MercuryCore.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : MercuryCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(MercuryCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(MercuryCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        GCLog.info("Starcraft Mercury Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(MercuryCore.instance, MercuryCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        MercuryCore.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(SCMercuryWorldProvider.class, new SCMercuryTeleportType());
        GalacticraftRegistry.registerCelestialBody(new SCMercuryPlanet());
        GalacticraftRegistry.registerRocketGui(SCMercuryWorldProvider.class, new ResourceLocation(MercuryCore.ASSET_DOMAIN, "textures/gui/mercuryRocketGui.png"));
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        MercuryCore.proxy.postInit(event);
        MercuryCore.proxy.registerRenderInformation();
        
        SCMercuryRecipeManager.loadRecipes();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new SCMercuryConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/mercury.conf"));

        MercuryItems.initItems();

        MercuryCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, MercuryCore.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
    
    public void registerOtherEntities()
    {
    	this.registerGalacticraftNonMobEntity(SCMercuryEntityRocketT4.class, "SpaceshipT4", SCMercuryConfigManager.idEntitySpaceshipTier4, 150, 1, true);
    }

    public void registerTileEntities()
    {
    	;
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new SCMercuryPacketHandlerServer(), MercuryCore.CHANNEL, Side.SERVER);
    }
}
