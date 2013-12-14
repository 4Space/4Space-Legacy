package mattparks.mods.starcraft.core;

import mattparks.mods.starcraft.core.blocks.MercuryStone;
import mattparks.mods.starcraft.core.blocks.StarcraftBlock;
import mattparks.mods.starcraft.core.blocks.StarcraftCaravanModule;
import mattparks.mods.starcraft.core.blocks.StarcraftGrass;
import mattparks.mods.starcraft.core.blocks.StarcraftGravityGenerator;
import mattparks.mods.starcraft.core.blocks.StarcraftOre;
import mattparks.mods.starcraft.mercury.GCMercury;
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

@Mod(name = StarcraftMercury.NAME, version = StarcraftCore.LOCALMAJVERSION + "." + StarcraftCore.LOCALMINVERSION + "." + StarcraftCore.LOCALBUILDVERSION, useMetadata = true, modid = StarcraftMercury.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { StarcraftMercury.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class StarcraftMercury 
{
    public static final String NAME = "Starcraft Mercury";
    public static final String MODID = "StarcraftMercury";
    public static final String CHANNEL = "StarcraftMercury";
    public static final String CHANNELENTITIES = "StarcraftMercuryEntities";

    
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

	// Block Mercury, Iridium Ore
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
	
	// Block Mercury, Iridium
	public static final Block IridiumBlock = new StarcraftOre(725, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("IridiumBlock")
			.setTextureName("starcraftmercury:iridiumBlock")
			.setCreativeTab(GCMercury.starcraftMercuryTab);
	
    //Black Glowstone
    public final static Block BlackGlowstone = new StarcraftBlock(501, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("BlackGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_black")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Blue Glowstone
    public static final Block BlueGlowstone = new StarcraftBlock(502, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("BlueGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_blue")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Brown Glowstone
    public static final Block BrownGlowstone = new StarcraftBlock(503, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("BrownGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_brown")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Cyan Glowstone
    public static final Block CyanGlowstone = new StarcraftBlock(504, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("CyanGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_cyan")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Green Glowstone
    public static final Block GreenGlowstone = new StarcraftBlock(505, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("GreenGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_green")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Grey Glowstone
    public static final Block GreyGlowstone = new StarcraftBlock(506, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("GreyGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_grey")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    // Light Blue Glowstone
    public static final Block LightBlueGlowstone = new StarcraftBlock(507, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("LightBlueGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_light_blue")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Silver Glowstone
    public static final Block SilverGlowstone = new StarcraftBlock(508, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("SilverGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_silver")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Lime Glowstone
    public static final Block LimeGlowstone = new StarcraftBlock(509, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("LimeGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_lime")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Magenta Glowstone
    public static final Block MagentaGlowstone = new StarcraftBlock(510, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("MagentaGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_magenta")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Orange Glowstone
    public static final Block OrangeGlowstone = new StarcraftBlock(511, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("OrangeGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_orange")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Pink Glowstone
    public static final Block PinkGlowstone = new StarcraftBlock(512, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("PinkGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_pink")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Purple Glowstone
    public static final Block PurpleGlowstone = new StarcraftBlock(513, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("PurpleGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_purple")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Red Glowstone
    public static final Block RedGlowstone = new StarcraftBlock(515, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("RedGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_red")
    		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //White Glowstone
    public static final Block WhiteGlowstone = new StarcraftBlock(516, null)
    	.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    	.setUnlocalizedName("WhiteGlowstone")
    	.setLightValue(1.0f)
    	.setTextureName("starcraftmercury:glowstone_white")
		.setCreativeTab(GCMercury.starcraftMercuryTab);

    //Yellow Glowstone
    public static final Block YellowGlowstone = new StarcraftBlock(517, null)
    		.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
    		.setUnlocalizedName("YellowGlowstone")
    		.setLightValue(1.0f)
    		.setTextureName("starcraftmercury:glowstone_yellow")
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
			.setTextureName("starcraftmercury:caravanModule")
			.setCreativeTab(GCMercury.starcraftMercuryTab);

	// Block Mercury, Caravan Block
	public static final Block caravanModulePart = new StarcraftBlock(928, null)
			.setHardness(1000000.0F).setStepSound(Block.soundClothFootstep)
			.setUnlocalizedName("caravanModulePart")
			.setTextureName("starcraftmercury:caravanModulePart")
			.setBlockUnbreakable();

	
        @Instance(value = "StarcraftMercury")
        public static StarcraftMercury instance;
        
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
            	GameRegistry.registerBlock(StarcraftMercury.MercuryGrass, "MercuryGrass");
            	GameRegistry.registerBlock(StarcraftMercury.MercuryDirt, "MercuryDirt");
            	GameRegistry.registerBlock(StarcraftMercury.MercuryStone, "MercuryStone");
            	GameRegistry.registerBlock(StarcraftMercury.MercuryCobblestone, "MercuryCobblestone");
            	GameRegistry.registerBlock(StarcraftMercury.MercuryBrick, "MercuryBrick");
            	GameRegistry.registerBlock(StarcraftMercury.MercuryIridiumOre, "MercuryIridiumOre");
            	GameRegistry.registerBlock(StarcraftMercury.MercuryCoalOre, "MercuryCoalOre");
            	GameRegistry.registerBlock(StarcraftMercury.MercuryTinOre, "MercuryTinOre");
            	GameRegistry.registerBlock(StarcraftMercury.MercuryCopperOre, "MercuryCopperOre");
            	GameRegistry.registerBlock(StarcraftMercury.IridiumBlock, "IridiumBlock");
            	
            	GameRegistry.registerBlock(StarcraftMercury.BlackGlowstone, "BlackGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.BlueGlowstone, "BlueGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.BrownGlowstone, "BrownGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.CyanGlowstone, "CyanGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.GreenGlowstone, "GreenGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.GreyGlowstone, "GreyGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.SilverGlowstone, "SilverGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.LightBlueGlowstone, "LightBlueGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.LimeGlowstone, "LimeGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.MagentaGlowstone, "MagentaGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.OrangeGlowstone, "OrangeGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.PinkGlowstone, "PinkGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.PurpleGlowstone, "PurpleGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.RedGlowstone, "RedGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.WhiteGlowstone, "WhiteGlowstone");
            	GameRegistry.registerBlock(StarcraftMercury.YellowGlowstone, "YellowGlowstone");
                GameRegistry.registerBlock(StarcraftMercury.gravityGenerator, "GravityGenerator");
                GameRegistry.registerBlock(StarcraftMercury.caravanModule, "CaravanModule");
                GameRegistry.registerBlock(StarcraftMercury.caravanModulePart, "CaravanModulePart");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        }
}