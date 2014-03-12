package mattparks.mods.starcraft.vesta;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCVestaConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDVesta;

    public static boolean generateOtherMods;

    // BLOCKS

    // ITEMS
    public static int idItemVestaBasic;
    
    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
  
    public SCVestaConfigManager(File file)
    {
        if (!SCVestaConfigManager.loaded)
        {
            SCVestaConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCVestaConfigManager.configuration.load();

            SCVestaConfigManager.dimensionIDVesta = SCVestaConfigManager.configuration.get("Dimensions", "Vesta Dimension ID", -42).getInt(-42);
        
            SCVestaConfigManager.idItemVestaBasic = SCVestaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVestaItemBasic", 6756).getInt(6756);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Vesta has a problem loading it's configuration");
        }
        finally
        {
            SCVestaConfigManager.configuration.save();
            SCVestaConfigManager.loaded = true;
        }
    }
}
