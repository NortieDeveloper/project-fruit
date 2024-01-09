package com.bittoastergames.projectfruit.orange.entities;

import com.bittoastergames.projectfruit.lemon.entities.EntityLemonator;
import com.bittoastergames.projectfruit.lemon.entities.EntitySmallLemon;
import com.bittoastergames.projectfruit.lime.entities.EntityLime;
import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntitySmallOrange extends EntityMob
{
	
	public EntitySmallOrange(World par1World)
	{
		super(par1World);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityLemonator.class, 1.0D, false));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLime.class, 1.0D, true));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntitySmallLemon.class, 1.0D, false));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLemonator.class, 0, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLime.class, 0, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySmallLemon.class, 0, false));
        this.setSize(1.0F, 1.5F);
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.36D);
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
	     * Returns the sound this mob makes when it is hurt.
	     */
	    protected String getHurtSound()
	    {
	    	 
	        return "projectfruit:mob.tinylemon.hit";
	    }

	    /**
	     * Returns the sound this mob makes on death.
	     */
	    protected String getDeathSound()
	    {
	        return "projectfruit:mob.tinylemon.death";
	    }
	    
	    /**
	     * Returns the volume for the sounds this mob makes.
	     */
	    protected float getSoundVolume()
	    {
	        return 0.5F;
	    }

	    /**
	     * Returns the item ID for the item the mob drops on death.
	     */
	    protected Item getDropItem()
	    {
	        return ProjectFruitRegistry.orange;
	    }

		public EntitySmallOrange spawnBabyAnimal(EntityMob entityMob) {
			return new EntitySmallOrange(worldObj);
			
		}


		public EntityAgeable createChild(EntityAgeable var1) {
			return null;
		}
	}

