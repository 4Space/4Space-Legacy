package mattparks.mods.starcraft.pluto.recipe;

import mattparks.mods.starcraft.pluto.blocks.PlutoBlocks;
import mattparks.mods.starcraft.pluto.items.PlutoItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class SCPlutoRecipeManager
{
    private static void addUniversalRecipes()
    {
    	OreDictionary.registerOre("blueGem", new ItemStack(PlutoItems.plutoItemBasic, 1, 3));

        //Armor
        RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemBoots), new Object[] { "X X", "X X", 'X', "blueGem" });
       
        RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemHelmet), new Object[] { "XXX", "X X", 'X', "blueGem" });

        RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "blueGem" });

        RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemLeggings), new Object[] { "XXX", "X X", "X X", 'X', "blueGem" });

        //Tools
        
        RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "blueGem", 'Y',Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemSword), new Object[] { "X", "X", "Y", 'X', "blueGem", 'Y', Item.stick  });
        
        RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemSpade), new Object[] { "X", "Y", "Y", 'X', "blueGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemHoe), new Object[] { "XX", "Y ", "Y ", 'X', "blueGem", 'Y', Item.stick  });;

        RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemAxe), new Object[] { "XX", "XY", " Y", 'X', "blueGem", 'Y', Item.stick  });

  	//Blocks      

        RecipeUtil.addRecipe(new ItemStack(PlutoBlocks.BlueGemBlock), new Object[] { "XXX", "XXX", "XXX", 'X', "blueGem" });

    //Smelting
        FurnaceRecipes.smelting().addSmelting(PlutoBlocks.BlueGemOre.blockID, 0, new ItemStack(PlutoItems.plutoItemBasic, 1, 5), 0.2F);
        FurnaceRecipes.smelting().addSmelting(PlutoBlocks.FrozenIronOre.blockID, 0, new ItemStack(PlutoItems.plutoItemBasic, 1, 3), 0.2F);
        FurnaceRecipes.smelting().addSmelting(PlutoBlocks.UnunpentiumOre.blockID, 0, new ItemStack(PlutoItems.plutoItemBasic, 1, 1), 0.2F);
    }

   

    public static void loadRecipes()
    {
        SCPlutoRecipeManager.addUniversalRecipes();
    }
}
