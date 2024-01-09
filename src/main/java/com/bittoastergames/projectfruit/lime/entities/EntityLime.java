package com.bittoastergames.projectfruit.lime.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import com.bittoastergames.projectfruit.orange.entities.EntitySmallOrange;

public class EntityLime extends EntityMob
{
	
	public EntityLime(World par1World)
	{
		super(par1World);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntitySmallOrange.class, 1.0D, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySmallOrange.class, 0, false));
        this.setSize(1.2F, 2.5F);
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
    }
	
	
	  protected void entityInit()
	    {
	        super.entityInit();
	        this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
	        this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
	        this.getDataWatcher().addObject(14, Byte.valueOf((byte)0));
	    }
	
	  public boolean isAIEnabled()
    	{
        return true;
    	}
	
	  public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	    {
	        super.writeEntityToNBT(nbttagcompound); // this saves the mob to disk
	    }

	    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	    {
	        super.readEntityFromNBT(nbttagcompound); // this loads the mob from disk
	    }

	    /**
	     * Returns the sound this mob makes while it's alive.
	     */
	    protected String getLivingSound()
	    {
	        return "none";
	    }

	    /**
	     * Returns the sound this mob makes when it is hurt.
	     */
	    protected String getHurtSound()
	    {
	    	 
	        return "none";
	    }

	    /**
	     * Returns the sound this mob makes on death.
	     */
	    protected String getDeathSound()
	    {
	        return "none";
	    }
	    
	    /**
	     * Returns the volume for the sounds this mob makes.
	     */
	    protected float getSoundVolume()
	    {
	        return 0.4F;
	    }

	    /**
	     * Returns the item ID for the item the mob drops on death.
	     */
	    protected Item getDropItem()
	    {
	        return ProjectFruitRegistry.lime;
	    }

		public EntityLime spawnBabyAnimal(EntityMob entityMob) {
			return new EntityLime(worldObj);
			
		}


		public EntityAgeable createChild(EntityAgeable var1) {
			return null;
		}
	}