package com.nukateam.nukacraft.common.registery;

import com.mojang.serialization.Codec;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.structures.SkyStructures;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModStructures {
    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE =
            DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, NukaCraftMod.MOD_ID);

    public static final RegistryObject<StructureType<SkyStructures>> SKY_STRUCTURES =
            DEFERRED_REGISTRY_STRUCTURE.register("sky_structures", () -> explicitStructureTypeTyping(SkyStructures.CODEC));


    private static <T extends Structure> StructureType<T> explicitStructureTypeTyping(Codec<T> structureCodec) {
        return () -> structureCodec;
    }
}
