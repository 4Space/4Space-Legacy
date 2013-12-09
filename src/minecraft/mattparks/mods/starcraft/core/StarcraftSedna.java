package mattparks.mods.starcraft.core;

import mattparks.mods.starcraft.core.CommonProxy;
import mattparks.mods.starcraft.core.StarcraftCore;
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

@Mod(name = StarcraftSedna.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = StarcraftSedna.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { StarcraftSedna.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class StarcraftSedna 
{
    public static final String NAME = "Starcraft Sedna";
    public static final String MODID = "StarcraftSedna";
    public static final String CHANNEL = "StarcraftSedna";
    public static final String CHANNELENTITIES = "StarcraftSednaEntities";

    
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
	
	// Block Sedna Ore Palladium
	public static final Block PalladiumOre = new StarcraftOre(937, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("PalladiumOre")
			.setTextureName("starcraftsedna:orePalladium")
			.setCreativeTab(GCSedna.starcraftSednaTab);
	
	// Block Sedna Palladium Block
	public static final Block PalladiumBlock = new StarcraftBlock(938, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("PalladiumBlock")
			.setTextureName("starcraftsedna:palladiumBlock")
			.setCreativeTab(GCSedna.starcraftSednaTab);
		
		
        @Instance(value = "StarcraftSedna")
        public static StarcraftSedna instance;
        
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
                GameRegistry.registerBlock(StarcraftSedna.SednaGrass, "SednaGrass");
                GameRegistry.registerBlock(StarcraftSedna.SednaDirt, "SednaDirt");
                GameRegistry.registerBlock(StarcraftSedna.SednaStone, "SednaStone");
                GameRegistry.registerBlock(StarcraftSedna.SednaCobblestone, "SednaCobblestone");
                GameRegistry.registerBlock(StarcraftSedna.SednaBrick, "SednaBrick");
                GameRegistry.registerBlock(StarcraftSedna.PalladiumOre, "PalladiumOre");
                GameRegistry.registerBlock(StarcraftSedna.PalladiumBlock, "PalladiumBlock");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        }
}