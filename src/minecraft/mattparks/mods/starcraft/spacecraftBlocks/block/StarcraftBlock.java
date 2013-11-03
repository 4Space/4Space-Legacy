package mattparks.mods.starcraft.spacecraftBlocks.block;

import mattparks.mods.starcraft.core.StarcraftCore;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StarcraftBlock extends Block
{
    public StarcraftBlock(int id, String name)
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
}
