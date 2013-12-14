package mattparks.mods.starcraft.core.blocks;

import java.util.Random;

import mattparks.mods.starcraft.core.StarcraftMercury;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MercuryStone extends Block
{
    public MercuryStone(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return StarcraftMercury.MercuryCobblestone.blockID;
    }
}
