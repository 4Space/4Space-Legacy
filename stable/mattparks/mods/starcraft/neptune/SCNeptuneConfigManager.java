package mattparks.mods.starcraft.neptune;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCNeptuneConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDNeptune;

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
  
    public SCNeptuneConfigManager(File file)
    {
        if (!SCNeptuneConfigManager.loaded)
        {
            SCNeptuneConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCNeptuneConfigManager.configuration.load();

            SCNeptuneConfigManager.dimensionIDNeptune = SCNeptuneConfigManager.configuration.get("Dimensions", "Uranus Dimension ID", -43).getInt(-43);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Neptune has a problem loading it's configuration");
        }
        finally
        {
            SCNeptuneConfigManager.configuration.save();
            SCNeptuneConfigManager.loaded = true;
        }
    }
}
