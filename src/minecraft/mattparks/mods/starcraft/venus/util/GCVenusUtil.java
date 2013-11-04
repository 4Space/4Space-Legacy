package mattparks.mods.starcraft.venus.util;

import java.util.HashMap;

import mattparks.mods.starcraft.venus.inventory.SCCoreInventoryRocketBenchT3;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.recipe.GCCoreNasaWorkbenchRecipe;
import net.minecraft.item.ItemStack;

public class GCVenusUtil
{
    public static ItemStack findMatchingSpaceshipT3Recipe(SCCoreInventoryRocketBenchT3 inventoryRocketBench)
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
