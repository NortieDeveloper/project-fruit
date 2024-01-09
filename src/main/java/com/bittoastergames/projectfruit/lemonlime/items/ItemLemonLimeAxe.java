package com.bittoastergames.projectfruit.lemonlime.items;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import java.util.List;
import java.util.Set;

public class ItemLemonLimeAxe extends ItemTool
{
    /** an array of the blocks this axe is effective against */
    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});

    public ItemLemonLimeAxe(ToolMaterial par2EnumToolMaterial)
    {
        super(-1.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.setCreativeTab(ProjectFruitRegistry.tabFruit);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        if(ProjectFruitRegistry.showToolTips) {
            list.add("Durability: " + this.toolMaterial.getMaxUses());
            list.add("Efficiency: " + this.toolMaterial.getEfficiencyOnProperMaterial());
            list.add("Enchantability: " + this.toolMaterial.getEnchantability());
        }
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.vine ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister )
    {
        itemIcon = iconRegister.registerIcon("projectfruit:lemonlimeaxe");
    }

}
