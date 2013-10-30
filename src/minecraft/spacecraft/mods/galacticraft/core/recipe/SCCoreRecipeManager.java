package spacecraft.mods.galacticraft.core.recipe;

import java.util.HashMap;

import spacecraft.mods.galacticraft.core.items.SCCoreItems;
import spacecraft.mods.galacticraft.core.util.SCCoreUtil;
import micdoodle8.mods.galacticraft.core.blocks.GCCoreBlocks;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class SCCoreRecipeManager
{
    public static void loadRecipes()
    {
        SCCoreRecipeManager.addUniversalRecipes();
    }

    private static void addUniversalRecipes()
    {
        OreDictionary.registerOre("ingotDesh", new ItemStack(SCCoreItems.venusItemBasic, 1, 2));
        OreDictionary.registerOre("plateDesh", new ItemStack(SCCoreItems.venusItemBasic, 1, 5));
        OreDictionary.registerOre("plateHeavyT2", new ItemStack(SCCoreItems.venusItemBasic, 1, 3));

        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.venusItemBasic, 1, 1), new Object[] { "X", "X", 'X', "ingotDesh" });

        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.venusItemBasic, 1, 4), new Object[] { "XWX", "XYX", " Z ", 'W', Item.diamond, 'X', Item.leather, 'Y', Item.slimeBall, 'Z', Block.chest });

//        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 2), new Object[] { "X", 'X', new ItemStack(VenusBlocks.venusBlock, 1, 8) });

        
        // Smelting
        FurnaceRecipes.smelting().addSmelting(SCCoreItems.venusItemBasic.itemID, 0, new ItemStack(SCCoreItems.venusItemBasic, 1, 2), 0.2F);

        // Schematic
        HashMap<Integer, ItemStack> input = new HashMap<Integer, ItemStack>();
        input.put(1, new ItemStack(GCCoreItems.partNoseCone));
        input.put(2, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(3, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(4, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(5, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(6, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(7, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(8, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(9, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(10, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(11, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(12, new ItemStack(GCCoreItems.rocketEngine, 1, 1));
        input.put(13, new ItemStack(GCCoreItems.partFins));
        input.put(14, new ItemStack(GCCoreItems.partFins));
        input.put(15, new ItemStack(GCCoreItems.rocketEngine));
        input.put(16, new ItemStack(GCCoreItems.rocketEngine, 1, 1));
        input.put(17, new ItemStack(GCCoreItems.partFins));
        input.put(18, new ItemStack(GCCoreItems.partFins));
        input.put(19, null);
        input.put(20, null);
        input.put(21, null);
        SCCoreUtil.addRocketBenchT3Recipe(new ItemStack(SCCoreItems.spaceship, 1, 0), input);

        HashMap<Integer, ItemStack> input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack(Block.chest));
        input2.put(20, null);
        input2.put(21, null);
        SCCoreUtil.addRocketBenchT3Recipe(new ItemStack(SCCoreItems.spaceship, 1, 1), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, null);
        input2.put(20, new ItemStack(Block.chest));
        input2.put(21, null);
        SCCoreUtil.addRocketBenchT3Recipe(new ItemStack(SCCoreItems.spaceship, 1, 1), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, null);
        input2.put(20, null);
        input2.put(21, new ItemStack(Block.chest));
        SCCoreUtil.addRocketBenchT3Recipe(new ItemStack(SCCoreItems.spaceship, 1, 1), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack(Block.chest));
        input2.put(20, new ItemStack(Block.chest));
        input2.put(21, null);
        SCCoreUtil.addRocketBenchT3Recipe(new ItemStack(SCCoreItems.spaceship, 1, 2), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack(Block.chest));
        input2.put(20, null);
        input2.put(21, new ItemStack(Block.chest));
        SCCoreUtil.addRocketBenchT3Recipe(new ItemStack(SCCoreItems.spaceship, 1, 2), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, null);
        input2.put(20, new ItemStack(Block.chest));
        input2.put(21, new ItemStack(Block.chest));
        SCCoreUtil.addRocketBenchT3Recipe(new ItemStack(SCCoreItems.spaceship, 1, 2), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack(Block.chest));
        input2.put(20, new ItemStack(Block.chest));
        input2.put(21, new ItemStack(Block.chest));
        SCCoreUtil.addRocketBenchT3Recipe(new ItemStack(SCCoreItems.spaceship, 1, 3), input2);
        
        //
        
        input = new HashMap<Integer, ItemStack>();
        input.put(1, new ItemStack(GCCoreItems.partNoseCone));
        input.put(2, new ItemStack(GCCoreItems.basicItem, 1, 14));
        input.put(3, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(4, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(5, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(6, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(7, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(8, new ItemStack(SCCoreItems.venusItemBasic, 1, 3));
        input.put(9, new ItemStack(GCCoreItems.partFins));
        input.put(10, new ItemStack(GCCoreItems.partFins));
        input.put(11, new ItemStack(GCCoreItems.rocketEngine));
        input.put(12, new ItemStack(GCCoreItems.partFins));
        input.put(13, new ItemStack(GCCoreItems.partFins));

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(14, new ItemStack(Block.chest));
        input2.put(15, null);
        input2.put(16, null);
    }
}
