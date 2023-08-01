package com.dayton.nukacraft.init.biomes;
import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.world.gen.ModDefaultFeatures;
import com.dayton.nukacraft.common.world.gen.ModFeatures;
import com.dayton.nukacraft.init.blocks.ModBlocksClass;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, NukaCraftMod.MOD_ID);

    public static final RegistryObject<Biome> POISON_VALLEY = BIOMES.register("poison_valley",
            ModBiomes::createPoisonValley);

    public static final RegistryObject<Biome> GLOW_SEA = BIOMES.register("glow_sea",
            ModBiomes::createGlowSea);

    public static final RegistryObject<Biome> ASH_HEAP = BIOMES.register("ash_heap",
            ModBiomes::createAshHeap);

    public static final RegistryObject<Biome> CRANBERRY_BOG = BIOMES.register("cranberry_bog",
            ModBiomes::createCranberryBog);

    private static Biome createPoisonValley() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-5399162).waterColor(-9547964).waterFogColor(11648455)
                .skyColor(-7964315).foliageColorOverride(1783388).grassColorOverride(-861768).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("nukacraft:tree_ashwood",
                FeatureUtils.register("nukacraft:tree_ash", Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocksClass.ASHWOOD.get().defaultBlockState()),
                                new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines()
                                .build()),
                List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:grass_ash", VegetationFeatures.PATCH_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 5),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:crackbush", ModFeatures.PATCH_CRACK_BUSH, List.of(NoiseThresholdCountPlacement.of(-0.4D, 3, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:bloodleaf", ModFeatures.PATCH_BLOODLEAF, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:brainfungus", ModFeatures.PATCH_BRAINFUNGUS, List.of(NoiseThresholdCountPlacement.of(-0.2D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:thistles", ModFeatures.PATCH_THISTLE, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:tatos", ModFeatures.PATCH_WILDTATO, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:asters", ModFeatures.PATCH_ASTER, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:sootflowers", ModFeatures.PATCH_SOOTFLOWER, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:sittbeans", ModFeatures.PATCH_SITTBEANS, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:feverblossoms", ModFeatures.PATCH_FEVERBLOSM, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:firemushs", ModFeatures.PATCH_FIREMUSH, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:ashroses", ModFeatures.PATCH_ASHROSE, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:ashgrasss", ModFeatures.PATCH_ASHGRASS, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:glowfungus", ModFeatures.PATCH_GLOWFUNGUS, List.of(NoiseThresholdCountPlacement.of(-0.2D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        ModDefaultFeatures.addWastelandOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.NONE).temperature(0.5f)
                .downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build())
                .build();
    }

    private static Biome createCranberryBog() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-10990522).waterColor(-11386816).waterFogColor(-11590620)
                .skyColor(-3024201).foliageColorOverride(-6797754).grassColorOverride(-7714230).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("nukacraft:tree_cranberry",
                FeatureUtils.register("nukacraft:cranberry_tree", Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                                new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines()
                                .build()),
                List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:grass_ash", VegetationFeatures.PATCH_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:crangrass", ModFeatures.PATCH_CRANGRASS, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 12),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:cranberrys", ModFeatures.PATCH_CRANBERRY, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:muttfruits", ModFeatures.PATCH_MUTTFRUIT, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:sittbeans", ModFeatures.PATCH_SITTBEANS, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:starberry", ModFeatures.PATCH_STARBERRY, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:glowfungus", ModFeatures.PATCH_GLOWFUNGUS, List.of(NoiseThresholdCountPlacement.of(-0.2D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:bloodleafs", ModFeatures.PATCH_BLOODLEAF, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:firemush", ModFeatures.PATCH_FIREMUSH, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        ModDefaultFeatures.addWastelandOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.NONE).temperature(0.5f)
                .downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build())
                .build();
    }

    private static Biome createGlowSea() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-5399162).waterColor(-13486806).waterFogColor(-9997233)
                .skyColor(-13486806).foliageColorOverride(-12038345).grassColorOverride(-11776440).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:grass_ash", VegetationFeatures.PATCH_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:glowgrass", ModFeatures.PATCH_GLOWGRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 2, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        ModDefaultFeatures.addWastelandOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.DESERT).temperature(1.5f)
                .downfall(0.9f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build())
                .build();
    }


    private static Biome createAshHeap() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-10990522).waterColor(-9551310).waterFogColor(11648455)
                .skyColor(-10990522).foliageColorOverride(-10465466).grassColorOverride(-11187642).ambientParticle(new AmbientParticleSettings(ParticleTypes.SMOKE, 0.0009f)).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:grass_ash", VegetationFeatures.PATCH_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:muttfruit", ModFeatures.PATCH_MUTTFRUIT, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:bloodleafs", ModFeatures.PATCH_BLOODLEAF, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:ashroses", ModFeatures.PATCH_ASHROSE, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:glowfungus", ModFeatures.PATCH_GLOWFUNGUS, List.of(NoiseThresholdCountPlacement.of(-0.2D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:brainfungus", ModFeatures.PATCH_BRAINFUNGUS, List.of(NoiseThresholdCountPlacement.of(-0.2D, 1, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        ModDefaultFeatures.addWastelandOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.DESERT).temperature(1.2f)
                .downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build())
                .build();
    }



    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
