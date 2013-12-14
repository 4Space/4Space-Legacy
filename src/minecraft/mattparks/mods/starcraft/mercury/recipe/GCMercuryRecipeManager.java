package mattparks.mods.starcraft.mercury.recipe;

import mattparks.mods.starcraft.core.StarcraftMercury;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class GCMercuryRecipeManager
{
    private static void addUniversalRecipes()
    {
        // Temporary craft TODO
        RecipeUtil.addRecipe(new ItemStack(StarcraftMercury.caravanModule), new Object[] { "XYZ", "GJG", "GGG", 'X', Block.furnaceIdle, 'Y', Block.workbench , 'Z', Block.chest, 'G' , GCCoreItems.canvas, 'J' , new ItemStack(GCCoreItems.canister, 1, 0) });
        
    }

    public static void loadRecipes()
    {
        GCMercuryRecipeManager.addUniversalRecipes();
    }
}
