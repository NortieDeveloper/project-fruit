package com.bittoastergames.projectfruit.main.client.orange;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelSmallOrange extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer face;
    ModelRenderer Shape4;
    ModelRenderer shape13;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer shape11;
    ModelRenderer Shape12;
    ModelRenderer leg;
    ModelRenderer leg2;
  
  public ModelSmallOrange()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 12, 12, 12);
      Shape1.setRotationPoint(-6F, 0F, -6F);
      Shape1.setTextureSize(128, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 10, 10, 1);
      Shape2.setRotationPoint(-5F, 1F, -7F);
      Shape2.setTextureSize(128, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      face = new ModelRenderer(this, 50, 7);
      face.addBox(0F, 0F, 0F, 8, 8, 1);
      face.setRotationPoint(-4F, 2F, -8F);
      face.setTextureSize(128, 32);
      face.mirror = true;
      setRotation(face, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 10, 10);
      Shape4.setRotationPoint(-7F, 1F, -5F);
      Shape4.setTextureSize(128, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      shape13 = new ModelRenderer(this, 0, 0);
      shape13.addBox(0F, 0F, 0F, 1, 8, 8);
      shape13.setRotationPoint(-8F, 2F, -4F);
      shape13.setTextureSize(128, 32);
      shape13.mirror = true;
      setRotation(shape13, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 0);
      Shape5.addBox(0F, 0F, 0F, 10, 10, 1);
      Shape5.setRotationPoint(-5F, 1F, 6F);
      Shape5.setTextureSize(128, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 0);
      Shape6.addBox(0F, 0F, 0F, 8, 8, 1);
      Shape6.setRotationPoint(-4F, 2F, 7F);
      Shape6.setTextureSize(128, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 0);
      Shape7.addBox(0F, 0F, 0F, 1, 10, 10);
      Shape7.setRotationPoint(6F, 1F, -5F);
      Shape7.setTextureSize(128, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 0);
      Shape9.addBox(0F, 0F, 0F, 1, 8, 8);
      Shape9.setRotationPoint(7F, 2F, -4F);
      Shape9.setTextureSize(128, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 0, 0);
      Shape10.addBox(0F, 0F, 0F, 10, 1, 10);
      Shape10.setRotationPoint(-5F, 12F, -5F);
      Shape10.setTextureSize(128, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      shape11 = new ModelRenderer(this, 0, 0);
      shape11.addBox(0F, 0F, 0F, 8, 1, 8);
      shape11.setRotationPoint(-4F, -2F, -4F);
      shape11.setTextureSize(128, 32);
      shape11.mirror = true;
      setRotation(shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 0);
      Shape12.addBox(0F, 0F, 0F, 10, 1, 10);
      Shape12.setRotationPoint(-5F, -1F, -5F);
      Shape12.setTextureSize(128, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      leg = new ModelRenderer(this, 0, 0);
      leg.addBox(0F, 0F, 0F, 3, 12, 4);
      leg.setRotationPoint(-4F, 12F, -2F);
      leg.setTextureSize(128, 32);
      leg.mirror = true;
      setRotation(leg, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 0);
      leg2.addBox(0F, 0F, 0F, 3, 12, 4);
      leg2.setRotationPoint(1F, 12F, -2F);
      leg2.setTextureSize(128, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
    face.render(f5);
    Shape4.render(f5);
    shape13.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    shape11.render(f5);
    Shape12.render(f5);
    leg.render(f5);
    leg2.render(f5);
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
    leg.rotateAngleX =  MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
  }

}
