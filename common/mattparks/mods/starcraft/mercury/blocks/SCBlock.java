package mattparks.mods.starcraft.mercury.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCBlock extends Block
{
    public SCBlock(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }

    @Override
    public int getMobilityFlag()
    {
    	if(this.blockID == MercuryBlocks.caravanModulePart.blockID)
    	{
    		return 2;
    	}
    	
        return 0;
    }

}
