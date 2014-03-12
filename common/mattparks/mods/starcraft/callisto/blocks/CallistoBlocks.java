package mattparks.mods.starcraft.callisto.blocks;

import mattparks.mods.starcraft.Version;
import mattparks.mods.starcraft.callisto.CommonProxyCallisto;
import mattparks.mods.starcraft.europa.CommonProxyEuropa;
import mattparks.mods.starcraft.moons.MoonsCore;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(name = CallistoBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = CallistoBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { CallistoBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class CallistoBlocks 
{
    public static final String NAME = "Callisto Blocks";
    public static final String MODID = "CallistoBlocks";
    public static final String CHANNEL = "CallistoBlocks";
    public static final String CHANNELENTITIES = "CallistoBlocksEntities";

    
 	public static final Block CallistoSurfaceStone = new SCBlock(875, null).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("CallistoSurfaceStone").setTextureName("starcraftcallisto:callistoSurfaceStone").setCreativeTab(MoonsCore.starcraftMoonsTab);

	public static final Block CallistoSubStone = new SCBlock(876, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("CallistoSubStone").setTextureName("starcraftcallisto:callistoSubStone").setCreativeTab(MoonsCore.starcraftMoonsTab);
	
 	public static final Block CallistoStone = new SCBlock(877, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("CallistoStone").setTextureName("starcraftcallisto:callistoStone").setCreativeTab(MoonsCore.starcraftMoonsTab);

	public static final Block CallistoCobblestone = new SCBlock(878, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("CallistoCobblestone").setTextureName("starcraftcallisto:callistoCobbletone").setCreativeTab(MoonsCore.starcraftMoonsTab);
	
	
        @Instance(value = "CallistoBlocks")
        public static CallistoBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.callisto.client.ClientProxyCallisto", serverSide = "mattparks.mods.starcraft.callisto.CommonProxyCallisto")
        public static CommonProxyCallisto proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(CallistoBlocks.CallistoSurfaceStone, "CallistoSurfaceStone");
                GameRegistry.registerBlock(CallistoBlocks.CallistoSubStone, "CallistoSubStone");
                GameRegistry.registerBlock(CallistoBlocks.CallistoStone, "CallistoStone");
                GameRegistry.registerBlock(CallistoBlocks.CallistoCobblestone, "CallistoCobblestone");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        }
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
        	;
        }
}