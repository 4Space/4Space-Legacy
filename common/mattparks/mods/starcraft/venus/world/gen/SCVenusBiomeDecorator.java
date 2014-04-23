package mattparks.mods.starcraft.venus.world.gen;

import java.util.Random;

import mattparks.mods.starcraft.venus.blocks.VenusBlocks;
import micdoodle8.mods.galacticraft.api.event.wgen.GCCoreEventPopulate;
import micdoodle8.mods.galacticraft.core.world.gen.GCCoreWorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;

public class SCVenusBiomeDecorator
{
    protected World worldObj;
    protected Random randomGenerator;

    protected int chunkX;
    protected int chunkZ;

    protected WorldGenerator dirtGen;
    protected WorldGenerator gemGen;
    protected WorldGenerator sulferGen;
    protected WorldGenerator meteorGen;
    protected WorldGenerator ironGen;
    protected WorldGenerator coalGen;
    protected WorldGenerator tinGen;
    protected WorldGenerator copperGen;
    protected WorldGenerator crystalGen;
    protected WorldGenerator fossilizedPlantGen;
    protected WorldGenerator glowstoneGen;
//    protected WorldGenerator lavaGen;

    public SCVenusBiomeDecorator()
    {
        this.gemGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusRedGemOre.blockID, 3, 0, false, VenusBlocks.VenusStone.blockID, 4);
        this.sulferGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusSulferOre.blockID, 16, 2, false, VenusBlocks.VenusStone.blockID, 4);
        this.meteorGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusMeteorOre.blockID, 2, 2, false, VenusBlocks.VenusStone.blockID, 4);
        this.dirtGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusDirt.blockID, 25, 6, false, VenusBlocks.VenusStone.blockID, 4); 
        this.ironGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusIronOre.blockID, 8, 3, false, VenusBlocks.VenusStone.blockID, 4);  
        this.coalGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusCoalOre.blockID, 12, 5, false, VenusBlocks.VenusStone.blockID, 4);     
        this.tinGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusTinOre.blockID, 4, 1, false, VenusBlocks.VenusStone.blockID, 4);  
        this.copperGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusCopperOre.blockID, 5, 7, false, VenusBlocks.VenusStone.blockID, 4);      
        this.crystalGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusCrystalOre.blockID, 1, 3, false, VenusBlocks.VenusStone.blockID, 4);
        this.fossilizedPlantGen = new GCCoreWorldGenMinableMeta(VenusBlocks.FossilizedPlantOre.blockID, 1, 2, false, VenusBlocks.VenusCoalOre.blockID, 4);
        this.glowstoneGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusGlowstoneOre.blockID, 1, 2, false, VenusBlocks.VenusStone.blockID, 4);
//        this.lavaGen = new GCCoreWorldGenMinableMeta(Block.lavaMoving.blockID, 45, 3, false, VenusBlocks.VenusStone.blockID, 4);
    }

    public void decorate(World worldObj, Random rand, int chunkX, int chunkZ)
    {
        if (this.worldObj != null)
        {
            throw new RuntimeException("Already decorating!!");
        }
        else
        {
            this.worldObj = worldObj;
            this.randomGenerator = rand;
            this.chunkX = chunkX;
            this.chunkZ = chunkZ;
            this.generateVenus();
            this.worldObj = null;
            this.randomGenerator = null;
        }
    }

    protected void generateVenus()
    {
        MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Pre(this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
        this.genOre(20, this.dirtGen, 0, 225);
        this.genOre(26, this.gemGen, 0, 8);
        this.genOre(23, this.sulferGen, 0, 120);
        this.genOre(12, this.meteorGen, 0, 20);
        this.genOre(35, this.ironGen, 0, 64);
        this.genOre(36, this.coalGen, 0, 75);
        this.genOre(35, this.tinGen, 0, 60);
        this.genOre(36, this.copperGen, 0, 60);
        this.genOre(36, this.crystalGen, 0, 12);
        this.genOre(36, this.fossilizedPlantGen, 0, 1000);
        this.genOre(35, this.glowstoneGen, 0, 16);
//        this.genOre(36, this.lavaGen, 0, 200);
        
        MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Post(this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
    }

    protected void genOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY)
    {
        for (int var5 = 0; var5 < amountPerChunk; ++var5)
        {
            final int var6 = this.chunkX + this.randomGenerator.nextInt(16);
            final int var7 = this.randomGenerator.nextInt(maxY - minY) + minY;
            final int var8 = this.chunkZ + this.randomGenerator.nextInt(16);
            worldGenerator.generate(this.worldObj, this.randomGenerator, var6, var7, var8);
        }
    }
}