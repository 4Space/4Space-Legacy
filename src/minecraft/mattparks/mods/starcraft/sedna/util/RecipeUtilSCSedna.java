package mattparks.mods.starcraft.sedna.util;

import mattparks.mods.starcraft.sedna.inventory.SCSednaInventoryRocketBenchT6;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import net.minecraft.item.ItemStack;

public class RecipeUtilSCSedna
{
	public static ItemStack findMatchingSpaceshipT6Recipe(SCSednaInventoryRocketBenchT6 inventoryRocketBench)
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
