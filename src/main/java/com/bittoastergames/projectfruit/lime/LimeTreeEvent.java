package com.bittoastergames.projectfruit.lime;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import com.bittoastergames.projectfruit.lime.blocks.BlockLimeSapling;
import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class LimeTreeEvent {
	private int BlockID;

	/** Used to make the sapling grow the tree **/
	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event) {
		if (event.world.getBlock(event.x, event.y, event.z) == ProjectFruitRegistry.limeSapling) {
			((BlockLimeSapling) ProjectFruitRegistry.limeSapling).growTree(event.world,
					event.x, event.y, event.z, event.world.rand);
			event.setResult(Result.ALLOW);
		}
	}
}
