package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> REGISTER = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NukaCraftMod.MOD_ID);

//    public static final RegistryObject<SoundEvent> NUCLEAR_EXPLOSION = createSoundEvent("nuclear_explosion");
//    public static final RegistryObject<SoundEvent> LARGE_NUCLEAR_EXPLOSION = createSoundEvent("large_nuclear_explosion");
//    public static final RegistryObject<SoundEvent> NUCLEAR_EXPLOSION_RUMBLE = createSoundEvent("nuclear_explosion_rumble");
//    public static final RegistryObject<SoundEvent> NUCLEAR_EXPLOSION_RINGING = createSoundEvent("nuclear_explosion_ringing");

    private static RegistryObject<SoundEvent> createSoundEvent(final String soundName) {
        return REGISTER.register(soundName, () -> new SoundEvent(nukaResource(soundName)));
    }
}
