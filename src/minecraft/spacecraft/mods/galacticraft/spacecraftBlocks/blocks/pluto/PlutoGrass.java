package spacecraft.mods.galacticraft.spacecraftBlocks.blocks.pluto;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import spacecraft.mods.galacticraft.spacecraftBlocks.SpacecraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;

public class PlutoGrass extends Block implements IPlantableBlock, ITerraformableBlock
{
	public PlutoGrass(int id, Material material)
    {
    	super( id, material.grass);
        this.setCreativeTab(SpacecraftCore.starcraftPlutoTab);
    }
    public int damageDropped(int par1)
    {
        return this.blockID == SpacecraftBlocks.PlutoDirt.blockID ? 4 : 0;
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
    public boolean isTerraformable(World world, int x, int y, int z)//Makes The Block TransFormable
    {
        int meta = world.getBlockMetadata(x, y, z);
        
        if ((meta >= 5 && meta <= 13))
        {
            return world.getBlockId(x, y + 1, z) == 0;
        }
        
        return false;
    }
}
