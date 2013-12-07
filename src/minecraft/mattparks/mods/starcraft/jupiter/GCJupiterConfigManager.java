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
    public static int idArmorClearDiamondHelmet;
    public static int idArmorClearDiamondChestplate;
    public static int idArmorClearDiamondLeggings;
    public static int idArmorClearDiamondBoots;

    // TOOLS
    public static int idToolClearDiamondSword;
    public static int idToolClearDiamondPickaxe;
    public static int idToolClearDiamondAxe;
    public static int idToolClearDiamondSpade;
    public static int idToolClearDiamondHoe;

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

            GCJupiterConfigManager.idArmorClearDiamondHelmet = GCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorClearDiamondHelmet", 2852).getInt(2852);
            GCJupiterConfigManager.idArmorClearDiamondChestplate = GCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorClearDiamondChestplate", 2753).getInt(2753);
            GCJupiterConfigManager.idArmorClearDiamondLeggings = GCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorClearDiamondLeggings", 2754).getInt(2754);
            GCJupiterConfigManager.idArmorClearDiamondBoots = GCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorClearDiamondBoots", 2755).getInt(2755);
            
            GCJupiterConfigManager.idToolClearDiamondSword = GCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolClearDiamondSword", 2756).getInt(2756);
            GCJupiterConfigManager.idToolClearDiamondPickaxe = GCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolClearDiamondPickaxe", 2757).getInt(2757);
            GCJupiterConfigManager.idToolClearDiamondSpade = GCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolClearDiamondSpade", 2758).getInt(2758);
            GCJupiterConfigManager.idToolClearDiamondHoe = GCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolClearDiamondHoe", 2759).getInt(2759);
            GCJupiterConfigManager.idToolClearDiamondAxe = GCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolClearDiamondAxe", 2760).getInt(2760);
            
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
