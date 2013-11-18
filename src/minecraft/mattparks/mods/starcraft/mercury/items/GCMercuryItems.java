package mattparks.mods.starcraft.mercury.items;

import mattparks.mods.starcraft.core.SCCoreConfigManager;
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

    public static Item jetpack;
    
    public static EnumArmorMaterial ARMORJETPACK = EnumHelper.addArmorMaterial("JETPACK", 200, new int[] {0, 0, 0, 0}, 0);
    
    public static void initItems()
    {
    	GCMercuryItems.spaceshipT4 = new SCCoreItemSpaceshipTier4(GCMercuryConfigManager.idItemSpaceshipTier4).setUnlocalizedName("spaceshipTier4");
       
    	GCMercuryItems.mercuryItemBasic = new GCMercuryItem(GCMercuryConfigManager.idItemMercuryBasic);
      	GCMercuryItems.T4Schematic = new GCMercuryItemSchematic(GCMercuryConfigManager.idTtemMercuryT4Schematic);
      	GCMercuryItems.jetpack = new SCCoreItemJetpack(GCMercuryConfigManager.idArmorJetpack, GCMercuryItems.ARMORJETPACK, 11, 1, false).setUnlocalizedName("jetpack");
    }
    
    public static void registerHarvestLevels()
    {
    }
}
