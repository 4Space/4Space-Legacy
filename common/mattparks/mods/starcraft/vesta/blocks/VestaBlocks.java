package mattparks.mods.starcraft.vesta.blocks;

import mattparks.mods.MattCore.Version;
import mattparks.mods.starcraft.vesta.CommonProxyVesta;
import mattparks.mods.starcraft.vesta.VestaCore;
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

@Mod(name = VestaBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = VestaBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { VestaBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class VestaBlocks 
{
    public static final String NAME = "Vesta Blocks";
    public static final String MODID = "VestaBlocks";
    public static final String CHANNEL = "VestaBlocks";
    public static final String CHANNELENTITIES = "VestaBlocksEntities";

    
	// Block Vesta, Grass
	public static final Block VestaGrass = new SCVestaGrass(632, null)
			.setHardness(1.5F).setStepSound(Block.soundGrassFootstep)
			.setUnlocalizedName("VestaGrass")
			.setTextureName("starcraftvesta:VestaGrass")
			.setCreativeTab(VestaCore.starcraftVestaTab);

	// Block Vesta, Dirt
	public static final Block VestaDirt = new SCBlock(633, null)
			.setHardness(0.4F).setStepSound(Block.soundGravelFootstep)
			.setUnlocalizedName("VestaDirt")
			.setTextureName("starcraftvesta:VestaDirt")
			.setCreativeTab(VestaCore.starcraftVestaTab);

	// Block Vesta, Stone
	public static final Block VestaStone = new SCVestaStone(634, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VestaStone")
			.setTextureName("starcraftvesta:VestaStone")
			.setCreativeTab(VestaCore.starcraftVestaTab);

	// Block Vesta, Brick
	public static final Block VestaBrick = new SCBlock(635, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VestaBrick")
			.setTextureName("starcraftvesta:VestaBrick")
			.setCreativeTab(VestaCore.starcraftVestaTab)
			.setBlockUnbreakable();
	
        @Instance(value = "VestaBlocks")
        public static VestaBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.vesta.client.ClientProxyVesta", serverSide = "mattparks.mods.starcraft.vesta.CommonProxyVesta")
        public static CommonProxyVesta proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(VestaBlocks.VestaGrass, "VestaGrass");
                GameRegistry.registerBlock(VestaBlocks.VestaDirt, "VestaDirt");
                GameRegistry.registerBlock(VestaBlocks.VestaStone, "VestaStone");
                GameRegistry.registerBlock(VestaBlocks.VestaBrick, "VestaBrick");                    
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