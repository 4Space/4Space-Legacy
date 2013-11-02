package mattparks.mods.starcraft.spacecraftBlocks.block;

import java.util.Random;

import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.spacecraftBlocks.SpacecraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MercuryStone extends Block
{
    public MercuryStone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(StarcraftCore.starcraftMercuryTab);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return SpacecraftBlocks.MercuryCobblestone.blockID;
    }
}
