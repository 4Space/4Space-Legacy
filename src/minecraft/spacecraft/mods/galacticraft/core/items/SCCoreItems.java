package spacecraft.mods.galacticraft.core.items;

import spacecraft.mods.galacticraft.core.SCCoreConfigManager;
import spacecraft.mods.galacticraft.venus.GCVenusConfigManager;
import spacecraft.mods.galacticraft.venus.items.GCVenusItemArmor;
import spacecraft.mods.galacticraft.venus.items.GCVenusItemAxe;
import spacecraft.mods.galacticraft.venus.items.GCVenusItemHoe;
import spacecraft.mods.galacticraft.venus.items.GCVenusItemPickaxe;
import spacecraft.mods.galacticraft.venus.items.GCVenusItemSpade;
import spacecraft.mods.galacticraft.venus.items.GCVenusItemSword;
import spacecraft.mods.galacticraft.venus.items.GCVenusItems;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import micdoodle8.mods.galacticraft.core.items.GCCoreItemBow;
import micdoodle8.mods.galacticraft.core.items.GCCoreItemRocketEngine;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

public class SCCoreItems
{
    public static Item venusItemBasic;
    public static Item gemPickaxe;
    public static Item gemAxe;
    public static Item gemHoe;
    public static Item gemSpade;
    public static Item gemSword;
    public static Item gemHelmet;
    public static Item gemChestplate;
    public static Item gemLeggings;
    public static Item gemBoots;
    public static Item jetpack;

    public static Item rocketEngine;
    public static Item spaceship;
    public static Item schematic;

    public static EnumArmorMaterial ARMORGEM = EnumHelper.addArmorMaterial("GEM", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLGEM = EnumHelper.addToolMaterial("GEM", 3, 1024, 5.0F, 2.5F, 8);
//    public static EnumArmorMaterial ARMORJETPACK = EnumHelper.addArmorMaterial("JETPACK", 200, new int[] {0, 0, 0, 0}, 0);
    
    public static void initItems()
    {
        SCCoreItems.venusItemBasic = new SCCoreItem(SCCoreConfigManager.idItemVenusBasic);
        SCCoreItems.gemPickaxe = new SCCoreItemPickaxe(SCCoreConfigManager.idToolGemPickaxe, SCCoreItems.TOOLGEM).setUnlocalizedName("gemPick");
        SCCoreItems.gemAxe = new SCCoreItemAxe(SCCoreConfigManager.idToolGemAxe, SCCoreItems.TOOLGEM).setUnlocalizedName("gemAxe");
        SCCoreItems.gemHoe = new SCCoreItemHoe(SCCoreConfigManager.idToolGemHoe, SCCoreItems.TOOLGEM).setUnlocalizedName("gemHoe");
        SCCoreItems.gemSpade = new SCCoreItemSpade(SCCoreConfigManager.idToolGemSpade, SCCoreItems.TOOLGEM).setUnlocalizedName("gemSpade");
        SCCoreItems.gemSword = new SCCoreItemSword(SCCoreConfigManager.idToolGemSword, SCCoreItems.TOOLGEM).setUnlocalizedName("gemSword");
        SCCoreItems.gemHelmet = new SCCoreItemArmor(SCCoreConfigManager.idArmorGemHelmet, SCCoreItems.ARMORGEM, 7, 0, false).setUnlocalizedName("gemHelmet");
        SCCoreItems.gemChestplate = new SCCoreItemArmor(SCCoreConfigManager.idArmorGemChestplate, SCCoreItems.ARMORGEM, 7, 1, false).setUnlocalizedName("gemChestplate");
        SCCoreItems.gemLeggings = new SCCoreItemArmor(SCCoreConfigManager.idArmorGemLeggings, SCCoreItems.ARMORGEM, 7, 2, false).setUnlocalizedName("gemLeggings");
        SCCoreItems.gemBoots = new SCCoreItemArmor(SCCoreConfigManager.idArmorGemBoots, SCCoreItems.ARMORGEM, 7, 3, false).setUnlocalizedName("gemBoots");

//        GCVenusItems.jetpack = new GCVenusItemJetpack(GCVenusConfigManager.idArmorJetpack, GCVenusItems.ARMORJETPACK, 11, 1, false, null).setUnlocalizedName("jetpack");
        
        SCCoreItems.rocketEngine = new SCCoreItemRocketEngine(SCCoreConfigManager.idItemRocketEngine, "engine");
        SCCoreItems.spaceship = new SCCoreItemSpaceshipTier3(SCCoreConfigManager.idItemSpaceshipTier3).setUnlocalizedName("spaceshipTier3");
        SCCoreItems.schematic = new SCCoreItemSchematic(SCCoreConfigManager.idItemSchematicMars).setUnlocalizedName("schematic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}
