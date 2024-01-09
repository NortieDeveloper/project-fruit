package com.bittoastergames.projectfruit.lemon.items;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class ItemBucketLemonade extends ItemBucket {
	/** field for checking if the bucket has been filled. */
	private Block isFull;

	public ItemBucketLemonade(Block par1) {
		super(par1);
		this.setMaxStackSize(1);
		this.isFull = par1;
		this.setCreativeTab(ProjectFruitRegistry.tabFruit);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack item, World world,
			EntityPlayer player) {

		boolean flag = this.isFull == Blocks.air;
		MovingObjectPosition movingobjectposition = this
				.getMovingObjectPositionFromPlayer(world, player, true);
		if (movingobjectposition == null) {
			return item;
		} else {
			FillBucketEvent event = new FillBucketEvent(player, item, world,
					movingobjectposition);
			if (MinecraftForge.EVENT_BUS.post(event)) {
				return item;
			}
			if (event.getResult() == Event.Result.ALLOW) {
				if (player.capabilities.isCreativeMode) {
					return item;
				}
				if (--item.stackSize <= 0) {
					return event.result;
				}
				if (!player.inventory.addItemStackToInventory(event.result)) {
					player.dropPlayerItemWithRandomChoice(event.result, false);
				}
				return item;
			}
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
				int x = movingobjectposition.blockX;
				int y = movingobjectposition.blockY;
				int z = movingobjectposition.blockZ;
				if (!world.canMineBlock(player, x, y, z)) {
					return item;
				}

				if (movingobjectposition.sideHit == 0) {
					--y;
				}
				if (movingobjectposition.sideHit == 1) {
					++y;
				}
				if (movingobjectposition.sideHit == 2) {
					--z;
				}
				if (movingobjectposition.sideHit == 3) {
					++z;
				}
				if (movingobjectposition.sideHit == 4) {
					--x;
				}
				if (movingobjectposition.sideHit == 5) {
					++x;
				}
				if (!player.canPlayerEdit(x, y, z,
						movingobjectposition.sideHit, item)) {
					return item;
				}
				if (this.tryPlaceContainedLiquid(world, x, y, z)
						&& !player.capabilities.isCreativeMode) {
					return new ItemStack(Items.bucket);
				}
			}
			return item;

		}

	}

	public boolean tryPlaceContainedLiquid(World par1World, int par2, int par3,
			int par4) {
		if (this.isFull == Blocks.air) {
			return false;
		} else {
			Material material = par1World.getBlock(par2, par3, par4).getMaterial();
			boolean flag = !material.isSolid();
			if (!par1World.isAirBlock(par2, par3, par4) && !flag) {
				return false;
			} else {
				if (par1World.provider.isHellWorld
						&& this.isFull == ProjectFruitRegistry.lemonadeBlock) {
					par1World.playSoundEffect((double) ((float) par2 + 0.5F),
							(double) ((float) par3 + 0.5F),
							(double) ((float) par4 + 0.5F), "random.fizz",
							0.5F,
							2.6F + (par1World.rand.nextFloat() - par1World.rand
									.nextFloat()) * 0.8F);
					for (int l = 0; l < 8; ++l) {
						par1World
								.spawnParticle("largesmoke", (double) par2
                                                + Math.random(),
                                        (double) par3 + Math.random(),
                                        (double) par4 + Math.random(), 0.0D,
                                        0.0D, 0.0D
                                );
					}
				} else {
					if (!par1World.isRemote && flag && !material.isLiquid()) {
						par1World.func_147480_a(par2, par3, par4, true);
					}
					par1World.setBlock(par2, par3, par4, ProjectFruitRegistry.lemonadeBlock, 0, 3);
				}
				return true;
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister
				.registerIcon("projectfruit:lemonadebucket");
	}

}
