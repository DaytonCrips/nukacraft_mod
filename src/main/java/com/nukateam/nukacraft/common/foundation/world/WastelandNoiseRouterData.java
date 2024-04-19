package com.nukateam.nukacraft.common.foundation.world;

import com.mojang.serialization.Codec;
import net.minecraft.client.gui.screens.worldselection.WorldCreationContext;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import static net.minecraft.world.level.levelgen.synth.NormalNoise.*;

public class WastelandNoiseRouterData {
    public static final ResourceKey<DensityFunction> Y = createKey("y");
    public static final ResourceKey<DensityFunction> SHIFT_X = createKey("shift_x");
    public static final ResourceKey<DensityFunction> SHIFT_Z = createKey("shift_z");
    public static final ResourceKey<DensityFunction> CONTINENTS = createKey("overworld/continents");
    public static final ResourceKey<DensityFunction> EROSION = createKey("overworld/erosion");
    public static final ResourceKey<DensityFunction> RIDGES = createKey("overworld/ridges");
    public static final ResourceKey<DensityFunction> FACTOR = createKey("overworld/factor");
    public static final ResourceKey<DensityFunction> DEPTH = createKey("overworld/depth");
    public static final ResourceKey<DensityFunction> SLOPED_CHEESE = createKey("overworld/sloped_cheese");
    public static final ResourceKey<DensityFunction> CONTINENTS_LARGE = createKey("overworld_large_biomes/continents");
    public static final ResourceKey<DensityFunction> EROSION_LARGE = createKey("overworld_large_biomes/erosion");
    public static final ResourceKey<DensityFunction> FACTOR_LARGE = createKey("overworld_large_biomes/factor");
    public static final ResourceKey<DensityFunction> DEPTH_LARGE = createKey("overworld_large_biomes/depth");
    public static final ResourceKey<DensityFunction> SLOPED_CHEESE_LARGE = createKey("overworld_large_biomes/sloped_cheese");
    public static final ResourceKey<DensityFunction> SLOPED_CHEESE_AMPLIFIED = createKey("overworld_amplified/sloped_cheese");
    public static final ResourceKey<DensityFunction> SPAGHETTI_ROUGHNESS_FUNCTION = createKey("overworld/caves/spaghetti_roughness_function");
    public static final ResourceKey<DensityFunction> ENTRANCES = createKey("overworld/caves/entrances");
    public static final ResourceKey<DensityFunction> NOODLE = createKey("overworld/caves/noodle");
    public static final ResourceKey<DensityFunction> PILLARS = createKey("overworld/caves/pillars");
    public static final ResourceKey<DensityFunction> SPAGHETTI_2D = createKey("overworld/caves/spaghetti_2d");

    public WastelandNoiseRouterData() {
    }

    private static ResourceKey<DensityFunction> createKey(String p_209537_) {
        return ResourceKey.create(Registries.DENSITY_FUNCTION, new ResourceLocation(p_209537_));
    }

    private static DensityFunction underground(HolderGetter<DensityFunction> registry, HolderGetter<NoiseParameters> pNoiseParameters, DensityFunction p_224473_) {
        DensityFunction densityFunction = getFunction(registry, SPAGHETTI_2D);
        DensityFunction densityFunction1 = getFunction(registry, SPAGHETTI_ROUGHNESS_FUNCTION);
        DensityFunction densityFunction2 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.CAVE_LAYER), 8.0D);
        DensityFunction densityFunction3 = DensityFunctions.mul(DensityFunctions.constant(4.0D), densityFunction2.square());
        DensityFunction densityFunction4 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.CAVE_CHEESE), 0.6666666666666666D);
        DensityFunction densityFunction5 = DensityFunctions.add(DensityFunctions.add(DensityFunctions.constant(0.27D), densityFunction4).clamp(-1.0D, 1.0D),
                DensityFunctions.add(DensityFunctions.constant(1.5D), DensityFunctions.mul(DensityFunctions.constant(-0.64D), p_224473_)).clamp(0.0D, 0.5D));
        DensityFunction densityFunction6 = DensityFunctions.add(densityFunction3, densityFunction5);
        DensityFunction densityFunction7 = DensityFunctions.min(DensityFunctions.min(densityFunction6, getFunction(registry, ENTRANCES)), DensityFunctions.add(densityFunction, densityFunction1));
        DensityFunction densityFunction8 = getFunction(registry, PILLARS);
        DensityFunction densityFunction9 = DensityFunctions.rangeChoice(densityFunction8, -1000000.0D, 0.03D, DensityFunctions.constant(-1000000.0D), densityFunction8);
        return DensityFunctions.max(densityFunction7, densityFunction9);
    }

    private static DensityFunction postProcess(DensityFunction p_224493_) {
        DensityFunction densityFunction = DensityFunctions.blendDensity(p_224493_);
        return DensityFunctions.mul(DensityFunctions.interpolated(densityFunction), DensityFunctions.constant(0.64D)).squeeze();
    }

    public static NoiseRouter falloutNoise(HolderGetter<DensityFunction> registry, HolderGetter<NoiseParameters> pNoiseParameters, boolean pLarge, boolean pAmplified) {
        var densityFunction = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_BARRIER), 0.5D);
        var densityFunction1 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_FLOODEDNESS), 0.67D);
        var densityFunction2 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_SPREAD), 0.7142857142857143D);
        var densityFunction3 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_LAVA));
        var densityFunction4 = getFunction(registry, SHIFT_X);
        var densityFunction5 = getFunction(registry, SHIFT_Z);
        var densityFunction6 = DensityFunctions.shiftedNoise2d(densityFunction4,
                densityFunction5, 0.25D, pNoiseParameters.getOrThrow(pLarge ? Noises.TEMPERATURE_LARGE : Noises.TEMPERATURE));

        var densityFunction7 = DensityFunctions.shiftedNoise2d(densityFunction4,
                densityFunction5, 0.25D, pNoiseParameters.getOrThrow(pLarge ? Noises.VEGETATION_LARGE : Noises.VEGETATION));

        var densityFunction8 = getFunction(registry, pLarge ? FACTOR_LARGE : FACTOR);
        var densityFunction9 = getFunction(registry, pLarge ? DEPTH_LARGE : DEPTH);
        var densityFunction10 = noiseGradientDensity(DensityFunctions.cache2d(densityFunction8), densityFunction9);
        var densityFunction11 = getFunction(registry, pLarge ? SLOPED_CHEESE_LARGE :
                (pAmplified ? SLOPED_CHEESE_AMPLIFIED : SLOPED_CHEESE));

        var densityFunction12 = DensityFunctions.min(densityFunction11, DensityFunctions.mul(DensityFunctions.constant(5.0D), getFunction(registry, ENTRANCES)));
        var densityFunction13 = DensityFunctions.rangeChoice(densityFunction11, -1000000.0D, 1.5625D, densityFunction12, underground(registry, pNoiseParameters, densityFunction11));
        var densityFunction14 = DensityFunctions.min(postProcess(slideOverworld(pAmplified, densityFunction13)), getFunction(registry, NOODLE));
        var densityFunction15 = getFunction(registry, Y);

        return new NoiseRouter(
                densityFunction,
                densityFunction1,
                densityFunction2,
                densityFunction3,
                densityFunction6,
                densityFunction7,
                getFunction(registry, pLarge ? CONTINENTS_LARGE : CONTINENTS),
                getFunction(registry, pLarge ? EROSION_LARGE : EROSION),
                densityFunction9, getFunction(registry, RIDGES),
                slideOverworld(pAmplified, DensityFunctions
                        .add(densityFunction10, DensityFunctions.constant(-0.703125D))
                        .clamp(-64.0D, 64.0D)), densityFunction14, DensityFunctions.constant(0.0F),
                DensityFunctions.constant(0.0F), DensityFunctions.constant(0.0F));
    }

    private static DensityFunction slideOverworld(boolean p_224490_, DensityFunction p_224491_) {
        return slide(p_224491_, -64, 384, p_224490_ ? 16 : 80, p_224490_ ? 0 : 64, -0.078125D, 0, 24, p_224490_ ? 0.4D : 0.1171875D);
    }

    private static DensityFunction noiseGradientDensity(DensityFunction p_212272_, DensityFunction p_212273_) {
        DensityFunction densityFunction = DensityFunctions.mul(p_212273_, p_212272_);
        return DensityFunctions.mul(DensityFunctions.constant(4.0D), densityFunction.quarterNegative());
    }

    private static DensityFunction slide(DensityFunction p_224444_, int p_224445_, int p_224446_, int p_224447_, int p_224448_, double p_224449_, int p_224450_, int p_224451_, double p_224452_) {
        DensityFunction densityFunction1 = DensityFunctions.yClampedGradient(p_224445_ + p_224446_ - p_224447_, p_224445_ + p_224446_ - p_224448_, 1.0D, 0.0D);
        DensityFunction $$9 = DensityFunctions.lerp(densityFunction1, p_224449_, p_224444_);
        DensityFunction densityFunction2 = DensityFunctions.yClampedGradient(p_224445_ + p_224450_, p_224445_ + p_224451_, 0.0D, 1.0D);
        return DensityFunctions.lerp(densityFunction2, p_224452_, $$9);
    }


    private static WorldCreationContext.DimensionsUpdater fixedBiomeConfigurator(Holder<Biome> pBiome) {
        return (sas, dod) -> {
            var registry = sas.registryOrThrow(Registries.NOISE_SETTINGS);
            var holder = registry.getHolderOrThrow(NoiseGeneratorSettings.OVERWORLD);
            var biomesource = new FixedBiomeSource(pBiome);
            var chunkgenerator = new NoiseBasedChunkGenerator(biomesource, holder);
            return dod.replaceOverworldGenerator(sas, chunkgenerator);
        };
    }

    private static DensityFunction getFunction(HolderGetter<DensityFunction> pDensityFunctions, ResourceKey<DensityFunction> pKey) {
        return new DensityFunctions.HolderHolder(pDensityFunctions.getOrThrow(pKey));
    }
}
