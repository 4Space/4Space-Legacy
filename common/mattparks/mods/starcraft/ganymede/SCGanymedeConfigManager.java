package mattparks.mods.starcraft.ganymede;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCGanymedeConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDGanymede;

    public static boolean generateOtherMods;

    // BLOCKS

    // ITEMS
    public static int idItemGanymedeBasic;
    
    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
  
    public SCGanymedeConfigManager(File file)
    {
        if (!SCGanymedeConfigManager.loaded)
        {
            SCGanymedeConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCGanymedeConfigManager.configuration.load();

            SCGanymedeConfigManager.dimensionIDGanymede = SCGanymedeConfigManager.configuration.get("Dimensions", "Ganymede Dimension ID", -52).getInt(-52);
        
            SCGanymedeConfigManager.idItemGanymedeBasic = SCGanymedeConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemGanymedeItemBasic", 6758).getInt(6758);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Ganymede has a problem loading it's configuration");
        }
        finally
        {
            SCGanymedeConfigManager.configuration.save();
            SCGanymedeConfigManager.loaded = true;
        }
    }
}
