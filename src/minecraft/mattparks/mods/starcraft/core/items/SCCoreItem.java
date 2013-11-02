package mattparks.mods.starcraft.core.items;

import java.util.List;

import mattparks.mods.starcraft.core.StarcraftCore;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCCoreItem extends Item
{
    public static String[] names = { "ingotGem", "itemGem", "redGemPlate", "pressureRegulator", "heatRegulator", "jetpackFuel" };
    protected Icon[] icons = new Icon[SCCoreItem.names.length];

    public SCCoreItem(int par1)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return StarcraftCore.starcraftCoreTab;
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

        for (String name : SCCoreItem.names)
        {
            this.icons[i++] = iconRegister.registerIcon(StarcraftCore.ASSET_PREFIX + name);
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
        for (int i = 0; i < SCCoreItem.names.length; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        if (this.icons.length > par1ItemStack.getItemDamage())
        {
            return "item." + SCCoreItem.names[par1ItemStack.getItemDamage()];
        }

        return "unnamed";
    }

    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        if (par2EntityPlayer.worldObj.isRemote)
        {
            switch (par1ItemStack.getItemDamage())
            {
            case 3:
                par3List.add(LanguageRegistry.instance().getStringLocalization("item.pressureRegulator.desc"));
                break;
            case 4:
                par3List.add(LanguageRegistry.instance().getStringLocalization("item.heatRegulator.desc"));
                break;
            }
        }
    }
}
