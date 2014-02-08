package mattparks.mods.starcraft.europa.items;

import mattparks.mods.starcraft.europa.GCEuropaConfigManager;
import net.minecraft.item.Item;

public class GCEuropaItems
{
    public static Item jupiterItemBasic;

    public static void initItems()
    {
    	GCEuropaItems.jupiterItemBasic = new GCEuropaItem(GCEuropaConfigManager.idItemEuropaBasic).setUnlocalizedName("europaBasic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}