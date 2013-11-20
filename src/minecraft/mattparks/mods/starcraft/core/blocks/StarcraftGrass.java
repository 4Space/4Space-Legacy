package mattparks.mods.starcraft.core.blocks;

import mattparks.mods.starcraft.core.StarcraftCore;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StarcraftGrass extends Block implements ITerraformableBlock
{
    public StarcraftGrass(int id, String name)
    {
        super(id, Material.rock);
        this.setUnlocalizedName(name);
        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public CreativeTabs getCreativeTabToDisplayOn()
//    {
//        return StarcraftCore.starcraftCoreTab;
//    }
    
	@Override
	public boolean isTerraformable(World world, int x, int y, int z) {
		return true;
	}	
}
