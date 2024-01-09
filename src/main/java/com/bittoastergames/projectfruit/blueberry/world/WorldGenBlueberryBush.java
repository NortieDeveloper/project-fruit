package com.bittoastergames.projectfruit.blueberry.world;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenBlueberryBush extends WorldGenerator
{
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] {
			ProjectFruitRegistry.blueberryGrass
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		Block checkID = world.getBlock(i, j, k);

		while (checkID != Blocks.air){
			distanceToAir++;
			checkID = world.getBlock(i, j + distanceToAir, k);
		}

		if (distanceToAir > 0){
			return false;
		}
		j += distanceToAir - 1;

		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j+1, k);
        Block blockIDBelow = world.getBlock(i, j-1, k);
		for (Block x : GetValidSpawnBlocks()){
			if (blockIDAbove != Blocks.air){
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Blocks.snow && blockIDBelow == x){
				return true;
			}
		}
		return false;
	}

	public WorldGenBlueberryBush() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 0, j, k) || !LocationIsValidSpawn(world, i + 0, j, k + 0) || !LocationIsValidSpawn(world, i, j, k + 0))
		{
			return false;
		}

		world.setBlock(i + 0, j + 0, k + 0, ProjectFruitRegistry.blueberryBushGrown);
		
		return true;
	}
}
