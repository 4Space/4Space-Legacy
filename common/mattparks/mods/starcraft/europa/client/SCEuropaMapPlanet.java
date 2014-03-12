package mattparks.mods.starcraft.europa.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class SCEuropaMapPlanet implements IMapObject
{
	@Override
	public float getDistanceFromCenter() 
	{
		return 1250.0F;
	}

	@Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

	@Override
	public float getPhaseShift() 
	{
		return 60F;
	}

	@Override
	public float getPlanetSize() 
	{
		return 1.5F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new SCEuropaSlotRenderer();
    }

    @Override
	public float getStretchValue() 
	{
		return 0.3F;
	}
}
