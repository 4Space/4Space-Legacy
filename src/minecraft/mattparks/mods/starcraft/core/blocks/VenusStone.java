package mattparks.mods.starcraft.core.blocks;

import java.util.Random;

import mattparks.mods.starcraft.core.StarcraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class VenusStone extends Block
{
    public VenusStone(int id, String name)
    {
        super(id, Material.rock);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return StarcraftBlocks.VenusCobblestone.blockID;
    }
}
