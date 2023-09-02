package com.dayton.nukacraft.common.entities;

import com.dayton.nukacraft.NukaCraftMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, NukaCraftMod.MOD_ID);

    public static final RegistryObject<EntityType<Deathclaw>> DEATHCLAW =
            registerEntity("deathclaw", EntityType.Builder
                    .of(Deathclaw::new, MobCategory.MONSTER)
                    .sized(1.5f, 3f));

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String entityName, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(entityName, () -> builder.build(new ResourceLocation(NukaCraftMod.MOD_ID, entityName).toString()));
    }

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
