package mattparks.mods.starcraft.europa;

import mattparks.mods.starcraft.europa.client.SCEuropaMapPlanet;
import mattparks.mods.starcraft.europa.dimension.SCEuropaWorldProvider;
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

public class SCEuropaPlanet implements IMoon
{
    private final IMapObject Europa = new SCEuropaMapPlanet();

    @Override
    public String getName()
    {
        return "Europa";
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
        return this.Europa;
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
        return SCEuropaWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return SCEuropaConfigManager.dimensionIDEuropa;
    }

	@Override
	public boolean forceStaticLoad() 
	{
		return true;
	}
}