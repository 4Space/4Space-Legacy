package mattparks.mods.starcraft.mercury.items;

import mattparks.mods.starcraft.mercury.GCMercuryConfigManager;
import net.minecraft.item.Item;

public class GCMercuryItems
{
    public static Item mercuryItemBasic;
    
    public static void initItems()
    {
        GCMercuryItems.mercuryItemBasic = new GCMercuryItem(GCMercuryConfigManager.idItemMercuryBasic);
    }
    
    public static void registerHarvestLevels()
    {
    }
}
