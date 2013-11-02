package mattparks.mods.starcraft.mercury.client.sounds;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class GCMercurySounds
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {
            

        }
        catch (final Exception e)
        {
            System.err.println("[GCMercury] Failed to register one or more sounds.");
        }
    }
}
