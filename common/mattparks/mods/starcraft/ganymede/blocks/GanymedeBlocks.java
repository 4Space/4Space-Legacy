package mattparks.mods.starcraft.ganymede.blocks;

import mattparks.mods.starcraft.Version;
import mattparks.mods.starcraft.ganymede.CommonProxyGanymede;
import mattparks.mods.starcraft.moons.MoonsCore;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(name = GanymedeBlocks.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = GanymedeBlocks.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GanymedeBlocks.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GanymedeBlocks 
{
    public static final String NAME = "Ganymede Blocks";
    public static final String MODID = "GanymedeBlocks";
    public static final String CHANNEL = "GanymedeBlocks";
    public static final String CHANNELENTITIES = "GanymedeBlocksEntities";

    
	public static final Block GanymedeSurfaceStone = new SCBlock(978, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("GanymedeSurfaceStone").setTextureName("starcraftganymede:ganymedeSurfaceStone").setCreativeTab(MoonsCore.starcraftMoonsTab);

	public static final Block GanymedeSubStone = new SCBlock(979, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("GanymedeSubStone").setTextureName("starcraftganymede:ganymedeSubStone").setCreativeTab(MoonsCore.starcraftMoonsTab);

	public static final Block GanymedeStone = new SCBlock(980, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("GanymedeStone").setTextureName("starcraftganymede:ganymedeStone").setCreativeTab(MoonsCore.starcraftMoonsTab);

	public static final Block GanymedeCobblestone = new SCBlock(981, null).setHardness(0.4F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("GanymedeCobblestone").setTextureName("starcraftganymede:ganymedeCobblestone").setCreativeTab(MoonsCore.starcraftMoonsTab);

	
        @Instance(value = "GanymedeBlocks")
        public static GanymedeBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.starcraft.ganymede.client.ClientProxyGanymede", serverSide = "mattparks.mods.starcraft.ganymede.CommonProxyGanymede")
        public static CommonProxyGanymede proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
        	    GameRegistry.registerBlock(GanymedeBlocks.GanymedeSurfaceStone, "GanymedeSurfaceStone");
        	    GameRegistry.registerBlock(GanymedeBlocks.GanymedeSubStone, "GanymedeSubStone");
                GameRegistry.registerBlock(GanymedeBlocks.GanymedeStone, "GanymedeStone");
                GameRegistry.registerBlock(GanymedeBlocks.GanymedeCobblestone, "GanymedeCobblestone");
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