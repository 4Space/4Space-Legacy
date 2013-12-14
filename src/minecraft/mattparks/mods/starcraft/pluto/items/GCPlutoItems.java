package mattparks.mods.starcraft.pluto.items;

import mattparks.mods.starcraft.pluto.GCPlutoConfigManager;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;

public class GCPlutoItems
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
        GCPlutoItems.plutoItemBasic = new GCPlutoItem(GCPlutoConfigManager.idItemPlutoBasic);
        
        GCPlutoItems.blueGemPickaxe = new SCCoreItemGemPickaxe(GCPlutoConfigManager.idToolBlueGemPickaxe, GCPlutoItems.TOOLBLUEGEM).setUnlocalizedName("blueGemPick");
        GCPlutoItems.blueGemAxe = new SCCoreItemGemAxe(GCPlutoConfigManager.idToolBlueGemAxe, GCPlutoItems.TOOLBLUEGEM).setUnlocalizedName("blueGemAxe");
        GCPlutoItems.blueGemHoe = new SCCoreItemGemHoe(GCPlutoConfigManager.idToolBlueGemHoe, GCPlutoItems.TOOLBLUEGEM).setUnlocalizedName("blueGemHoe");
        GCPlutoItems.blueGemSpade = new SCCoreItemGemSpade(GCPlutoConfigManager.idToolBlueGemSpade, GCPlutoItems.TOOLBLUEGEM).setUnlocalizedName("blueGemSpade");
        GCPlutoItems.blueGemSword = new SCCoreItemGemSword(GCPlutoConfigManager.idToolBlueGemSword, GCPlutoItems.TOOLBLUEGEM).setUnlocalizedName("blueGemSword");

        GCPlutoItems.blueGemHelmet = new SCCoreItemBlueGemArmor(GCPlutoConfigManager.idArmorBlueGemHelmet, GCPlutoItems.ARMORBLUEGEM, 7, 0, false).setUnlocalizedName("blueGemHelmet");
        GCPlutoItems.blueGemChestplate = new SCCoreItemBlueGemArmor(GCPlutoConfigManager.idArmorBlueGemChestplate, GCPlutoItems.ARMORBLUEGEM, 7, 1, false).setUnlocalizedName("blueGemChestplate");
        GCPlutoItems.blueGemLeggings = new SCCoreItemBlueGemArmor(GCPlutoConfigManager.idArmorBlueGemLeggings, GCPlutoItems.ARMORBLUEGEM, 7, 2, false).setUnlocalizedName("blueGemLeggings");
        GCPlutoItems.blueGemBoots = new SCCoreItemBlueGemArmor(GCPlutoConfigManager.idArmorBlueGemBoots, GCPlutoItems.ARMORBLUEGEM, 7, 3, false).setUnlocalizedName("blueGemBoots");

    }
    
    public static void registerHarvestLevels()
    {
    }
}
