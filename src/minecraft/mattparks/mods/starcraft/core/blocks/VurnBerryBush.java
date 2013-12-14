package mattparks.mods.starcraft.core.blocks;

import mattparks.mods.starcraft.venus.items.GCVenusItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class VurnBerryBush extends BlockCrops
{
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    public VurnBerryBush(int par1)
    {
        super(par1);
    }

    /**
     * Generate a crop produce ItemStack for this crop.
     */
    @Override
	protected int getCropItem()
    {
      return GCVenusItems.vurnBerry.itemID;
    }

    @Override
	@SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        if (par2 < 7)
        {
            if (par2 == 6)
            {
                par2 = 5;
            }

            return this.iconArray[par2 >> 1];
        }
        else
        {
            return this.iconArray[3];
        }
    }

    /**
     * Generate a seed ItemStack for this crop.
     */
    @Override
	protected int getSeedItem()
    {
        return GCVenusItems.vurnBerry.itemID;
    }

    @Override
	@SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[4];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(this.getTextureName() + "_stage_" + i);
        }
    }
}
