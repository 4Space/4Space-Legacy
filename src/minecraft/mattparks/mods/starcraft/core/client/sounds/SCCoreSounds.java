package mattparks.mods.starcraft.core.client.sounds;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SCCoreSounds
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {

        }
        catch (final Exception e)
        {
            System.err.println("[SCCore] Failed to register one or more sounds.");
        }
    }
}
