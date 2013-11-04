package mattparks.mods.starcraft.core;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCCoreConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public SCCoreConfigManager(File file)
    {
        if (!SCCoreConfigManager.loaded)
        {
            SCCoreConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS

    // BLOCKS
    
    // ITEMS
    public static int idItemVenusBasic;
    public static int idItemSchematicMars;
    public static int idItemRocketEngine;
    
    public static int idItemSpaceshipTier4;
    public static int idItemSpaceshipTier5;
    
    // ARMOR
    public static int idArmorJetpack;

    public static int idArmorGemHelmet;
    public static int idArmorGemChestplate;
    public static int idArmorGemLeggings;
    public static int idArmorGemBoots;

    // TOOLS
    public static int idToolGemSword;
    public static int idToolGemPickaxe;
    public static int idToolGemAxe;
    public static int idToolGemSpade;
    public static int idToolGemHoe;

    // ENTITIES
    public static int idEntitySpaceshipTier4;
    public static int idEntitySpaceshipTier5;
    
    // GUI
    public static int idGuiRocketCraftingBenchT4;
    public static int idGuiRocketCraftingBenchT5;
    
    // SCHEMATIC
    public static int idSchematicRocketT4;
    public static int idSchematicRocketT5;
	

    // ACHIEVEMENTS
    
    // GENERAL

    private void setDefaultValues()
    {
        try
        {
            SCCoreConfigManager.configuration.load();

            SCCoreConfigManager.idItemVenusBasic = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenusItemBasic", 7540).getInt(7540);
            SCCoreConfigManager.idItemSchematicMars = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSchematicMars", 7541).getInt(7541);
            SCCoreConfigManager.idItemRocketEngine = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemRocketEngine", 7542).getInt(7542);
            
            SCCoreConfigManager.idItemSpaceshipTier4 = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier4", 7544).getInt(7544);
            SCCoreConfigManager.idItemSpaceshipTier5 = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier5", 7545).getInt(7545);

            SCCoreConfigManager.idToolGemSword = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSword", 7546).getInt(7546);
            SCCoreConfigManager.idToolGemPickaxe = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemPickaxe", 7547).getInt(7547);
            SCCoreConfigManager.idToolGemSpade = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSpade", 7548).getInt(7548);
            SCCoreConfigManager.idToolGemHoe = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemHoe", 7549).getInt(7549);
            SCCoreConfigManager.idToolGemAxe = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemAxe", 7550).getInt(7550);

            
            SCCoreConfigManager.idArmorJetpack = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorJetpack", 7551).getInt(7551);
            
            SCCoreConfigManager.idArmorGemHelmet = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemHelmet", 7552).getInt(7582);
            SCCoreConfigManager.idArmorGemChestplate = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemChestplate", 7553).getInt(753);
            SCCoreConfigManager.idArmorGemLeggings = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemLeggings", 7554).getInt(7554);
            SCCoreConfigManager.idArmorGemBoots = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemBoots", 7555).getInt(7555);

            //Block id's 7653-7654 are used by Spacecraft Pluto
            
            SCCoreConfigManager.idEntitySpaceshipTier4 = SCCoreConfigManager.configuration.get("Entities", "idEntitySpaceshipTier4", 174).getInt(174);
            SCCoreConfigManager.idEntitySpaceshipTier5 = SCCoreConfigManager.configuration.get("Entities", "idEntitySpaceshipTier5", 175).getInt(175);
            
            SCCoreConfigManager.idGuiRocketCraftingBenchT4 = SCCoreConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT4", 144).getInt(144);
            SCCoreConfigManager.idGuiRocketCraftingBenchT5 = SCCoreConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT5", 145).getInt(145);
            
            SCCoreConfigManager.idSchematicRocketT4 = SCCoreConfigManager.configuration.get("Schematic", "idSchematicRocketT4", 4).getInt(4);
            SCCoreConfigManager.idSchematicRocketT5 = SCCoreConfigManager.configuration.get("Schematic", "idSchematicRocketT5", 5).getInt(5);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Core has a problem loading it's configuration");
        }
        finally
        {
            SCCoreConfigManager.configuration.save();
            SCCoreConfigManager.loaded = true;
        }
    }
}
