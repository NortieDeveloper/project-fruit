package com.bittoastergames.projectfruit.lemon;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class LemonArmor extends ItemArmor {

    public String armorNamePrefix;
    public ArmorMaterial material;

    public LemonArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4,
                      String armornamePrefix) {
        super(par2EnumArmorMaterial, par3, par4);
        this.material = par2EnumArmorMaterial;
        par2EnumArmorMaterial.getDamageReductionAmount(par4);
        this.maxStackSize = 1;
        this.setCreativeTab(ProjectFruitRegistry.tabFruit);
        armorNamePrefix = armornamePrefix;
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot,
                                  String type) {
        if (stack.toString().contains("leggings")) {
            return "projectfruit:" + armorNamePrefix + "_2.png";
        }

        if (stack.toString().contains("Leggings"))
            if (armorType == 2) {
                return "projectfruit:" + armorNamePrefix + "_2.png";
            }
        return "projectfruit:" + armorNamePrefix + "_1.png";
    }

    public void registerIcons(IIconRegister parIconRegister) {
        if (armorType == 0) {
            itemIcon = parIconRegister.registerIcon("projectfruit:lemonhelmet");
        }

        if (armorType == 1) {
            itemIcon = parIconRegister
                    .registerIcon("projectfruit:lemonchestplate");
        }

        if (armorType == 2) {
            itemIcon = parIconRegister.registerIcon("projectfruit:lemonleggings");
        }

        if (armorType == 3) {
            itemIcon = parIconRegister.registerIcon("projectfruit:lemonboots");
        }
    }

}
