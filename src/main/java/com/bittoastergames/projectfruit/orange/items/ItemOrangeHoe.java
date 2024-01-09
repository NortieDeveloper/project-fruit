package com.bittoastergames.projectfruit.orange.items;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemOrangeHoe extends Item{

    protected ToolMaterial theToolMaterial;

    public ItemOrangeHoe(ToolMaterial lemonstoneTool)
    {
        super();
        this.theToolMaterial = lemonstoneTool;
        this.maxStackSize = 1;
        this.setMaxDamage(lemonstoneTool.getMaxUses());
        this.setCreativeTab(ProjectFruitRegistry.tabFruit);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Event.Result.ALLOW)
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return true;
            }

            Block i1 = par3World.getBlock(par4, par5, par6);
            Block j1 = par3World.getBlock(par4, par5 + 1, par6);

            if ((par7 == 0 || j1 != Blocks.air || i1 != Blocks.grass) && i1 != Blocks.dirt)
            {
                return false;
            }
            else
            {
                Block block = Blocks.farmland;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getStepResourcePath(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return true;
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    public String func_77842_f()
    {
        return this.theToolMaterial.toString();
    }

    @Override
    public void registerIcons(IIconRegister iconRegister )
    {
        itemIcon = iconRegister.registerIcon( "projectfruit:orangehoe");
    }

}
