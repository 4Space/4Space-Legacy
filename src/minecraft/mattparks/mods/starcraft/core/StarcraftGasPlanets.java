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

public class StarcraftGasPlanets 
{
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
	
	// Block Jupiter, Clear Diamond Block
	public static final Block ClearDiamondBlock = new StarcraftBlock(638, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("ClearDiamondBlock")
			.setTextureName("starcraftjupiter:clearDiamondBlock")
			.setCreativeTab(GCJupiter.starcraftGasTab);

	
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

	
        @Instance(value = "StarcraftGasPlanets")
        public static StarcraftGasPlanets instance;
        
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
                GameRegistry.registerBlock(StarcraftGasPlanets.JupiterNitrogen, "JupiterNitrogen");
                GameRegistry.registerBlock(StarcraftGasPlanets.JupiterHelium, "JupiterHelium");
                GameRegistry.registerBlock(StarcraftGasPlanets.JupiterHydrogen, "JupiterHydrogen");
                GameRegistry.registerBlock(StarcraftGasPlanets.JupiterBrick, "JupiterBrick");    
                GameRegistry.registerBlock(StarcraftGasPlanets.ClearDiamondBlock, "ClearDiamondBlock");
                
                GameRegistry.registerBlock(StarcraftGasPlanets.hydrogenFlowing, "MetallicHydrogenFlowing");
//              GameRegistry.registerBlock(StarcraftCore2.hydrogenStill, "MetallicHydrogenStill");
                
                GameRegistry.registerBlock(StarcraftGasPlanets.SaturnNitrogen, "SaturnNitrogen");
                GameRegistry.registerBlock(StarcraftGasPlanets.SaturnHelium, "SaturnHelium");
                GameRegistry.registerBlock(StarcraftGasPlanets.SaturnHydrogen, "SaturnHydrogen");
                GameRegistry.registerBlock(StarcraftGasPlanets.SaturnBrick, "SaturnBrick");
                
                GameRegistry.registerBlock(StarcraftGasPlanets.UranusNitrogen, "UranusNitrogen");
                GameRegistry.registerBlock(StarcraftGasPlanets.UranusHelium, "UranusHelium");
                GameRegistry.registerBlock(StarcraftGasPlanets.UranusHydrogen, "UranusHydrogen");
                GameRegistry.registerBlock(StarcraftGasPlanets.UranusBrick, "UranusBrick");
                                        
                GameRegistry.registerBlock(StarcraftGasPlanets.NeptuneNitrogen, "NeptuneNitrogen");
                GameRegistry.registerBlock(StarcraftGasPlanets.NeptuneHelium, "NeptuneHelium");
                GameRegistry.registerBlock(StarcraftGasPlanets.NeptuneHydrogen, "NeptuneHydrogen");
                GameRegistry.registerBlock(StarcraftGasPlanets.NeptuneBrick, "NeptuneBrick");                    
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        }
}