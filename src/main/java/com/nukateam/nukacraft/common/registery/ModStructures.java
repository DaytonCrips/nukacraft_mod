package com.nukateam.nukacraft.common.registery;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.structures.WorldStructures;
import net.minecraft.world.level.levelgen.feature.StructureFeature;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModStructures {
    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, NukaCraftMod.MOD_ID);
    public static final RegistryObject<StructureFeature<?>> WORLD_STRUCTURES = DEFERRED_REGISTRY_STRUCTURE.register("world_structures", WorldStructures::new);

}
