package mattparks.mods.starcraft.mercury.wgen;

import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCMercuryBiomeGenBase extends BiomeGenBase
{
    public static final BiomeGenBase mercuryFlat = new SCMercuryBiomeGenFlat(102).setBiomeName("mercury");

    public SCMercuryBiomeGenBase(int var1)
    {
        super(var1);
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.rainfall = 0F;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor()
    {
        double d0 = MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
        double d1 = MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
        return this.getModdedBiomeGrassColor(ColorizerGrass.getGrassColor(d0, d1));
    }

    @Override
    public float getSpawningChance()
    {
        return 0.1F;
    }

    @Override
    public SCMercuryBiomeGenBase setColor(int var1)
    {
        return (SCMercuryBiomeGenBase) super.setColor(var1);
    }
}
