package com.bittoastergames.projectfruit.main;

import com.bittoastergames.projectfruit.blueberry.world.WorldGenBlueberryBush;
import com.bittoastergames.projectfruit.lemon.world.WorldGenLemonHouse;
import com.bittoastergames.projectfruit.lemon.world.WorldGenLemonTree;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class WorldGeneratorFruitDimension implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
	IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
	if(world.provider.dimensionId == 0)//surface
	{
	this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
	}
	else if(world.provider.dimensionId == -1)//End
	{
	this.generateEnd(world, random, chunkX * 16, chunkZ * 16);
	}
	else if(world.provider.dimensionId == 1)//Nether
	{
	generateNether(world, random, chunkX * 16, chunkZ * 16);
	}
	else if(world.provider.dimensionId == 37)//Fruit
	{
	this.generateFruitDim(world, random, chunkX * 16, chunkZ * 16);
	}
	}

	private void generateSurface(World world, Random random, int chunkX,
			int chunkZ) {
		
		for (int i = 0; i < 10; i++) {
			int xCoord1 = chunkX + random.nextInt(16);
			int yCoord1 = random.nextInt(90);
			int zCoord1 = chunkZ + random.nextInt(16);
			(new WorldGenLemonTree(false, 4, 0, 0, false)).generate(world,
					random, xCoord1, yCoord1, zCoord1);
		}
		
	}
	

	private void generateNether(World world, Random random, int chunkX,
			int chunkZ) {
	}

	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
	}
	
	private void generateFruitDim(World world, Random random, int chunkX,
			int chunkZ) {
		for (int i = 0; i < ProjectFruitRegistry.lemonStoneOreRarity; i++) {
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(16);
			int zCoord = chunkZ + random.nextInt(16);
			(new WorldGenMinable(ProjectFruitRegistry.lemonStoneOre, 8))
					.generate(world, random, xCoord, yCoord, zCoord);
		}
		
		for (int i = 0; i < ProjectFruitRegistry.limeStoneOreRarity; i++) {
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(16);
			int zCoord = chunkZ + random.nextInt(16);
			(new WorldGenMinable(ProjectFruitRegistry.limeStoneOre, 6))
					.generate(world, random, xCoord, yCoord, zCoord);
		}
		
		for (int i = 0; i < ProjectFruitRegistry.blueberryStoneOreRarity; i++) {
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(16);
			int zCoord = chunkZ + random.nextInt(16);
			(new WorldGenMinable(ProjectFruitRegistry.blueberryStoneBlock, 5))
					.generate(world, random, xCoord, yCoord, zCoord);
		}
		
		for (int i = 0; i < ProjectFruitRegistry.orangeStoneOreRarity; i++) {
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(16);
			int zCoord = chunkZ + random.nextInt(16);
			(new WorldGenMinable(ProjectFruitRegistry.orangeStoneBlock, 5))
					.generate(world, random, xCoord, yCoord, zCoord);
		}


		for (int i = 0; i < ProjectFruitRegistry.lemonHouseRarity; i++) {
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(98);
			int zCoord = chunkZ + random.nextInt(16);
			(new WorldGenLemonHouse()).generate(world, random, xCoord,
					yCoord, zCoord);
		}
		
		for (int i = 0; i < 64; i++) {
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(98);
			int zCoord = chunkZ + random.nextInt(16);
			(new WorldGenBlueberryBush()).generate(world, random, xCoord,
					yCoord, zCoord);
		}
	}
}
