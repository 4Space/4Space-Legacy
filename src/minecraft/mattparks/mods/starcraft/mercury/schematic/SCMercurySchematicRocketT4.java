package mattparks.mods.starcraft.mercury.schematic;

import mattparks.mods.starcraft.mercury.SCMercuryConfigManager;
import mattparks.mods.starcraft.mercury.client.gui.SCMercuryGuiSchematicRocketT4;
import mattparks.mods.starcraft.mercury.inventory.SCMercuryContainerRocketBenchT4;
import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCMercurySchematicRocketT4 implements ISchematicPage
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
        return SCMercuryConfigManager.idGuiRocketCraftingBenchT4;
    }

    @Override
    public int getPageID()
    {
        return SCMercuryConfigManager.idSchematicRocketT4;
    }

    @Override
    public ItemStack getRequiredItem()
    {
        return new ItemStack(GCCoreItems.schematic.itemID, 1, 1);
    }

    @Override
    public Container getResultContainer(EntityPlayer player, int x, int y, int z)
    {
        return new SCMercuryContainerRocketBenchT4(player.inventory, x, y, z);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z)
    {
        return new SCMercuryGuiSchematicRocketT4(player.inventory, x, y, z);
    }
}
