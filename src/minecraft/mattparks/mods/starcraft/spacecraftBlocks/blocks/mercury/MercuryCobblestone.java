package mattparks.mods.starcraft.spacecraftBlocks.blocks.mercury;

import java.util.Random;

import mattparks.mods.starcraft.core.StarcraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MercuryCobblestone extends Block
{
    public MercuryCobblestone(int id, Material material)
    {
    	super( id, material.rock);
        this.setCreativeTab(StarcraftCore.starcraftMercuryTab);
    }

}
