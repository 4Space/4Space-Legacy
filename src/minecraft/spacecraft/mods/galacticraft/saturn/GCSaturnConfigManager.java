package spacecraft.mods.galacticraft.saturn;

import java.io.File;
import java.util.logging.Level;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCSaturnConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCSaturnConfigManager(File file)
    {
        if (!GCSaturnConfigManager.loaded)
        {
            GCSaturnConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS
    public static int dimensionIDSaturn;

    // BLOCKS

    // ITEMS
    
    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
  
    public static boolean generateOtherMods;

    private void setDefaultValues()
    {
        try
        {
            GCSaturnConfigManager.configuration.load();

            GCSaturnConfigManager.dimensionIDSaturn = GCSaturnConfigManager.configuration.get("Dimensions", "Saturn Dimension ID", -51).getInt(-51);
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
