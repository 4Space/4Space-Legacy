package mattparks.mods.starcraft.vesta.items;

import mattparks.mods.starcraft.vesta.SCVestaConfigManager;
import net.minecraft.item.Item;

public class VestaItems
{
    public static Item jupiterItemBasic;

    public static void initItems()
    {
    	VestaItems.jupiterItemBasic = new SCVestaItem(SCVestaConfigManager.idItemVestaBasic).setUnlocalizedName("vestaBasic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}