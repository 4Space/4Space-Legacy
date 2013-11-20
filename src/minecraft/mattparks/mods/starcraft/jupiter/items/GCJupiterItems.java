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

    public static void initItems()
    {
    	GCJupiterItems.jupiterItemBasic = new GCJupiterItem(GCJupiterConfigManager.idItemJupiterBasic).setUnlocalizedName("jupiterBasic");
        GCJupiterItems.spaceshipT5 = new SCCoreItemSpaceshipTier5(GCJupiterConfigManager.idItemSpaceshipTier5).setUnlocalizedName("spaceshipTier5");
//        SCCoreItems.schematic = new SCCoreItemSchematic(SCCoreConfigManager.idItemSchematicMars).setUnlocalizedName("schematic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}