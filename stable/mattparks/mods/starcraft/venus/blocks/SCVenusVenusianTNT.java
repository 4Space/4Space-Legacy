package mattparks.mods.starcraft.venus.blocks;

import java.util.Random;

import mattparks.mods.starcraft.venus.entity.item.SCVenusEntityVenusianTNTPrimed;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCVenusVenusianTNT extends Block
{
    @SideOnly(Side.CLIENT)
    private Icon field_94393_a;
    @SideOnly(Side.CLIENT)
    private Icon field_94392_b;

    public SCVenusVenusianTNT(int par1, String name)
    {
        super(par1, Material.tnt);
        this.setUnlocalizedName(name);
        this.setHardness(2.0F);
    }

    @Override
	public boolean canDropFromExplosion(Explosion par1Explosion)
    {
        return false;
    }

    @Override
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 0 ? this.field_94392_b : (par1 == 1 ? this.field_94393_a : this.blockIcon);
    }

    @Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.getCurrentEquippedItem().itemID == Item.flintAndSteel.itemID)
        {
            this.primeTnt(par1World, par2, par3, par4, 1, par5EntityPlayer);
            par1World.setBlockToAir(par2, par3, par4);
            par5EntityPlayer.getCurrentEquippedItem().damageItem(1, par5EntityPlayer);
            return true;
        }
        else
        {
            return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
        }
    }

    @Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);

        if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
        {
            this.onBlockDestroyedByPlayer(par1World, par2, par3, par4, 1);
            par1World.setBlockToAir(par2, par3, par4);
        }
    }

    @Override
	public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion)
    {
        if (!par1World.isRemote)
        {
            SCVenusEntityVenusianTNTPrimed GCVenusEntityVenusianTNTPrimed = new SCVenusEntityVenusianTNTPrimed(par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, par5Explosion.getExplosivePlacedBy());
            GCVenusEntityVenusianTNTPrimed.fuse = par1World.rand.nextInt(GCVenusEntityVenusianTNTPrimed.fuse / 4) + GCVenusEntityVenusianTNTPrimed.fuse / 8;
            par1World.spawnEntityInWorld(GCVenusEntityVenusianTNTPrimed);
        }
    }

    @Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
        this.primeTnt(par1World, par2, par3, par4, par5, (EntityLivingBase)null);
    }

    @Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        if (par5Entity instanceof EntityArrow && !par1World.isRemote)
        {
            EntityArrow entityarrow = (EntityArrow)par5Entity;

            if (entityarrow.isBurning())
            {
                this.primeTnt(par1World, par2, par3, par4, 1, entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)entityarrow.shootingEntity : null);
                par1World.setBlockToAir(par2, par3, par4);
            }
        }
    }

    @Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
        {
            this.onBlockDestroyedByPlayer(par1World, par2, par3, par4, 1);
            par1World.setBlockToAir(par2, par3, par4);
        }
    }

    public void primeTnt(World par1World, int par2, int par3, int par4, int par5, EntityLivingBase par6EntityLivingBase)
    {
        if (!par1World.isRemote)
        {
            if ((par5 & 1) == 1)
            {
                SCVenusEntityVenusianTNTPrimed GCVenusEntityVenusianTNTPrimed = new SCVenusEntityVenusianTNTPrimed(par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, par6EntityLivingBase);
                par1World.spawnEntityInWorld(GCVenusEntityVenusianTNTPrimed);
                par1World.playSoundAtEntity(GCVenusEntityVenusianTNTPrimed, "random.fuse", 1.0F, 1.0F);
            }
        }
    }

    @Override
	public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    @Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(this.getTextureName() + "_side");
        this.field_94393_a = par1IconRegister.registerIcon(this.getTextureName() + "_top");
        this.field_94392_b = par1IconRegister.registerIcon(this.getTextureName() + "_bottom");
    }
}
