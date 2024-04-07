package com.nukateam.nukacraft.common.registery.fluid;

import com.mojang.math.Vector3f;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class ModFluidTypes {
    public static final ResourceLocation ACID_STILL_RL = nukaResource("fluid/acid_still");
    public static final ResourceLocation ACID_FLOWING_RL = nukaResource("fluid/acid_flow");
    public static final ResourceLocation ACID_OVERLAY_RL = nukaResource("fluid/acid_overlay");

    public static final ResourceLocation POISONOUS_WATER_STILL_RL = nukaResource("fluid/acid_still");
    public static final ResourceLocation POISONOUS_WATER_FLOWING_RL = nukaResource("fluid/acid_flow");
    public static final ResourceLocation POISONOUS_WATER_OVERLAY_RL = nukaResource("fluid/acid_overlay");

    public static final ResourceLocation DIRTY_WATER_STILL_RL = nukaResource("fluid/acid_still");
    public static final ResourceLocation DIRTY_WATER_FLOWING_RL = nukaResource("fluid/acid_flow");
    public static final ResourceLocation DIRTY_WATER_OVERLAY_RL = nukaResource("fluid/acid_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, NukaCraftMod.MOD_ID);

    public static final RegistryObject<FluidType> ACID_FLUID_TYPE = register("acid_fluid",
            ACID_STILL_RL, ACID_FLOWING_RL, ACID_OVERLAY_RL,
            FluidType.Properties.create()
                    .lightLevel(2)
                    .density(20)
                    .viscosity(5)
                    .canHydrate(false)
                    .canConvertToSource(false)
                    .sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK));

    public static final RegistryObject<FluidType> DIRTY_WATER_FLUID_TYPE = register("dirty_water_fluid",
            DIRTY_WATER_STILL_RL, DIRTY_WATER_FLOWING_RL, DIRTY_WATER_OVERLAY_RL,
            FluidType.Properties.create()
                    .density(20)
                    .viscosity(5)
                    .sound(SoundAction.get("empty"), SoundEvents.BUCKET_EMPTY));

    public static final RegistryObject<FluidType> POISONOUS_WATER_FLUID_TYPE = register("poisonous_water_fluid",
            POISONOUS_WATER_STILL_RL, POISONOUS_WATER_FLOWING_RL, POISONOUS_WATER_OVERLAY_RL,
            FluidType.Properties.create()
                    .density(20)
                    .viscosity(5)
                    .sound(SoundAction.get("empty"), SoundEvents.BUCKET_EMPTY));


    private static RegistryObject<FluidType> register(String name,
                                                      ResourceLocation still,
                                                      ResourceLocation flowing,
                                                      ResourceLocation overlay,
                                                      FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(
                ACID_STILL_RL, ACID_FLOWING_RL, ACID_OVERLAY_RL,
                0xA1E038D0,
                new Vector3f(224f / 255f, 56f / 255f, 208f / 255f),
                properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}