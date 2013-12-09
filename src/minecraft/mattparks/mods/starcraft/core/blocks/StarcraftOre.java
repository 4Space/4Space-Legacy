package mattparks.mods.starcraft.core.blocks;

import ic2.api.item.Items;

import java.util.Random;

import universalelectricity.compatibility.Compatibility;
import mattparks.mods.starcraft.core.StarcraftMercury;
import mattparks.mods.starcraft.core.StarcraftVenus;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class StarcraftOre extends Block implements IDetectableResource
{
    public StarcraftOre(int par1, String name)
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
    
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	if(StarcraftMercury.MercuryIridiumOre.blockID == this.blockID)
    	{
    		if(Compatibility.isIndustrialCraft2Loaded())
    		{
    			return Items.getItem("iridiumOre").itemID;
    		}
    		
    		return this.blockID;
    	}
    	
    	if(StarcraftMercury.MercuryCoalOre.blockID == this.blockID || StarcraftVenus.VenusCoalOre.blockID == this.blockID)
    	{
    		return Item.coal.itemID;
    	}
    	
        return this.blockID;
    }
}
