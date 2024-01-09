package com.bittoastergames.projectfruit.main.client.lemon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.bittoastergames.projectfruit.lemon.entities.EntityLemonator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLemonator extends RenderLiving
{

    public RenderLemonator(ModelBase modelbase, float f)
    {
        super(modelbase, f);
    }

    public void func_177_a(EntityLemonator entityLemonator, double d, double d1, double d2,
                           float f, float f1)
    {
        super.doRender(entityLemonator, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLemonator entityliving, double d, double d1, double d2,
                               float f, float f1)
    {
        func_177_a((EntityLemonator)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2,
                         float f, float f1)
    {
        func_177_a((EntityLemonator)entity, d, d1, d2, f, f1);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {

        return (new ResourceLocation("projectfruit:textures/entities/lemonator.png"));
    }
   
}