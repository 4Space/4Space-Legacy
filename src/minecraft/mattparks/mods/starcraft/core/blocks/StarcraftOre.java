package mattparks.mods.starcraft.core.blocks;

import ic2.api.item.Items;

import java.util.Random;

import universalelectricity.compatibility.Compatibility;
import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.core.StarcraftCore;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class StarcraftOre extends Block implements IDetectableResource
{
    public StarcraftOre(int id, String name)
    {
        super(id, Material.rock);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
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
    
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	if(StarcraftCore.MercuryIridiumOre.blockID == this.blockID)
    	{
    		if(Compatibility.isIndustrialCraft2Loaded())
    		{
    			return Items.getItem("iridiumOre").itemID;
    		}
    		
    		return this.blockID;
    	}
    	
    	if(StarcraftCore.MercuryCoalOre.blockID == this.blockID || StarcraftCore.VenusCoalOre.blockID == this.blockID)
    	{
    		return Item.coal.itemID;
    	}
    	
        return this.blockID;
    }
}
