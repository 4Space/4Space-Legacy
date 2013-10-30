package spacecraft.mods.galacticraft.venus;

import spacecraft.mods.galacticraft.venus.items.GCVenusItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

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