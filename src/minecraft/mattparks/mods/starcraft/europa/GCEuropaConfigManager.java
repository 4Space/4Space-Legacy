package mattparks.mods.starcraft.europa;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCEuropaConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDEuropa;

    public static boolean generateOtherMods;

    // BLOCKS

    // ITEMS
    public static int idItemEuropaBasic;
    
    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
  
    public GCEuropaConfigManager(File file)
    {
        if (!GCEuropaConfigManager.loaded)
        {
            GCEuropaConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            GCEuropaConfigManager.configuration.load();

            GCEuropaConfigManager.dimensionIDEuropa = GCEuropaConfigManager.configuration.get("Dimensions", "Europa Dimension ID", -53).getInt(-53);
        
            GCEuropaConfigManager.idItemEuropaBasic = GCEuropaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemEuropaItemBasic", 6758).getInt(6758);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Europa has a problem loading it's configuration");
        }
        finally
        {
            GCEuropaConfigManager.configuration.save();
            GCEuropaConfigManager.loaded = true;
        }
    }
}
