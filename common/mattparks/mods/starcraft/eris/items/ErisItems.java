package mattparks.mods.starcraft.eris.items;

import mattparks.mods.starcraft.eris.SCErisConfigManager;
import net.minecraft.item.Item;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
 
public class ErisItems
{
    public static Item erisItemBasic;
   
//    public static EnumArmorMaterial ARMORSULFER = EnumHelper.addArmorMaterial("SULFER", 42, new int[] { 4, 9, 7, 4 }, 12);
//    public static EnumToolMaterial TOOLSULFER = EnumHelper.addToolMaterial("SULFER", 3, 1024, 5.0F, 2.5F, 8);

    public static void initItems()
    {
        ErisItems.erisItemBasic = new SCErisItem(SCErisConfigManager.idItemErisBasic);
    }
    
    public static void registerHarvestLevels()
    {
    }
}
