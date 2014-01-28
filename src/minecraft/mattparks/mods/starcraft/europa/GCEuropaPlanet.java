package mattparks.mods.starcraft.europa;

import mattparks.mods.starcraft.europa.client.GCEuropaMapPlanet;
import mattparks.mods.starcraft.europa.dimension.GCEuropaWorldProvider;
import mattparks.mods.starcraft.jupiter.GCJupiter;

import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IMoon;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;


public class GCEuropaPlanet implements IMoon
{
    private final IMapObject Europa = new GCEuropaMapPlanet();

    @Override
    public String getName()
    {
        return "Europa";
    }

    @Override
    public boolean isReachable()
    {
        return true;
    }

    @Override
    public IPlanet getParentPlanet()
    {
        return GCJupiter.jupiter;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Europa;
    }

    @Override
    public boolean autoRegister()
    {
        return true;
    }

    @Override
    public boolean addToList()
    {
        return true;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return GCEuropaWorldProvider.class;
    }

    @Override
    public int getDimensionID()
    {
        return -54;
    }
}