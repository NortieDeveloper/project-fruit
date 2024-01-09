package com.bittoastergames.projectfruit.main;

import com.bittoastergames.projectfruit.blueberry.blocks.BlockBlueberryGrass;
import com.bittoastergames.projectfruit.blueberry.blocks.BlockBlueberryStone;
import com.bittoastergames.projectfruit.blueberry.blocks.TileEntityBlueberryBushBlock;
import com.bittoastergames.projectfruit.blueberry.blocks.TileEntityBlueberryBushGrownBlock;
import com.bittoastergames.projectfruit.blueberry.items.*;
import com.bittoastergames.projectfruit.blueberry.world.BiomeGenBlueberryBiome;
import com.bittoastergames.projectfruit.blueberry.world.BiomeGenBlueberryBiomeHills;
import com.bittoastergames.projectfruit.lemon.LemonArmor;
import com.bittoastergames.projectfruit.lemon.LemonadeFluid;
import com.bittoastergames.projectfruit.lemon.blocks.*;
import com.bittoastergames.projectfruit.lemon.items.*;
import com.bittoastergames.projectfruit.lemon.world.BiomeGenLemonBiome;
import com.bittoastergames.projectfruit.lemon.world.BiomeGenLemonBiomeHills;
import com.bittoastergames.projectfruit.lemonlime.items.*;
import com.bittoastergames.projectfruit.lime.blocks.BlockLimeGrass;
import com.bittoastergames.projectfruit.lime.blocks.BlockLimeLeaves;
import com.bittoastergames.projectfruit.lime.blocks.BlockLimeSapling;
import com.bittoastergames.projectfruit.lime.blocks.BlockLimeStone;
import com.bittoastergames.projectfruit.lime.items.*;
import com.bittoastergames.projectfruit.lime.world.BiomeGenLimeBiome;
import com.bittoastergames.projectfruit.lime.world.BiomeGenLimeBiomeHills;
import com.bittoastergames.projectfruit.orange.blocks.BlockOrangeGrass;
import com.bittoastergames.projectfruit.orange.blocks.BlockOrangeLeaves;
import com.bittoastergames.projectfruit.orange.blocks.BlockOrangeSapling;
import com.bittoastergames.projectfruit.orange.blocks.BlockOrangeStone;
import com.bittoastergames.projectfruit.orange.items.*;
import com.bittoastergames.projectfruit.orange.world.BiomeGenOrangeBiome;
import com.bittoastergames.projectfruit.orange.world.BiomeGenOrangeBiomeHills;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class ProjectFruitRegistry {
	
	public static CreativeTabs tabFruit = new CreativeTabs("tabFruit") {
        @Override
        public Item getTabIconItem() {
            return lemon;
        }
    };
    
	public static boolean useBigExplosion;

    public static boolean showToolTips;

    /////////////////////ID/////////////////////////
    // Lemon Sword
    public static Item lemonSword;

    // Lemon Bow
    public static Item lemonBow;

    // Lemon Arrow
    public static Item lemonArrow;

    // Lemon Pickaxe
    public static Item lemonPickaxe;

    // Lemon Axe
    public static Item lemonAxe;

    // Lemon Shovel
    public static Item lemonShovel;

    // Lemon Hoe
    public static Item lemonHoe;

    // Lemon Stone
    public static Item lemonStone;

    // Lemon Stone Block
    public static Block lemonStoneOre;

    // Lemonilium
    public static Block lemonilium;

    // Lemon Sapling
    public static Block lemonSapling;

    // Lemon Leaves
    public static Block lemonLeaves;

    public static Block lemonBrick;

    public static Block lemonadeBlock;

    public static Fluid lemonadeFluid;

    // Lemon
    public static Item lemon;

    // Explosive Lemon
    public static Item explosiveLemon;

    //Lemonade
    public static Item lemonade;

    //Lemon helemet
    public static Item lemonHelmet;

    //Lemon chestplate
    public static Item lemonChestplate;

    //Lemon leggings
    public static Item lemonLeggings;

    //Lemon boots
    public static Item lemonBoots;
    /////////////////////////////////////////////

    //LEMONLIME//

    public static Item lemonLimeSword;

    public static Item lemonLimePickaxe;

    public static Item lemonLimeAxe;

    public static Item lemonLimeShovel;

    public static Item lemonLimeHoe;

    //LEMONLIME//

    ////////////////////LIME STUFF/////////////////////////

    public static Block limeGrass;

    public static Item lime;

    public static Item limeStone;

    public static Item limeSword;
    
    public static Item limePickaxe;
    
    public static Item limeAxe;
    
    public static Item limeShovel;
    
    public static Item limeHoe;
    
    public static Block limeStoneOre;

    public static Block limeLeaves;

    public static Block limeSapling;

    ////////////////////////////////////////////

    /////////////////ORANGE STUFF///////////////

    public static Block orangeGrass;

    public static Item orange;

    public static Block orangeLeaves;

    public static Block orangeSapling;

    public static Item orangeJuice;

    public static Item orangeAxe;
    
    public static Item orangeHoe;
    
    public static Item orangePickaxe;
    
    public static Item orangeShovel;
    
    public static Item orangeSword;
    
    public static Item orangeStone;
    
    public static Block orangeStoneBlock;
    
    //////////////////////////////////////////
    
    //////////////////BLUEBERRY//////////////
    
    public static Item blueberry;
    
    public static Item blueberrySword;
    
    public static Item blueberryStone;
    
    public static Item blueberryPickaxe;
    
    public static Item blueberryAxe;
    
    public static Item blueberryShovel;
    
    public static Item blueberryHoe;
    
    public static Block blueberryStoneBlock;
    
    public static Block blueberryGrass;
    
    public static Block blueberryBush;
    
    public static Block blueberryBushGrown;
    
    ////////////////////////////////////////

    //////////Portal Stuff////////////////
    public static BlockFruitPortal fruitPortal;

    public static int dimID = 37;
    //////////////////////////////////////

    public static int lemonBiomeID, lemonBiomeHillsID, limeBiomeID, limeBiomeHillsID, orangeBiomeID, orangeBiomeHillsID, blueberryBiomeID,
    blueberryBiomeHillsID;

    public static int lemonStoneOreRarity, limeStoneOreRarity, orangeStoneOreRarity, blueberryStoneOreRarity;

    public static int lemonHouseRarity;

    public static ToolMaterial lemonstoneTool = EnumHelper.addToolMaterial("Lemonstone", 2, 1856, 5.0F, 7.0F, 7);

    public static ToolMaterial lemonLimeStoneTool = EnumHelper.addToolMaterial("Lemonlimestone", 2, 1500, 10.0F, 8.0F, 10);

    public static ToolMaterial blueberryStoneTool = EnumHelper.addToolMaterial("BlueberryStone", 3, 3000, 4.0F, 5.0F, 6);

    public static ToolMaterial limeStoneTool = EnumHelper.addToolMaterial("LimeStone", 1, 1256, 12.0F, 9.0F, 10);

    public static ToolMaterial orangeStoneTool = EnumHelper.addToolMaterial("OrangeStone", 0, 2652, 10.0F, 6.0F, 8);

    public static ArmorMaterial lemonstoneArmor = EnumHelper.addArmorMaterial("Lemonstone", 44, new int[]{3, 8, 6, 3}, 10);
    
    public static Material materialLemonade;
    
    public static BiomeGenBase lemonBiome, lemonBiomeHills, limeBiome, limeBiomeHills, orangeBiome, orangeBiomeHills, blueberryBiome, blueberryBiomeHills;
	
    public static void init(){
    	registerItems();
    	registerBlocks();
    	registerFluids();
    	registerBiomes();
    	registerGameRegistry();
    }
    
    public static void registerConfig(FMLPreInitializationEvent event){
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();

        /////////////////////////////////LEMON STUFF///////////////////////////////////
        useBigExplosion = config.get(Configuration.CATEGORY_GENERAL, "useBigExplosion", false).getBoolean(false);

        showToolTips = config.get(Configuration.CATEGORY_GENERAL, "showToolTips", true).getBoolean(true);

        lemonBiomeID = config.get(Configuration.CATEGORY_GENERAL, "lemonBiomeID", 50).getInt();

        lemonBiomeHillsID = config.get(Configuration.CATEGORY_GENERAL, "lemonBiomeHillsID", 53).getInt();

        limeBiomeID = config.get(Configuration.CATEGORY_GENERAL, "limeBiomeID", 51).getInt();

        limeBiomeHillsID = config.get(Configuration.CATEGORY_GENERAL, "limeBiomeHillsID", 54).getInt();

        orangeBiomeID = config.get(Configuration.CATEGORY_GENERAL, "orangeBiomeID", 52).getInt();

        orangeBiomeHillsID = config.get(Configuration.CATEGORY_GENERAL, "orangeBiomeHillsID", 55).getInt();

        blueberryBiomeID = config.get(Configuration.CATEGORY_GENERAL, "blueberryBiomeID", 56).getInt();

        blueberryBiomeHillsID = config.get(Configuration.CATEGORY_GENERAL, "blueberryBiomeHillsID", 57).getInt();

        lemonStoneOreRarity = config.get(Configuration.CATEGORY_GENERAL, "lemonStoneOreRarity", 4).getInt();

        limeStoneOreRarity = config.get(Configuration.CATEGORY_GENERAL, "limeStoneOreRarity", 4).getInt();

        orangeStoneOreRarity = config.get(Configuration.CATEGORY_GENERAL, "orangeStoneRarity", 4).getInt();

        blueberryStoneOreRarity = config.get(Configuration.CATEGORY_GENERAL, "blueberryStoneOreRarity", 4).getInt();

        lemonHouseRarity = config.get(Configuration.CATEGORY_GENERAL, "lemonHouseRarity", 3).getInt();

        config.save();

    }

    public static void registerItems(){

        //LEMON STUFF//
        lemonSword = new ItemLemonSword(lemonstoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lemon_sword");

        lemonBow = new ItemLemonBow().setMaxStackSize(1).setUnlocalizedName("projectfruit:lemon_bow");

        lemonArrow = new ItemLemonArrow().setMaxStackSize(64).setUnlocalizedName("projectfruit:lemon_arrow");

        lemonPickaxe = new ItemLemonPickaxe(lemonstoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lemon_pickaxe");

        lemonAxe = new ItemLemonAxe(lemonstoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lemon_axe");

        lemonShovel = new ItemLemonShovel(lemonstoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lemon_shovel");

        lemonHoe = new ItemLemonHoe(lemonstoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lemon_hoe");

        lemonStone = new ItemLemonStone().setMaxStackSize(64).setUnlocalizedName("projectfruit:lemon_ore");
        
        lemon = new ItemLemon(1, 1, true).setUnlocalizedName("projectfruit:lemon");

        explosiveLemon = new ItemExplosiveLemon().setMaxStackSize(64).setUnlocalizedName("projectfruit:explosive_lemon");

        lemonade = new ItemBucketLemonade(lemonadeBlock).setUnlocalizedName("projectfruit:lemonade_bucket").setContainerItem(Items.bucket);

        lemonHelmet = new LemonArmor(lemonstoneArmor, 0, 0, "lemonarmor").setUnlocalizedName("projectfruit:lemon_helmet");

        lemonChestplate = new LemonArmor(lemonstoneArmor, 0, 1, "lemonarmor").setUnlocalizedName("projectfruit:lemon_chestplate");

        lemonLeggings = new LemonArmor(lemonstoneArmor, 0, 2, "lemonarmor").setUnlocalizedName("projectfruit:lemon_leggings");

        lemonBoots = new LemonArmor(lemonstoneArmor, 0, 3, "lemonarmor").setUnlocalizedName("projectfruit:lemon_boots");
        //LEMON STUFF//

        //LEMON LIME//

        lemonLimeSword = new ItemLemonLimeSword(lemonLimeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lemon_lime_sword");

        lemonLimeShovel = new ItemLemonLimeShovel(lemonLimeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lemon_lime_shovel");

        lemonLimePickaxe = new ItemLemonLimePickaxe(lemonLimeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lemon_lime_pickaxe");

        lemonLimeHoe = new ItemLemonLimeHoe(lemonLimeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lemon_lime_hoe");

        lemonLimeAxe = new ItemLemonLimeAxe(lemonLimeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lemon_lime_axe");

        //LEMON LIME//

        //LIME STUFF//
        lime = new ItemLime(2, 2, true).setUnlocalizedName("projectfruit:lime");

        limeStone = new ItemLimeStone().setMaxStackSize(64).setUnlocalizedName("projectfruit:lime_ore");
        
        limeSword = new ItemLimeSword(limeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lime_sword");
        
        limeAxe = new ItemLimeAxe(limeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lime_axe");
        
        limeHoe = new ItemLimeHoe(limeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lime_hoe");
        
        limePickaxe = new ItemLimePickaxe(lemonLimeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lime_pickaxe");
        
        limeShovel = new ItemLimeShovel(limeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:lime_shovel");
        //LIME STUFF//

        //ORANGE STUFF//
        orange = new ItemOrange(4, 4, true).setUnlocalizedName("projectfruit:orange");

        orangeJuice = new ItemBucketOrangeJuice(1, 1, false).setUnlocalizedName("projectfruit:orange_juice_bucket");
        
        orangeAxe = new ItemOrangeAxe(orangeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:orange_axe");
        
        orangeHoe = new ItemOrangeHoe(orangeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:orange_hoe");
        
        orangePickaxe = new ItemOrangePickaxe(orangeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:orange_pickaxe");
        
        orangeShovel = new ItemOrangeShovel(orangeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:orange_shovel");
        
        orangeStone = new ItemOrangeStone().setMaxStackSize(64).setUnlocalizedName("projectfruit:orange_stone");
        
        orangeSword = new ItemOrangeSword(orangeStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:orange_sword");
        //ORANGE STUFF//
        
        //BLUEBERRY//
        
        blueberry = new ItemBlueberry(1, 1, false).setUnlocalizedName("projectfruit:blueberry");
        
        blueberryStone = new ItemBlueberryStone().setUnlocalizedName("projectfruit:blueberry_stone");
        
        blueberrySword = new ItemBlueberrySword(blueberryStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:blueberry_sword");
        
        blueberryAxe = new ItemBlueberryAxe(blueberryStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:blueberry_axe");
        
        blueberryHoe = new ItemBlueberryHoe(blueberryStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:blueberry_hoe");
        
        blueberryPickaxe = new ItemBlueberryPickaxe(blueberryStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:blueberry_pickaxe");
        
        blueberryShovel = new ItemBlueberryShovel(blueberryStoneTool).setMaxStackSize(1).setUnlocalizedName("projectfruit:blueberry_shovel");
        
        ////////////

        
    }
    
    public static void registerBlocks(){
    	
    	lemonStoneOre = new BlockLemonStone().setHardness(4.0F).setStepSound(Block.soundTypeStone).setBlockName("projectfruit:lemon_ore_block");

        lemonilium = new BlockLemonilium().setHardness(0.5F).setStepSound(Block.soundTypeGrass).setBlockName("projectfruit:lemonilium");

        lemonSapling = new BlockLemonSapling().setStepSound(Block.soundTypeGrass).setBlockName("projectfruit:lemon_tree_sapling");

        lemonLeaves = new BlockLemonLeaves().setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("projectfruit:lemon_leaves");

        lemonBrick = new BlockLemonBrick().setHardness(6.0F).setResistance(18.0F).setStepSound(Block.soundTypeStone).setBlockName("projectfruit:lemon_brick");

        limeGrass = new BlockLimeGrass().setHardness(0.5F).setStepSound(Block.soundTypeGrass).setBlockName("projectfruit:lime_grass");
        
        limeStoneOre = new BlockLimeStone().setHardness(4.0F).setStepSound(Block.soundTypeStone).setBlockName("projectfruit:lime_stone_block");

        limeLeaves = new BlockLimeLeaves().setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("projectfruit:lime_leaves");

        limeSapling = new BlockLimeSapling().setStepSound(Block.soundTypeGrass).setBlockName("projectfruit:lime_sapling");

        orangeGrass = new BlockOrangeGrass().setHardness(0.5F).setStepSound(Block.soundTypeGrass).setBlockName("projectfruit:orange_grass");
        
        orangeLeaves = new BlockOrangeLeaves().setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("projectfruit:orange_leaves");

        orangeSapling = new BlockOrangeSapling().setStepSound(Block.soundTypeGrass).setBlockName("projectfruit:orange_sapling");

        orangeStoneBlock = new BlockOrangeStone().setHardness(4.0F).setStepSound(Block.soundTypeStone).setBlockName("projectfruit:orange_stone_block");
        
        blueberryStoneBlock = new BlockBlueberryStone().setHardness(4.0F).setStepSound(Block.soundTypeStone).setBlockName("projectfruit:blueberry_stone_block");
        
        blueberryGrass = new BlockBlueberryGrass().setHardness(0.5F).setStepSound(Block.soundTypeGrass).setBlockName("projectfruit:blueberry_grass");
        
        blueberryBush = new TileEntityBlueberryBushBlock().setStepSound(Block.soundTypeGrass).setBlockName("projectfruit:blueberry_bush");
        
        blueberryBushGrown = new TileEntityBlueberryBushGrownBlock().setStepSound(Block.soundTypeGrass).setBlockName("projectfruit:blueberry_bush_grown");
        
        fruitPortal = (BlockFruitPortal) new BlockFruitPortal().setHardness(-1.0F).setStepSound(Block.soundTypeGlass).setLightLevel(0.75F).setBlockName("projectfruit:fruit_dimension_portal");

        GameRegistry.registerItem(lemon, "lemon");
        GameRegistry.registerItem(lemonade, "lemonade");
        GameRegistry.registerItem(lemonArrow, "lemonarrow");
        GameRegistry.registerItem(lemonAxe, "lemonaxe");
        GameRegistry.registerItem(lemonBoots, "lemonboots");
        GameRegistry.registerItem(lemonBow, "lemonbow");
        GameRegistry.registerItem(lemonChestplate, "lemonchestplate");
        GameRegistry.registerItem(lemonHelmet, "lemonhelmet");
        GameRegistry.registerItem(lemonHoe, "lemonhoe");
        GameRegistry.registerItem(lemonLeggings, "lemonleggings");
        GameRegistry.registerItem(lemonPickaxe, "lemonpickaxe");
        GameRegistry.registerItem(lemonShovel, "lemonshovel");
        GameRegistry.registerItem(lemonStone, "lemonstone");
        GameRegistry.registerItem(lemonSword, "lemonsword");
        GameRegistry.registerItem(explosiveLemon, "explosivelemon");

        GameRegistry.registerItem(lemonLimeAxe, "lemonlimeaxe");
        GameRegistry.registerItem(lemonLimeHoe, "lemonlimehoe");
        GameRegistry.registerItem(lemonLimePickaxe, "lemonlimepickaxe");
        GameRegistry.registerItem(lemonLimeShovel, "lemonlimeshovel");
        GameRegistry.registerItem(lemonLimeSword, "lemonlimesword");

        GameRegistry.registerItem(lime, "lime");
        GameRegistry.registerItem(limeAxe, "limeaxe");
        GameRegistry.registerItem(limeHoe, "limehoe");
        GameRegistry.registerItem(limePickaxe, "limepickaxe");
        GameRegistry.registerItem(limeShovel, "limeshovel");
        GameRegistry.registerItem(limeStone, "limestone");
        GameRegistry.registerItem(limeSword, "limesword");

        GameRegistry.registerItem(orange, "orange");
        GameRegistry.registerItem(orangeAxe, "orangeaxe");
        GameRegistry.registerItem(orangeHoe, "orangehoe");
        GameRegistry.registerItem(orangeJuice, "orangejuice");
        GameRegistry.registerItem(orangePickaxe, "orangepickaxe");
        GameRegistry.registerItem(orangeShovel, "orangeshovel");
        GameRegistry.registerItem(orangeStone, "orangestone");
        GameRegistry.registerItem(orangeSword, "orangesword");

        GameRegistry.registerItem(blueberry, "blueberry");
        GameRegistry.registerItem(blueberryAxe, "blueberryaxe");
        GameRegistry.registerItem(blueberryHoe, "blueberryhoe");
        GameRegistry.registerItem(blueberryPickaxe, "blueberrypickaxe");
        GameRegistry.registerItem(blueberryShovel, "blueberryshovel");
        GameRegistry.registerItem(blueberryStone, "blueberrystone");
        GameRegistry.registerItem(blueberrySword, "blueberrysword");
        
    }
    
    public static void registerGameRegistry(){
        GameRegistry.registerBlock(lemonStoneOre, "Lemon Stone Block");
        GameRegistry.registerBlock(lemonLeaves, "Lemon Leaves");
        GameRegistry.registerBlock(lemonilium, "Lemonilium");
        GameRegistry.registerBlock(lemonSapling, "Lemon Sapling");
        GameRegistry.registerBlock(lemonBrick, "Lemon Bricks");
        GameRegistry.registerBlock(fruitPortal, "Fruit Portal");
        GameRegistry.registerBlock(limeGrass, "Lime Grass");
        GameRegistry.registerBlock(orangeGrass, "Orange Grass");
        GameRegistry.registerBlock(orangeLeaves, "Orange Leaves");
        GameRegistry.registerBlock(orangeSapling, "Orange Sapling");
        GameRegistry.registerBlock(limeStoneOre, "Lime Stone Block");
        GameRegistry.registerBlock(limeLeaves, "Lime Leaves");
        GameRegistry.registerBlock(limeSapling, "Lime Sapling");
        GameRegistry.registerBlock(lemonadeBlock, "LemonadeStill");
        GameRegistry.registerBlock(blueberryStoneBlock, "Blueberry Stone Block");
        GameRegistry.registerBlock(blueberryGrass, "Blueberry Grass");
        GameRegistry.registerBlock(orangeStoneBlock, "Orange Stone Block");
        GameRegistry.registerBlock(blueberryBush, "Blueberry Bush");
        GameRegistry.registerBlock(blueberryBushGrown, "Blueberry Bush Grown");


    }
    
    public static void registerRecipes(){
        GameRegistry.addRecipe(new ItemStack(lemonSword), " x ", " x ", " y ",
                'x', lemonStone, 'y', Items.stick);

        GameRegistry.addRecipe(new ItemStack(lemonPickaxe), "xxx", " y ", " y ",
                'x', lemonStone, 'y', Items.stick);

        GameRegistry.addRecipe(new ItemStack(lemonAxe), "xx ", "xy ", " y ",
                'x', lemonStone, 'y', Items.stick);

        GameRegistry.addRecipe(new ItemStack(lemonShovel), " x ", " y ", " y ",
                'x', lemonStone, 'y', Items.stick);

        GameRegistry.addRecipe(new ItemStack(lemonHoe), "xx ", " y ", " y ",
                'x', lemonStone, 'y', Items.stick);

        GameRegistry.addRecipe(new ItemStack(lemonBow), " ls", "x s", " ls",
                'x', Items.stick, 's', Items.string, 'l', lemon);

        GameRegistry.addShapelessRecipe(new ItemStack(lemonArrow , 6), explosiveLemon, Items.arrow);

        GameRegistry.addRecipe(new ItemStack(explosiveLemon), " y ", "yxy", " y ",
                'x', lemon, 'y', Items.gunpowder);

        GameRegistry.addRecipe(new ItemStack(lemonLimeSword), " l ", " l ", " s ",
                'l', limeStone, 's', lemonSword);

        GameRegistry.addRecipe(new ItemStack(lemonLimePickaxe), " l ", " l ", " s ",
                'l', limeStone, 's', lemonPickaxe);

        GameRegistry.addRecipe(new ItemStack(lemonLimeAxe), " l ", " l ", " s ",
                'l', limeStone, 's', lemonAxe);

        GameRegistry.addRecipe(new ItemStack(lemonLimeShovel), " l ", " l ", " s ",
                'l', limeStone, 's', lemonShovel);

        GameRegistry.addRecipe(new ItemStack(lemonLimeHoe), " l ", " l ", " s ",
                'l', limeStone, 's', lemonHoe);

        GameRegistry.addRecipe(new ItemStack(lemonLimePickaxe), " l ", " l ", " s ",
                'l', lemonStone, 's', limePickaxe);

        GameRegistry.addRecipe(new ItemStack(lemonLimeAxe), " l ", " l ", " s ",
                'l', lemonStone, 's', limeAxe);

        GameRegistry.addRecipe(new ItemStack(lemonLimeShovel), " l ", " l ", " s ",
                'l', lemonStone, 's', limeShovel);

        GameRegistry.addRecipe(new ItemStack(lemonLimeHoe), " l ", " l ", " s ",
                'l', lemonStone, 's', limeHoe);

        GameRegistry.addShapelessRecipe(new ItemStack(orangeJuice), orange, Items.bucket);

        GameRegistry.addRecipe(new ItemStack(lemonHelmet, 1), "xxx", "x x", "   ",
                'x', lemonStone);

        GameRegistry.addRecipe(new ItemStack(lemonChestplate, 1), "x x", "xxx", "xxx",
                'x', lemonStone);

        GameRegistry.addRecipe(new ItemStack(lemonLeggings, 1), "xxx", "x x", "x x",
                'x', lemonStone);

        GameRegistry.addRecipe(new ItemStack(lemonBoots, 1), "   ", "x x", "x x",
                'x', lemonStone);

        GameRegistry.addRecipe(new ItemStack(lemonBrick, 1), "lll", "lbl", "lll",
                'l', lemon, 'b', Blocks.brick_block);

        GameRegistry.addShapelessRecipe(new ItemStack(lemonade), lemon, Items.bucket);
        
        GameRegistry.addRecipe(new ItemStack(blueberrySword), " x ", " x ", " y ",
                'x', blueberryStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(blueberryPickaxe), "xxx", " y ", " y ",
                'x', blueberryStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(blueberryAxe), "xx ", "xy ", " y ",
                'x', blueberryStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(blueberryShovel), " x ", " y ", " y ",
                'x', blueberryStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(blueberryHoe), "xx ", " y ", " y ",
                'x', blueberryStone, 'y', Items.stick);
       
        GameRegistry.addRecipe(new ItemStack(limeSword), " x ", " x ", " y ",
                'x', limeStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(lemonLimeSword), " l ", " l ", " s ",
                'l', lemonStone, 's', limeSword);
        
        GameRegistry.addRecipe(new ItemStack(limePickaxe), "xxx", " y ", " y ",
                'x', limeStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(limeAxe), "xx ", "xy ", " y ",
                'x', limeStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(limeShovel), " x ", " y ", " y ",
                'x', limeStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(limeHoe), "xx ", " y ", " y ",
                'x', limeStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(orangeSword), " x ", " x ", " y ",
                'x', orangeStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(orangePickaxe), "xxx", " y ", " y ",
                'x', orangeStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(orangeAxe), "xx ", "xy ", " y ",
                'x', orangeStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(orangeShovel), " x ", " y ", " y ",
                'x', orangeStone, 'y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(orangeHoe), "xx ", " y ", " y ",
                'x', orangeStone, 'y', Items.stick);
    }
    
    public static void registerFluids(){
    	lemonadeFluid = new Fluid("lemonadefluid").setUnlocalizedName("lemonadefluid");

        FluidRegistry.registerFluid(lemonadeFluid);

        materialLemonade = new MaterialLiquid(MapColor.waterColor);

        lemonadeBlock = new LemonadeFluid(lemonadeFluid, materialLemonade).setBlockName("projectfruit:lemondadestill");
        
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("lemonadefluid", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ProjectFruitRegistry.lemonade), new ItemStack(Items.bucket));
    }
    
    public static void registerBiomes(){
        lemonBiome = (new BiomeGenLemonBiome(lemonBiomeID)).setBiomeName("LemonBiome");
        limeBiome = (new BiomeGenLimeBiome(limeBiomeID)).setBiomeName("LimeBiome");
        orangeBiome = (new BiomeGenOrangeBiome(orangeBiomeID)).setBiomeName("OrangeBiome");
        lemonBiomeHills = (new BiomeGenLemonBiomeHills(lemonBiomeHillsID)).setBiomeName("Lemon Biome Hills");
        limeBiomeHills = (new BiomeGenLimeBiomeHills(limeBiomeHillsID)).setBiomeName("Lime Biome Hills");
        orangeBiomeHills = (new BiomeGenOrangeBiomeHills(orangeBiomeHillsID)).setBiomeName("Orange Biome Hills");
        blueberryBiome = (new BiomeGenBlueberryBiome(blueberryBiomeID)).setBiomeName("Blueberry Biome");
        blueberryBiomeHills = (new BiomeGenBlueberryBiomeHills(blueberryBiomeHillsID)).setBiomeName("Blueberry Biome Hills");
    }

}
