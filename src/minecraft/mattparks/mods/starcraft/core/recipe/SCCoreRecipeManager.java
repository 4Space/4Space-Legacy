package mattparks.mods.starcraft.core.recipe;

import java.util.HashMap;

import mattparks.mods.starcraft.core.items.SCCoreItems;
import mattparks.mods.starcraft.core.util.SCCoreUtil;
import mattparks.mods.starcraft.spacecraftBlocks.SpacecraftBlocks;
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

public class SCCoreRecipeManager
{
    public static void loadRecipes()
    {
        SCCoreRecipeManager.addUniversalRecipes();
    }

    private static void addUniversalRecipes()
    {
    	OreDictionary.registerOre("ingotGem", new ItemStack(SCCoreItems.coreItemBasic, 1, 0));
        OreDictionary.registerOre("plateGem", new ItemStack(SCCoreItems.coreItemBasic, 1, 2));
    	
        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.coreItemBasic, 1, 1), new Object[] { "X", "X", 'X', "plateGem" });

        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.gemBoots), new Object[] { "X X", "X X", 'X', "plateGem" });
        
        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.gemHelmet), new Object[] { "XXX", "X X", 'X', "plateGem" });

        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.gemChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "plateGem" });

        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.gemLeggings), new Object[] { "XXX", "X X", "X X", 'X', "plateGem" });
        
        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.gemSword), new Object[] { "X", "X", "Y", 'X', "plateGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.gemPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "plateGem", 'Y',Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.gemSpade), new Object[] { "X", "Y", "Y", 'X', "plateGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.gemHoe), new Object[] { "XX", "Y ", "Y ", 'X', "plateGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.gemHoe), new Object[] { "XX", " Y", " Y", 'X', "plateGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.gemAxe), new Object[] { "XX", "XY", " Y", 'X', "plateGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(SCCoreItems.gemAxe), new Object[] { "XX", "YX", "Y ", 'X', "plateGem", 'Y', Item.stick });
        
        // Temporary craft TODO
        RecipeUtil.addRecipe(new ItemStack(SpacecraftBlocks.caravanModule), new Object[] { "XYZ", "GJG", "GGG", 'X', Block.furnaceIdle, 'Y', Block.workbench , 'Z', Block.chest, 'G' , GCCoreItems.canvas, 'J' , new ItemStack(GCCoreItems.canister, 1, 0) });
        
        // Compressor recipe
        CompressorRecipes.addShapelessRecipe(new ItemStack(SCCoreItems.coreItemBasic, 1, 2), "ingotGem", "ingotGem");
        
        // Smelting
        
    }
}
