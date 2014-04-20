package mattparks.mods.starcraft.europa.blocks;

import mattparks.mods.MattCore.Version;
import mattparks.mods.starcraft.europa.CommonProxyEuropa;
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

@Mod(name = EuropaBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = EuropaBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { EuropaBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class EuropaBlocks 
{
    public static final String NAME = "Europa Blocks";
    public static final String MODID = "EuropaBlocks";
    public static final String CHANNEL = "EuropaBlocks";
    public static final String CHANNELENTITIES = "EuropaBlocksEntities";

    
 	public static final Block EuropaHardIce = new SCBlock(975, null).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("EuropaHardIce").setTextureName("starcrafteuropa:europaHardIce").setCreativeTab(MoonsCore.starcraftMoonsTab);

	public static final Block EuropaSoftIce = new SCBlock(976, null).setHardness(1.5F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("EuropaSoftIce").setTextureName("starcrafteuropa:europaSoftIce").setCreativeTab(MoonsCore.starcraftMoonsTab);
	
	
        @Instance(value = "EuropaBlocks")
        public static EuropaBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.europa.client.ClientProxyEuropa", serverSide = "mattparks.mods.starcraft.europa.CommonProxyEuropa")
        public static CommonProxyEuropa proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(EuropaBlocks.EuropaSoftIce, "EuropaSoftIce");
                GameRegistry.registerBlock(EuropaBlocks.EuropaHardIce, "EuropaHardIce");
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