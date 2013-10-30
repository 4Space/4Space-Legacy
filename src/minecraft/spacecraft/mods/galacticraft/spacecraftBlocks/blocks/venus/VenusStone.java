package spacecraft.mods.galacticraft.spacecraftBlocks.blocks.venus;

import java.util.Random;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import spacecraft.mods.galacticraft.spacecraftBlocks.SpacecraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class VenusStone extends Block
{
    public VenusStone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(SpacecraftCore.starcraftVenusTab);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return SpacecraftBlocks.VenusCobblestone.blockID;
    }
}
