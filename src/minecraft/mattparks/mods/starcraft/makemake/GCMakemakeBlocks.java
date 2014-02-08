package mattparks.mods.starcraft.makemake;

import mattparks.mods.starcraft.makemake.blocks.MakemakeStone;
import mattparks.mods.starcraft.makemake.blocks.StarcraftBlock;
import mattparks.mods.starcraft.makemake.blocks.StarcraftGrass;
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

@Mod(modid="StarcraftMakemakeBlocks", name="StarcraftMakemakeBlocks", version="0.0.1", dependencies = "required-after:GalacticraftCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GCMakemakeBlocks 
{
    public static final String NAME = "Starcraft Makemake Blocks";
    public static final String MODID = "StarcraftMakemakeBlocks";
    public static final String CHANNEL = "StarcraftMakemakeBlocks";
    public static final String CHANNELENTITIES = "StarcraftMakemakeBlocksEntities";

    
	// Block Vesta, Grass
	public static final Block MakemakeGrass = new StarcraftGrass(736, null)
			.setHardness(1.5F).setStepSound(Block.soundGrassFootstep)
			.setUnlocalizedName("MakemakeGrass")
			.setTextureName("starcraftmakemake:MakemakeGrass")
			.setCreativeTab(GCMakemake.starcraftMakemakeTab);

	// Block Vesta, Dirt
	public static final Block MakemakeDirt = new StarcraftBlock(737, null)
			.setHardness(0.4F).setStepSound(Block.soundGravelFootstep)
			.setUnlocalizedName("MakemakeDirt")
			.setTextureName("starcraftmakemake:MakemakeDirt")
			.setCreativeTab(GCMakemake.starcraftMakemakeTab);

	// Block Vesta, Stone
	public static final Block MakemakeStone = new MakemakeStone(738, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MakemakeStone")
			.setTextureName("starcraftmakemake:MakemakeStone")
			.setCreativeTab(GCMakemake.starcraftMakemakeTab);

	// Block Vesta, Brick
	public static final Block MakemakeBrick = new StarcraftBlock(739, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MakemakeBrick")
			.setTextureName("starcraftmakemake:MakemakeBrick")
			.setCreativeTab(GCMakemake.starcraftMakemakeTab)
			.setBlockUnbreakable();
	
        @Instance(value = "GCMakemakeBlocks")
        public static GCMakemakeBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.makemake.client.ClientProxyMakemake", serverSide = "mattparks.mods.starcraft.makemake.CommonProxyMakemake")
        public static CommonProxyMakemake proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(GCMakemakeBlocks.MakemakeGrass, "MakemakeGrass");
                GameRegistry.registerBlock(GCMakemakeBlocks.MakemakeDirt, "MakemakeDirt");
                GameRegistry.registerBlock(GCMakemakeBlocks.MakemakeStone, "MakemakeStone");
                GameRegistry.registerBlock(GCMakemakeBlocks.MakemakeBrick, "MakemakeBrick");                    
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