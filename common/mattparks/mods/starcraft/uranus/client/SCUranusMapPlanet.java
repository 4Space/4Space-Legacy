package mattparks.mods.starcraft.uranus.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class SCUranusMapPlanet implements IMapObject
{
	@Override
	public float getDistanceFromCenter() 
	{
		return 19.2F;
	}

	@Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

	@Override
	public float getPhaseShift() 
	{
		return 40000.0F;
	}

	@Override
	public float getPlanetSize() 
	{
		return 15F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new SCUranusSlotRenderer();
    }

    @Override
	public float getStretchValue() 
	{
		return 11.86F;
	}
}
