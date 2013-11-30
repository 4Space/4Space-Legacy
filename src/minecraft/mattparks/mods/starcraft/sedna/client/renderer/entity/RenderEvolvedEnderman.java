package mattparks.mods.starcraft.sedna.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import mattparks.mods.starcraft.sedna.client.renderer.model.ModelEvolvedEnderman;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import mattparks.mods.starcraft.sedna.entity.monster.EntityEvolvedEnderman;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RenderEvolvedEnderman extends RenderLiving
{
    private static final ResourceLocation EvolvedEndermanEyesTexture = new ResourceLocation("textures/entity/enderman/enderman_eyes.png");
    private static final ResourceLocation EvolvedEndermanTextures = new ResourceLocation("textures/entity/enderman/enderman.png");

    /** The model of the EvolvedEnderman */
    private ModelEvolvedEnderman EvolvedEndermanModel;
    private Random rnd = new Random();

    public RenderEvolvedEnderman()
    {
        super(new ModelEvolvedEnderman(), 0.5F);
        this.EvolvedEndermanModel = (ModelEvolvedEnderman)super.mainModel;
        this.setRenderPassModel(this.EvolvedEndermanModel);
    }

    /**
     * Renders the EvolvedEnderman
     */
    public void renderEvolvedEnderman(EntityEvolvedEnderman par1EntityEvolvedEnderman, double par2, double par4, double par6, float par8, float par9)
    {
        this.EvolvedEndermanModel.isCarrying = par1EntityEvolvedEnderman.getCarried() > 0;
        this.EvolvedEndermanModel.isAttacking = par1EntityEvolvedEnderman.isScreaming();

        if (par1EntityEvolvedEnderman.isScreaming())
        {
            double d3 = 0.02D;
            par2 += this.rnd.nextGaussian() * d3;
            par6 += this.rnd.nextGaussian() * d3;
        }

        super.doRenderLiving(par1EntityEvolvedEnderman, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEvolvedEndermanTextures(EntityEvolvedEnderman par1EntityEvolvedEnderman)
    {
        return EvolvedEndermanTextures;
    }

    /**
     * Render the block an EvolvedEnderman is carrying
     */
    protected void renderCarrying(EntityEvolvedEnderman par1EntityEvolvedEnderman, float par2)
    {
        super.renderEquippedItems(par1EntityEvolvedEnderman, par2);

        if (par1EntityEvolvedEnderman.getCarried() > 0)
        {
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glPushMatrix();
            float f1 = 0.5F;
            GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
            f1 *= 1.0F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-f1, -f1, f1);
            int i = par1EntityEvolvedEnderman.getBrightnessForRender(par2);
            int j = i % 65536;
            int k = i / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.bindTexture(TextureMap.locationBlocksTexture);
            this.renderBlocks.renderBlockAsItem(Block.blocksList[par1EntityEvolvedEnderman.getCarried()], par1EntityEvolvedEnderman.getCarryingData(), 1.0F);
            GL11.glPopMatrix();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        }
    }

    /**
     * Render the EvolvedEndermans eyes
     */
    protected int renderEyes(EntityEvolvedEnderman par1EntityEvolvedEnderman, int par2, float par3)
    {
        if (par2 != 0)
        {
            return -1;
        }
        else
        {
            this.bindTexture(EvolvedEndermanEyesTexture);
            float f1 = 1.0F;
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
            GL11.glDisable(GL11.GL_LIGHTING);

            if (par1EntityEvolvedEnderman.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderEvolvedEnderman((EntityEvolvedEnderman)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
    {
        return this.renderEyes((EntityEvolvedEnderman)par1EntityLivingBase, par2, par3);
    }

    protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.renderCarrying((EntityEvolvedEnderman)par1EntityLivingBase, par2);
    }

    public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderEvolvedEnderman((EntityEvolvedEnderman)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEvolvedEndermanTextures((EntityEvolvedEnderman)par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderEvolvedEnderman((EntityEvolvedEnderman)par1Entity, par2, par4, par6, par8, par9);
    }
}
