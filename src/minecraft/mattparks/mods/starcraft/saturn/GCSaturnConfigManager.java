package mattparks.mods.starcraft.saturn;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCSaturnConfigManager
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
  
    public GCSaturnConfigManager(File file)
    {
        if (!GCSaturnConfigManager.loaded)
        {
            GCSaturnConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            GCSaturnConfigManager.configuration.load();

            GCSaturnConfigManager.dimensionIDSaturn = GCSaturnConfigManager.configuration.get("Dimensions", "Saturn Dimension ID", -45).getInt(-45);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Saturn has a problem loading it's configuration");
        }
        finally
        {
            GCSaturnConfigManager.configuration.save();
            GCSaturnConfigManager.loaded = true;
        }
    }
}
