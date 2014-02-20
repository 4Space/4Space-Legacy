package mattparks.mods.starcraft.europa;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCEuropaConfigManager
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
  
    public SCEuropaConfigManager(File file)
    {
        if (!SCEuropaConfigManager.loaded)
        {
            SCEuropaConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCEuropaConfigManager.configuration.load();

            SCEuropaConfigManager.dimensionIDEuropa = SCEuropaConfigManager.configuration.get("Dimensions", "Europa Dimension ID", -53).getInt(-53);
        
            SCEuropaConfigManager.idItemEuropaBasic = SCEuropaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemEuropaItemBasic", 6758).getInt(6758);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Europa has a problem loading it's configuration");
        }
        finally
        {
            SCEuropaConfigManager.configuration.save();
            SCEuropaConfigManager.loaded = true;
        }
    }
}
