package mattparks.mods.starcraft.mercury.items;

import mattparks.mods.starcraft.mercury.SCMercuryConfigManager;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;

public class MercuryItems
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
    	MercuryItems.spaceshipT4 = new SCMercuryItemSpaceshipTier4(SCMercuryConfigManager.idItemSpaceshipTier4).setUnlocalizedName("spaceshipTier4");
       
    	MercuryItems.mercuryItemBasic = new SCMercuryItem(SCMercuryConfigManager.idItemMercuryBasic);
      	MercuryItems.T4Schematic = new SCMercuryItemSchematic(SCMercuryConfigManager.idTtemMercuryT4Schematic);
      	MercuryItems.jetpack = new SCMercuryItemJetpack(SCMercuryConfigManager.idArmorJetpack, MercuryItems.ARMORJETPACK, 11, 1, false).setUnlocalizedName("jetpack");
   
        MercuryItems.iridiumPickaxe = new SCMercuryItemIridiumPickaxe(SCMercuryConfigManager.idToolIridiumPickaxe, MercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumPick");
        MercuryItems.iridiumAxe = new SCMercuryItemIridiumAxe(SCMercuryConfigManager.idToolIridiumAxe, MercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumAxe");
        MercuryItems.iridiumHoe = new SCMercuryItemIridiumHoe(SCMercuryConfigManager.idToolIridiumHoe, MercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumHoe");
        MercuryItems.iridiumSpade = new SCMercuryItemIridiumSpade(SCMercuryConfigManager.idToolIridiumSpade, MercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumSpade");
        MercuryItems.iridiumSword = new SCMercuryItemIridiumSword(SCMercuryConfigManager.idToolIridiumSword, MercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumSword");

        MercuryItems.iridiumHelmet = new SCMercuryItemIridiumArmor(SCMercuryConfigManager.idArmorIridiumHelmet, MercuryItems.ARMORIRIDIUM, 7, 0, false).setUnlocalizedName("iridiumHelmet");
        MercuryItems.iridiumChestplate = new SCMercuryItemIridiumArmor(SCMercuryConfigManager.idArmorIridiumChestplate, MercuryItems.ARMORIRIDIUM, 7, 1, false).setUnlocalizedName("iridiumChestplate");
        MercuryItems.iridiumLeggings = new SCMercuryItemIridiumArmor(SCMercuryConfigManager.idArmorIridiumLeggings, MercuryItems.ARMORIRIDIUM, 7, 2, false).setUnlocalizedName("iridiumLeggings");
        MercuryItems.iridiumBoots = new SCMercuryItemIridiumArmor(SCMercuryConfigManager.idArmorIridiumBoots, MercuryItems.ARMORIRIDIUM, 7, 3, false).setUnlocalizedName("iridiumBoots");    
    }
    
    public static void registerHarvestLevels()
    {
    }
}
