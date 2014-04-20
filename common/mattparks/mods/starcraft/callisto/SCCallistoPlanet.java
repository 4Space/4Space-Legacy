package mattparks.mods.starcraft.callisto;

import mattparks.mods.starcraft.callisto.client.SCCallistoMapPlanet;
import mattparks.mods.starcraft.callisto.dimension.SCCallistoWorldProvider;
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
 
public class SCCallistoPlanet implements IMoon
{
    private final IMapObject Callisto = new SCCallistoMapPlanet();

    @Override
    public String getName()
    {
        return "Callisto";
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
        return this.Callisto;
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
        return SCCallistoWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return SCCallistoConfigManager.dimensionIDCallisto;
    }

	@Override
	public boolean forceStaticLoad() 
	{
		return true;
	}
}