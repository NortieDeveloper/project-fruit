package com.bittoastergames.projectfruit.orange;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import com.bittoastergames.projectfruit.orange.blocks.BlockOrangeSapling;

public class OrangeTreeEvent {
	private int BlockID;

	/** Used to make the sapling grow the tree **/
	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event) {
		if (event.world.getBlock(event.x, event.y, event.z) == ProjectFruitRegistry.orangeSapling) {
			((BlockOrangeSapling) ProjectFruitRegistry.orangeSapling).growTree(event.world,
					event.x, event.y, event.z, event.world.rand);
			event.setResult(Result.ALLOW);
		}
	}
}
