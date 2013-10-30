package spacecraft.mods.galacticraft.spacecraftBlocks;

import java.io.File;

import spacecraft.mods.galacticraft.spacecraftBlocks.blocks.mercury.*;
import spacecraft.mods.galacticraft.spacecraftBlocks.blocks.venus.*;
import spacecraft.mods.galacticraft.spacecraftBlocks.blocks.jupiter.*;
import spacecraft.mods.galacticraft.spacecraftBlocks.blocks.pluto.*;
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

@Mod(modid="SpacecraftBlocks", name="Spacecraft Blocks", version="0.0.1", dependencies = "required-after:Forge@[9.10.0.789,)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
  public class SpacecraftBlocks 
  {
	    public static final String CHANNEL = "SpacecraftBlocks";
	    public static final String FILE_PATH = "/spacecraft/mods/galacticraft/spacecraftBlocks/";
	    public static final String CLIENT_PATH = "client/";
	    public static final String LANGUAGE_PATH = "/assets/spacecraftblocks/lang/";
	    public static final String CONFIG_FILE = "spacecraft/spacecraftblocks.conf";
	    private static final String[] LANGUAGES_SUPPORTED = new String[] {"en_US"};
	    
	    public static String TEXTURE_DOMAIN = "spacecraftBlocks";
	    public static String TEXTURE_PREFIX = SpacecraftBlocks.TEXTURE_DOMAIN + ":";
	    public static String TEXTURE_SUFFIX;

	    @Instance("SpacecraftBlocks")
        public static SpacecraftBlocks instance;
		
		//Block Venus Grass
    	public final static Block VenusGrass = new VenusGrass(610, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("VenusGrass") .setTextureName("spacecraftvenus:grassVenus");

		//Block Venus Dirt
		public final static Block VenusDirt = new VenusDirt(611, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("VenusDirt") .setTextureName("spacecraftvenus:dirtVenus");
        
		//Block Venus Stone
		public final static Block VenusStone = new VenusStone(612, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusStone") .setTextureName("spacecraftvenus:stoneVenus");

		//Block Venus Cobblestone
		public final static Block VenusCobblestone = new VenusBlock(613, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCobblestone") .setTextureName("spacecraftvenus:cobblestoneVenus");

		//Block Venus Gem Block
		public final static Block VenusRedGemBlock = new VenusBlock(614, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGem") .setTextureName("spacecraftvenus:gemBlock");

		//Block Venus Meteor Block
		public final static Block VenusMeteorBlock = new VenusBlock(615, Material.rock) .setHardness(3.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteor") .setTextureName("spacecraftvenus:meteorBlock");

		//Block Venus Brick
		public final static Block VenusBrick = new VenusBlock(616, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBrick") .setTextureName("spacecraftvenus:venusBrick");

		//Block Venus Sulfer
		public final static Block VenusSulferBlock = new VenusOre(617, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulfer") .setTextureName("spacecraftvenus:sulferBlock");

		//Block Venus Sulfer Ore
		public final static Block VenusSulferOre = new VenusOre(618, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulferOre") .setTextureName("spacecraftvenus:sulferOre");

		//Block Venus Meteor Ore
		public final static Block VenusMeteorOre = new VenusOre(619, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteorOre") .setTextureName("spacecraftvenus:meteorOre");

		//Block Venus Gem Ore
		public final static Block VenusRedGemOre = new VenusOre(620, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGemOre") .setTextureName("spacecraftvenus:gemOre");

		//Block Venus Iron Ore
		public final static Block VenusIronOre = new VenusOre(621, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusIronOre") .setTextureName("spacecraftvenus:ironOre");

		//Block Venus Coal Ore
		public final static Block VenusCoalOre = new VenusOre(622, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCoalOre") .setTextureName("spacecraftvenus:coalOre");

		//Block Venus Iron Ore
		public final static Block VenusTinOre = new VenusOre(623, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusTinOre") .setTextureName("spacecraftvenus:tinOre");

		//Block Venus Coal Ore
		public final static Block VenusCopperOre = new VenusOre(624, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCopperOre") .setTextureName("spacecraftvenus:copperOre");				

		//Block Venus Basalt
		public final static Block VenusBasalt = new VenusStone(625, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBasalt") .setTextureName("spacecraftvenus:venusBasalt");				

		//Block Venus Half Basalt
		public final static Block VenusHalfBasalt = new VenusHalfSlab(626, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusHalfBasalt") .setTextureName("spacecraftvenus:venusBasalt");				

		//Block Venus Blaze Egg
		public final static Block EvolvedBlazeEgg = new VenusBlazeEgg(627) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("EvolvedBlazeEgg") .setTextureName("spacecraftvenus:evolvedBlazeEgg");				

		//Block Pluto Grass
    	public final static Block PlutoGrass = new PlutoGrass(910, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("grassPluto") .setTextureName("spacecraftpluto:grassPluto");

		//Block Pluto Dirt
		public final static Block PlutoDirt = new PlutoDirt(911, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("dirtPluto") .setTextureName("spacecraftpluto:dirtPluto");
        
		//Block Pluto Stone
		public final static Block PlutoStone = new PlutoStone(912, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("stonePluto") .setTextureName("spacecraftpluto:stonePluto");

		//Block Pluto Cobblestone
		public final static Block PlutoCobblestone = new PlutoBlock(913, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("cobblestonePluto") .setTextureName("spacecraftpluto:cobblestonePluto");

		//Block Pluto Brick
		public final static Block PlutoBrick = new PlutoBlock(916, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("plutoBrick") .setTextureName("spacecraftpluto:plutoBrick");

		
		//Block Mercury Grass
    	public final static Block MercuryGrass = new MercuryGrass(710, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("MercuryGrass") .setTextureName("spacecraftmercury:grassMercury");

		//Block Mercury Dirt
		public final static Block MercuryDirt = new MercuryDirt(711, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("MercuryDirt") .setTextureName("spacecraftmercury:dirtMercury");
        
		//Block Mercury Stone
		public final static Block MercuryStone = new MercuryStone(712, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryStone") .setTextureName("spacecraftmercury:stoneMercury");

		//Block Mercury Cobblestone
		public final static Block MercuryCobblestone = new MercuryBlock(713, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCobblestone") .setTextureName("spacecraftmercury:cobblestoneMercury");

		//Block Mercury Brick
		public final static Block MercuryBrick = new MercuryBlock(716, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryBrick") .setTextureName("spacecraftmercury:mercuryBrick");

		//Block Mercury Gem Ore
		public final static Block MercuryIridiumOre = new MercuryOre(720, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryIridiumOre") .setTextureName("spacecraftmercury:iridiumOreMercury");

		//Block Mercury Coal Ore
		public final static Block MercuryCoalOre = new MercuryOre(722, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCoalOre") .setTextureName("spacecraftmercury:coalOreMercury");

		//Block Mercury Iron Ore
		public final static Block MercuryTinOre = new MercuryOre(723, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryTinOre") .setTextureName("spacecraftmercury:tinOreMercury");

		//Block Mercury Coal Ore
		public final static Block MercuryCopperOre = new MercuryOre(724, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCopperOre") .setTextureName("spacecraftmercury:copperOreMercury");				

		
		//Block Jupiter Grass
    	public final static Block JupiterLightGas = new JupiterDirt(650, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("lightGas") .setTextureName("spacecraftjupiter:lightGasJupiter");

		//Block Jupiter Dirt
		public final static Block JupiterMediumGas = new JupiterDirt(651, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("mediumGas") .setTextureName("spacecraftjupiter:mediumGasJupiter");
        
		//Block Jupiter Stone
		public final static Block JupiterHeavyGas = new JupiterStone(652, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("heavyGas") .setTextureName("spacecraftjupiter:heavyGasJupiter");

		
        @SidedProxy(clientSide="spacecraft.mods.galacticraft.spacecraftBlocks.client.ClientProxy", serverSide="spacecraft.mods.galacticraft.spacecraftBlocks.CommonProxy")
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
				
                GameRegistry.registerBlock(JupiterLightGas, "JupiterLightGas");
                GameRegistry.registerBlock(JupiterMediumGas, "JupiterMediumGas");
				GameRegistry.registerBlock(JupiterHeavyGas, "JupiterHeavyGas");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        }
}