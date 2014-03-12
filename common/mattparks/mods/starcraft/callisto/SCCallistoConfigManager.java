package mattparks.mods.starcraft.callisto;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCCallistoConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDCallisto;

    public static boolean generateOtherMods;

    // BLOCKS

    // ITEMS
    public static int idItemCallistoBasic;
    
    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
  
    public SCCallistoConfigManager(File file)
    {
        if (!SCCallistoConfigManager.loaded)
        {
            SCCallistoConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCCallistoConfigManager.configuration.load();

            SCCallistoConfigManager.dimensionIDCallisto = SCCallistoConfigManager.configuration.get("Dimensions", "Callisto Dimension ID", -53).getInt(-53);
        
            SCCallistoConfigManager.idItemCallistoBasic = SCCallistoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemCallistoItemBasic", 6759).getInt(6759);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Europa has a problem loading it's configuration");
        }
        finally
        {
            SCCallistoConfigManager.configuration.save();
            SCCallistoConfigManager.loaded = true;
        }
    }
}
