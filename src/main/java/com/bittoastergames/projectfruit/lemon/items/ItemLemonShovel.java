package com.bittoastergames.projectfruit.lemon.items;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import java.util.List;
import java.util.Set;

public class ItemLemonShovel extends ItemTool
{
	/** an array of the blocks this spade is effective against */
    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});

    public ItemLemonShovel(ToolMaterial par2EnumToolMaterial)
    {
        super(-2.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
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
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Blocks.snow_layer ? true : par1Block == Blocks.snow;
    }
    
    @Override
    public void registerIcons(IIconRegister iconRegister )
    {
         itemIcon = iconRegister.registerIcon( "projectfruit:lemonshovel");
    }
    
}
