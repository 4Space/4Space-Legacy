package mattparks.mods.starcraft.moons;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCJupiterConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDJupiter;

    // ITEMS
    public static int idItemJupiterBasic;

    // BLOCKS

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
    
    public static boolean generateOtherMods;

    // ACHIEVEMENTS

    // GENERAL
  
    public SCJupiterConfigManager(File file)
    {
        if (!SCJupiterConfigManager.loaded)
        {
            SCJupiterConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCJupiterConfigManager.configuration.load();

            SCJupiterConfigManager.dimensionIDJupiter = SCJupiterConfigManager.configuration.get("Dimensions", "Jupiter Dimension ID", -43).getInt(-43);
        
            SCJupiterConfigManager.idItemJupiterBasic = SCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemJupiterItemBasic", 9756).getInt(9756);
            SCJupiterConfigManager.idItemSpaceshipTier5 = SCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier5", 7545).getInt(7545);

            SCJupiterConfigManager.idArmorClearDiamondHelmet = SCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorClearDiamondHelmet", 2652).getInt(2652);
            SCJupiterConfigManager.idArmorClearDiamondChestplate = SCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorClearDiamondChestplate", 2753).getInt(2753);
            SCJupiterConfigManager.idArmorClearDiamondLeggings = SCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorClearDiamondLeggings", 2754).getInt(2754);
            SCJupiterConfigManager.idArmorClearDiamondBoots = SCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorClearDiamondBoots", 2755).getInt(2755);
            
            SCJupiterConfigManager.idToolClearDiamondSword = SCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolClearDiamondSword", 2756).getInt(2756);
            SCJupiterConfigManager.idToolClearDiamondPickaxe = SCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolClearDiamondPickaxe", 2757).getInt(2757);
            SCJupiterConfigManager.idToolClearDiamondSpade = SCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolClearDiamondSpade", 2758).getInt(2758);
            SCJupiterConfigManager.idToolClearDiamondHoe = SCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolClearDiamondHoe", 2759).getInt(2759);
            SCJupiterConfigManager.idToolClearDiamondAxe = SCJupiterConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolClearDiamondAxe", 2760).getInt(2760);
            
            SCJupiterConfigManager.idEntitySpaceshipTier5 = SCJupiterConfigManager.configuration.get("Entities", "idEntitySpaceshipTier5", 175).getInt(175);
            
            SCJupiterConfigManager.idGuiRocketCraftingBenchT5 = SCJupiterConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT5", 145).getInt(145);
            
            SCJupiterConfigManager.idSchematicRocketT5 = SCJupiterConfigManager.configuration.get("Schematic", "idSchematicRocketT5", 5).getInt(5);
        
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Jupiter has a problem loading it's configuration");
        }
        finally
        {
            SCJupiterConfigManager.configuration.save();
            SCJupiterConfigManager.loaded = true;
        }
    }
}
