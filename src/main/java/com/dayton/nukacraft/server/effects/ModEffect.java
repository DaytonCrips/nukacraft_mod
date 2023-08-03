package com.dayton.nukacraft.server.effects;

import com.dayton.nukacraft.NukaCraftMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffect {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<MobEffect> RAD_RES = MOB_EFFECTS.register("rad_res", () -> new RadResistEffect(MobEffectCategory.HARMFUL, -4588069));
    public static final RegistryObject<MobEffect> QUANT_SHIELD = MOB_EFFECTS.register("quant_shield", () -> new RadResistEffect(MobEffectCategory.HARMFUL, -4588069));
    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
