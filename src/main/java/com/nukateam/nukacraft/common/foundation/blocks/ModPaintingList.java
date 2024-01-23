package com.nukateam.nukacraft.common.foundation.blocks;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintingList {
    public static final DeferredRegister<Motive> PAINTING_TYPES = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, NukaCraftMod.MOD_ID);

    public static final RegistryObject<Motive> NUKACOLA = PAINTING_TYPES.register("nukacola", () -> new Motive(16,32));
    public static final RegistryObject<Motive> QUANTCOLA = PAINTING_TYPES.register("quantcola", () -> new Motive(16,32));
}
