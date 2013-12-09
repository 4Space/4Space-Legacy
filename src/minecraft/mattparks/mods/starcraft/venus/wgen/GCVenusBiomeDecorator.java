package mattparks.mods.starcraft.venus.wgen;

import java.util.Random;

import mattparks.mods.starcraft.core.StarcraftVenus;
import micdoodle8.mods.galacticraft.api.event.wgen.GCCoreEventPopulate;
import micdoodle8.mods.galacticraft.core.world.gen.GCCoreWorldGenMinableMeta;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;

public class GCVenusBiomeDecorator
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
    
    protected WorldGenerator lavaGen;

    public GCVenusBiomeDecorator()
    {
        this.gemGen = new GCCoreWorldGenMinableMeta(StarcraftVenus.VenusRedGemOre.blockID, 4, 0, false, StarcraftVenus.VenusStone.blockID, 4);
        this.sulferGen = new GCCoreWorldGenMinableMeta(StarcraftVenus.VenusSulferOre.blockID, 4, 1, false, StarcraftVenus.VenusStone.blockID, 4);
        this.meteorGen = new GCCoreWorldGenMinableMeta(StarcraftVenus.VenusMeteorOre.blockID, 3, 2, false, StarcraftVenus.VenusStone.blockID, 4);
        this.dirtGen = new GCCoreWorldGenMinableMeta(StarcraftVenus.VenusDirt.blockID, 32, 3, false, StarcraftVenus.VenusStone.blockID, 4); 
        this.ironGen = new GCCoreWorldGenMinableMeta(StarcraftVenus.VenusIronOre.blockID, 6, 4, false, StarcraftVenus.VenusStone.blockID, 4);  
        this.coalGen = new GCCoreWorldGenMinableMeta(StarcraftVenus.VenusCoalOre.blockID, 9, 5, false, StarcraftVenus.VenusStone.blockID, 4);     
        this.tinGen = new GCCoreWorldGenMinableMeta(StarcraftVenus.VenusTinOre.blockID, 5, 6, false, StarcraftVenus.VenusStone.blockID, 4);  
        this.copperGen = new GCCoreWorldGenMinableMeta(StarcraftVenus.VenusCopperOre.blockID, 5, 7, false, StarcraftVenus.VenusStone.blockID, 4);      
    
        this.lavaGen = new GCCoreWorldGenMinableMeta(Block.lavaMoving.blockID, 32, 0, false, StarcraftVenus.VenusGrass.blockID, 4); 
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

    protected void generateVenus()
    {
        MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Pre(this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
        this.genOre(20, this.dirtGen, 0, 200);
        this.genOre(26, this.gemGen, 0, 60);
        this.genOre(23, this.sulferGen, 0, 60);
        this.genOre(12, this.meteorGen, 0, 128);
        this.genOre(35, this.ironGen, 0, 128);
        this.genOre(36, this.coalGen, 0, 128);
        this.genOre(35, this.tinGen, 0, 128);
        this.genOre(36, this.copperGen, 0, 128);
        
        this.genOre(36, this.lavaGen, 0, 128);
        
        MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Post(this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
    }
}
