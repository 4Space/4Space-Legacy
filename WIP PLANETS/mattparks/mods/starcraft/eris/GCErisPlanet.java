package mattparks.mods.starcraft.eris;

import mattparks.mods.starcraft.eris.client.GCErisMapPlanet;
import mattparks.mods.starcraft.eris.dimension.GCErisWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCErisPlanet implements IPlanet
{
    private final IMapObject Eris = new GCErisMapPlanet();

    @Override
    public String getName()
    {
        return "Eris";
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
        return this.Eris;
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
        return GCErisWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return GCErisConfigManager.dimensionIDEris;
    }
}
