package com.dayton.nukacraft.common.entities;

import com.dayton.nukacraft.NukaCraftMod;
import com.mrcrayfish.guns.entity.MissileEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiFunction;

public class EntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, NukaCraftMod.MOD_ID);

    public static final RegistryObject<EntityType<Deathclaw>> DEATHCLAW =
            registerEntity("deathclaw", EntityType.Builder
                    .of(Deathclaw::new, MobCategory.MONSTER)
                    .sized(1.5f, 3f));

    public static final RegistryObject<EntityType<MiniNukeEntity>> MININUKE = registerBasic("mini_nuke", MiniNukeEntity::new);

    public static final RegistryObject<EntityType<PowerArmorFrame>> POWER_ARMOR_FRAME =
            registerEntity("power_armor_frame", EntityType.Builder
                    .of(PowerArmorFrame::new, MobCategory.MISC)
                    .sized(1.0f, 2.3f));

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String entityName, EntityType.Builder<T> builder) {
        NukaCraftMod.LOGGER.debug("ENTITY REGISTERED");
        return ENTITY_TYPES.register(entityName, () -> builder.build(new ResourceLocation(NukaCraftMod.MOD_ID, entityName).toString()));
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> registerBasic(String id, BiFunction<EntityType<T>, Level, T> function)
    {

        return ENTITY_TYPES.register(id, () -> EntityType.Builder.of(function::apply, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .setTrackingRange(100)
                .setUpdateInterval(1)
                //.noSummon()
                .fireImmune()
                .setShouldReceiveVelocityUpdates(true).build(id));
    }



    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
