package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.registries.ForgeRegistries;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class ModDimension {
    public static final ResourceLocation WASTELAND_RESOURCE = nukaResource("fallout_wasteland");

    public static final ResourceKey<Level> FALLOUT_WASTELAND = ResourceKey.create(Registry.DIMENSION_REGISTRY, WASTELAND_RESOURCE);

    public static final ResourceKey<DimensionType> FALLOUT_WASTELAND_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, WASTELAND_RESOURCE);

    public static void register() {
        System.out.println("Registering ModDimensions for " + NukaCraftMod.MOD_ID);
    }
}
