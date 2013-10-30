package spacecraft.mods.galacticraft.jupiter;

import java.io.File;
import java.util.logging.Level;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCJupiterConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCJupiterConfigManager(File file)
    {
        if (!GCJupiterConfigManager.loaded)
        {
            GCJupiterConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS
    public static int dimensionIDJupiter;

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
            GCJupiterConfigManager.configuration.load();

            GCJupiterConfigManager.dimensionIDJupiter = GCJupiterConfigManager.configuration.get("Dimensions", "Jupiter Dimension ID", -49).getInt(-49);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Jupiter has a problem loading it's configuration");
        }
        finally
        {
            GCJupiterConfigManager.configuration.save();
            GCJupiterConfigManager.loaded = true;
        }
    }
}
