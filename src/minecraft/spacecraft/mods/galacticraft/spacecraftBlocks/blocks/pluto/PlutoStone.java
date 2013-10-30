package spacecraft.mods.galacticraft.spacecraftBlocks.blocks.pluto;

import java.util.Random;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import spacecraft.mods.galacticraft.spacecraftBlocks.SpacecraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PlutoStone extends Block
{
    public PlutoStone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(SpacecraftCore.starcraftPlutoTab);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return SpacecraftBlocks.PlutoCobblestone.blockID;
    }
}
