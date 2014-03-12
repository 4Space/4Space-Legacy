package mattparks.mods.starcraft.callisto.items;

import mattparks.mods.starcraft.callisto.SCCallistoConfigManager;
import net.minecraft.item.Item;

public class CallistoItems
{
    public static Item jupiterItemBasic;

    public static void initItems()
    {
    	CallistoItems.jupiterItemBasic = new SCCallistoItem(SCCallistoConfigManager.idItemCallistoBasic).setUnlocalizedName("callistoBasic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}