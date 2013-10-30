package spacecraft.mods.galacticraft.spacecraftBlocks.blocks.mercury;

import java.util.Random;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MercuryBlock extends Block
{
    public MercuryBlock(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(SpacecraftCore.starcraftMercuryTab);
    }

}
