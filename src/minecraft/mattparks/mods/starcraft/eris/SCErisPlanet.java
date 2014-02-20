package mattparks.mods.starcraft.eris;

import mattparks.mods.starcraft.eris.client.SCErisMapPlanet;
import mattparks.mods.starcraft.eris.dimension.SCErisWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class SCErisPlanet implements IPlanet
{
    private final IMapObject Eris = new SCErisMapPlanet();

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
        return SCErisConfigManager.dimensionIDEris;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Eris;
    }

    @Override
    public String getName()
    {
        return "Eris";
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return SCErisWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return true;
    }
}
