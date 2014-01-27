package mattparks.mods.starcraft.makemake.items;

import mattparks.mods.starcraft.makemake.GCMakemakeConfigManager;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;

public class GCMakemakeItems
{
    public static Item jupiterItemBasic;

    public static void initItems()
    {
    	GCMakemakeItems.jupiterItemBasic = new GCMakemakeItem(GCMakemakeConfigManager.idItemMakemakeBasic).setUnlocalizedName("makemakeBasic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}