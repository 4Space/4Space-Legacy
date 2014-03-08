package mattparks.mods.starcraft.mercury.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCMercuryGravityGenerator extends Block
{

    @SideOnly(Side.CLIENT)
    private Icon field_94393_a;
    @SideOnly(Side.CLIENT)
    private Icon field_94392_b;

    public SCMercuryGravityGenerator(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }
    
    @Override
	public Icon getIcon(int par1, int par2)
    {
        return par1 == 0 ? this.field_94392_b : (par1 == 1 ? this.field_94393_a : this.blockIcon);
    }
    
    @Override
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(this.getTextureName() + "_side");
        this.field_94393_a = par1IconRegister.registerIcon(this.getTextureName() + "_top");
        this.field_94392_b = par1IconRegister.registerIcon(this.getTextureName() + "_bottom");
    }
}