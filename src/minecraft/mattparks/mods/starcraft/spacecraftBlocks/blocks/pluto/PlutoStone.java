package mattparks.mods.starcraft.spacecraftBlocks.blocks.pluto;

import java.util.Random;

import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.spacecraftBlocks.SpacecraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PlutoStone extends Block
{
    public PlutoStone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(StarcraftCore.starcraftPlutoTab);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return SpacecraftBlocks.PlutoCobblestone.blockID;
    }
}
