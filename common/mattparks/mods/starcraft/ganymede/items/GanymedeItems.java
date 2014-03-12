package mattparks.mods.starcraft.ganymede.items;

import mattparks.mods.starcraft.ganymede.SCGanymedeConfigManager;
import net.minecraft.item.Item;

public class GanymedeItems
{
    public static Item jupiterItemBasic;

    public static void initItems()
    {
    	GanymedeItems.jupiterItemBasic = new SCGanymedeItem(SCGanymedeConfigManager.idItemGanymedeBasic).setUnlocalizedName("ganymedeBasic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}