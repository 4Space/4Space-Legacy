package mattparks.mods.starcraft.makemake.items;

import mattparks.mods.starcraft.makemake.SCMakemakeConfigManager;
import net.minecraft.item.Item;

public class SCMakemakeItems
{
    public static Item jupiterItemBasic;

    public static void initItems()
    {
    	SCMakemakeItems.jupiterItemBasic = new SCMakemakeItem(SCMakemakeConfigManager.idItemMakemakeBasic).setUnlocalizedName("makemakeBasic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}