package spacecraft.mods.galacticraft.mercury;

import java.io.File;
import java.util.logging.Level;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCMercuryConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public GCMercuryConfigManager(File file)
    {
        if (!GCMercuryConfigManager.loaded)
        {
            GCMercuryConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    // DIMENSIONS
    public static int dimensionIDMercury;

    // BLOCKS
    public static int idBlockMercury;

    // ITEMS
    public static int idItemMercuryBasic;
    
    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
    public static boolean disableGemOreMercury;
    public static boolean disableCoalOreMercury;  
    public static boolean disableTinOreMercury;
    public static boolean disableCopperOreMercury;
  
    public static boolean generateOtherMods;
    public static boolean disableMercuryVillageGen;

    private void setDefaultValues()
    {
        try
        {
            GCMercuryConfigManager.configuration.load();

            GCMercuryConfigManager.dimensionIDMercury = GCMercuryConfigManager.configuration.get("Dimensions", "Venus Dimension ID", -47).getInt(-47);

            GCMercuryConfigManager.idBlockMercury = GCMercuryConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenus", 7755).getInt(7755);
     
            GCMercuryConfigManager.idItemMercuryBasic = GCMercuryConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenusItemBasic", 7756).getInt(7756);

            //Block id's 7857-7870 used by Spacecraft Venus
            
            GCMercuryConfigManager.disableGemOreMercury = GCMercuryConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Gem Ore Gen on Mercury", false).getBoolean(false);
            GCMercuryConfigManager.disableCoalOreMercury = GCMercuryConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Coal Ore Gen on Mercury", false).getBoolean(false);
            GCMercuryConfigManager.disableTinOreMercury = GCMercuryConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Tin Ore Gen on Mercury", false).getBoolean(false);
            GCMercuryConfigManager.disableCopperOreMercury = GCMercuryConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Copper Ore Gen on Mercury", false).getBoolean(false);

            GCMercuryConfigManager.generateOtherMods = GCMercuryConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Mercury", false).getBoolean(false);        
            GCMercuryConfigManager.disableMercuryVillageGen = GCMercuryConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Mercury Village Gen", false).getBoolean(false);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Mercury has a problem loading it's configuration");
        }
        finally
        {
            GCMercuryConfigManager.configuration.save();
            GCMercuryConfigManager.loaded = true;
        }
    }
}
