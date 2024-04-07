package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintingList {
    public static final DeferredRegister<Painting> PAINTING_TYPES = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<Painting> NUKACOLA = PAINTING_TYPES.register("nukacola", () -> new PaintingVariant(16, 32));
    public static final RegistryObject<Painting> QUANTCOLA = PAINTING_TYPES.register("quantcola", () -> new PaintingVariant(16, 32));
}
