package mattparks.mods.starcraft.spacecraftBlocks;

import java.io.File;

import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.spacecraftBlocks.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="StarcraftBlocks", name="Starcraft Blocks", version="0.0.1", dependencies = "required-after:Forge@[9.10.0.789,)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
  public class SpacecraftBlocks 
  {
    public static final String CHANNEL = "StarcraftBlocks";
    public static final String FILE_PATH = "/mattparks/mods/starcraft/spacecraftBlocks/";
    public static final String CLIENT_PATH = "client/";
    public static final String CONFIG_FILE = "starcraft/starcraftBlocks.conf";
    
	//Block Venus Grass
	public final static Block VenusGrass = new StarcraftDirt(610, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("VenusGrass") .setTextureName("starcraftvenus:grassVenus") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Dirt
	public final static Block VenusDirt = new StarcraftDirt(611, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("VenusDirt") .setTextureName("starcraftvenus:dirtVenus") .setCreativeTab(StarcraftCore.starcraftVenusTab);
    
	//Block Venus Stone
	public final static Block VenusStone = new VenusStone(612, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusStone") .setTextureName("starcraftvenus:stoneVenus") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Cobblestone
	public final static Block VenusCobblestone = new StarcraftBlock(613, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCobblestone") .setTextureName("starcraftvenus:cobblestoneVenus") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Gem Block
	public final static Block VenusRedGemBlock = new StarcraftBlock(614, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGem") .setTextureName("starcraftvenus:gemBlock") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Meteor Block
	public final static Block VenusMeteorBlock = new StarcraftBlock(615, Material.rock) .setHardness(3.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteor") .setTextureName("starcraftvenus:meteorBlock") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Brick
	public final static Block VenusBrick = new StarcraftBlock(616, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBrick") .setTextureName("starcraftvenus:venusBrick") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Sulfer
	public final static Block VenusSulferBlock = new StarcraftOre(617, Material.rock) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulfer") .setTextureName("starcraftvenus:sulferBlock") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Sulfer Ore
	public final static Block VenusSulferOre = new StarcraftOre(618, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulferOre") .setTextureName("starcraftvenus:sulferOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Meteor Ore
	public final static Block VenusMeteorOre = new StarcraftOre(619, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteorOre") .setTextureName("starcraftvenus:meteorOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Gem Ore
	public final static Block VenusRedGemOre = new StarcraftOre(620, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGemOre") .setTextureName("starcraftvenus:gemOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Iron Ore
	public final static Block VenusIronOre = new StarcraftOre(621, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusIronOre") .setTextureName("starcraftvenus:ironOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Coal Ore
	public final static Block VenusCoalOre = new StarcraftOre(622, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCoalOre") .setTextureName("starcraftvenus:coalOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Iron Ore
	public final static Block VenusTinOre = new StarcraftOre(623, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusTinOre") .setTextureName("starcraftvenus:tinOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Coal Ore
	public final static Block VenusCopperOre = new StarcraftOre(624, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCopperOre") .setTextureName("starcraftvenus:copperOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);				

	//Block Venus Basalt
	public final static Block VenusBasalt = new VenusStone(625, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBasalt") .setTextureName("starcraftvenus:venusBasalt") .setCreativeTab(StarcraftCore.starcraftVenusTab);				

	//Block Venus Half Basalt
	public final static Block VenusHalfBasalt = new VenusHalfSlab(626, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusHalfBasalt") .setTextureName("starcraftvenus:venusBasalt") .setCreativeTab(StarcraftCore.starcraftVenusTab);				

	//Block Venus Blaze Egg
	public final static Block EvolvedBlazeEgg = new VenusBlazeEgg(627) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("EvolvedBlazeEgg") .setTextureName("starcraftvenus:evolvedBlazeEgg") .setCreativeTab(StarcraftCore.starcraftVenusTab);				

	
	//Block Pluto Grass
	public final static Block PlutoGrass = new StarcraftDirt(910, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("grassPluto") .setTextureName("starcraftpluto:grassPluto") .setCreativeTab(StarcraftCore.starcraftPlutoTab);

	//Block Pluto Dirt
	public final static Block PlutoDirt = new StarcraftDirt(911, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("dirtPluto") .setTextureName("starcraftpluto:dirtPluto") .setCreativeTab(StarcraftCore.starcraftPlutoTab);
    
	//Block Pluto Stone
	public final static Block PlutoStone = new PlutoStone(912, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("stonePluto") .setTextureName("starcraftpluto:stonePluto") .setCreativeTab(StarcraftCore.starcraftPlutoTab);

	//Block Pluto Cobblestone
	public final static Block PlutoCobblestone = new StarcraftBlock(913, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("cobblestonePluto") .setTextureName("starcraftpluto:cobblestonePluto") .setCreativeTab(StarcraftCore.starcraftPlutoTab);

	//Block Pluto Brick
	public final static Block PlutoBrick = new StarcraftBlock(916, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("plutoBrick") .setTextureName("starcraftpluto:plutoBrick") .setCreativeTab(StarcraftCore.starcraftPlutoTab);

	
	//Block Mercury Grass
	public final static Block MercuryGrass = new StarcraftDirt(710, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("MercuryGrass") .setTextureName("starcraftmercury:grassMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Dirt
	public final static Block MercuryDirt = new StarcraftDirt(711, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("MercuryDirt") .setTextureName("starcraftmercury:dirtMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);
    
	//Block Mercury Stone
	public final static Block MercuryStone = new MercuryStone(712, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryStone") .setTextureName("starcraftmercury:stoneMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Cobblestone
	public final static Block MercuryCobblestone = new StarcraftBlock(713, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCobblestone") .setTextureName("starcraftmercury:cobblestoneMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Brick
	public final static Block MercuryBrick = new StarcraftBlock(716, Material.rock) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryBrick") .setTextureName("starcraftmercury:mercuryBrick") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Gem Ore
	public final static Block MercuryIridiumOre = new StarcraftOre(720, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryIridiumOre") .setTextureName("starcraftmercury:iridiumOreMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Coal Ore
	public final static Block MercuryCoalOre = new StarcraftOre(722, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCoalOre") .setTextureName("starcraftmercury:coalOreMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Iron Ore
	public final static Block MercuryTinOre = new StarcraftOre(723, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryTinOre") .setTextureName("starcraftmercury:tinOreMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Coal Ore
	public final static Block MercuryCopperOre = new StarcraftOre(724, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCopperOre") .setTextureName("starcraftmercury:copperOreMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);			

	
	//Block Jupiter Nitrogen
	public final static Block JupiterNitrogen = new StarcraftGasTop(650, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("jupiterNitrogen") .setTextureName("starcraftjupiter:jupiterNitrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

	//Block Jupiter Helium
	public final static Block JupiterHelium = new StarcraftGasBottom(651, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("jupiterHelium") .setTextureName("starcraftjupiter:jupiterHelium") .setCreativeTab(StarcraftCore.starcraftGasTab);

	//Block Jupiter Hydrogen
	public final static Block JupiterHydrogen = new StarcraftGasBottom(652, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("jupiterHydrogen") .setTextureName("starcraftjupiter:jupiterHydrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);
  

	//Block Saturn Grass
	public final static Block SaturnNitrogen = new StarcraftGasTop(653, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("saturnNitrogen") .setTextureName("starcraftsaturn:saturnNitrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

	//Block Saturn Dirt
	public final static Block SaturnHelium = new StarcraftGasBottom(654, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("saturnHelium") .setTextureName("starcraftsaturn:saturnHelium") .setCreativeTab(StarcraftCore.starcraftGasTab);
    
	//Block Saturn Stone
	public final static Block SaturnHydrogen = new StarcraftGasBottom(655, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("saturnHydrogen") .setTextureName("starcraftsaturn:saturnHydrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

	
	//Block Uranus Grass
	public final static Block UranusNitrogen = new StarcraftGasTop(656, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("uranusNitrogen") .setTextureName("starcrafturanus:uranusNitrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

	//Block Uranus Dirt
	public final static Block UranusHelium = new StarcraftGasBottom(657, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("uranusHelium") .setTextureName("starcrafturanus:uranusHelium") .setCreativeTab(StarcraftCore.starcraftGasTab);
    
	//Block Uranus Stone
	public final static Block UranusHydrogen = new StarcraftGasBottom(658, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("uranusHydrogen") .setTextureName("starcrafturanus:uranusHydrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

	
	//Block Neptune Grass
	public final static Block NeptuneNitrogen = new StarcraftGasTop(659, Material.grass) .setHardness(0.4F).setStepSound(Block.soundGrassFootstep) .setUnlocalizedName("neptuneNitrogen") .setTextureName("starcraftneptune:neptuneNitrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

	//Block Neptune Dirt
	public final static Block NeptuneHelium = new StarcraftGasBottom(660, Material.grass) .setHardness(0.3F).setStepSound(Block.soundGravelFootstep) .setUnlocalizedName("neptuneHelium") .setTextureName("starcraftneptune:neptuneHelium") .setCreativeTab(StarcraftCore.starcraftGasTab);
    
	//Block Neptune Stone
	public final static Block NeptuneHydrogen = new StarcraftGasBottom(661, Material.rock) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("neptuneHydrogen") .setTextureName("starcraftneptune:neptuneHydrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);
	
	
    //Fluid Metallic Hydrogen
    public final static Block MetallicHydrogenFlowing = new StarcraftMetallicHydrogenFlowing(920).setUnlocalizedName("MetallicHydrogenFlowing") .setCreativeTab(StarcraftCore.starcraftGasTab);
    public final static Block MetallicHydrogenStill = new StarcraftMetallicHydrogenStill(921).setUnlocalizedName("MetallicHydrogenStill") .setCreativeTab(StarcraftCore.starcraftGasTab);
    
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
				
	            GameRegistry.registerBlock(MetallicHydrogenFlowing, "MetallicHydrogenFlowing");
//				GameRegistry.registerBlock(MetallicHydrogenStill, "MetallicHydrogenStill");

        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        }
}
