package mattparks.mods.starcraft.io.items;

import mattparks.mods.starcraft.io.SCIoConfigManager;
import net.minecraft.item.Item;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

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