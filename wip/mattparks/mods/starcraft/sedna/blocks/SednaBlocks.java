package mattparks.mods.starcraft.sedna.blocks;

import mattparks.mods.starcraft.Version;
import mattparks.mods.starcraft.sedna.CommonProxySedna;
import mattparks.mods.starcraft.sedna.SednaCore;
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

@Mod(name = SednaBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = SednaBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { SednaBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class SednaBlocks 
{
    public static final String NAME = "Sedna Blocks";
    public static final String MODID = "SednaBlocks";
    public static final String CHANNEL = "SednaBlocks";
    public static final String CHANNELENTITIES = "SednaBlocksEntities";

    
	// Block Sedna Grass
	public static final Block SednaGrass = new SCSednaGrass(781, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("grassSedna")
			.setTextureName("starcraftsedna:grassSedna")
			.setCreativeTab(SednaCore.starcraftSednaTab);

	// Block Sedna Dirt
	public static final Block SednaDirt = new SCBlock(782, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("dirtSedna")
			.setTextureName("starcraftsedna:dirtSedna")
			.setCreativeTab(SednaCore.starcraftSednaTab);

	// Block Sedna Stone
	public static final Block SednaStone = new SCSednaStone(783, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("stoneSedna")
			.setTextureName("starcraftsedna:stoneSedna")
			.setCreativeTab(SednaCore.starcraftSednaTab);

	// Block Sedna Cobblestone
	public static final Block SednaCobblestone = new SCBlock(784, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("cobblestoneSedna")
			.setTextureName("starcraftsedna:cobblestoneSedna")
			.setCreativeTab(SednaCore.starcraftSednaTab);

	// Block Sedna Brick
	public static final Block SednaBrick = new SCBlock(785, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("sednaBrick")
			.setTextureName("starcraftsedna:sednaBrick")
			.setCreativeTab(SednaCore.starcraftSednaTab)
			.setBlockUnbreakable();
	
	// Block Sedna Ore Palladium
	public static final Block PalladiumOre = new SCSednaOre(786, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("PalladiumOre")
			.setTextureName("starcraftsedna:orePalladium")
			.setCreativeTab(SednaCore.starcraftSednaTab);
	
	// Block Sedna Palladium Block
	public static final Block PalladiumBlock = new SCBlock(787, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("PalladiumBlock")
			.setTextureName("starcraftsedna:palladiumBlock")
			.setCreativeTab(SednaCore.starcraftSednaTab);

        @Instance(value = "SednaBlocks")
        public static SednaBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.sedna.client.ClientProxySedna", serverSide = "mattparks.mods.starcraft.sedna.CommonProxySedna")
        public static CommonProxySedna proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(SednaBlocks.SednaGrass, "SednaGrass");
                GameRegistry.registerBlock(SednaBlocks.SednaDirt, "SednaDirt");
                GameRegistry.registerBlock(SednaBlocks.SednaStone, "SednaStone");
                GameRegistry.registerBlock(SednaBlocks.SednaCobblestone, "SednaCobblestone");
                GameRegistry.registerBlock(SednaBlocks.SednaBrick, "SednaBrick");
                GameRegistry.registerBlock(SednaBlocks.PalladiumOre, "PalladiumOre");
                GameRegistry.registerBlock(SednaBlocks.PalladiumBlock, "PalladiumBlock");
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