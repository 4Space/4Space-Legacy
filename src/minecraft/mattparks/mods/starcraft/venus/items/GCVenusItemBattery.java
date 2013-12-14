package mattparks.mods.starcraft.venus.items;

import mattparks.mods.starcraft.venus.GCVenus;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import universalelectricity.core.item.ItemElectric;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusItemBattery extends ItemElectric
{
    public GCVenusItemBattery(int id, String assetName)
    {
        super(id);
        this.setUnlocalizedName(assetName);
        this.setTextureName(GCVenus.ASSET_PREFIX + assetName);
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return GCVenus.starcraftVenusTab;
    }

    @Override
    public float getMaxElectricityStored(ItemStack itemStack)
    {
        return 7500;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return ClientProxyCore.galacticraftItem;
    }

    @Override
    public float getVoltage(ItemStack itemStack)
    {
        return 120;
    }
}
