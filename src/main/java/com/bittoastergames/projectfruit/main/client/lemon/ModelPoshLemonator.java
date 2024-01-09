package com.bittoastergames.projectfruit.main.client.lemon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPoshLemonator extends ModelBase
{
    //fields
    ModelRenderer body;
    ModelRenderer leg_1;
    ModelRenderer leg_2;
    ModelRenderer head;
    ModelRenderer side_thing_1;
    ModelRenderer side_thing_2;
    ModelRenderer tophat;
    ModelRenderer tophatbrim1;
    ModelRenderer tophatbrim2;
    ModelRenderer tophatbrim3;
    ModelRenderer tophatbrim4;
    ModelRenderer monocole;
    ModelRenderer monocole2;
    ModelRenderer glass;
    ModelRenderer monocole3;
    ModelRenderer monocole4;

    public ModelPoshLemonator()
    {
        textureWidth = 256;
        textureHeight = 256;

        body = new ModelRenderer(this, 0, 0);
        body.addBox(0F, 0F, 0F, 20, 20, 37);
        body.setRotationPoint(-10F, -31F, -4F);
        body.setTextureSize(256, 256);
        body.mirror = true;
        setRotation(body, -0.8922867F, 0F, 0F);
        leg_1 = new ModelRenderer(this, 2, 100);
        leg_1.addBox(0F, 0F, 0F, 6, 25, 6);
        leg_1.setRotationPoint(10F, -1F, 2F);
        leg_1.setTextureSize(256, 256);
        leg_1.mirror = true;
        setRotation(leg_1, 0F, 0F, 0F);
        leg_2 = new ModelRenderer(this, 2, 100);
        leg_2.addBox(0F, 0F, 0F, 6, 25, 6);
        leg_2.setRotationPoint(-16F, -1F, 2F);
        leg_2.setTextureSize(256, 256);
        leg_2.mirror = true;
        setRotation(leg_2, 0F, 0F, 0F);
        head = new ModelRenderer(this, 153, 0);
        head.addBox(0F, 0F, 0F, 20, 16, 17);
        head.setRotationPoint(-10F, -31F, -20F);
        head.setTextureSize(256, 256);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        side_thing_1 = new ModelRenderer(this, 126, 39);
        side_thing_1.addBox(0F, 0F, 0F, 4, 4, 4);
        side_thing_1.setRotationPoint(-14F, -25F, -14F);
        side_thing_1.setTextureSize(256, 256);
        side_thing_1.mirror = true;
        setRotation(side_thing_1, 0F, 0F, 0F);
        side_thing_2 = new ModelRenderer(this, 126, 39);
        side_thing_2.addBox(0F, 0F, 0F, 4, 4, 4);
        side_thing_2.setRotationPoint(10F, -25F, -14F);
        side_thing_2.setTextureSize(256, 256);
        side_thing_2.mirror = true;
        setRotation(side_thing_2, 0F, 0F, 0F);
        tophat = new ModelRenderer(this, 0, 58);
        tophat.addBox(0F, 0F, 0F, 12, 12, 10);
        tophat.setRotationPoint(-6F, -43F, -16F);
        tophat.setTextureSize(256, 256);
        tophat.mirror = true;
        setRotation(tophat, 0F, 0F, 0F);
        tophatbrim1 = new ModelRenderer(this, 0, 82);
        tophatbrim1.addBox(0F, 0F, 0F, 14, 1, 1);
        tophatbrim1.setRotationPoint(-7F, -32F, -17F);
        tophatbrim1.setTextureSize(256, 256);
        tophatbrim1.mirror = true;
        setRotation(tophatbrim1, 0F, 0F, 0F);
        tophatbrim2 = new ModelRenderer(this, 0, 82);
        tophatbrim2.addBox(0F, 0F, 0F, 14, 1, 1);
        tophatbrim2.setRotationPoint(-7F, -32F, -6F);
        tophatbrim2.setTextureSize(256, 256);
        tophatbrim2.mirror = true;
        setRotation(tophatbrim2, 0F, 0F, 0F);
        tophatbrim3 = new ModelRenderer(this, 0, 82);
        tophatbrim3.addBox(0F, 0F, 0F, 1, 1, 10);
        tophatbrim3.setRotationPoint(-7F, -32F, -16F);
        tophatbrim3.setTextureSize(256, 256);
        tophatbrim3.mirror = true;
        setRotation(tophatbrim3, 0F, 0F, 0F);
        tophatbrim4 = new ModelRenderer(this, 0, 82);
        tophatbrim4.addBox(0F, 0F, 0F, 1, 1, 10);
        tophatbrim4.setRotationPoint(6F, -32F, -16F);
        tophatbrim4.setTextureSize(256, 256);
        tophatbrim4.mirror = true;
        setRotation(tophatbrim4, 0F, 0F, 0F);
        monocole = new ModelRenderer(this, 0, 71);
        monocole.addBox(0F, 0F, 0F, 5, 1, 1);
        monocole.setRotationPoint(3F, -30F, -22F);
        monocole.setTextureSize(256, 256);
        monocole.mirror = true;
        setRotation(monocole, 0F, 0F, 0F);
        monocole2 = new ModelRenderer(this, 0, 70);
        monocole2.addBox(0F, 0F, 0F, 3, 1, 1);
        monocole2.setRotationPoint(7F, -26F, -22F);
        monocole2.setTextureSize(256, 256);
        monocole2.mirror = true;
        setRotation(monocole2, 0F, 0F, -1.570796F);
        glass = new ModelRenderer(this, 49, 62);
        glass.addBox(0F, 0F, 0F, 3, 3, 1);
        glass.setRotationPoint(4F, -29F, -22F);
        glass.setTextureSize(256, 256);
        glass.mirror = true;
        setRotation(glass, 0F, 0F, 0F);
        monocole3 = new ModelRenderer(this, 0, 70);
        monocole3.addBox(0F, 0F, 0F, 3, 1, 1);
        monocole3.setRotationPoint(3F, -26F, -22F);
        monocole3.setTextureSize(256, 256);
        monocole3.mirror = true;
        setRotation(monocole3, 0F, 0F, -1.570796F);
        monocole4 = new ModelRenderer(this, 0, 70);
        monocole4.addBox(0F, 0F, 0F, 5, 1, 1);
        monocole4.setRotationPoint(3F, -26F, -22F);
        monocole4.setTextureSize(256, 256);
        monocole4.mirror = true;
        setRotation(monocole4, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        body.render(f5);
        leg_1.render(f5);
        leg_2.render(f5);
        head.render(f5);
        side_thing_1.render(f5);
        side_thing_2.render(f5);
        tophat.render(f5);
        tophatbrim1.render(f5);
        tophatbrim2.render(f5);
        tophatbrim3.render(f5);
        tophatbrim4.render(f5);
        monocole.render(f5);
        monocole2.render(f5);
        glass.render(f5);
        monocole3.render(f5);
        monocole4.render(f5);
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
        leg_1.rotateAngleX =  MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        leg_2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    }

}
