package mattparks.mods.starcraft.vesta.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCVestaMapPlanet implements IMapObject
{
	@Override
	public float getDistanceFromCenter() 
	{
		return 7.54F;
	}

	@Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

	@Override
	public float getPhaseShift() 
	{
		return 2.8F;
	}

	@Override
	public float getPlanetSize() 
	{
		return 0.53191489361702127659574468085106F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new GCVestaSlotRenderer();
    }

    @Override
	public float getStretchValue() 
	{
		return 11.86F;
	}
}
