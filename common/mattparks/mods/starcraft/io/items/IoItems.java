package mattparks.mods.starcraft.io.items;

import mattparks.mods.starcraft.io.SCIoConfigManager;
import net.minecraft.item.Item;

public class IoItems
{
    public static Item jupiterItemBasic;

    public static void initItems()
    {
    	IoItems.jupiterItemBasic = new SCIoItem(SCIoConfigManager.idItemIoBasic).setUnlocalizedName("ioBasic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}