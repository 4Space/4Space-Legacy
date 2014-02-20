package mattparks.mods.starcraft.jupiter.items;

import mattparks.mods.starcraft.jupiter.SCJupiterConfigManager;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;

public class JupiterItems
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
    	JupiterItems.jupiterItemBasic = new SCJupiterItem(SCJupiterConfigManager.idItemJupiterBasic).setUnlocalizedName("jupiterBasic");
        JupiterItems.spaceshipT5 = new SCJupiterItemSpaceshipTier5(SCJupiterConfigManager.idItemSpaceshipTier5).setUnlocalizedName("spaceshipTier5");
//        SCCoreItems.schematic = new SCCoreItemSchematic(SCCoreConfigManager.idItemSchematicMars).setUnlocalizedName("schematic");
   
        JupiterItems.clearDiamondPickaxe = new SCJupiterItemClearDiamondPickaxe(SCJupiterConfigManager.idToolClearDiamondPickaxe, JupiterItems.TOOLCLEARDIAMOND).setUnlocalizedName("ClearDiamondPick");
        JupiterItems.clearDiamondAxe = new SCJupiterItemClearDiamondAxe(SCJupiterConfigManager.idToolClearDiamondAxe, JupiterItems.TOOLCLEARDIAMOND).setUnlocalizedName("ClearDiamondAxe");
        JupiterItems.clearDiamondHoe = new SCJupiterItemClearDiamondHoe(SCJupiterConfigManager.idToolClearDiamondHoe, JupiterItems.TOOLCLEARDIAMOND).setUnlocalizedName("ClearDiamondHoe");
        JupiterItems.clearDiamondSpade = new SCJupiterItemClearDiamondSpade(SCJupiterConfigManager.idToolClearDiamondSpade, JupiterItems.TOOLCLEARDIAMOND).setUnlocalizedName("ClearDiamondSpade");
        JupiterItems.clearDiamondSword = new SCJupiterItemClearDiamondSword(SCJupiterConfigManager.idToolClearDiamondSword, JupiterItems.TOOLCLEARDIAMOND).setUnlocalizedName("ClearDiamondSword");

        JupiterItems.clearDiamondHelmet = new SCJupiterItemClearDiamondArmor(SCJupiterConfigManager.idArmorClearDiamondHelmet, JupiterItems.ARMORCLEARDIAMOND, 7, 0, false).setUnlocalizedName("ClearDiamondHelmet");
        JupiterItems.clearDiamondChestplate = new SCJupiterItemClearDiamondArmor(SCJupiterConfigManager.idArmorClearDiamondChestplate, JupiterItems.ARMORCLEARDIAMOND, 7, 1, false).setUnlocalizedName("ClearDiamondChestplate");
        JupiterItems.clearDiamondLeggings = new SCJupiterItemClearDiamondArmor(SCJupiterConfigManager.idArmorClearDiamondLeggings, JupiterItems.ARMORCLEARDIAMOND, 7, 2, false).setUnlocalizedName("ClearDiamondLeggings");
        JupiterItems.clearDiamondBoots = new SCJupiterItemClearDiamondArmor(SCJupiterConfigManager.idArmorClearDiamondBoots, JupiterItems.ARMORCLEARDIAMOND, 7, 3, false).setUnlocalizedName("ClearDiamondBoots");

    }
    
    public static void registerHarvestLevels()
    {
    }
}