package mattparks.mods.starcraft.jupiter;

import mattparks.mods.starcraft.jupiter.client.SCJupiterMapPlanet;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class SCJupiterPlanet implements IPlanet
{
	@Override
	public String getName()
	{
		return "Jupiter";
	}

	@Override
	public boolean isReachable()
	{
		return false;
	}

	@Override
	public IMapObject getMapObject()
	{
		return new SCJupiterMapPlanet();
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
}
