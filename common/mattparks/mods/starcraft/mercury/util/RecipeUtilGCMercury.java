package mattparks.mods.starcraft.mercury.util;

import mattparks.mods.starcraft.mercury.inventory.SCMercuryInventoryRocketBenchT4;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import net.minecraft.item.ItemStack;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class RecipeUtilGCMercury
{
    public static ItemStack findMatchingSpaceshipT4Recipe(SCMercuryInventoryRocketBenchT4 inventoryRocketBench)
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
