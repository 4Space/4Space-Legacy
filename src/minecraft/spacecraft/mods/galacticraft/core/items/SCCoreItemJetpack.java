package spacecraft.mods.galacticraft.core.items;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
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
                this.setCreativeTab(SpacecraftCore.starcraftCoreTab);
        }

        @Override
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5)
    {
            if (entity instanceof EntityPlayer)
            {
                    final EntityPlayer player = (EntityPlayer) entity;

                    if (SpacecraftCore.tick % 100 == 0)
                    {
                            if (!player.capabilities.isCreativeMode)
                            {
                                player.inventory.consumeInventoryItem(Item.coal.itemID);
                            }
                    }
            }
    }

        public void setActive()
        {
                this.active = true;
        }
}