package spacecraft.mods.galacticraft.venus.items;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import spacecraft.mods.galacticraft.venus.GCVenus;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusItemBlock extends ItemBlock
{
    public GCVenusItemBlock(int i)
    {
        super(i);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return ClientProxyCore.galacticraftItem;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        String name = "";

        switch (itemstack.getItemDamage())
        {
        case 0:
        {
            name = "copperOreVenus";
            break;
        }
        case 1:
        {
            name = "tinOreVenus";
            break;
        }
        case 2:
        {
            name = "ironOreVenus";
            break;
        }
        case 3:
        {
            name = "coalOreVenus";
            break;
        }
        case 4:
        {
            name = "meteorOreVenus";
            break;
        }
        case 5:
        {
            name = "gemOre";
            break;
        }
        case 6:
        {
            name = "sulferOre";
            break;
        }
        case 7:
        {
            name = "cobblestoneVenus";
            break;
        }
        case 8:
        {
            name = "grassVenus";
            break;
        }
        case 9:
        {
            name = "dirtVenus";
            break;
        }
        case 10:
        {
            name = "stoneVenus";
            break;
        }
        default:
            name = "null";
        }

        return Block.blocksList[this.getBlockID()].getUnlocalizedName() + "." + name;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return SpacecraftCore.starcraftVenusTab;
    }

    @Override
    public String getUnlocalizedName()
    {
        return Block.blocksList[this.getBlockID()].getUnlocalizedName() + ".0";
    }
}
