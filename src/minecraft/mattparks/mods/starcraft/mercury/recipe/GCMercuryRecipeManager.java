package mattparks.mods.starcraft.mercury.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import mattparks.mods.starcraft.core.StarcraftMercury;
import mattparks.mods.starcraft.core.StarcraftVenus;
import mattparks.mods.starcraft.core.blocks.StarcraftGlowstone;
import mattparks.mods.starcraft.mercury.items.GCMercuryItems;
import mattparks.mods.starcraft.venus.items.GCVenusItems;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GCMercuryRecipeManager
{
    private static void addUniversalRecipes()
    {
    	OreDictionary.registerOre("iridium", new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 3));
        // Temporary craft TODO
        RecipeUtil.addRecipe(new ItemStack(StarcraftMercury.caravanModule), new Object[] { "XYZ", "GJG", "GGG", 'X', Block.furnaceIdle, 'Y', Block.workbench , 'Z', Block.chest, 'G' , GCCoreItems.canvas, 'J' , new ItemStack(GCCoreItems.canister, 1, 0) });
        
        //Armor
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumBoots), new Object[] { "X X", "X X", 'X', "iridium" });
       
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumHelmet), new Object[] { "XXX", "X X", 'X', "iridium" });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "iridium" });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumLeggings), new Object[] { "XXX", "X X", "X X", 'X', "iridium" });
        
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumSword), new Object[] { "X", "X", "Y", 'X', "iridium", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.jetpack), new Object[] { "   ", "ZYZ", " X ", 'X', GCCoreItems.rocketEngine, 'Y', Item.plateIron, 'Z', GCCoreItems.canister });
        //Tools
        
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "iridium", 'Y',Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumSpade), new Object[] { "X", "Y", "Y", 'X', "iridium", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumHoe), new Object[] { "XX", "Y ", "Y ", 'X', "iridium", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumHoe), new Object[] { "XX", " Y", " Y", 'X', "iridium", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumAxe), new Object[] { "XX", "XY", " Y", 'X', "iridium", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumAxe), new Object[] { "XX", "YX", "Y ", 'X', "iridium", 'Y', Item.stick });
        
        //Glowstone
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.BlackGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 0), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.BlueGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.BrownGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 3), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.CyanGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 6), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.GreenGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 2), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.GreyGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 8), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.LightBlueGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 12), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.SilverGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 7), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.LimeGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 10), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.MagentaGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 13), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.OrangeGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 14), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.PinkGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 9), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.PurpleGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 5), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.RedGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Block.glowStone, 1, 0));

        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.WhiteGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 15), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftMercury.YellowGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 11), new ItemStack(Block.glowStone, 1, 0));        
        }
    

    public static void loadRecipes()
    {
        GCMercuryRecipeManager.addUniversalRecipes();
    }
}
