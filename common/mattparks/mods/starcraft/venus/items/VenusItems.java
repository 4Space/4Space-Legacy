package mattparks.mods.starcraft.venus.items;

import mattparks.mods.starcraft.venus.SCVenusConfigManager;
import mattparks.mods.starcraft.venus.blocks.VenusBlocks;
import micdoodle8.mods.galacticraft.mars.GCMarsConfigManager;
import micdoodle8.mods.galacticraft.mars.items.GCMarsItemSchematic;
import micdoodle8.mods.galacticraft.mars.items.GCMarsItems;
import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

public class VenusItems
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
    
    public static Item jetpack;
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
    public static Item VurnBerryOnAStick;
    
    public static Item venusBattery;
    
    public static Item T3Schematic;
    public static Item spaceshipT3;
    
    public static Item key;
    
    public static EnumArmorMaterial ARMORSULFER = EnumHelper.addArmorMaterial("SULFER", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLSULFER = EnumHelper.addToolMaterial("SULFER", 3, 1024, 5.0F, 2.5F, 8);
    
    public static EnumArmorMaterial ARMORGEM = EnumHelper.addArmorMaterial("GEM", 42, new int[] { 3, 3, 3, 3 }, 12);
    public static EnumToolMaterial TOOLGEM = EnumHelper.addToolMaterial("GEM", 3, 1024, 5.0F, 2.5F, 8);
    
    public static EnumArmorMaterial ARMORJETPACK = EnumHelper.addArmorMaterial("JETPACK", 42, new int[] { 4, 9, 7, 4 }, 12);
    
    public static void initItems()
    {
        VenusItems.venusItemBasic = new SCVenusItem(SCVenusConfigManager.idItemVenusBasic);
        
		VenusItems.venusBattery = new SCVenusItemBattery(SCVenusConfigManager.idItemVenusBattery, "venusBattery");

        VenusItems.sulferPickaxe = new SCVenusItemSulferPickaxe(SCVenusConfigManager.idToolSulferPickaxe, VenusItems.TOOLSULFER).setUnlocalizedName("sulferPick");
        VenusItems.sulferAxe = new SCVenusItemSulferAxe(SCVenusConfigManager.idToolSulferAxe, VenusItems.TOOLSULFER).setUnlocalizedName("sulferAxe");
        VenusItems.sulferHoe = new SCVenusItemSulferHoe(SCVenusConfigManager.idToolSulferHoe, VenusItems.TOOLSULFER).setUnlocalizedName("sulferHoe");
        VenusItems.sulferSpade = new SCVenusItemSulferSpade(SCVenusConfigManager.idToolSulferSpade, VenusItems.TOOLSULFER).setUnlocalizedName("sulferSpade");
        VenusItems.sulferSword = new SCVenusItemSword(SCVenusConfigManager.idToolSulferSword, VenusItems.TOOLSULFER).setUnlocalizedName("sulferSword");
        
        VenusItems.sulferHelmet = new SCVenusItemSulferArmor(SCVenusConfigManager.idArmorSulferHelmet, VenusItems.ARMORSULFER, 7, 0, false).setUnlocalizedName("sulferHelmet");
        VenusItems.sulferChestplate = new SCVenusItemSulferArmor(SCVenusConfigManager.idArmorSulferChestplate, VenusItems.ARMORSULFER, 7, 1, false).setUnlocalizedName("sulferChestplate");
        VenusItems.sulferLeggings = new SCVenusItemSulferArmor(SCVenusConfigManager.idArmorSulferLeggings, VenusItems.ARMORSULFER, 7, 2, false).setUnlocalizedName("sulferLeggings");
        VenusItems.sulferBoots = new SCVenusItemSulferArmor(SCVenusConfigManager.idArmorSulferBoots, VenusItems.ARMORSULFER, 7, 3, false).setUnlocalizedName("sulferBoots");
    
        VenusItems.gemPickaxe = new SCVenusItemGemPickaxe(SCVenusConfigManager.idToolGemPickaxe, VenusItems.TOOLGEM).setUnlocalizedName("gemPick");
        VenusItems.gemAxe = new SCVenusItemGemAxe(SCVenusConfigManager.idToolGemAxe, VenusItems.TOOLGEM).setUnlocalizedName("gemAxe");
        VenusItems.gemHoe = new SCVenusItemGemHoe(SCVenusConfigManager.idToolGemHoe, VenusItems.TOOLGEM).setUnlocalizedName("gemHoe");
        VenusItems.gemSpade = new SCVenusItemGemSpade(SCVenusConfigManager.idToolGemSpade, VenusItems.TOOLGEM).setUnlocalizedName("gemSpade");
        VenusItems.gemSword = new SCVenusItemGemSword(SCVenusConfigManager.idToolGemSword, VenusItems.TOOLGEM).setUnlocalizedName("gemSword");

        VenusItems.gemHelmet = new SCVenusItemGemArmor(SCVenusConfigManager.idArmorGemHelmet, VenusItems.ARMORGEM, 7, 0, false).setUnlocalizedName("gemHelmet");
        VenusItems.gemChestplate = new SCVenusItemGemArmor(SCVenusConfigManager.idArmorGemChestplate, VenusItems.ARMORGEM, 7, 1, false).setUnlocalizedName("gemChestplate");
        VenusItems.gemLeggings = new SCVenusItemGemArmor(SCVenusConfigManager.idArmorGemLeggings, VenusItems.ARMORGEM, 7, 2, false).setUnlocalizedName("gemLeggings");
        VenusItems.gemBoots = new SCVenusItemGemArmor(SCVenusConfigManager.idArmorGemBoots, VenusItems.ARMORGEM, 7, 3, false).setUnlocalizedName("gemBoots");

        VenusItems.vurnBerry = (new SCVenusVurnBerry(SCVenusConfigManager.idVurnBerry, 4, 0.6F, VenusBlocks.VurnBerryBush.blockID, Block.tilledField.blockID)).setUnlocalizedName("vurnBerry").setTextureName("starcraftvenus:vurnBerry");

        VenusItems.VurnBerryOnAStick = new SCVenusItemVurnBerryOnAStick(SCVenusConfigManager.idVurnBerryOnAStick).setUnlocalizedName("vurnBerryOnAStick").setTextureName("starcraftvenus:vurnBerryOnAStick");
        
        VenusItems.T3Schematic = new SCVenusItemSchematic(SCVenusConfigManager.idSchematicRocketT3).setUnlocalizedName("T3Schematic");
        VenusItems.spaceshipT3 = new SCVenusItemSpaceshipTier3(SCVenusConfigManager.idItemSpaceshipTier3).setUnlocalizedName("spaceshipTier3");
    
        VenusItems.jetpack = new SCVenusItemJetpack(SCVenusConfigManager.idJetpack, VenusItems.ARMORJETPACK, 7, 1, false).setUnlocalizedName("jetpack");

        VenusItems.key = new SCVenusItemKey(SCVenusConfigManager.idItemKeyT3).setUnlocalizedName("key");
    }
    
    public static void registerHarvestLevels()
    {
        MinecraftForge.setToolClass(VenusItems.sulferPickaxe, "pickaxe", 4);
        MinecraftForge.setToolClass(VenusItems.sulferAxe, "axe", 4);
        MinecraftForge.setToolClass(VenusItems.sulferSpade, "shovel", 4);
    }
}
