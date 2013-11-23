package mattparks.mods.starcraft.sedna;

import java.io.File;
import java.util.logging.Level;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCSednaConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCSednaConfigManager(File file)
    {
        if (!GCSednaConfigManager.loaded)
        {
            GCSednaConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS
    public static int dimensionIDSedna;

    // BLOCKS
    public static int idBlockSedna;

    // ITEMS
    public static int idItemSednaBasic;
    
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
            GCSednaConfigManager.configuration.load();

            GCSednaConfigManager.dimensionIDSedna = GCSednaConfigManager.configuration.get("Dimensions", "Sedna Dimension ID", -53).getInt(-53);

//            GCPlutoConfigManager.idBlockPluto = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockSedna", 7653).getInt(7653);
     
            GCSednaConfigManager.idItemSednaBasic = GCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSednaBasic", 3653).getInt(3653);

            //Block id's 7755-7756 are used by Starcraft mercury
            
            GCSednaConfigManager.generateOtherMods = GCSednaConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Eris", false).getBoolean(false);        
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Eris has a problem loading it's configuration");
        }
        finally
        {
            GCSednaConfigManager.configuration.save();
            GCSednaConfigManager.loaded = true;
        }
    }
}
