package mattparks.mods.starcraft.sedna.schematic;

import mattparks.mods.starcraft.sedna.SCSednaConfigManager;
import mattparks.mods.starcraft.sedna.client.gui.SCSednaGuiSchematicRocketT6;
import mattparks.mods.starcraft.sedna.inventory.SCSednaContainerRocketBenchT6;
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
        return SCSednaConfigManager.idGuiRocketCraftingBenchT5;
    }

    @Override
    public int getPageID()
    {
        return SCSednaConfigManager.idSchematicRocketT5;
    }

    @Override
    public ItemStack getRequiredItem()
    {
        return new ItemStack(GCCoreItems.schematic.itemID, 1, 1);
    }

    @Override
    public Container getResultContainer(EntityPlayer player, int x, int y, int z)
    {
        return new SCSednaContainerRocketBenchT6(player.inventory, x, y, z);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z)
    {
        return new SCSednaGuiSchematicRocketT6(player.inventory, x, y, z);
    }
}
