package com.bittoastergames.projectfruit.lemon.blocks;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import java.util.Random;

public class BlockLemonBrick extends Block {

	public BlockLemonBrick()
    {
        super(Material.rock);
        this.setCreativeTab(ProjectFruitRegistry.tabFruit);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Block idDropped(int par1, Random par2Random, int par3)
    {
        return ProjectFruitRegistry.lemonBrick;
    }
    
    @Override
    public void registerBlockIcons( IIconRegister iconRegister )
    {
         blockIcon = iconRegister.registerIcon( "projectfruit:lemonbrick");
    }
	
}
