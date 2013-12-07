package mattparks.mods.starcraft.jupiter.items;

import mattparks.mods.starcraft.jupiter.GCJupiter;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCCoreItemClearDiamondArmor extends ItemArmor
{
    public boolean attachedMask;
    private final EnumArmorMaterial material;

    public SCCoreItemClearDiamondArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, boolean breathable)
    {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.material = par2EnumArmorMaterial;
        this.attachedMask = breathable;
    }

    @Override
    public Item setUnlocalizedName(String par1Str)
    {
        super.setTextureName(par1Str);
        super.setUnlocalizedName(par1Str);
        return this;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {
        if (this.material == GCJupiterItems.ARMORCLEARDIAMOND)
        {
            if (stack.getItem().itemID == GCJupiterItems.clearDiamondHelmet.itemID)
            {
                return "textures/model/armor/clearDiamond_1.png";
            }
            else if (stack.getItem().itemID == GCJupiterItems.clearDiamondChestplate.itemID || stack.getItem().itemID == GCJupiterItems.clearDiamondBoots.itemID)
            {
                return "textures/model/armor/clearDiamond_2.png";
            }
            else if (stack.getItem().itemID == GCJupiterItems.clearDiamondLeggings.itemID)
            {
                return "textures/model/armor/clearDiamond_3.png";
            }
        }

        return null;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return GCJupiter.starcraftGasTab;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return ClientProxyCore.galacticraftItem;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", "starcraftjupiter:"));
    }
}
