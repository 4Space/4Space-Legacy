package mattparks.mods.starcraft.spacecraftBlocks;

import java.io.File;

import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.mercury.GCMercury;
import mattparks.mods.starcraft.spacecraftBlocks.block.*;
import mattparks.mods.starcraft.venus.GCVenus;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
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

            //Block Core, Gravity Generator
        public final static Block gravityGenerator = new StarcraftBlock(9862, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("GravityGenerator") .setTextureName("starcraftcore:GravityGenerator") .setCreativeTab(StarcraftCore.starcraftCoreTab);
    	
           //Block Core, Caravan Module
    	public final static Block caravanModule = new StarcraftCaravanModule(927, null).setHardness(0.4F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("caravanModule").setTextureName("starcraftcore:caravanModule");
    
    	//Block Core, Caravan Module Part
    	public final static Block caravanModulePart = new StarcraftBlock(928, null).setHardness(1000000.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("caravanModulePart").setTextureName("starcraftcore:caravanModulePart").setBlockUnbreakable();
    
    	
        //Block Venus, Grass
        public final static Block VenusGrass = new StarcraftGrass(610, null) .setHardness(0.4F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGrass") .setTextureName("starcraftvenus:grassVenus") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Dirt
        public final static Block VenusDirt = new StarcraftBlock(611, null) .setHardness(0.3F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusDirt") .setTextureName("starcraftvenus:dirtVenus") .setCreativeTab(GCVenus.starcraftVenusTab);
    
        //Block Venus, Stone
        public final static Block VenusStone = new VenusStone(612, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusStone") .setTextureName("starcraftvenus:stoneVenus") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Cobblestone
        public final static Block VenusCobblestone = new StarcraftBlock(613, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCobblestone") .setTextureName("starcraftvenus:cobblestoneVenus") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Gem Block
        public final static Block VenusRedGemBlock = new StarcraftBlock(614, null) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGem") .setTextureName("starcraftvenus:gemBlock") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Meteor Block
        public final static Block VenusMeteorBlock = new StarcraftBlock(615, null) .setHardness(3.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteor") .setTextureName("starcraftvenus:meteorBlock") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Brick
        public final static Block VenusBrick = new StarcraftBlock(616, null) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBrick") .setTextureName("starcraftvenus:venusBrick") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Sulfer
        public final static Block VenusSulferBlock = new StarcraftOre(617, null) .setHardness(2.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulfer") .setTextureName("starcraftvenus:sulferBlock") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Sulfer Ore
        public final static Block VenusSulferOre = new StarcraftOre(618, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusSulferOre") .setTextureName("starcraftvenus:sulferOre") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Meteor Ore
        public final static Block VenusMeteorOre = new StarcraftOre(619, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusMeteorOre") .setTextureName("starcraftvenus:meteorOre") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Gem Ore
        public final static Block VenusRedGemOre = new StarcraftOre(620, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusGemOre") .setTextureName("starcraftvenus:gemOre") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Iron Ore
        public final static Block VenusIronOre = new StarcraftOre(621, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusIronOre") .setTextureName("starcraftvenus:ironOre") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Coal Ore
        public final static Block VenusCoalOre = new StarcraftOre(622, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCoalOre") .setTextureName("starcraftvenus:coalOre") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Iron Ore
        public final static Block VenusTinOre = new StarcraftOre(623, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusTinOre") .setTextureName("starcraftvenus:tinOre") .setCreativeTab(GCVenus.starcraftVenusTab);

        //Block Venus, Coal Ore
        public final static Block VenusCopperOre = new StarcraftOre(624, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusCopperOre") .setTextureName("starcraftvenus:copperOre") .setCreativeTab(GCVenus.starcraftVenusTab);                                

        //Block Venus, Basalt
        public final static Block VenusBasalt = new StarcraftBlock(625, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusBasalt") .setTextureName("starcraftvenus:venusBasalt") .setCreativeTab(GCVenus.starcraftVenusTab);                                

        //Block Venus, Half Basalt
        public final static Block VenusHalfBasalt = new StarcraftHalfSlab(626, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusHalfBasalt") .setTextureName("starcraftvenus:venusBasalt") .setCreativeTab(GCVenus.starcraftVenusTab);                                

        //Block Venus, Blaze Egg
        public final static Block EvolvedBlazeEgg = new StarcraftEgg(627, 0, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("EvolvedBlazeEgg") .setTextureName("starcraftvenus:evolvedBlazeEgg") .setCreativeTab(GCVenus.starcraftVenusTab);                                

        //Block Venus, Toxic Sludge
//        public final static Block ToxicSludge = new StarcraftToxicSludge(1024, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("VenusToxicSludge") .setTextureName("starcraftvenus:toxicSludge") .setCreativeTab(GCVenus.starcraftVenusTab);                                
// TODO finish Venus Toxic Sludge
        
        //Block Pluto, Grass
        public final static Block PlutoGrass = new StarcraftGrass(910, null) .setHardness(0.4F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("grassPluto") .setTextureName("starcraftpluto:grassPluto") .setCreativeTab(StarcraftCore.starcraftPlutoTab);

        //Block Pluto, Dirt
        public final static Block PlutoDirt = new StarcraftBlock(911, null) .setHardness(0.3F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("dirtPluto") .setTextureName("starcraftpluto:dirtPluto") .setCreativeTab(StarcraftCore.starcraftPlutoTab);
    
        //Block Pluto, Stone
        public final static Block PlutoStone = new PlutoStone(912, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("stonePluto") .setTextureName("starcraftpluto:stonePluto") .setCreativeTab(StarcraftCore.starcraftPlutoTab);

        //Block Pluto, Cobblestone
        public final static Block PlutoCobblestone = new StarcraftBlock(913, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("cobblestonePluto") .setTextureName("starcraftpluto:cobblestonePluto") .setCreativeTab(StarcraftCore.starcraftPlutoTab);

        //Block Pluto, Brick
        public final static Block PlutoBrick = new StarcraftBlock(916, null) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("plutoBrick") .setTextureName("starcraftpluto:plutoBrick") .setCreativeTab(StarcraftCore.starcraftPlutoTab);

        
        //Block Mercury, Grass
        public final static Block MercuryGrass = new StarcraftGrass(710, null) .setHardness(0.4F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryGrass") .setTextureName("starcraftmercury:grassMercury") .setCreativeTab(GCMercury.starcraftMercuryTab);

        //Block Mercury, Dirt
        public final static Block MercuryDirt = new StarcraftBlock(711, null) .setHardness(0.3F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryDirt") .setTextureName("starcraftmercury:dirtMercury") .setCreativeTab(GCMercury.starcraftMercuryTab);
    
        //Block Mercury, Stone
        public final static Block MercuryStone = new MercuryStone(712, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryStone") .setTextureName("starcraftmercury:stoneMercury") .setCreativeTab(GCMercury.starcraftMercuryTab);

        //Block Mercury, Cobblestone
        public final static Block MercuryCobblestone = new StarcraftBlock(713, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCobblestone") .setTextureName("starcraftmercury:cobblestoneMercury") .setCreativeTab(GCMercury.starcraftMercuryTab);

        //Block Mercury, Brick
        public final static Block MercuryBrick = new StarcraftBlock(716, null) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryBrick") .setTextureName("starcraftmercury:mercuryBrick") .setCreativeTab(GCMercury.starcraftMercuryTab);

        //Block Mercury, Gem Ore
        public final static Block MercuryIridiumOre = new StarcraftOre(720, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryIridiumOre") .setTextureName("starcraftmercury:iridiumOreMercury") .setCreativeTab(GCMercury.starcraftMercuryTab);

        //Block Mercury, Coal Ore
        public final static Block MercuryCoalOre = new StarcraftOre(722, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCoalOre") .setTextureName("starcraftmercury:coalOreMercury") .setCreativeTab(GCMercury.starcraftMercuryTab);

        //Block Mercury, Iron Ore
        public final static Block MercuryTinOre = new StarcraftOre(723, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryTinOre") .setTextureName("starcraftmercury:tinOreMercury") .setCreativeTab(GCMercury.starcraftMercuryTab);

        //Block Mercury, Coal Ore
        public final static Block MercuryCopperOre = new StarcraftOre(724, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("MercuryCopperOre") .setTextureName("starcraftmercury:copperOreMercury") .setCreativeTab(GCMercury.starcraftMercuryTab);                        

        
        //Block Jupiter, Nitrogen
        public final static Block JupiterNitrogen = new StarcraftGasTop(650, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("jupiterNitrogen") .setTextureName("starcraftjupiter:jupiterNitrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

        //Block Jupiter, Helium
        public final static Block JupiterHelium = new StarcraftGasBottom(651, null) .setHardness(0.4F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("jupiterHelium") .setTextureName("starcraftjupiter:jupiterHelium") .setCreativeTab(StarcraftCore.starcraftGasTab);

        //Block Jupiter, Hydrogen
        public final static Block JupiterHydrogen = new StarcraftGasBottom(652, null) .setHardness(0.3F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("jupiterHydrogen") .setTextureName("starcraftjupiter:jupiterHydrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

        //Block Jupiter, Brick
        public final static Block JupiterBrick = new StarcraftBlock(637, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("jupiterBrick") .setTextureName("starcraftjupiter:jupiterBrick") .setCreativeTab(StarcraftCore.starcraftGasTab);


        //Block Saturn, Nitrogen
        public final static Block SaturnNitrogen = new StarcraftGasTop(653, null) .setHardness(0.4F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("saturnNitrogen") .setTextureName("starcraftsaturn:saturnNitrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

        //Block Saturn, Helium
        public final static Block SaturnHelium = new StarcraftGasBottom(654, null) .setHardness(0.3F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("saturnHelium") .setTextureName("starcraftsaturn:saturnHelium") .setCreativeTab(StarcraftCore.starcraftGasTab);
    
        //Block Saturn, Hydrogen
        public final static Block SaturnHydrogen = new StarcraftGasBottom(655, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("saturnHydrogen") .setTextureName("starcraftsaturn:saturnHydrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

        //Block Saturn, Brick
        public final static Block SaturnBrick = new StarcraftBlock(628, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("saturnBrick") .setTextureName("starcraftsaturn:saturnBrick") .setCreativeTab(StarcraftCore.starcraftGasTab);

        
        //Block Uranus Nitrogen
        public final static Block UranusNitrogen = new StarcraftGasTop(656, null) .setHardness(0.4F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("uranusNitrogen") .setTextureName("starcrafturanus:uranusNitrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

        //Block Uranus Helium
        public final static Block UranusHelium = new StarcraftGasBottom(657, null) .setHardness(0.3F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("uranusHelium") .setTextureName("starcrafturanus:uranusHelium") .setCreativeTab(StarcraftCore.starcraftGasTab);
    
        //Block Uranus Hydrogen
        public final static Block UranusHydrogen = new StarcraftGasBottom(658, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("uranusHydrogen") .setTextureName("starcrafturanus:uranusHydrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

        //Block Uranus Brick
        public final static Block UranusBrick = new StarcraftBlock(629, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("uranusBrick") .setTextureName("starcrafturanus:uranusBrick") .setCreativeTab(StarcraftCore.starcraftGasTab);

        
        //Block Neptune Nitrogen
        public final static Block NeptuneNitrogen = new StarcraftGasTop(659, null) .setHardness(0.4F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("neptuneNitrogen") .setTextureName("starcraftneptune:neptuneNitrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

        //Block Neptune Helium
        public final static Block NeptuneHelium = new StarcraftGasBottom(660, null) .setHardness(0.3F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("neptuneHelium") .setTextureName("starcraftneptune:neptuneHelium") .setCreativeTab(StarcraftCore.starcraftGasTab);
    
        //Block Neptune Hydrogen
        public final static Block NeptuneHydrogen = new StarcraftGasBottom(661, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("neptuneHydrogen") .setTextureName("starcraftneptune:neptuneHydrogen") .setCreativeTab(StarcraftCore.starcraftGasTab);

        //Block Neptune Brick
        public final static Block NeptuneBrick = new StarcraftBlock(630, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("neptuneBrick") .setTextureName("starcraftneptune:neptuneBrick") .setCreativeTab(StarcraftCore.starcraftGasTab);

        
        //Fluid Metallic Hydrogen
        public final static Block hydrogenFlowing = new StarcraftMetallicHydrogenFlowing(920, null).setUnlocalizedName("MetallicHydrogenFlowing") .setCreativeTab(StarcraftCore.starcraftGasTab);
        public final static Block hydrogenStill = new StarcraftMetallicHydrogenStill(921, null).setUnlocalizedName("MetallicHydrogenStill") .setCreativeTab(StarcraftCore.starcraftGasTab);

        //Block Eris Grass
        public final static Block ErisGrass = new StarcraftGrass(922, null) .setHardness(0.4F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("grassEris") .setTextureName("starcrafteris:grassEris") .setCreativeTab(StarcraftCore.starcraftErisTab);

        //Block Pluto Dirt
        public final static Block ErisDirt = new StarcraftBlock(923, null) .setHardness(0.3F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("dirtEris") .setTextureName("starcrafteris:dirtEris") .setCreativeTab(StarcraftCore.starcraftErisTab);
      
        //Block Eris Stone
        public final static Block ErisStone = new PlutoStone(924, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("stoneEris") .setTextureName("starcrafteris:stoneEris") .setCreativeTab(StarcraftCore.starcraftErisTab);

        //Block Eris Cobblestone
        public final static Block ErisCobblestone = new StarcraftBlock(925, null) .setHardness(1.5F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("cobblestoneEris") .setTextureName("starcrafteris:cobblestoneEris") .setCreativeTab(StarcraftCore.starcraftErisTab);

        //Block Eris Brick
        public final static Block ErisBrick = new StarcraftBlock(926, null) .setHardness(12.0F).setStepSound(Block.soundStoneFootstep) .setUnlocalizedName("erisBrick") .setTextureName("starcrafteris:erisBrick") .setCreativeTab(StarcraftCore.starcraftErisTab);

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
                GameRegistry.registerBlock(SpacecraftBlocks.gravityGenerator, "GravityGenerator");
                GameRegistry.registerBlock(SpacecraftBlocks.caravanModule, "CaravanModule");
                GameRegistry.registerBlock(SpacecraftBlocks.caravanModulePart, "CaravanModulePart");
                
                GameRegistry.registerBlock(SpacecraftBlocks.VenusGrass, "VenusGrass");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusDirt, "VenusDirt");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusStone, "VenusStone");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusCobblestone, "VenusCobblestone");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusRedGemBlock, "VenusRedGemBlock");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusMeteorBlock, "VenusMeteorBlock");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusBrick, "VenusBrick");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusSulferBlock, "VenusSulferBlock");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusRedGemOre, "VenusRedGemOre");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusMeteorOre, "VenusMeteorOre");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusSulferOre, "VenusSulferOre");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusIronOre, "VenusIronOre");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusCoalOre, "VenusCoalOre");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusTinOre, "VenusTinOre");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusCopperOre, "VenusCopperOre");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusBasalt, "VenusBasalt");
                GameRegistry.registerBlock(SpacecraftBlocks.VenusHalfBasalt, "VenusHalfBasalt");
                GameRegistry.registerBlock(SpacecraftBlocks.EvolvedBlazeEgg, "EvolvedBlazeEgg");
//                GameRegistry.registerBlock(SpacecraftBlocks.ToxicSludge, "ToxicSludge");
                                
                GameRegistry.registerBlock(SpacecraftBlocks.PlutoGrass, "PlutoGrass");
                GameRegistry.registerBlock(SpacecraftBlocks.PlutoDirt, "PlutoDirt");
                GameRegistry.registerBlock(SpacecraftBlocks.PlutoStone, "PlutoStone");
                GameRegistry.registerBlock(SpacecraftBlocks.PlutoCobblestone, "PlutoCobblestone");
                GameRegistry.registerBlock(SpacecraftBlocks.PlutoBrick, "PlutoBrick");
                                
                GameRegistry.registerBlock(SpacecraftBlocks.MercuryGrass, "MercuryGrass");
                GameRegistry.registerBlock(SpacecraftBlocks.MercuryDirt, "MercuryDirt");
                GameRegistry.registerBlock(SpacecraftBlocks.MercuryStone, "MercuryStone");
                GameRegistry.registerBlock(SpacecraftBlocks.MercuryCobblestone, "MercuryCobblestone");
                GameRegistry.registerBlock(SpacecraftBlocks.MercuryBrick, "MercuryBrick");
                GameRegistry.registerBlock(SpacecraftBlocks.MercuryIridiumOre, "MercuryIridiumOre");
                GameRegistry.registerBlock(SpacecraftBlocks.MercuryCoalOre, "MercuryCoalOre");
                GameRegistry.registerBlock(SpacecraftBlocks.MercuryTinOre, "MercuryTinOre");
                GameRegistry.registerBlock(SpacecraftBlocks.MercuryCopperOre, "MercuryCopperOre");
                                
                GameRegistry.registerBlock(SpacecraftBlocks.JupiterNitrogen, "JupiterNitrogen");
                GameRegistry.registerBlock(SpacecraftBlocks.JupiterHelium, "JupiterHelium");
                GameRegistry.registerBlock(SpacecraftBlocks.JupiterHydrogen, "JupiterHydrogen");
                GameRegistry.registerBlock(SpacecraftBlocks.JupiterBrick, "JupiterBrick");       
                
                GameRegistry.registerBlock(SpacecraftBlocks.SaturnNitrogen, "SaturnNitrogen");
                GameRegistry.registerBlock(SpacecraftBlocks.SaturnHelium, "SaturnHelium");
                GameRegistry.registerBlock(SpacecraftBlocks.SaturnHydrogen, "SaturnHydrogen");
                GameRegistry.registerBlock(SpacecraftBlocks.SaturnBrick, "SaturnBrick");
                
                GameRegistry.registerBlock(SpacecraftBlocks.UranusNitrogen, "UranusNitrogen");
                GameRegistry.registerBlock(SpacecraftBlocks.UranusHelium, "UranusHelium");
                GameRegistry.registerBlock(SpacecraftBlocks.UranusHydrogen, "UranusHydrogen");
                GameRegistry.registerBlock(SpacecraftBlocks.UranusBrick, "UranusBrick");
                                        
                GameRegistry.registerBlock(SpacecraftBlocks.NeptuneNitrogen, "NeptuneNitrogen");
                GameRegistry.registerBlock(SpacecraftBlocks.NeptuneHelium, "NeptuneHelium");
                GameRegistry.registerBlock(SpacecraftBlocks.NeptuneHydrogen, "NeptuneHydrogen");
                GameRegistry.registerBlock(SpacecraftBlocks.NeptuneBrick, "NeptuneBrick");
                
                GameRegistry.registerBlock(SpacecraftBlocks.hydrogenFlowing, "MetallicHydrogenFlowing");
//              GameRegistry.registerBlock(SpacecraftBlocks.hydrogenStill, "MetallicHydrogenStill");
                    
                GameRegistry.registerBlock(SpacecraftBlocks.ErisGrass, "ErisGrass");
                GameRegistry.registerBlock(SpacecraftBlocks.ErisDirt, "ErisDirt");
                GameRegistry.registerBlock(SpacecraftBlocks.ErisStone, "ErisStone");
                GameRegistry.registerBlock(SpacecraftBlocks.ErisCobblestone, "ErisCobblestone");
                GameRegistry.registerBlock(SpacecraftBlocks.ErisBrick, "ErisBrick");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
                ;
        }
}
