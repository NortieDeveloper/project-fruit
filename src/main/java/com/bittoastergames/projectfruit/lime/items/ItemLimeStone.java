package com.bittoastergames.projectfruit.lime.items;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemLimeStone extends Item
{
    public ItemLimeStone()
    {
        super();
        this.setCreativeTab(ProjectFruitRegistry.tabFruit);
    }
    
    @Override
    public void registerIcons(IIconRegister iconRegister )
    {
         itemIcon = iconRegister.registerIcon( "projectfruit:limestone");
    }

}
