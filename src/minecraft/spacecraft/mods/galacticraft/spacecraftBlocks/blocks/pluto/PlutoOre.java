package spacecraft.mods.galacticraft.spacecraftBlocks.blocks.pluto;

import java.util.Random;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class PlutoOre extends Block implements IDetectableResource, IPlantableBlock
{
    public PlutoOre(int id, Material material)
    {
            super( id, material.rock);
        this.setCreativeTab(SpacecraftCore.starcraftPlutoTab);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == Block.oreCoal.blockID ? Item.coal.itemID : (this.blockID == Block.oreDiamond.blockID ? Item.diamond.itemID : (this.blockID == Block.oreLapis.blockID ? Item.dyePowder.itemID : (this.blockID == Block.oreEmerald.blockID ? Item.emerald.itemID : (this.blockID == Block.oreNetherQuartz.blockID ? Item.netherQuartz.itemID : this.blockID))));
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return this.blockID == Block.oreLapis.blockID ? 4 + par1Random.nextInt(5) : 1;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        if (par1 > 0 && this.blockID != this.idDropped(0, par2Random, par1))
        {
            int j = par2Random.nextInt(par1 + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(par2Random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(par2Random);
        }
    }
    @Override
    public boolean isValueable(int metadata)
    {
        switch (metadata)
        {
        case 0:
            return true;
        case 1:
            return true;
        case 2:
            return true;
        default:
            return false;
        }
    }
    
    @Override
    public int requiredLiquidBlocksNearby()
    {
        return 5; //Set How LiquidBlocks Is Needed Nearby To Plant in.
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
    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
            int j1 = 0;

            if (this.blockID == Block.oreCoal.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 0, 2);
            }
            else if (this.blockID == Block.oreDiamond.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
            else if (this.blockID == Block.oreEmerald.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
            else if (this.blockID == Block.oreLapis.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }
            else if (this.blockID == Block.oreNetherQuartz.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }

            this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
        }
    }
}
