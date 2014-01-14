package mattparks.mods.starcraft.sedna;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCSednaConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDSedna;

    // BLOCKS
    public static int idBlockSedna;

    // ITEMS
    public static int idItemSednaBasic;
    public static int idItemSpaceshipTier6;

    // ARMOR
    public static int idArmorGravityHelmet;
    
    public static int idArmorGravityChestplate;
    public static int idArmorGravityLeggings;
    public static int idArmorGravityBoots;
    // ACHIEVEMENTS
    public static int idEntityEvolvedEnderman;

    // TOOLS

    // ENTITIES
    public static int idEntitySpaceshipTier6;

    // GUI
    public static int idGuiRocketCraftingBenchT5;

    // SCHEMATIC
    public static int idSchematicRocketT5;

    public static boolean generateOtherMods;

    // GENERAL
  
    public GCSednaConfigManager(File file)
    {
        if (!GCSednaConfigManager.loaded)
        {
            GCSednaConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            GCSednaConfigManager.configuration.load();

            GCSednaConfigManager.dimensionIDSedna = GCSednaConfigManager.configuration.get("Dimensions", "Sedna Dimension ID", -53).getInt(-53);

//            GCPlutoConfigManager.idBlockPluto = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockSedna", 7653).getInt(7653);
     
            GCSednaConfigManager.idItemSednaBasic = GCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSednaBasic", 3653).getInt(3653);

            GCSednaConfigManager.idArmorGravityHelmet = GCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGravityHelmet", 6867).getInt(6867);
            GCSednaConfigManager.idArmorGravityChestplate = GCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGravityChestplate", 6868).getInt(6868);
            GCSednaConfigManager.idArmorGravityLeggings = GCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGravityLeggings", 6869).getInt(6869);
            GCSednaConfigManager.idArmorGravityBoots = GCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGravityBoots", 6870).getInt(6870);

            GCSednaConfigManager.idEntityEvolvedEnderman = GCSednaConfigManager.configuration.get("Entities", "idEntityEvolvedEnderman", 693).getInt(693);
            
            GCSednaConfigManager.idItemSpaceshipTier6 = GCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier6", 6545).getInt(6545);
            
            GCSednaConfigManager.idEntitySpaceshipTier6 = GCSednaConfigManager.configuration.get("Entities", "idEntitySpaceshipTier6", 675).getInt(675);
            
            GCSednaConfigManager.idGuiRocketCraftingBenchT5 = GCSednaConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT5", 645).getInt(645);
            
            GCSednaConfigManager.idSchematicRocketT5 = GCSednaConfigManager.configuration.get("Schematic", "idSchematicRocketT5", 6).getInt(6);
            
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
