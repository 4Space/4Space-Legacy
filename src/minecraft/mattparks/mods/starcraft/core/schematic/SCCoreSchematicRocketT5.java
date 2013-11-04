package mattparks.mods.starcraft.core.schematic;

import mattparks.mods.starcraft.core.SCCoreConfigManager;
import mattparks.mods.starcraft.core.client.gui.SCCoreGuiSchematicRocketT5;
import mattparks.mods.starcraft.core.inventory.SCCoreContainerRocketBenchT5;
import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCCoreSchematicRocketT5 implements ISchematicPage
{
    @Override
    public int getPageID()
    {
        return SCCoreConfigManager.idSchematicRocketT5;
    }

    @Override
    public int getGuiID()
    {
        return SCCoreConfigManager.idGuiRocketCraftingBenchT5;
    }

    @Override
    public ItemStack getRequiredItem()
    {
        return new ItemStack(GCCoreItems.schematic.itemID, 1, 1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z)
    {
        return new SCCoreGuiSchematicRocketT5(player.inventory, x, y, z);
    }

    @Override
    public Container getResultContainer(EntityPlayer player, int x, int y, int z)
    {
        return new SCCoreContainerRocketBenchT5(player.inventory, x, y, z);
    }

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
}
