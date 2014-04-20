package mattparks.mods.starcraft.io.blocks;

import mattparks.mods.MattCore.Version;
import mattparks.mods.starcraft.io.CommonProxyIo;
import mattparks.mods.starcraft.moons.MoonsCore;
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

@Mod(name = IoBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = IoBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { IoBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class IoBlocks 
{
    public static final String NAME = "Io Blocks";
    public static final String MODID = "IoBlocks";
    public static final String CHANNEL = "IoBlocks";
    public static final String CHANNELENTITIES = "IoBlocksEntities";


	public static final Block IoBasalt = new SCBlock(931, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("IoBasalt").setTextureName("starcraftio:ioBasalt").setCreativeTab(MoonsCore.starcraftMoonsTab);
	
	public static final Block IoHalfBasalt = new SCHalfSlab(932, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("IoHalfBasalt").setTextureName("starcraftio:ioBasalt").setCreativeTab(MoonsCore.starcraftMoonsTab);

	public static final Block IoStone = new SCBlock(933, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("IoStone").setTextureName("starcraftio:ioStone").setCreativeTab(MoonsCore.starcraftMoonsTab);

	public static final Block IoCobblestone = new SCBlock(934, null).setHardness(0.4F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("ioCobblestone").setTextureName("starcraftio:ioCobblestone").setCreativeTab(MoonsCore.starcraftMoonsTab);

	
        @Instance(value = "IoBlocks")
        public static IoBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.io.client.ClientProxyIo", serverSide = "mattparks.mods.starcraft.io.CommonProxyIo")
        public static CommonProxyIo proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(IoBlocks.IoBasalt, "IoBasalt");
                GameRegistry.registerBlock(IoBlocks.IoHalfBasalt, "IoHalfBasalt");
                GameRegistry.registerBlock(IoBlocks.IoStone, "IoStone");
                GameRegistry.registerBlock(IoBlocks.IoCobblestone, "IoCobblestone");
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