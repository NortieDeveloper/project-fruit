package com.bittoastergames.projectfruit.lime.world;

import com.bittoastergames.projectfruit.lime.entities.EntityLime;
import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeGenLimeBiomeHills extends BiomeGenBase {

	private WorldGenerator WorldGenLimeTree;

    private static final Height biomeHeight = new Height(0.7F, 1.0F);
	
	public BiomeGenLimeBiomeHills(int par1)
    {
        super(par1);
        this.setHeight(biomeHeight);
        this.topBlock = ProjectFruitRegistry.limeGrass;
        this.fillerBlock = Blocks.stone;
        this.theBiomeDecorator.treesPerChunk = 15;
        this.WorldGenLimeTree = new WorldGenLimeTree(false);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityLime.class, 20, 1, 3));
    }

    public WorldGenAbstractTree func_150567_a(Random par1Random) {
        return (WorldGenAbstractTree) (par1Random.nextInt(10) == 0 ? this.WorldGenLimeTree : this.worldGeneratorTrees);
    }

    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);

    }
	
}
