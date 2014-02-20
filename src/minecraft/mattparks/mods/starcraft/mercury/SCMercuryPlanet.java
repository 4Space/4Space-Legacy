package mattparks.mods.starcraft.mercury;

import mattparks.mods.starcraft.mercury.client.SCMercuryMapPlanet;
import mattparks.mods.starcraft.mercury.dimension.SCMercuryWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class SCMercuryPlanet implements IPlanet
{
    private final IMapObject Mercury = new SCMercuryMapPlanet();

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
        return SCMercuryConfigManager.dimensionIDMercury;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Mercury;
    }

    @Override
    public String getName()
    {
        return "Mercury";
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return SCMercuryWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return true;
    }
}
