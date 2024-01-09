package com.bittoastergames.projectfruit.main.client.lemon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSmallLemon extends ModelBase {
	// fields
	ModelRenderer body;
	ModelRenderer side1;
	ModelRenderer side2;
	ModelRenderer leg1;
	ModelRenderer leg2;

	public ModelSmallLemon() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this, 0, 0);
		body.addBox(0F, 0F, 0F, 10, 8, 5);
		body.setRotationPoint(-5F, 10F, -2F);
		body.setTextureSize(64, 64);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		side1 = new ModelRenderer(this, 0, 14);
		side1.addBox(0F, 0F, 0F, 1, 4, 3);
		side1.setRotationPoint(-6F, 12F, -1F);
		side1.setTextureSize(64, 64);
		side1.mirror = true;
		setRotation(side1, 0F, 0F, 0F);
		side2 = new ModelRenderer(this, 0, 14);
		side2.addBox(0F, 0F, 0F, 1, 4, 3);
		side2.setRotationPoint(5F, 12F, -1F);
		side2.setTextureSize(64, 64);
		side2.mirror = true;
		setRotation(side2, 0F, 0F, 0F);
		leg1 = new ModelRenderer(this, 14, 14);
		leg1.addBox(0F, 0F, 0F, 2, 6, 3);
		leg1.setRotationPoint(-4F, 18F, -1F);
		leg1.setTextureSize(64, 64);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 14, 14);
		leg2.addBox(0F, 0F, 0F, 2, 6, 3);
		leg2.setRotationPoint(2F, 18F, -1F);
		leg2.setTextureSize(64, 64);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		body.render(f5);
		side1.render(f5);
		side2.render(f5);
		leg1.render(f5);
		leg2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
		leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* 1.4F * f1;
	}

}
