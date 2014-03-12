package mattparks.mods.starcraft.titan;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCTitanConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDTitan;

    public static boolean generateOtherMods;

    // BLOCKS

    // ITEMS
    public static int idItemTitanBasic;
    
    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
  
    public SCTitanConfigManager(File file)
    {
        if (!SCTitanConfigManager.loaded)
        {
            SCTitanConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCTitanConfigManager.configuration.load();

            SCTitanConfigManager.dimensionIDTitan = SCTitanConfigManager.configuration.get("Dimensions", "Titan Dimension ID", -73).getInt(-73);
        
            SCTitanConfigManager.idItemTitanBasic = SCTitanConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemTitanItemBasic", 7759).getInt(7759);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Titan has a problem loading it's configuration");
        }
        finally
        {
            SCTitanConfigManager.configuration.save();
            SCTitanConfigManager.loaded = true;
        }
    }
}
