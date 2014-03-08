package mattparks.mods.starcraft.vesta.recipe;


public class SCVestaRecipeManager
{
    private static void addUniversalRecipes()
    {
//    	OreDictionary.registerOre("iridiumIngot", new ItemStack(MercuryItems.mercuryItemBasic, 1, 2));

        // GENERAL
//        RecipeUtil.addRecipe(new ItemStack(MercuryBlocks.caravanModule), new Object[] { "XYZ", "GJG", "GGG", 'X', Block.furnaceIdle, 'Y', Block.workbench , 'Z', Block.chest, 'G' , GCCoreItems.canvas, 'J' , new ItemStack(GCCoreItems.canister, 1, 0) });

        // Smelting
//        FurnaceRecipes.smelting().addSmelting(MercuryBlocks.MercuryCobblestone.blockID, 0, new ItemStack(MercuryBlocks.MercuryStone, 1, 0), 0.2F);
    }

   

    public static void loadRecipes()
    {
        SCVestaRecipeManager.addUniversalRecipes();
    }
}
