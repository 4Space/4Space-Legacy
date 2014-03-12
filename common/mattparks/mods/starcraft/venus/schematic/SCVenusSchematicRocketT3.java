package mattparks.mods.starcraft.venus.schematic;

import mattparks.mods.starcraft.venus.SCVenusConfigManager;
import mattparks.mods.starcraft.venus.client.gui.SCVenusGuiSchematicRocketT3;
import micdoodle8.mods.galacticraft.api.recipe.SchematicPage;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerRocketBench;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCVenusSchematicRocketT3 extends SchematicPage
{
	@Override
	public int getPageID()
	{
		return SCVenusConfigManager.idSchematicRocketT3;
	}

	@Override
	public int getGuiID()
	{
		return SCVenusConfigManager.idGuiRocketCraftingBenchT3;
	}

	@Override
	public ItemStack getRequiredItem()
	{
		return null;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z)
	{
		return new SCVenusGuiSchematicRocketT3(player.inventory, x, y, z);
	}

	@Override
	public Container getResultContainer(EntityPlayer player, int x, int y, int z)
	{
		return new GCCoreContainerRocketBench(player.inventory, x, y, z);
	}
}
