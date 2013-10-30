package spacecraft.mods.galacticraft.pluto;

import spacecraft.mods.galacticraft.pluto.client.GCPlutoMapPlanet;
import spacecraft.mods.galacticraft.pluto.dimension.GCPlutoWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCPlutoPlanet implements IPlanet
{
    private final IMapObject Pluto = new GCPlutoMapPlanet();

    @Override
    public String getName()
    {
        return "Pluto";
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
        return this.Pluto;
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
        return GCPlutoWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return GCPlutoConfigManager.dimensionIDPluto;
    }
}
