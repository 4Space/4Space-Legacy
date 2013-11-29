package mattparks.mods.starcraft.core;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.core.blocks.*;
import mattparks.mods.starcraft.core.network.SCCorePacketHandlerServer;
import mattparks.mods.starcraft.eris.GCEris;
import mattparks.mods.starcraft.jupiter.GCJupiter;
import mattparks.mods.starcraft.mercury.GCMercury;
import mattparks.mods.starcraft.pluto.GCPluto;
import mattparks.mods.starcraft.sedna.GCSedna;
import mattparks.mods.starcraft.venus.GCVenus;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(name = StarcraftCore.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = StarcraftCore.MODID, dependencies = "required-after:Forge@[9.10.0.837,); after:ICBM|Explosion; after:IC2; after:BuildCraft|Core; after:BuildCraft|Energy; after:IC2")
@NetworkMod(channels = { StarcraftCore.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class StarcraftCore
{
    public static final String NAME = "Starcraft Core";
    public static final String MODID = "StarcraftCore";
    public static final String CHANNEL = "GCStarcraftCore";
    public static final String CHANNELENTITIES = "SCCoreEntities";

    public static final int LOCALMAJVERSION = 0;
    public static final int LOCALMINVERSION = 0;
    public static final int LOCALBUILDVERSION = 2;
    public static int remoteMajVer;
    public static int remoteMinVer;
    public static int remoteBuildVer;
    
	// Block Core, Gravity Generator
	public final static Block gravityGenerator = new StarcraftBlock(986, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("GravityGenerator")
			.setTextureName("starcraftmercury:GravityGenerator")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Core, Tier1 Caravan Module
	public final static Block caravanModule = new StarcraftCaravanModule(927, null)
			.setHardness(0.4F).setStepSound(Block.soundClothFootstep)
			.setUnlocalizedName("caravanModule")
			.setTextureName("starcraftmercury:caravanModule");

	// Block Core, Caravan Block
	public final static Block caravanModulePart = new StarcraftBlock(928, null)
			.setHardness(1000000.0F).setStepSound(Block.soundClothFootstep)
			.setUnlocalizedName("caravanModulePart")
			.setTextureName("starcraftmercury:caravanModulePart")
			.setBlockUnbreakable();

	// Block Venus, Grass
	public final static Block VenusGrass = new StarcraftGrass(610, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusGrass")
			.setTextureName("starcraftvenus:grassVenus")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Dirt
	public final static Block VenusDirt = new StarcraftBlock(611, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusDirt")
			.setTextureName("starcraftvenus:dirtVenus")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Stone
	public final static Block VenusStone = new VenusStone(612, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusStone")
			.setTextureName("starcraftvenus:stoneVenus")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Cobblestone
	public final static Block VenusCobblestone = new StarcraftBlock(613, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusCobblestone")
			.setTextureName("starcraftvenus:cobblestoneVenus")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Gem Block
	public final static Block VenusRedGemBlock = new StarcraftBlock(614, null)
			.setHardness(2.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusGem")
			.setTextureName("starcraftvenus:gemBlock")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Meteor Block
	public final static Block VenusMeteorBlock = new StarcraftBlock(615, null)
			.setHardness(3.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusMeteor")
			.setTextureName("starcraftvenus:meteorBlock")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Brick
	public final static Block VenusBrick = new StarcraftBlock(616, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusBrick")
			.setTextureName("starcraftvenus:venusBrick")
			.setCreativeTab(GCVenus.starcraftVenusTab).setBlockUnbreakable();

	// Block Venus, Sulfer
	public final static Block VenusSulferBlock = new StarcraftOre(617, null)
			.setHardness(2.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusSulfer")
			.setTextureName("starcraftvenus:sulferBlock")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Sulfer Ore
	public final static Block VenusSulferOre = new StarcraftOre(618, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusSulferOre")
			.setTextureName("starcraftvenus:sulferOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Meteor Ore
	public final static Block VenusMeteorOre = new StarcraftOre(619, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusMeteorOre")
			.setTextureName("starcraftvenus:meteorOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Gem Ore
	public final static Block VenusRedGemOre = new StarcraftOre(620, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusGemOre")
			.setTextureName("starcraftvenus:gemOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Iron Ore
	public final static Block VenusIronOre = new StarcraftOre(621, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusIronOre")
			.setTextureName("starcraftvenus:ironOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Coal Ore
	public final static Block VenusCoalOre = new StarcraftOre(622, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusCoalOre")
			.setTextureName("starcraftvenus:coalOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Iron Ore
	public final static Block VenusTinOre = new StarcraftOre(623, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusTinOre")
			.setTextureName("starcraftvenus:tinOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Coal Ore
	public final static Block VenusCopperOre = new StarcraftOre(624, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusCopperOre")
			.setTextureName("starcraftvenus:copperOre")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Basalt
	public final static Block VenusBasalt = new StarcraftBlock(625, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusBasalt")
			.setTextureName("starcraftvenus:venusBasalt")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Half Basalt
	public final static Block VenusHalfBasalt = new StarcraftHalfSlab(626, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusHalfBasalt")
			.setTextureName("starcraftvenus:venusBasalt")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Blaze Egg
	public final static Block EvolvedBlazeEgg = new StarcraftEgg(627, 0, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("EvolvedBlazeEgg")
			.setTextureName("starcraftvenus:evolvedBlazeEgg")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Venusian TNT
	public final static Block VenusianTNT = new StarcraftVenusianTNT(629, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VenusianTNT")
			.setTextureName("starcraftvenus:venusianTNT")
			.setCreativeTab(GCVenus.starcraftVenusTab);
	
	// Block Venus, Vurn Berry Bush
	public final static Block VurnBerryBush = new VurnBerryBush(1630)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("VurnBerryBush")
			.setTextureName("starcraftvenus:VurnBerryBush")
			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Venus, Toxic Sludge
// 	public final static Block ToxicSludge = new StarcraftToxicSludge(1024, null) 
// 			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
// 			.setUnlocalizedName("VenusToxicSludge")
// 			.setTextureName("starcraftvenus:toxicSludge")
// 			.setCreativeTab(GCVenus.starcraftVenusTab);

	// Block Pluto, Grass
	public final static Block PlutoGrass = new StarcraftGrass(910, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("grassPluto")
			.setTextureName("starcraftpluto:grassPluto")
			.setCreativeTab(GCPluto.starcraftPlutoTab);

	// Block Pluto, Dirt
	public final static Block PlutoDirt = new StarcraftBlock(911, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("dirtPluto")
			.setTextureName("starcraftpluto:dirtPluto")
			.setCreativeTab(GCPluto.starcraftPlutoTab);

	// Block Pluto, Stone
	public final static Block PlutoStone = new PlutoStone(912, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("stonePluto")
			.setTextureName("starcraftpluto:stonePluto")
			.setCreativeTab(GCPluto.starcraftPlutoTab);

	// Block Pluto, Cobblestone
	public final static Block PlutoCobblestone = new StarcraftBlock(913, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("cobblestonePluto")
			.setTextureName("starcraftpluto:cobblestonePluto")
			.setCreativeTab(GCPluto.starcraftPlutoTab);

	// Block Pluto, Brick
	public final static Block PlutoBrick = new StarcraftBlock(916, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("plutoBrick")
			.setTextureName("starcraftpluto:plutoBrick")
			.setCreativeTab(GCPluto.starcraftPlutoTab)
			.setBlockUnbreakable();

	// Block Mercury, Grass
	public final static Block MercuryGrass = new StarcraftGrass(710, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryGrass")
			.setTextureName("starcraftmercury:grassMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Dirt
	public final static Block MercuryDirt = new StarcraftBlock(711, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryDirt")
			.setTextureName("starcraftmercury:dirtMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Stone
	public final static Block MercuryStone = new MercuryStone(712, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryStone")
			.setTextureName("starcraftmercury:stoneMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Cobblestone
	public final static Block MercuryCobblestone = new StarcraftBlock(713, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryCobblestone")
			.setTextureName("starcraftmercury:cobblestoneMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Brick
	public final static Block MercuryBrick = new StarcraftBlock(716, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryBrick")
			.setTextureName("starcraftmercury:mercuryBrick")
			.setCreativeTab(GCMercury.starcraftMercuryTab)
			.setBlockUnbreakable();

	// Block Mercury, Gem Ore
	public final static Block MercuryIridiumOre = new StarcraftOre(720, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryIridiumOre")
			.setTextureName("starcraftmercury:iridiumOreMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Coal Ore
	public final static Block MercuryCoalOre = new StarcraftOre(722, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryCoalOre")
			.setTextureName("starcraftmercury:coalOreMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Iron Ore
	public final static Block MercuryTinOre = new StarcraftOre(723, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryTinOre")
			.setTextureName("starcraftmercury:tinOreMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Coal Ore
	public final static Block MercuryCopperOre = new StarcraftOre(724, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryCopperOre")
			.setTextureName("starcraftmercury:copperOreMercury")
			.setCreativeTab(GCMercury.starcraftMercuryTab);
	
	// Block Mercury, Glowstone
	public final static Block MercuryGlowstone = new StarcraftColored(725, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("MercuryGlowstone")
			.setLightValue(1.0F)
			.setTextureName("starcraftmercury:glowstone")
			.setCreativeTab(GCMercury.starcraftMercuryTab);
	

	// Block Jupiter, Nitrogen
	public final static Block JupiterNitrogen = new StarcraftGasTop(650, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("jupiterNitrogen")
			.setTextureName("starcraftjupiter:jupiterNitrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Jupiter, Helium
	public final static Block JupiterHelium = new StarcraftGasBottom(651, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("jupiterHelium")
			.setTextureName("starcraftjupiter:jupiterHelium")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Jupiter, Hydrogen
	public final static Block JupiterHydrogen = new StarcraftGasBottom(652,
			null).setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("jupiterHydrogen")
			.setTextureName("starcraftjupiter:jupiterHydrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Jupiter, Brick
	public final static Block JupiterBrick = new StarcraftBlock(637, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("jupiterBrick")
			.setTextureName("starcraftjupiter:jupiterBrick")
			.setCreativeTab(GCJupiter.starcraftGasTab)
			.setBlockUnbreakable();

	// Block Saturn, Nitrogen
	public final static Block SaturnNitrogen = new StarcraftGasTop(653, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("saturnNitrogen")
			.setTextureName("starcraftsaturn:saturnNitrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Saturn, Helium
	public final static Block SaturnHelium = new StarcraftGasBottom(654, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("saturnHelium")
			.setTextureName("starcraftsaturn:saturnHelium")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Saturn, Hydrogen
	public final static Block SaturnHydrogen = new StarcraftGasBottom(655, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("saturnHydrogen")
			.setTextureName("starcraftsaturn:saturnHydrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Saturn, Brick
	public final static Block SaturnBrick = new StarcraftBlock(628, null)
			.setHardness(100.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("saturnBrick")
			.setTextureName("starcraftsaturn:saturnBrick")
			.setCreativeTab(GCJupiter.starcraftGasTab)
			.setBlockUnbreakable();

	// Block Uranus Nitrogen
	public final static Block UranusNitrogen = new StarcraftGasTop(656, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("uranusNitrogen")
			.setTextureName("starcrafturanus:uranusNitrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Uranus Helium
	public final static Block UranusHelium = new StarcraftGasBottom(657, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("uranusHelium")
			.setTextureName("starcrafturanus:uranusHelium")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Uranus Hydrogen
	public final static Block UranusHydrogen = new StarcraftGasBottom(658, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("uranusHydrogen")
			.setTextureName("starcrafturanus:uranusHydrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Uranus Brick
	public final static Block UranusBrick = new StarcraftBlock(699, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("uranusBrick")
			.setTextureName("starcrafturanus:uranusBrick")
			.setCreativeTab(GCJupiter.starcraftGasTab)
			.setBlockUnbreakable();

	// Block Neptune Nitrogen
	public final static Block NeptuneNitrogen = new StarcraftGasTop(659, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("neptuneNitrogen")
			.setTextureName("starcraftneptune:neptuneNitrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Neptune Helium
	public final static Block NeptuneHelium = new StarcraftGasBottom(660, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("neptuneHelium")
			.setTextureName("starcraftneptune:neptuneHelium")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Neptune Hydrogen
	public final static Block NeptuneHydrogen = new StarcraftGasBottom(661,
			null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("neptuneHydrogen")
			.setTextureName("starcraftneptune:neptuneHydrogen")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Neptune Brick
	public final static Block NeptuneBrick = new StarcraftBlock(630, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("neptuneBrick")
			.setTextureName("starcraftneptune:neptuneBrick")
			.setCreativeTab(GCJupiter.starcraftGasTab)
			.setBlockUnbreakable();

	// Fluid Metallic Hydrogen Flowing
	public final static Block hydrogenFlowing = new StarcraftMetallicHydrogenFlowing(920, null)
			.setUnlocalizedName("MetallicHydrogenFlowing")
			.setCreativeTab(GCJupiter.starcraftGasTab);
	
	// Fluid Metallic Hydrogen Still
	public final static Block hydrogenStill = new StarcraftMetallicHydrogenStill(921, null)
			.setUnlocalizedName("MetallicHydrogenStill")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	// Block Eris Grass
	public final static Block ErisGrass = new StarcraftGrass(922, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("grassEris")
			.setTextureName("starcrafteris:grassEris")
			.setCreativeTab(GCEris.starcraftErisTab);

	// Block Pluto Dirt
	public final static Block ErisDirt = new StarcraftBlock(923, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("dirtEris")
			.setTextureName("starcrafteris:dirtEris")
			.setCreativeTab(GCEris.starcraftErisTab);

	// Block Eris Stone
	public final static Block ErisStone = new PlutoStone(924, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("stoneEris")
			.setTextureName("starcrafteris:stoneEris")
			.setCreativeTab(GCEris.starcraftErisTab);

	// Block Eris Cobblestone
	public final static Block ErisCobblestone = new StarcraftBlock(925, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("cobblestoneEris")
			.setTextureName("starcrafteris:cobblestoneEris")
			.setCreativeTab(GCEris.starcraftErisTab);

	// Block Eris Brick
	public final static Block ErisBrick = new StarcraftBlock(926, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("erisBrick")
			.setTextureName("starcrafteris:erisBrick")
			.setCreativeTab(GCEris.starcraftErisTab)
			.setBlockUnbreakable();
	
	// Block Sedna Grass
	public final static Block SednaGrass = new StarcraftGrass(932, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("grassSedna")
			.setTextureName("starcraftsedna:grassSedna")
			.setCreativeTab(GCSedna.starcraftSednaTab);

	// Block Sedna Dirt
	public final static Block SednaDirt = new StarcraftBlock(933, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("dirtSedna")
			.setTextureName("starcraftsedna:dirtSedna")
			.setCreativeTab(GCSedna.starcraftSednaTab);

	// Block Sedna Stone
	public final static Block SednaStone = new PlutoStone(934, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("stoneSedna")
			.setTextureName("starcraftsedna:stoneSedna")
			.setCreativeTab(GCSedna.starcraftSednaTab);

	// Block Sedna Cobblestone
	public final static Block SednaCobblestone = new StarcraftBlock(935, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("cobblestoneSedna")
			.setTextureName("starcraftsedna:cobblestoneSedna")
			.setCreativeTab(GCSedna.starcraftSednaTab);

	// Block Sedna Brick
	public final static Block SednaBrick = new StarcraftBlock(936, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("sednaBrick")
			.setTextureName("starcraftsedna:sednaBrick")
			.setCreativeTab(GCSedna.starcraftSednaTab)
			.setBlockUnbreakable();

    
//    public static final String LANGUAGE_PATH = "/assets/starcraftcore/lang/";
//    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US", "ru_RU" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.core.client.ClientProxy", serverSide = "mattparks.mods.starcraft.core.CommonProxy")
    public static CommonProxy proxy;

    @Instance(StarcraftCore.MODID)
    public static StarcraftCore instance;

//    public static final String ASSET_DOMAIN = "starcraftcore";
//    public static final String ASSET_PREFIX = StarcraftCore.ASSET_DOMAIN + ":";
    
//    public static long tick;
//    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new StarcraftCoreConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/core.conf"));

        StarcraftCore.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        //Registering Blocks
        GameRegistry.registerBlock(StarcraftCore.gravityGenerator, "GravityGenerator");
        GameRegistry.registerBlock(StarcraftCore.caravanModule, "CaravanModule");
        GameRegistry.registerBlock(StarcraftCore.caravanModulePart, "CaravanModulePart");
        
        GameRegistry.registerBlock(StarcraftCore.VenusGrass, "VenusGrass");
        GameRegistry.registerBlock(StarcraftCore.VenusDirt, "VenusDirt");
        GameRegistry.registerBlock(StarcraftCore.VenusStone, "VenusStone");
        GameRegistry.registerBlock(StarcraftCore.VenusCobblestone, "VenusCobblestone");
        GameRegistry.registerBlock(StarcraftCore.VenusRedGemBlock, "VenusRedGemBlock");
        GameRegistry.registerBlock(StarcraftCore.VenusMeteorBlock, "VenusMeteorBlock");
        GameRegistry.registerBlock(StarcraftCore.VenusBrick, "VenusBrick");
        GameRegistry.registerBlock(StarcraftCore.VenusSulferBlock, "VenusSulferBlock");
        GameRegistry.registerBlock(StarcraftCore.VenusRedGemOre, "VenusRedGemOre");
        GameRegistry.registerBlock(StarcraftCore.VenusMeteorOre, "VenusMeteorOre");
        GameRegistry.registerBlock(StarcraftCore.VenusSulferOre, "VenusSulferOre");
        GameRegistry.registerBlock(StarcraftCore.VenusIronOre, "VenusIronOre");
        GameRegistry.registerBlock(StarcraftCore.VenusCoalOre, "VenusCoalOre");
        GameRegistry.registerBlock(StarcraftCore.VenusTinOre, "VenusTinOre");
        GameRegistry.registerBlock(StarcraftCore.VenusCopperOre, "VenusCopperOre");
        GameRegistry.registerBlock(StarcraftCore.VenusBasalt, "VenusBasalt");
        GameRegistry.registerBlock(StarcraftCore.VenusHalfBasalt, "VenusHalfBasalt");
        GameRegistry.registerBlock(StarcraftCore.VenusianTNT, "VenusianTNT");
        GameRegistry.registerBlock(StarcraftCore.EvolvedBlazeEgg, "EvolvedBlazeEgg");
//        GameRegistry.registerBlock(StarcraftCore2.ToxicSludge, "ToxicSludge");

        GameRegistry.registerBlock(StarcraftCore.PlutoGrass, "PlutoGrass");
        GameRegistry.registerBlock(StarcraftCore.PlutoDirt, "PlutoDirt");
        GameRegistry.registerBlock(StarcraftCore.PlutoStone, "PlutoStone");
        GameRegistry.registerBlock(StarcraftCore.PlutoCobblestone, "PlutoCobblestone");
        GameRegistry.registerBlock(StarcraftCore.PlutoBrick, "PlutoBrick");
                        
        GameRegistry.registerBlock(StarcraftCore.MercuryGrass, "MercuryGrass");
        GameRegistry.registerBlock(StarcraftCore.MercuryDirt, "MercuryDirt");
        GameRegistry.registerBlock(StarcraftCore.MercuryStone, "MercuryStone");
        GameRegistry.registerBlock(StarcraftCore.MercuryCobblestone, "MercuryCobblestone");
        GameRegistry.registerBlock(StarcraftCore.MercuryBrick, "MercuryBrick");
        GameRegistry.registerBlock(StarcraftCore.MercuryIridiumOre, "MercuryIridiumOre");
        GameRegistry.registerBlock(StarcraftCore.MercuryCoalOre, "MercuryCoalOre");
        GameRegistry.registerBlock(StarcraftCore.MercuryTinOre, "MercuryTinOre");
        GameRegistry.registerBlock(StarcraftCore.MercuryCopperOre, "MercuryCopperOre");
        GameRegistry.registerBlock(StarcraftCore.MercuryGlowstone, "MercuryGlowstone");
                        
        GameRegistry.registerBlock(StarcraftCore.JupiterNitrogen, "JupiterNitrogen");
        GameRegistry.registerBlock(StarcraftCore.JupiterHelium, "JupiterHelium");
        GameRegistry.registerBlock(StarcraftCore.JupiterHydrogen, "JupiterHydrogen");
        GameRegistry.registerBlock(StarcraftCore.JupiterBrick, "JupiterBrick");       
        
        GameRegistry.registerBlock(StarcraftCore.SaturnNitrogen, "SaturnNitrogen");
        GameRegistry.registerBlock(StarcraftCore.SaturnHelium, "SaturnHelium");
        GameRegistry.registerBlock(StarcraftCore.SaturnHydrogen, "SaturnHydrogen");
        GameRegistry.registerBlock(StarcraftCore.SaturnBrick, "SaturnBrick");
        
        GameRegistry.registerBlock(StarcraftCore.UranusNitrogen, "UranusNitrogen");
        GameRegistry.registerBlock(StarcraftCore.UranusHelium, "UranusHelium");
        GameRegistry.registerBlock(StarcraftCore.UranusHydrogen, "UranusHydrogen");
        GameRegistry.registerBlock(StarcraftCore.UranusBrick, "UranusBrick");
                                
        GameRegistry.registerBlock(StarcraftCore.NeptuneNitrogen, "NeptuneNitrogen");
        GameRegistry.registerBlock(StarcraftCore.NeptuneHelium, "NeptuneHelium");
        GameRegistry.registerBlock(StarcraftCore.NeptuneHydrogen, "NeptuneHydrogen");
        GameRegistry.registerBlock(StarcraftCore.NeptuneBrick, "NeptuneBrick");
        
        GameRegistry.registerBlock(StarcraftCore.hydrogenFlowing, "MetallicHydrogenFlowing");
//      GameRegistry.registerBlock(StarcraftCore2.hydrogenStill, "MetallicHydrogenStill");
            
        GameRegistry.registerBlock(StarcraftCore.ErisGrass, "ErisGrass");
        GameRegistry.registerBlock(StarcraftCore.ErisDirt, "ErisDirt");
        GameRegistry.registerBlock(StarcraftCore.ErisStone, "ErisStone");
        GameRegistry.registerBlock(StarcraftCore.ErisCobblestone, "ErisCobblestone");
        GameRegistry.registerBlock(StarcraftCore.ErisBrick, "ErisBrick");
        
        GameRegistry.registerBlock(StarcraftCore.SednaGrass, "SednaGrass");
        GameRegistry.registerBlock(StarcraftCore.SednaDirt, "SednaDirt");
        GameRegistry.registerBlock(StarcraftCore.SednaStone, "SednaStone");
        GameRegistry.registerBlock(StarcraftCore.SednaCobblestone, "SednaCobblestone");
        GameRegistry.registerBlock(StarcraftCore.SednaBrick, "SednaBrick");
       
//        int languages = 0;
//
//        for (String language : StarcraftCore2.LANGUAGES_SUPPORTED)
//        {
//            LanguageRegistry.instance().loadLocalization(StarcraftCore2.LANGUAGE_PATH + language + ".lang", language, false);
//
//            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
//            {
//                try
//                {
//                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");
//
//                    for (String child : children)
//                    {
//                        if (child != "" || child != null)
//                        {
//                            LanguageRegistry.instance().loadLocalization(StarcraftCore2.LANGUAGE_PATH + language + ".lang", child, false);
//                            languages++;
//                        }
//                    }
//                }
//                catch (Exception e)
//                {
//                    FMLLog.severe("Failed to load a child language file.");
//                    e.printStackTrace();
//                }
//            }
//
//            languages++;
//        }
//
//        GCLog.info("Starcraft Core Loaded: " + languages + " Languages.");

//        SchematicRegistry.registerSchematicRecipe(new GCVenusSchematicRocketT3());
        // TODO add Tier 3-6 to crafting bench  
        
        NetworkRegistry.instance().registerGuiHandler(StarcraftCore.instance, StarcraftCore.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        StarcraftCore.proxy.init(event);
//        GalacticraftRegistry.addDungeonLoot(2, new ItemStack(SCCoreItems.schematic, 1, 0));
        // TODO add Tier 3-6 schematics to dungeons       
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new SCCorePacketHandlerServer(), StarcraftCore.CHANNEL, Side.SERVER);
    }

    public void registerTileEntities()
    {
    	;
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerOtherEntities()
    {
    	;
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        StarcraftCore.proxy.postInit(event);
        StarcraftCore.proxy.registerRenderInformation();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, StarcraftCore.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
