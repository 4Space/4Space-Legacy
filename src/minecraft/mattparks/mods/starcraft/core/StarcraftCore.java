package mattparks.mods.starcraft.core;

import java.util.HashMap;

import mattparks.mods.starcraft.core.network.GCCorePacketHandlerServer;
import mattparks.mods.starcraft.core.network.GCCoreConnectionHandler;
import mattparks.mods.starcraft.core.network.GCCorePacketManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
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
import cpw.mods.fml.relauncher.Side;

@Mod(name = StarcraftCore.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = StarcraftCore.MODID, dependencies = "required-after:Forge@[9.10.0.837,); after:ICBM|Explosion; after:IC2; after:BuildCraft|Core; after:BuildCraft|Energy; after:IC2")
@NetworkMod(channels = { StarcraftCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class StarcraftCore
{
    public static final String NAME = "Starcraft Core";
    public static final String MODID = "StarcraftCore";
    public static final String CHANNEL = "GCStarcraftCore";
    public static final String CHANNELENTITIES = "SCCoreEntities";

    public static final int LOCALMAJVERSION = 0;
    public static final int LOCALMINVERSION = 0;
    public static final int LOCALBUILDVERSION = 4;
    public static int remoteMajVer;
    public static int remoteMinVer;
    public static int remoteBuildVer;
    
    @SidedProxy(clientSide = "mattparks.mods.starcraft.core.client.ClientProxy", serverSide = "mattparks.mods.starcraft.core.CommonProxy")
    public static CommonProxy proxy;

    @Instance(StarcraftCore.MODID)
    public static StarcraftCore instance;

    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        NetworkRegistry.instance().registerGuiHandler(StarcraftCore.instance, StarcraftCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        StarcraftCore.proxy.init(event);  
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        StarcraftCore.proxy.postInit(event);
        StarcraftCore.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
 //       new StarcraftCoreConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/core.conf"));

        StarcraftCore.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, StarcraftCore.instance, 80, 3, true);
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
        NetworkRegistry.instance().registerChannel(new GCCorePacketHandlerServer(), StarcraftCore.CHANNEL, Side.SERVER);
    }
}
