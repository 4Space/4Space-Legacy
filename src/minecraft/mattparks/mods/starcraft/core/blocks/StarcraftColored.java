package mattparks.mods.starcraft.core.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import mattparks.mods.starcraft.mercury.GCMercury;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class StarcraftColored extends Block
{
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    public StarcraftColored(int id, String name)
    {
        super(id, Material.glass);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(0.3F);
    }
    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return this.iconArray[par2 % this.iconArray.length];
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1;
    }

    /**
     * Takes a dye damage value and returns the block damage value to match
     */
    public static int getBlockFromDye(int par0)
    {
        return ~par0 & 15;
    }

    /**
     * Takes a block damage value and returns the dye damage value to match
     */
    public static int getDyeFromBlock(int par0)
    {
        return ~par0 & 15;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int j = 0; j < 16; ++j)
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
        this.iconArray = new Icon[16];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(this.getTextureName() + "_" + ItemDye.dyeItemNames[getDyeFromBlock(i)]);
        }
    }
}
