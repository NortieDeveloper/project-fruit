package com.bittoastergames.projectfruit.lemon;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class LemonadeFluid extends BlockFluidClassic{

	@SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

    public LemonadeFluid(Fluid fluid, Material material) {
        super(ProjectFruitRegistry.lemonadeFluid, Material.water);
        this.setTickRandomly(true);
    }

	@Override
    public IIcon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            stillIcon = register.registerIcon("projectfruit:lemonadestill");
            flowingIcon = register.registerIcon("projectfruit:lemonadeflow");
    }
    
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
    
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }
    
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        if (par1World.provider.dimensionId > 37 || par1World.getBlock(par2, par3 - 1, par4) != ProjectFruitRegistry.lemonBrick || !ProjectFruitRegistry.fruitPortal.tryToCreatePortal(par1World, par2, par3, par4))
        {
            
            par1World.scheduleBlockUpdate(par2, par3, par4, ProjectFruitRegistry.lemonadeBlock, this.tickRate(par1World) + par1World.rand.nextInt(10));
            
        }
    }

}
