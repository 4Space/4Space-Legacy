package mattparks.mods.starcraft.callisto.items;

import mattparks.mods.starcraft.callisto.SCCallistoConfigManager;
import net.minecraft.item.Item;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
 
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