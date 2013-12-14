package mattparks.mods.starcraft.core;

import mattparks.mods.starcraft.core.blocks.BurnStone;
import mattparks.mods.starcraft.core.blocks.StarcraftBlock;
import mattparks.mods.starcraft.core.blocks.StarcraftEgg;
import mattparks.mods.starcraft.core.blocks.StarcraftGrass;
import mattparks.mods.starcraft.core.blocks.StarcraftHalfSlab;
import mattparks.mods.starcraft.core.blocks.StarcraftOre;
import mattparks.mods.starcraft.core.blocks.StarcraftVenusianTNT;
import mattparks.mods.starcraft.core.blocks.VenusStone;
import mattparks.mods.starcraft.core.blocks.VurnBerryBush;
import mattparks.mods.starcraft.venus.GCVenus;
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

@Mod(name = StarcraftVenus.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = StarcraftVenus.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { StarcraftVenus.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class StarcraftVenus 
{
    public static final String NAME = "Starcraft Venus";
    public static final String MODID = "StarcraftVenus";
    public static final String CHANNEL = "StarcraftVenus";
    public static final String CHANNELENTITIES = "StarcraftVenusEntities";


	// Block Venus, Grass
	public static final Block VenusGrass = new StarcraftGrass(610, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusGrass")
			.setTextureName("starcraftvenus:grassVenus")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Dirt
	public static final Block VenusDirt = new StarcraftBlock(611, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusDirt")
			.setTextureName("starcraftvenus:dirtVenus")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Stone
	public static final Block VenusStone = new VenusStone(612, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusStone")
			.setTextureName("starcraftvenus:stoneVenus")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Cobblestone
	public static final Block VenusCobblestone = new StarcraftBlock(613, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusCobblestone")
			.setTextureName("starcraftvenus:cobblestoneVenus")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Gem Block
	public static final Block VenusRedGemBlock = new StarcraftBlock(614, null)
			.setHardness(2.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusGem")
			.setTextureName("starcraftvenus:gemBlock")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Meteor Block
	public static final Block VenusMeteorBlock = new StarcraftBlock(615, null)
			.setHardness(3.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusMeteor")
			.setTextureName("starcraftvenus:meteorBlock")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Brick
	public static final Block VenusBrick = new StarcraftBlock(616, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusBrick")
			.setTextureName("starcraftvenus:venusBrick")
			.setCreativeTab(GCVenus.starcraftVenusTab).setBlockUnbreakable();

	// Block Venus, Sulfer
	public static final Block VenusSulferBlock = new StarcraftOre(617, null)
			.setHardness(2.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusSulfer")
			.setTextureName("starcraftvenus:sulferBlock")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Sulfer Ore
	public static final Block VenusSulferOre = new StarcraftOre(618, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusSulferOre")
			.setTextureName("starcraftvenus:sulferOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Meteor Ore
	public static final Block VenusMeteorOre = new StarcraftOre(619, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusMeteorOre")
			.setTextureName("starcraftvenus:meteorOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Gem Ore
	public static final Block VenusRedGemOre = new StarcraftOre(620, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusGemOre")
			.setTextureName("starcraftvenus:gemOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Iron Ore
	public static final Block VenusIronOre = new StarcraftOre(621, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusIronOre")
			.setTextureName("starcraftvenus:ironOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Coal Ore
	public static final Block VenusCoalOre = new StarcraftOre(622, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusCoalOre")
			.setTextureName("starcraftvenus:coalOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Iron Ore
	public static final Block VenusTinOre = new StarcraftOre(623, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusTinOre")
			.setTextureName("starcraftvenus:tinOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Coal Ore
	public static final Block VenusCopperOre = new StarcraftOre(624, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusCopperOre")
			.setTextureName("starcraftvenus:copperOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Basalt
	public static final Block VenusBasalt = new StarcraftBlock(625, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusBasalt")
			.setTextureName("starcraftvenus:venusBasalt")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Half Basalt
	public static final Block VenusHalfBasalt = new StarcraftHalfSlab(626, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusHalfBasalt")
			.setTextureName("starcraftvenus:venusBasalt")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Blaze Egg
	public static final Block EvolvedBlazeEgg = new StarcraftEgg(627, 0, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("EvolvedBlazeEgg")
			.setTextureName("starcraftvenus:evolvedBlazeEgg")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Venusian TNT
	public static final Block VenusianTNT = new StarcraftVenusianTNT(629, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusianTNT")
			.setTextureName("starcraftvenus:venusianTNT")
			.setCreativeTab(GCVenus.starcraftVenusTab);
	
	// Block Venus, Vurn Berry Bush
	public static final Block VurnBerryBush = new VurnBerryBush(1630)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VurnBerryBush")
			.setTextureName("starcraftvenus:VurnBerryBush")
			.setCreativeTab(GCVenus.starcraftVenusTab);
	
	// Block Venus, Burn Stone
		public static final Block VenusBurnStone = new BurnStone(1631, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusBurnStone")
			.setTextureName("starcraftvenus:burnStoneVenus")
			.setCreativeTab(GCVenus.starcraftVenusTab);

		
        @Instance(value = "StarcraftVenus")
        public static StarcraftVenus instance;
        
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
                GameRegistry.registerBlock(StarcraftVenus.VenusGrass, "VenusGrass");
                GameRegistry.registerBlock(StarcraftVenus.VenusDirt, "VenusDirt");
                GameRegistry.registerBlock(StarcraftVenus.VenusStone, "VenusStone");
                GameRegistry.registerBlock(StarcraftVenus.VenusCobblestone, "VenusCobblestone");
                GameRegistry.registerBlock(StarcraftVenus.VenusRedGemBlock, "VenusRedGemBlock");
                GameRegistry.registerBlock(StarcraftVenus.VenusMeteorBlock, "VenusMeteorBlock");
                GameRegistry.registerBlock(StarcraftVenus.VenusBrick, "VenusBrick");
                GameRegistry.registerBlock(StarcraftVenus.VenusSulferBlock, "VenusSulferBlock");
                GameRegistry.registerBlock(StarcraftVenus.VenusRedGemOre, "VenusRedGemOre");
                GameRegistry.registerBlock(StarcraftVenus.VenusMeteorOre, "VenusMeteorOre");
                GameRegistry.registerBlock(StarcraftVenus.VenusSulferOre, "VenusSulferOre");
                GameRegistry.registerBlock(StarcraftVenus.VenusIronOre, "VenusIronOre");
                GameRegistry.registerBlock(StarcraftVenus.VenusCoalOre, "VenusCoalOre");
                GameRegistry.registerBlock(StarcraftVenus.VenusTinOre, "VenusTinOre");
                GameRegistry.registerBlock(StarcraftVenus.VenusCopperOre, "VenusCopperOre");
                GameRegistry.registerBlock(StarcraftVenus.VenusBasalt, "VenusBasalt");
                GameRegistry.registerBlock(StarcraftVenus.VenusHalfBasalt, "VenusHalfBasalt");
                GameRegistry.registerBlock(StarcraftVenus.VenusianTNT, "VenusianTNT");
                GameRegistry.registerBlock(StarcraftVenus.EvolvedBlazeEgg, "EvolvedBlazeEgg");
                GameRegistry.registerBlock(StarcraftVenus.VenusBurnStone, "VenusBurnStone");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        }
}