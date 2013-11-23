package mattparks.mods.starcraft.sedna.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCSednaMapPlanet implements IMapObject
{
	@Override
	public float getPlanetSize() 
	{
		return 0.53191489361702127659574468085106F;
	}

	@Override
	public float getDistanceFromCenter() 
	{
		return 502.0F;
//(closest point to the Sun) of 76.4 AU, and an aphelion (farthest point from the Sun) of 960.8 AU.
	}

	@Override
	public float getPhaseShift() 
	{
		return 2.8F;
	}

	@Override
	public float getStretchValue() 
	{
		return 11.86F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new GCSednaSlotRenderer();
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }
}
