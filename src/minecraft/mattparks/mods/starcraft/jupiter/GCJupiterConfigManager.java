package mattparks.mods.starcraft.jupiter;

import java.io.File;
import java.util.logging.Level;

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
    public static int idItemJupiterBasic;
    
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

            GCJupiterConfigManager.dimensionIDJupiter = GCJupiterConfigManager.configuration.get("Dimensions", "Jupiter Dimension ID", -41).getInt(-41);
        
            GCJupiterConfigManager.idItemJupiterBasic = GCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemJupiterItemBasic", 9756).getInt(9756);
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
