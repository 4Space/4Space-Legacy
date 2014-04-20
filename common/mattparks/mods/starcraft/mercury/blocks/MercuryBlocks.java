package mattparks.mods.starcraft.mercury.blocks;

import mattparks.mods.MattCore.Version;
import mattparks.mods.starcraft.mercury.CommonProxyMercury;
import mattparks.mods.starcraft.mercury.MercuryCore;
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

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod(name = MercuryBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = MercuryBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { MercuryBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class MercuryBlocks 
{
    public static final String NAME = "Mercury Blocks";
    public static final String MODID = "MercuryBlocks";
    public static final String CHANNEL = "MercuryBlocks";
    public static final String CHANNELENTITIES = "MercuryBlocksEntities";


    public static final Block MercuryGrass = new SCMercuryGrass(710, null).setHardness(0.4F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("MercuryGrass").setTextureName("starcraftmercury:grassMercury").setCreativeTab(MercuryCore.starcraftMercuryTab);

	public static final Block MercuryDirt = new SCBlock(711, null).setHardness(0.3F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("MercuryDirt").setTextureName("starcraftmercury:dirtMercury").setCreativeTab(MercuryCore.starcraftMercuryTab);

	public static final Block MercuryStone = new SCMercuryStone(712, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("MercuryStone").setTextureName("starcraftmercury:stoneMercury").setCreativeTab(MercuryCore.starcraftMercuryTab);

	public static final Block MercuryCobblestone = new SCBlock(713, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("MercuryCobblestone").setTextureName("starcraftmercury:cobblestoneMercury").setCreativeTab(MercuryCore.starcraftMercuryTab);

	public static final Block MercuryBrick = new SCBlock(716, null).setHardness(1000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("MercuryBrick").setTextureName("starcraftmercury:mercuryBrick").setCreativeTab(MercuryCore.starcraftMercuryTab).setBlockUnbreakable();

	public static final Block MercuryIridiumOre = new SCMercuryOre(720, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("MercuryIridiumOre").setTextureName("starcraftmercury:iridiumOreMercury").setCreativeTab(MercuryCore.starcraftMercuryTab);

	public static final Block MercuryCoalOre = new SCMercuryOre(722, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("MercuryCoalOre").setTextureName("starcraftmercury:coalOreMercury").setCreativeTab(MercuryCore.starcraftMercuryTab);

	public static final Block MercuryTinOre = new SCMercuryOre(723, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("MercuryTinOre").setTextureName("starcraftmercury:tinOreMercury").setCreativeTab(MercuryCore.starcraftMercuryTab);

	public static final Block MercuryCopperOre = new SCMercuryOre(724, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("MercuryCopperOre").setTextureName("starcraftmercury:copperOreMercury").setCreativeTab(MercuryCore.starcraftMercuryTab);

	public static final Block IridiumBlock = new SCMercuryOre(725, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("IridiumBlock").setTextureName("starcraftmercury:iridiumBlock").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public final static Block BlackGlowstone = new SCBlock(501, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("BlackGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_black").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block BlueGlowstone = new SCBlock(502, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("BlueGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_blue").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block BrownGlowstone = new SCBlock(503, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("BrownGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_brown").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block CyanGlowstone = new SCBlock(504, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("CyanGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_cyan").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block GreenGlowstone = new SCBlock(505, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("GreenGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_green").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block GreyGlowstone = new SCBlock(506, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("GreyGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_grey").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block LightBlueGlowstone = new SCBlock(507, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("LightBlueGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_light_blue").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block SilverGlowstone = new SCBlock(508, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("SilverGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_silver").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block LimeGlowstone = new SCBlock(509, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("LimeGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_lime").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block MagentaGlowstone = new SCBlock(510, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("MagentaGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_magenta").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block OrangeGlowstone = new SCBlock(511, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("OrangeGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_orange").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block PinkGlowstone = new SCBlock(512, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("PinkGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_pink").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block PurpleGlowstone = new SCBlock(513, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("PurpleGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_purple").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block RedGlowstone = new SCBlock(515, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("RedGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_red").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block WhiteGlowstone = new SCBlock(516, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("WhiteGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_white").setCreativeTab(MercuryCore.starcraftMercuryTab);

    public static final Block YellowGlowstone = new SCBlock(517, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("YellowGlowstone").setLightValue(1.0f).setTextureName("starcraftmercury:glowstone_yellow").setCreativeTab(MercuryCore.starcraftMercuryTab);

	public static final Block caravanModule = new SCCaravanModule(927, null).setHardness(0.4F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("caravanModule").setTextureName("starcraftmercury:caravanModule").setCreativeTab(MercuryCore.starcraftMercuryTab);

	public static final Block caravanModulePart = new SCBlock(928, null).setHardness(30.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("caravanModulePart").setTextureName("starcraftmercury:caravanModulePart");

	
        @Instance(value = "MercuryBlocks")
        public static MercuryBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.mercury.client.ClientProxyMercury", serverSide = "mattparks.mods.starcraft.mercury.CommonProxyMercury")
        public static CommonProxyMercury proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
            	GameRegistry.registerBlock(MercuryBlocks.MercuryGrass, "MercuryGrass");
            	GameRegistry.registerBlock(MercuryBlocks.MercuryDirt, "MercuryDirt");
            	GameRegistry.registerBlock(MercuryBlocks.MercuryStone, "MercuryStone");
            	GameRegistry.registerBlock(MercuryBlocks.MercuryCobblestone, "MercuryCobblestone");
            	GameRegistry.registerBlock(MercuryBlocks.MercuryBrick, "MercuryBrick");
            	GameRegistry.registerBlock(MercuryBlocks.MercuryIridiumOre, "MercuryIridiumOre");
            	GameRegistry.registerBlock(MercuryBlocks.MercuryCoalOre, "MercuryCoalOre");
            	GameRegistry.registerBlock(MercuryBlocks.MercuryTinOre, "MercuryTinOre");
            	GameRegistry.registerBlock(MercuryBlocks.MercuryCopperOre, "MercuryCopperOre");
            	GameRegistry.registerBlock(MercuryBlocks.IridiumBlock, "IridiumBlock");
            	
            	GameRegistry.registerBlock(MercuryBlocks.BlackGlowstone, "BlackGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.BlueGlowstone, "BlueGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.BrownGlowstone, "BrownGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.CyanGlowstone, "CyanGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.GreenGlowstone, "GreenGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.GreyGlowstone, "GreyGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.SilverGlowstone, "SilverGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.LightBlueGlowstone, "LightBlueGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.LimeGlowstone, "LimeGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.MagentaGlowstone, "MagentaGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.OrangeGlowstone, "OrangeGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.PinkGlowstone, "PinkGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.PurpleGlowstone, "PurpleGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.RedGlowstone, "RedGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.WhiteGlowstone, "WhiteGlowstone");
            	GameRegistry.registerBlock(MercuryBlocks.YellowGlowstone, "YellowGlowstone");
                GameRegistry.registerBlock(MercuryBlocks.caravanModule, "CaravanModule");
                GameRegistry.registerBlock(MercuryBlocks.caravanModulePart, "CaravanModulePart");
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        }
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
        	;
        }
}