package mattparks.mods.starcraft.saturn;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCSaturnConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDSaturn;

    public static boolean generateOtherMods;

    // BLOCKS

    // ITEMS
    
    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
  
    public SCSaturnConfigManager(File file)
    {
        if (!SCSaturnConfigManager.loaded)
        {
            SCSaturnConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCSaturnConfigManager.configuration.load();

            SCSaturnConfigManager.dimensionIDSaturn = SCSaturnConfigManager.configuration.get("Dimensions", "Saturn Dimension ID", -45).getInt(-45);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Saturn has a problem loading it's configuration");
        }
        finally
        {
            SCSaturnConfigManager.configuration.save();
            SCSaturnConfigManager.loaded = true;
        }
    }
}
