package mattparks.mods.starcraft.venus.items;

import mattparks.mods.starcraft.core.StarcraftVenus;
import mattparks.mods.starcraft.venus.GCVenusConfigManager;
import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
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
    
    public static Item gemPickaxe;
    public static Item gemAxe;
    public static Item gemHoe;
    public static Item gemSpade;
    public static Item gemSword;
    public static Item gemHelmet;
    public static Item gemChestplate;
    public static Item gemLeggings;
    public static Item gemBoots;
    
    public static Item vurnBerry;
    
//    public static Item venusBattery;
    
    public static Item T3Schematic;
    public static Item spaceshipT3;
    
    public static EnumArmorMaterial ARMORSULFER = EnumHelper.addArmorMaterial("SULFER", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLSULFER = EnumHelper.addToolMaterial("SULFER", 3, 1024, 5.0F, 2.5F, 8);
    
    public static EnumArmorMaterial ARMORGEM = EnumHelper.addArmorMaterial("GEM", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLGEM = EnumHelper.addToolMaterial("GEM", 3, 1024, 5.0F, 2.5F, 8);
    
    public static void initItems()
    {
        GCVenusItems.venusItemBasic = new GCVenusItem(GCVenusConfigManager.idItemVenusBasic);
//        GCVenusItems.venusBattery = new GCVenusItemBattery(GCVenusConfigManager.idItemVenusBattery, "venusBattery");

        GCVenusItems.sulferPickaxe = new GCVenusItemSulferPickaxe(GCVenusConfigManager.idToolSulferPickaxe, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferPick");
        GCVenusItems.sulferAxe = new GCVenusItemSulferAxe(GCVenusConfigManager.idToolSulferAxe, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferAxe");
        GCVenusItems.sulferHoe = new GCVenusItemSulferHoe(GCVenusConfigManager.idToolSulferHoe, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferHoe");
        GCVenusItems.sulferSpade = new GCVenusItemSulferSpade(GCVenusConfigManager.idToolSulferSpade, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferSpade");
        GCVenusItems.sulferSword = new GCVenusItemSword(GCVenusConfigManager.idToolSulferSword, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferSword");
        
        GCVenusItems.sulferHelmet = new GCVenusItemSulferArmor(GCVenusConfigManager.idArmorSulferHelmet, GCVenusItems.ARMORSULFER, 7, 0, false).setUnlocalizedName("sulferHelmet");
        GCVenusItems.sulferChestplate = new GCVenusItemSulferArmor(GCVenusConfigManager.idArmorSulferChestplate, GCVenusItems.ARMORSULFER, 7, 1, false).setUnlocalizedName("sulferChestplate");
        GCVenusItems.sulferLeggings = new GCVenusItemSulferArmor(GCVenusConfigManager.idArmorSulferLeggings, GCVenusItems.ARMORSULFER, 7, 2, false).setUnlocalizedName("sulferLeggings");
        GCVenusItems.sulferBoots = new GCVenusItemSulferArmor(GCVenusConfigManager.idArmorSulferBoots, GCVenusItems.ARMORSULFER, 7, 3, false).setUnlocalizedName("sulferBoots");
    
        GCVenusItems.gemPickaxe = new SCCoreItemGemPickaxe(GCVenusConfigManager.idToolGemPickaxe, GCVenusItems.TOOLGEM).setUnlocalizedName("gemPick");
        GCVenusItems.gemAxe = new SCCoreItemGemAxe(GCVenusConfigManager.idToolGemAxe, GCVenusItems.TOOLGEM).setUnlocalizedName("gemAxe");
        GCVenusItems.gemHoe = new SCCoreItemGemHoe(GCVenusConfigManager.idToolGemHoe, GCVenusItems.TOOLGEM).setUnlocalizedName("gemHoe");
        GCVenusItems.gemSpade = new SCCoreItemGemSpade(GCVenusConfigManager.idToolGemSpade, GCVenusItems.TOOLGEM).setUnlocalizedName("gemSpade");
        GCVenusItems.gemSword = new SCCoreItemGemSword(GCVenusConfigManager.idToolGemSword, GCVenusItems.TOOLGEM).setUnlocalizedName("gemSword");

        GCVenusItems.gemHelmet = new SCCoreItemGemArmor(GCVenusConfigManager.idArmorGemHelmet, GCVenusItems.ARMORGEM, 7, 0, false).setUnlocalizedName("gemHelmet");
        GCVenusItems.gemChestplate = new SCCoreItemGemArmor(GCVenusConfigManager.idArmorGemChestplate, GCVenusItems.ARMORGEM, 7, 1, false).setUnlocalizedName("gemChestplate");
        GCVenusItems.gemLeggings = new SCCoreItemGemArmor(GCVenusConfigManager.idArmorGemLeggings, GCVenusItems.ARMORGEM, 7, 2, false).setUnlocalizedName("gemLeggings");
        GCVenusItems.gemBoots = new SCCoreItemGemArmor(GCVenusConfigManager.idArmorGemBoots, GCVenusItems.ARMORGEM, 7, 3, false).setUnlocalizedName("gemBoots");

        GCVenusItems.vurnBerry = (new GCVenusVurnBerry(GCVenusConfigManager.idVurnBerry, 4, 0.6F, StarcraftVenus.VurnBerryBush.blockID, Block.tilledField.blockID)).setUnlocalizedName("vurnBerry").setTextureName("starcraftvenus:vurnBerry");

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
