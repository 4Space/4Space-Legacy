package mattparks.mods.starcraft.venus.items;

import java.util.List;

import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.venus.GCVenus;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusItem extends Item
{
    public static String[] names = { "ingotSulfer", "venusPlate", "sulferPlate", "venusPowerCrystal", "venusPowerCell", "emptyCell", "rawBasalt", "basaltBrick", "vurnBerry", "venusRod", "positiveParticle", "negativeParticle", "strangeParticle" };
    protected Icon[] icons = new Icon[GCVenusItem.names.length];

    public GCVenusItem(int par1)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return StarcraftCore.starcraftVenusTab;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return ClientProxyCore.galacticraftItem;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        int i = 0;

        for (String name : GCVenusItem.names)
        {
            this.icons[i++] = iconRegister.registerIcon(GCVenus.ASSET_PREFIX + name);
        }
    }

    @Override
    public Icon getIconFromDamage(int damage)
    {
        if (this.icons.length > damage)
        {
            return this.icons[damage];
        }

        return super.getIconFromDamage(damage);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < GCVenusItem.names.length; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        if (this.icons.length > par1ItemStack.getItemDamage())
        {
            return "item." + GCVenusItem.names[par1ItemStack.getItemDamage()];
        }

        return "unnamed";
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
	{
    	if(par1ItemStack.getItemDamage() == 3 || par1ItemStack.getItemDamage() == 4)
    	{
    		return true;
    	}
    	
    	return false;
	}
    
    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }
}
