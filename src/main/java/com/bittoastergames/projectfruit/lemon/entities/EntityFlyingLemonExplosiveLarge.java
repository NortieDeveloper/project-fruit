package com.bittoastergames.projectfruit.lemon.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.bittoastergames.projectfruit.main.ProjectFruit;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityFlyingLemonExplosiveLarge extends EntityFlyingLemonExplosive
{
    public int field_92057_e = 1;

    public EntityFlyingLemonExplosiveLarge(World par1World)
    {
        super(par1World);
    }

    @SideOnly(Side.CLIENT)
    public EntityFlyingLemonExplosiveLarge(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        super(par1World, par2, par4, par6, par8, par10, par12);
    }

    public EntityFlyingLemonExplosiveLarge(World par1World, EntityLivingBase par2EntityLivingBase, double par3, double par5, double par7)
    {
        super(par1World, par2EntityLivingBase, par3, par5, par7);
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (!this.worldObj.isRemote)
        {
            if (par1MovingObjectPosition.entityHit != null)
            {
                par1MovingObjectPosition.entityHit.attackEntityFrom(ProjectFruit.causeLemonFireballDamage(this, this.shootingEntity), 6.0F);
            }

            this.worldObj.newExplosion((Entity)null, this.posX, this.posY, this.posZ, (float)this.field_92057_e, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            this.setDead();
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("ExplosionPower", this.field_92057_e);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);

        if (par1NBTTagCompound.hasKey("ExplosionPower"))
        {
            this.field_92057_e = par1NBTTagCompound.getInteger("ExplosionPower");
        }
    }
}
