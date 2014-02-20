package mattparks.mods.starcraft.jupiter.blocks;

import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class SCGasTop extends Block implements ITerraformableBlock
{
	public SCGasTop(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftBlocks.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
	
	@Override
	public void initializeBlock()
    {
		Block.setBurnProperties(JupiterBlocks.JupiterNitrogen.blockID, 5, 5);
		Block.setBurnProperties(JupiterBlocks.NeptuneNitrogen.blockID, 5, 5);
		Block.setBurnProperties(JupiterBlocks.UranusNitrogen.blockID, 5, 5);
    }	
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
	public boolean isTerraformable(World world, int x, int y, int z) {
		return true;
	}

    @Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
}
