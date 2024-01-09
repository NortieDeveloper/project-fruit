package com.bittoastergames.projectfruit.main.client.lemon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLemonator extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer leg_1;
    ModelRenderer leg_2;
    ModelRenderer head;
    ModelRenderer side_thing_1;
    ModelRenderer side_thing_2;
  
  public ModelLemonator()
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
