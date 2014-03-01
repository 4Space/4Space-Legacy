package mattparks.mods.starcraft.jupiter.util;

import mattparks.mods.starcraft.jupiter.inventory.SCJupiterInventoryRocketBenchT5;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import net.minecraft.item.ItemStack;

public class RecipeUtilSCJupiter
{
	public static ItemStack findMatchingSpaceshipT5Recipe(SCJupiterInventoryRocketBenchT5 inventoryRocketBench)
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
