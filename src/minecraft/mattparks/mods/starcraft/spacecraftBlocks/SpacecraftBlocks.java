package mattparks.mods.starcraft.spacecraftBlocks;

import java.io.File;

import mattparks.mods.starcraft.spacecraftBlocks.blocks.jupiter.*;
import mattparks.mods.starcraft.spacecraftBlocks.blocks.mercury.*;
import mattparks.mods.starcraft.spacecraftBlocks.blocks.pluto.*;
import mattparks.mods.starcraft.spacecraftBlocks.blocks.venus.*;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

@Mod(modid="StarcraftBlocks", name="Starcraft Blocks", version="0.0.1", dependencies = "required-after:Forge@[9.10.0.789,)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
  public class SpacecraftBlocks 
  {
    public static final String CHANNEL = "StarcraftBlocks";
    public static final String FILE_PATH = "/mattparks/mods/starcraft/spacecraftBlocks/";
    public static final String CLIENT_PATH = "client/";
    public static final String CONFIG_FILE = "starcraft/starcraftBlocks.conf";
    
	//Block Venus Grass
	public final static Block VenusGrass = new VenusGrass(610, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("VenusGrass") .setTextureName("starcraftvenus:grassVenus");

	//Block Venus Dirt
	public final static Block VenusDirt = new VenusDirt(611, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("VenusDirt") .setTextureName("starcraftvenus:dirtVenus");
    
	//Block Venus Stone
	public final static Block VenusStone = new VenusStone(612, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusStone") .setTextureName("starcraftvenus:stoneVenus");

	//Block Venus Cobblestone
	public final static Block VenusCobblestone = new VenusBlock(613, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCobblestone") .setTextureName("starcraftvenus:cobblestoneVenus");

	//Block Venus Gem Block
	public final static Block VenusRedGemBlock = new VenusBlock(614, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGem") .setTextureName("starcraftvenus:gemBlock");

	//Block Venus Meteor Block
	public final static Block VenusMeteorBlock = new VenusBlock(615, Material.rock) .setHardness(3.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteor") .setTextureName("starcraftvenus:meteorBlock");

	//Block Venus Brick
	public final static Block VenusBrick = new VenusBlock(616, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBrick") .setTextureName("starcraftvenus:venusBrick");

	//Block Venus Sulfer
	public final static Block VenusSulferBlock = new VenusOre(617, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulfer") .setTextureName("starcraftvenus:sulferBlock");

	//Block Venus Sulfer Ore
	public final static Block VenusSulferOre = new VenusOre(618, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulferOre") .setTextureName("starcraftvenus:sulferOre");

	//Block Venus Meteor Ore
	public final static Block VenusMeteorOre = new VenusOre(619, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteorOre") .setTextureName("starcraftvenus:meteorOre");

	//Block Venus Gem Ore
	public final static Block VenusRedGemOre = new VenusOre(620, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGemOre") .setTextureName("starcraftvenus:gemOre");

	//Block Venus Iron Ore
	public final static Block VenusIronOre = new VenusOre(621, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusIronOre") .setTextureName("starcraftvenus:ironOre");

	//Block Venus Coal Ore
	public final static Block VenusCoalOre = new VenusOre(622, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCoalOre") .setTextureName("starcraftvenus:coalOre");

	//Block Venus Iron Ore
	public final static Block VenusTinOre = new VenusOre(623, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusTinOre") .setTextureName("starcraftvenus:tinOre");

	//Block Venus Coal Ore
	public final static Block VenusCopperOre = new VenusOre(624, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCopperOre") .setTextureName("starcraftvenus:copperOre");				

	//Block Venus Basalt
	public final static Block VenusBasalt = new VenusStone(625, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBasalt") .setTextureName("starcraftvenus:venusBasalt");				

	//Block Venus Half Basalt
	public final static Block VenusHalfBasalt = new VenusHalfSlab(626, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusHalfBasalt") .setTextureName("starcraftvenus:venusBasalt");				

	//Block Venus Blaze Egg
	public final static Block EvolvedBlazeEgg = new VenusBlazeEgg(627) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("EvolvedBlazeEgg") .setTextureName("starcraftvenus:evolvedBlazeEgg");				

	//Block Pluto Grass
	public final static Block PlutoGrass = new PlutoGrass(910, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("grassPluto") .setTextureName("starcraftpluto:grassPluto");

	//Block Pluto Dirt
	public final static Block PlutoDirt = new PlutoDirt(911, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("dirtPluto") .setTextureName("starcraftpluto:dirtPluto");
    
	//Block Pluto Stone
	public final static Block PlutoStone = new PlutoStone(912, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("stonePluto") .setTextureName("starcraftpluto:stonePluto");

	//Block Pluto Cobblestone
	public final static Block PlutoCobblestone = new PlutoBlock(913, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("cobblestonePluto") .setTextureName("starcraftpluto:cobblestonePluto");

	//Block Pluto Brick
	public final static Block PlutoBrick = new PlutoBlock(916, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("plutoBrick") .setTextureName("starcraftpluto:plutoBrick");

	
	//Block Mercury Grass
	public final static Block MercuryGrass = new MercuryGrass(710, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("MercuryGrass") .setTextureName("starcraftmercury:grassMercury");

	//Block Mercury Dirt
	public final static Block MercuryDirt = new MercuryDirt(711, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("MercuryDirt") .setTextureName("starcraftmercury:dirtMercury");
    
	//Block Mercury Stone
	public final static Block MercuryStone = new MercuryStone(712, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryStone") .setTextureName("starcraftmercury:stoneMercury");

	//Block Mercury Cobblestone
	public final static Block MercuryCobblestone = new MercuryBlock(713, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCobblestone") .setTextureName("starcraftmercury:cobblestoneMercury");

	//Block Mercury Brick
	public final static Block MercuryBrick = new MercuryBlock(716, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryBrick") .setTextureName("starcraftmercury:mercuryBrick");

	//Block Mercury Gem Ore
	public final static Block MercuryIridiumOre = new MercuryOre(720, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryIridiumOre") .setTextureName("starcraftmercury:iridiumOreMercury");

	//Block Mercury Coal Ore
	public final static Block MercuryCoalOre = new MercuryOre(722, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCoalOre") .setTextureName("starcraftmercury:coalOreMercury");

	//Block Mercury Iron Ore
	public final static Block MercuryTinOre = new MercuryOre(723, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryTinOre") .setTextureName("starcraftmercury:tinOreMercury");

	//Block Mercury Coal Ore
	public final static Block MercuryCopperOre = new MercuryOre(724, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCopperOre") .setTextureName("starcraftmercury:copperOreMercury");				

	
	//Block Jupiter Nitrogen
	public final static Block JupiterNitrogen = new JupiterBlock(650, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("jupiterNitrogen") .setTextureName("starcraftjupiter:jupiterNitrogen");

	//Block Jupiter Helium
	public final static Block JupiterHelium = new JupiterDirt(651, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("jupiterHelium") .setTextureName("starcraftjupiter:jupiterHelium");

	//Block Jupiter Hydrogen
	public final static Block JupiterHydrogen = new JupiterDirt(652, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("jupiterHydrogen") .setTextureName("starcraftjupiter:jupiterHydrogen");
  

	//Block Saturn Grass
	public final static Block SaturnNitrogen = new JupiterDirt(653, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("saturnNitrogen") .setTextureName("starcraftsaturn:saturnNitrogen");

	//Block Saturn Dirt
	public final static Block SaturnHelium = new JupiterDirt(654, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("saturnHelium") .setTextureName("starcraftsaturn:saturnHelium");
    
	//Block Saturn Stone
	public final static Block SaturnHydrogen = new JupiterBlock(655, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("saturnHydrogen") .setTextureName("starcraftsaturn:saturnHydrogen");

	
	//Block Uranus Grass
	public final static Block UranusNitrogen = new JupiterDirt(656, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("uranusNitrogen") .setTextureName("starcrafturanus:uranusNitrogen");

	//Block Uranus Dirt
	public final static Block UranusHelium = new JupiterDirt(657, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("uranusHelium") .setTextureName("starcrafturanus:uranusHelium");
    
	//Block Uranus Stone
	public final static Block UranusHydrogen = new JupiterBlock(658, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("uranusHydrogen") .setTextureName("starcrafturanus:uranusHydrogen");

	
	//Block Neptune Grass
	public final static Block NeptuneNitrogen = new JupiterDirt(659, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("neptuneNitrogen") .setTextureName("starcraftneptune:neptuneNitrogen");

	//Block Neptune Dirt
	public final static Block NeptuneHelium = new JupiterDirt(660, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("neptuneHelium") .setTextureName("starcraftneptune:neptuneHelium");
    
	//Block Neptune Stone
	public final static Block NeptuneHydrogen = new JupiterBlock(661, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("neptuneHydrogen") .setTextureName("starcraftneptune:neptuneHydrogen");
	 
	    @Instance("SpacecraftBlocks")
        public static SpacecraftBlocks instance;

        @SidedProxy(clientSide="mattparks.mods.starcraft.spacecraftBlocks.client.ClientProxy", serverSide="mattparks.mods.starcraft.spacecraftBlocks.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
    		new SpacecraftBlocksConfigManager(new File(event.getModConfigurationDirectory(), SpacecraftBlocks.CONFIG_FILE));
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                proxy.registerRenderers();
                //Registering Blocks
                GameRegistry.registerBlock(VenusGrass, "VenusGrass");
                GameRegistry.registerBlock(VenusDirt, "VenusDirt");
				GameRegistry.registerBlock(VenusStone, "VenusStone");
				GameRegistry.registerBlock(VenusCobblestone, "VenusCobblestone");
				GameRegistry.registerBlock(VenusRedGemBlock, "VenusRedGemBlock");
				GameRegistry.registerBlock(VenusMeteorBlock, "VenusMeteorBlock");
				GameRegistry.registerBlock(VenusBrick, "VenusBrick");
				GameRegistry.registerBlock(VenusSulferBlock, "VenusSulferBlock");
				GameRegistry.registerBlock(VenusRedGemOre, "VenusRedGemOre");
				GameRegistry.registerBlock(VenusMeteorOre, "VenusMeteorOre");
				GameRegistry.registerBlock(VenusSulferOre, "VenusSulferOre");
				GameRegistry.registerBlock(VenusIronOre, "VenusIronOre");
				GameRegistry.registerBlock(VenusCoalOre, "VenusCoalOre");
				GameRegistry.registerBlock(VenusTinOre, "VenusTinOre");
				GameRegistry.registerBlock(VenusCopperOre, "VenusCopperOre");
				GameRegistry.registerBlock(VenusBasalt, "VenusBasalt");
				GameRegistry.registerBlock(VenusHalfBasalt, "VenusHalfBasalt");
				GameRegistry.registerBlock(EvolvedBlazeEgg, "EvolvedBlazeEgg");
				
                GameRegistry.registerBlock(PlutoGrass, "PlutoGrass");
                GameRegistry.registerBlock(PlutoDirt, "PlutoDirt");
				GameRegistry.registerBlock(PlutoStone, "PlutoStone");
				GameRegistry.registerBlock(PlutoCobblestone, "PlutoCobblestone");
				GameRegistry.registerBlock(PlutoBrick, "PlutoBrick");
				
				GameRegistry.registerBlock(MercuryGrass, "MercuryGrass");
                GameRegistry.registerBlock(MercuryDirt, "MercuryDirt");
				GameRegistry.registerBlock(MercuryStone, "MercuryStone");
				GameRegistry.registerBlock(MercuryCobblestone, "MercuryCobblestone");
				GameRegistry.registerBlock(MercuryBrick, "MercuryBrick");
				GameRegistry.registerBlock(MercuryIridiumOre, "MercuryIridiumOre");
				GameRegistry.registerBlock(MercuryCoalOre, "MercuryCoalOre");
				GameRegistry.registerBlock(MercuryTinOre, "MercuryTinOre");
				GameRegistry.registerBlock(MercuryCopperOre, "MercuryCopperOre");
				
				GameRegistry.registerBlock(JupiterNitrogen, "JupiterNitrogen");
	            GameRegistry.registerBlock(JupiterHelium, "JupiterHelium");
			    GameRegistry.registerBlock(JupiterHydrogen, "JupiterHydrogen");
					
	            GameRegistry.registerBlock(SaturnNitrogen, "SaturnNitrogen");
	            GameRegistry.registerBlock(SaturnHelium, "SaturnHelium");
			    GameRegistry.registerBlock(SaturnHydrogen, "SaturnHydrogen");
					
	            GameRegistry.registerBlock(UranusNitrogen, "UranusNitrogen");
	            GameRegistry.registerBlock(UranusHelium, "UranusHelium");
				GameRegistry.registerBlock(UranusHydrogen, "UranusHydrogen");
					
	            GameRegistry.registerBlock(NeptuneNitrogen, "NeptuneNitrogen");
	            GameRegistry.registerBlock(NeptuneHelium, "NeptuneHelium");
				GameRegistry.registerBlock(NeptuneHydrogen, "NeptuneHydrogen");

        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        }
}