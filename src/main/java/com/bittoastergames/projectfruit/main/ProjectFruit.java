package com.bittoastergames.projectfruit.main;

import com.bittoastergames.projectfruit.blueberry.blocks.TileEntityBlueberryBushEntity;
import com.bittoastergames.projectfruit.blueberry.blocks.TileEntityBlueberryBushGrownEntity;
import com.bittoastergames.projectfruit.lemon.LemonTreeEvent;
import com.bittoastergames.projectfruit.lemon.LemonadeBucketHandler;
import com.bittoastergames.projectfruit.lemon.entities.EntityExplosiveLemon;
import com.bittoastergames.projectfruit.lemon.entities.EntityFlyingLemonExplosive;
import com.bittoastergames.projectfruit.lemon.entities.EntityLemonArrow;
import com.bittoastergames.projectfruit.lime.LimeTreeEvent;
import com.bittoastergames.projectfruit.orange.OrangeTreeEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = ProjectFruit.modID, name = ProjectFruit.modName, version = ProjectFruit.version)
public class ProjectFruit {

    public static final String modID = "projectfruit";
    public static final String modName = "Project Fruit";
    public static final String version = "1.1.10";

    // World Gen
    public static WorldGeneratorFruitDimension worldGen = new WorldGeneratorFruitDimension();

    public static DamageSource causeLemonArrowDamage(EntityLemonArrow par0EntityArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("lemonarrow", par0EntityArrow, par1Entity)).setProjectile();
    }

    public static DamageSource causeLemonFireballDamage(EntityFlyingLemonExplosive par0EntityFireball, Entity par1Entity)
    {
        return par1Entity == null ? (new EntityDamageSourceIndirect("onFire", par0EntityFireball, par0EntityFireball)).setProjectile() : (new EntityDamageSourceIndirect("fireball", par0EntityFireball, par1Entity)).setProjectile();
    }

    // The instance of your mod that Forge uses.
    @Instance("projectfruit")
    public static ProjectFruit instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="com.bittoastergames.projectfruit.main.client.ClientProxy", serverSide="com.bittoastergames.projectfruit.main.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

        EntityRegistry.registerModEntity(EntityExplosiveLemon.class, "explosiveLemon", 2, this, 40, 3, true);
        EntityRegistry.registerModEntity(EntityFlyingLemonExplosive.class, "explosiveLemon", 2, this, 40, 3, true);

        ProjectFruitRegistry.registerConfig(event);

        proxy.init();
        proxy.registerRenderers();
        GameRegistry.registerTileEntity(TileEntityBlueberryBushEntity.class, "tileEntityBlueberryBush");
        GameRegistry.registerTileEntity(TileEntityBlueberryBushGrownEntity.class, "tileEntityBlueberryGrownBush");
        ProjectFruitRegistry.init();
        FMLCommonHandler.instance().bus().register(new FruitConectionHandler());
        DimensionManager.registerProviderType(ProjectFruitRegistry.dimID, FruitWorldProvider.class, false);
        DimensionManager.registerDimension(ProjectFruitRegistry.dimID, ProjectFruitRegistry.dimID);
        MinecraftForge.EVENT_BUS.register(new LemonTreeEvent());
        MinecraftForge.EVENT_BUS.register(new LimeTreeEvent());
        MinecraftForge.EVENT_BUS.register(new OrangeTreeEvent());

        GameRegistry.registerWorldGenerator(worldGen, 1);

        LemonadeBucketHandler.INSTANCE.buckets.put(ProjectFruitRegistry.lemonadeBlock, ProjectFruitRegistry.lemonade);
        MinecraftForge.EVENT_BUS.register(LemonadeBucketHandler.INSTANCE);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ProjectFruitRegistry.registerRecipes();
        GameRegistry.registerFuelHandler(new ProjectFruitFuelHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }


}