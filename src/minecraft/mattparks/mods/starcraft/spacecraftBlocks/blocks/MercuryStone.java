package mattparks.mods.starcraft.spacecraftBlocks.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.spacecraftBlocks.SpacecraftBlocks;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class MercuryStone extends Block
{
    public MercuryStone(int id, String name)
    {
        super(id, Material.rock);
        this.setUnlocalizedName(name);
        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return SpacecraftBlocks.MercuryCobblestone.blockID;
    }
}
