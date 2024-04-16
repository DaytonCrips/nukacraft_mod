package com.nukateam.nukacraft.common.foundation.world;

import com.mojang.serialization.Codec;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.structures.WorldStructures;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModStructures {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE =
            DeferredRegister.create(Registries.STRUCTURE_TYPE, NukaCraftMod.MOD_ID);

    public static final RegistryObject<StructureType<WorldStructures>> WORLD_STRUCTURE =
            DEFERRED_REGISTRY_STRUCTURE.register("world_structures", () -> explicitStructureTypeTyping(WorldStructures.CODEC));

    private static <T extends Structure> StructureType<T> explicitStructureTypeTyping(Codec<T> structureCodec) {
        return () -> structureCodec;
    }
}
