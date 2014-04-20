package mattparks.mods.starcraft.pluto.blocks;

import mattparks.mods.MattCore.Version;
import mattparks.mods.starcraft.pluto.CommonProxyPluto;
import mattparks.mods.starcraft.pluto.PlutoCore;
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

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod(name = PlutoBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = PlutoBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { PlutoBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class PlutoBlocks 
{
    public static final String NAME = "Pluto Blocks";
    public static final String MODID = "PlutoBlocks";
    public static final String CHANNEL = "PlutoBlocks";
    public static final String CHANNELENTITIES = "PlutoBlocksEntities";


	// Block Pluto, Grass
	public static final Block PlutoGrass = new SCPlutoGrass(910, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("grassPluto")
			.setTextureName("starcraftpluto:grassPluto")
			.setCreativeTab(PlutoCore.starcraftPlutoTab);

	// Block Pluto, Dirt
	public static final Block PlutoDirt = new SCBlock(911, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("dirtPluto")
			.setTextureName("starcraftpluto:dirtPluto")
			.setCreativeTab(PlutoCore.starcraftPlutoTab);

	// Block Pluto, Stone
	public static final Block PlutoStone = new SCPlutoStone(912, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("stonePluto")
			.setTextureName("starcraftpluto:stonePluto")
			.setCreativeTab(PlutoCore.starcraftPlutoTab);

	// Block Pluto, Cobblestone
	public static final Block PlutoCobblestone = new SCBlock(913, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("cobblestonePluto")
			.setTextureName("starcraftpluto:cobblestonePluto")
			.setCreativeTab(PlutoCore.starcraftPlutoTab);

	// Block Pluto, Brick
	public static final Block PlutoBrick = new SCBlock(916, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("plutoBrick")
			.setTextureName("starcraftpluto:plutoBrick")
			.setCreativeTab(PlutoCore.starcraftPlutoTab)
			.setBlockUnbreakable();
	
	// Block Pluto, Ununpetium Block
	public static final Block BlockUnunpetium = new SCBlock(817, null)
			.setHardness(5.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("BlockUnunpetium")
			.setLightValue(0.7f)
			.setTextureName("starcraftpluto:BlockUnunpetium")
			.setCreativeTab(PlutoCore.starcraftPlutoTab);
	
	// Block Pluto, Ununpetium Ore
	public static final Block UnunpentiumOre = new SCBlock(818, null)
			.setHardness(5.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("UnunpentiumOre")
			.setTextureName("starcraftpluto:oreUnunpentium")
			.setCreativeTab(PlutoCore.starcraftPlutoTab);
	
	// Block Pluto, Blue Gem Ore
	public static final Block BlueGemOre = new SCBlock(819, null)
			.setHardness(5.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("BlueGemOre")
			.setTextureName("starcraftpluto:oreBlueGem")
			.setCreativeTab(PlutoCore.starcraftPlutoTab);
	
	// Block Pluto, Frozen Iron Ore
	public static final Block FrozenIronOre = new SCBlock(820, null)
			.setHardness(5.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("FrozenIronOre")
			.setTextureName("starcraftpluto:oreFrozenIron")
			.setCreativeTab(PlutoCore.starcraftPlutoTab);
	
	// Block Pluto, Blue Gem Block
	public static final Block BlueGemBlock = new SCBlock(821, null)
			.setHardness(5.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("BlockBlueGem")
			.setTextureName("starcraftpluto:blueGemBlock")
			.setCreativeTab(PlutoCore.starcraftPlutoTab);
	
	// Block Pluto, Frozen Iron Block
	public static final Block FrozenIronBlock = new SCBlock(822, null)
			.setHardness(5.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("FrozenIronBlock")
			.setTextureName("starcraftpluto:blockFrozenIron")
			.setCreativeTab(PlutoCore.starcraftPlutoTab);
	
		
        @Instance(value = "PlutoBlocks")
        public static PlutoBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.pluto.client.ClientProxyPluto", serverSide = "mattparks.mods.starcraft.pluto.CommonProxyPluto")
        public static CommonProxyPluto proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(PlutoBlocks.PlutoGrass, "PlutoGrass");
                GameRegistry.registerBlock(PlutoBlocks.PlutoDirt, "PlutoDirt");
                GameRegistry.registerBlock(PlutoBlocks.PlutoStone, "PlutoStone");
                GameRegistry.registerBlock(PlutoBlocks.PlutoCobblestone, "PlutoCobblestone");
                GameRegistry.registerBlock(PlutoBlocks.PlutoBrick, "PlutoBrick");
                GameRegistry.registerBlock(PlutoBlocks.BlockUnunpetium, "BlockUnunpetium");
                GameRegistry.registerBlock(PlutoBlocks.UnunpentiumOre, "UnunpentiumOre");
                GameRegistry.registerBlock(PlutoBlocks.BlueGemOre, "BlueGemOre");
                GameRegistry.registerBlock(PlutoBlocks.FrozenIronOre, "FrozenIronOre");
                GameRegistry.registerBlock(PlutoBlocks.BlueGemBlock, "BlueGemBlock");
                GameRegistry.registerBlock(PlutoBlocks.FrozenIronBlock, "FrozenIronBlock");
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