package mattparks.mods.starcraft.venus.client.render.entities;

import mattparks.mods.starcraft.venus.VenusCore;
import mattparks.mods.starcraft.venus.client.model.SCVenusModelFlameling;
import mattparks.mods.starcraft.venus.entities.SCVenusEntityFlameling;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SCVenusRenderFlameling extends RenderLiving
{
    private static final ResourceLocation flamelingTexture = new ResourceLocation(VenusCore.ASSET_DOMAIN, "textures/model/flameling.png");

    public SCVenusRenderFlameling()
    {
        super(new SCVenusModelFlameling(), 0.3F);
    }

    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSilverfish((SCVenusEntityFlameling) par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSilverfish((SCVenusEntityFlameling) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation func_110779_a(SCVenusEntityFlameling par1EntityArrow)
    {
        return SCVenusRenderFlameling.flamelingTexture;
    }

    @Override
    protected float getDeathMaxRotation(EntityLivingBase par1EntityLiving)
    {
        return 180.0F;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110779_a((SCVenusEntityFlameling) par1Entity);
    }

    public void renderSilverfish(SCVenusEntityFlameling par1EntitySilverfish, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntitySilverfish, par2, par4, par6, par8, par9);
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3)
    {
        return -1;
    }
}
