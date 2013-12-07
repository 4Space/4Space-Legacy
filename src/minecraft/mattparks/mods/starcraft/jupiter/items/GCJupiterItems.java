package mattparks.mods.starcraft.jupiter.items;

import mattparks.mods.starcraft.jupiter.GCJupiterConfigManager;
import mattparks.mods.starcraft.jupiter.items.GCJupiterItems;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;

public class GCJupiterItems
{
    public static Item jupiterItemBasic;
    public static Item spaceshipT5;
//    public static Item schematic;
    
    public static Item clearDiamondPickaxe;
    public static Item clearDiamondAxe;
    public static Item clearDiamondHoe;
    public static Item clearDiamondSpade;
    public static Item clearDiamondSword;
    public static Item clearDiamondHelmet;
    public static Item clearDiamondChestplate;
    public static Item clearDiamondLeggings;
    public static Item clearDiamondBoots;
    
    public static EnumArmorMaterial ARMORCLEARDIAMOND = EnumHelper.addArmorMaterial("ClearDiamond", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLCLEARDIAMOND = EnumHelper.addToolMaterial("ClearDiamond", 3, 1024, 5.0F, 2.5F, 8);
    public static void initItems()
    {
    	GCJupiterItems.jupiterItemBasic = new GCJupiterItem(GCJupiterConfigManager.idItemJupiterBasic).setUnlocalizedName("jupiterBasic");
        GCJupiterItems.spaceshipT5 = new SCCoreItemSpaceshipTier5(GCJupiterConfigManager.idItemSpaceshipTier5).setUnlocalizedName("spaceshipTier5");
//        SCCoreItems.schematic = new SCCoreItemSchematic(SCCoreConfigManager.idItemSchematicMars).setUnlocalizedName("schematic");
   
        GCJupiterItems.clearDiamondPickaxe = new SCCoreItemClearDiamondPickaxe(GCJupiterConfigManager.idToolClearDiamondPickaxe, GCJupiterItems.TOOLCLEARDIAMOND).setUnlocalizedName("ClearDiamondPick");
        GCJupiterItems.clearDiamondAxe = new SCCoreItemClearDiamondAxe(GCJupiterConfigManager.idToolClearDiamondAxe, GCJupiterItems.TOOLCLEARDIAMOND).setUnlocalizedName("ClearDiamondAxe");
        GCJupiterItems.clearDiamondHoe = new SCCoreItemClearDiamondHoe(GCJupiterConfigManager.idToolClearDiamondHoe, GCJupiterItems.TOOLCLEARDIAMOND).setUnlocalizedName("ClearDiamondHoe");
        GCJupiterItems.clearDiamondSpade = new SCCoreItemClearDiamondSpade(GCJupiterConfigManager.idToolClearDiamondSpade, GCJupiterItems.TOOLCLEARDIAMOND).setUnlocalizedName("ClearDiamondSpade");
        GCJupiterItems.clearDiamondSword = new SCCoreItemClearDiamondSword(GCJupiterConfigManager.idToolClearDiamondSword, GCJupiterItems.TOOLCLEARDIAMOND).setUnlocalizedName("ClearDiamondSword");

        GCJupiterItems.clearDiamondHelmet = new SCCoreItemClearDiamondArmor(GCJupiterConfigManager.idArmorClearDiamondHelmet, GCJupiterItems.ARMORCLEARDIAMOND, 7, 0, false).setUnlocalizedName("ClearDiamondHelmet");
        GCJupiterItems.clearDiamondChestplate = new SCCoreItemClearDiamondArmor(GCJupiterConfigManager.idArmorClearDiamondChestplate, GCJupiterItems.ARMORCLEARDIAMOND, 7, 1, false).setUnlocalizedName("ClearDiamondChestplate");
        GCJupiterItems.clearDiamondLeggings = new SCCoreItemClearDiamondArmor(GCJupiterConfigManager.idArmorClearDiamondLeggings, GCJupiterItems.ARMORCLEARDIAMOND, 7, 2, false).setUnlocalizedName("ClearDiamondLeggings");
        GCJupiterItems.clearDiamondBoots = new SCCoreItemClearDiamondArmor(GCJupiterConfigManager.idArmorClearDiamondBoots, GCJupiterItems.ARMORCLEARDIAMOND, 7, 3, false).setUnlocalizedName("ClearDiamondBoots");

    }
    
    public static void registerHarvestLevels()
    {
    }
}