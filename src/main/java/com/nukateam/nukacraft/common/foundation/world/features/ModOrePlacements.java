package com.nukateam.nukacraft.common.foundation.world.features;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;
import static com.nukateam.nukacraft.common.foundation.world.features.OreFeatures.ORE_LEAD_PLACE;

public class ModOrePlacements {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, NukaCraftMod.MOD_ID);

    public static final RuleTest STONE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static final RuleTest DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    public static final ResourceKey<PlacedFeature> TREES_ASH_HEAP = registerKey("trees_ash_heap");

   public static final ResourceKey<PlacedFeature> ORE_LEAD      = registerKey("ore_lead"     );
   public static final ResourceKey<PlacedFeature> ORE_SILVER    = registerKey("ore_silver"   );
   public static final ResourceKey<PlacedFeature> ORE_BLACK_TITAN = registerKey("ore_btitan"   );
   public static final ResourceKey<PlacedFeature> ORE_URAN      = registerKey("ore_uran"     );
   public static final ResourceKey<PlacedFeature> ORE_ULTRACITE = registerKey("ore_ultracite");
   public static final ResourceKey<PlacedFeature> ORE_ALUMI     = registerKey("ore_alumi"    );

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var features = context.lookup(Registries.CONFIGURED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ORE_LEAD, new PlacedFeature(features.getOrThrow(OreFeatures.ORE_LEAD_PLACE),
                commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.bottom(),
                                VerticalAnchor.absolute(45))))
        );

        context.register(ORE_SILVER        , new PlacedFeature(features.getOrThrow(OreFeatures.ORE_SILVER_PLACE),
                commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(20))))
        );

        context.register(ORE_BLACK_TITAN   , new PlacedFeature(features.getOrThrow(OreFeatures.ORE_BTITAN_PLACE),
                        commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(11))))
        );

        context.register(ORE_URAN          , new PlacedFeature(features.getOrThrow(OreFeatures.ORE_URAN_PLACE),
                        commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(11))))
        );

        context.register(ORE_ULTRACITE     , new PlacedFeature(features.getOrThrow(OreFeatures.ORE_ULTRACITE_PLACE),
                        commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))))
        );

        context.register(ORE_ALUMI         , new PlacedFeature(features.getOrThrow(OreFeatures.ORE_ALUMI_PLACE),
                        commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))))
        );
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, nukaResource(name));
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier p_195345_) {
        return List.of(CountPlacement.of(count), InSquarePlacement.spread(), p_195345_, BiomeFilter.biome());
    }

}
