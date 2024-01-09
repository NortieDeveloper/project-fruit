package com.bittoastergames.projectfruit.lemon.world;

import com.bittoastergames.projectfruit.lemon.entities.EntityKingLemonator;
import com.bittoastergames.projectfruit.lemon.entities.EntityLemonCow;
import com.bittoastergames.projectfruit.lemon.entities.EntityLemonator;
import com.bittoastergames.projectfruit.lemon.entities.EntityPoshLemonator;
import com.bittoastergames.projectfruit.main.ProjectFruitRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;


public class BiomeGenLemonBiome extends BiomeGenBase {
    private WorldGenerator WorldGenLemonTree;

    private static final Height biomeHeight = new Height(0.0F, 0.4F);

    public BiomeGenLemonBiome(int par1) {
        super(par1);
        this.setHeight(biomeHeight);
        this.topBlock = ProjectFruitRegistry.lemonilium;
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator.treesPerChunk = 15;
        this.WorldGenLemonTree = new WorldGenLemonTree(false);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityLemonCow.class, 8, 2, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityLemonator.class, 18, 2, 6));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityKingLemonator.class, 1, 0, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityPoshLemonator.class, 1, 0, 1));
        //this.spawnableCreatureList.add(new SpawnListEntry(EntitySmallLemon.class, 1, 0, 2));
    }

    public WorldGenAbstractTree func_150567_a(Random par1Random) {
        return (WorldGenAbstractTree) (par1Random.nextInt(10) == 0 ? this.WorldGenLemonTree : this.worldGeneratorTrees);
    }

    public void decorate(World par1World, Random par2Random, int par3, int par4) {
        super.decorate(par1World, par2Random, par3, par4);
    }
}
