package mattparks.mods.starcraft.vesta;

import mattparks.mods.starcraft.vesta.blocks.StarcraftBlock;
import mattparks.mods.starcraft.vesta.blocks.StarcraftGrass;
import mattparks.mods.starcraft.vesta.blocks.VestaStone;
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

@Mod(modid="StarcraftVestaBlocks", name="StarcraftVestaBlocks", version="0.0.1", dependencies = "required-after:GalacticraftCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GCVestaBlocks 
{
    public static final String NAME = "Starcraft Vesta Blocks";
    public static final String MODID = "StarcraftVestaBlocks";
    public static final String CHANNEL = "StarcraftVestaBlocks";
    public static final String CHANNELENTITIES = "StarcraftVestaBlocksEntities";

    
	// Block Vesta, Grass
	public static final Block VestaGrass = new StarcraftGrass(632, null)
			.setHardness(1.5F).setStepSound(Block.soundGrassFootstep)
			.setUnlocalizedName("VestaGrass")
			.setTextureName("starcraftvesta:VestaGrass")
			.setCreativeTab(GCVesta.starcraftVestaTab);

	// Block Vesta, Dirt
	public static final Block VestaDirt = new StarcraftBlock(633, null)
			.setHardness(0.4F).setStepSound(Block.soundGravelFootstep)
			.setUnlocalizedName("VestaDirt")
			.setTextureName("starcraftvesta:VestaDirt")
			.setCreativeTab(GCVesta.starcraftVestaTab);

	// Block Vesta, Stone
	public static final Block VestaStone = new VestaStone(634, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VestaStone")
			.setTextureName("starcraftvesta:VestaStone")
			.setCreativeTab(GCVesta.starcraftVestaTab);

	// Block Vesta, Brick
	public static final Block VestaBrick = new StarcraftBlock(635, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VestaBrick")
			.setTextureName("starcraftvesta:VestaBrick")
			.setCreativeTab(GCVesta.starcraftVestaTab)
			.setBlockUnbreakable();
	
        @Instance(value = "GCVestaBlocks")
        public static GCVestaBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.vesta.client.ClientProxyVesta", serverSide = "mattparks.mods.starcraft.vesta.CommonProxyVesta")
        public static CommonProxyVesta proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(GCVestaBlocks.VestaGrass, "VestaGrass");
                GameRegistry.registerBlock(GCVestaBlocks.VestaDirt, "VestaDirt");
                GameRegistry.registerBlock(GCVestaBlocks.VestaStone, "VestaStone");
                GameRegistry.registerBlock(GCVestaBlocks.VestaBrick, "VestaBrick");                    
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