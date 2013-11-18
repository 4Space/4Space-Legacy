package mattparks.mods.starcraft.venus;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCVenusConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCVenusConfigManager(File file)
    {
        if (!GCVenusConfigManager.loaded)
        {
            GCVenusConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS
    public static int dimensionIDVenus;

    // BLOCKS
    public static int idBlockVenus;
    public static int idBlockBlazeEgg;
    public static int idBlockBasaltSlab;


    // ITEMS
    public static int idItemVenusBasic;
    public static int idItemVenusBattery;
    public static int idTtemVenusT3Schematic;
    
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

    private void setDefaultValues()
    {
        try
        {
            GCVenusConfigManager.configuration.load();

            GCVenusConfigManager.dimensionIDVenus = GCVenusConfigManager.configuration.get("Dimensions", "Venus Dimension ID", -47).getInt(-47);

            GCVenusConfigManager.idBlockVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenus", 7857).getInt(7857);
            GCVenusConfigManager.idBlockBlazeEgg = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockBlazeEgg", 7858).getInt(7858);
            GCVenusConfigManager.idBlockBasaltSlab = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockBasaltSlab", 7859).getInt(7859);
      
            GCVenusConfigManager.idItemVenusBasic = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenusItemBasic", 7860).getInt(7860);
            GCVenusConfigManager.idItemVenusBattery = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusBattery", 7861).getInt(7861);

            GCVenusConfigManager.idToolSulferSword = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferSword", 7862).getInt(7862);
            GCVenusConfigManager.idToolSulferPickaxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferPickaxe", 7863).getInt(7863);
            GCVenusConfigManager.idToolSulferSpade = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferSpade", 7864).getInt(7864);
            GCVenusConfigManager.idToolSulferHoe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferHoe", 7865).getInt(7865);
            GCVenusConfigManager.idToolSulferAxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferAxe", 7866).getInt(7866);

            GCVenusConfigManager.idToolGemSword = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSword", 7546).getInt(7546);
            GCVenusConfigManager.idToolGemPickaxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemPickaxe", 7547).getInt(7547);
            GCVenusConfigManager.idToolGemSpade = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSpade", 7548).getInt(7548);
            GCVenusConfigManager.idToolGemHoe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemHoe", 7549).getInt(7549);
            GCVenusConfigManager.idToolGemAxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemAxe", 7550).getInt(7550);
            
            GCVenusConfigManager.idArmorSulferHelmet = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferHelmet", 7867).getInt(7867);
            GCVenusConfigManager.idArmorSulferChestplate = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferChestplate", 7868).getInt(7868);
            GCVenusConfigManager.idArmorSulferLeggings = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferLeggings", 7869).getInt(7869);
            GCVenusConfigManager.idArmorSulferBoots = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferBoots", 7870).getInt(7870);

            GCVenusConfigManager.idArmorGemHelmet = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemHelmet", 7552).getInt(7582);
            GCVenusConfigManager.idArmorGemChestplate = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemChestplate", 7553).getInt(753);
            GCVenusConfigManager.idArmorGemLeggings = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemLeggings", 7554).getInt(7554);
            GCVenusConfigManager.idArmorGemBoots = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemBoots", 7555).getInt(7555);
            
            GCVenusConfigManager.idTtemVenusT3Schematic = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idTtemVenusT3Schematic", 7892).getInt(7892);
            GCVenusConfigManager.idItemSpaceshipTier3 = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemSpaceshipTier3", 7543).getInt(7543);
            
            GCVenusConfigManager.idEntityEvolvedBlaze = GCVenusConfigManager.configuration.get("Entities", "idEntityEvolvedBlaze", 289).getInt(289);
            GCVenusConfigManager.idEntityVenusianVillager = GCVenusConfigManager.configuration.get("Entities", "idEntityVenusianVillager", 290).getInt(290);
            GCVenusConfigManager.idEntityFlameling = GCVenusConfigManager.configuration.get("Entities", "idEntityFlameling", 292).getInt(291);

            GCVenusConfigManager.idEntitySpaceshipTier3 = GCVenusConfigManager.configuration.get("Entities", "idEntitySpaceshipTier3", 173).getInt(173);
            
            GCVenusConfigManager.idGuiRocketCraftingBenchT3 = GCVenusConfigManager.configuration.get("GUI", "idGuiRocketCraftingBenchT3", 143).getInt(143);
            
            GCVenusConfigManager.idSchematicRocketT3 = GCVenusConfigManager.configuration.get("Schematic", "idSchematicRocketT3", 3).getInt(3);

            GCVenusConfigManager.disableGemOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Gem Ore Gen on Venus", false).getBoolean(false);
            GCVenusConfigManager.disableMeteorOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Meteor Ore Gen on Venus", false).getBoolean(false);
            GCVenusConfigManager.disableSulferOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Sulfer Ore Gen on Venus", false).getBoolean(false);
            GCVenusConfigManager.disableIronOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Iron Ore Gen on Venus", false).getBoolean(false);
            GCVenusConfigManager.disableCoalOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Coal Ore Gen on Venus", false).getBoolean(false);
            GCVenusConfigManager.disableTinOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Tin Ore Gen on Venus", false).getBoolean(false);
            GCVenusConfigManager.disableCopperOreVenus = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Copper Ore Gen on Venus", false).getBoolean(false);

            GCVenusConfigManager.generateOtherMods = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Venus", false).getBoolean(false);        
            GCVenusConfigManager.disableVenusVillageGen = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Venus Village Gen", false).getBoolean(false);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Venus has a problem loading it's configuration");
        }
        finally
        {
            GCVenusConfigManager.configuration.save();
            GCVenusConfigManager.loaded = true;
        }
    }
}
