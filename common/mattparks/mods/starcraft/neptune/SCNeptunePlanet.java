package mattparks.mods.starcraft.neptune;

import mattparks.mods.starcraft.neptune.client.SCNeptuneMapPlanet;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCNeptunePlanet implements IPlanet
{
	@Override
	public String getName()
	{
		return "Neptune";
	}

	@Override
	public boolean isReachable()
	{
		return false;
	}

	@Override
	public IMapObject getMapObject()
	{
		return new SCNeptuneMapPlanet();
	}

	@Override
	public IGalaxy getParentGalaxy()
	{
		return GalacticraftCore.galaxyMilkyWay;
	}

	@Override
	public boolean autoRegister()
	{
		return false;
	}

	@Override
	public boolean addToList()
	{
		return false;
	}

	@Override
	public Class<? extends WorldProvider> getWorldProvider()
	{
		return null;
	}

	@Override
	public int getDimensionID()
	{
		return -1;
	}

	@Override
	public boolean forceStaticLoad() 
	{
		return true;
	}
}
