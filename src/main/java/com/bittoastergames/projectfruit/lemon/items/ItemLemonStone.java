package com.bittoastergames.projectfruit.lemon.items;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemLemonStone extends Item
{
    public ItemLemonStone()
    {
        super();
        this.setCreativeTab(ProjectFruitRegistry.tabFruit);
    }
    
    @Override
    public void registerIcons(IIconRegister iconRegister )
    {
         itemIcon = iconRegister.registerIcon("projectfruit:lemonore");
    }

}
