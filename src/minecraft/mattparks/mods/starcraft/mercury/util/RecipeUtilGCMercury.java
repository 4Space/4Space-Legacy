package mattparks.mods.starcraft.mercury.util;

import mattparks.mods.starcraft.mercury.inventory.SCCoreInventoryRocketBenchT4;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import net.minecraft.item.ItemStack;

public class RecipeUtilGCMercury
{
    public static ItemStack findMatchingSpaceshipT4Recipe(SCCoreInventoryRocketBenchT4 inventoryRocketBench)
    {
        for (INasaWorkbenchRecipe recipe : GalacticraftRegistry.getRocketT2Recipes())
        {
            if (recipe.matches(inventoryRocketBench))
            {
                return recipe.getRecipeOutput();
            }
        }

        return null;
    }
}
