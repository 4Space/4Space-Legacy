package mattparks.mods.starcraft.core;

import mattparks.mods.starcraft.core.blocks.PlutoStone;
import mattparks.mods.starcraft.core.blocks.StarcraftBlock;
import mattparks.mods.starcraft.core.blocks.StarcraftGrass;
import mattparks.mods.starcraft.core.blocks.StarcraftOre;
import mattparks.mods.starcraft.eris.GCEris;
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

@Mod(name = StarcraftEris.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = StarcraftEris.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { StarcraftEris.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class StarcraftEris 
{
    public static final String NAME = "Starcraft Eris";
    public static final String MODID = "StarcraftEris";
    public static final String CHANNEL = "StarcraftBlocks";
    public static final String CHANNELENTITIES = "StarcraftErisEntities";

	// Block Eris Grass
	public static final Block ErisGrass = new StarcraftGrass(922, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("grassEris")
			.setTextureName("starcrafteris:grassEris")
			.setCreativeTab(GCEris.starcraftErisTab);

	// Block Pluto Dirt
	public static final Block ErisDirt = new StarcraftBlock(923, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("dirtEris")
			.setTextureName("starcrafteris:dirtEris")
			.setCreativeTab(GCEris.starcraftErisTab);

	// Block Eris Stone
	public static final Block ErisStone = new PlutoStone(924, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("stoneEris")
			.setTextureName("starcrafteris:stoneEris")
			.setCreativeTab(GCEris.starcraftErisTab);

	// Block Eris Cobblestone
	public static final Block ErisCobblestone = new StarcraftBlock(925, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("cobblestoneEris")
			.setTextureName("starcrafteris:cobblestoneEris")
			.setCreativeTab(GCEris.starcraftErisTab);

	// Block Eris Brick
	public static final Block ErisBrick = new StarcraftBlock(926, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("erisBrick")
			.setTextureName("starcrafteris:erisBrick")
			.setCreativeTab(GCEris.starcraftErisTab)
			.setBlockUnbreakable();
	
	// Block Eris Coal Ore
	public static final Block ErisCoalOre = new StarcraftOre(1930, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("ErisCoalOre")
			.setTextureName("starcrafteris:oreCoal")
			.setCreativeTab(GCEris.starcraftErisTab);
			
	// Block Eris Green Gem Ore
	public static final Block ErisGreenGemOre = new StarcraftOre(1931, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("ErisGreenGemOre")
			.setTextureName("starcrafteris:oreGreenGem")
			.setCreativeTab(GCEris.starcraftErisTab);
			
	// Block Eris Iron Ore
	public static final Block ErisIronOre = new StarcraftOre(1932, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("ErisIronOre")
			.setTextureName("starcrafteris:oreIron")
			.setCreativeTab(GCEris.starcraftErisTab);
			
	// Block Eris Meteor Ore
	public static final Block ErisMeteorOre = new StarcraftOre(1933, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("ErisMeteorOre")
			.setTextureName("starcrafteris:oreMeteor")
			.setCreativeTab(GCEris.starcraftErisTab);
			
	// Block Eris Tin Ore
	public static final Block ErisTinOre = new StarcraftOre(1934, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("ErisTinOre")
			.setTextureName("starcrafteris:oreTin")
			.setCreativeTab(GCEris.starcraftErisTab);
	
	// Block Eris Green Gem Block
	public static final Block GreenGemBlock = new StarcraftOre(1935, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("GreenGemBlock")
			.setTextureName("starcrafteris:greenGemBlock")
			.setCreativeTab(GCEris.starcraftErisTab);
	
	
        @Instance(value = "StarcraftEris")
        public static StarcraftEris instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.core.client.ClientProxy", serverSide = "mattparks.mods.starcraft.core.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
        	;
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(StarcraftEris.ErisGrass, "ErisGrass");
                GameRegistry.registerBlock(StarcraftEris.ErisDirt, "ErisDirt");
                GameRegistry.registerBlock(StarcraftEris.ErisStone, "ErisStone");
                GameRegistry.registerBlock(StarcraftEris.ErisCobblestone, "ErisCobblestone");
                GameRegistry.registerBlock(StarcraftEris.ErisBrick, "ErisBrick");
                GameRegistry.registerBlock(StarcraftEris.ErisCoalOre, "ErisCoalOre");
                GameRegistry.registerBlock(StarcraftEris.ErisGreenGemOre, "ErisGreenGemOre");
                GameRegistry.registerBlock(StarcraftEris.ErisIronOre, "ErisIronOre");
                GameRegistry.registerBlock(StarcraftEris.ErisMeteorOre, "ErisMeteorOre");
				GameRegistry.registerBlock(StarcraftEris.ErisTinOre, "ErisTinOre");
				GameRegistry.registerBlock(StarcraftEris.GreenGemBlock, "GreenGemBlock");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        }
}