package mattparks.mods.starcraft.spacecraftBlocks.block;

import java.util.Random;

import mattparks.mods.starcraft.core.StarcraftCore;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class StarcraftOre extends Block implements IDetectableResource, IPlantableBlock
{
    public StarcraftOre(int id, Material material)
    {
            super( id, material.rock);
//        this.setCreativeTab(StarcraftCore.starcraftVenusTab);
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
            return true;
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
}
