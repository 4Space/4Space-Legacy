package mattparks.mods.starcraft.sedna.schematic;

import mattparks.mods.starcraft.jupiter.GCJupiterConfigManager;
import mattparks.mods.starcraft.jupiter.client.gui.SCCoreGuiSchematicRocketT5;
import mattparks.mods.starcraft.jupiter.inventory.SCCoreContainerRocketBenchT5;
import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCSednaSchematicRocketT5 implements ISchematicPage
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
        return GCJupiterConfigManager.idGuiRocketCraftingBenchT5;
    }

    @Override
    public int getPageID()
    {
        return GCJupiterConfigManager.idSchematicRocketT5;
    }

    @Override
    public ItemStack getRequiredItem()
    {
        return new ItemStack(GCCoreItems.schematic.itemID, 1, 1);
    }

    @Override
    public Container getResultContainer(EntityPlayer player, int x, int y, int z)
    {
        return new SCCoreContainerRocketBenchT5(player.inventory, x, y, z);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z)
    {
        return new SCCoreGuiSchematicRocketT5(player.inventory, x, y, z);
    }
}
