package com.nukateam.nukacraft.common.foundation.world.features.placed;

import com.nukateam.nukacraft.common.foundation.world.features.configured.OreFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class ModOrePlacements {
//    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, NukaCraftMod.MOD_ID);

//    public static final RuleTest STONE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
//    public static final RuleTest DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    public static final ResourceKey<PlacedFeature> ORE_LEAD = registerKey("ore_lead");
    public static final ResourceKey<PlacedFeature> ORE_SILVER = registerKey("ore_silver");
    public static final ResourceKey<PlacedFeature> ORE_BLACK_TITAN = registerKey("ore_black_titan");
    public static final ResourceKey<PlacedFeature> ORE_URAN = registerKey("ore_uran");
    public static final ResourceKey<PlacedFeature> ORE_ULTRACITE = registerKey("ore_ultracite");
    public static final ResourceKey<PlacedFeature> ORE_ALUMINIUM = registerKey("ore_alumi");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var features = context.lookup(Registries.CONFIGURED_FEATURE);

        var t1 = "minecraft:worldgen/placed_feature=net.minecraft.core.RegistrySetBuilder$UniversalLookup@50f07c30";
        var t2 = "minecraft:worldgen/placed_feature=net.minecraft.core.RegistrySetBuilder$UniversalLookup@50f07c30";

        context.register(ORE_LEAD, new PlacedFeature(features.getOrThrow(OreFeatures.ORE_LEAD_PLACE),
                commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.bottom(),
                        VerticalAnchor.absolute(45))))
        );

        context.register(ORE_SILVER, new PlacedFeature(features.getOrThrow(OreFeatures.ORE_SILVER_PLACE),
                commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(20))))
        );

        context.register(ORE_BLACK_TITAN, new PlacedFeature(features.getOrThrow(OreFeatures.ORE_BLACK_TITAN_PLACE),
                commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(11))))
        );

        context.register(ORE_URAN, new PlacedFeature(features.getOrThrow(OreFeatures.ORE_URAN_PLACE),
                commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(11))))
        );

        context.register(ORE_ULTRACITE, new PlacedFeature(features.getOrThrow(OreFeatures.ORE_ULTRACITE_PLACE),
                commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))))
        );

        context.register(ORE_ALUMINIUM, new PlacedFeature(features.getOrThrow(OreFeatures.ORE_ALUMINIUM_PLACE),
                commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))))
        );
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, nukaResource(name));
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier p_195345_) {
        return List.of(CountPlacement.of(count), InSquarePlacement.spread(), p_195345_, BiomeFilter.biome());
    }

}
