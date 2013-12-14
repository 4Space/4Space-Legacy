package mattparks.mods.starcraft.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BurnStone extends Block
{
    public BurnStone(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }
}
