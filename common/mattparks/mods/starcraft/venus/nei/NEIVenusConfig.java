package mattparks.mods.starcraft.venus.nei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import mattparks.mods.starcraft.venus.items.VenusItems;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIVenusConfig implements IConfigureNEI
{
    private static HashMap<ArrayList<PositionedStack>, PositionedStack> rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();

    public static Set<Entry<ArrayList<PositionedStack>, PositionedStack>> getRocketBenchRecipes()
    {
        return NEIVenusConfig.rocketBenchRecipes.entrySet();
    }

    @Override
    public String getName()
    {
        return "Starcraft Venus NEI Plugin";
    }

    @Override
    public String getVersion()
    {
        return GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION;
    }

    @Override
    public void loadConfig()
    {
        this.registerRecipes();
        API.registerRecipeHandler(new RocketT3RecipeHandler());
        API.registerUsageHandler(new RocketT3RecipeHandler());
    }

    public void registerRecipes()
    {
        final int changey = 15;

        ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

        input1.add(new PositionedStack(new ItemStack(GCCoreItems.partNoseCone), 45, -8 + changey));
        input1.add(new PositionedStack(new ItemStack(VenusItems.venusItemBasic, 1, 5), 36, -6 + 0 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(VenusItems.venusItemBasic, 1, 5), 36, -6 + 1 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(VenusItems.venusItemBasic, 1, 5), 36, -6 + 2 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(VenusItems.venusItemBasic, 1, 5), 36, -6 + 3 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(VenusItems.venusItemBasic, 1, 5), 36, -6 + 4 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(VenusItems.venusItemBasic, 1, 5), 54, -6 + 0 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(VenusItems.venusItemBasic, 1, 5), 54, -6 + 1 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(VenusItems.venusItemBasic, 1, 5), 54, -6 + 2 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(VenusItems.venusItemBasic, 1, 5), 54, -6 + 3 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(VenusItems.venusItemBasic, 1, 5), 54, -6 + 4 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.rocketEngine), 45, 100 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.rocketEngine, 1, 1), 18, 64 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.rocketEngine, 1, 1), 72, 64 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.partFins), 18, 82 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.partFins), 18, 100 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.partFins), 72, 82 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.partFins), 72, 100 + changey));
        this.registerRocketBenchRecipe(input1, new PositionedStack(new ItemStack(VenusItems.spaceshipT3, 1, 0), 139, 87 + changey));

        ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 0 * 26, -15 + changey));
        this.registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(VenusItems.spaceshipT3, 1, 1), 139, 87 + changey));

        input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 1 * 26, -15 + changey));
        this.registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(VenusItems.spaceshipT3, 1, 1), 139, 87 + changey));

        input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 2 * 26, -15 + changey));
        this.registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(VenusItems.spaceshipT3, 1, 1), 139, 87 + changey));

        input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 0 * 26, -15 + changey));
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 1 * 26, -15 + changey));
        this.registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(VenusItems.spaceshipT3, 1, 2), 139, 87 + changey));

        input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 1 * 26, -15 + changey));
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 2 * 26, -15 + changey));
        this.registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(VenusItems.spaceshipT3, 1, 2), 139, 87 + changey));

        input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 0 * 26, -15 + changey));
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 2 * 26, -15 + changey));
        this.registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(VenusItems.spaceshipT3, 1, 2), 139, 87 + changey));

        input2 = new ArrayList<PositionedStack>(input1);
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 0 * 26, -15 + changey));
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 1 * 26, -15 + changey));
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 2 * 26, -15 + changey));
        this.registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(VenusItems.spaceshipT3, 1, 3), 139, 87 + changey));
    }

    public void registerRocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output)
    {
        NEIVenusConfig.rocketBenchRecipes.put(input, output);
    }
}
