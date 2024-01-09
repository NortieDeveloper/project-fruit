package com.bittoastergames.projectfruit.blueberry.items;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemBlueberryStone extends Item{
	
	public ItemBlueberryStone()
    {
        super();
        this.setCreativeTab(ProjectFruitRegistry.tabFruit);
    }
    
    @Override
    public void registerIcons(IIconRegister iconRegister )
    {
         itemIcon = iconRegister.registerIcon( "projectfruit:blueberrystone");
    }

}
