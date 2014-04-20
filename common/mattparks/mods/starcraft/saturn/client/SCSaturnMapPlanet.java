package mattparks.mods.starcraft.saturn.client;

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

public class SCSaturnMapPlanet implements IMapObject
{
	@Override
	public float getDistanceFromCenter() 
	{
		return 9.54F;
	}

	@Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

	@Override
	public float getPhaseShift() 
	{
		return 555.5F;
	}

	@Override
	public float getPlanetSize() 
	{
		return 14F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new SCSaturnSlotRenderer();
    }

    @Override
	public float getStretchValue() 
	{
		return 11.86F;
	}
}
