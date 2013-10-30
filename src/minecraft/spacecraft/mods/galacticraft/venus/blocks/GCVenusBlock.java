package spacecraft.mods.galacticraft.venus.blocks;

import java.util.List;
import java.util.Random;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import spacecraft.mods.galacticraft.venus.GCVenus;
import spacecraft.mods.galacticraft.venus.items.GCVenusItems;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusBlock extends Block implements IDetectableResource, IPlantableBlock, ITileEntityProvider, ITerraformableBlock
{
    @SideOnly(Side.CLIENT)
    private Icon[] venus2BlockIcons;

    public GCVenusBlock(int i)
    {
        super(i, Material.rock);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        if (world.getBlockMetadata(x, y, z) == 10)
        {
            return null;
        }

        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        if (world.getBlockMetadata(x, y, z) == 10)
        {
            return AxisAlignedBB.getAABBPool().getAABB(x + 0.0D, y + 0.0D, z + 0.0D, x + 0.0D, y + 0.0D, z + 0.0D);
        }

        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }

    @Override
    public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
    {
        int metadata = world.getBlockMetadata(x, y, z);

        if (metadata == 10 || metadata == 7)
        {
            return 10000.0F;
        }

        return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.venus2BlockIcons = new Icon[11];
        this.venus2BlockIcons[0] = par1IconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + "copperOre");
        this.venus2BlockIcons[1] = par1IconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + "tinOre");
        this.venus2BlockIcons[2] = par1IconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + "ironOre");
        this.venus2BlockIcons[3] = par1IconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + "coalOre");
        this.venus2BlockIcons[4] = par1IconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + "meteorOre");
        this.venus2BlockIcons[5] = par1IconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + "gemOre");
        this.venus2BlockIcons[6] = par1IconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + "sulferOre");
        this.venus2BlockIcons[7] = par1IconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + "cobblestoneVenus");
        this.venus2BlockIcons[8] = par1IconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + "grassVenus");
        this.venus2BlockIcons[9] = par1IconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + "dirtVenus");
        this.venus2BlockIcons[10] = par1IconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + "stoneVenus");
    }

    @Override
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return SpacecraftCore.starcraftVenusTab;
    }

    @Override
    public float getBlockHardness(World par1World, int par2, int par3, int par4)
    {
        final int meta = par1World.getBlockMetadata(par2, par3, par4);

        if (meta == 10 || meta == 7)
        {
            return -1.0F;
        }

        return this.blockHardness;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        if (metadata == 10)
        {
//            return new GCVenus2TileEntityDungeonSpawner();
        }

        return null;
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return null;
    }

    @Override
    public boolean canHarvestBlock(EntityPlayer player, int meta)
    {
        if (meta == 10 || meta == 7)
        {
            return false;
        }

        return super.canHarvestBlock(player, meta);
    }

    @Override
    public Icon getIcon(int side, int meta)
    {
        switch (meta)
        {
        case 0:
            return this.venus2BlockIcons[0];
        case 1:
            return this.venus2BlockIcons[1];
        case 2:
            return this.venus2BlockIcons[2];
        case 3:
            return this.venus2BlockIcons[3];
        case 4:
            return this.venus2BlockIcons[4];
        case 5:
            return this.venus2BlockIcons[5];
        case 6:
            return this.venus2BlockIcons[6];
        case 7:
            return this.venus2BlockIcons[7];
        case 8:
            return this.venus2BlockIcons[8];
        case 9:
            return this.venus2BlockIcons[9];
        case 10:
            return this.venus2BlockIcons[10];
        }

        return this.venus2BlockIcons[1];
    }

    @Override
    public int idDropped(int meta, Random random, int par3)
    {
        if (meta == 2)
        {
            return GCVenusItems.venusItemBasic.itemID;
        }
        else if (meta == 10 || meta == 7)
        {
            return 0;
        }

        return this.blockID;
    }

    @Override
    public int damageDropped(int meta)
    {
        if (meta == 9)
        {
            return 4;
        }
        else if (meta == 2)
        {
            return 0;
        }
        else
        {
            return meta;
        }
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random)
    {
        if (meta == 10 || meta == 7)
        {
            return 0;
        }

        return 1;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        int var4;

        for (var4 = 0; var4 < 11; ++var4)
        {
            if (var4 != 10)
            {
                par3List.add(new ItemStack(par1, 1, var4));
            }
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
        case 3:
            return true;
        case 4:
            return true;
        case 5:
            return true;
        case 6:
            return true;
        case 7:
            return true;
        default:
            return false;
        }
    }

    @Override
    public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant)
    {
        return false;
    }

    @Override
    public int requiredLiquidBlocksNearby()
    {
        return 4;
    }

    @Override
    public boolean isPlantable(int metadata)
    {
        return false;
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        if (rand.nextInt(10) == 0)
        {
            int metadata = world.getBlockMetadata(x, y, z);

            if (metadata == 7)
            {
                GCVenus.proxy.spawnParticle("sludgeDrip", x + rand.nextDouble(), y, z + rand.nextDouble());

                if (rand.nextInt(100) == 0)
                {
                    world.playSound(x, y, z, "galacticraft.ambience.singledrip", 1, 0.8F + rand.nextFloat() / 5.0F, false);
                }
            }
        }
    }

    @Override
    public boolean isTerraformable(World world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z) == 5 && world.getBlockId(x, y + 1, z) == 0;
    }
}
