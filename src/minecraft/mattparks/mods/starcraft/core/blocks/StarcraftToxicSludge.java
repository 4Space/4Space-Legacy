package mattparks.mods.starcraft.core.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.venus.entities.GCVenusEntityFlameling;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class StarcraftToxicSludge extends BlockFlowing
{
    @SideOnly(Side.CLIENT)
    Icon stillIcon;
    @SideOnly(Side.CLIENT)
    Icon flowingIcon;
    
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if (!world.isRemote)
        {
            if (entity instanceof EntityPlayer && ((EntityPlayer) entity).capabilities.isFlying || entity instanceof GCVenusEntityFlameling)
            {
                return;
            }

            int range = 5;
            List<?> l = world.getEntitiesWithinAABB(GCVenusEntityFlameling.class, AxisAlignedBB.getBoundingBox(x - range, y - range, z - range, x + range, y + range, z + range));

            if (l.size() < 3)
            {
                GCVenusEntityFlameling sludgeling = new GCVenusEntityFlameling(world);
                sludgeling.setPosition(x + world.rand.nextInt(5) - 2, y, z + world.rand.nextInt(5) - 2);
                world.spawnEntityInWorld(sludgeling);
            }
        }

        super.onEntityCollidedWithBlock(world, x, y, z, entity);
    }
	
	public StarcraftToxicSludge(int id, String name)
    {
        super(id, Material.water);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }

//	{
//		this.blockHardness = 100.0F;
//		this.setLightOpacity(1);
//	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 0 ? this.stillIcon : this.flowingIcon;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        super.randomDisplayTick(world, x, y, z, rand);

        if (rand.nextInt(1200) == 0)
        {
            world.playSound(x + 0.5F, y + 0.5F, z + 0.5F, "liquid.lava", rand.nextFloat() * 0.25F + 0.75F, 0.00001F + rand.nextFloat() * 0.5F, false);
        }
    }
}
