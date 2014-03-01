package mattparks.mods.starcraft.saturn;

import mattparks.mods.starcraft.saturn.client.SCSaturnMapPlanet;
import mattparks.mods.starcraft.saturn.dimension.SCSaturnWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class SCSaturnPlanet implements IPlanet
{
    private final IMapObject Saturn = new SCSaturnMapPlanet();

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
        return SCSaturnConfigManager.dimensionIDSaturn;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Saturn;
    }

    @Override
    public String getName()
    {
        return "Saturn";
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return SCSaturnWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return false;
    }
}
