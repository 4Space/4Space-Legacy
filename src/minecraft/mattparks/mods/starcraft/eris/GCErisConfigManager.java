package mattparks.mods.starcraft.eris;

import java.io.File;
import java.util.logging.Level;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCErisConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCErisConfigManager(File file)
    {
        if (!GCErisConfigManager.loaded)
        {
            GCErisConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS
    public static int dimensionIDEris;

    // BLOCKS
    public static int idBlockEris;

    // ITEMS
    public static int idItemErisBasic;
    
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
            GCErisConfigManager.configuration.load();

            GCErisConfigManager.dimensionIDEris = GCErisConfigManager.configuration.get("Dimensions", "Eris Dimension ID", -53).getInt(-53);

//            GCPlutoConfigManager.idBlockPluto = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenus", 7653).getInt(7653);
     
            GCErisConfigManager.idItemErisBasic = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemErisBasic", 9654).getInt(9654);

            //Block id's 7755-7756 are used by Starcraft mercury
            
            GCErisConfigManager.generateOtherMods = GCErisConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Eris", false).getBoolean(false);        
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Eris has a problem loading it's configuration");
        }
        finally
        {
            GCErisConfigManager.configuration.save();
            GCErisConfigManager.loaded = true;
        }
    }
}
