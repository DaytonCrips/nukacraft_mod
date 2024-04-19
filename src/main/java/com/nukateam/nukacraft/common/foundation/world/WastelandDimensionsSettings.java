package com.nukateam.nukacraft.common.foundation.world;

import com.mojang.serialization.DataResult;
import com.nukateam.nukacraft.common.registery.fluid.ModFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;

import java.util.List;
import java.util.OptionalLong;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class WastelandDimensionsSettings {
//    public static final DeferredRegister<NoiseGeneratorSettings> NOISE_GENERATORS = DeferredRegister.create(Registries.NOISE_SETTINGS, NukaCraftMod.MOD_ID);
//    public static final DeferredRegister<DimensionType> DIMENSION_TYPES = DeferredRegister.create(Registries.DIMENSION_TYPE, NukaCraftMod.MOD_ID);

//    public static final RegistryObject<NoiseGeneratorSettings> WASTELAND_NOISE_GEN = NOISE_GENERATORS.register("fallout_wasteland_noise", WastelandDimensionsSettings::falloutNoise);
//    public static final RegistryObject<DimensionType> WASTELAND_DIM_TYPE = DIMENSION_TYPES.register("fallout_wasteland_type", WastelandDimensionsSettings::falloutDimensionType);

    public static final ResourceLocation WASTELAND = nukaResource("fallout_wasteland");

    public static final ResourceKey<Level> WASTELAND_DIMENSION = ResourceKey.create(Registries.DIMENSION, WASTELAND);

    static final NoiseSettings WASTELAND_NOISE_SETTINGS = create(-64, 384, 1, 2);

    public static final ResourceKey<NoiseGeneratorSettings> WASTELAND_NOISE_GEN =
            ResourceKey.create(Registries.NOISE_SETTINGS, nukaResource("fallout_wasteland_noise"));

    public static final ResourceKey<DimensionType> WASTELAND_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, nukaResource("fallout_wasteland"));

//    public static final ResourceKey<LevelStem> WASTELAND_LEVEL_STEM =  ResourceKey.create(Registries.LEVEL_STEM, ModDimensions.WASTELAND);

    public static void bootstrapNoise(BootstapContext<NoiseGeneratorSettings> context) {
        context.register(WASTELAND_NOISE_GEN, falloutNoise(context));
    }

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(WASTELAND_DIM_TYPE, falloutDimensionType());
    }

//    public static void bootstrapStem(BootstapContext<LevelStem> context) {
//        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
//        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);
//
//        HolderGetter<BiomeDensitySource> biomeDataRegistry = context.lookup(TFRegistries.Keys.BIOME_TERRAIN_DATA);
//
//        var twilightChunkGenerator = new NoiseBasedChunkGenerator(
//                new TFBiomeProvider(biomeDataRegistry.getOrThrow(BiomeLayerStack.BIOME_GRID)),
//                noiseGenSettings.getOrThrow(TWILIGHT_NOISE_GEN)
//        );
//
//        LevelStem stem = new LevelStem(
//                dimTypes.getOrThrow(WASTELAND_DIM_TYPE),
//                twilightChunkGenerator
//        );
//
//        context.register(WASTELAND_LEVEL_STEM, stem);
//    }

    public static NoiseGeneratorSettings falloutNoise(BootstapContext<NoiseGeneratorSettings> context) {
        var falloutNoise = WastelandNoiseRouterData.falloutNoise(
                context.lookup(Registries.DENSITY_FUNCTION),
                context.lookup(Registries.NOISE),
                false, false);

        return new NoiseGeneratorSettings(WASTELAND_NOISE_SETTINGS,
                Blocks.GRASS_BLOCK.defaultBlockState(),
                ModFluids.DIRTY_WATER_BLOCK.get().defaultBlockState(),
                falloutNoise,
                WastelandSurfaceRule.fallout(),
                (new WastelandBiomeBuilder()).spawnTarget(),
                64,
                false,
                true,
                false,
                false);
    }

    private static DimensionType falloutDimensionType() {
        return new DimensionType(
                OptionalLong.empty(),
                true, //skylight
                false, //ceiling
                false, //ultrawarm
                true, //natural
                1.0D, //coordinate scale
                true, //bed works
                false, //respawn anchor works
                -64,
                384,
                384, // Logical Height
                BlockTags.INFINIBURN_OVERWORLD, //infiburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // DimensionRenderInfo
                0f, // Wish this could be set to -0.05 since it'll make the world truly blacked out if an area is not sky-lit (see: Dark Forests) Sadly this also messes up night vision so it gets 0
                new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 7)
        );
    }

    private static DataResult<NoiseSettings> guardY(NoiseSettings p_158721_) {
        if (p_158721_.minY() + p_158721_.height() > DimensionType.MAX_Y + 1) {
            return DataResult.error(() -> "min_y + height cannot be higher than: " + (DimensionType.MAX_Y + 1));
        } else if (p_158721_.height() % 16 != 0) {
            return DataResult.error(() -> "height has to be a multiple of 16");
        } else {
            return p_158721_.minY() % 16 != 0 ? DataResult.error(() -> "min_y has to be a multiple of 16") : DataResult.success(p_158721_);
        }
    }

    public static NoiseSettings create(int p_224526_, int p_224527_, int p_224528_, int p_224529_) {
        NoiseSettings noisesettings = new NoiseSettings(p_224526_, p_224527_, p_224528_, p_224529_);
        guardY(noisesettings).error().ifPresent((p_158719_) -> {
            throw new IllegalStateException(p_158719_.message());
        });
        return noisesettings;
    }


//    public static void register(ResourceKey<NoiseGeneratorSettings> p_198263_, NoiseGeneratorSettings p_198264_) {
//        BuiltInRegistries.register(Registries.NOISE_SETTINGS, p_198263_.location(), p_198264_);
//    }
}
