package mattparks.mods.starcraft.uranus;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCUranusConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDUranus;

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
  
    public GCUranusConfigManager(File file)
    {
        if (!GCUranusConfigManager.loaded)
        {
            GCUranusConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            GCUranusConfigManager.configuration.load();

            GCUranusConfigManager.dimensionIDUranus = GCUranusConfigManager.configuration.get("Dimensions", "Uranus Dimension ID", -46).getInt(-46);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Uranus has a problem loading it's configuration");
        }
        finally
        {
            GCUranusConfigManager.configuration.save();
            GCUranusConfigManager.loaded = true;
        }
    }
}
