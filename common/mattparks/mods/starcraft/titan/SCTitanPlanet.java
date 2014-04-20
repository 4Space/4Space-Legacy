package mattparks.mods.starcraft.titan;

import mattparks.mods.starcraft.saturn.SaturnCore;
import mattparks.mods.starcraft.titan.client.SCTitanMapPlanet;
import mattparks.mods.starcraft.titan.dimension.SCTitanWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IMoon;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import net.minecraft.world.WorldProvider;


public class SCTitanPlanet implements IMoon
{
    private final IMapObject Titan = new SCTitanMapPlanet();

    @Override
    public String getName()
    {
        return "Titan";
    }

    @Override
    public boolean isReachable()
    {
        return true;
    }

    @Override
    public IPlanet getParentPlanet()
    {
        return SaturnCore.saturn;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Titan;
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
        return SCTitanWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return SCTitanConfigManager.dimensionIDTitan;
    }

	@Override
	public boolean forceStaticLoad() 
	{
		return true;
	}
}