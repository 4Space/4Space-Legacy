package mattparks.mods.starcraft.venus.items;

import mattparks.mods.starcraft.venus.VenusCore;
import micdoodle8.mods.galacticraft.api.transmission.core.item.ItemElectric;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCVenusItemBattery extends ItemElectric
{
	public SCVenusItemBattery(int id, String assetName)
	{
		super(id);
		this.setUnlocalizedName(assetName);
		this.setTextureName(VenusCore.ASSET_PREFIX + assetName);
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return VenusCore.starcraftVenusTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public float getMaxElectricityStored(ItemStack itemStack)
	{
		return 7500;
	}

	@Override
	public float getVoltage(ItemStack itemStack)
	{
		return 120;
	}
}
