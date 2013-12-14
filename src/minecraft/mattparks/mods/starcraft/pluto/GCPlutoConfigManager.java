package mattparks.mods.starcraft.pluto;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCPlutoConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCPlutoConfigManager(File file)
    {
        if (!GCPlutoConfigManager.loaded)
        {
            GCPlutoConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS
    public static int dimensionIDPluto;

    // BLOCKS

    // ITEMS
    public static int idItemPlutoBasic;
    
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

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
  
    public static boolean generateOtherMods;

    private void setDefaultValues()
    {
        try
        {
            GCPlutoConfigManager.configuration.load();

            GCPlutoConfigManager.dimensionIDPluto = GCPlutoConfigManager.configuration.get("Dimensions", "Venus Dimension ID", -44).getInt(-44);

            GCPlutoConfigManager.idItemPlutoBasic = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenusItemBasic", 7654).getInt(7654);

            GCPlutoConfigManager.idArmorBlueGemHelmet = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorBlueGemHelmet", 1952).getInt(1952);
            GCPlutoConfigManager.idArmorBlueGemChestplate = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorBlueGemChestplate", 1953).getInt(1953);
            GCPlutoConfigManager.idArmorBlueGemLeggings = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorBlueGemLeggings", 1954).getInt(1954);
            GCPlutoConfigManager.idArmorBlueGemBoots = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorBlueGemBoots", 1955).getInt(1955);
            
            GCPlutoConfigManager.idToolBlueGemSword = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolBlueGemSword", 1956).getInt(1956);
            GCPlutoConfigManager.idToolBlueGemPickaxe = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolBlueGemPickaxe", 1957).getInt(1957);
            GCPlutoConfigManager.idToolBlueGemSpade = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolBlueGemSpade", 1958).getInt(1958);
            GCPlutoConfigManager.idToolBlueGemHoe = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolBlueGemHoe", 1959).getInt(1959);
            GCPlutoConfigManager.idToolBlueGemAxe = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolBlueGemAxe", 1960).getInt(1960);
            
            
            //Block id's 7755-7756 are used by Starcraft mercury
            
            GCPlutoConfigManager.generateOtherMods = GCPlutoConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Pluto", false).getBoolean(false);        
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Pluto has a problem loading it's configuration");
        }
        finally
        {
            GCPlutoConfigManager.configuration.save();
            GCPlutoConfigManager.loaded = true;
        }
    }
}
