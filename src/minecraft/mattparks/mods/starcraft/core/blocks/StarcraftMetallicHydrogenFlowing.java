package mattparks.mods.starcraft.core.blocks;

import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;

public class StarcraftMetallicHydrogenFlowing extends BlockFlowing
{
	{
		this.blockHardness = 100.0F;
		this.setLightOpacity(1);
	}

	public StarcraftMetallicHydrogenFlowing(int par1, String name)
    {
        super(par1, Material.lava);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }
}
