package mattparks.mods.starcraft.mercury.client.gui;

import mattparks.mods.starcraft.mercury.MercuryCore;
import mattparks.mods.starcraft.mercury.inventory.SCMercuryContainerRocketBenchT4;
import micdoodle8.mods.galacticraft.api.recipe.ISchematicResultPage;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCMercuryGuiSchematicRocketT4 extends GuiContainer implements ISchematicResultPage
{
    private static final ResourceLocation tier4SchematicTexture = new ResourceLocation(MercuryCore.ASSET_DOMAIN, "textures/gui/schematic_rocket_T3.png");

    private int pageIndex;

    public SCMercuryGuiSchematicRocketT4(InventoryPlayer par1InventoryPlayer, int x, int y, int z)
    {
        super(new SCMercuryContainerRocketBenchT4(par1InventoryPlayer, x, y, z));
        this.ySize = 238;
    }

    @Override
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            switch (par1GuiButton.id)
            {
            case 0:
                SchematicRegistry.flipToLastPage(this.pageIndex);
                break;
            case 1:
                SchematicRegistry.flipToNextPage(this.pageIndex);
                break;
            }
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(SCMercuryGuiSchematicRocketT4.tier4SchematicTexture);
        final int var5 = (this.width - this.xSize) / 2;
        final int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString("Tier 4 Rocket", 7, -20 + 27, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, 220 - 104 + 2 + 27, 4210752);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initGui()
    {
        super.initGui();
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 130, this.height / 2 - 30 + 27 - 12, 40, 20, "Back"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 130, this.height / 2 - 30 + 27 + 12, 40, 20, "Next"));
    }

    @Override
    public void setPageIndex(int index)
    {
        this.pageIndex = index;
    }
}
