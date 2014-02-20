package mattparks.mods.starcraft.pluto.items;

import mattparks.mods.starcraft.pluto.SCPlutoConfigManager;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;

public class PlutoItems
{
    public static Item plutoItemBasic;
    
    public static Item blueGemPickaxe;
    public static Item blueGemAxe;
    public static Item blueGemHoe;
    public static Item blueGemSpade;
    public static Item blueGemSword;
    public static Item blueGemHelmet;
    public static Item blueGemChestplate;
    public static Item blueGemLeggings;
    public static Item blueGemBoots;
    
    public static EnumArmorMaterial ARMORBLUEGEM = EnumHelper.addArmorMaterial("BLUEGEM", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLBLUEGEM = EnumHelper.addToolMaterial("BLUEGEM", 3, 1024, 5.0F, 2.5F, 8);

    public static void initItems()
    {
        PlutoItems.plutoItemBasic = new SCPlutoItem(SCPlutoConfigManager.idItemPlutoBasic);
        
        PlutoItems.blueGemPickaxe = new SCCoreItemGemPickaxe(SCPlutoConfigManager.idToolBlueGemPickaxe, PlutoItems.TOOLBLUEGEM).setUnlocalizedName("blueGemPick");
        PlutoItems.blueGemAxe = new SCCoreItemGemAxe(SCPlutoConfigManager.idToolBlueGemAxe, PlutoItems.TOOLBLUEGEM).setUnlocalizedName("blueGemAxe");
        PlutoItems.blueGemHoe = new SCCoreItemGemHoe(SCPlutoConfigManager.idToolBlueGemHoe, PlutoItems.TOOLBLUEGEM).setUnlocalizedName("blueGemHoe");
        PlutoItems.blueGemSpade = new SCCoreItemGemSpade(SCPlutoConfigManager.idToolBlueGemSpade, PlutoItems.TOOLBLUEGEM).setUnlocalizedName("blueGemSpade");
        PlutoItems.blueGemSword = new SCCoreItemGemSword(SCPlutoConfigManager.idToolBlueGemSword, PlutoItems.TOOLBLUEGEM).setUnlocalizedName("blueGemSword");

        PlutoItems.blueGemHelmet = new SCCoreItemBlueGemArmor(SCPlutoConfigManager.idArmorBlueGemHelmet, PlutoItems.ARMORBLUEGEM, 7, 0, false).setUnlocalizedName("blueGemHelmet");
        PlutoItems.blueGemChestplate = new SCCoreItemBlueGemArmor(SCPlutoConfigManager.idArmorBlueGemChestplate, PlutoItems.ARMORBLUEGEM, 7, 1, false).setUnlocalizedName("blueGemChestplate");
        PlutoItems.blueGemLeggings = new SCCoreItemBlueGemArmor(SCPlutoConfigManager.idArmorBlueGemLeggings, PlutoItems.ARMORBLUEGEM, 7, 2, false).setUnlocalizedName("blueGemLeggings");
        PlutoItems.blueGemBoots = new SCCoreItemBlueGemArmor(SCPlutoConfigManager.idArmorBlueGemBoots, PlutoItems.ARMORBLUEGEM, 7, 3, false).setUnlocalizedName("blueGemBoots");

    }
    
    public static void registerHarvestLevels()
    {
    }
}
