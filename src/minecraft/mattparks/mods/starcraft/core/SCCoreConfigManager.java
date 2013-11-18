package mattparks.mods.starcraft.core;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCCoreConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public SCCoreConfigManager(File file)
    {
        if (!SCCoreConfigManager.loaded)
        {
            SCCoreConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS

    // BLOCKS
    
    // ITEMS
    public static int idItemVenusBasic;
    public static int idItemSchematicMars;
    public static int idItemRocketEngine;
    
    // ARMOR

    // TOOLS

    // ENTITIES
    
    // GUI
    
    // SCHEMATIC
	

    // ACHIEVEMENTS
    
    // GENERAL

    private void setDefaultValues()
    {
        try
        {
            SCCoreConfigManager.configuration.load();

            SCCoreConfigManager.idItemVenusBasic = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenusItemBasic", 7540).getInt(7540);
            SCCoreConfigManager.idItemSchematicMars = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSchematicMars", 7541).getInt(7541);
        
            //Block id's 7653-7654 are used by Spacecraft Pluto
            
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Core has a problem loading it's configuration");
        }
        finally
        {
            SCCoreConfigManager.configuration.save();
            SCCoreConfigManager.loaded = true;
        }
    }
}
