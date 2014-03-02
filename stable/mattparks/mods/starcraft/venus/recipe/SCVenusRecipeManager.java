package mattparks.mods.starcraft.venus.recipe;

import java.util.HashMap;

import mattparks.mods.starcraft.venus.blocks.VenusBlocks;
import mattparks.mods.starcraft.venus.items.VenusItems;
import mattparks.mods.starcraft.venus.util.SCVenusUtil;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.core.blocks.GCCoreBlocks;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import micdoodle8.mods.galacticraft.moon.items.GCMoonItem;
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
    	// ORE DICTIONARY
    	OreDictionary.registerOre("ingotSulfer", new ItemStack(VenusItems.venusItemBasic, 1, 0));
    	OreDictionary.registerOre("sulferDust", new ItemStack(VenusItems.venusItemBasic, 1, 1));
    	OreDictionary.registerOre("redGem", new ItemStack(VenusItems.venusItemBasic, 1, 3));
    	OreDictionary.registerOre("venusRodDust", new ItemStack(VenusItems.venusItemBasic, 1, 7));
    	OreDictionary.registerOre("sulferPlate", new ItemStack(VenusItems.venusItemBasic, 1, 2));
    	OreDictionary.registerOre("redGemPlate", new ItemStack(VenusItems.venusItemBasic, 1, 4));
    	OreDictionary.registerOre("venusRod", new ItemStack(VenusItems.venusItemBasic, 1, 6));
    	OreDictionary.registerOre("rawBasalt", new ItemStack(VenusItems.venusItemBasic, 1, 8));
    	OreDictionary.registerOre("VenusCrystal", new ItemStack(VenusItems.venusItemBasic, 1, 11));
    	OreDictionary.registerOre("FossilizedPlant", new ItemStack(VenusItems.venusItemBasic, 1, 12));
    	
    	OreDictionary.registerOre("vurnBerry", new ItemStack(VenusItems.vurnBerry, 1, 1));
    	OreDictionary.registerOre("meteoricIronIngot", new ItemStack(GCCoreItems.meteoricIronIngot, 1, 0));
    	OreDictionary.registerOre("basaltBrick", new ItemStack(VenusItems.venusItemBasic, 1, 9));
    	OreDictionary.registerOre("meteorBlock", new ItemStack(VenusBlocks.VenusMeteorBlock));
    	OreDictionary.registerOre("crystalBlock", new ItemStack(VenusBlocks.CrystalBlock));
    	OreDictionary.registerOre("halfBasalt", new ItemStack(VenusBlocks.VenusHalfBasalt));
    	OreDictionary.registerOre("venusStone", new ItemStack(VenusBlocks.VenusStone));

    	// ARMOR AND TOOLS CRAFTING
    	RecipeUtil.addRecipe(new ItemStack(VenusItems.jetpack), new Object[] {  "GRG", "C C", 'R', Item.redstone, 'G', "redGem", 'C', Item.coal });
    	
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemBoots), new Object[] {  "X X", "X X", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemHelmet), new Object[] { "XXX", "X X", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemLeggings), new Object[] { "XXX", "X X", "X X", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemSword), new Object[] { "X", "X", "Y", 'X', "redGem", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "redGem", 'Y',Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemSpade), new Object[] { "X", "Y", "Y", 'X', "redGem", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemHoe), new Object[] { "XX", " Y", " Y", 'X', "redGem", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemAxe), new Object[] { "XX", "XY", " Y", 'X', "redGem", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferHelmet), new Object[] { "XXX", "X X", 'X', "ingotSulfer" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "ingotSulfer" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferLeggings), new Object[] { "XXX", "X X", "X X", 'X', "ingotSulfer" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferBoots), new Object[] {  "X X", "X X", 'X', "ingotSulfer" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferSword), new Object[] { "X", "X", "Y", 'X', "ingotSulfer", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "ingotSulfer", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferSpade), new Object[] { "X", "Y", "Y", 'X', "ingotSulfer", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferHoe), new Object[] { "XX", " Y", " Y", 'X', "ingotSulfer", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferAxe), new Object[] { "XX", "XY", " Y", 'X', "ingotSulfer", 'Y', Item.stick });
       
        // PLATE CRAFTING
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 2), new Object[] { "XX", "XY", 'X', "ingotSulfer", 'Y', "venusRodDust" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 4), new Object[] { "XX", "XY", 'X', "redGem", 'Y', "venusRodDust" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 5), new Object[] { "XYX", 'X', "sulferPlate", 'Y', "redGemPlate" });
        
        // OTHERS CRAFTING
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 0), new Object[] { "XX", 'X', "sulferDust" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 4, 7), new Object[] { "X", 'X', "venusRod" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 9), new Object[] { "XX", 'X', "rawBasalt" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 10), new Object[] { "Y Y", " X ", "Y Y", 'X', "VenusCrystal", 'Y', "venusRodDust" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.vurnBerry), new Object[] { "Y Y", " X ", "Y Y", 'X', "FossilizedPlant", 'Y', Item.bone });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.VurnBerryOnAStick), new Object[] { "  X", " Y ", "Y  ", 'X', "vurnBerry", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBattery, 1, 100), new Object[] { "TRT", "CVC", "TRT", 'T', "sulferPlate", 'R', Item.redstone, 'C', Item.coal, 'V', "VenusCrystal" });
        
        // ITEM TO BLOCK
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusRedGemBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusMeteorBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "meteoricIronIngot" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusSulferBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotSulfer" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.CrystalBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "VenusCrystal" });
        
        // BLOCK TO ITEM
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 9, 0), new Object[] { "X", 'X', VenusBlocks.VenusSulferBlock });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 9, 3), new Object[] { "X", 'X', VenusBlocks.VenusRedGemBlock });
        RecipeUtil.addRecipe(new ItemStack(GCCoreItems.meteoricIronIngot, 9, 0), new Object[] { "X", 'X', VenusBlocks.VenusMeteorBlock });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 9, 11), new Object[] { "X", 'X', VenusBlocks.CrystalBlock });
        
        // UNREVERSABLE BLOCK CRAFTING
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusianTNT, 1, 1), new Object[] { "Y Y", " X ", "Y Y", 'X', Block.tnt, 'Y', "sulferDust" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusBurnStone, 1, 1), new Object[] { "Y Y", " X ", "Y Y", 'X', "venusStone", 'Y', "venusRodDust" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusHalfBasalt, 1, 1), new Object[] { "XX", "XX", 'X', "basaltBrick" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusBasalt, 1, 1), new Object[] { "X", "X", 'X', "halfBasalt" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusDecorationBlock, 1, 1), new Object[] { "X X", " Y ", "X X", 'X', "ingotSulfer", 'Y', "redGem" });

        // Smelting
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusSulferOre.blockID, 0, new ItemStack(VenusItems.venusItemBasic, 1, 1), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusCoalOre.blockID, 0, new ItemStack(Item.coal), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusIronOre.blockID, 0, new ItemStack(Item.ingotIron), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusCopperOre.blockID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusTinOre.blockID, 0, OreDictionary.getOres("ingotTin").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusRedGemOre.blockID, 0, new ItemStack(VenusItems.venusItemBasic, 1, 3), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusCrystalOre.blockID, 0, new ItemStack(VenusItems.venusItemBasic, 1, 11), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusCobblestone.blockID, 0, new ItemStack(VenusBlocks.VenusStone), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusMeteorOre.blockID, 0, new ItemStack(GCCoreItems.meteoricIronRaw), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.FossilizedPlantOre.blockID, 0, new ItemStack(VenusItems.venusItemBasic, 1, 12), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.BasaltOre.blockID, 0, new ItemStack(VenusItems.venusItemBasic, 1, 8), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusGlowstoneOre.blockID, 0, new ItemStack(Item.glowstone, 8, 1), 0.2F);
        
        // Schematic
        HashMap<Integer, ItemStack> input = new HashMap<Integer, ItemStack>();
        input.put(1, new ItemStack(GCCoreItems.partNoseCone));
        input.put(2, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(3, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(4, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(5, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(6, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(7, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(8, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(9, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(10, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(11, new ItemStack(VenusItems.venusItemBasic, 1, 5));
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
        input.put(3, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(4, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(5, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(6, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(7, new ItemStack(VenusItems.venusItemBasic, 1, 5));
        input.put(8, new ItemStack(VenusItems.venusItemBasic, 1, 5));
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
