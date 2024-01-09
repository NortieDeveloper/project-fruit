package com.bittoastergames.projectfruit.lemon;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraftforge.event.entity.player.BonemealEvent;

import com.bittoastergames.projectfruit.lemon.blocks.BlockLemonSapling;
import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;

public class LemonTreeEvent {
	private int BlockID;

	/** Used to make the sapling grow the tree **/
	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event) {
		if (event.world.getBlock(event.x, event.y, event.z) == ProjectFruitRegistry.lemonSapling) {
			((BlockLemonSapling) ProjectFruitRegistry.lemonSapling).growTree(event.world,
					event.x, event.y, event.z, event.world.rand);
			event.setResult(Result.ALLOW);
		}
	}
}
