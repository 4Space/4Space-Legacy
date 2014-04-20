package mattparks.mods.starcraft.ganymede;

import mattparks.mods.starcraft.ganymede.client.SCGanymedeMapPlanet;
import mattparks.mods.starcraft.ganymede.dimension.SCGanymedeWorldProvider;
import mattparks.mods.starcraft.jupiter.JupiterCore;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IMoon;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import net.minecraft.world.WorldProvider;

/**
 * This file is part of the 4-Space project
 * 
 * @author mattparks
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SCGanymedePlanet implements IMoon
{
    private final IMapObject Ganymede = new SCGanymedeMapPlanet();

    @Override
    public String getName()
    {
        return "Ganymede";
    }

    @Override
    public boolean isReachable()
    {
        return true;
    }

    @Override
    public IPlanet getParentPlanet()
    {
        return JupiterCore.jupiter;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Ganymede;
    }

    @Override
    public boolean autoRegister()
    {
        return true;
    }

    @Override
    public boolean addToList()
    {
        return true;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return SCGanymedeWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return SCGanymedeConfigManager.dimensionIDGanymede;
    }

	@Override
	public boolean forceStaticLoad() 
	{
		return true;
	}
}