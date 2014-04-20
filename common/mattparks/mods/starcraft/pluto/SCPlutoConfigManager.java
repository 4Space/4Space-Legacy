package mattparks.mods.starcraft.pluto;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCPlutoConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDPluto;

    // ITEMS
    public static int idItemPlutoBasic;

    // BLOCKS

    // ARMOR
    public static int idArmorBlueGemHelmet;
    
    public static int idArmorBlueGemChestplate;
    public static int idArmorBlueGemLeggings;
    public static int idArmorBlueGemBoots;
    // TOOLS
    public static int idToolBlueGemSword;

    public static int idToolBlueGemPickaxe;
    public static int idToolBlueGemAxe;
    public static int idToolBlueGemSpade;
    public static int idToolBlueGemHoe;
    public static boolean generateOtherMods;

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
  
    public SCPlutoConfigManager(File file)
    {
        if (!SCPlutoConfigManager.loaded)
        {
            SCPlutoConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCPlutoConfigManager.configuration.load();

            SCPlutoConfigManager.dimensionIDPluto = SCPlutoConfigManager.configuration.get("Dimensions", "Venus Dimension ID", -47).getInt(-47);

            SCPlutoConfigManager.idItemPlutoBasic = SCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenusItemBasic", 7654).getInt(7654);

            SCPlutoConfigManager.idArmorBlueGemHelmet = SCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorBlueGemHelmet", 1952).getInt(1952);
            SCPlutoConfigManager.idArmorBlueGemChestplate = SCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorBlueGemChestplate", 1953).getInt(1953);
            SCPlutoConfigManager.idArmorBlueGemLeggings = SCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorBlueGemLeggings", 1954).getInt(1954);
            SCPlutoConfigManager.idArmorBlueGemBoots = SCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorBlueGemBoots", 1955).getInt(1955);
            
            SCPlutoConfigManager.idToolBlueGemSword = SCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolBlueGemSword", 1956).getInt(1956);
            SCPlutoConfigManager.idToolBlueGemPickaxe = SCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolBlueGemPickaxe", 1957).getInt(1957);
            SCPlutoConfigManager.idToolBlueGemSpade = SCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolBlueGemSpade", 1958).getInt(1958);
            SCPlutoConfigManager.idToolBlueGemHoe = SCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolBlueGemHoe", 1959).getInt(1959);
            SCPlutoConfigManager.idToolBlueGemAxe = SCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolBlueGemAxe", 1960).getInt(1960);
            
            
            //Block id's 7755-7756 are used by Starcraft mercury
            
            SCPlutoConfigManager.generateOtherMods = SCPlutoConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Pluto", false).getBoolean(false);        
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Pluto has a problem loading it's configuration");
        }
        finally
        {
            SCPlutoConfigManager.configuration.save();
            SCPlutoConfigManager.loaded = true;
        }
    }
}
