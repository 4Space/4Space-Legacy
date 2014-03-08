package mattparks.mods.starcraft.jupiter.recipe;

import mattparks.mods.starcraft.jupiter.blocks.JupiterBlocks;
import mattparks.mods.starcraft.jupiter.items.JupiterItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SCJupiterRecipeManager
{
    private static void addUniversalRecipes()
    {
    	OreDictionary.registerOre("clearDiamond", new ItemStack(JupiterItems.jupiterItemBasic, 1, 3));
    	
        //GENERAL
        RecipeUtil.addRecipe(new ItemStack(JupiterItems.clearDiamondBoots), new Object[] { "X X", "X X", 'X', "clearDiamond" });
        RecipeUtil.addRecipe(new ItemStack(JupiterItems.clearDiamondHelmet), new Object[] { "XXX", "X X", 'X', "clearDiamond" });
        RecipeUtil.addRecipe(new ItemStack(JupiterItems.clearDiamondChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "clearDiamond" });
        RecipeUtil.addRecipe(new ItemStack(JupiterItems.clearDiamondLeggings), new Object[] { "XXX", "X X", "X X", 'X', "clearDiamond" });

        RecipeUtil.addRecipe(new ItemStack(JupiterItems.clearDiamondSword), new Object[] { "X", "X", "Y", 'X', "clearDiamond", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(JupiterItems.clearDiamondPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "clearDiamond", 'Y',Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(JupiterItems.clearDiamondSpade), new Object[] { "X", "Y", "Y", 'X', "clearDiamond", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(JupiterItems.clearDiamondHoe), new Object[] { "XX", "Y ", "Y ", 'X', "clearDiamond", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(JupiterItems.clearDiamondAxe), new Object[] { "XX", "XY", " Y", 'X', "clearDiamond", 'Y', Item.stick  });

        //ITEMS
        
  	    //BLOCKS
        RecipeUtil.addRecipe(new ItemStack(JupiterBlocks.ClearDiamondBlock), new Object[] { "XXX", "XXX", "XXX", 'X', "clearDiamond" });

    }

   

    public static void loadRecipes()
    {
        SCJupiterRecipeManager.addUniversalRecipes();
    }
}
