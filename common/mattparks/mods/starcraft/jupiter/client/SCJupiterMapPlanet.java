package mattparks.mods.starcraft.jupiter.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCJupiterMapPlanet implements IMapObject
{
	@Override
	public float getDistanceFromCenter() 
	{
		return 5.20F;
	}

	@Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

	@Override
	public float getPhaseShift() 
	{
		return 5.5F;
	}

	@Override
	public float getPlanetSize() 
	{
		return 17F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new SCJupiterSlotRenderer();
    }

    @Override
	public float getStretchValue() 
	{
		return 11.86F;
	}
}
