package com.bittoastergames.projectfruit.orange.blocks;


import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockOrangeGrass extends Block {

	 public BlockOrangeGrass()
	    {
	        super(Material.grass);
	        this.setTickRandomly(true);
	        this.setCreativeTab(ProjectFruitRegistry.tabFruit);
	    }
	 
	 public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	    {
	        if (!par1World.isRemote)
	        {
	            if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
	            {
	                par1World.setBlock(par2, par3, par4, Blocks.dirt);
	            }
	            else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
	            {
	                for (int l = 0; l < 4; ++l)
	                {
	                    int i1 = par2 + par5Random.nextInt(3) - 1;
	                    int j1 = par3 + par5Random.nextInt(5) - 3;
	                    int k1 = par4 + par5Random.nextInt(3) - 1;
	                    Block l1 = par1World.getBlock(i1, j1 + 1, k1);

	                    if (par1World.getBlock(i1, j1, k1) == Blocks.dirt && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
	                    {
	                        par1World.setBlock(i1, j1, k1, ProjectFruitRegistry.orangeGrass);
	                    }
	                }
	            }
	        }
	    }
	 
	 @SideOnly(Side.CLIENT)
	 private IIcon sides, bottom, top;
	 
	 public IIcon getIcon(int par1, int par2)
	    {
	        return par1 == 1 ? this.top : (par1 == 0 ? Blocks.dirt.getBlockTextureFromSide(par1) : this.sides);
	    }
	 
	 @SideOnly(Side.CLIENT)
     public void registerBlockIcons(IIconRegister par1IconRegister)
     {
             this.sides = par1IconRegister.registerIcon("projectfruit:orangegrassside");
             this.bottom = par1IconRegister.registerIcon("projectfruit:lemoniliumbottom");
             this.top = par1IconRegister.registerIcon("projectfruit:orangegrasstop");
     }
	 
	 @SideOnly(Side.CLIENT)
	 public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	    {
	        if (par5 == 1)
	        {
	            return this.top;
	        }
	        else if (par5 == 0)
	        {
	            return Blocks.dirt.getBlockTextureFromSide(par5);
	        }
	        else
	        {
	            return null;
	        }
	    }
	 
	 public Block idDropped(int par1, Random random, int zero) {
	        return ProjectFruitRegistry.orangeGrass;
	}
}
