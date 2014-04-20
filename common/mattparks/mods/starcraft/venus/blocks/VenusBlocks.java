package mattparks.mods.starcraft.venus.blocks;

import mattparks.mods.MattCore.Version;
import mattparks.mods.starcraft.venus.CommonProxyVenus;
import mattparks.mods.starcraft.venus.VenusCore;
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

@Mod(name = VenusBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = VenusBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { VenusBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class VenusBlocks 
{
    public static final String NAME = "Venus Blocks";
    public static final String MODID = "VenusBlocks";
    public static final String CHANNEL = "VenusBlocks";
    public static final String CHANNELENTITIES = "VenusBlocksEntities";

	public static final Block VenusGrass = new SCVenusGrass(760, null).setHardness(0.4F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusGrass").setTextureName("starcraftvenus:grassVenus").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusDirt = new SCVenusBlock(761, null).setHardness(0.3F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusDirt").setTextureName("starcraftvenus:dirtVenus").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusStone = new SCVenusStone(762, null).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusStone").setTextureName("starcraftvenus:stoneVenus").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusCobblestone = new SCVenusBlock(763, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusCobblestone").setTextureName("starcraftvenus:cobblestoneVenus").setCreativeTab(VenusCore.starcraftVenusTab);

    public static final Block VenusBurnStone = new SCVenusBurnStone(764, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusBurnStone").setTextureName("starcraftvenus:burnStoneVenus").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusRedGemBlock = new SCVenusBlock(765, null).setHardness(2.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusGem").setTextureName("starcraftvenus:gemBlock").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusMeteorBlock = new SCVenusBlock(766, null).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusMeteor").setTextureName("starcraftvenus:meteorBlock").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusSulferBlock = new SCVenusOre(767, null).setHardness(2.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusSulfer").setTextureName("starcraftvenus:sulferBlock").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusDecorationBlock = new SCVenusBlock(768, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusDecorationBlock").setTextureName("starcraftvenus:venusDecorationBlock").setCreativeTab(VenusCore.starcraftVenusTab);
    
    public static final Block CrystalBlock = new SCVenusBlock(769, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("CrystalBlock").setTextureName("starcraftvenus:crystalBlock").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusBrick = new SCVenusBlock(772, null).setHardness(15.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusBrick").setTextureName("starcraftvenus:venusBrick").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusSulferOre = new SCVenusOre(773, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusSulferOre").setTextureName("starcraftvenus:sulferOre").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusMeteorOre = new SCVenusOre(774, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusMeteorOre").setTextureName("starcraftvenus:meteorOre").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusRedGemOre = new SCVenusOre(775, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusGemOre").setTextureName("starcraftvenus:gemOre").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusIronOre = new SCVenusOre(776, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusIronOre").setTextureName("starcraftvenus:ironOre").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusCoalOre = new SCVenusOre(777, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusCoalOre").setTextureName("starcraftvenus:coalOre").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusTinOre = new SCVenusOre(778, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusTinOre").setTextureName("starcraftvenus:tinOre").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusCopperOre = new SCVenusOre(779, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusCopperOre").setTextureName("starcraftvenus:copperOre").setCreativeTab(VenusCore.starcraftVenusTab);

    public static final Block VenusGlowstoneOre = new SCVenusOre(781, null).setHardness(0.5F).setStepSound(Block.soundGlassFootstep).setLightValue(0.75f).setUnlocalizedName("VenusGlowstoneOre").setTextureName("starcraftvenus:glowstoneOre").setCreativeTab(VenusCore.starcraftVenusTab);
	
    public static final Block VenusCrystalOre = new SCVenusOre(782, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusCrystalOre").setTextureName("starcraftvenus:venusCrystalOre").setCreativeTab(VenusCore.starcraftVenusTab);
    
    public static final Block FossilizedPlantOre = new SCVenusOre(783, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("FossilizedPlantOre").setTextureName("starcraftvenus:fossilizedPlantOre").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block EvolvedBlazeEgg = new SCVenusEgg(784, 0, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("EvolvedBlazeEgg").setTextureName("starcraftvenus:evolvedBlazeEgg").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VenusianTNT = new SCVenusVenusianTNT(785, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusianTNT").setTextureName("starcraftvenus:venusianTNT").setCreativeTab(VenusCore.starcraftVenusTab);

	public static final Block VurnBerryBush = new SCVenusVurnBerryBush(786).setHardness(0.25F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VurnBerryBush").setTextureName("starcraftvenus:VurnBerryBush").setCreativeTab(VenusCore.starcraftVenusTab);

        @Instance(value = "VenusBlocks")
        public static VenusBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.venus.client.ClientProxyVenus", serverSide = "mattparks.mods.starcraft.venus.CommonProxyVenus")
        public static CommonProxyVenus proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(VenusBlocks.VenusGrass, "VenusGrass");
                GameRegistry.registerBlock(VenusBlocks.VenusDirt, "VenusDirt");
                GameRegistry.registerBlock(VenusBlocks.VenusStone, "VenusStone");
                GameRegistry.registerBlock(VenusBlocks.VenusCobblestone, "VenusCobblestone");
                GameRegistry.registerBlock(VenusBlocks.VenusRedGemBlock, "VenusRedGemBlock");
                GameRegistry.registerBlock(VenusBlocks.VenusMeteorBlock, "VenusMeteorBlock");
                GameRegistry.registerBlock(VenusBlocks.VenusBrick, "VenusBrick");
                GameRegistry.registerBlock(VenusBlocks.VenusSulferBlock, "VenusSulferBlock");
                GameRegistry.registerBlock(VenusBlocks.VenusRedGemOre, "VenusRedGemOre");
                GameRegistry.registerBlock(VenusBlocks.VenusMeteorOre, "VenusMeteorOre");
                GameRegistry.registerBlock(VenusBlocks.VenusSulferOre, "VenusSulferOre");
                GameRegistry.registerBlock(VenusBlocks.VenusIronOre, "VenusIronOre");
                GameRegistry.registerBlock(VenusBlocks.VenusCoalOre, "VenusCoalOre");
                GameRegistry.registerBlock(VenusBlocks.VenusTinOre, "VenusTinOre");
                GameRegistry.registerBlock(VenusBlocks.VenusCopperOre, "VenusCopperOre");
                GameRegistry.registerBlock(VenusBlocks.VenusianTNT, "VenusianTNT");
                GameRegistry.registerBlock(VenusBlocks.EvolvedBlazeEgg, "EvolvedBlazeEgg");
                GameRegistry.registerBlock(VenusBlocks.VenusBurnStone, "VenusBurnStone");
                GameRegistry.registerBlock(VenusBlocks.VenusCrystalOre, "VenusCrystalOre");
                GameRegistry.registerBlock(VenusBlocks.FossilizedPlantOre, "FossilizedPlantOre");
                GameRegistry.registerBlock(VenusBlocks.VenusDecorationBlock, "VenusDecorationBlock");
                GameRegistry.registerBlock(VenusBlocks.CrystalBlock, "CrystalBlock");
                GameRegistry.registerBlock(VenusBlocks.VenusGlowstoneOre, "VenusGlowstoneOre");
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