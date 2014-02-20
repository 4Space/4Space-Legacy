package mattparks.mods.starcraft.mercury;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCMercuryConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDMercury;

    // BLOCKS
    public static int idBlockMercury;

    // ITEMS
    public static int idItemMercuryBasic;

    public static int idTtemMercuryT4Schematic;
    public static int idItemSpaceshipTier4;
    // ARMOR
    public static int idArmorJetpack;
    
    public static int idArmorIridiumHelmet;
 
    public static int idArmorIridiumChestplate;
    public static int idArmorIridiumLeggings;
    public static int idArmorIridiumBoots;
    public static int idToolIridiumSword;

    // TOOLS
 
    public static int idToolIridiumPickaxe;
    public static int idToolIridiumAxe;
    public static int idToolIridiumSpade;
    public static int idToolIridiumHoe;
    // ENTITIES
    public static int idEntitySpaceshipTier4;

    // GUI
    public static int idGuiRocketCraftingBenchT4;

    // SCHEMATIC
    public static int idSchematicRocketT4;

    // GENERAL
    public static boolean disableGemOreMercury;

    // ACHIEVEMENTS

    public static boolean disableCoalOreMercury;
    public static boolean disableTinOreMercury;  
    public static boolean disableCopperOreMercury;
    public static boolean generateOtherMods;
  
    public static boolean disableMercuryVillageGen;
    public SCMercuryConfigManager(File file)
    {
        if (!SCMercuryConfigManager.loaded)
        {
            SCMercuryConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCMercuryConfigManager.configuration.load();

            SCMercuryConfigManager.dimensionIDMercury = SCMercuryConfigManager.configuration.get("Dimensions", "Venus Dimension ID", -42).getInt(-42);

            SCMercuryConfigManager.idBlockMercury = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenus", 7755).getInt(7755);
     
            SCMercuryConfigManager.idItemMercuryBasic = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenusItemBasic", 7756).getInt(7756);
            SCMercuryConfigManager.idTtemMercuryT4Schematic = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idTtemMercuryT4Schematic", 7757).getInt(7757);
            SCMercuryConfigManager.idItemSpaceshipTier4 = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier4", 7544).getInt(7544);
            
            SCMercuryConfigManager.idArmorJetpack = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorJetpack", 7551).getInt(7551);
            
            SCMercuryConfigManager.idArmorIridiumHelmet = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorIridiumHelmet", 9652).getInt(9652);
            SCMercuryConfigManager.idArmorIridiumChestplate = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorIridiumChestplate", 9653).getInt(9653);
            SCMercuryConfigManager.idArmorIridiumLeggings = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorIridiumLeggings", 9654).getInt(9654);
            SCMercuryConfigManager.idArmorIridiumBoots = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorIridiumBoots", 9655).getInt(9655);
            
            SCMercuryConfigManager.idToolIridiumSword = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolIridiumSword", 9656).getInt(9656);
            SCMercuryConfigManager.idToolIridiumPickaxe = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolIridiumPickaxe", 9657).getInt(9657);
            SCMercuryConfigManager.idToolIridiumSpade = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolIridiumSpade", 9658).getInt(9658);
            SCMercuryConfigManager.idToolIridiumHoe = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolIridiumHoe", 9659).getInt(9659);
            SCMercuryConfigManager.idToolIridiumAxe = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolIridiumAxe", 9660).getInt(9660);
            
            
            
            //Block id's 7857-7870 used by Spacecraft Venus
            
            SCMercuryConfigManager.idEntitySpaceshipTier4 = SCMercuryConfigManager.configuration.get("Entities", "idEntitySpaceshipTier4", 174).getInt(174);
    
            SCMercuryConfigManager.idGuiRocketCraftingBenchT4 = SCMercuryConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT4", 144).getInt(144);

            SCMercuryConfigManager.idSchematicRocketT4 = SCMercuryConfigManager.configuration.get("Schematic", "idSchematicRocketT4", 4).getInt(4);

            SCMercuryConfigManager.disableGemOreMercury = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Gem Ore Gen on Mercury", false).getBoolean(false);
            SCMercuryConfigManager.disableCoalOreMercury = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Coal Ore Gen on Mercury", false).getBoolean(false);
            SCMercuryConfigManager.disableTinOreMercury = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Tin Ore Gen on Mercury", false).getBoolean(false);
            SCMercuryConfigManager.disableCopperOreMercury = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Copper Ore Gen on Mercury", false).getBoolean(false);

            SCMercuryConfigManager.generateOtherMods = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Mercury", false).getBoolean(false);        
            SCMercuryConfigManager.disableMercuryVillageGen = SCMercuryConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Mercury Village Gen", false).getBoolean(false);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Mercury has a problem loading it's configuration");
        }
        finally
        {
            SCMercuryConfigManager.configuration.save();
            SCMercuryConfigManager.loaded = true;
        }
    }
}
