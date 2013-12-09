package mattparks.mods.starcraft.mercury.items;

import mattparks.mods.starcraft.mercury.GCMercuryConfigManager;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;

public class GCMercuryItems
{
    public static Item mercuryItemBasic;
    
    public static Item spaceshipT4;
    public static Item T4Schematic;
    
    public static Item iridiumPickaxe;
    public static Item iridiumAxe;
    public static Item iridiumHoe;
    public static Item iridiumSpade;
    public static Item iridiumSword;
    public static Item iridiumHelmet;
    public static Item iridiumChestplate;
    public static Item iridiumLeggings;
    public static Item iridiumBoots;
    

    public static Item jetpack;
    
    public static EnumArmorMaterial ARMORJETPACK = EnumHelper.addArmorMaterial("JETPACK", 200, new int[] {0, 0, 0, 0}, 0);
    
    public static EnumArmorMaterial ARMORIRIDIUM = EnumHelper.addArmorMaterial("IRIDIUM", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLIRIDIUM = EnumHelper.addToolMaterial("IRIDIUM", 3, 1024, 5.0F, 2.5F, 8);
    
    public static void initItems()
    {
    	GCMercuryItems.spaceshipT4 = new SCCoreItemSpaceshipTier4(GCMercuryConfigManager.idItemSpaceshipTier4).setUnlocalizedName("spaceshipTier4");
       
    	GCMercuryItems.mercuryItemBasic = new GCMercuryItem(GCMercuryConfigManager.idItemMercuryBasic);
      	GCMercuryItems.T4Schematic = new GCMercuryItemSchematic(GCMercuryConfigManager.idTtemMercuryT4Schematic);
      	GCMercuryItems.jetpack = new SCCoreItemJetpack(GCMercuryConfigManager.idArmorJetpack, GCMercuryItems.ARMORJETPACK, 11, 1, false).setUnlocalizedName("jetpack");
   
        GCMercuryItems.iridiumPickaxe = new SCCoreItemIridiumPickaxe(GCMercuryConfigManager.idToolIridiumPickaxe, GCMercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumPick");
        GCMercuryItems.iridiumAxe = new SCCoreItemIridiumAxe(GCMercuryConfigManager.idToolIridiumAxe, GCMercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumAxe");
        GCMercuryItems.iridiumHoe = new SCCoreItemIridiumHoe(GCMercuryConfigManager.idToolIridiumHoe, GCMercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumHoe");
        GCMercuryItems.iridiumSpade = new SCCoreItemIridiumSpade(GCMercuryConfigManager.idToolIridiumSpade, GCMercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumSpade");
        GCMercuryItems.iridiumSword = new SCCoreItemIridiumSword(GCMercuryConfigManager.idToolIridiumSword, GCMercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumSword");

        GCMercuryItems.iridiumHelmet = new SCCoreItemIridiumArmor(GCMercuryConfigManager.idArmorIridiumHelmet, GCMercuryItems.ARMORIRIDIUM, 7, 0, false).setUnlocalizedName("iridiumHelmet");
        GCMercuryItems.iridiumChestplate = new SCCoreItemIridiumArmor(GCMercuryConfigManager.idArmorIridiumChestplate, GCMercuryItems.ARMORIRIDIUM, 7, 1, false).setUnlocalizedName("iridiumChestplate");
        GCMercuryItems.iridiumLeggings = new SCCoreItemIridiumArmor(GCMercuryConfigManager.idArmorIridiumLeggings, GCMercuryItems.ARMORIRIDIUM, 7, 2, false).setUnlocalizedName("iridiumLeggings");
        GCMercuryItems.iridiumBoots = new SCCoreItemIridiumArmor(GCMercuryConfigManager.idArmorIridiumBoots, GCMercuryItems.ARMORIRIDIUM, 7, 3, false).setUnlocalizedName("iridiumBoots");    
    }
    
    public static void registerHarvestLevels()
    {
    }
}
