package mattparks.mods.starcraft.makemake;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCMakemakeConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDMakemake;

    public static boolean generateOtherMods;

    // BLOCKS

    // ITEMS
    public static int idItemMakemakeBasic;
    
    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
  
    public SCMakemakeConfigManager(File file)
    {
        if (!SCMakemakeConfigManager.loaded)
        {
            SCMakemakeConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCMakemakeConfigManager.configuration.load();

            SCMakemakeConfigManager.dimensionIDMakemake = SCMakemakeConfigManager.configuration.get("Dimensions", "Makemake Dimension ID", -55).getInt(-55);
        
            SCMakemakeConfigManager.idItemMakemakeBasic = SCMakemakeConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemMakemakeItemBasic", 6756).getInt(6756);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Makemake has a problem loading it's configuration");
        }
        finally
        {
            SCMakemakeConfigManager.configuration.save();
            SCMakemakeConfigManager.loaded = true;
        }
    }
}
