package mattparks.mods.starcraft.eris.items;

import mattparks.mods.starcraft.eris.GCErisConfigManager;
import net.minecraft.item.Item;

public class GCErisItems
{
    public static Item erisItemBasic;
   
//    public static EnumArmorMaterial ARMORSULFER = EnumHelper.addArmorMaterial("SULFER", 42, new int[] { 4, 9, 7, 4 }, 12);
//    public static EnumToolMaterial TOOLSULFER = EnumHelper.addToolMaterial("SULFER", 3, 1024, 5.0F, 2.5F, 8);

    public static void initItems()
    {
        GCErisItems.erisItemBasic = new GCErisItem(GCErisConfigManager.idItemErisBasic);
    }
    
    public static void registerHarvestLevels()
    {
    }
}
