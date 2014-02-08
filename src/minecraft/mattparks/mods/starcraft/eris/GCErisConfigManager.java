package mattparks.mods.starcraft.eris;

import java.io.File;
import java.util.logging.Level;

import mattparks.mods.starcraft.core.StarcraftEris;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class GCErisConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDEris;

    // ITEMS
    public static int idItemErisBasic;

    // BLOCKS

    public static int idErisGrass;
    public static int idErisDirt;
    public static int idErisStone;
    public static int idErisCobblestone;
    public static int idErisBrick;
    public static int idErisCoalOre;
    public static int idErisGreenGemOre;
    public static int idErisIronOre;
    public static int idErisMeteorOre;
	public static int idErisTinOre;
	public static int idGreenGemBlock;
    
    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
	public static boolean generateOtherMods;
  
    public GCErisConfigManager(File file)
    {
        if (!GCErisConfigManager.loaded)
        {
            GCErisConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            GCErisConfigManager.configuration.load();

            GCErisConfigManager.dimensionIDEris = GCErisConfigManager.configuration.get("Dimensions", "Eris Dimension ID", -40).getInt(-40);

            GCErisConfigManager.idItemErisBasic = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemErisBasic", 9654).getInt(9654);

            GCErisConfigManager.idErisGrass = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idErisGrass", 9655).getInt(9655);
            GCErisConfigManager.idErisDirt = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idErisDirt", 9656).getInt(9656);
            GCErisConfigManager.idErisStone = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idErisStone", 9657).getInt(9657);
            GCErisConfigManager.idErisCobblestone = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idErisCobblestone", 9658).getInt(9658);
            GCErisConfigManager.idErisBrick = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idErisBrick", 9659).getInt(9659);
            GCErisConfigManager.idErisCoalOre = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idErisCoalOre", 9660).getInt(9660);
            GCErisConfigManager.idErisGreenGemOre = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idErisGreenGemOre", 9661).getInt(9661);
            GCErisConfigManager.idErisIronOre = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idErisIronOre", 9662).getInt(9662);
            GCErisConfigManager.idErisMeteorOre = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idErisMeteorOre", 9663).getInt(9663);
            GCErisConfigManager.idErisTinOre = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idErisTinOre", 9664).getInt(9664);
            GCErisConfigManager.idGreenGemBlock = GCErisConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idGreenGemBlock", 9665).getInt(9665);

            GCErisConfigManager.generateOtherMods = GCErisConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Eris", false).getBoolean(false);        
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft Eris has a problem loading it's configuration");
        }
        finally
        {
            GCErisConfigManager.configuration.save();
            GCErisConfigManager.loaded = true;
        }
    }
}
