package com.bittoastergames.projectfruit.lemon.items;

import com.bittoastergames.projectfruit.lemon.entities.EntityExplosiveLemon;
import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemExplosiveLemon extends Item {

	public ItemExplosiveLemon() {
		super();
		this.setCreativeTab(ProjectFruitRegistry.tabFruit);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!par2World.isRemote)
        {
        	par2World.spawnEntityInWorld(new EntityExplosiveLemon(par2World, par3EntityPlayer));
        }

        return par1ItemStack;
    }
	
	 @Override
	    public void registerIcons(IIconRegister iconRegister )
	    {
	         itemIcon = iconRegister.registerIcon( "projectfruit:explosivelemon");
	    }
	

}
