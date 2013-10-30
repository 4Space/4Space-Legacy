package spacecraft.mods.galacticraft.saturn;

import spacecraft.mods.galacticraft.saturn.client.GCSaturnMapPlanet;
import spacecraft.mods.galacticraft.saturn.dimension.*;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCSaturnPlanet implements IPlanet
{
    private final IMapObject Saturn = new GCSaturnMapPlanet();

    @Override
    public String getName()
    {
        return "Saturn";
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
        return this.Saturn;
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
        return GCSaturnWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return GCSaturnConfigManager.dimensionIDSaturn;
    }
}
