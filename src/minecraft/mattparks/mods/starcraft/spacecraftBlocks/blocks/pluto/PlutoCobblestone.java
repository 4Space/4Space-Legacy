package mattparks.mods.starcraft.spacecraftBlocks.blocks.pluto;

import java.util.Random;

import mattparks.mods.starcraft.core.StarcraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PlutoCobblestone extends Block
{
    public PlutoCobblestone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(StarcraftCore.starcraftPlutoTab);
    }

}
