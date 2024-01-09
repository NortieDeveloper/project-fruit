package com.bittoastergames.projectfruit.orange.world;

import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import com.bittoastergames.projectfruit.orange.entities.EntitySmallOrange;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeGenOrangeBiomeHills extends BiomeGenBase {

	private WorldGenerator WorldGenOrangeTree;

    private static final Height biomeHeight = new Height(0.7F, 1.0F);
	
	public BiomeGenOrangeBiomeHills(int par1)
    {
        super(par1);
        this.setHeight(biomeHeight);
        this.topBlock = ProjectFruitRegistry.orangeGrass;
        this.fillerBlock = Blocks.stone;
        this.theBiomeDecorator.treesPerChunk = 15;
        this.WorldGenOrangeTree = new WorldGenOrangeTree(false);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySmallOrange.class , 10, 1, 6));
    }

    public WorldGenAbstractTree func_150567_a(Random par1Random) {
        return (WorldGenAbstractTree) (par1Random.nextInt(10) == 0 ? this.WorldGenOrangeTree : this.worldGeneratorTrees);
    }

    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);

    }
	
}
