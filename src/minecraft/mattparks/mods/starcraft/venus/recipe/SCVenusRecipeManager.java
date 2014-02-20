package mattparks.mods.starcraft.venus.recipe;

import java.util.HashMap;

import mattparks.mods.starcraft.venus.blocks.VenusBlocks;
import mattparks.mods.starcraft.venus.items.VenusItems;
import mattparks.mods.starcraft.venus.util.SCVenusUtil;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class SCVenusRecipeManager
{
    private static void addUniversalRecipes()
    {
    	OreDictionary.registerOre("ingotSulfer", new ItemStack(VenusItems.venusItemBasic, 1, 0));
    	OreDictionary.registerOre("sulferDust", new ItemStack(VenusItems.venusItemBasic, 1, 1));
    	OreDictionary.registerOre("redGem", new ItemStack(VenusItems.venusItemBasic, 1, 3));
//        OreDictionary.registerOre("plateSulfer", new ItemStack(GCVenusItems.venusItemBasic, 1, 2));
//        OreDictionary.registerOre("itemGem", new ItemStack(GCVenusItems.venusItemBasic, 1, 2));

        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemBoots), new Object[] { "X X", "X X", 'X', "redGem" });
        
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemHelmet), new Object[] { "XXX", "X X", 'X', "redGem" });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "redGem" });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemLeggings), new Object[] { "XXX", "X X", "X X", 'X', "redGem" });
        
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemSword), new Object[] { "X", "X", "Y", 'X', "redGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "redGem", 'Y',Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemSpade), new Object[] { "X", "Y", "Y", 'X', "redGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemHoe), new Object[] { "XX", "Y ", "Y ", 'X', "redGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemHoe), new Object[] { "XX", " Y", " Y", 'X', "redGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemAxe), new Object[] { "XX", "XY", " Y", 'X', "redGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemAxe), new Object[] { "XX", "YX", "Y ", 'X', "redGem", 'Y', Item.stick });
        
        
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferBoots), new Object[] { "X X", "X X", 'X', "ingotSulfer" });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferSword), new Object[] { "X", "X", "Y", 'X', "ingotSulfer", 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "ingotSulfer", 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferSpade), new Object[] { "X", "Y", "Y", 'X', "ingotSulfer", 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferHoe), new Object[] { "XX", "Y ", "Y ", 'X', "ingotSulfer", 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferHoe), new Object[] { "XX", " Y", " Y", 'X', "ingotSulfer", 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferAxe), new Object[] { "XX", "XY", " Y", 'X', "ingotSulfer", 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferAxe), new Object[] { "XX", "YX", "Y ", 'X', "ingotSulfer", 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferHelmet), new Object[] { "XXX", "X X", 'X', "ingotSulfer" });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "ingotSulfer" });

        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferLeggings), new Object[] { "XXX", "X X", "X X", 'X', "ingotSulfer" });

        
        //Sulfer Ingot Crafting
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 0), new Object[] { "XX ", "   ", "   ", 'X', "sulferDust" });

        
//        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusBattery, 1, GCVenusItems.venusBattery.getMaxDamage()), new Object[] { " T ", "TRT", "TCT", 'T', "plateSulfer", 'R', Item.redstone, 'C', Item.coal });
        
        
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusSulferBlock, 1, 0), new Object[] { "TTT", "TTT", "TTT", 'T', "ingotSulfer" });
        
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusRedGemBlock, 1, 0), new Object[] { "TTT", "TTT", "TTT", 'T', "redGem"});
        
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 5), new Object[] { "WXW", "WYW", "WZW", 'X', "compressedSteel", 'Y', Block.glass, 'Z', new ItemStack(GCCoreItems.canister, 1, 0), 'W', "plateSulfer" });
        
        GameRegistry.addShapelessRecipe(new ItemStack(VenusItems.venusItemBasic, 9, 0), new ItemStack(VenusBlocks.VenusSulferBlock, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(VenusItems.venusItemBasic, 9, 3), new ItemStack(VenusBlocks.VenusRedGemBlock, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 4), new ItemStack(VenusItems.venusItemBasic, 1, 5), new ItemStack(VenusItems.venusItemBasic, 1, 3));
        
        GameRegistry.addShapelessRecipe(new ItemStack(VenusBlocks.VenusBasalt, 1, 0),  new ItemStack(VenusItems.venusItemBasic, 1, 7), new ItemStack(VenusItems.venusItemBasic, 1, 7), new ItemStack(VenusItems.venusItemBasic, 1, 7), new ItemStack(VenusItems.venusItemBasic, 1, 7));
        
        GameRegistry.addShapelessRecipe(new ItemStack(VenusBlocks.VenusHalfBasalt, 6, 0), new ItemStack(VenusBlocks.VenusBasalt, 1, 0), new ItemStack(VenusBlocks.VenusBasalt, 1, 0), new ItemStack(VenusBlocks.VenusBasalt, 1, 0));
        
        
        // Compressor recipes
        
//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 2), "ingotSulfer", "ingotSulfer");
        
//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 1), new ItemStack(GCVenusItems.venusItemBasic, 1, 2), new ItemStack(GCVenusItems.venusItemBasic, 1, 2) );
//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 2), "ingotGem", "ingotGem");
        
        // Smelting
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusSulferOre.blockID, 0, new ItemStack(VenusItems.venusItemBasic, 1, 1), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusCoalOre.blockID, 0, new ItemStack(Item.coal), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusIronOre.blockID, 0, new ItemStack(Item.ingotIron), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusCopperOre.blockID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusTinOre.blockID, 0, OreDictionary.getOres("ingotTin").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusRedGemOre.blockID, 0, new ItemStack(VenusItems.venusItemBasic, 1, 3), 0.2F);
    
        // Schematic
        HashMap<Integer, ItemStack> input = new HashMap<Integer, ItemStack>();
        input.put(1, new ItemStack(GCCoreItems.partNoseCone));
        input.put(2, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(3, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(4, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(5, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(6, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(7, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(8, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(9, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(10, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(11, new ItemStack(VenusItems.venusItemBasic, 1, 3));
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
        SCVenusUtil.addRocketBenchT3Recipe(new ItemStack(VenusItems.spaceshipT3, 1, 0), input);

        HashMap<Integer, ItemStack> input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack(Block.chest));
        input2.put(20, null);
        input2.put(21, null);
        SCVenusUtil.addRocketBenchT3Recipe(new ItemStack(VenusItems.spaceshipT3, 1, 1), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, null);
        input2.put(20, new ItemStack(Block.chest));
        input2.put(21, null);
        SCVenusUtil.addRocketBenchT3Recipe(new ItemStack(VenusItems.spaceshipT3, 1, 1), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, null);
        input2.put(20, null);
        input2.put(21, new ItemStack(Block.chest));
        SCVenusUtil.addRocketBenchT3Recipe(new ItemStack(VenusItems.spaceshipT3, 1, 1), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack(Block.chest));
        input2.put(20, new ItemStack(Block.chest));
        input2.put(21, null);
        SCVenusUtil.addRocketBenchT3Recipe(new ItemStack(VenusItems.spaceshipT3, 1, 2), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack(Block.chest));
        input2.put(20, null);
        input2.put(21, new ItemStack(Block.chest));
        SCVenusUtil.addRocketBenchT3Recipe(new ItemStack(VenusItems.spaceshipT3, 1, 2), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, null);
        input2.put(20, new ItemStack(Block.chest));
        input2.put(21, new ItemStack(Block.chest));
        SCVenusUtil.addRocketBenchT3Recipe(new ItemStack(VenusItems.spaceshipT3, 1, 2), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack(Block.chest));
        input2.put(20, new ItemStack(Block.chest));
        input2.put(21, new ItemStack(Block.chest));
        SCVenusUtil.addRocketBenchT3Recipe(new ItemStack(VenusItems.spaceshipT3, 1, 3), input2);
        
        //
        
        input = new HashMap<Integer, ItemStack>();
        input.put(1, new ItemStack(GCCoreItems.partNoseCone));
        input.put(2, new ItemStack(GCCoreItems.basicItem, 1, 14));
        input.put(3, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(4, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(5, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(6, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(7, new ItemStack(VenusItems.venusItemBasic, 1, 3));
        input.put(8, new ItemStack(VenusItems.venusItemBasic, 1, 3));
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

    public static void loadRecipes()
    {
        SCVenusRecipeManager.addUniversalRecipes();
    }
}
