
package com.bittoastergames.projectfruit.main.client.lime;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLime extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer peg1;
    ModelRenderer peg2;
  
  public ModelLime()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      body = new ModelRenderer(this, 0, 0);
      body.addBox(0F, 0F, 0F, 34, 24, 18);
      body.setRotationPoint(-16F, -18F, -6F);
      body.setTextureSize(128, 128);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 44);
      leg1.addBox(0F, 0F, 0F, 6, 18, 6);
      leg1.setRotationPoint(-14F, 6F, 0F);
      leg1.setTextureSize(128, 128);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 25, 44);
      leg2.addBox(0F, 0F, 0F, 6, 18, 6);
      leg2.setRotationPoint(10F, 6F, 0F);
      leg2.setTextureSize(128, 128);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      peg1 = new ModelRenderer(this, 103, 43);
      peg1.addBox(0F, 0F, 0F, 6, 6, 6);
      peg1.setRotationPoint(-22F, -9F, 0F);
      peg1.setTextureSize(128, 128);
      peg1.mirror = true;
      setRotation(peg1, 0F, 0F, 0F);
      peg2 = new ModelRenderer(this, 78, 43);
      peg2.addBox(0F, 0F, 0F, 6, 6, 6);
      peg2.setRotationPoint(18F, -9F, 0F);
      peg2.setTextureSize(128, 128);
      peg2.mirror = true;
      setRotation(peg2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    peg1.render(f5);
    peg2.render(f5);
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
    leg1.rotateAngleX =  MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
  }

}
