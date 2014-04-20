package mattparks.mods.starcraft.sedna;

import mattparks.mods.starcraft.sedna.client.SCSednaMapPlanet;
import mattparks.mods.starcraft.sedna.dimension.SCSednaWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class SCSednaPlanet implements IPlanet
{
    private final IMapObject Sedna = new SCSednaMapPlanet();

    @Override
    public boolean addToList()
    {
        return false;
    }

    @Override
    public boolean autoRegister()
    {
        return true;
    }

    @Override
    public int getDimensionID()
    {
        return SCSednaConfigManager.dimensionIDSedna;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Sedna;
    }

    @Override
    public String getName()
    {
        return "Sedna";
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return SCSednaWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return true;
    }

	@Override
	public boolean forceStaticLoad() 
	{
		return true;
	}
}
