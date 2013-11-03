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

  public class SpacecraftBlocks 
  {
	  public static Block VenusGrass;
	  public static Block VenusDirt;
	  public static Block VenusStone;
	  public static Block VenusCobblestone;
	  public static Block VenusRedGemBlock;
	  public static Block VenusMeteorBlock;
	  public static Block VenusBrick;
	  public static Block VenusSulferBlock;
	  public static Block VenusSulferOre;
	  public static Block VenusMeteorOre;
	  public static Block VenusRedGemOre;
	  public static Block VenusIronOre;
	  public static Block VenusCoalOre;
	  public static Block VenusTinOre;
	  public static Block VenusCopperOre;
	  public static Block VenusBasalt;
	  public static Block VenusHalfBasalt;
	  
	  public static Block EvolvedBlazeEgg;
	  
	  public static Block PlutoGrass;
	  public static Block PlutoDirt;
	  public static Block PlutoStone;
	  public static Block PlutoCobblestone;
	  public static Block PlutoBrick;
	  
	  public static Block MercuryGrass;
	  public static Block MercuryDirt;
	  public static Block MercuryStone;
	  public static Block MercuryCobblestone;
	  public static Block MercuryBrick;
	  public static Block MercuryIridiumOre;
	  public static Block MercuryCoalOre;
	  public static Block MercuryTinOre;
	  public static Block MercuryCopperOre;
	  
	  public static Block JupiterNitrogen;
	  public static Block JupiterHelium;
	  public static Block JupiterHydrogen;
	  
	  public static Block SaturnNitrogen;
	  public static Block SaturnHelium;
	  public static Block SaturnHydrogen;
	  
	  public static Block UranusNitrogen;
	  public static Block UranusHelium;
	  public static Block UranusHydrogen;
	  
	  public static Block NeptuneNitrogen;
	  public static Block NeptuneHelium;
	  public static Block NeptuneHydrogen;
	  
	  public static Block hydrogenFlowing;
	  public static Block hydrogenStill;
	  
	  public static Block ErisGrass;
	  public static Block ErisDirt;
	  public static Block ErisStone;
	  public static Block ErisCobblestone;
	  public static Block ErisBrick;

	public static void initBlocks()
	{
	//Block Venus Grass
	SpacecraftBlocks.VenusGrass = new StarcraftBlock(610, "VenusGrass") .setTextureName("starcraftvenus:grassVenus") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Dirt
	SpacecraftBlocks.VenusDirt = new StarcraftBlock(611, "VenusDirt") .setTextureName("starcraftvenus:dirtVenus") .setCreativeTab(StarcraftCore.starcraftVenusTab);
    
	//Block Venus Stone
	SpacecraftBlocks.VenusStone = new VenusStone(612, "VenusStone") .setTextureName("starcraftvenus:stoneVenus") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Cobblestone
	SpacecraftBlocks.VenusCobblestone = new StarcraftBlock(613, "VenusCobblestone") .setTextureName("starcraftvenus:cobblestoneVenus") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Gem Block
	SpacecraftBlocks.VenusRedGemBlock = new StarcraftBlock(614, "VenusGem") .setTextureName("starcraftvenus:gemBlock") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Meteor Block
	SpacecraftBlocks.VenusMeteorBlock = new StarcraftBlock(615, "VenusMeteor") .setTextureName("starcraftvenus:meteorBlock") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Brick
	SpacecraftBlocks.VenusBrick = new StarcraftBlock(616, "VenusBrick") .setTextureName("starcraftvenus:venusBrick") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Sulfer
	SpacecraftBlocks.VenusSulferBlock = new StarcraftOre(617, "VenusSulfer") .setTextureName("starcraftvenus:sulferBlock") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Sulfer Ore
	SpacecraftBlocks.VenusSulferOre = new StarcraftOre(618, "VenusSulferOre") .setTextureName("starcraftvenus:sulferOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Meteor Ore
	SpacecraftBlocks.VenusMeteorOre = new StarcraftOre(619, "VenusMeteorOre") .setTextureName("starcraftvenus:meteorOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Gem Ore
	SpacecraftBlocks.VenusRedGemOre = new StarcraftOre(620, "VenusGemOre") .setTextureName("starcraftvenus:gemOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Iron Ore
	SpacecraftBlocks.VenusIronOre = new StarcraftOre(621, "VenusIronOre") .setTextureName("starcraftvenus:ironOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Coal Ore
	SpacecraftBlocks.VenusCoalOre = new StarcraftOre(622, "VenusCoalOre") .setTextureName("starcraftvenus:coalOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Iron Ore
	SpacecraftBlocks.VenusTinOre = new StarcraftOre(623, "VenusTinOre") .setTextureName("starcraftvenus:tinOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);

	//Block Venus Coal Ore
	SpacecraftBlocks.VenusCopperOre = new StarcraftOre(624, "VenusCopperOre") .setTextureName("starcraftvenus:copperOre") .setCreativeTab(StarcraftCore.starcraftVenusTab);				

	//Block Venus Basalt
	SpacecraftBlocks.VenusBasalt = new VenusStone(625, "VenusBasalt") .setTextureName("starcraftvenus:venusBasalt") .setCreativeTab(StarcraftCore.starcraftVenusTab);				

	//Block Venus Half Basalt
	SpacecraftBlocks.VenusHalfBasalt = new VenusHalfSlab(626, "VenusHalfBasalt") .setTextureName("starcraftvenus:venusBasalt") .setCreativeTab(StarcraftCore.starcraftVenusTab);				

	//Block Venus Blaze Egg
	SpacecraftBlocks.EvolvedBlazeEgg = new VenusBlazeEgg(627, 0, "EvolvedBlazeEgg") .setTextureName("starcraftvenus:evolvedBlazeEgg") .setCreativeTab(StarcraftCore.starcraftVenusTab);				

	
	//Block Pluto Grass
	SpacecraftBlocks.PlutoGrass = new StarcraftBlock(910, "grassPluto") .setTextureName("starcraftpluto:grassPluto") .setCreativeTab(StarcraftCore.starcraftPlutoTab);

	//Block Pluto Dirt
	SpacecraftBlocks.PlutoDirt = new StarcraftBlock(911, "dirtPluto") .setTextureName("starcraftpluto:dirtPluto") .setCreativeTab(StarcraftCore.starcraftPlutoTab);
    
	//Block Pluto Stone
	SpacecraftBlocks.PlutoStone = new PlutoStone(912, "stonePluto") .setTextureName("starcraftpluto:stonePluto") .setCreativeTab(StarcraftCore.starcraftPlutoTab);

	//Block Pluto Cobblestone
	SpacecraftBlocks.PlutoCobblestone = new StarcraftBlock(913, "cobblestonePluto") .setTextureName("starcraftpluto:cobblestonePluto") .setCreativeTab(StarcraftCore.starcraftPlutoTab);

	//Block Pluto Brick
	SpacecraftBlocks.PlutoBrick = new StarcraftBlock(916, "plutoBrick") .setTextureName("starcraftpluto:plutoBrick") .setCreativeTab(StarcraftCore.starcraftPlutoTab);

	
	//Block Mercury Grass
	SpacecraftBlocks.MercuryGrass = new StarcraftBlock(710, "MercuryGrass") .setTextureName("starcraftmercury:grassMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Dirt
	SpacecraftBlocks.MercuryDirt = new StarcraftBlock(711, "MercuryDirt") .setTextureName("starcraftmercury:dirtMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);
    
	//Block Mercury Stone
	SpacecraftBlocks.MercuryStone = new MercuryStone(712, "MercuryStone") .setTextureName("starcraftmercury:stoneMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Cobblestone
	SpacecraftBlocks.MercuryCobblestone = new StarcraftBlock(713, "MercuryCobblestone") .setTextureName("starcraftmercury:cobblestoneMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Brick
	SpacecraftBlocks.MercuryBrick = new StarcraftBlock(716, "MercuryBrick") .setTextureName("starcraftmercury:mercuryBrick") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Gem Ore
	SpacecraftBlocks.MercuryIridiumOre = new StarcraftOre(720, "MercuryIridiumOre") .setTextureName("starcraftmercury:iridiumOreMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Coal Ore
	SpacecraftBlocks.MercuryCoalOre = new StarcraftOre(722, "MercuryCoalOre") .setTextureName("starcraftmercury:coalOreMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Iron Ore
	SpacecraftBlocks.MercuryTinOre = new StarcraftOre(723, "MercuryTinOre") .setTextureName("starcraftmercury:tinOreMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);

	//Block Mercury Coal Ore
	SpacecraftBlocks.MercuryCopperOre = new StarcraftOre(724, "MercuryCopperOre") .setTextureName("starcraftmercury:copperOreMercury") .setCreativeTab(StarcraftCore.starcraftMercuryTab);			

	
	//Block Jupiter Nitrogen
	SpacecraftBlocks.JupiterNitrogen = new StarcraftGasTop(650, "jupiterNitrogen") .setTextureName("starcraftjupiter:jupiterNitrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

	//Block Jupiter Helium
	SpacecraftBlocks.JupiterHelium = new StarcraftGasBottom(651, "jupiterHelium") .setTextureName("starcraftjupiter:jupiterHelium") .setCreativeTab(StarcraftCore.starcraftGasTab);

	//Block Jupiter Hydrogen
	SpacecraftBlocks.JupiterHydrogen = new StarcraftGasBottom(652, "jupiterHydrogen") .setTextureName("starcraftjupiter:jupiterHydrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);
  

	//Block Saturn Grass
	SpacecraftBlocks.SaturnNitrogen = new StarcraftGasTop(653, "saturnNitrogen") .setTextureName("starcraftsaturn:saturnNitrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

	//Block Saturn Dirt
	SpacecraftBlocks.SaturnHelium = new StarcraftGasBottom(654, "saturnHelium") .setTextureName("starcraftsaturn:saturnHelium") .setCreativeTab(StarcraftCore.starcraftGasTab);
    
	//Block Saturn Stone
	SpacecraftBlocks.SaturnHydrogen = new StarcraftGasBottom(655, "saturnHydrogen") .setTextureName("starcraftsaturn:saturnHydrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

	
	//Block Uranus Grass
	SpacecraftBlocks.UranusNitrogen = new StarcraftGasTop(656, "uranusNitrogen") .setTextureName("starcrafturanus:uranusNitrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

	//Block Uranus Dirt
	SpacecraftBlocks.UranusHelium = new StarcraftGasBottom(657, "uranusHelium") .setTextureName("starcrafturanus:uranusHelium") .setCreativeTab(StarcraftCore.starcraftGasTab);
    
	//Block Uranus Stone
	SpacecraftBlocks.UranusHydrogen = new StarcraftGasBottom(658, "uranusHydrogen") .setTextureName("starcrafturanus:uranusHydrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

	
	//Block Neptune Grass
	SpacecraftBlocks.NeptuneNitrogen = new StarcraftGasTop(659, "neptuneNitrogen") .setTextureName("starcraftneptune:neptuneNitrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

	//Block Neptune Dirt
	SpacecraftBlocks.NeptuneHelium = new StarcraftGasBottom(660, "neptuneHelium") .setTextureName("starcraftneptune:neptuneHelium") .setCreativeTab(StarcraftCore.starcraftGasTab);
    
	//Block Neptune Stone
	SpacecraftBlocks.NeptuneHydrogen = new StarcraftGasBottom(661, "neptuneHydrogen") .setTextureName("starcraftneptune:neptuneHydrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);
	
	
    //Fluid Metallic Hydrogen
    SpacecraftBlocks.hydrogenFlowing = new StarcraftMetallicHydrogenFlowing(920, "MetallicHydrogenFlowing") .setCreativeTab(StarcraftCore.starcraftGasTab);
    SpacecraftBlocks.hydrogenStill = new StarcraftMetallicHydrogenStill(921, "MetallicHydrogenStill") .setCreativeTab(StarcraftCore.starcraftGasTab);

    //Block Eris Grass
  	SpacecraftBlocks.ErisGrass = new StarcraftBlock(922, "grassEris") .setTextureName("starcrafteris:grassEris") .setCreativeTab(StarcraftCore.starcraftErisTab);

  	//Block Pluto Dirt
  	SpacecraftBlocks.ErisDirt = new StarcraftBlock(923, "dirtEris") .setTextureName("starcrafteris:dirtEris") .setCreativeTab(StarcraftCore.starcraftErisTab);
      
  	//Block Eris Stone
  	SpacecraftBlocks.ErisStone = new PlutoStone(924, "stoneEris") .setTextureName("starcrafteris:stoneEris") .setCreativeTab(StarcraftCore.starcraftErisTab);

  	//Block Eris Cobblestone
  	SpacecraftBlocks.ErisCobblestone = new StarcraftBlock(925, "cobblestoneEris") .setTextureName("starcrafteris:cobblestoneEris") .setCreativeTab(StarcraftCore.starcraftErisTab);

  	//Block Eris Brick
  	SpacecraftBlocks.ErisBrick = new StarcraftBlock(926, "erisBrick") .setTextureName("starcrafteris:erisBrick") .setCreativeTab(StarcraftCore.starcraftErisTab);
	}
	    @Instance("SpacecraftBlocks")
        public static SpacecraftBlocks instance;

        @SidedProxy(clientSide="mattparks.mods.starcraft.spacecraftBlocks.client.ClientProxy", serverSide="mattparks.mods.starcraft.spacecraftBlocks.CommonProxy")
        public static CommonProxy proxy;

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
				
	            GameRegistry.registerBlock(hydrogenFlowing, "MetallicHydrogenFlowing");
//				GameRegistry.registerBlock(hydrogenStill, "MetallicHydrogenStill");
	            
                GameRegistry.registerBlock(ErisGrass, "ErisGrass");
                GameRegistry.registerBlock(ErisDirt, "ErisDirt");
				GameRegistry.registerBlock(ErisStone, "ErisStone");
				GameRegistry.registerBlock(ErisCobblestone, "ErisCobblestone");
				GameRegistry.registerBlock(ErisBrick, "ErisBrick");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        }
}
