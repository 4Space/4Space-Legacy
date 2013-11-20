package mattparks.mods.starcraft.spacecraftBlocks.blocks;

import mattparks.mods.starcraft.core.StarcraftCore;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;

public class StarcraftMetallicHydrogenStill extends BlockStationary{
       
        public StarcraftMetallicHydrogenStill(int id, String name)
        {
            super(id, Material.lava);
            this.setUnlocalizedName(name);
            this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
            this.setHardness(2.0F);

            this.blockHardness = 100.0F;
            this.setLightOpacity(1);
            this.disableStats();
        }
}
