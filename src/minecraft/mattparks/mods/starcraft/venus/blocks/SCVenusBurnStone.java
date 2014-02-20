package mattparks.mods.starcraft.venus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SCVenusBurnStone extends Block
{
    public SCVenusBurnStone(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }
}
