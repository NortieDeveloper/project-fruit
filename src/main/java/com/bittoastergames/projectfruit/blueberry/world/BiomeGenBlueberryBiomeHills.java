package com.bittoastergames.projectfruit.blueberry.world;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

public class BiomeGenBlueberryBiomeHills extends BiomeGenBase{

    private static final Height biomeHeight = new Height(0.7F, 1.0F);

	public BiomeGenBlueberryBiomeHills(int par1)
    {
        super(par1);
        this.setHeight(biomeHeight);
        this.topBlock = ProjectFruitRegistry.blueberryGrass;
        this.fillerBlock = Blocks.stone;
        this.theBiomeDecorator.treesPerChunk = 15;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
    }
	
    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);

    }
	
}
