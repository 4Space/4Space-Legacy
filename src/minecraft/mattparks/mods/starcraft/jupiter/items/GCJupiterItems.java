package mattparks.mods.starcraft.jupiter.items;

import mattparks.mods.starcraft.jupiter.GCJupiterConfigManager;
import net.minecraft.item.Item;

public class GCJupiterItems
{
    public static Item jupiterItemBasic;
//    public static Item T5Schematic;
    
    public static void initItems()
    {
        GCJupiterItems.jupiterItemBasic = new GCJupiterItem(GCJupiterConfigManager.idItemJupiterBasic);
//        GCJupiterItems.T5Schematic = new GCJupiterItemSchematic(GCMercuryConfigManager.idTtemMercuryT5Schematic);
    }
    
    public static void registerHarvestLevels()
    {
    }
}
