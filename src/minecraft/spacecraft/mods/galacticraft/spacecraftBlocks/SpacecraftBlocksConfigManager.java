package spacecraft.mods.galacticraft.spacecraftBlocks;

import java.io.File;
import java.util.logging.Level;

import micdoodle8.mods.galacticraft.core.GCLog;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class SpacecraftBlocksConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    public SpacecraftBlocksConfigManager(File file)
    {
        if (!SpacecraftBlocksConfigManager.loaded)
        {
            SpacecraftBlocksConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    //Rocket

    // DIMENSIONS

    // BLOCKS
    public static int idVenusGrass;
    public static int idVenusDirt;
    public static int idVenusStone;
    public static int idVenusCobblestone;
    public static int idVenusRedGemBlock;
    public static int idVenusMeteorBlock;
    public static int idVenusBrick;
    public static int idVenusSulferBlock;
    public static int idVenusRedGemOre;
    public static int idVenusMeteorOre;
    public static int idVenusSulferOre;
    public static int idVenusIronOre;
    public static int idVenusCoalOre;
    public static int idVenusTinOre;
    public static int idVenusCopperOre;
    public static int idVenusBasalt;
    public static int idVenusHalfBasalt;
    public static int idEvolvedBlazeEgg;
    				
    public static int idPlutoGrass;
    public static int idPlutoDirt;
    public static int idPlutoStone;
    public static int idPlutoCobblestone;
    public static int idPlutoBrick;
    				
    public static int idMercuryGrass;
    public static int idMercuryDirt;
    public static int idMercuryStone;
    public static int idMercuryCobblestone;
    public static int idMercuryBrick;
    public static int idMercuryIridiumOre;
    public static int idMercuryCoalOre;
    public static int idMercuryTinOre;
    public static int idMercuryCopperOre;
    				
    public static int idJupiterLightGas;
    public static int idJupiterMediumGas;
    public static int idJupiterHeavyGas;


    // ITEMS

    // ARMOR
    
    // TOOLS

    // ENTITIES
	
    // GUI

    // SCHEMATIC
    
    // GENERAL

    private void setDefaultValues()
    {
        try
        {
            SpacecraftBlocksConfigManager.configuration.load();

            SpacecraftBlocksConfigManager.idVenusGrass = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Grass ID", 7004).getInt(7004);
            SpacecraftBlocksConfigManager.idVenusDirt = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Dirt ID", 7005).getInt(7005);
            SpacecraftBlocksConfigManager.idVenusStone = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Stone ID", 7006).getInt(7006);
            SpacecraftBlocksConfigManager.idVenusCobblestone = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Cobblestone ID", 7007).getInt(7007);
            SpacecraftBlocksConfigManager.idVenusRedGemBlock = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Gem Block ID", 7008).getInt(7008);
            SpacecraftBlocksConfigManager.idVenusMeteorBlock = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Meteor Block ID", 7009).getInt(7009);
            SpacecraftBlocksConfigManager.idVenusBrick = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Brick ID", 7010).getInt(7010);
            SpacecraftBlocksConfigManager.idVenusSulferBlock = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Sulfer Block ID", 7011).getInt(7011);
            SpacecraftBlocksConfigManager.idVenusRedGemOre = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Gem Ore ID", 7012).getInt(7012);
            SpacecraftBlocksConfigManager.idVenusMeteorOre = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Meteor Ore ID", 7013).getInt(7013);
            SpacecraftBlocksConfigManager.idVenusSulferOre = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Sulfer Ore ID", 7014).getInt(7014);
            SpacecraftBlocksConfigManager.idVenusIronOre = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Iron Ore ID", 7015).getInt(7015);
            SpacecraftBlocksConfigManager.idVenusCoalOre = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Coal Ore ID", 7016).getInt(7016);
            SpacecraftBlocksConfigManager.idVenusTinOre = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Tin Ore ID", 7017).getInt(7017);
            SpacecraftBlocksConfigManager.idVenusCopperOre = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Copper Ore ID", 7018).getInt(7018);
            SpacecraftBlocksConfigManager.idVenusBasalt = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Basalt ID", 7019).getInt(7019);
            SpacecraftBlocksConfigManager.idVenusHalfBasalt = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Basalt Slab ID", 7020).getInt(7020);
            SpacecraftBlocksConfigManager.idEvolvedBlazeEgg = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Venus Blaze Egg ID", 7021).getInt(7021);
            				
            SpacecraftBlocksConfigManager.idPlutoGrass = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Pluto Grass ID", 7022).getInt(7022);
            SpacecraftBlocksConfigManager.idPlutoDirt = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Pluto Dirt ID", 7023).getInt(7023);
            SpacecraftBlocksConfigManager.idPlutoStone = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Pluto Stone ID", 7024).getInt(7024);
            SpacecraftBlocksConfigManager.idPlutoCobblestone = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Pluto Cobblestone ID", 7025).getInt(7025);
            SpacecraftBlocksConfigManager.idPlutoBrick = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Pluto Brick ID", 7026).getInt(7026);
            				
            SpacecraftBlocksConfigManager.idMercuryGrass = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Mercury Grass ID", 7027).getInt(7027);
            SpacecraftBlocksConfigManager.idMercuryDirt = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Mercury Dirt ID", 7028).getInt(7028);
            SpacecraftBlocksConfigManager.idMercuryStone = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Mercury Stone ID", 7029).getInt(7029);
            SpacecraftBlocksConfigManager.idMercuryCobblestone = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Mercury Cobblestone ID", 7030).getInt(7030);
            SpacecraftBlocksConfigManager.idMercuryBrick = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Mercury Brick ID", 7031).getInt(7031);
            SpacecraftBlocksConfigManager.idMercuryIridiumOre = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Mercury Iridium ID", 7032).getInt(7032);
            SpacecraftBlocksConfigManager.idMercuryCoalOre = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Mercury Coal Ore ID", 7033).getInt(7033);
            SpacecraftBlocksConfigManager.idMercuryTinOre = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Mercury Tin Ore ID", 7034).getInt(7034);
            SpacecraftBlocksConfigManager.idMercuryCopperOre = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Mercury Copper Ore ID", 7035).getInt(7035);
            				
            SpacecraftBlocksConfigManager.idJupiterLightGas = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Jupiter Light Gas ID", 7036).getInt(7006);
            SpacecraftBlocksConfigManager.idJupiterMediumGas = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Jupiter Medium Gas ID", 7037).getInt(7037);
            SpacecraftBlocksConfigManager.idJupiterHeavyGas = SpacecraftBlocksConfigManager.configuration.get("Blocks", "Jupiter Heavy Gas ID", 7038).getInt(7038);    
        
            //Block id's 7539 and up are used by Spacecraft Core
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Spacecraft Blocks has a problem loading it's configuration");
        }
        finally
        {
        	SpacecraftBlocksConfigManager.configuration.save();
        	SpacecraftBlocksConfigManager.loaded = true;
        }
    }
}