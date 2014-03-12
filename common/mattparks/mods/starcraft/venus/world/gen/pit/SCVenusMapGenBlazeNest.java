package mattparks.mods.starcraft.venus.world.gen.pit;

import micdoodle8.mods.galacticraft.core.world.gen.GCCoreMapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;
import cpw.mods.fml.common.FMLLog;

public class SCVenusMapGenBlazeNest extends GCCoreMapGenStructure
{
    private int terrainType;

	@Override
	protected boolean canSpawnStructureAtCoords(int par1, int par2)
    {
    	if (this.rand.nextInt(75) != 0)
    	{
    		return false;
    	}
    	
    	return true;
    }

    @Override
    protected StructureStart getStructureStart(int par1, int par2)
    {
        FMLLog.info("Generating Blaze Nest at x" + par1 * 16 + " z" + par2 * 16);
        return new SCVenusStructureBlazePitStart(this.worldObj, this.rand, par1, par2);
    }
}