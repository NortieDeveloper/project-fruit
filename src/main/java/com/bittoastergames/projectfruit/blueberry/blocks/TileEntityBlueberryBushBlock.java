package com.bittoastergames.projectfruit.blueberry.blocks;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class TileEntityBlueberryBushBlock extends BlockContainer {

	public static boolean isHarvestable;
	
	public TileEntityBlueberryBushBlock() {
		super(Material.plants);
		this.setCreativeTab(ProjectFruitRegistry.tabFruit);
		this.setTickRandomly(true);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.6F, 0.8F);
	}
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
            int l;

            for (l = 1; par1World.getBlock(par2, par3 - l, par4) == ProjectFruitRegistry.blueberryBush; ++l)
            {
                ;
            }

            if (l < 3)
            {
               par1World.setBlock(par2, par3, par4, ProjectFruitRegistry.blueberryBushGrown);
            }
    }

	// Make sure you set this as your TileEntity class relevant for the block!
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityBlueberryBushEntity();
	}
	
	public boolean canPlaceBlockAt(World par1World,int x,int y,int z){
		
		if(par1World.getBlock(x, y - 1, z) == ProjectFruitRegistry.blueberryBush || par1World.getBlock(x, y - 1, z) == ProjectFruitRegistry.blueberryBushGrown){
			return false;
		}
		
		return true;
	}

	// You don't want the normal render type, or it wont render properly.
	@Override
	public int getRenderType() {
		return -1;
	}

	// It's not an opaque cube, so you need this.
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	public int quantityDropped(Random par1Random)
    {
        return par1Random.nextInt(2);
    }
	
	public Block idDropped(int par1, Random random, int zero) {
		return ProjectFruitRegistry.blueberryBush;
	}

	// It's not a normal block, so you need this too.
	public boolean renderAsNormalBlock() {
		return false;
	}

	// This is the icon to use for showing the block in your hand.
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon("projectfruit:blueberrybushicon");
	}

}
