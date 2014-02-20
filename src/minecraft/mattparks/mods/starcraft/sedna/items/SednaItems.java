package mattparks.mods.starcraft.sedna.items;

import mattparks.mods.starcraft.sedna.SCSednaConfigManager;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;

public class SednaItems
{
    public static Item sednaItemBasic;
    public static Item gravityBoots;
    public static Item spaceshipT6;
    
    public static EnumArmorMaterial ARMORGRAVITY = EnumHelper.addArmorMaterial("GRAVITY", 42, new int[] { 4, 9, 7, 4 }, 12);
//    public static EnumToolMaterial TOOLgravity = EnumHelper.addToolMaterial("gravity", 3, 1024, 5.0F, 2.5F, 8);
    
    public static void initItems()
    {
        SednaItems.sednaItemBasic = new SCSednaItem(SCSednaConfigManager.idItemSednaBasic);
    
        SednaItems.gravityBoots = new SCSednaItemGravityBoots(SCSednaConfigManager.idArmorGravityBoots, SednaItems.ARMORGRAVITY, 7, 3, false).setUnlocalizedName("gravityBoots");

        SednaItems.spaceshipT6 = new SCSednaItemSpaceshipTier6(SCSednaConfigManager.idItemSpaceshipTier6).setUnlocalizedName("spaceshipTier6");
    }
    
    public static void registerHarvestLevels()
    {
    }
}
