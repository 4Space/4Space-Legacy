package mattparks.mods.starcraft.venus.util;

import mattparks.mods.starcraft.venus.VenusCore;
import mattparks.mods.starcraft.venus.inventory.SCVenusInventoryRocketBenchT3;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import net.minecraft.item.ItemStack;

public class RecipeUtilVenus
{
	public static ItemStack findMatchingSpaceshipT3Recipe(SCVenusInventoryRocketBenchT3 inventoryRocketBench)
	{
		for (INasaWorkbenchRecipe recipe : VenusCore.getRocketT3Recipes())
		{
			if (recipe.matches(inventoryRocketBench))
			{
				return recipe.getRecipeOutput();
			}
		}

		return null;
	}
}
