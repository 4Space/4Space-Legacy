package mattparks.mods.starcraft.spacecraftBlocks.block;

import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class StarcraftGasTop extends Block implements ITerraformableBlock
{
	public StarcraftGasTop(int id, Material material)
    {
    	super( id, material.rock);
    }

	@Override
	public boolean isTerraformable(World world, int x, int y, int z) {
		return false;
	}	
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
	
}
