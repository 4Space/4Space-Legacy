package mattparks.mods.starcraft.core.network;

import java.io.DataInputStream;

import cpw.mods.fml.relauncher.Side;

/**
*
* Original code by micdoodle8
* 
*/
public interface IGalacticraftAdvancedPacket
{
    public byte getPacketID();

    public void handlePacket(DataInputStream stream, Object[] extradata, Side side);
}
