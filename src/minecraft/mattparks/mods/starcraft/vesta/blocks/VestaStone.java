package mattparks.mods.starcraft.vesta.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class VestaStone extends Block
{
    public VestaStone(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }
    
//    @Override
//	public int idDropped(int par1, Random par2Random, int par3)
    {
//        return StarcraftMercury.MercuryCobblestone.blockID;
    }
}
