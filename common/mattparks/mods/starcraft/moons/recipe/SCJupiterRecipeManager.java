package mattparks.mods.starcraft.moons.recipe;

import mattparks.mods.starcraft.moons.items.JupiterItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
 
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
        
    }

   

    public static void loadRecipes()
    {
        SCJupiterRecipeManager.addUniversalRecipes();
    }
}
