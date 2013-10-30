package spacecraft.mods.galacticraft.venus;

import spacecraft.mods.galacticraft.venus.client.GCVenusMapPlanet;
import spacecraft.mods.galacticraft.venus.dimension.GCVenusWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCVenusPlanet implements IPlanet
{
    private final IMapObject Venus = new GCVenusMapPlanet();

    @Override
    public String getName()
    {
        return "Venus";
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
        return this.Venus;
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
        return GCVenusWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return GCVenusConfigManager.dimensionIDVenus;
    }
}
