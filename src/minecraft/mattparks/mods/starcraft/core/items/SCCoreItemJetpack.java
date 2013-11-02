package mattparks.mods.starcraft.core.items;

import mattparks.mods.starcraft.core.SCCoreConfigManager;
import mattparks.mods.starcraft.core.StarcraftCore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SCCoreItemJetpack extends ItemArmor
{
        public boolean active;

        public SCCoreItemJetpack(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, boolean breathable)
        {
            super(par1, par2EnumArmorMaterial, par3, par4);
                this.setMaxStackSize(1);
                this.setMaxDamage(256);
                this.setCreativeTab(StarcraftCore.starcraftCoreTab);
        }

        @Override
        public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemstack)
        {
        if (itemstack.itemID == SCCoreItems.jetpack.itemID)
        {
        player.capabilities.allowFlying = true;
        }
        }
}