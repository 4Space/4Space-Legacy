package mattparks.mods.starcraft.core;

import mattparks.mods.starcraft.core.blocks.PlutoStone;
import mattparks.mods.starcraft.core.blocks.StarcraftBlock;
import mattparks.mods.starcraft.core.blocks.StarcraftGrass;
import mattparks.mods.starcraft.pluto.GCPluto;
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

@Mod(name = StarcraftPluto.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = StarcraftPluto.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { StarcraftPluto.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class StarcraftPluto 
{
    public static final String NAME = "Starcraft Pluto";
    public static final String MODID = "StarcraftPluto";
    public static final String CHANNEL = "StarcraftPluto";
    public static final String CHANNELENTITIES = "StarcraftPlutoEntities";


	// Block Pluto, Grass
	public static final Block PlutoGrass = new StarcraftGrass(910, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("grassPluto")
			.setTextureName("starcraftpluto:grassPluto")
			.setCreativeTab(GCPluto.starcraftPlutoTab);

	// Block Pluto, Dirt
	public static final Block PlutoDirt = new StarcraftBlock(911, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("dirtPluto")
			.setTextureName("starcraftpluto:dirtPluto")
			.setCreativeTab(GCPluto.starcraftPlutoTab);

	// Block Pluto, Stone
	public static final Block PlutoStone = new PlutoStone(912, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("stonePluto")
			.setTextureName("starcraftpluto:stonePluto")
			.setCreativeTab(GCPluto.starcraftPlutoTab);

	// Block Pluto, Cobblestone
	public static final Block PlutoCobblestone = new StarcraftBlock(913, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("cobblestonePluto")
			.setTextureName("starcraftpluto:cobblestonePluto")
			.setCreativeTab(GCPluto.starcraftPlutoTab);

	// Block Pluto, Brick
	public static final Block PlutoBrick = new StarcraftBlock(916, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("plutoBrick")
			.setTextureName("starcraftpluto:plutoBrick")
			.setCreativeTab(GCPluto.starcraftPlutoTab)
			.setBlockUnbreakable();
	
	// Block Pluto, Ununpetium Block
	public static final Block BlockUnunpetium = new StarcraftBlock(817, null)
			.setHardness(5.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("BlockUnunpetium")
			.setLightValue(0.7f)
			.setTextureName("starcraftpluto:BlockUnunpetium")
			.setCreativeTab(GCPluto.starcraftPlutoTab);
	
	// Block Pluto, Ununpetium Ore
	public static final Block UnunpentiumOre = new StarcraftBlock(818, null)
			.setHardness(5.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("UnunpentiumOre")
			.setTextureName("starcraftpluto:oreUnunpentium")
			.setCreativeTab(GCPluto.starcraftPlutoTab);
	
	// Block Pluto, Blue Gem Ore
	public static final Block BlueGemOre = new StarcraftBlock(819, null)
			.setHardness(5.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("BlueGemOre")
			.setTextureName("starcraftpluto:oreBlueGem")
			.setCreativeTab(GCPluto.starcraftPlutoTab);
	
	// Block Pluto, Frozen Iron Ore
	public static final Block FrozenIronOre = new StarcraftBlock(820, null)
			.setHardness(5.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("FrozenIronOre")
			.setTextureName("starcraftpluto:oreFrozenIron")
			.setCreativeTab(GCPluto.starcraftPlutoTab);
	
	// Block Pluto, Blue Gem Block
	public static final Block BlueGemBlock = new StarcraftBlock(821, null)
			.setHardness(5.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("BlockBlueGem")
			.setTextureName("starcraftpluto:blueGemBlock")
			.setCreativeTab(GCPluto.starcraftPlutoTab);
	
	// Block Pluto, Frozen Iron Block
	public static final Block FrozenIronBlock = new StarcraftBlock(822, null)
			.setHardness(5.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("FrozenIronBlock")
			.setTextureName("starcraftpluto:blockFrozenIron")
			.setCreativeTab(GCPluto.starcraftPlutoTab);
	
		
        @Instance(value = "StarcraftPluto")
        public static StarcraftPluto instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.core.client.ClientProxy", serverSide = "mattparks.mods.starcraft.core.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(StarcraftPluto.PlutoGrass, "PlutoGrass");
                GameRegistry.registerBlock(StarcraftPluto.PlutoDirt, "PlutoDirt");
                GameRegistry.registerBlock(StarcraftPluto.PlutoStone, "PlutoStone");
                GameRegistry.registerBlock(StarcraftPluto.PlutoCobblestone, "PlutoCobblestone");
                GameRegistry.registerBlock(StarcraftPluto.PlutoBrick, "PlutoBrick");
                GameRegistry.registerBlock(StarcraftPluto.BlockUnunpetium, "BlockUnunpetium");
                GameRegistry.registerBlock(StarcraftPluto.UnunpentiumOre, "UnunpentiumOre");
                GameRegistry.registerBlock(StarcraftPluto.BlueGemOre, "BlueGemOre");
                GameRegistry.registerBlock(StarcraftPluto.FrozenIronOre, "FrozenIronOre");
                GameRegistry.registerBlock(StarcraftPluto.BlueGemBlock, "BlueGemBlock");
                GameRegistry.registerBlock(StarcraftPluto.FrozenIronBlock, "FrozenIronBlock");
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