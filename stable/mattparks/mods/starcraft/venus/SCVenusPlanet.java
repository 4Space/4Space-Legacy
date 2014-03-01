package mattparks.mods.starcraft.venus;

import mattparks.mods.starcraft.venus.client.SCVenusMapPlanet;
import mattparks.mods.starcraft.venus.dimension.SCVenusWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class SCVenusPlanet implements IPlanet
{
    private final IMapObject Venus = new SCVenusMapPlanet();

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
        return SCVenusConfigManager.dimensionIDVenus;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Venus;
    }

    @Override
    public String getName()
    {
        return "Venus";
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return SCVenusWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return true;
    }
}
