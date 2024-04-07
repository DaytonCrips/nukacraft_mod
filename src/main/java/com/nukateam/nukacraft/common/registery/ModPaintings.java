package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<PaintingVariant> NUKACOLA = PAINTING_VARIANTS.register("nukacola",
            () -> new PaintingVariant(16, 32));

    public static final RegistryObject<PaintingVariant> QUANTCOLA = PAINTING_VARIANTS.register("quantcola",
            () -> new PaintingVariant(16, 32));

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}