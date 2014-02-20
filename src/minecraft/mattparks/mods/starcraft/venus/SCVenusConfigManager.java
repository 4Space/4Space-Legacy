package mattparks.mods.starcraft.venus;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SCVenusConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDVenus;

    // ITEMS
    public static int idItemVenusBasic;
    public static int idVurnBerryOnAStick;

    // BLOCKS

    public static int idItemVenusBattery;
    public static int idTtemVenusT3Schematic;
    public static int idVurnBerry;
    
    public static int idItemSpaceshipTier3;
    
    // ARMOR
    public static int idArmorSulferHelmet;
    
    public static int idArmorSulferChestplate;
    public static int idArmorSulferLeggings;
    public static int idArmorSulferBoots;
    public static int idArmorGemHelmet;
    
    public static int idArmorGemChestplate;
    public static int idArmorGemLeggings;
    public static int idArmorGemBoots;
    // TOOLS
    public static int idToolSulferSword;

    public static int idToolSulferPickaxe;
    public static int idToolSulferAxe;
    public static int idToolSulferSpade;
    public static int idToolSulferHoe;
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
    
    // ACHIEVEMENTS
    public static int idEntityEvolvedBlaze;

    public static int idEntityVenusianVillager;
    public static int idEntityFlameling;
    // GENERAL
    public static boolean disableGemOreVenus;
    
    public static boolean disableSulferOreVenus;
    public static boolean disableMeteorOreVenus;
    public static boolean disableIronOreVenus;
    public static boolean disableCoalOreVenus;
    public static boolean disableTinOreVenus;  
    public static boolean disableCopperOreVenus;
    public static boolean generateOtherMods;
  
    public static boolean disableVenusVillageGen;
    public SCVenusConfigManager(File file)
    {
        if (!SCVenusConfigManager.loaded)
        {
            SCVenusConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            SCVenusConfigManager.configuration.load();

            SCVenusConfigManager.dimensionIDVenus = SCVenusConfigManager.configuration.get("Dimensions", "Venus Dimension ID", -47).getInt(-47);

            SCVenusConfigManager.idArmorGemHelmet = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemHelmet", 7852).getInt(7852);
            SCVenusConfigManager.idArmorGemChestplate = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemChestplate", 7853).getInt(7853);
            SCVenusConfigManager.idArmorGemLeggings = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemLeggings", 7854).getInt(7854);
            SCVenusConfigManager.idArmorGemBoots = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemBoots", 7855).getInt(7855);
            
            SCVenusConfigManager.idToolGemSword = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSword", 7856).getInt(7856);
            SCVenusConfigManager.idToolGemPickaxe = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemPickaxe", 7857).getInt(7857);
            SCVenusConfigManager.idToolGemSpade = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSpade", 7858).getInt(7858);
            SCVenusConfigManager.idToolGemHoe = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemHoe", 7859).getInt(7859);
            SCVenusConfigManager.idToolGemAxe = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemAxe", 7860).getInt(7860);
            
            SCVenusConfigManager.idArmorSulferHelmet = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferHelmet", 7861).getInt(7861);
            SCVenusConfigManager.idArmorSulferChestplate = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferChestplate", 7862).getInt(7862);
            SCVenusConfigManager.idArmorSulferLeggings = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferLeggings", 7863).getInt(7863);
            SCVenusConfigManager.idArmorSulferBoots = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferBoots", 7864).getInt(7864);
            
            SCVenusConfigManager.idToolSulferSword = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferSword", 7865).getInt(7865);
            SCVenusConfigManager.idToolSulferPickaxe = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferPickaxe", 7866).getInt(7866);
            SCVenusConfigManager.idToolSulferSpade = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferSpade", 7867).getInt(7867);
            SCVenusConfigManager.idToolSulferHoe = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferHoe", 7868).getInt(7868);
            SCVenusConfigManager.idToolSulferAxe = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferAxe", 7869).getInt(7869);

            SCVenusConfigManager.idItemVenusBasic = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenusItemBasic", 7870).getInt(7870);
            SCVenusConfigManager.idItemVenusBattery = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusBattery", 7871).getInt(7871);
            
            SCVenusConfigManager.idVurnBerry = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idVurnBerry", 7872).getInt(7872);
            SCVenusConfigManager.idVurnBerryOnAStick = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idVurnBerryOnAStick", 7879).getInt(7879);

            
            SCVenusConfigManager.idTtemVenusT3Schematic = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idTtemVenusT3Schematic", 7873).getInt(7873);
            SCVenusConfigManager.idItemSpaceshipTier3 = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier3", 7874).getInt(7874);
            
            SCVenusConfigManager.idEntitySpaceshipTier3 = SCVenusConfigManager.configuration.get("Entities", "idEntitySpaceshipTier3", 173).getInt(173);
            
            SCVenusConfigManager.idGuiRocketCraftingBenchT3 = SCVenusConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT3", 143).getInt(143);
            
            SCVenusConfigManager.idSchematicRocketT3 = SCVenusConfigManager.configuration.get("Schematic", "idSchematicRocketT3", 3).getInt(3);

            SCVenusConfigManager.idEntityEvolvedBlaze = SCVenusConfigManager.configuration.get("Entities", "idEntityEvolvedBlaze", 193).getInt(193);
            SCVenusConfigManager.idEntityVenusianVillager = SCVenusConfigManager.configuration.get("Entities", "idEntityVenusianVillager", 194).getInt(194);
            SCVenusConfigManager.idEntityFlameling = SCVenusConfigManager.configuration.get("Entities", "idEntityFlameling", 195).getInt(195);
            
            SCVenusConfigManager.disableGemOreVenus = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Gem Ore Gen on Venus", false).getBoolean(false);
            SCVenusConfigManager.disableMeteorOreVenus = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Meteor Ore Gen on Venus", false).getBoolean(false);
            SCVenusConfigManager.disableSulferOreVenus = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Sulfer Ore Gen on Venus", false).getBoolean(false);
            SCVenusConfigManager.disableIronOreVenus = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Iron Ore Gen on Venus", false).getBoolean(false);
            SCVenusConfigManager.disableCoalOreVenus = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Coal Ore Gen on Venus", false).getBoolean(false);
            SCVenusConfigManager.disableTinOreVenus = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Tin Ore Gen on Venus", false).getBoolean(false);
            SCVenusConfigManager.disableCopperOreVenus = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Copper Ore Gen on Venus", false).getBoolean(false);

            SCVenusConfigManager.generateOtherMods = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Venus", false).getBoolean(false);        
            SCVenusConfigManager.disableVenusVillageGen = SCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Venus Village Gen", false).getBoolean(false);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Venus has a problem loading it's configuration");
        }
        finally
        {
            SCVenusConfigManager.configuration.save();
            SCVenusConfigManager.loaded = true;
        }
    }
}
