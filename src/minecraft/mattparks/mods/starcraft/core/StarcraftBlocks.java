package mattparks.mods.starcraft.core;

import mattparks.mods.starcraft.core.blocks.*;
import mattparks.mods.starcraft.eris.GCEris;
import mattparks.mods.starcraft.jupiter.GCJupiter;
import mattparks.mods.starcraft.mercury.GCMercury;
import mattparks.mods.starcraft.pluto.GCPluto;
import mattparks.mods.starcraft.sedna.GCSedna;
import mattparks.mods.starcraft.venus.GCVenus;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(name = StarcraftBlocks.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = StarcraftBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { StarcraftBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class StarcraftBlocks 
{
    public static final String NAME = "Starcraft Blocks";
    public static final String MODID = "StarcraftBlocks";
    public static final String CHANNEL = "StarcraftBlocks";
    public static final String CHANNELENTITIES = "StarcraftBlocksEntities";

    
	// Block Mercury, Grass
    public static final Block MercuryGrass = new StarcraftGrass(710, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryGrass")
			.setTextureName("starcraftmercury:grassMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Dirt
	public static final Block MercuryDirt = new StarcraftBlock(711, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryDirt")
			.setTextureName("starcraftmercury:dirtMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Stone
	public static final Block MercuryStone = new MercuryStone(712, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryStone")
			.setTextureName("starcraftmercury:stoneMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Cobblestone
	public static final Block MercuryCobblestone = new StarcraftBlock(713, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryCobblestone")
			.setTextureName("starcraftmercury:cobblestoneMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Brick
	public static final Block MercuryBrick = new StarcraftBlock(716, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryBrick")
			.setTextureName("starcraftmercury:mercuryBrick")
			.setCreativeTab(GCMercury.starcraftMercuryTab)
			.setBlockUnbreakable();

	// Block Mercury, Gem Ore
	public static final Block MercuryIridiumOre = new StarcraftOre(720, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryIridiumOre")
			.setTextureName("starcraftmercury:iridiumOreMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Coal Ore
	public static final Block MercuryCoalOre = new StarcraftOre(722, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryCoalOre")
			.setTextureName("starcraftmercury:coalOreMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Iron Ore
	public static final Block MercuryTinOre = new StarcraftOre(723, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryTinOre")
			.setTextureName("starcraftmercury:tinOreMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Coal Ore
	public static final Block MercuryCopperOre = new StarcraftOre(724, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryCopperOre")
			.setTextureName("starcraftmercury:copperOreMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);
	
	// Block Mercury, Glowstone
	public static final Block MercuryGlowstone = new StarcraftGlowstone(725, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryGlowstone")
			.setLightValue(1.0F)
			.setTextureName("starcraftmercury:glowstone")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Gravity Generator
	public static final Block gravityGenerator = new StarcraftGravityGenerator(986, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("GravityGenerator")
			.setTextureName("starcraftmercury:GravityGenerator")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Tier1 Caravan Module
	public static final Block caravanModule = new StarcraftCaravanModule(927, null)
			.setHardness(0.4F).setStepSound(Block.soundClothFootstep)
			.setUnlocalizedName("caravanModule")
			.setTextureName("starcraftmercury:caravanModule");

	// Block Mercury, Caravan Block
	public static final Block caravanModulePart = new StarcraftBlock(928, null)
			.setHardness(1000000.0F).setStepSound(Block.soundClothFootstep)
			.setUnlocalizedName("caravanModulePart")
			.setTextureName("starcraftmercury:caravanModulePart")
			.setBlockUnbreakable();

	
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
	
	
	// Block Jupiter, Nitrogen
	public static final Block JupiterNitrogen = new StarcraftGasTop(650, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("jupiterNitrogen")
			.setTextureName("starcraftjupiter:jupiterNitrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Jupiter, Helium
	public static final Block JupiterHelium = new StarcraftGasBottom(651, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("jupiterHelium")
			.setTextureName("starcraftjupiter:jupiterHelium")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Jupiter, Hydrogen
	public static final Block JupiterHydrogen = new StarcraftGasBottom(652,
			null).setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("jupiterHydrogen")
			.setTextureName("starcraftjupiter:jupiterHydrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Jupiter, Brick
	public static final Block JupiterBrick = new StarcraftBlock(637, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("jupiterBrick")
			.setTextureName("starcraftjupiter:jupiterBrick")
			.setCreativeTab(GCJupiter.starcraftGasTab)
			.setBlockUnbreakable();

	
	// Block Saturn, Nitrogen
	public static final Block SaturnNitrogen = new StarcraftGasTop(653, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("saturnNitrogen")
			.setTextureName("starcraftsaturn:saturnNitrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Saturn, Helium
	public static final Block SaturnHelium = new StarcraftGasBottom(654, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("saturnHelium")
			.setTextureName("starcraftsaturn:saturnHelium")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Saturn, Hydrogen
	public static final Block SaturnHydrogen = new StarcraftGasBottom(655, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("saturnHydrogen")
			.setTextureName("starcraftsaturn:saturnHydrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Saturn, Brick
	public static final Block SaturnBrick = new StarcraftBlock(628, null)
			.setHardness(100.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("saturnBrick")
			.setTextureName("starcraftsaturn:saturnBrick")
			.setCreativeTab(GCJupiter.starcraftGasTab)
			.setBlockUnbreakable();

	
	// Block Uranus Nitrogen
	public static final Block UranusNitrogen = new StarcraftGasTop(656, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("uranusNitrogen")
			.setTextureName("starcrafturanus:uranusNitrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Uranus Helium
	public static final Block UranusHelium = new StarcraftGasBottom(657, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("uranusHelium")
			.setTextureName("starcrafturanus:uranusHelium")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Uranus Hydrogen
	public static final Block UranusHydrogen = new StarcraftGasBottom(658, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("uranusHydrogen")
			.setTextureName("starcrafturanus:uranusHydrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Uranus Brick
	public static final Block UranusBrick = new StarcraftBlock(699, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("uranusBrick")
			.setTextureName("starcrafturanus:uranusBrick")
			.setCreativeTab(GCJupiter.starcraftGasTab)
			.setBlockUnbreakable();

	
	// Block Neptune Nitrogen
	public static final Block NeptuneNitrogen = new StarcraftGasTop(659, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("neptuneNitrogen")
			.setTextureName("starcraftneptune:neptuneNitrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Neptune Helium
	public static final Block NeptuneHelium = new StarcraftGasBottom(660, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("neptuneHelium")
			.setTextureName("starcraftneptune:neptuneHelium")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Neptune Hydrogen
	public static final Block NeptuneHydrogen = new StarcraftGasBottom(661,
			null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("neptuneHydrogen")
			.setTextureName("starcraftneptune:neptuneHydrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Neptune Brick
	public static final Block NeptuneBrick = new StarcraftBlock(630, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("neptuneBrick")
			.setTextureName("starcraftneptune:neptuneBrick")
			.setCreativeTab(GCJupiter.starcraftGasTab)
			.setBlockUnbreakable();

	
	// Fluid Metallic Hydrogen Flowing
	public static final Block hydrogenFlowing = new StarcraftMetallicHydrogenFlowing(920, null)
			.setUnlocalizedName("MetallicHydrogenFlowing")
			.setCreativeTab(GCJupiter.starcraftGasTab);
	
	// Fluid Metallic Hydrogen Still
	public static final Block hydrogenStill = new StarcraftMetallicHydrogenStill(921, null)
			.setUnlocalizedName("MetallicHydrogenStill")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	
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
	
	
	// Block Sedna Grass
	public static final Block SednaGrass = new StarcraftGrass(932, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("grassSedna")
			.setTextureName("starcraftsedna:grassSedna")
			.setCreativeTab(GCSedna.starcraftSednaTab);

	// Block Sedna Dirt
	public static final Block SednaDirt = new StarcraftBlock(933, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("dirtSedna")
			.setTextureName("starcraftsedna:dirtSedna")
			.setCreativeTab(GCSedna.starcraftSednaTab);

	// Block Sedna Stone
	public static final Block SednaStone = new PlutoStone(934, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("stoneSedna")
			.setTextureName("starcraftsedna:stoneSedna")
			.setCreativeTab(GCSedna.starcraftSednaTab);

	// Block Sedna Cobblestone
	public static final Block SednaCobblestone = new StarcraftBlock(935, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("cobblestoneSedna")
			.setTextureName("starcraftsedna:cobblestoneSedna")
			.setCreativeTab(GCSedna.starcraftSednaTab);

	// Block Sedna Brick
	public static final Block SednaBrick = new StarcraftBlock(936, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("sednaBrick")
			.setTextureName("starcraftsedna:sednaBrick")
			.setCreativeTab(GCSedna.starcraftSednaTab)
			.setBlockUnbreakable();

		
		
        @Instance(value = "StarcraftBlocks")
        public static StarcraftBlocks instance;
        
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
                GameRegistry.registerBlock(StarcraftBlocks.gravityGenerator, "GravityGenerator");
                GameRegistry.registerBlock(StarcraftBlocks.caravanModule, "CaravanModule");
                GameRegistry.registerBlock(StarcraftBlocks.caravanModulePart, "CaravanModulePart");
                
                GameRegistry.registerBlock(StarcraftBlocks.VenusGrass, "VenusGrass");
                GameRegistry.registerBlock(StarcraftBlocks.VenusDirt, "VenusDirt");
                GameRegistry.registerBlock(StarcraftBlocks.VenusStone, "VenusStone");
                GameRegistry.registerBlock(StarcraftBlocks.VenusCobblestone, "VenusCobblestone");
                GameRegistry.registerBlock(StarcraftBlocks.VenusRedGemBlock, "VenusRedGemBlock");
                GameRegistry.registerBlock(StarcraftBlocks.VenusMeteorBlock, "VenusMeteorBlock");
                GameRegistry.registerBlock(StarcraftBlocks.VenusBrick, "VenusBrick");
                GameRegistry.registerBlock(StarcraftBlocks.VenusSulferBlock, "VenusSulferBlock");
                GameRegistry.registerBlock(StarcraftBlocks.VenusRedGemOre, "VenusRedGemOre");
                GameRegistry.registerBlock(StarcraftBlocks.VenusMeteorOre, "VenusMeteorOre");
                GameRegistry.registerBlock(StarcraftBlocks.VenusSulferOre, "VenusSulferOre");
                GameRegistry.registerBlock(StarcraftBlocks.VenusIronOre, "VenusIronOre");
                GameRegistry.registerBlock(StarcraftBlocks.VenusCoalOre, "VenusCoalOre");
                GameRegistry.registerBlock(StarcraftBlocks.VenusTinOre, "VenusTinOre");
                GameRegistry.registerBlock(StarcraftBlocks.VenusCopperOre, "VenusCopperOre");
                GameRegistry.registerBlock(StarcraftBlocks.VenusBasalt, "VenusBasalt");
                GameRegistry.registerBlock(StarcraftBlocks.VenusHalfBasalt, "VenusHalfBasalt");
                GameRegistry.registerBlock(StarcraftBlocks.VenusianTNT, "VenusianTNT");
                GameRegistry.registerBlock(StarcraftBlocks.EvolvedBlazeEgg, "EvolvedBlazeEgg");
//                GameRegistry.registerBlock(StarcraftCore2.ToxicSludge, "ToxicSludge");

                GameRegistry.registerBlock(StarcraftBlocks.PlutoGrass, "PlutoGrass");
                GameRegistry.registerBlock(StarcraftBlocks.PlutoDirt, "PlutoDirt");
                GameRegistry.registerBlock(StarcraftBlocks.PlutoStone, "PlutoStone");
                GameRegistry.registerBlock(StarcraftBlocks.PlutoCobblestone, "PlutoCobblestone");
                GameRegistry.registerBlock(StarcraftBlocks.PlutoBrick, "PlutoBrick");
                                
                GameRegistry.registerBlock(StarcraftBlocks.MercuryGrass, "MercuryGrass");
                GameRegistry.registerBlock(StarcraftBlocks.MercuryDirt, "MercuryDirt");
                GameRegistry.registerBlock(StarcraftBlocks.MercuryStone, "MercuryStone");
                GameRegistry.registerBlock(StarcraftBlocks.MercuryCobblestone, "MercuryCobblestone");
                GameRegistry.registerBlock(StarcraftBlocks.MercuryBrick, "MercuryBrick");
                GameRegistry.registerBlock(StarcraftBlocks.MercuryIridiumOre, "MercuryIridiumOre");
                GameRegistry.registerBlock(StarcraftBlocks.MercuryCoalOre, "MercuryCoalOre");
                GameRegistry.registerBlock(StarcraftBlocks.MercuryTinOre, "MercuryTinOre");
                GameRegistry.registerBlock(StarcraftBlocks.MercuryCopperOre, "MercuryCopperOre");
                GameRegistry.registerBlock(StarcraftBlocks.MercuryGlowstone, "MercuryGlowstone");
                                
                GameRegistry.registerBlock(StarcraftBlocks.JupiterNitrogen, "JupiterNitrogen");
                GameRegistry.registerBlock(StarcraftBlocks.JupiterHelium, "JupiterHelium");
                GameRegistry.registerBlock(StarcraftBlocks.JupiterHydrogen, "JupiterHydrogen");
                GameRegistry.registerBlock(StarcraftBlocks.JupiterBrick, "JupiterBrick");       
                
                GameRegistry.registerBlock(StarcraftBlocks.SaturnNitrogen, "SaturnNitrogen");
                GameRegistry.registerBlock(StarcraftBlocks.SaturnHelium, "SaturnHelium");
                GameRegistry.registerBlock(StarcraftBlocks.SaturnHydrogen, "SaturnHydrogen");
                GameRegistry.registerBlock(StarcraftBlocks.SaturnBrick, "SaturnBrick");
                
                GameRegistry.registerBlock(StarcraftBlocks.UranusNitrogen, "UranusNitrogen");
                GameRegistry.registerBlock(StarcraftBlocks.UranusHelium, "UranusHelium");
                GameRegistry.registerBlock(StarcraftBlocks.UranusHydrogen, "UranusHydrogen");
                GameRegistry.registerBlock(StarcraftBlocks.UranusBrick, "UranusBrick");
                                        
                GameRegistry.registerBlock(StarcraftBlocks.NeptuneNitrogen, "NeptuneNitrogen");
                GameRegistry.registerBlock(StarcraftBlocks.NeptuneHelium, "NeptuneHelium");
                GameRegistry.registerBlock(StarcraftBlocks.NeptuneHydrogen, "NeptuneHydrogen");
                GameRegistry.registerBlock(StarcraftBlocks.NeptuneBrick, "NeptuneBrick");
                
                GameRegistry.registerBlock(StarcraftBlocks.hydrogenFlowing, "MetallicHydrogenFlowing");
//              GameRegistry.registerBlock(StarcraftCore2.hydrogenStill, "MetallicHydrogenStill");
                    
                GameRegistry.registerBlock(StarcraftBlocks.ErisGrass, "ErisGrass");
                GameRegistry.registerBlock(StarcraftBlocks.ErisDirt, "ErisDirt");
                GameRegistry.registerBlock(StarcraftBlocks.ErisStone, "ErisStone");
                GameRegistry.registerBlock(StarcraftBlocks.ErisCobblestone, "ErisCobblestone");
                GameRegistry.registerBlock(StarcraftBlocks.ErisBrick, "ErisBrick");
                
                GameRegistry.registerBlock(StarcraftBlocks.SednaGrass, "SednaGrass");
                GameRegistry.registerBlock(StarcraftBlocks.SednaDirt, "SednaDirt");
                GameRegistry.registerBlock(StarcraftBlocks.SednaStone, "SednaStone");
                GameRegistry.registerBlock(StarcraftBlocks.SednaCobblestone, "SednaCobblestone");
                GameRegistry.registerBlock(StarcraftBlocks.SednaBrick, "SednaBrick");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        }
}
