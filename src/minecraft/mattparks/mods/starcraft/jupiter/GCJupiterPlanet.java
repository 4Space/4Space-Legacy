package mattparks.mods.starcraft.jupiter;

import mattparks.mods.starcraft.jupiter.client.GCJupiterMapPlanet;
import mattparks.mods.starcraft.jupiter.dimension.GCJupiterWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCJupiterPlanet implements IPlanet
{
    private final IMapObject Jupiter = new GCJupiterMapPlanet();

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
        return GCJupiterConfigManager.dimensionIDJupiter;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Jupiter;
    }

    @Override
    public String getName()
    {
        return "Jupiter";
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return GCJupiterWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return true;
    }
}
