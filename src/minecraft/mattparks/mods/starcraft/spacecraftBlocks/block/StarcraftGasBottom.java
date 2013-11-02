package mattparks.mods.starcraft.spacecraftBlocks.block;

import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class StarcraftGasBottom extends Block implements ITerraformableBlock
{
	public StarcraftGasBottom(int id, Material material)
    {
    	super( id, material.rock);
    }

	@Override
	public boolean isTerraformable(World world, int x, int y, int z) {
		return false;
	}	
	
}
