package mattparks.mods.starcraft.jupiter;

import mattparks.mods.starcraft.jupiter.client.SCJupiterMapPlanet;
import mattparks.mods.starcraft.jupiter.dimension.SCJupiterWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class SCJupiterPlanet implements IPlanet
{
    private final IMapObject Jupiter = new SCJupiterMapPlanet();

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
        return SCJupiterConfigManager.dimensionIDJupiter;
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
        return SCJupiterWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return true;
    }
}
