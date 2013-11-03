package mattparks.mods.starcraft.jupiter.items;

import mattparks.mods.starcraft.mercury.GCMercuryConfigManager;
import net.minecraft.item.Item;

public class GCJupiterItems
{
    public static Item mercuryItemBasic;
    
    public static void initItems()
    {
        GCJupiterItems.mercuryItemBasic = new GCJupiterItem(GCMercuryConfigManager.idItemMercuryBasic);
    }
    
    public static void registerHarvestLevels()
    {
    }
}
