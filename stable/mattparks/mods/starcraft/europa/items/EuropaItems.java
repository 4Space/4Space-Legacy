package mattparks.mods.starcraft.europa.items;

import mattparks.mods.starcraft.europa.SCEuropaConfigManager;
import net.minecraft.item.Item;

public class EuropaItems
{
    public static Item jupiterItemBasic;

    public static void initItems()
    {
    	EuropaItems.jupiterItemBasic = new SCEuropaItem(SCEuropaConfigManager.idItemEuropaBasic).setUnlocalizedName("europaBasic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}