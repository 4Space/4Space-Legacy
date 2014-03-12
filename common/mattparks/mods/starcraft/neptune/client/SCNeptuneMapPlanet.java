package mattparks.mods.starcraft.neptune.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class SCNeptuneMapPlanet implements IMapObject
{
	@Override
	public float getDistanceFromCenter() 
	{
		return 30.07F;
	}

	@Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

	@Override
	public float getPhaseShift() 
	{
		return 5000.0F;
	}

	@Override
	public float getPlanetSize() 
	{
		return 14F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new SCNeptuneSlotRenderer();
    }

    @Override
	public float getStretchValue() 
	{
		return 11.86F;
	}
}
