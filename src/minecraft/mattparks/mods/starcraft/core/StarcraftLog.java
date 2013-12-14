package mattparks.mods.starcraft.core;

import java.util.logging.Level;
import cpw.mods.fml.relauncher.FMLRelaunchLog;

/**
*
* Original code by micdoodle8
* 
*/
public class StarcraftLog
{
    public static void info(String message)
    {
        FMLRelaunchLog.log("Starcraft", Level.INFO, message);
    }

    public static void severe(String message)
    {
        FMLRelaunchLog.log("Starcraft", Level.SEVERE, message);
    }
}
