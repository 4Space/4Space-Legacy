package spacecraft.mods.galacticraft.spacecraftBlocks.blocks.jupiter;

import java.util.Random;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class JupiterCobblestone extends Block
{
    public JupiterCobblestone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(SpacecraftCore.starcraftMercuryTab);
    }

}
