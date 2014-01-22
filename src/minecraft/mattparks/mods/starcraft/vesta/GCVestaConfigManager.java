package mattparks.mods.starcraft.vesta;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCVestaConfigManager
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
  
    public GCVestaConfigManager(File file)
    {
        if (!GCVestaConfigManager.loaded)
        {
            GCVestaConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            GCVestaConfigManager.configuration.load();

            GCVestaConfigManager.dimensionIDVesta = GCVestaConfigManager.configuration.get("Dimensions", "Vesta Dimension ID", -50).getInt(-50);
        
            GCVestaConfigManager.idItemVestaBasic = GCVestaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVestaItemBasic", 6756).getInt(6756);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Vesta has a problem loading it's configuration");
        }
        finally
        {
            GCVestaConfigManager.configuration.save();
            GCVestaConfigManager.loaded = true;
        }
    }
}
