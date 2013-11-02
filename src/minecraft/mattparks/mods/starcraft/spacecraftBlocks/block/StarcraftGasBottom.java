package mattparks.mods.starcraft.spacecraftBlocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import mattparks.mods.starcraft.core.StarcraftCore;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;

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
