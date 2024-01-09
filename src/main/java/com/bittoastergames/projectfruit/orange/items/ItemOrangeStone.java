package com.bittoastergames.projectfruit.orange.items;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemOrangeStone extends Item{
	
	public ItemOrangeStone()
    {
        super();
        this.setCreativeTab(ProjectFruitRegistry.tabFruit);
    }
    
    @Override
    public void registerIcons(IIconRegister iconRegister )
    {
         itemIcon = iconRegister.registerIcon("projectfruit:orangestone");
    }


}
