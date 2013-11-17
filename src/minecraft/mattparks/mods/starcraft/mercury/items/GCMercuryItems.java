package mattparks.mods.starcraft.mercury.items;

import mattparks.mods.starcraft.core.SCCoreConfigManager;
import mattparks.mods.starcraft.mercury.GCMercuryConfigManager;
import net.minecraft.item.Item;

public class GCMercuryItems
{
    public static Item mercuryItemBasic;
    public static Item spaceshipT4;
    public static Item T4Schematic;
    
    public static void initItems()
    {
    	GCMercuryItems.spaceshipT4 = new SCCoreItemSpaceshipTier4(GCMercuryConfigManager.idItemSpaceshipTier4).setUnlocalizedName("spaceshipTier4");
        GCMercuryItems.mercuryItemBasic = new GCMercuryItem(GCMercuryConfigManager.idItemMercuryBasic);
        GCMercuryItems.T4Schematic = new GCMercuryItemSchematic(GCMercuryConfigManager.idTtemMercuryT4Schematic);
    }
    
    public static void registerHarvestLevels()
    {
    }
}
