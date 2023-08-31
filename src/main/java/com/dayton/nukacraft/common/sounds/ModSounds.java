package com.dayton.nukacraft.common.sounds;

import com.dayton.nukacraft.NukaCraftMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NukaCraftMod.MOD_ID);
    public static final RegistryObject<SoundEvent> ITEM_10MM_FIRE = register("item.pistol10mm.fire");
    public static final RegistryObject<SoundEvent> ITEM_10MM_ENCHANTED_FIRE = register("item.pistol10mm.enchanted_fire");
    public static final RegistryObject<SoundEvent> ITEM_10MM_SILENCED_FIRE = register("item.pistol10mm.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_10MM_COCK = register("item.pistol10mm.cock");
//    public static final RegistryObject<SoundEvent> ITEM_10MM_RELOAD = register("item.pistol10mm.reload");


    public static RegistryObject<SoundEvent> register(String key) {
        return SOUNDS.register(key, () -> new SoundEvent(new ResourceLocation(NukaCraftMod.MOD_ID, key)));
    }
}
