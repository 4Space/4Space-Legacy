package mattparks.mods.starcraft.io.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class SCIoMapPlanet implements IMapObject
{
	@Override
	public float getDistanceFromCenter() 
	{
		return 750.0F;
	}

	@Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

	@Override
	public float getPhaseShift() 
	{
		return 3F;
	}

	@Override
	public float getPlanetSize() 
	{
		return 1.75F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new SCIoSlotRenderer();
    }

    @Override
	public float getStretchValue() 
	{
		return 0.3F;
	}
}
