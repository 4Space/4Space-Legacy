package mattparks.mods.starcraft.spacecraftBlocks.block;

import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;

public class StarcraftMetallicHydrogenFlowing extends BlockFlowing {

        public StarcraftMetallicHydrogenFlowing(int par1) {
                super(par1, Material.lava);
        }

        {
        	this.blockHardness = 100.0F;
        	this.setLightOpacity(1);
}}
