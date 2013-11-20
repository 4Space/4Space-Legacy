package mattparks.mods.starcraft.core.blocks;

import mattparks.mods.starcraft.core.StarcraftCore;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;

public class StarcraftMetallicHydrogenFlowing extends BlockFlowing
{
	public StarcraftMetallicHydrogenFlowing(int id, String name)
    {
        super(id, Material.lava);
        this.setUnlocalizedName(name);
        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }

	{
		this.blockHardness = 100.0F;
		this.setLightOpacity(1);
	}
}
