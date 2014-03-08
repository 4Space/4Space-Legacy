package mattparks.mods.starcraft.uranus;

import mattparks.mods.starcraft.uranus.client.SCUranusMapPlanet;
import mattparks.mods.starcraft.uranus.dimension.SCUranusWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class SCUranusPlanet implements IPlanet
{
    private final IMapObject Uranus = new SCUranusMapPlanet();

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
        return SCUranusConfigManager.dimensionIDUranus;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Uranus;
    }

    @Override
    public String getName()
    {
        return "Uranus";
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return SCUranusWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return false;
    }
}
