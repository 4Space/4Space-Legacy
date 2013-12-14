package mattparks.mods.starcraft.core.client;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import mattparks.mods.starcraft.core.CommonProxy;
import mattparks.mods.starcraft.core.StarcraftCore;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.client.GCCoreCloudRenderer;
import micdoodle8.mods.galacticraft.core.util.PacketUtil;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{
    public class ClientPacketHandler implements IPacketHandler
    {
        @Override
        public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player p)
        {
            final DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
            final int packetType = PacketUtil.readPacketID(data);
            EntityPlayer player = (EntityPlayer) p;

            if (packetType == 0)
            {
                final Class<?>[] decodeAs = { Integer.class, Integer.class, Integer.class };
                final Object[] packetReadout = PacketUtil.readPacketData(data, decodeAs);

                int entityID = 0;
                Entity entity = null;
                
                switch ((Integer) packetReadout[1])
                {
                case 0:
                    entityID = (Integer) packetReadout[2];
                    entity = player.worldObj.getEntityByID(entityID);

                    {
                    }

                    player.openContainer.windowId = (Integer) packetReadout[0];
                    break;
                case 1:
                    entityID = (Integer) packetReadout[2];
                    entity = player.worldObj.getEntityByID(entityID);

                    {
                    }

                    player.openContainer.windowId = (Integer) packetReadout[0];
                    break;
                }
            }
        }
    }
    
    public static class TickHandlerClient implements ITickHandler
    {
        @Override
        public String getLabel()
        {
            return "Starcraft Core Client";
        }

        @Override
        public void tickEnd(EnumSet<TickType> type, Object... tickData)
        {
        }

        @Override
        public EnumSet<TickType> ticks()
        {
            return EnumSet.of(TickType.CLIENT);
        }

        @Override
        public void tickStart(EnumSet<TickType> type, Object... tickData)
        {
            final Minecraft minecraft = FMLClientHandler.instance().getClient();

            final WorldClient world = minecraft.theWorld;

            if (type.equals(EnumSet.of(TickType.CLIENT)))
            {
                if (world != null)
                {
                    {
                        if (world.provider.getSkyRenderer() == null)
                        {
                        }

                        if (world.provider.getCloudRenderer() == null)
                        {
                            world.provider.setCloudRenderer(new GCCoreCloudRenderer());
                        }
                    }

                    for (int i = 0; i < world.loadedEntityList.size(); i++)
                    {
                        final Entity e = (Entity) world.loadedEntityList.get(i);

                        if (e != null)
                        {
//                            if (e instanceof SCCoreEntityRocketT4)
                            {
//                                final SCCoreEntityRocketT4 eship = (SCCoreEntityRocketT4) e;

//                                if (eship.rocketSoundUpdater == null)
                                {
//                                    eship.rocketSoundUpdater = new GCCoreSoundUpdaterSpaceship(FMLClientHandler.instance().getClient().sndManager, eship, FMLClientHandler.instance().getClient().thePlayer);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static ArrayList<SoundPoolEntry> newMusic = new ArrayList<SoundPoolEntry>();
    
    public static Map<String, String> capeMap = new HashMap<String, String>();

    public static boolean handleLavaMovement(EntityPlayer player)
    {
        return player.worldObj.isMaterialInBB(player.boundingBox.expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.lava);
    }


    public static boolean handleWaterMovement(EntityPlayer player)
    {
        return player.worldObj.isMaterialInBB(player.boundingBox.expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.water);
    }

    {
    }

    {
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tile = world.getBlockTileEntity(x, y, z);

        return null;
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        TickRegistry.registerTickHandler(new TickHandlerClient(), Side.CLIENT);
        NetworkRegistry.instance().registerChannel(new ClientPacketHandler(), StarcraftCore.CHANNEL, Side.CLIENT);

        //Blue Cape
        String capeBlueString = "https://raw.github.com/mattparks/Starcraft-2/master/capes/capeBlue.png";
        //Green Cape
        String capeGreenString = "https://raw.github.com/mattparks/Starcraft-2/master/capes/capeGreen.png";
        //Orange Cape
        String capeOrangeString = "https://raw.github.com/mattparks/Starcraft-2/master/capes/capeOrange.png";
        //Red Cape
        String capeRedString = "https://raw.github.com/mattparks/Starcraft-2/master/capes/capeRed.png";
        //Violet Cape
        String capeVioletString = "https://raw.github.com/mattparks/Starcraft-2/master/capes/capeViolet.png";
        //Yellow Cape
        String capeYellowString = "https://raw.github.com/mattparks/Starcraft-2/master/capes/capeYellow.png";

        ClientProxyCore.capeMap.put("mattparks", capeBlueString);     
        ClientProxyCore.capeMap.put("flashy3", capeOrangeString); 
        ClientProxyCore.capeMap.put("Dinammar", capeVioletString); 
        ClientProxyCore.capeMap.put("imac123456", capeOrangeString); 
        ClientProxyCore.capeMap.put("decaxon", capeGreenString); 
        ClientProxyCore.capeMap.put("Henry33russian", capeBlueString); 
        
        ClientProxyCore.capeMap.put("ghostheart305", capeRedString); 
        ClientProxyCore.capeMap.put("langjam350roxsox", capeBlueString); 
        ClientProxyCore.capeMap.put("_Ja1m3", capeRedString); 
        ClientProxyCore.capeMap.put("goldenkat99", capeOrangeString); 

    }

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
    }

    @Override
    public void registerRenderInformation()
    {      
        ;
    }

    @Override
    public void spawnParticle(String var1, double var2, double var4, double var6)
    {
        final Minecraft var14 = FMLClientHandler.instance().getClient();

        if (var14 != null && var14.renderViewEntity != null && var14.effectRenderer != null)
        {
            final double var15 = var14.renderViewEntity.posX - var2;
            final double var17 = var14.renderViewEntity.posY - var4;
            final double var19 = var14.renderViewEntity.posZ - var6;
            Object var21 = null;
            final double var22 = 64.0D;

            if (var15 * var15 + var17 * var17 + var19 * var19 < var22 * var22)
            {
                if (var1.equals("sludgeDrip"))
                {
                }
            }
        }
    }
}
