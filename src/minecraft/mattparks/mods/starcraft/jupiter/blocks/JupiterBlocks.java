package mattparks.mods.starcraft.jupiter.blocks;

import mattparks.mods.starcraft.Version;
import mattparks.mods.starcraft.jupiter.CommonProxyJupiter;
import mattparks.mods.starcraft.jupiter.JupiterCore;
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

@Mod(name = JupiterBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = JupiterBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { JupiterBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class JupiterBlocks 
{
    public static final String NAME = "Jupiter Blocks";
    public static final String MODID = "JupiterBlocks";
    public static final String CHANNEL = "JupiterBlocks";
    public static final String CHANNELENTITIES = "JupiterBlocksEntities";

    
	// Block Jupiter, Nitrogen
	public static final Block JupiterNitrogen = new SCGasTop(650, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("jupiterNitrogen")
			.setTextureName("starcraftjupiter:jupiterNitrogen")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	// Block Jupiter, Helium
	public static final Block JupiterHelium = new SCGasBottom(651, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("jupiterHelium")
			.setTextureName("starcraftjupiter:jupiterHelium")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	// Block Jupiter, Hydrogen
	public static final Block JupiterHydrogen = new SCGasBottom(652,
			null).setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("jupiterHydrogen")
			.setTextureName("starcraftjupiter:jupiterHydrogen")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	// Block Jupiter, Brick
	public static final Block JupiterBrick = new SCBlock(637, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("jupiterBrick")
			.setTextureName("starcraftjupiter:jupiterBrick")
			.setCreativeTab(JupiterCore.starcraftGasTab)
			.setBlockUnbreakable();
	
	// Block Jupiter, Clear Diamond Block
	public static final Block ClearDiamondBlock = new SCBlock(638, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("ClearDiamondBlock")
			.setTextureName("starcraftjupiter:clearDiamondBlock")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	
	// Block Saturn, Nitrogen
	public static final Block SaturnNitrogen = new SCGasTop(653, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("saturnNitrogen")
			.setTextureName("starcraftsaturn:saturnNitrogen")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	// Block Saturn, Helium
	public static final Block SaturnHelium = new SCGasBottom(654, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("saturnHelium")
			.setTextureName("starcraftsaturn:saturnHelium")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	// Block Saturn, Hydrogen
	public static final Block SaturnHydrogen = new SCGasBottom(655, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("saturnHydrogen")
			.setTextureName("starcraftsaturn:saturnHydrogen")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	// Block Saturn, Brick
	public static final Block SaturnBrick = new SCBlock(628, null)
			.setHardness(100.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("saturnBrick")
			.setTextureName("starcraftsaturn:saturnBrick")
			.setCreativeTab(JupiterCore.starcraftGasTab)
			.setBlockUnbreakable();

	
	// Block Uranus Nitrogen
	public static final Block UranusNitrogen = new SCGasTop(656, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("uranusNitrogen")
			.setTextureName("starcrafturanus:uranusNitrogen")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	// Block Uranus Helium
	public static final Block UranusHelium = new SCGasBottom(657, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("uranusHelium")
			.setTextureName("starcrafturanus:uranusHelium")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	// Block Uranus Hydrogen
	public static final Block UranusHydrogen = new SCGasBottom(658, null)
			.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("uranusHydrogen")
			.setTextureName("starcrafturanus:uranusHydrogen")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	// Block Uranus Brick
	public static final Block UranusBrick = new SCBlock(699, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("uranusBrick")
			.setTextureName("starcrafturanus:uranusBrick")
			.setCreativeTab(JupiterCore.starcraftGasTab)
			.setBlockUnbreakable();

	
	// Block Neptune Nitrogen
	public static final Block NeptuneNitrogen = new SCGasTop(659, null)
			.setHardness(0.4F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("neptuneNitrogen")
			.setTextureName("starcraftneptune:neptuneNitrogen")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	// Block Neptune Helium
	public static final Block NeptuneHelium = new SCGasBottom(660, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("neptuneHelium")
			.setTextureName("starcraftneptune:neptuneHelium")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	// Block Neptune Hydrogen
	public static final Block NeptuneHydrogen = new SCGasBottom(661,
			null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("neptuneHydrogen")
			.setTextureName("starcraftneptune:neptuneHydrogen")
			.setCreativeTab(JupiterCore.starcraftGasTab);

	// Block Neptune Brick
	public static final Block NeptuneBrick = new SCBlock(630, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("neptuneBrick")
			.setTextureName("starcraftneptune:neptuneBrick")
			.setCreativeTab(JupiterCore.starcraftGasTab)
			.setBlockUnbreakable();

	
        @Instance(value = "JupiterBlocks")
        public static JupiterBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.jupiter.client.ClientProxyJupiter", serverSide = "mattparks.mods.starcraft.jupiter.CommonProxyJupiter")
        public static CommonProxyJupiter proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(JupiterBlocks.JupiterNitrogen, "JupiterNitrogen");
                GameRegistry.registerBlock(JupiterBlocks.JupiterHelium, "JupiterHelium");
                GameRegistry.registerBlock(JupiterBlocks.JupiterHydrogen, "JupiterHydrogen");
                GameRegistry.registerBlock(JupiterBlocks.JupiterBrick, "JupiterBrick");    
                GameRegistry.registerBlock(JupiterBlocks.ClearDiamondBlock, "ClearDiamondBlock");
                
                GameRegistry.registerBlock(JupiterBlocks.SaturnNitrogen, "SaturnNitrogen");
                GameRegistry.registerBlock(JupiterBlocks.SaturnHelium, "SaturnHelium");
                GameRegistry.registerBlock(JupiterBlocks.SaturnHydrogen, "SaturnHydrogen");
                GameRegistry.registerBlock(JupiterBlocks.SaturnBrick, "SaturnBrick");
                
                GameRegistry.registerBlock(JupiterBlocks.UranusNitrogen, "UranusNitrogen");
                GameRegistry.registerBlock(JupiterBlocks.UranusHelium, "UranusHelium");
                GameRegistry.registerBlock(JupiterBlocks.UranusHydrogen, "UranusHydrogen");
                GameRegistry.registerBlock(JupiterBlocks.UranusBrick, "UranusBrick");
                                        
                GameRegistry.registerBlock(JupiterBlocks.NeptuneNitrogen, "NeptuneNitrogen");
                GameRegistry.registerBlock(JupiterBlocks.NeptuneHelium, "NeptuneHelium");
                GameRegistry.registerBlock(JupiterBlocks.NeptuneHydrogen, "NeptuneHydrogen");
                GameRegistry.registerBlock(JupiterBlocks.NeptuneBrick, "NeptuneBrick");                    
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