package mattparks.mods.starcraft.sedna;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCSednaConfigManager
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
  
    public SCSednaConfigManager(File file)
    {
        if (!SCSednaConfigManager.loaded)
        {
            SCSednaConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCSednaConfigManager.configuration.load();

            SCSednaConfigManager.dimensionIDSedna = SCSednaConfigManager.configuration.get("Dimensions", "Sedna Dimension ID", -53).getInt(-53);

//            GCPlutoConfigManager.idBlockPluto = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockSedna", 7653).getInt(7653);
     
            SCSednaConfigManager.idItemSednaBasic = SCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSednaBasic", 3653).getInt(3653);

            SCSednaConfigManager.idArmorGravityHelmet = SCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGravityHelmet", 6867).getInt(6867);
            SCSednaConfigManager.idArmorGravityChestplate = SCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGravityChestplate", 6868).getInt(6868);
            SCSednaConfigManager.idArmorGravityLeggings = SCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGravityLeggings", 6869).getInt(6869);
            SCSednaConfigManager.idArmorGravityBoots = SCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGravityBoots", 6870).getInt(6870);

            SCSednaConfigManager.idEntityEvolvedEnderman = SCSednaConfigManager.configuration.get("Entities", "idEntityEvolvedEnderman", 192).getInt(192);
            
            SCSednaConfigManager.idItemSpaceshipTier6 = SCSednaConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier6", 6545).getInt(6545);
            
            SCSednaConfigManager.idEntitySpaceshipTier6 = SCSednaConfigManager.configuration.get("Entities", "idEntitySpaceshipTier6", 675).getInt(675);
            
            SCSednaConfigManager.idGuiRocketCraftingBenchT5 = SCSednaConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT5", 645).getInt(645);
            
            SCSednaConfigManager.idSchematicRocketT5 = SCSednaConfigManager.configuration.get("Schematic", "idSchematicRocketT5", 6).getInt(6);
            
            //Block id's 7755-7756 are used by Starcraft mercury
            
            SCSednaConfigManager.generateOtherMods = SCSednaConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Eris", false).getBoolean(false);        
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Eris has a problem loading it's configuration");
        }
        finally
        {
            SCSednaConfigManager.configuration.save();
            SCSednaConfigManager.loaded = true;
        }
    }
}
