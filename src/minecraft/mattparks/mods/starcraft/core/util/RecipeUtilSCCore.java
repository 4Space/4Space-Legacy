package mattparks.mods.starcraft.core.util;

import mattparks.mods.starcraft.core.inventory.SCCoreInventoryRocketBenchT4;
import mattparks.mods.starcraft.core.inventory.SCCoreInventoryRocketBenchT5;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import net.minecraft.item.ItemStack;

public class RecipeUtilSCCore
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

	public static ItemStack findMatchingSpaceshipT5Recipe(SCCoreInventoryRocketBenchT5 inventoryRocketBench)
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
