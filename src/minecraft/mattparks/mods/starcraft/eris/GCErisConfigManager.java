package mattparks.mods.starcraft.eris;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCErisConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDEris;

    // ITEMS
    public static int idItemErisBasic;

    // BLOCKS

    public static boolean generateOtherMods;
    
    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
  
    public GCErisConfigManager(File file)
    {
        if (!GCErisConfigManager.loaded)
        {
            GCErisConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            GCErisConfigManager.configuration.load();

            GCErisConfigManager.dimensionIDEris = GCErisConfigManager.configuration.get("Dimensions", "Eris Dimension ID", -40).getInt(-40);

            GCErisConfigManager.idItemErisBasic = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemErisBasic", 9654).getInt(9654);

            GCErisConfigManager.generateOtherMods = GCErisConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Eris", false).getBoolean(false);        
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcrfat Eris has a problem loading it's configuration");
        }
        finally
        {
            GCErisConfigManager.configuration.save();
            GCErisConfigManager.loaded = true;
        }
    }
}
