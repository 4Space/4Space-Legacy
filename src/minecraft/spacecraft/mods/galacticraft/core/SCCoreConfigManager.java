package spacecraft.mods.galacticraft.core;

import java.io.File;
import java.util.logging.Level;

import spacecraft.mods.galacticraft.venus.GCVenusConfigManager;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import net.minecraft.item.Item;
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
    public static int idItemSpaceshipTier3;
    public static int idItemSchematicMars;
    public static int idItemRocketEngine;
    public static int idArmorJetpack;
    
    // ARMOR
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
    public static int idEntitySpaceshipTier3;
    
    // GUI
    public static int idGuiRocketCraftingBenchT3;

    // SCHEMATIC
    public static int idSchematicRocketT3;
    public static int idSchematicCargoRocket;

    // ACHIEVEMENTS
    
    // GENERAL

    private void setDefaultValues()
    {
        try
        {
            SCCoreConfigManager.configuration.load();

            SCCoreConfigManager.idItemVenusBasic = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenusItemBasic", 7539).getInt(7539);
            SCCoreConfigManager.idItemSpaceshipTier3 = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier3", 7540).getInt(7540);
            SCCoreConfigManager.idItemSchematicMars = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSchematicMars", 7541).getInt(7541);
            SCCoreConfigManager.idItemRocketEngine = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemRocketEngineMars", 7542).getInt(7542);
            SCCoreConfigManager.idArmorJetpack = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorJetpack", 7543).getInt(7543);

            SCCoreConfigManager.idToolGemSword = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSword", 7544).getInt(7544);
            SCCoreConfigManager.idToolGemPickaxe = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemPickaxe", 7545).getInt(7545);
            SCCoreConfigManager.idToolGemSpade = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSpade", 7546).getInt(7546);
            SCCoreConfigManager.idToolGemHoe = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemHoe", 7547).getInt(7547);
            SCCoreConfigManager.idToolGemAxe = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemAxe", 7548).getInt(7548);

            SCCoreConfigManager.idArmorGemHelmet = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemHelmet", 7549).getInt(7549);
            SCCoreConfigManager.idArmorGemChestplate = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemChestplate", 7550).getInt(7550);
            SCCoreConfigManager.idArmorGemLeggings = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemLeggings", 7551).getInt(7551);
            SCCoreConfigManager.idArmorGemBoots = SCCoreConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemBoots", 7552).getInt(7552);

            //Block id's 7653-7654 are used by Spacecraft Pluto
            
            SCCoreConfigManager.idEntitySpaceshipTier3 = SCCoreConfigManager.configuration.get("Entities", "idEntitySpaceshipTier3", 173).getInt(173);
            SCCoreConfigManager.idGuiRocketCraftingBenchT3 = SCCoreConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT3", 143).getInt(143);

            SCCoreConfigManager.idSchematicRocketT3 = SCCoreConfigManager.configuration.get("Schematic", "idSchematicRocketT3", 2).getInt(2);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Venus has a problem loading it's configuration");
        }
        finally
        {
            SCCoreConfigManager.configuration.save();
            SCCoreConfigManager.loaded = true;
        }
    }
}
