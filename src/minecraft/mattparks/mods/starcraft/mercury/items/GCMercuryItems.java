package mattparks.mods.starcraft.mercury.items;

import mattparks.mods.starcraft.mercury.GCMercuryConfigManager;
import net.minecraft.item.Item;

public class GCMercuryItems
{
    public static Item mercuryItemBasic;
    public static Item T4Schematic;
    
    public static void initItems()
    {
        GCMercuryItems.mercuryItemBasic = new GCMercuryItem(GCMercuryConfigManager.idItemMercuryBasic);
        GCMercuryItems.T4Schematic = new GCMercuryItemSchematic(GCMercuryConfigManager.idTtemMercuryT4Schematic);
    }
    
    public static void registerHarvestLevels()
    {
    }
}
