package com.bittoastergames.projectfruit.main.client.lime;

import com.bittoastergames.projectfruit.lime.entities.EntityLime;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLime extends RenderLiving {

    public RenderLime(ModelBase modelbase, float f)
    {
        super(modelbase, f);
    }

    public void func_177_a(EntityLime entityLemonator, double d, double d1, double d2,
                           float f, float f1)
    {
        super.doRender(entityLemonator, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLime entityliving, double d, double d1, double d2,
                               float f, float f1)
    {
        func_177_a((EntityLime)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2,
                         float f, float f1)
    {
        func_177_a((EntityLime)entity, d, d1, d2, f, f1);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {

        return (new ResourceLocation("projectfruit:textures/entities/entitylime.png"));
    }
	
}
