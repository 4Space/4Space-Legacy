package spacecraft.mods.galacticraft.venus.client.render.entities;

import spacecraft.mods.galacticraft.venus.GCVenus;
import spacecraft.mods.galacticraft.venus.client.model.GCVenusModelEvolvedBlaze;
import spacecraft.mods.galacticraft.venus.entities.GCVenusEntityEvolvedBlaze;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GCVenusRenderEvolvedBlaze extends RenderLiving
{
    private static final ResourceLocation EvolvedBlazeTextures = new ResourceLocation(GCVenus.TEXTURE_DOMAIN, "textures/entity/EvolvedBlaze.png");
    private int field_77068_a;

    public GCVenusRenderEvolvedBlaze()
    {
        super(new GCVenusModelEvolvedBlaze(), 0.5F);
        this.field_77068_a = ((ModelEvolvedBlaze)this.mainModel).func_78104_a();
    }

    public void renderEvolvedBlaze(GCVenusEntityEvolvedBlaze par1EntityEvolvedBlaze, double par2, double par4, double par6, float par8, float par9)
    {
        int i = ((ModelEvolvedBlaze)this.mainModel).func_78104_a();

        if (i != this.field_77068_a)
        {
            this.field_77068_a = i;
            this.mainModel = new ModelEvolvedBlaze();
        }

        super.doRenderLiving(par1EntityEvolvedBlaze, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEvolvedBlazeTextures(GCVenusEntityEvolvedBlaze par1EntityEvolvedBlaze)
    {
        return EvolvedBlazeTextures;
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderEvolvedBlaze((GCVenusEntityEvolvedBlaze)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderEvolvedBlaze((GCVenusEntityEvolvedBlaze)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEvolvedBlazeTextures((GCVenusEntityEvolvedBlaze)par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderEvolvedBlaze((GCVenusEntityEvolvedBlaze)par1Entity, par2, par4, par6, par8, par9);
    }
}
