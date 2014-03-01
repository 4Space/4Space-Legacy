package mattparks.mods.starcraft.neptune;

import mattparks.mods.starcraft.neptune.client.SCNeptuneMapPlanet;
import mattparks.mods.starcraft.neptune.dimension.SCNeptuneWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class SCNeptunePlanet implements IPlanet
{
    private final IMapObject Neptune = new SCNeptuneMapPlanet();

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
        return SCNeptuneConfigManager.dimensionIDNeptune;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Neptune;
    }

    @Override
    public String getName()
    {
        return "Neptune";
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return SCNeptuneWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return false;
    }
}
