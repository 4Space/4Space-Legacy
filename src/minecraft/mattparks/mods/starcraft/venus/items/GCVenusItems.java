package mattparks.mods.starcraft.venus.items;

import mattparks.mods.starcraft.core.SCCoreConfigManager;
import mattparks.mods.starcraft.core.items.SCCoreItems;
import mattparks.mods.starcraft.mercury.GCMercuryConfigManager;
import mattparks.mods.starcraft.mercury.items.GCMercuryItemSchematic;
import mattparks.mods.starcraft.mercury.items.GCMercuryItems;
import mattparks.mods.starcraft.venus.GCVenusConfigManager;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

public class GCVenusItems
{
    public static Item venusItemBasic;
    public static Item sulferPickaxe;
    public static Item sulferAxe;
    public static Item sulferHoe;
    public static Item sulferSpade;
    public static Item sulferSword;
    public static Item sulferHelmet;
    public static Item sulferChestplate;
    public static Item sulferLeggings;
    public static Item sulferBoots;
    public static Item venusBattery;
    
    public static Item T3Schematic;
    public static Item spaceshipT3;
    
    public static EnumArmorMaterial ARMORSULFER = EnumHelper.addArmorMaterial("SULFER", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLSULFER = EnumHelper.addToolMaterial("SULFER", 3, 1024, 5.0F, 2.5F, 8);

    public static void initItems()
    {
        GCVenusItems.venusItemBasic = new GCVenusItem(GCVenusConfigManager.idItemVenusBasic);
        GCVenusItems.venusBattery = new GCVenusItemBattery(GCVenusConfigManager.idItemVenusBattery, "venusBattery");

        GCVenusItems.sulferPickaxe = new GCVenusItemPickaxe(GCVenusConfigManager.idToolSulferPickaxe, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferPick");
        GCVenusItems.sulferAxe = new GCVenusItemAxe(GCVenusConfigManager.idToolSulferAxe, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferAxe");
        GCVenusItems.sulferHoe = new GCVenusItemHoe(GCVenusConfigManager.idToolSulferHoe, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferHoe");
        GCVenusItems.sulferSpade = new GCVenusItemSpade(GCVenusConfigManager.idToolSulferSpade, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferSpade");
        GCVenusItems.sulferSword = new GCVenusItemSword(GCVenusConfigManager.idToolSulferSword, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferSword");
        
        GCVenusItems.sulferHelmet = new GCVenusItemArmor(GCVenusConfigManager.idArmorSulferHelmet, GCVenusItems.ARMORSULFER, 7, 0, false).setUnlocalizedName("sulferHelmet");
        GCVenusItems.sulferChestplate = new GCVenusItemArmor(GCVenusConfigManager.idArmorSulferChestplate, GCVenusItems.ARMORSULFER, 7, 1, false).setUnlocalizedName("sulferChestplate");
        GCVenusItems.sulferLeggings = new GCVenusItemArmor(GCVenusConfigManager.idArmorSulferLeggings, GCVenusItems.ARMORSULFER, 7, 2, false).setUnlocalizedName("sulferLeggings");
        GCVenusItems.sulferBoots = new GCVenusItemArmor(GCVenusConfigManager.idArmorSulferBoots, GCVenusItems.ARMORSULFER, 7, 3, false).setUnlocalizedName("sulferBoots");
    
        GCVenusItems.T3Schematic = new GCVenusItemSchematic(GCVenusConfigManager.idTtemVenusT3Schematic);
        GCVenusItems.spaceshipT3 = new GCVenusItemSpaceshipTier3(GCVenusConfigManager.idItemSpaceshipTier3).setUnlocalizedName("spaceshipTier3");
    }
    
    public static void registerHarvestLevels()
    {
        MinecraftForge.setToolClass(GCVenusItems.sulferPickaxe, "pickaxe", 4);
        MinecraftForge.setToolClass(GCVenusItems.sulferAxe, "axe", 4);
        MinecraftForge.setToolClass(GCVenusItems.sulferSpade, "shovel", 4);
    }
}
