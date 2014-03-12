package mattparks.mods.starcraft.titan.items;

import mattparks.mods.starcraft.titan.SCTitanConfigManager;
import net.minecraft.item.Item;

public class TitanItems
{
    public static Item jupiterItemBasic;

    public static void initItems()
    {
    	TitanItems.jupiterItemBasic = new SCTitanItem(SCTitanConfigManager.idItemTitanBasic).setUnlocalizedName("titanBasic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}