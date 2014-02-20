package mattparks.mods.starcraft.makemake.blocks;

import mattparks.mods.starcraft.Version;
import mattparks.mods.starcraft.makemake.CommonProxyMakemake;
import mattparks.mods.starcraft.makemake.MakemakeCore;
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

@Mod(name = MakemakeBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = MakemakeBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { MakemakeBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class MakemakeBlocks 
{
    public static final String NAME = "Makemake Blocks";
    public static final String MODID = "MakemakeBlocks";
    public static final String CHANNEL = "MakemakeBlocks";
    public static final String CHANNELENTITIES = "MakemakeBlocksEntities";

    
	// Block Vesta, Grass
	public static final Block MakemakeGrass = new SCMakemakeGrass(736, null)
			.setHardness(1.5F).setStepSound(Block.soundGrassFootstep)
			.setUnlocalizedName("MakemakeGrass")
			.setTextureName("starcraftmakemake:MakemakeGrass")
			.setCreativeTab(MakemakeCore.starcraftMakemakeTab);

	// Block Vesta, Dirt
	public static final Block MakemakeDirt = new SCBlock(737, null)
			.setHardness(0.4F).setStepSound(Block.soundGravelFootstep)
			.setUnlocalizedName("MakemakeDirt")
			.setTextureName("starcraftmakemake:MakemakeDirt")
			.setCreativeTab(MakemakeCore.starcraftMakemakeTab);

	// Block Vesta, Stone
	public static final Block MakemakeStone = new MakemakeStone(738, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MakemakeStone")
			.setTextureName("starcraftmakemake:MakemakeStone")
			.setCreativeTab(MakemakeCore.starcraftMakemakeTab);

	// Block Vesta, Brick
	public static final Block MakemakeBrick = new SCBlock(739, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MakemakeBrick")
			.setTextureName("starcraftmakemake:MakemakeBrick")
			.setCreativeTab(MakemakeCore.starcraftMakemakeTab)
			.setBlockUnbreakable();
	
        @Instance(value = "MakemakeBlocks")
        public static MakemakeBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.makemake.client.ClientProxyMakemake", serverSide = "mattparks.mods.starcraft.makemake.CommonProxyMakemake")
        public static CommonProxyMakemake proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(MakemakeBlocks.MakemakeGrass, "MakemakeGrass");
                GameRegistry.registerBlock(MakemakeBlocks.MakemakeDirt, "MakemakeDirt");
                GameRegistry.registerBlock(MakemakeBlocks.MakemakeStone, "MakemakeStone");
                GameRegistry.registerBlock(MakemakeBlocks.MakemakeBrick, "MakemakeBrick");                    
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