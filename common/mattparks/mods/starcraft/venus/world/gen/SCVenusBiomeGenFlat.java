package mattparks.mods.starcraft.venus.world.gen;

import java.util.Random;

import net.minecraft.world.World;

public class SCVenusBiomeGenFlat extends SCVenusBiomeGenBase
{
    public SCVenusBiomeGenFlat(int par1)
    {
        super(par1);
        this.setBiomeName("venusFlat");
        this.setColor(11111111);
        this.minHeight = 1.5F;
        this.maxHeight = 0.4F;
    }
}
