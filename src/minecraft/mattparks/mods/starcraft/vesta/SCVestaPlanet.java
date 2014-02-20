package mattparks.mods.starcraft.vesta;

import mattparks.mods.starcraft.vesta.client.SCVestaMapPlanet;
import mattparks.mods.starcraft.vesta.dimension.SCVestaWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class SCVestaPlanet implements IPlanet
{
    private final IMapObject Vesta = new SCVestaMapPlanet();

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
        return SCVestaConfigManager.dimensionIDVesta;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.Vesta;
    }

    @Override
    public String getName()
    {
        return "Vesta";
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return SCVestaWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return false;
    }
}
