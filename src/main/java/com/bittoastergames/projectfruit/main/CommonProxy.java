package com.bittoastergames.projectfruit.main;

import com.bittoastergames.projectfruit.lemon.entities.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.bittoastergames.projectfruit.lime.entities.EntityLime;
import com.bittoastergames.projectfruit.orange.entities.EntitySmallOrange;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy implements IGuiHandler {
        
	public void registerRenderInformation(){}
	
	public void init(){
    	EntityRegistry.registerGlobalEntityID(EntityLemonator.class, "Lemonator", EntityRegistry.findGlobalUniqueEntityId(), 0xFFF700, 0xF0E805);
    	EntityRegistry.registerGlobalEntityID(EntitySmallLemon.class, "Tiny Lemon", EntityRegistry.findGlobalUniqueEntityId(), 0xFFF700, 0xF0E805);
    	EntityRegistry.registerGlobalEntityID(EntityKingLemonator.class, "King Lemonator", EntityRegistry.findGlobalUniqueEntityId(), 0xFFF700, 0xF0E805);
    	EntityRegistry.registerGlobalEntityID(EntityLemonCow.class, "Lemon Cow", EntityRegistry.findGlobalUniqueEntityId(), 0xFFF700, 0xBDBBBC);
    	EntityRegistry.registerGlobalEntityID(EntityFlyingLemon.class, "FlyingLemon", EntityRegistry.findGlobalUniqueEntityId(), 0xFFF700, 0xF0E805);
    	EntityRegistry.registerModEntity(EntityLemonArrow.class, "LemonArrow", 51, ProjectFruit.instance, 128, 5, true);
    	EntityRegistry.registerGlobalEntityID(EntityLime.class, "Lime", EntityRegistry.findGlobalUniqueEntityId(), 0x32AB22, 0x3CC22B);
    	EntityRegistry.registerGlobalEntityID(EntitySmallOrange.class, "Small Orange", EntityRegistry.findGlobalUniqueEntityId(), 0xE78B00, 0xE79820);
        EntityRegistry.registerGlobalEntityID(EntityPoshLemonator.class, "Posh Lemonator", EntityRegistry.findGlobalUniqueEntityId(), 0xFFF700, 0xF0E805);
    	registerRenderInformation();
    }
	
	
        // Client stuff
        public void registerRenderers() {
                // Nothing here as the server doesn't render graphics!
        }

		@Override
		public Object getServerGuiElement(int ID, EntityPlayer player,
				World world, int x, int y, int z) {
			return null;
		}

		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player,
				World world, int x, int y, int z) {
			return null;
		}

}