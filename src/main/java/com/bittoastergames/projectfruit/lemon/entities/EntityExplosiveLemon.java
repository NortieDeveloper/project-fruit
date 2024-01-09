package com.bittoastergames.projectfruit.lemon.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityExplosiveLemon extends EntityThrowable
{
	public EntityLiving shootingEntity;
	public int field_92057_e = 1;
	
	 public EntityExplosiveLemon(World par1World)
	    {
	        super(par1World);
	    }

	    public EntityExplosiveLemon(World par1World, EntityLivingBase par2EntityLivingBase)
	    {
	        super(par1World, par2EntityLivingBase);
	    }

	    public EntityExplosiveLemon(World par1World, double par2, double par4, double par6)
	    {
	        super(par1World, par2, par4, par6);
	    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (!this.worldObj.isRemote)
        {
            if (par1MovingObjectPosition.entityHit != null)
            {
                par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.shootingEntity), 8);
            }

            this.worldObj.newExplosion((Entity)null, this.posX, this.posY, this.posZ, (float)this.field_92057_e, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            this.setDead();
        }
    }
}
