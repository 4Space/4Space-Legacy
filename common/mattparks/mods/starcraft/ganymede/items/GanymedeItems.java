package mattparks.mods.starcraft.ganymede.items;

import mattparks.mods.starcraft.ganymede.SCGanymedeConfigManager;
import net.minecraft.item.Item;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

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