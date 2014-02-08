package mattparks.mods.starcraft.vesta.items;

import mattparks.mods.starcraft.vesta.GCVestaConfigManager;
import net.minecraft.item.Item;

public class GCVestaItems
{
    public static Item jupiterItemBasic;

    public static void initItems()
    {
    	GCVestaItems.jupiterItemBasic = new GCVestaItem(GCVestaConfigManager.idItemVestaBasic).setUnlocalizedName("vestaBasic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}