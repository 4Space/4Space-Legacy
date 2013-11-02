package mattparks.mods.starcraft.venus;

import mattparks.mods.starcraft.venus.items.GCVenusItems;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusCreativeTab extends CreativeTabs {
         
	public GCVenusCreativeTab(int position, String tabID)
	{
		super(position, tabID);
	}
 
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return GCVenusItems.sulferSword.itemID;
	}
 
	public String getTranslatedTabLabel()
	{
		return "Galacticraft Venus";
	}
}