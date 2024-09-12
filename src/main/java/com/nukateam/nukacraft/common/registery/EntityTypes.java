package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.entities.blocks.ChairBlockEntity;
import com.nukateam.nukacraft.common.foundation.entities.misc.*;
import com.nukateam.nukacraft.common.foundation.entities.mobs.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiFunction;

import static net.minecraft.world.entity.EntityType.Builder;

public class EntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NukaCraftMod.MOD_ID);

    public static final RegistryObject<EntityType<BaseballGrenadeEntity>> BASEBALL_GRENADE_ENTITY =
            registerBasic("baseball_grenade_entity", BaseballGrenadeEntity::new);

    public static final RegistryObject<EntityType<Entity>> CHAIRENTITY =
            registerEntity("chairblockentity", Builder
                    .of(ChairBlockEntity::new, MobCategory.MISC)
                    .sized(0f, 0f));

    public static final RegistryObject<EntityType<Deathclaw>> DEATHCLAW =
            registerEntity("deathclaw", Builder
                    .of(Deathclaw::new, MobCategory.MONSTER)
                    .sized(1.5f, 3f));


//    public static final RegistryObject<EntityType<WeaponDisplay>> WEAPON_DISPLAY =
//            registerEntity("weapon_display_entity", Builder
//                    .of(WeaponDisplay::new, MobCategory.MISC)
//                    .sized(0.5F, 0.5F)
//                    .clientTrackingRange(10)
//                    .updateInterval(Integer.MAX_VALUE));

    public static final RegistryObject<EntityType<MiniNukeEntity>> MININUKE = registerBasic("mini_nuke", MiniNukeEntity::new);

    public static final RegistryObject<EntityType<PowerArmorFrame>> POWER_ARMOR_FRAME =
            registerEntity("power_armor_frame", Builder
                    .of(PowerArmorFrame::new, MobCategory.MISC)
                    .sized(1.0f, 2.3f));

    public static final RegistryObject<EntityType<Raider>> RAIDER =
            registerEntity("raider", Builder
                    .of(Raider::new, MobCategory.CREATURE)
                    .sized(1.0f, 1.9f));

    public static final RegistryObject<EntityType<Radroach>> RADROACH =
            registerEntity("radroach", Builder
                    .of(Radroach::new, MobCategory.MONSTER)
                    .sized(0.5f, 0.25f));

    public static final RegistryObject<EntityType<Brahmin>> BRAHMIN =
            registerEntity("brahmin", Builder
                    .of(Brahmin::new, MobCategory.CREATURE)
                    .sized(1.0f, 1.0f));

    public static final RegistryObject<EntityType<Bloatfly>> BLOATFLY =
            registerEntity("bloatfly", Builder
                    .of(Bloatfly::new, MobCategory.MONSTER)
                    .sized(1.0f, 1.0f));

    public static final RegistryObject<EntityType<Molerat>> MOLERAT =
            registerEntity("molerat", Builder
                    .of(Molerat::new, MobCategory.MONSTER)
                    .sized(1.0f, 1.0f));

    public static final RegistryObject<EntityType<Assaultron>> ASSAULTRON =
            registerEntity("assaultron", Builder
                    .of(Assaultron::new, MobCategory.MONSTER)
                    .sized(0.8f, 2.1f)
                    .fireImmune());

    public static final RegistryObject<EntityType<Securitron>> SECURITRON =
            registerEntity("securitron", Builder
                    .of(Securitron::new, MobCategory.MONSTER)
                    .sized(1.35f, 2.3f)
                    .fireImmune());

    public static final RegistryObject<EntityType<NuclearExplosionEffectEntity>> NUCLEAR_EXPLOSION_EFFECT
            = ENTITY_TYPES.register("nuclear_explosion_effect", () -> Builder
            .of(NuclearExplosionEffectEntity::new, MobCategory.MISC)
            .sized(10.5F, 10.5F)
            .clientTrackingRange(20)
            .build("nuclear_explosion_effect"));

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String entityName, EntityType.Builder<T> builder) {
        NukaCraftMod.LOGGER.debug(entityName + "ENTITY REGISTERED");
        return ENTITY_TYPES.register(entityName, () -> builder.build(new ResourceLocation(NukaCraftMod.MOD_ID, entityName).toString()));
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> registerBasic(String id, BiFunction<EntityType<T>, Level, T> function) {
        return ENTITY_TYPES.register(id, () -> Builder.of(function::apply, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .setTrackingRange(100)
                .setUpdateInterval(1)
                //.noSummon()
                .fireImmune()
                .setShouldReceiveVelocityUpdates(true).build(id));
    }

    public static final RegistryObject<EntityType<NuclearExplosionEntity>> NUCLEAR_EXPLOSION
            = ENTITY_TYPES.register("nuclear_explosion", () -> (EntityType) EntityType.Builder
            .of(NuclearExplosionEntity::new, MobCategory.MISC)
            .sized(0.99F, 0.99F)
            .setCustomClientFactory(NuclearExplosionEntity::new)
            .setUpdateInterval(1)
            .setShouldReceiveVelocityUpdates(true)
            .updateInterval(10)
            .clientTrackingRange(20)
            .build("nuclear_explosion"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }


}
