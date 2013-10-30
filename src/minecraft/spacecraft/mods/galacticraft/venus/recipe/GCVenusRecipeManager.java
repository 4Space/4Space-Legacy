package spacecraft.mods.galacticraft.venus.recipe;

import java.util.HashMap;

import spacecraft.mods.galacticraft.venus.items.GCVenusItems;
import spacecraft.mods.galacticraft.venus.util.GCVenusUtil;
import micdoodle8.mods.galacticraft.core.blocks.GCCoreBlocks;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class GCVenusRecipeManager
{
    public static void loadRecipes()
    {
        GCVenusRecipeManager.addUniversalRecipes();
    }

    private static void addUniversalRecipes()
    {
        OreDictionary.registerOre("ingotDesh", new ItemStack(GCVenusItems.venusItemBasic, 1, 2));
        OreDictionary.registerOre("plateDesh", new ItemStack(GCVenusItems.venusItemBasic, 1, 5));
        OreDictionary.registerOre("plateHeavyT2", new ItemStack(GCVenusItems.venusItemBasic, 1, 3));

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferBoots), new Object[] { "X X", "X X", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 2) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 1), new Object[] { "X", "X", 'X', "ingotDesh" });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 4), new Object[] { "XWX", "XYX", " Z ", 'W', Item.diamond, 'X', Item.leather, 'Y', Item.slimeBall, 'Z', Block.chest });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferSword), new Object[] { "X", "X", "Y", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 2), 'Y', new ItemStack(GCVenusItems.venusItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 2), 'Y', new ItemStack(GCVenusItems.venusItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferSpade), new Object[] { "X", "Y", "Y", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 2), 'Y', new ItemStack(GCVenusItems.venusItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferHoe), new Object[] { "XX", "Y ", "Y ", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 2), 'Y', new ItemStack(GCVenusItems.venusItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferHoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 2), 'Y', new ItemStack(GCVenusItems.venusItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferAxe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 2), 'Y', new ItemStack(GCVenusItems.venusItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferAxe), new Object[] { "XX", "YX", "Y ", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 2), 'Y', new ItemStack(GCVenusItems.venusItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferHelmet), new Object[] { "XXX", "X X", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 2) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferChestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 2) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferLeggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 2) });

//        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 2), new Object[] { "X", 'X', new ItemStack(VenusBlocks.venusBlock, 1, 8) });

        
        // Smelting
        FurnaceRecipes.smelting().addSmelting(GCVenusItems.venusItemBasic.itemID, 0, new ItemStack(GCVenusItems.venusItemBasic, 1, 2), 0.2F);
    }
}
