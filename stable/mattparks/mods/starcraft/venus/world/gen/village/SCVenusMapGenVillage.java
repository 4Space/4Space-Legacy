package mattparks.mods.starcraft.venus.world.gen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import mattparks.mods.starcraft.venus.world.gen.SCVenusBiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;
import cpw.mods.fml.common.FMLLog;

public class SCVenusMapGenVillage extends MapGenStructure
{
    public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { SCVenusBiomeGenBase.venusFlat });
    private final int terrainType;
    private static boolean initialized;

    static
    {
        try
        {
            SCVenusMapGenVillage.initiateStructures();
        }
        catch (Throwable e)
        {
            ;
        }
    }

    public static void initiateStructures() throws Throwable
    {
        if (!SCVenusMapGenVillage.initialized)
        {
            MapGenStructureIO.func_143034_b(SCVenusStructureVillageStart.class, "VenusVillage");
            MapGenStructureIO.func_143031_a(SCVenusComponentVillageField.class, "VenusField1");
            MapGenStructureIO.func_143031_a(SCVenusComponentVillageField2.class, "VenusField2");
            MapGenStructureIO.func_143031_a(SCVenusComponentVillageHouse.class, "VenusHouse");
            MapGenStructureIO.func_143031_a(SCVenusComponentVillageRoadPiece.class, "VenusRoadPiece");
            MapGenStructureIO.func_143031_a(SCVenusComponentVillagePathGen.class, "VenusPath");
            MapGenStructureIO.func_143031_a(SCVenusComponentVillageTorch.class, "VenusTorch");
            MapGenStructureIO.func_143031_a(SCVenusComponentVillageStartPiece.class, "VenusWell");
            MapGenStructureIO.func_143031_a(SCVenusComponentVillageWoodHut.class, "VenusWoodHut");
        }

        SCVenusMapGenVillage.initialized = true;
    }

    public SCVenusMapGenVillage()
    {
        this.terrainType = 0;
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int i, int j)
    {
        final byte numChunks = 32;
        final byte offsetChunks = 8;
        final int oldi = i;
        final int oldj = j;

        if (i < 0)
        {
            i -= numChunks - 1;
        }

        if (j < 0)
        {
            j -= numChunks - 1;
        }

        int randX = i / numChunks;
        int randZ = j / numChunks;
        final Random var7 = this.worldObj.setRandomSeed(i, j, 10387312);
        randX *= numChunks;
        randZ *= numChunks;
        randX += var7.nextInt(numChunks - offsetChunks);
        randZ += var7.nextInt(numChunks - offsetChunks);

        if (oldi == randX && oldj == randZ)
        {
            return true;
        }

        return false;
    }

    @Override
    public String func_143025_a()
    {
        return "VenusVillage";
    }

    @Override
    protected StructureStart getStructureStart(int par1, int par2)
    {
        FMLLog.info("Generating Venus Village at x" + par1 * 16 + " z" + par2 * 16);
        return new SCVenusStructureVillageStart(this.worldObj, this.rand, par1, par2, this.terrainType);
    }
}
