package spacecraft.mods.galacticraft.venus.client.render.entities;

import spacecraft.mods.galacticraft.venus.GCVenus;
import spacecraft.mods.galacticraft.venus.client.model.GCVenusModelFlameling;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityFlameling;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GCVenusRenderFlameling extends RenderLiving
{
    private static final ResourceLocation flamelingTexture = new ResourceLocation(GCVenus.TEXTURE_DOMAIN, "textures/model/flameling.png");

    public GCVenusRenderFlameling()
    {
        super(new GCVenusModelFlameling(), 0.3F);
    }

    protected ResourceLocation func_110779_a(GCVenusEntityFlameling par1EntityArrow)
    {
        return GCVenusRenderFlameling.flamelingTexture;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110779_a((GCVenusEntityFlameling) par1Entity);
    }

    public void renderSilverfish(GCVenusEntityFlameling par1EntitySilverfish, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntitySilverfish, par2, par4, par6, par8, par9);
    }

    @Override
    protected float getDeathMaxRotation(EntityLivingBase par1EntityLiving)
    {
        return 180.0F;
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3)
    {
        return -1;
    }

    @Override
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSilverfish((GCVenusEntityFlameling) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSilverfish((GCVenusEntityFlameling) par1Entity, par2, par4, par6, par8, par9);
    }
}
