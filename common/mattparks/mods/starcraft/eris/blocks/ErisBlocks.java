package mattparks.mods.starcraft.eris.blocks;

import mattparks.mods.MattCore.Version;
import mattparks.mods.starcraft.eris.CommonProxyEris;
import mattparks.mods.starcraft.eris.ErisCore;
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
 
@Mod(name = ErisBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = ErisBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { ErisBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class ErisBlocks 
{
    public static final String NAME = "Eris Blocks";
    public static final String MODID = "ErisBlocks";
    public static final String CHANNEL = "ErisBlocks";
    public static final String CHANNELENTITIES = "ErisBlocksEntities";

	// Block Eris Grass
	public static final Block ErisGrass = new SCErisGrass(922, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("grassEris")
			.setTextureName("starcrafteris:grassEris")
			.setCreativeTab(ErisCore.starcraftErisTab);

	// Block Pluto Dirt
	public static final Block ErisDirt = new SCBlock(923, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("dirtEris")
			.setTextureName("starcrafteris:dirtEris")
			.setCreativeTab(ErisCore.starcraftErisTab);

	// Block Eris Stone
	public static final Block ErisStone = new SCErisStone(924, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("stoneEris")
			.setTextureName("starcrafteris:stoneEris")
			.setCreativeTab(ErisCore.starcraftErisTab);

	// Block Eris Cobblestone
	public static final Block ErisCobblestone = new SCBlock(925, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("cobblestoneEris")
			.setTextureName("starcrafteris:cobblestoneEris")
			.setCreativeTab(ErisCore.starcraftErisTab);

	// Block Eris Brick
	public static final Block ErisBrick = new SCBlock(926, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("erisBrick")
			.setTextureName("starcrafteris:erisBrick")
			.setCreativeTab(ErisCore.starcraftErisTab)
			.setBlockUnbreakable();
	
	// Block Eris Coal Ore
	public static final Block ErisCoalOre = new SCErisOre(1930, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("ErisCoalOre")
			.setTextureName("starcrafteris:oreCoal")
			.setCreativeTab(ErisCore.starcraftErisTab);
			
	// Block Eris Green Gem Ore
	public static final Block ErisGreenGemOre = new SCErisOre(1931, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("ErisGreenGemOre")
			.setTextureName("starcrafteris:oreGreenGem")
			.setCreativeTab(ErisCore.starcraftErisTab);
			
	// Block Eris Iron Ore
	public static final Block ErisIronOre = new SCErisOre(1932, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("ErisIronOre")
			.setTextureName("starcrafteris:oreIron")
			.setCreativeTab(ErisCore.starcraftErisTab);
			
	// Block Eris Meteor Ore
	public static final Block ErisMeteorOre = new SCErisOre(1933, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("ErisMeteorOre")
			.setTextureName("starcrafteris:oreMeteor")
			.setCreativeTab(ErisCore.starcraftErisTab);
			
	// Block Eris Tin Ore
	public static final Block ErisTinOre = new SCErisOre(1934, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("ErisTinOre")
			.setTextureName("starcrafteris:oreTin")
			.setCreativeTab(ErisCore.starcraftErisTab);
	
	// Block Eris Green Gem Block
	public static final Block GreenGemBlock = new SCErisOre(1935, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("GreenGemBlock")
			.setTextureName("starcrafteris:greenGemBlock")
			.setCreativeTab(ErisCore.starcraftErisTab);
	
	
        @Instance(value = "ErisBlocks")
        public static ErisBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.eris.client.ClientProxyEris", serverSide = "mattparks.mods.starcraft.eris.CommonProxyEris")
        public static CommonProxyEris proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(ErisBlocks.ErisGrass, "ErisGrass");
                GameRegistry.registerBlock(ErisBlocks.ErisDirt, "ErisDirt");
                GameRegistry.registerBlock(ErisBlocks.ErisStone, "ErisStone");
                GameRegistry.registerBlock(ErisBlocks.ErisCobblestone, "ErisCobblestone");
                GameRegistry.registerBlock(ErisBlocks.ErisBrick, "ErisBrick");
                GameRegistry.registerBlock(ErisBlocks.ErisCoalOre, "ErisCoalOre");
                GameRegistry.registerBlock(ErisBlocks.ErisGreenGemOre, "ErisGreenGemOre");
                GameRegistry.registerBlock(ErisBlocks.ErisIronOre, "ErisIronOre");
                GameRegistry.registerBlock(ErisBlocks.ErisMeteorOre, "ErisMeteorOre");
				GameRegistry.registerBlock(ErisBlocks.ErisTinOre, "ErisTinOre");
				GameRegistry.registerBlock(ErisBlocks.GreenGemBlock, "GreenGemBlock");
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