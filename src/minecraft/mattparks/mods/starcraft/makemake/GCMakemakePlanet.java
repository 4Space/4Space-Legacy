package mattparks.mods.starcraft.makemake;

import mattparks.mods.starcraft.makemake.client.GCMakemakeMapPlanet;
import mattparks.mods.starcraft.makemake.dimension.GCMakemakeWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCMakemakePlanet implements IPlanet
{
    private final IMapObject Makemake = new GCMakemakeMapPlanet();

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
        return GCMakemakeConfigManager.dimensionIDMakemake;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Makemake;
    }

    @Override
    public String getName()
    {
        return "Makemake";
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return GCMakemakeWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return false;
    }
}
