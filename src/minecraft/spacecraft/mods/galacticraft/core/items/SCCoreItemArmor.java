package spacecraft.mods.galacticraft.core.items;

import spacecraft.mods.galacticraft.core.SpacecraftCore;
import spacecraft.mods.galacticraft.venus.GCVenus;
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

public class SCCoreItemArmor extends ItemArmor
{
    public boolean attachedMask;
    private final EnumArmorMaterial material;

    public SCCoreItemArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, boolean breathable)
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
        if (this.material == SCCoreItems.ARMORGEM)
        {
            if (stack.getItem().itemID == SCCoreItems.gemHelmet.itemID)
            {
                return "textures/model/armor/gem_1.png";
            }
            else if (stack.getItem().itemID == SCCoreItems.gemChestplate.itemID || stack.getItem().itemID == SCCoreItems.gemBoots.itemID)
            {
                return "textures/model/armor/gem_2.png";
            }
            else if (stack.getItem().itemID == SCCoreItems.gemLeggings.itemID)
            {
                return "textures/model/armor/gem_3.png";
            }
        }

        return null;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return SpacecraftCore.starcraftCoreTab;
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
        this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", "spacecraftcore:"));
    }
}
