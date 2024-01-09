package com.bittoastergames.projectfruit.main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFruitPortal extends BlockBreakable {
	public BlockFruitPortal() {
		super("portal", Material.portal, false);
		this.setTickRandomly(true);
		this.setHardness(-1.0F);
		this.setStepSound(soundTypeGlass);
		this.setLightLevel(0.75F);
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);

        if (p_149674_1_.provider.isSurfaceWorld() && p_149674_1_.getGameRules().getGameRuleBooleanValue("doMobSpawning") && p_149674_5_.nextInt(2000) < p_149674_1_.difficultySetting.getDifficultyId())
        {
            int l;

            for (l = p_149674_3_; !World.doesBlockHaveSolidTopSurface(p_149674_1_, p_149674_2_, l, p_149674_4_) && l > 0; --l)
            {
                ;
            }

            if (l > 0 && !p_149674_1_.getBlock(p_149674_2_, l + 1, p_149674_4_).isNormalCube())
            {
                Entity entity = ItemMonsterPlacer.spawnCreature(p_149674_1_, 57, (double)p_149674_2_ + 0.5D, (double)l + 1.1D, (double)p_149674_4_ + 0.5D);

                if (entity != null)
                {
                    entity.timeUntilPortal = entity.getPortalCooldown();
                }
            }
        }
    }

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		return null;
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y,
	 * z
	 */
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        int l = func_149999_b(p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_));

        if (l == 0)
        {
            if (p_149719_1_.getBlock(p_149719_2_ - 1, p_149719_3_, p_149719_4_) != this && p_149719_1_.getBlock(p_149719_2_ + 1, p_149719_3_, p_149719_4_) != this)
            {
                l = 2;
            }
            else
            {
                l = 1;
            }

            if (p_149719_1_ instanceof World && !((World)p_149719_1_).isRemote)
            {
                ((World)p_149719_1_).setBlockMetadataWithNotify(p_149719_2_, p_149719_3_, p_149719_4_, l, 2);
            }
        }

        float f = 0.125F;
        float f1 = 0.125F;

        if (l == 1)
        {
            f = 0.5F;
        }

        if (l == 2)
        {
            f1 = 0.5F;
        }

        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
    }

	/**
	 * Is this block (a) opaque and (B) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube() {
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	/**
	 * Checks to see if this location is valid to create a portal and will
	 * return True if it does. Args: world, x, y, z
	 */
	public boolean tryToCreatePortal(World par1World, int par2, int par3,
			int par4) {
		byte b0 = 0;
		byte b1 = 0;
		if (par1World.getBlock(par2 - 1, par3, par4) == ProjectFruitRegistry.lemonBrick
				|| par1World.getBlock(par2 + 1, par3, par4) == ProjectFruitRegistry.lemonBrick) {
			b0 = 1;
		}
		if (par1World.getBlock(par2, par3, par4 - 1) == ProjectFruitRegistry.lemonBrick
				|| par1World.getBlock(par2, par3, par4 + 1) == ProjectFruitRegistry.lemonBrick) {
			b1 = 1;
		}
		if (b0 == b1) {
			return false;
		} else {
			if (par1World.getBlock(par2 - b0, par3, par4 - b1) == Blocks.air) {
				par2 -= b0;
				par4 -= b1;
			}
			int l;
			int i1;
			for (l = -1; l <= 2; ++l) {
				for (i1 = -1; i1 <= 3; ++i1) {
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
					if (l != -1 && l != 2 || i1 != -1 && i1 != 3) {
						Block j1 = par1World.getBlock(par2 + b0 * l, par3 + i1,
                                par4 + b1 * l);
						if (flag) {
							if (j1 != ProjectFruitRegistry.lemonBrick) {
								return false;
							}
						} else if (j1 != Blocks.air
								&& j1 != ProjectFruitRegistry.lemonadeBlock) {
							return false;
						}
					}
				}
			}
			for (l = 0; l < 2; ++l) {
				for (i1 = 0; i1 < 3; ++i1) {
					par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l,
							ProjectFruitRegistry.fruitPortal, 0, 2);
				}
			}
			return true;
		}
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, Block par5) {
		byte b0 = 0;
		byte b1 = 1;
		if (par1World.getBlock(par2 - 1, par3, par4) == ProjectFruitRegistry.fruitPortal
				|| par1World.getBlock(par2 + 1, par3, par4) == ProjectFruitRegistry.fruitPortal) {
			b0 = 1;
			b1 = 0;
		}
		int i1;
		for (i1 = par3; par1World.getBlock(par2, i1 - 1, par4) == ProjectFruitRegistry.fruitPortal; --i1) {
			;
		}
		if (par1World.getBlock(par2, i1 - 1, par4) != ProjectFruitRegistry.lemonBrick) {
			par1World.setBlockToAir(par2, par3, par4);
		} else {
			int j1;
			for (j1 = 1; j1 < 4
					&& par1World.getBlock(par2, i1 + j1, par4) == ProjectFruitRegistry.fruitPortal; ++j1) {
				;
			}
			if (j1 == 3
					&& par1World.getBlock(par2, i1 + j1, par4) == ProjectFruitRegistry.lemonBrick) {
				boolean flag = par1World.getBlock(par2 - 1, par3, par4) == ProjectFruitRegistry.fruitPortal
						|| par1World.getBlock(par2 + 1, par3, par4) == ProjectFruitRegistry.fruitPortal;
				boolean flag1 = par1World.getBlock(par2, par3, par4 - 1) == ProjectFruitRegistry.fruitPortal
						|| par1World.getBlock(par2, par3, par4 + 1) == ProjectFruitRegistry.fruitPortal;
				if (flag && flag1) {
					par1World.setBlockToAir(par2, par3, par4);
				} else {
					if ((par1World.getBlock(par2 + b0, par3, par4 + b1) != ProjectFruitRegistry.lemonBrick || par1World
							.getBlock(par2 - b0, par3, par4 - b1) != ProjectFruitRegistry.fruitPortal)
							&& (par1World
									.getBlock(par2 - b0, par3, par4 - b1) != ProjectFruitRegistry.lemonBrick || par1World
									.getBlock(par2 + b0, par3, par4 + b1) != ProjectFruitRegistry.fruitPortal)) {
						par1World.setBlockToAir(par2, par3, par4);
					}
				}
			} else {
				par1World.setBlockToAir(par2, par3, par4);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 * coordinates. Args: blockAccess, x, y, z, side
	 */
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4, int par5) {
		if (par1IBlockAccess.getBlock(par2, par3, par4) == ProjectFruitRegistry.fruitPortal) {
			return false;
		} else {
			boolean flag = par1IBlockAccess.getBlock(par2 - 1, par3, par4) == ProjectFruitRegistry.fruitPortal
					&& par1IBlockAccess.getBlock(par2 - 2, par3, par4) != ProjectFruitRegistry.fruitPortal;
			boolean flag1 = par1IBlockAccess.getBlock(par2 + 1, par3, par4) == ProjectFruitRegistry.fruitPortal
					&& par1IBlockAccess.getBlock(par2 + 2, par3, par4) != ProjectFruitRegistry.fruitPortal;
			boolean flag2 = par1IBlockAccess.getBlock(par2, par3, par4 - 1) == ProjectFruitRegistry.fruitPortal
					&& par1IBlockAccess.getBlock(par2, par3, par4 - 2) != ProjectFruitRegistry.fruitPortal;
			boolean flag3 = par1IBlockAccess.getBlock(par2, par3, par4 + 1) == ProjectFruitRegistry.fruitPortal
					&& par1IBlockAccess.getBlock(par2, par3, par4 + 2) != ProjectFruitRegistry.fruitPortal;
			boolean flag4 = flag || flag1;
			boolean flag5 = flag2 || flag3;
			return flag4 && par5 == 4 ? true : (flag4 && par5 == 5 ? true
					: (flag5 && par5 == 2 ? true : flag5 && par5 == 3));
		}
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random) {
		return 0;
	}

	/**
	 * Triggered whenever an entity collides with this block (enters into the
	 * block). Args: world, x, y, z, entity
	 */
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3,
			int par4, Entity par5Entity) {
		if ((par5Entity.ridingEntity == null)
				&& (par5Entity.riddenByEntity == null)
				&& ((par5Entity instanceof EntityPlayerMP))) {
			EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;
			if (thePlayer.timeUntilPortal > 0) {
				thePlayer.timeUntilPortal = 10;
			} else if (thePlayer.dimension != ProjectFruitRegistry.dimID) {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer
						.getConfigurationManager()
						.transferPlayerToDimension(
								thePlayer,
								ProjectFruitRegistry.dimID,
								new FruitDimensionTeleporter(
										thePlayer.mcServer
												.worldServerForDimension(ProjectFruitRegistry.dimID)));
			} else {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager()
						.transferPlayerToDimension(
								thePlayer,
								0,
								new FruitDimensionTeleporter(thePlayer.mcServer
										.worldServerForDimension(0)));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass() {
		return 1;
	}

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        if (p_149734_5_.nextInt(100) == 0)
        {
            p_149734_1_.playSound((double)p_149734_2_ + 0.5D, (double)p_149734_3_ + 0.5D, (double)p_149734_4_ + 0.5D, "portal.portal", 0.5F, p_149734_5_.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int l = 0; l < 4; ++l)
        {
            double d0 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
            double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
            double d2 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = p_149734_5_.nextInt(2) * 2 - 1;
            d3 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;

            if (p_149734_1_.getBlock(p_149734_2_ - 1, p_149734_3_, p_149734_4_) != this && p_149734_1_.getBlock(p_149734_2_ + 1, p_149734_3_, p_149734_4_) != this)
            {
                d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
                d3 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
            }
            else
            {
                d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)i1;
                d5 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
            }

            p_149734_1_.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }
    }

    public static int func_149999_b(int p_149999_0_)
    {
        return p_149999_0_ & 3;
    }

	@SideOnly(Side.CLIENT)
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return 0;
	}
}