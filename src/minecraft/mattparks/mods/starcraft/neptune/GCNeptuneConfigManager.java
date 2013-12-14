package mattparks.mods.starcraft.neptune;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCNeptuneConfigManager
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
  
    public GCNeptuneConfigManager(File file)
    {
        if (!GCNeptuneConfigManager.loaded)
        {
            GCNeptuneConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            GCNeptuneConfigManager.configuration.load();

            GCNeptuneConfigManager.dimensionIDNeptune = GCNeptuneConfigManager.configuration.get("Dimensions", "Uranus Dimension ID", -43).getInt(-43);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Neptune has a problem loading it's configuration");
        }
        finally
        {
            GCNeptuneConfigManager.configuration.save();
            GCNeptuneConfigManager.loaded = true;
        }
    }
}
