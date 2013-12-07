package mattparks.mods.starcraft.sedna.items;

import java.util.ArrayList;

import mattparks.mods.starcraft.sedna.GCSednaConfigManager;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import micdoodle8.mods.galacticraft.core.items.GCCoreItemBow;
import micdoodle8.mods.galacticraft.core.items.GCCoreItemRocketEngine;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

public class GCSednaItems
{
    public static Item sednaItemBasic;
//    public static Item gravityHelmet;
//    public static Item gravityChestplate;
//    public static Item gravityLeggings;
    public static Item gravityBoots;
    
    public static EnumArmorMaterial ARMORGRAVITY = EnumHelper.addArmorMaterial("GRAVITY", 42, new int[] { 4, 9, 7, 4 }, 12);
//    public static EnumToolMaterial TOOLgravity = EnumHelper.addToolMaterial("gravity", 3, 1024, 5.0F, 2.5F, 8);
    
    public static void initItems()
    {
        GCSednaItems.sednaItemBasic = new GCSednaItem(GCSednaConfigManager.idItemSednaBasic);
    
//        GCSednaItems.gravityHelmet = new GCSednaItemGravityBoots(GCSednaConfigManager.idArmorGravityHelmet, GCSednaItems.ARMORGRAVITY, 7, 0, false).setUnlocalizedName("gravityHelmet");
//        GCSednaItems.gravityChestplate = new GCSednaItemGravityBoots(GCSednaConfigManager.idArmorGravityChestplate, GCSednaItems.ARMORGRAVITY, 7, 1, false).setUnlocalizedName("gravityChestplate");
//        GCSednaItems.gravityLeggings = new GCSednaItemGravityBoots(GCSednaConfigManager.idArmorGravityLeggings, GCSednaItems.ARMORGRAVITY, 7, 2, false).setUnlocalizedName("gravityLeggings");
        GCSednaItems.gravityBoots = new GCSednaItemGravityBoots(GCSednaConfigManager.idArmorGravityBoots, GCSednaItems.ARMORGRAVITY, 7, 3, false).setUnlocalizedName("gravityBoots");
    }
    
    public static void registerHarvestLevels()
    {
    }
}
