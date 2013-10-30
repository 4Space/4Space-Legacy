package spacecraft.mods.galacticraft.spacecraftBlocks.blocks.mercury;

import java.util.Random;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import spacecraft.mods.galacticraft.spacecraftBlocks.SpacecraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MercuryStone extends Block
{
    public MercuryStone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(SpacecraftCore.starcraftMercuryTab);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return SpacecraftBlocks.MercuryCobblestone.blockID;
    }
}
