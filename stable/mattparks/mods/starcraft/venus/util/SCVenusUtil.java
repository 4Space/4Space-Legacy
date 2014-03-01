package mattparks.mods.starcraft.venus.util;

import java.util.HashMap;

import mattparks.mods.starcraft.venus.inventory.SCVenusInventoryRocketBenchT3;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.recipe.GCCoreNasaWorkbenchRecipe;
import net.minecraft.item.ItemStack;

public class SCVenusUtil
{
    public static void addRocketBenchT3Recipe(ItemStack result, HashMap<Integer, ItemStack> input)
    {
        GalacticraftRegistry.addT2RocketRecipe(new GCCoreNasaWorkbenchRecipe(result, input));
    }

    public static ItemStack findMatchingSpaceshipT3Recipe(SCVenusInventoryRocketBenchT3 inventoryRocketBench)
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