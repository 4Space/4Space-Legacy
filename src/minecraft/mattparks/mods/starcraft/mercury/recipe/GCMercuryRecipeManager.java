package mattparks.mods.starcraft.mercury.recipe;

import java.util.HashMap;

import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.venus.items.GCVenusItems;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.core.blocks.GCCoreBlocks;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class GCMercuryRecipeManager
{
    public static void loadRecipes()
    {
        GCMercuryRecipeManager.addUniversalRecipes();
    }

    private static void addUniversalRecipes()
    {
        // Temporary craft TODO
        RecipeUtil.addRecipe(new ItemStack(StarcraftCore.caravanModule), new Object[] { "XYZ", "GJG", "GGG", 'X', Block.furnaceIdle, 'Y', Block.workbench , 'Z', Block.chest, 'G' , GCCoreItems.canvas, 'J' , new ItemStack(GCCoreItems.canister, 1, 0) });
        
    }
}
