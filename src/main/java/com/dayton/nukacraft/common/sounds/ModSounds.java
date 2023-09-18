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
    public static final RegistryObject<SoundEvent> ITEM_10MM_RELOAD = register("item.pistol10mm.reload");


    public static final RegistryObject<SoundEvent> ITEM_38MM_FIRE = register("item.pistol38mm.fire");
    public static final RegistryObject<SoundEvent> ITEM_38MM_ENCHANTED_FIRE = register("item.pistol38mm.enchanted_fire");
    public static final RegistryObject<SoundEvent> ITEM_38MM_SILENCED_FIRE = register("item.pistol38mm.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_38MM_COCK = register("item.pistol38mm.cock");
    public static final RegistryObject<SoundEvent> ITEM_38MM_RELOAD = register("item.pistol38mm.reload");


    public static final RegistryObject<SoundEvent> ITEM_45MM_FIRE = register("item.pistol45mm.fire");
    public static final RegistryObject<SoundEvent> ITEM_45MM_ENCHANTED_FIRE = register("item.pistol45mm.enchanted_fire");
    public static final RegistryObject<SoundEvent> ITEM_45MM_SILENCED_FIRE = register("item.pistol45mm.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_45MM_COCK = register("item.pistol45mm.cock");
    public static final RegistryObject<SoundEvent> ITEM_45MM_RELOAD = register("item.pistol45mm.reload");



    public static RegistryObject<SoundEvent> register(String key) {
        return SOUNDS.register(key, () -> new SoundEvent(new ResourceLocation(NukaCraftMod.MOD_ID, key)));
    }
}
