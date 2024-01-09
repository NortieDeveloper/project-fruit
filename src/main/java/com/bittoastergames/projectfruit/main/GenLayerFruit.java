package com.bittoastergames.projectfruit.main;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayerFruit extends GenLayer {
	public GenLayerFruit(long seed) {
		super(seed);
	}

	public static GenLayer[] makeTheWorld(long seed) {

		GenLayer biomes = new GenLayerBiomesFruit(1L);

		// more GenLayerZoom = bigger biomes
		biomes = new GenLayerZoom(1000L, biomes);
		biomes = new GenLayerZoom(1001L, biomes);
		biomes = new GenLayerZoom(1002L, biomes);
		biomes = new GenLayerZoom(1003L, biomes);
		biomes = new GenLayerZoom(1004L, biomes);

		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);

		biomes.initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);

		return new GenLayer[] { biomes, genlayervoronoizoom };
	}
}