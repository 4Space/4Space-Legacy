package spacecraft.mods.galacticraft.spacecraftBlocks.blocks.venus;

import java.util.Random;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class VenusCobblestone extends Block
{
    public VenusCobblestone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(SpacecraftCore.starcraftVenusTab);
    }

}
