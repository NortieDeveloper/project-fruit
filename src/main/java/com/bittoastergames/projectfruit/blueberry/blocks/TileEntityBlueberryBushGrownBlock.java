package com.bittoastergames.projectfruit.blueberry.blocks;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class TileEntityBlueberryBushGrownBlock extends BlockContainer {
	
	public TileEntityBlueberryBushGrownBlock() {
		super(Material.plants);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.6F, 0.8F);
        this.setBlockTextureName("projectfruit:blueberrybushgrown");
	}

	// Make sure you set this as your TileEntity class relevant for the block!
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityBlueberryBushGrownEntity();
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

	// It's not a normal block, so you need this too.
	public boolean renderAsNormalBlock() {
		return false;
	}

    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
    {
        return new ItemStack(ProjectFruitRegistry.blueberryBush, 1);
    }

    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();

        items.add(new ItemStack(ProjectFruitRegistry.blueberryBush, 1));

        return items;
    }

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9){
		par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ProjectFruitRegistry.blueberry));	
		return par1World.setBlock(par2, par3, par4, ProjectFruitRegistry.blueberryBush);
	}


	// This is the icon to use for showing the block in your hand.
	public void registerIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon("projectfruit:blueberrybushicon");
	}

}
