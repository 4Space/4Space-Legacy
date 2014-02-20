package mattparks.mods.starcraft.eris;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCErisConfigManager
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
  
    public SCErisConfigManager(File file)
    {
        if (!SCErisConfigManager.loaded)
        {
            SCErisConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCErisConfigManager.configuration.load();

            SCErisConfigManager.dimensionIDEris = SCErisConfigManager.configuration.get("Dimensions", "Eris Dimension ID", -40).getInt(-40);

            SCErisConfigManager.idItemErisBasic = SCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemErisBasic", 9777).getInt(9777);

            SCErisConfigManager.generateOtherMods = SCErisConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Eris", false).getBoolean(false);        
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Eris has a problem loading it's configuration");
        }
        finally
        {
            SCErisConfigManager.configuration.save();
            SCErisConfigManager.loaded = true;
        }
    }
}
