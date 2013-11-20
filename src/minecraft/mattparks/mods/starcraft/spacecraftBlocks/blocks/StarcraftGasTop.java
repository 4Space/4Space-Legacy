package mattparks.mods.starcraft.spacecraftBlocks.blocks;

import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.spacecraftBlocks.SpacecraftBlocks;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class StarcraftGasTop extends Block implements ITerraformableBlock
{
	public StarcraftGasTop(int id, String name)
    {
        super(id, Material.rock);
        this.setUnlocalizedName(name);
        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }

	@Override
	public void initializeBlock()
    {
		this.setBurnProperties(SpacecraftBlocks.JupiterNitrogen.blockID, 5, 5);
		this.setBurnProperties(SpacecraftBlocks.NeptuneNitrogen.blockID, 5, 5);
		this.setBurnProperties(SpacecraftBlocks.UranusNitrogen.blockID, 5, 5);
    }
	
	@Override
	public boolean isTerraformable(World world, int x, int y, int z) {
		return true;
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
