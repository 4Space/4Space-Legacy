package mattparks.mods.starcraft.europa.items;

import mattparks.mods.starcraft.europa.SCEuropaConfigManager;
import net.minecraft.item.Item;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

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