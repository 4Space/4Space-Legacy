package mattparks.mods.starcraft.mercury.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import mattparks.mods.starcraft.core.StarcraftGas;
import mattparks.mods.starcraft.core.StarcraftMercury;
import mattparks.mods.starcraft.core.StarcraftPluto;
import mattparks.mods.starcraft.jupiter.items.GCJupiterItems;
import mattparks.mods.starcraft.mercury.items.GCMercuryItems;
import mattparks.mods.starcraft.pluto.items.GCPlutoItems;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class GCMercuryRecipeManager
{
    private static void addUniversalRecipes()
    {
    	OreDictionary.registerOre("iridium", new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 3));
    	OreDictionary.registerOre("blueGem", new ItemStack(GCPlutoItems.plutoItemBasic, 1, 3));
    	OreDictionary.registerOre("clearDiamond", new ItemStack(GCJupiterItems.jupiterItemBasic, 1, 3));
    	
        // Temporary craft TODO
        RecipeUtil.addRecipe(new ItemStack(StarcraftMercury.caravanModule), new Object[] { "XYZ", "GJG", "GGG", 'X', Block.furnaceIdle, 'Y', Block.workbench , 'Z', Block.chest, 'G' , GCCoreItems.canvas, 'J' , new ItemStack(GCCoreItems.canister, 1, 0) });

        //Armor
        
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumBoots), new Object[] { "X X", "X X", 'X', "iridium" });
       
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumHelmet), new Object[] { "XXX", "X X", 'X', "iridium" });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "iridium" });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumLeggings), new Object[] { "XXX", "X X", "X X", 'X', "iridium" });       

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.jetpack), new Object[] { "ZYZ", " X ", 'X', GCCoreItems.rocketEngine, 'Y', Item.plateIron, 'Z', GCCoreItems.canister });

        //Tools
        
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "iridium", 'Y',Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumSword), new Object[] { "X", "X", "Y", 'X', "iridium", 'Y', Item.stick  });
        
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumSpade), new Object[] { "X", "Y", "Y", 'X', "iridium", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumHoe), new Object[] { "XX", " Y", " Y", 'X', "iridium", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumAxe), new Object[] { "XX", "YX", "Y ", 'X', "iridium", 'Y', Item.stick });

        
        //Blocks      

        RecipeUtil.addRecipe(new ItemStack(StarcraftMercury.IridiumBlock), new Object[] { "XXX", "XXX", "XXX", 'X', "iridium" });

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
       
        // Smelting

        FurnaceRecipes.smelting().addSmelting(StarcraftMercury.MercuryCoalOre.blockID, 0, new ItemStack(Item.coal), 0.2F);
        FurnaceRecipes.smelting().addSmelting(StarcraftMercury.MercuryCopperOre.blockID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(StarcraftMercury.MercuryTinOre.blockID, 0, OreDictionary.getOres("ingotTin").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(StarcraftMercury.MercuryIridiumOre.blockID, 0, new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 3), 0.2F);
        
        //Pluto
        
        //Armor
        RecipeUtil.addRecipe(new ItemStack(GCPlutoItems.blueGemBoots), new Object[] { "X X", "X X", 'X', "blueGem" });
       
        RecipeUtil.addRecipe(new ItemStack(GCPlutoItems.blueGemHelmet), new Object[] { "XXX", "X X", 'X', "blueGem" });

        RecipeUtil.addRecipe(new ItemStack(GCPlutoItems.blueGemChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "blueGem" });

        RecipeUtil.addRecipe(new ItemStack(GCPlutoItems.blueGemLeggings), new Object[] { "XXX", "X X", "X X", 'X', "blueGem" });

        //Tools
        
        RecipeUtil.addRecipe(new ItemStack(GCPlutoItems.blueGemPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "blueGem", 'Y',Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCPlutoItems.blueGemSword), new Object[] { "X", "X", "Y", 'X', "blueGem", 'Y', Item.stick  });
        
        RecipeUtil.addRecipe(new ItemStack(GCPlutoItems.blueGemSpade), new Object[] { "X", "Y", "Y", 'X', "blueGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCPlutoItems.blueGemHoe), new Object[] { "XX", "Y ", "Y ", 'X', "blueGem", 'Y', Item.stick  });;

        RecipeUtil.addRecipe(new ItemStack(GCPlutoItems.blueGemAxe), new Object[] { "XX", "XY", " Y", 'X', "blueGem", 'Y', Item.stick  });

  	//Blocks      

        RecipeUtil.addRecipe(new ItemStack(StarcraftPluto.BlueGemBlock), new Object[] { "XXX", "XXX", "XXX", 'X', "blueGem" });

    //Smelting
        FurnaceRecipes.smelting().addSmelting(StarcraftPluto.BlueGemOre.blockID, 0, new ItemStack(GCPlutoItems.plutoItemBasic, 1, 5), 0.2F);
        FurnaceRecipes.smelting().addSmelting(StarcraftPluto.FrozenIronOre.blockID, 0, new ItemStack(GCPlutoItems.plutoItemBasic, 1, 3), 0.2F);
        FurnaceRecipes.smelting().addSmelting(StarcraftPluto.UnunpentiumOre.blockID, 0, new ItemStack(GCPlutoItems.plutoItemBasic, 1, 1), 0.2F);
    
    //Jupiter
        
        //Armor
        RecipeUtil.addRecipe(new ItemStack(GCJupiterItems.clearDiamondBoots), new Object[] { "X X", "X X", 'X', "clearDiamond" });
       
        RecipeUtil.addRecipe(new ItemStack(GCJupiterItems.clearDiamondHelmet), new Object[] { "XXX", "X X", 'X', "clearDiamond" });

        RecipeUtil.addRecipe(new ItemStack(GCJupiterItems.clearDiamondChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "clearDiamond" });

        RecipeUtil.addRecipe(new ItemStack(GCJupiterItems.clearDiamondLeggings), new Object[] { "XXX", "X X", "X X", 'X', "clearDiamond" });

        //Tools
        
        RecipeUtil.addRecipe(new ItemStack(GCJupiterItems.clearDiamondSword), new Object[] { "X", "X", "Y", 'X', "clearDiamond", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCJupiterItems.clearDiamondPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "clearDiamond", 'Y',Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCJupiterItems.clearDiamondSpade), new Object[] { "X", "Y", "Y", 'X', "clearDiamond", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCJupiterItems.clearDiamondHoe), new Object[] { "XX", "Y ", "Y ", 'X', "clearDiamond", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCJupiterItems.clearDiamondAxe), new Object[] { "XX", "XY", " Y", 'X', "clearDiamond", 'Y', Item.stick  });

  	//Blocks      

        RecipeUtil.addRecipe(new ItemStack(StarcraftGas.ClearDiamondBlock), new Object[] { "XXX", "XXX", "XXX", 'X', "clearDiamond" });

    }

   

    public static void loadRecipes()
    {
        GCMercuryRecipeManager.addUniversalRecipes();
    }
}
