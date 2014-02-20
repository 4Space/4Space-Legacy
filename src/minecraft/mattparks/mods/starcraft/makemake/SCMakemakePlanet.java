package mattparks.mods.starcraft.makemake;

import mattparks.mods.starcraft.makemake.client.SCMakemakeMapPlanet;
import mattparks.mods.starcraft.makemake.dimension.SCMakemakeWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class SCMakemakePlanet implements IPlanet
{
    private final IMapObject Makemake = new SCMakemakeMapPlanet();

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
        return SCMakemakeConfigManager.dimensionIDMakemake;
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
        return SCMakemakeWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return false;
    }
}
