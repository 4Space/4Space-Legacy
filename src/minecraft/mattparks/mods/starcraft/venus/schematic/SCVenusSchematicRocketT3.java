package mattparks.mods.starcraft.venus.schematic;

import mattparks.mods.starcraft.venus.SCVenusConfigManager;
import mattparks.mods.starcraft.venus.client.gui.SCVenusGuiSchematicRocketT3;
import mattparks.mods.starcraft.venus.inventory.SCVenusContainerRocketBenchT3;
import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCVenusSchematicRocketT3 implements ISchematicPage
{
    @Override
    public int compareTo(ISchematicPage o)
    {
        if (this.getPageID() > o.getPageID())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    @Override
    public int getGuiID()
    {
        return SCVenusConfigManager.idGuiRocketCraftingBenchT3;
    }

    @Override
    public int getPageID()
    {
        return SCVenusConfigManager.idSchematicRocketT3;
    }

    @Override
    public ItemStack getRequiredItem()
    {
        return new ItemStack(GCCoreItems.schematic.itemID, 1, 1);
    }

    @Override
    public Container getResultContainer(EntityPlayer player, int x, int y, int z)
    {
        return new SCVenusContainerRocketBenchT3(player.inventory, x, y, z);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z)
    {
        return new SCVenusGuiSchematicRocketT3(player.inventory, x, y, z);
    }
}
