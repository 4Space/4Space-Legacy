package mattparks.mods.starcraft.neptune;

import mattparks.mods.starcraft.neptune.client.GCNeptuneMapPlanet;
import mattparks.mods.starcraft.neptune.dimension.*;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCNeptunePlanet implements IPlanet
{
    private final IMapObject Neptune = new GCNeptuneMapPlanet();

    @Override
    public String getName()
    {
        return "Neptune";
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
        return this.Neptune;
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
        return GCNeptuneWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return GCNeptuneConfigManager.dimensionIDNeptune;
    }
}
