package mattparks.mods.starcraft.core.blocks;

import mattparks.mods.starcraft.core.StarcraftMercury;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StarcraftBlock extends Block
{
    public StarcraftBlock(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }

    @Override
    public int getMobilityFlag()
    {
    	if(this.blockID == StarcraftMercury.caravanModulePart.blockID)
    	{
    		return 2;
    	}
    	
        return 0;
    }

}
