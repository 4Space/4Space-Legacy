package spacecraft.mods.galacticraft.spacecraftBlocks.blocks.mercury;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;

public class MercuryDirt extends Block implements IPlantableBlock, ITerraformableBlock
{
	public MercuryDirt(int id, Material material)
    {
    	super( id, material.grass);
		this.setCreativeTab(SpacecraftCore.starcraftMercuryTab);
	}
    @Override
    public int requiredLiquidBlocksNearby()
    {
        return 5;
    }
    
    @Override
    public boolean isPlantable(int metadata)
    {
        if (metadata >= 5 && metadata <= 13)
        {
            return true;
        }

        return false;
    }
    
    @Override
    public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant)
    {
        return true;
    }

    @Override
    public boolean isTerraformable(World world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        
        if ((meta >= 5 && meta <= 13))
        {
            return world.getBlockId(x, y + 1, z) == 0;
        }
        
        return false;
    }
}
