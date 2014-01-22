package mattparks.mods.starcraft.vesta;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCVestaConfigManager
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
  
    public GCVestaConfigManager(File file)
    {
        if (!GCVestaConfigManager.loaded)
        {
            GCVestaConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            GCVestaConfigManager.configuration.load();

            GCVestaConfigManager.dimensionIDSaturn = GCVestaConfigManager.configuration.get("Dimensions", "Saturn Dimension ID", -45).getInt(-45);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Saturn has a problem loading it's configuration");
        }
        finally
        {
            GCVestaConfigManager.configuration.save();
            GCVestaConfigManager.loaded = true;
        }
    }
}
