package mattparks.mods.starcraft.core.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

/**
*
* Original code by micdoodle8
* 
*/
public class GCCorePacketHandlerServer implements IPacketHandler
{
    public static enum EnumPacketServer
    {
        UNUSED_0(0),
        RESPAWN_PLAYER(1, String.class),
        TELEPORT_ENTITY(2, String.class),
        IGNITE_ROCKET(3),
        OPEN_SCHEMATIC_PAGE(4, Integer.class),
        UNUSED_1(5),
        OPEN_SPACESHIP_INV(6, Integer.class),
        UPDATE_SHIP_YAW(7, Float.class),
        UPDATE_SHIP_PITCH(8, Float.class),
        UNUSED_2(9),
        SET_ENTITY_FIRE(10, Integer.class),
        OPEN_REFINERY_GUI(11, Integer.class, Integer.class, Integer.class),
        UPDATE_CONTROLLABLE_ENTITY(12),
        UNUSED_3(13),
        UPDATE_ADVANCED_ENTITY(14),
        BIND_SPACE_STATION_ID(15, Integer.class),
        UNLOCK_NEW_SCHEMATIC(16),
        UPDATE_DISABLEABLE_BUTTON(
                17,
                    Integer.class,
                    Integer.class,
                    Integer.class,
                    Integer.class),
        ON_FAILED_CHEST_UNLOCK(18, Integer.class),
        RENAME_SPACE_STATION(19, String.class, Integer.class),
        OPEN_BUGGY_INV(20),
        UPDATE_DYNAMIC_ENTITY_INV(21, Integer.class),
        UPDATE_DYNAMIC_TILE_INV(22, Integer.class, Integer.class, Integer.class),
        OPEN_EXTENDED_INVENTORY(23),
        ON_ADVANCED_GUI_CLICKED_INT(
                24,
                    Integer.class,
                    Integer.class,
                    Integer.class,
                    Integer.class,
                    Integer.class),
        ON_ADVANCED_GUI_CLICKED_STRING(
                25,
                    Integer.class,
                    Integer.class,
                    Integer.class,
                    Integer.class,
                    String.class),
        UPDATE_SHIP_MOTION_Y(26, Integer.class, Boolean.class);

        private int index;
        private Class<?>[] decodeAs;

        private EnumPacketServer(int index, Class<?>... decodeAs)
        {
            this.index = index;
            this.decodeAs = decodeAs;
        }

        public Class<?>[] getDecodeClasses()
        {
            return this.decodeAs;
        }

        public int getIndex()
        {
            return this.index;
        }
    }

    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player p)
    {
        if (packet == null)
        {
            FMLLog.severe("Packet received as null!");
            return;
        }

        if (packet.data == null)
        {
            FMLLog.severe("Packet data received as null! ID " + packet.getPacketId());
            return;
        }

        final DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));

        final EntityPlayerMP player = (EntityPlayerMP) p;

        Object[] packetReadout = null;

        {
        }

        {
            player.playerNetServerHandler.sendPacketToPlayer(new Packet9Respawn(player.dimension, (byte) player.worldObj.difficultySetting, player.worldObj.getWorldInfo().getTerrainType(), player.worldObj.getHeight(), player.theItemInWorldManager.getGameType()));
            {
                try
                {
                    {
                        {
                        }
                        {
                        }
                    }

                    final Object[] toSend = { player.username };
                }
                catch (final Exception e)
                {
                    e.printStackTrace();
                }
            }
            {

                {
                    ItemStack stack2 = null;

                    {
                    }

                    {
                    }
                    {
                        player.sendChatToPlayer(ChatMessageComponent.createFromText("I don't have a parachute! If I press launch again, there's no going back!"));
                    }
                }
                {
                    player.sendChatToPlayer(ChatMessageComponent.createFromText("I'll need to load in some rocket fuel first!"));
                }
            }
            if (player != null)
            {

            }
            {

                {
                }
            }
            {

                {
                }
            }
            for (final Object object : player.worldObj.loadedEntityList)
            {
                if (object instanceof EntityLiving)
                {
                    final EntityLiving entity = (EntityLiving) object;

                    if (entity.entityId == (Integer) packetReadout[0] && entity.ridingEntity == null)
                    {
                        entity.setFire(3);
                    }
                }
            }
            try
            {
            }
            catch (final Exception e)
            {
                e.printStackTrace();
            }
            try
            {
            }
            catch (final Exception e)
            {
                e.printStackTrace();
            }
            {

            }
            final Container container = player.openContainer;

            {


                {

                    {

                       {
                       }

                    }
                }
            }
            final TileEntity tileAt = player.worldObj.getBlockTileEntity((Integer) packetReadout[0], (Integer) packetReadout[1], (Integer) packetReadout[2]);

            {
            }
            {
                player.sendChatToPlayer(ChatMessageComponent.createFromText("I'll probably need a Tier " + packetReadout[0] + " Dungeon key to unlock this!"));
            }
            {
            }
            {
            }
            {
            }
            {
            }
            switch ((Integer) packetReadout[0])
            {
            case 0:
                {
                }
                break;
            case 1:
                {
                }
                break;
            case 2:
                {
                }
                break;
            case 3:
                {
                }
                break;
            case 4:
                {
                }
                break;
            case 5:
                {
                }
                break;
            default:
                break;
            }

            switch ((Integer) packetReadout[0])
            {
            case 0:
                {
                }
                break;
            default:
                break;
            }
           boolean up = (Boolean) packetReadout[1];
            {
            }
        }
    }
}
