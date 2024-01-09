
package com.bittoastergames.projectfruit.main.client.lemon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlyingLemon extends ModelBase
{
    //fields
    ModelRenderer body;
    ModelRenderer ear1;
    ModelRenderer ear2;

    public ModelFlyingLemon()
    {
        textureWidth = 256;
        textureHeight = 256;

        body = new ModelRenderer(this, 0, 0);
        body.addBox(0F, 0F, 0F, 80, 60, 46);
        body.setRotationPoint(-32F, -36F, -12F);
        body.setTextureSize(256, 256);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        ear1 = new ModelRenderer(this, 0, 110);
        ear1.addBox(0F, 0F, 0F, 16, 16, 16);
        ear1.setRotationPoint(-48F, -16F, 3F);
        ear1.setTextureSize(256, 256);
        ear1.mirror = true;
        setRotation(ear1, 0F, 0F, 0F);
        ear2 = new ModelRenderer(this, 69, 110);
        ear2.addBox(0F, 0F, 0F, 16, 16, 16);
        ear2.setRotationPoint(48F, -16F, 3F);
        ear2.setTextureSize(256, 256);
        ear2.mirror = true;
        setRotation(ear2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        body.render(f5);
        ear1.render(f5);
        ear2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
    }

}
