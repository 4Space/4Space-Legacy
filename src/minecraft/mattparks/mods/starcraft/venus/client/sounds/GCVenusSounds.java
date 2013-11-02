package mattparks.mods.starcraft.venus.client.sounds;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class GCVenusSounds
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {
            

        }
        catch (final Exception e)
        {
            System.err.println("[GCVenus2] Failed to register one or more sounds.");
        }
    }
}
