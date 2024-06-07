package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_TYPES;
    public static final RegistryObject<PaintingVariant> NUKACOLA;
    public static final RegistryObject<PaintingVariant> QUANTCOLA;
    public static final RegistryObject<PaintingVariant> SUGAR_BOMB_PROMO;

    public ModPaintings() {
    }
    static {
        PAINTING_TYPES = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, NukaCraftMod.MOD_ID);
        NUKACOLA = PAINTING_TYPES.register("nukacola", () -> {
            return new PaintingVariant(16, 32);
        });
        QUANTCOLA = PAINTING_TYPES.register("quantcola", () -> {
            return new PaintingVariant(16, 32);
        });
        SUGAR_BOMB_PROMO = PAINTING_TYPES.register("sugar_bomb_promo", () -> {
            return new PaintingVariant(32, 16);
        });
    }
}