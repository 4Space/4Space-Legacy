package mattparks.mods.starcraft.core.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StarcraftGlowstone extends Block
{
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    public StarcraftGlowstone(int par1, String name)
    {
        super(par1, Material.glass);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < this.iconArray.length; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[16];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(this.getTextureName() + "_" + ItemDye.dyeItemNames[BlockColored.getDyeFromBlock(i)]);
        }
        this.blockIcon = this.iconArray[0];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        return this.iconArray[par2 % this.iconArray.length];
    }

    public Icon getSideTextureIndex(int metadata)
    {
        return this.iconArray[metadata % this.iconArray.length];
    }
}
