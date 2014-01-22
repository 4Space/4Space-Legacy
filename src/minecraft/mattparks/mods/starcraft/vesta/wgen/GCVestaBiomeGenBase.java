package mattparks.mods.starcraft.vesta.wgen;

import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVestaBiomeGenBase extends BiomeGenBase
{
    public static final BiomeGenBase venusFlat = new GCVestaBiomeGenFlat(102).setBiomeName("venus");

    public GCVestaBiomeGenBase(int var1)
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
    public GCVestaBiomeGenBase setColor(int var1)
    {
        return (GCVestaBiomeGenBase) super.setColor(var1);
    }
}
