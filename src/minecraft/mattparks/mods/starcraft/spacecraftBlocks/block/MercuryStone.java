package mattparks.mods.starcraft.spacecraftBlocks.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mattparks.mods.starcraft.spacecraftBlocks.SpacecraftBlocks;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class MercuryStone extends Block
{
    public MercuryStone(int id, Material material)
    {
    	super( id, material.rock);
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return SpacecraftBlocks.MercuryCobblestone.blockID;
    }
}
