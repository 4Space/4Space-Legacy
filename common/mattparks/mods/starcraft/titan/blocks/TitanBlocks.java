package mattparks.mods.starcraft.titan.blocks;

import mattparks.mods.MattCore.Version;
import mattparks.mods.starcraft.moons.MoonsCore;
import mattparks.mods.starcraft.titan.CommonProxyTitan;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(name = TitanBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = TitanBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { TitanBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class TitanBlocks 
{
    public static final String NAME = "Titan Blocks";
    public static final String MODID = "TitanBlocks";
    public static final String CHANNEL = "TitanBlocks";
    public static final String CHANNELENTITIES = "TitanBlocksEntities";

    
 	public static final Block TitanSurfaceStone = new SCTitanSurfaceStone(795).setHardness(0.75F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("TitanSurfaceStone").setTextureName("starcrafttitan:titanSurfaceStone").setCreativeTab(MoonsCore.starcraftMoonsTab);

	public static final Block RockySolidWater = new SCBlock(796, null).setHardness(1.5F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("RockySolidWater").setTextureName("starcrafttitan:rockySolidWater").setCreativeTab(MoonsCore.starcraftMoonsTab);
	
 	public static final Block TitanStone = new SCBlock(797, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("TitanStone").setTextureName("starcrafttitan:titanStone").setCreativeTab(MoonsCore.starcraftMoonsTab);

	public static final Block TitanCobblestone = new SCBlock(798, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("TitanCobblestone").setTextureName("starcrafttitan:titanCobbletone").setCreativeTab(MoonsCore.starcraftMoonsTab);
	
	
        @Instance(value = "TitanBlocks")
        public static TitanBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.titan.client.ClientProxyTitan", serverSide = "mattparks.mods.starcraft.titan.CommonProxyTitan")
        public static CommonProxyTitan proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(TitanBlocks.TitanSurfaceStone, "TitanSurfaceStone");
                GameRegistry.registerBlock(TitanBlocks.RockySolidWater, "RockySolidWater");
                GameRegistry.registerBlock(TitanBlocks.TitanStone, "TitanStone");
                GameRegistry.registerBlock(TitanBlocks.TitanCobblestone, "TitanCobblestone");
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