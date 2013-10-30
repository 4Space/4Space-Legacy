package spacecraft.mods.galacticraft.mercury.wgen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import spacecraft.mods.galacticraft.mercury.wgen.GCMercuryBiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;
import cpw.mods.fml.common.FMLLog;

public class GCMercuryMapGenVillage extends MapGenStructure
{
    public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { GCMercuryBiomeGenBase.venusFlat });
    private final int terrainType;
    private static boolean initialized;

    static
    {
        try
        {
            GCMercuryMapGenVillage.initiateStructures();
        }
        catch (Throwable e)
        {
            ;
        }
    }

    public static void initiateStructures() throws Throwable
    {
        if (!GCMercuryMapGenVillage.initialized)
        {
            MapGenStructureIO.func_143034_b(GCMercuryStructureVillageStart.class, "VenusVillage");
            MapGenStructureIO.func_143031_a(GCMercuryComponentVillageField.class, "VenusField1");
            MapGenStructureIO.func_143031_a(GCMercuryComponentVillageField2.class, "VenusField2");
            MapGenStructureIO.func_143031_a(GCMercuryComponentVillageHouse.class, "VenusHouse");
            MapGenStructureIO.func_143031_a(GCMercuryComponentVillageRoadPiece.class, "VenusRoadPiece");
            MapGenStructureIO.func_143031_a(GCMercuryComponentVillagePathGen.class, "VenusPath");
            MapGenStructureIO.func_143031_a(GCMercuryComponentVillageTorch.class, "VenusTorch");
            MapGenStructureIO.func_143031_a(GCMercuryComponentVillageStartPiece.class, "VenusWell");
            MapGenStructureIO.func_143031_a(GCMercuryComponentVillageWoodHut.class, "VenusWoodHut");
        }

        GCMercuryMapGenVillage.initialized = true;
    }

    public GCMercuryMapGenVillage()
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
    protected StructureStart getStructureStart(int par1, int par2)
    {
        FMLLog.info("Generating Venus Village at x" + par1 * 16 + " z" + par2 * 16);
        return new GCMercuryStructureVillageStart(this.worldObj, this.rand, par1, par2, this.terrainType);
    }

    @Override
    public String func_143025_a()
    {
        return "VenusVillage";
    }
}
