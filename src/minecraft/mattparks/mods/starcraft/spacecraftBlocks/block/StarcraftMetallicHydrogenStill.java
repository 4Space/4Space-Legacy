package mattparks.mods.starcraft.spacecraftBlocks.block;

import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;

public class StarcraftMetallicHydrogenStill extends BlockStationary
{
       public StarcraftMetallicHydrogenStill(int par1)
       {
    	   super(par1, Material.lava);
    	   this.blockHardness = 100.0F;
    	   this.setLightOpacity(1);
    	   this.disableStats();
       }
}
