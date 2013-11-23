package mattparks.mods.starcraft.sedna;

import mattparks.mods.starcraft.sedna.client.GCSednaMapPlanet;
import mattparks.mods.starcraft.sedna.dimension.GCSednaWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCSednaPlanet implements IPlanet
{
    private final IMapObject Sedna = new GCSednaMapPlanet();

    @Override
    public String getName()
    {
        return "Sedna";
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
        return this.Sedna;
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
        return GCSednaWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return GCSednaConfigManager.dimensionIDSedna;
    }
}
