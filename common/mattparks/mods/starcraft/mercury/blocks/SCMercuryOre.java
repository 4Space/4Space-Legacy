package mattparks.mods.starcraft.mercury.blocks;

import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCMercuryOre extends Block implements IDetectableResource
{
    public SCMercuryOre(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftMercury.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }

    @Override
    public boolean isValueable(int metadata)
    {
        switch (metadata)
        {
        default:
            return true;
        }
    }
}
