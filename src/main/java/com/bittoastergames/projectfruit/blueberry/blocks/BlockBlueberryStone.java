package com.bittoastergames.projectfruit.blueberry.blocks;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockBlueberryStone extends Block {

	public BlockBlueberryStone() {
		super(Material.rock);
        this.setHarvestLevel("pickaxe", 3);
		this.setCreativeTab(ProjectFruitRegistry.tabFruit);
	}

	public Item getItemDropped(int par1, Random random, int zero) {
		return ProjectFruitRegistry.blueberryStone;
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister
				.registerIcon("projectfruit:blueberrystoneblock");
	}

}
