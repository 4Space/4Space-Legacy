package mattparks.mods.starcraft.venus.client.render.entities;

import mattparks.mods.starcraft.venus.VenusCore;
import mattparks.mods.starcraft.venus.client.model.SCVenusModelEvolvedBlaze;
import mattparks.mods.starcraft.venus.entities.SCVenusEntityEvolvedBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SCVenusRenderEvolvedBlaze extends RenderLiving
{
    private static final ResourceLocation EvolvedBlazeTextures = new ResourceLocation(VenusCore.ASSET_DOMAIN, "textures/model/EvolvedBlaze.png");
    private int field_77068_a;

    public SCVenusRenderEvolvedBlaze()
    {
        super(new SCVenusModelEvolvedBlaze(), 0.5F);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    @Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderEvolvedBlaze((SCVenusEntityEvolvedBlaze)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderEvolvedBlaze((SCVenusEntityEvolvedBlaze)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEvolvedBlazeTextures((SCVenusEntityEvolvedBlaze)par1Entity);
    }

    protected ResourceLocation getEvolvedBlazeTextures(SCVenusEntityEvolvedBlaze par1EntityEvolvedBlaze)
    {
        return EvolvedBlazeTextures;
    }

    public void renderEvolvedBlaze(SCVenusEntityEvolvedBlaze par1EntityEvolvedBlaze, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityEvolvedBlaze, par2, par4, par6, par8, par9);
    }

    @Override
	public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderEvolvedBlaze((SCVenusEntityEvolvedBlaze)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }
}
