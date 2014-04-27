package mattparks.mods.starcraft.pluto.client;

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
 
public class SCPlutoMapPlanet implements IMapObject
{
	@Override
	public float getDistanceFromCenter() 
	{
		return 39.5F;
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
        return new SCPlutoSlotRenderer();
    }

    @Override
	public float getStretchValue() 
	{
		return 11.86F;
	}
}
