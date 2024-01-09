package com.bittoastergames.projectfruit.main;

import com.bittoastergames.projectfruit.blueberry.world.BiomeGenBlueberryBiome;
import com.bittoastergames.projectfruit.lemon.world.BiomeGenLemonBiome;
import com.bittoastergames.projectfruit.lime.world.BiomeGenLimeBiome;
import com.bittoastergames.projectfruit.orange.world.BiomeGenOrangeBiome;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.List;
import java.util.Random;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.*;

public class FruitChunkProvider implements IChunkProvider {
    private Random rand;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    private NoiseGeneratorPerlin noiseGen4;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    private World worldObj;
    private final boolean mapFeaturesEnabled;
    private WorldType worldType;
    private final double[] noiseField;
    private final float[] parabolicField;
    private double[] stoneNoise = new double[256];
    private MapGenBase caveGenerator = new MapGenCaves();
    private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
    private MapGenBase ravineGenerator = new MapGenRavine();
    private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
    private BiomeGenBase[] biomesForGeneration;
    double[] field_147427_d;
    double[] field_147428_e;
    double[] field_147425_f;
    double[] field_147426_g;
    int[][] field_73219_j = new int[32][32];

    {
        caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
/*strongholdGenerator = (MapGenStronghold) TerrainGen.getModdedMapGen(strongholdGenerator, STRONGHOLD);
villageGenerator = (MapGenVillage) TerrainGen.getModdedMapGen(villageGenerator, VILLAGE);*/
        mineshaftGenerator = (MapGenMineshaft) TerrainGen.getModdedMapGen(mineshaftGenerator, MINESHAFT);
        scatteredFeatureGenerator = (MapGenScatteredFeature) TerrainGen.getModdedMapGen(scatteredFeatureGenerator, SCATTERED_FEATURE);
        ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }
    public FruitChunkProvider(World par1World, long par2, boolean par4)
    {
        this.worldObj = par1World;
        this.mapFeaturesEnabled = par4;
        this.worldType = par1World.getWorldInfo().getTerrainType();
        this.rand = new Random(par2);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen4 = new NoiseGeneratorPerlin(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseField = new double[825];
        this.parabolicField = new float[25];

        for (int j = -2; j <= 2; j++)
        {
            for (int k = -2; k <= 2; k++)
            {
                float f = 10.0F / MathHelper.sqrt_float(j * j + k * k + 0.2F);
                this.parabolicField[(j + 2 + (k + 2) * 5)] = f;
            }
        }

        NoiseGenerator[] noiseGens = { this.noiseGen1, this.noiseGen2, this.noiseGen3, this.noiseGen4, this.noiseGen5, this.noiseGen6, this.mobSpawnerNoise };
        noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
        this.noiseGen1 = ((NoiseGeneratorOctaves)noiseGens[0]);
        this.noiseGen2 = ((NoiseGeneratorOctaves)noiseGens[1]);
        this.noiseGen3 = ((NoiseGeneratorOctaves)noiseGens[2]);
        this.noiseGen4 = ((NoiseGeneratorPerlin)noiseGens[3]);
        this.noiseGen5 = ((NoiseGeneratorOctaves)noiseGens[4]);
        this.noiseGen6 = ((NoiseGeneratorOctaves)noiseGens[5]);
        this.mobSpawnerNoise = ((NoiseGeneratorOctaves)noiseGens[6]);

    }

    public void generateTerrain(int par1, int par2, Block[] blocks)
    {
        byte b0 = 63;
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, 10, 10);
        initializeNoiseField(par1 * 4, 0, par2 * 4);

        for (int k = 0; k < 4; k++)
        {
            int l = k * 5;
            int i1 = (k + 1) * 5;

            for (int j1 = 0; j1 < 4; j1++)
            {
                int k1 = (l + j1) * 33;
                int l1 = (l + j1 + 1) * 33;
                int i2 = (i1 + j1) * 33;
                int j2 = (i1 + j1 + 1) * 33;

                for (int k2 = 0; k2 < 32; k2++)
                {
                    double d0 = 0.125D;
                    double d1 = this.noiseField[(k1 + k2)];
                    double d2 = this.noiseField[(l1 + k2)];
                    double d3 = this.noiseField[(i2 + k2)];
                    double d4 = this.noiseField[(j2 + k2)];
                    double d5 = (this.noiseField[(k1 + k2 + 1)] - d1) * d0;
                    double d6 = (this.noiseField[(l1 + k2 + 1)] - d2) * d0;
                    double d7 = (this.noiseField[(i2 + k2 + 1)] - d3) * d0;
                    double d8 = (this.noiseField[(j2 + k2 + 1)] - d4) * d0;

                    for (int l2 = 0; l2 < 8; l2++)
                    {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int i3 = 0; i3 < 4; i3++)
                        {
                            int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
                            short short1 = 256;
                            j3 -= short1;
                            double d14 = 0.25D;
                            double d16 = (d11 - d10) * d14;
                            double d15 = d10 - d16;

                            for (int k3 = 0; k3 < 4; k3++)
                            {
                                if ((d15 += d16) > 0.0D)
                                {
                                    blocks[j3 += short1] = Blocks.stone;
                                }
                                else if (k2 * 8 + l2 < b0)
                                {
                                    blocks[j3 += short1] = ProjectFruitRegistry.lemonadeBlock;
                                }
                                else
                                {
                                    blocks[j3 += short1] = Blocks.air;
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }


    /**
     * Replaces the stone that was placed in with blocks that match the biome
     */
    public void replaceBlocksForBiome(int chunkX, int chunkZ, Block[] par3ArrayOfBlock, byte[] p_147422_4_, BiomeGenBase[] par4ArrayOfBiomeGenBase)
    {
        ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, chunkX, chunkZ, par3ArrayOfBlock, par4ArrayOfBiomeGenBase);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Event.Result.DENY) return;

        double d0 = 0.03125D;
        this.stoneNoise = this.noiseGen4.func_151599_a(this.stoneNoise, chunkX * 16, chunkZ * 16, 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

        for (int k = 0; k < 16; k++)
        {
            for (int l = 0; l < 16; l++)
            {
                BiomeGenBase biomegenbase = par4ArrayOfBiomeGenBase[(l + k * 16)];
                biomegenbase.genTerrainBlocks(this.worldObj, this.rand, par3ArrayOfBlock, p_147422_4_, chunkX * 16 + k, chunkZ * 16 + l, this.stoneNoise[(l + k * 16)]);
            }
        }

    }
    /**
     * loads or generates the chunk at the chunk location specified
     */
    public Chunk loadChunk(int par1, int par2)
    {
        return this.provideChunk(par1, par2);
    }
    /**
     * Will return back a chunk, if it doesn’t exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int par1, int par2)
    {
        this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
        Block[] ablock = new Block[65536];
        byte[] abyte = new byte[65536];
        generateTerrain(par1, par2, ablock);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
        replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
        this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
        this.ravineGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);

        if (this.mapFeaturesEnabled)
        {
            this.mineshaftGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/*this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
this.strongholdGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);*/
            this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
        }

        Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
        byte[] abyte1 = chunk.getBiomeArray();

        for (int k = 0; k < abyte1.length; k++)
        {
            abyte1[k] = (byte)this.biomesForGeneration[k].biomeID;
        }

        chunk.generateSkylightMap();
        return chunk;
    }
    /**
     * generates a subset of the level’s terrain data. Takes 7 arguments: the [empty] noise array, the position, and the
     * size.
     */
    private void initializeNoiseField(int p_147423_1_, int p_147423_2_, int p_147423_3_)
    {
        this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
        this.field_147427_d = this.noiseGen3.generateNoiseOctaves(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
        this.field_147428_e = this.noiseGen1.generateNoiseOctaves(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.41200000000003D, 684.41200000000003D, 684.41200000000003D);
        this.field_147425_f = this.noiseGen2.generateNoiseOctaves(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.41200000000003D, 684.41200000000003D, 684.41200000000003D);
        int l = 0;
        int i1 = 0;

        for (int j1 = 0; j1 < 5; j1++)
        {
            for (int k1 = 0; k1 < 5; k1++)
            {
                float f = 0.0F;
                float f1 = 0.0F;
                float f2 = 0.0F;
                byte b0 = 2;
                BiomeGenBase biomegenbase = this.biomesForGeneration[(j1 + 2 + (k1 + 2) * 10)];

                for (int l1 = -b0; l1 <= b0; l1++)
                {
                    for (int i2 = -b0; i2 <= b0; i2++)
                    {
                        BiomeGenBase biomegenbase1 = this.biomesForGeneration[(j1 + l1 + 2 + (k1 + i2 + 2) * 10)];
                        float f3 = biomegenbase1.rootHeight;
                        float f4 = biomegenbase1.heightVariation;

                        if ((this.worldType == WorldType.AMPLIFIED) && (f3 > 0.0F))
                        {
                            f3 = 1.0F + f3 * 2.0F;
                            f4 = 1.0F + f4 * 4.0F;
                        }

                        float f5 = this.parabolicField[(l1 + 2 + (i2 + 2) * 5)] / (f3 + 2.0F);

                        if (biomegenbase1.rootHeight > biomegenbase.rootHeight)
                        {
                            f5 /= 2.0F;
                        }

                        f += f4 * f5;
                        f1 += f3 * f5;
                        f2 += f5;
                    }
                }

                f /= f2;
                f1 /= f2;
                f = f * 0.9F + 0.1F;
                f1 = (f1 * 4.0F - 1.0F) / 8.0F;
                double d13 = this.field_147426_g[i1] / 8000.0D;

                if (d13 < 0.0D)
                {
                    d13 = -d13 * 0.3D;
                }

                d13 = d13 * 3.0D - 2.0D;

                if (d13 < 0.0D)
                {
                    d13 /= 2.0D;

                    if (d13 < -1.0D)
                    {
                        d13 = -1.0D;
                    }

                    d13 /= 1.4D;
                    d13 /= 2.0D;
                }
                else
                {
                    if (d13 > 1.0D)
                    {
                        d13 = 1.0D;
                    }

                    d13 /= 8.0D;
                }

                i1++;
                double d12 = f1;
                double d14 = f;
                d12 += d13 * 0.2D;
                d12 = d12 * 8.5D / 8.0D;
                double d5 = 8.5D + d12 * 4.0D;

                for (int j2 = 0; j2 < 33; j2++)
                {
                    double d6 = (j2 - d5) * 12.0D * 128.0D / 256.0D / d14;

                    if (d6 < 0.0D)
                    {
                        d6 *= 4.0D;
                    }

                    double d7 = this.field_147428_e[l] / 512.0D;
                    double d8 = this.field_147425_f[l] / 512.0D;
                    double d9 = (this.field_147427_d[l] / 10.0D + 1.0D) / 2.0D;
                    double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;

                    if (j2 > 29)
                    {
                        double d11 = (j2 - 29) / 3.0F;
                        d10 = d10 * (1.0D - d11) + -10.0D * d11;
                    }

                    this.noiseField[l] = d10;
                    l++;
                }
            }
        }
    }
    /**
     * Checks to see if a chunk exists at x, y
     */
    public boolean chunkExists(int par1, int par2)
    {
        return true;
    }
    /**
     * Populates chunk with ores etc etc
     */
    public void populate(IChunkProvider par1IChunkProvider, int par2, int par3)
    {
        BlockFalling.fallInstantly = true;
        int k = par2 * 16;
        int l = par3 * 16;
        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
        this.rand.setSeed(this.worldObj.getSeed());
        long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        long j1 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)par2 * i1 + (long)par3 * j1 ^ this.worldObj.getSeed());
        boolean flag = false;

        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(par1IChunkProvider, worldObj, rand, par2, par3, flag));

        if (this.mapFeaturesEnabled)
        {
            this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
/*flag = this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);*/
            this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
        }

        int k1;
        int l1;
        int i2;

        if (biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills && !flag && this.rand.nextInt(4) == 0
                && TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, LAKE))
        {
            k1 = k + this.rand.nextInt(16) + 8;
            l1 = this.rand.nextInt(256);
            i2 = l + this.rand.nextInt(16) + 8;
            (new WorldGenLakes(ProjectFruitRegistry.lemonadeBlock)).generate(this.worldObj, this.rand, k1, l1, i2);
        }

        if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, LAVA) && !flag && this.rand.nextInt(8) == 0)
        {
            k1 = k + this.rand.nextInt(16) + 8;
            l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
            i2 = l + this.rand.nextInt(16) + 8;

            if (l1 < 63 || this.rand.nextInt(10) == 0)
            {
                (new WorldGenLakes(Blocks.lava)).generate(this.worldObj, this.rand, k1, l1, i2);
            }
        }

        boolean doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, DUNGEON);
        for (k1 = 0; doGen && k1 < 8; ++k1)
        {
            l1 = k + this.rand.nextInt(16) + 8;
            i2 = this.rand.nextInt(256);
            int j2 = l + this.rand.nextInt(16) + 8;
            (new WorldGenDungeons()).generate(this.worldObj, this.rand, l1, i2, j2);
        }

        biomegenbase.decorate(this.worldObj, this.rand, k, l);
        SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
        k += 8;
        l += 8;
        doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, ICE);
        for (k1 = 0; doGen && k1 < 16; ++k1)
        {
            for (l1 = 0; l1 < 16; ++l1)
            {
                i2 = this.worldObj.getPrecipitationHeight(k + k1, l + l1);

                if (this.worldObj.isBlockFreezable(k1 + k, i2 - 1, l1 + l))
                {
                    this.worldObj.setBlock(k1 + k, i2 - 1, l1 + l, Blocks.ice, 0, 2);
                }
                if (this.worldObj.func_147478_e(k1 + k, i2, l1 + l, true))
                {
                    this.worldObj.setBlock(k1 + k, i2, l1 + l, Blocks.snow, 0, 2);
                }
            }
        }
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, worldObj, rand, par2, par3, flag));

        BlockFalling.fallInstantly = false;
    }
    /**
     * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
     * Return true if all chunks have been saved.
     */
    public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate)
    {
        return true;
    }

    /**
     * Unloads chunks that are marked to be unloaded. This is not guaranteed to unload every such chunk.
     */
    public boolean unloadQueuedChunks()
    {
        return false;
    }
    /**
     * Returns if the IChunkProvider supports saving.
     */
    public boolean canSave()
    {
        return true;
    }
    /**
     * Converts the instance data to a readable string.
     */
    public String makeString()
    {
        return "LWRandomLevelSource";
    }
    /**
     * Returns a list of creatures of the specified type that can spawn at the given location.
     */
    public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4)
    {
        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(par2, par4);
        BiomeGenLemonBiome lemonbiome = new BiomeGenLemonBiome(0);
        BiomeGenLimeBiome limebiome = new BiomeGenLimeBiome(0);
        BiomeGenOrangeBiome orangeBiome = new BiomeGenOrangeBiome(0);
        BiomeGenBlueberryBiome blueberryBiome = new BiomeGenBlueberryBiome(0);

        if(biomegenbase.biomeName.contains("Lemon")){
            return lemonbiome.getSpawnableList(par1EnumCreatureType);
        }

        if(biomegenbase.biomeName.contains("Lime")){
            return limebiome.getSpawnableList(par1EnumCreatureType);
        }

        if(biomegenbase.biomeName.contains("Orange")){
            return orangeBiome.getSpawnableList(par1EnumCreatureType);
        }

        if(biomegenbase.biomeName.contains("Blueberry")){
            return blueberryBiome.getSpawnableList(par1EnumCreatureType);
        }

        return null;

    }

    @Override
    public ChunkPosition func_147416_a(World var1, String var2, int var3, int var4, int var5) {
        return null;
    }

    public int getLoadedChunkCount()
    {
        return 0;
    }
    public void recreateStructures(int par1, int par2)
    {
        if (this.mapFeaturesEnabled)
        {
            this.mineshaftGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[]) null);
/*this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[]) null);
this.strongholdGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[]) null);*/
            this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[]) null);
        }
    }

    /**
     * Save extra data not associated with any Chunk.  Not saved during autosave, only during world unload.  Currently
     * unimplemented.
     */
    @Override
    public void saveExtraData() {

    }
}