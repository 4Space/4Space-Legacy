package mattparks.mods.starcraft.spacecraftBlocks.block;

import java.util.Random;

import mattparks.mods.starcraft.spacecraftBlocks.SpacecraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class PlutoStone extends Block
{
    public PlutoStone(int id, Material material)
    {
    	super( id, material.rock);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return SpacecraftBlocks.PlutoCobblestone.blockID;
    }
}
