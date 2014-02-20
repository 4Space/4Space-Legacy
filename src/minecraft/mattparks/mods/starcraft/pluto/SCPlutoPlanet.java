package mattparks.mods.starcraft.pluto;

import mattparks.mods.starcraft.pluto.client.SCPlutoMapPlanet;
import mattparks.mods.starcraft.pluto.dimension.SCPlutoWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class SCPlutoPlanet implements IPlanet
{
    private final IMapObject Pluto = new SCPlutoMapPlanet();

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
        return SCPlutoConfigManager.dimensionIDPluto;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Pluto;
    }

    @Override
    public String getName()
    {
        return "Pluto";
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return SCPlutoWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return true;
    }
}
