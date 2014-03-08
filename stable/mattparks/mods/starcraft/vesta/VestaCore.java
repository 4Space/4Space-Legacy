package mattparks.mods.starcraft.vesta;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.Version;
import mattparks.mods.starcraft.vesta.blocks.VestaBlocks;
import mattparks.mods.starcraft.vesta.dimension.SCVestaTeleportType;
import mattparks.mods.starcraft.vesta.dimension.SCVestaWorldProvider;
import mattparks.mods.starcraft.vesta.network.SCVestaPacketHandlerServer;
import mattparks.mods.starcraft.vesta.recipe.SCVestaRecipeManager;
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

@Mod(name = VestaCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = VestaCore.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { VestaCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class VestaCore
{
    public static final String NAME = "Starcraft Vesta";
    public static final String MODID = "GCVesta";
    public static final String CHANNEL = "GCVesta";
    public static final String CHANNELENTITIES = "GCVestaEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftvesta/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.vesta.client.ClientProxyVesta", serverSide = "mattparks.mods.starcraft.vesta.CommonProxyVesta")
    public static CommonProxyVesta proxy;

    @Instance(VestaCore.MODID)
    public static VestaCore instance;

    public static final String ASSET_DOMAIN = "starcraftvesta";
    public static final String ASSET_PREFIX = VestaCore.ASSET_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
	public static CreativeTabs starcraftVestaTab = new CreativeTabs("starcraftVestaTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(VestaBlocks.VestaDirt, 1, 0);
		}
	};
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : VestaCore.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(VestaCore.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(VestaCore.LANGUAGE_PATH + language + ".lang", child, false);
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

        NetworkRegistry.instance().registerGuiHandler(VestaCore.instance, VestaCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        VestaCore.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(SCVestaWorldProvider.class, new SCVestaTeleportType());
        GalacticraftRegistry.registerCelestialBody(new SCVestaPlanet());
        GalacticraftRegistry.registerRocketGui(SCVestaWorldProvider.class, new ResourceLocation(VestaCore.ASSET_DOMAIN, "textures/gui/vestaRocketGui.png"));
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        VestaCore.proxy.postInit(event);
        VestaCore.proxy.registerRenderInformation();
        
        SCVestaRecipeManager.loadRecipes();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new SCVestaConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/saturn.conf"));

        VestaCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, VestaCore.instance, 80, 3, true);
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
        NetworkRegistry.instance().registerChannel(new SCVestaPacketHandlerServer(), VestaCore.CHANNEL, Side.SERVER);
    }
}
