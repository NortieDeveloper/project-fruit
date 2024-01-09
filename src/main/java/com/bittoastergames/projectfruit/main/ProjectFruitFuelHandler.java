package com.bittoastergames.projectfruit.main;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ProjectFruitFuelHandler implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if(fuel.getItem() == Item.getItemFromBlock(ProjectFruitRegistry.lemonSapling))
        {
            return 100;
        }
        else if(fuel.getItem() == Item.getItemFromBlock(ProjectFruitRegistry.limeSapling))
        {
            return 100;
        }
        else if(fuel.getItem() == Item.getItemFromBlock(ProjectFruitRegistry.orangeSapling))
        {
            return 100;
        }
        else
        {
            return 0;
        }
    }
}
