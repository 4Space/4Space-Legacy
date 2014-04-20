package mattparks.mods.starcraft.mercury;

import mattparks.mods.starcraft.mercury.client.SCMercuryMapPlanet;
import mattparks.mods.starcraft.mercury.dimension.SCMercuryWorldProvider;
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

public class SCMercuryPlanet implements IPlanet
{
	private final IMapObject mercury = new SCMercuryMapPlanet();

	@Override
	public String getName()
	{
		return "Mercury";
	}

	@Override
	public boolean isReachable()
	{
		return true;
	}

	@Override
	public IGalaxy getParentGalaxy()
	{
		return GalacticraftCore.galaxyMilkyWay;
	}

	@Override
	public IMapObject getMapObject()
	{
		return this.mercury;
	}

	@Override
	public boolean autoRegister()
	{
		return true;
	}

	@Override
	public boolean addToList()
	{
		return false;
	}

	@Override
	public Class<? extends WorldProvider> getWorldProvider()
	{
		return SCMercuryWorldProvider.class;
	}

	@Override
	public int getDimensionID()
	{
		return SCMercuryConfigManager.dimensionIDMercury;
	}

	@Override
	public boolean forceStaticLoad()
	{
		return true;
	}
}
