package mattparks.mods.starcraft.mercury.recipe;

import mattparks.mods.starcraft.core.items.SCCoreItems;
import mattparks.mods.starcraft.spacecraftBlocks.SpacecraftBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class GCMercuryRecipeManager
{
    public static void loadRecipes()
    {
        GCMercuryRecipeManager.addUniversalRecipes();
    }

    private static void addUniversalRecipes()
    {        
        // Smelting
       
        FurnaceRecipes.smelting().addSmelting(SpacecraftBlocks.MercuryCoalOre.blockID, 0, new ItemStack(Item.coal), 0.2F);
        FurnaceRecipes.smelting().addSmelting(SpacecraftBlocks.MercuryCopperOre.blockID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(SpacecraftBlocks.MercuryTinOre.blockID, 0, OreDictionary.getOres("ingotTin").get(0), 0.2F);
    }
}
