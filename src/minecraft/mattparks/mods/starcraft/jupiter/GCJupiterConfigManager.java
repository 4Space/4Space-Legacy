package mattparks.mods.starcraft.jupiter;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCJupiterConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCJupiterConfigManager(File file)
    {
        if (!GCJupiterConfigManager.loaded)
        {
            GCJupiterConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS
    public static int dimensionIDJupiter;

    // BLOCKS

    // ITEMS
    public static int idItemJupiterBasic;
    public static int idItemSpaceshipTier5;
    
    // ARMOR

    // TOOLS

    // ENTITIES
    public static int idEntitySpaceshipTier5;
    
    // GUI
    public static int idGuiRocketCraftingBenchT5;
    
    // SCHEMATIC
    public static int idSchematicRocketT5;

    // ACHIEVEMENTS

    // GENERAL
  
    public static boolean generateOtherMods;

    private void setDefaultValues()
    {
        try
        {
            GCJupiterConfigManager.configuration.load();

            GCJupiterConfigManager.dimensionIDJupiter = GCJupiterConfigManager.configuration.get("Dimensions", "Jupiter Dimension ID", -41).getInt(-41);
        
            GCJupiterConfigManager.idItemJupiterBasic = GCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemJupiterItemBasic", 9756).getInt(9756);
            GCJupiterConfigManager.idItemSpaceshipTier5 = GCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier5", 7545).getInt(7545);

            GCJupiterConfigManager.idEntitySpaceshipTier5 = GCJupiterConfigManager.configuration.get("Entities", "idEntitySpaceshipTier5", 175).getInt(175);
            
            GCJupiterConfigManager.idGuiRocketCraftingBenchT5 = GCJupiterConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT5", 145).getInt(145);
            
            GCJupiterConfigManager.idSchematicRocketT5 = GCJupiterConfigManager.configuration.get("Schematic", "idSchematicRocketT5", 5).getInt(5);
        
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Jupiter has a problem loading it's configuration");
        }
        finally
        {
            GCJupiterConfigManager.configuration.save();
            GCJupiterConfigManager.loaded = true;
        }
    }
}
