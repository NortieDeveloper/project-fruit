package com.bittoastergames.projectfruit.main.client;

import com.bittoastergames.projectfruit.blueberry.blocks.TileEntityBlueberryBushEntity;
import com.bittoastergames.projectfruit.blueberry.blocks.TileEntityBlueberryBushGrownEntity;
import com.bittoastergames.projectfruit.blueberry.blocks.TileEntityBlueberryBushGrownRenderer;
import com.bittoastergames.projectfruit.blueberry.blocks.TileEntityBlueberryBushRenderer;
import com.bittoastergames.projectfruit.lemon.entities.*;
import com.bittoastergames.projectfruit.lime.entities.EntityLime;
import com.bittoastergames.projectfruit.main.CommonProxy;
import com.bittoastergames.projectfruit.main.client.lemon.*;
import com.bittoastergames.projectfruit.main.client.lime.ModelLime;
import com.bittoastergames.projectfruit.main.client.lime.RenderLime;
import com.bittoastergames.projectfruit.main.client.orange.ModelSmallOrange;
import com.bittoastergames.projectfruit.main.client.orange.RenderSmallOrange;
import com.bittoastergames.projectfruit.orange.entities.EntitySmallOrange;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
        
	
	public void registerRenderInformation(){
		RenderingRegistry.registerEntityRenderingHandler(EntityLemonator.class, new RenderLemonator(new ModelLemonator(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallLemon.class, new RenderSmallLemon(new ModelSmallLemon(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLemonCow.class, new RenderLemonCow(new ModelLemonCow(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingLemon.class, new RenderFlyingLemon(new ModelFlyingLemon(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLemonArrow.class, new RenderLemonArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveLemon.class, new RenderExplosiveLemon(0));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingLemonExplosive.class, new RenderFlyingLemonExplosive(0));
		RenderingRegistry.registerEntityRenderingHandler(EntityKingLemonator.class, new RenderKingLemonator(new ModelKingLemonator(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLime.class, new RenderLime(new ModelLime(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallOrange.class, new RenderSmallOrange(new ModelSmallOrange(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPoshLemonator.class, new RenderPoshLemonator(new ModelPoshLemonator(), 1.0F));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlueberryBushEntity.class, new TileEntityBlueberryBushRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlueberryBushGrownEntity.class, new TileEntityBlueberryBushGrownRenderer());
	}
	
        @Override
        public void registerRenderers() {
                
        }
        
}