package mattparks.mods.starcraft.io;

import mattparks.mods.starcraft.io.client.SCIoMapPlanet;
import mattparks.mods.starcraft.io.dimension.SCIoWorldProvider;
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

public class SCIoPlanet implements IMoon
{
    private final IMapObject Io = new SCIoMapPlanet();

    @Override
    public String getName()
    {
        return "Io";
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
        return this.Io;
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
        return SCIoWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return SCIoConfigManager.dimensionIDIo;
    }

	@Override
	public boolean forceStaticLoad() 
	{
		return true;
	}
}