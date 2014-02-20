package mattparks.mods.starcraft.mercury.recipe;

import mattparks.mods.starcraft.mercury.blocks.MercuryBlocks;
import mattparks.mods.starcraft.mercury.items.MercuryItems;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class SCMercuryRecipeManager
{
    private static void addUniversalRecipes()
    {
    	OreDictionary.registerOre("iridium", new ItemStack(MercuryItems.mercuryItemBasic, 1, 3));
    	
        // Temporary craft TODO
        RecipeUtil.addRecipe(new ItemStack(MercuryBlocks.caravanModule), new Object[] { "XYZ", "GJG", "GGG", 'X', Block.furnaceIdle, 'Y', Block.workbench , 'Z', Block.chest, 'G' , GCCoreItems.canvas, 'J' , new ItemStack(GCCoreItems.canister, 1, 0) });

        //Armor
        
        RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumBoots), new Object[] { "X X", "X X", 'X', "iridium" });
       
        RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumHelmet), new Object[] { "XXX", "X X", 'X', "iridium" });

        RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "iridium" });

        RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumLeggings), new Object[] { "XXX", "X X", "X X", 'X', "iridium" });       

        RecipeUtil.addRecipe(new ItemStack(MercuryItems.jetpack), new Object[] { "ZYZ", " X ", 'X', GCCoreItems.rocketEngine, 'Y', Item.plateIron, 'Z', GCCoreItems.canister });

        //Tools
        
        RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "iridium", 'Y',Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumSword), new Object[] { "X", "X", "Y", 'X', "iridium", 'Y', Item.stick  });
        
        RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumSpade), new Object[] { "X", "Y", "Y", 'X', "iridium", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumHoe), new Object[] { "XX", " Y", " Y", 'X', "iridium", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumAxe), new Object[] { "XX", "YX", "Y ", 'X', "iridium", 'Y', Item.stick });

        
        //Blocks      

        RecipeUtil.addRecipe(new ItemStack(MercuryBlocks.IridiumBlock), new Object[] { "XXX", "XXX", "XXX", 'X', "iridium" });

        //Glowstone
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.BlackGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 0), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.BlueGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.BrownGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 3), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.CyanGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 6), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.GreenGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 2), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.GreyGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 8), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.LightBlueGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 12), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.SilverGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 7), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.LimeGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 10), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.MagentaGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 13), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.OrangeGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 14), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.PinkGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 9), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.PurpleGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 5), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.RedGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Block.glowStone, 1, 0));

        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.WhiteGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 15), new ItemStack(Block.glowStone, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.YellowGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 11), new ItemStack(Block.glowStone, 1, 0));        
       
        // Smelting

        FurnaceRecipes.smelting().addSmelting(MercuryBlocks.MercuryCoalOre.blockID, 0, new ItemStack(Item.coal), 0.2F);
        FurnaceRecipes.smelting().addSmelting(MercuryBlocks.MercuryCopperOre.blockID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(MercuryBlocks.MercuryTinOre.blockID, 0, OreDictionary.getOres("ingotTin").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(MercuryBlocks.MercuryIridiumOre.blockID, 0, new ItemStack(MercuryItems.mercuryItemBasic, 1, 3), 0.2F);
    }

   

    public static void loadRecipes()
    {
        SCMercuryRecipeManager.addUniversalRecipes();
    }
}
