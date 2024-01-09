package com.bittoastergames.projectfruit.lemon.items;

import com.bittoastergames.projectfruit.lemon.entities.EntityLemonArrow;
import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemLemonBow extends Item {

    @SideOnly(Side.CLIENT)
    private IIcon TEXTURE1, TEXTURE2, TEXTURE3;

    public ItemLemonBow() {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(384);
        this.setCreativeTab(ProjectFruitRegistry.tabFruit);
    }

    /**
     * called when the player releases the use item button. Args: itemstack,
     * world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,
                                     EntityPlayer par3EntityPlayer, int par4) {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer,
                par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            return;
        }
        j = event.charge;

        boolean flag = par3EntityPlayer.capabilities.isCreativeMode
                || EnchantmentHelper.getEnchantmentLevel(
                Enchantment.infinity.effectId, par1ItemStack) > 0;

        if (flag
                || par3EntityPlayer.inventory
                .hasItem(ProjectFruitRegistry.lemonArrow)) {
            float f = (float) j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double) f < 0.1D) {
                return;
            }

            if (f > 1.0F) {
                f = 1.0F;
            }

            EntityLemonArrow entityarrow = new EntityLemonArrow(par2World,
                    par3EntityPlayer, f * 2.0F);

            if (f == 1.0F) {
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(
                    Enchantment.power.effectId, par1ItemStack);

            if (k > 0) {
                entityarrow.setDamage(entityarrow.getDamage() + (double) k
                        * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(
                    Enchantment.punch.effectId, par1ItemStack);

            if (l > 0) {
                entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(
                    Enchantment.flame.effectId, par1ItemStack) > 0) {
                entityarrow.setFire(100);
            }

            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F,
                    1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag) {
                entityarrow.canBePickedUp = 2;
            } else {
                par3EntityPlayer.inventory
                        .consumeInventoryItem(ProjectFruitRegistry.lemonArrow);
            }

            if (!par2World.isRemote) {
                par2World.spawnEntityInWorld(entityarrow);
            }
        }
    }

    public ItemStack onEaten(ItemStack par1ItemStack, World par2World,
                             EntityPlayer par3EntityPlayer) {
        return par1ItemStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items
     * is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.bow;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is
     * pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
                                      EntityPlayer par3EntityPlayer) {
        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer,
                par1ItemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            return event.result;
        }

        if (par3EntityPlayer.capabilities.isCreativeMode
                || par3EntityPlayer.inventory
                .hasItem(ProjectFruitRegistry.lemonArrow)) {
            par3EntityPlayer.setItemInUse(par1ItemStack,
                    this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based
     * on material.
     */
    public int getItemEnchantability() {
        return 1;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("projectfruit:lemonbow_0");
        TEXTURE1 = iconRegister.registerIcon("projectfruit:lemonbow_1");
        TEXTURE2 = iconRegister.registerIcon("projectfruit:lemonbow_2");
        TEXTURE3 = iconRegister.registerIcon("projectfruit:lemonbow_3");

    }

    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player,
                         ItemStack usingItem, int useRemaining) {
        if (player.getItemInUse() == null)
            return this.itemIcon;
        int Pulling = stack.getMaxItemUseDuration() - useRemaining;
        if (Pulling >= 18) {
            return TEXTURE3;
        } else if (Pulling > 13) {
            return TEXTURE2;
        } else if (Pulling > 0) {
            return TEXTURE1;
        }
        return itemIcon;
    }
}
