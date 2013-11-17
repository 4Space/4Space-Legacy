package mattparks.mods.starcraft.uranus;

import mattparks.mods.starcraft.uranus.client.GCUranusMapPlanet;
import mattparks.mods.starcraft.uranus.dimension.GCUranusWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCUranusPlanet implements IPlanet
{
    private final IMapObject Uranus = new GCUranusMapPlanet();

    @Override
    public String getName()
    {
        return "Uranus";
    }

    @Override
    public boolean isReachable()
    {
        return false;
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Uranus;
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
        return GCUranusWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return GCUranusConfigManager.dimensionIDUranus;
    }
}
