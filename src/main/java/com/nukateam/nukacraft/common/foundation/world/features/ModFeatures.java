package com.nukateam.nukacraft.common.foundation.world.features;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.fluid.ModFluids;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static com.nukateam.nukacraft.common.registery.ModBlocks.ACID_DIRT;
import static com.nukateam.nukacraft.common.registery.ModBlocks.ASHSTONE;

public class ModFeatures {
//    private void s(){
//        RegistryObject<Feature<?>> d = FEATURES.register("big_mushgloom", () -> new BigMushgloomFeature(HugeMushroomFeatureConfiguration.CODEC));
//    }

    //    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, NukaCraftMod.MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, NukaCraftMod.MOD_ID);

//    public static final RegistryObject<Feature<?>, Feature<HugeMushroomFeatureConfiguration>> BIG_MUSHGLOOM =
//            FEATURES.register("big_mushgloom", () -> new BigMushgloomFeature(HugeMushroomFeatureConfiguration.CODEC));


    public static final RegistryObject<VineFeature> VINE = FEATURES.register("vine", () -> new VineFeature(VineFeatureConfiguration.CODEC));


//    public static final RegistryObject<Feature<?>> DISK_ASHSTONE = FeatureUtils.register("disk_ashstone",
//            Feature.FOREST_ROCK,
//            new BlockStateConfiguration(ASHSTONE.get().defaultBlockState()));


//    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_ASHDIRT =
//            FeatureUtils.register("disk_ashdirt",
//                    Feature.DISK,
//                    new DiskConfiguration(
//                            new RuleBasedBlockStateProvider(
//                                    BlockStateProvider.simple(Blocks.MUD),
//                                    List.of(new RuleBasedBlockStateProvider
//                                            .Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR),
//                                            BlockStateProvider.simple(ModBlocks.ASHDIRT.get())))
//                            ),
//                            BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK),
//                            UniformInt.of(2, 5),
//                            4));

    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_ASHSTONE = FeatureUtils.createKey("disk_ashstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_ASHDIRT = FeatureUtils.createKey("disk_ashdirt");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LAKE_ACID = FeatureUtils.createKey("lake_acid");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BOGPAD =
            FeatureUtils.createKey("patch_bogpad");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASTER_PLANT =
            FeatureUtils.createKey("aster_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEWDROP_SAPLING_PLANT =
            FeatureUtils.createKey("dewdrop_sapling_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TOXIC_FERN_PLANT =
            FeatureUtils.createKey("toxic_fern_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BROC_PLANT =
            FeatureUtils.createKey("broc_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> THISTLE_PLANT =
            FeatureUtils.createKey("thistle_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PLANT =
            FeatureUtils.createKey("dead_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SOOTFLOWER_PLANT =
            FeatureUtils.createKey("sootflower_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> HOLLYHOCK_PLANT =
            FeatureUtils.createKey("hollyhock_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FEVERBLOSSOM_PLANT =
            FeatureUtils.createKey("feverblossom_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRACKBERRY_BUSH_PLANT =
            FeatureUtils.createKey("crackberry_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MUTTFRUIT_BUSH_PLANT =
            FeatureUtils.createKey("muttfruit_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> BRAINFUNGUS_PLANT =
            FeatureUtils.createKey("brainfungus_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWFUNGUS_PLANT =
            FeatureUtils.createKey("glowfungus_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GUTFUNGI_PLANT =
            FeatureUtils.createKey("gutfungus_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BOMBBERRY_BUSH_PLANT =
            FeatureUtils.createKey("bomberry_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> FUSFRUIT_BUSH_PLANT =
            FeatureUtils.createKey("fusfruit_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGAMORH_MUSH_PLANT =
            FeatureUtils.createKey("megamorph_mush_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> QUANTUMLEAF_BUSH_PLANT =
            FeatureUtils.createKey("quantleaf_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NEUTRON_BUSH_PLANT =
            FeatureUtils.createKey("neutron_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MINDFUNGUS_PLANT =
            FeatureUtils.createKey("mindfungus_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DEAD_DATURAN =
            FeatureUtils.createKey("deaddaturan_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DEAD_PUNGA =
            FeatureUtils.createKey("deadpunga_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DEAD_CORAL =
            FeatureUtils.createKey("deadcoral_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_AGAVE_BUSH =
            FeatureUtils.createKey("agave_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GINS_BUSH =
            FeatureUtils.createKey("gins_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLOODLEAF =
            FeatureUtils.createKey("bloodleaf_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> RADASTER_PLANT =
            FeatureUtils.createKey("radaster_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RADROSE_PLANT =
            FeatureUtils.createKey("radrose_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLASTCAP_PLANT =
            FeatureUtils.createKey("blastcap_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FIREFUNGI_PLANT =
            FeatureUtils.createKey("firefungi_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> INVERT_PLANT =
            FeatureUtils.createKey("invert_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BOOMBLOSSOM_PLANT =
            FeatureUtils.createKey("boomblossom_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_XANDER =
            FeatureUtils.createKey("patch_xander");

//    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_RUSTY_BUSH =
//            FeatureUtils.createKey("patch_rusty_bush",
//                    Feature.RANDOM_PATCH,
//                    vegetationPatch(BlockStateProvider.simple(ModBlocks.RUSTY_BUSH.get()), 2));

//    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BBLIGHT = FeatureUtils.createKey("patch_bblight",
//            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocks.BBLIGHT.get()), 1));


    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLOWGRASS =
            FeatureUtils.createKey("patch_glowgrass");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CRANGRASS =
            FeatureUtils.createKey("patch_crangrass");


    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SITTBEANS =
            FeatureUtils.createKey("patch_sittbeans");


    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ASHGRASS =
            FeatureUtils.createKey("patch_ashgrass");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_POISONGRASS =
            FeatureUtils.createKey("patch_poisongrass");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_HEAP_GRASS =
            FeatureUtils.createKey("patch_heapgrass");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_RUSTY_BUSH =
            FeatureUtils.createKey("patch_rustybush");

    public static final ResourceKey<ConfiguredFeature<?, ?>> STARBERRY_PLANT =
            FeatureUtils.createKey("starberry_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRANBERRY_PLANT =
            FeatureUtils.createKey("cranberry_plant_features");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
        FeatureUtils.register(pContext, DISK_ASHSTONE, Feature.FOREST_ROCK, new BlockStateConfiguration(ASHSTONE.get().defaultBlockState()));
        FeatureUtils.register(pContext, DISK_ASHDIRT, Feature.DISK, new DiskConfiguration(
                new RuleBasedBlockStateProvider(
                        BlockStateProvider.simple(Blocks.MUD),
                        List.of(new RuleBasedBlockStateProvider
                                .Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR),
                                BlockStateProvider.simple(ModBlocks.ASHDIRT.get())))
                ),
                BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK),
                UniformInt.of(2, 5),
                4));


        FeatureUtils.register(pContext, LAKE_ACID, Feature.LAKE,
                new LakeFeature.Configuration(BlockStateProvider.simple(ModFluids.ACID_FLUID.get().defaultFluidState().createLegacyBlock()),
                        BlockStateProvider.simple(ACID_DIRT.get().defaultBlockState())));


        FeatureUtils.register(pContext, PATCH_BOGPAD,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(12, 8, 5,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BOGPAD.get())))));

        FeatureUtils.register(pContext, ASTER_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.ASTER.get().defaultBlockState(), 1)), 30));

        FeatureUtils.register(pContext, DEWDROP_SAPLING_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.DEWDROP_SAPLING.get().defaultBlockState(), 2)), 25));

        FeatureUtils.register(pContext, TOXIC_FERN_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.TOXICFERN.get().defaultBlockState(), 1)), 15));

        FeatureUtils.register(pContext, BROC_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.BROC.get().defaultBlockState(), 1)), 20));

        FeatureUtils.register(pContext, THISTLE_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.THISTLE.get().defaultBlockState(), 3)
                        .add(ModBlocks.ASHGRASS.get().defaultBlockState(), 7)), 20));

        FeatureUtils.register(pContext, DEAD_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.DEAD_PLANT.get().defaultBlockState(), 1)), 50));

        FeatureUtils.register(pContext, SOOTFLOWER_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.SOOTFLOWER.get().defaultBlockState(), 1)), 20));

        FeatureUtils.register(pContext, HOLLYHOCK_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.HOLLYHOCK.get().defaultBlockState(), 1)), 20));

        FeatureUtils.register(pContext, FEVERBLOSSOM_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.FEVERBLOSSOM.get().defaultBlockState(), 1)), 20));

        FeatureUtils.register(pContext, CRACKBERRY_BUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.CRACKBERRY_BUSH.get().defaultBlockState(), 1)), 15));

        FeatureUtils.register(pContext, MUTTFRUIT_BUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.MUTTFRUIT_BUSH.get().defaultBlockState(), 1)), 10));


        FeatureUtils.register(pContext, BRAINFUNGUS_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.BRAINFUNGUS.get().defaultBlockState(), 1)), 20));


        FeatureUtils.register(pContext, GLOWFUNGUS_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.GLOWFUNGUS.get().defaultBlockState(), 3)), 10));

        FeatureUtils.register(pContext, GUTFUNGI_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.GUTFUNGI.get().defaultBlockState(), 1)), 10));

        FeatureUtils.register(pContext, BOMBBERRY_BUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.BOMBBERRY_BUSH.get().defaultBlockState(), 1)), 10));


        FeatureUtils.register(pContext, FUSFRUIT_BUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.FUSFRUIT_BUSH.get().defaultBlockState(), 1)), 8));


        FeatureUtils.register(pContext, MEGAMORH_MUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.MEGAHATTERFUNGI.get().defaultBlockState(), 1)), 12));

        FeatureUtils.register(pContext, QUANTUMLEAF_BUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.QUANTUMLEAF_BUSH.get().defaultBlockState(), 1)), 10));

        FeatureUtils.register(pContext, NEUTRON_BUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.NEUTRON_BUSH.get().defaultBlockState(), 1)), 10));

        FeatureUtils.register(pContext, MINDFUNGUS_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.MINDFUNGUS.get().defaultBlockState(), 1)), 10));


        FeatureUtils.register(pContext, PATCH_DEAD_DATURAN,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.DEAD_DATURAN.get()), 2));

        FeatureUtils.register(pContext, PATCH_DEAD_PUNGA,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.DEAD_PUNGA.get()), 2));


        FeatureUtils.register(pContext, PATCH_DEAD_CORAL,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.DEAD_CORALLEAF.get()), 1));

        FeatureUtils.register(pContext, PATCH_AGAVE_BUSH,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.AGAVE.get()), 1));

        FeatureUtils.register(pContext, PATCH_GINS_BUSH,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.GINSENG.get()), 1));


        FeatureUtils.register(pContext, PATCH_BLOODLEAF,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.BLOODLEAF_BUSH.get()), 1));


        FeatureUtils.register(pContext, RADASTER_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.RADASTER.get().defaultBlockState(), 1)), 30));

        FeatureUtils.register(pContext, RADROSE_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.RADROSE.get().defaultBlockState(), 1)), 20));

        FeatureUtils.register(pContext, BLASTCAP_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.BLASTCAP.get().defaultBlockState(), 1)), 20));

        FeatureUtils.register(pContext, FIREFUNGI_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.FIREMUSHROOM.get().defaultBlockState(), 1)), 18));

        FeatureUtils.register(pContext, INVERT_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.INVERT.get().defaultBlockState(), 1)), 10));

        FeatureUtils.register(pContext, BOOMBLOSSOM_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.BOOMBLOSSOM.get().defaultBlockState(), 1)), 30));


        FeatureUtils.register(pContext, PATCH_XANDER,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.ZANDER.get()), 1));

//     FeatureUtils.register(pContext, PATCH_RUSTY_BUSH =
//            FeatureUtils.register(,
//                    Feature.RANDOM_PATCH,
//                    vegetationPatch(BlockStateProvider.simple(ModBlocks.RUSTY_BUSH.get()), 2));

//     FeatureUtils.register(pContext, PATCH_BBLIGHT = FeatureUtils.register(,
//            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocks.BBLIGHT.get()), 1));


        FeatureUtils.register(pContext, PATCH_GLOWGRASS,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.GLOW_GRASS.get()), 36));

        FeatureUtils.register(pContext, PATCH_CRANGRASS,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.CRANBERRY_GRASS.get()), 19));


        FeatureUtils.register(pContext, PATCH_SITTBEANS,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.SITTBEAN_BUSH.get()), 1));


        FeatureUtils.register(pContext, PATCH_ASHGRASS,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.ASHGRASS.get()), 32));

        FeatureUtils.register(pContext, PATCH_POISONGRASS,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.POISONGRASS.get()), 66));

        FeatureUtils.register(pContext, PATCH_HEAP_GRASS,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.HEAP_GRASS.get()), 26));

        FeatureUtils.register(pContext, PATCH_RUSTY_BUSH,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.RUSTY_BUSH.get()), 12));


        FeatureUtils.register(pContext, STARBERRY_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.STARBERRY.get().defaultBlockState(), 2)), 31));

        FeatureUtils.register(pContext, CRANBERRY_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.CRANBERRY.get().defaultBlockState(), 3)), 40));

    }

    private static RandomPatchConfiguration vegetationPatch(BlockStateProvider p_195203_, int p_195204_) {
        return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(p_195203_)));
    }
}
