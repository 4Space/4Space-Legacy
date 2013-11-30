package mattparks.mods.starcraft.core.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class MultiBlock extends Block
{
    public static final String[] STONE_BRICK_TYPES = new String[] {"grass", "dirt", "stone", "brick"};
    public static final String[] field_94407_b = new String[] {null, "grass", "dirt", "stone", "brick"};
    @SideOnly(Side.CLIENT)
    private Icon[] field_94408_c;

    public MultiBlock(int par1)
    {
        super(par1, Material.rock);
//        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 >= field_94407_b.length)
        {
            par2 = 0;
        }

        return this.field_94408_c[par2];
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int j = 0; j < 4; ++j)
        {
            par3List.add(new ItemStack(par1, 1, j));
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94408_c = new Icon[field_94407_b.length];

        for (int i = 0; i < this.field_94408_c.length; ++i)
        {
            String s = this.getTextureName();

            if (field_94407_b[i] != null)
            {
                s = s + "_" + field_94407_b[i];
            }

            this.field_94408_c[i] = par1IconRegister.registerIcon(s);
        }
    }
}
