package spacecraft.mods.galacticraft.core.schematic;

import spacecraft.mods.galacticraft.core.SCCoreConfigManager;
import spacecraft.mods.galacticraft.core.client.gui.SCCoreGuiSchematicRocketT3;
import spacecraft.mods.galacticraft.core.inventory.SCCoreContainerRocketBenchT3;
import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCCoreSchematicRocketT3 implements ISchematicPage
{
    @Override
    public int getPageID()
    {
        return SCCoreConfigManager.idSchematicRocketT3;
    }

    @Override
    public int getGuiID()
    {
        return SCCoreConfigManager.idGuiRocketCraftingBenchT3;
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
        return new SCCoreGuiSchematicRocketT3(player.inventory, x, y, z);
    }

    @Override
    public Container getResultContainer(EntityPlayer player, int x, int y, int z)
    {
        return new SCCoreContainerRocketBenchT3(player.inventory, x, y, z);
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
