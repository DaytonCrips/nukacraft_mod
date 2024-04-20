package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<SoundEvent> ITEM_10MM_FIRE = register("item.pistol10mm.fire");
    public static final RegistryObject<SoundEvent> ITEM_10MM_ENCHANTED_FIRE = register("item.pistol10mm.enchanted_fire");
    public static final RegistryObject<SoundEvent> ITEM_10MM_SILENCED_FIRE = register("item.pistol10mm.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_10MM_COCK = register("item.pistol10mm.cock");
    public static final RegistryObject<SoundEvent> ITEM_10MM_RELOAD = register("item.pistol10mm.reload");

    public static final RegistryObject<SoundEvent> ITEM_LASER_GATLING_FIRE = register("item.laser_gatling.fire");
    //public static final RegistryObject<SoundEvent> ITEM_LASER_RIFLE_ENCHANTED_FIRE = register("item.laser_rifle.enchanted_fire");
    //public static final RegistryObject<SoundEvent> ITEM_LASER_RIFLE_SILENCED_FIRE = register("item.laser_rifle.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_LASER_GATLING_COCK = register("item.laser_gatling.cock");
    public static final RegistryObject<SoundEvent> ITEM_LASER_GATLING_RELOAD = register("item.laser_gatling.reload");


    public static final RegistryObject<SoundEvent> ITEM_PUMPSHOTGUN_FIRE = register("item.pump_shotgun.fire");
    //public static final RegistryObject<SoundEvent> ITEM_PUMPSHOTGUN_ENCHANTED_FIRE = register("item.pump_shotgun.enchanted_fire");
    //public static final RegistryObject<SoundEvent> ITEM_PUMPSHOTGUN_SILENCED_FIRE = register("item.pump_shotgun.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_PUMPSHOTGUN_COCK = register("item.pump_shotgun.cock");
    public static final RegistryObject<SoundEvent> ITEM_PUMPSHOTGUN_RELOAD = register("item.pump_shotgun.reload");

    public static final RegistryObject<SoundEvent> ITEM_LASER_PISTOL_FIRE = register("item.laser_pistol.fire");
    //public static final RegistryObject<SoundEvent> ITEM_LASER_RIFLE_ENCHANTED_FIRE = register("item.laser_rifle.enchanted_fire");
    //public static final RegistryObject<SoundEvent> ITEM_LASER_RIFLE_SILENCED_FIRE = register("item.laser_rifle.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_LASER_PISTOL_COCK = register("item.laser_pistol.cock");
    public static final RegistryObject<SoundEvent> ITEM_LASER_PISTOL_RELOAD = register("item.laser_pistol.reload");

    public static final RegistryObject<SoundEvent> ITEM_TESLA_RIFLE_FIRE = register("item.tesla_carbine.fire");
    //public static final RegistryObject<SoundEvent> ITEM_TESLA_RIFLE_ENCHANTED_FIRE = register("item.tesla_carbine.enchanted_fire");
    //public static final RegistryObject<SoundEvent> ITEM_TESLA_RIFLE_SILENCED_FIRE = register("item.tesla_carbine.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_TESLA_RIFLE_COCK = register("item.tesla_carbine.cock");
    public static final RegistryObject<SoundEvent> ITEM_TESLA_RIFLE_RELOAD = register("item.tesla_carbine.reload");
    public static final RegistryObject<SoundEvent> ITEM_LASER_RIFLE_FIRE = register("item.laser_rifle.fire");
    //public static final RegistryObject<SoundEvent> ITEM_LASER_RIFLE_ENCHANTED_FIRE = register("item.laser_rifle.enchanted_fire");
    //public static final RegistryObject<SoundEvent> ITEM_LASER_RIFLE_SILENCED_FIRE = register("item.laser_rifle.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_LASER_RIFLE_COCK = register("item.laser_rifle.cock");
    public static final RegistryObject<SoundEvent> ITEM_LASER_RIFLE_RELOAD = register("item.laser_rifle.reload");

    public static final RegistryObject<SoundEvent> ITEM_MINIGUN_FIRE = register("item.minigun.fire");

    public static final RegistryObject<SoundEvent> ITEM_38MM_FIRE = register("item.pistol38mm.fire");
    public static final RegistryObject<SoundEvent> ITEM_38MM_ENCHANTED_FIRE = register("item.pistol38mm.enchanted_fire");
    public static final RegistryObject<SoundEvent> ITEM_38MM_SILENCED_FIRE = register("item.pistol38mm.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_38MM_COCK = register("item.pistol38mm.cock");
    public static final RegistryObject<SoundEvent> ITEM_38MM_RELOAD = register("item.pistol38mm.reload");

    public static final RegistryObject<SoundEvent> ITEM_FATMAN_FIRE = register("item.fatman.fire");
    public static final RegistryObject<SoundEvent> ITEM_FATMAN_RELOAD = register("item.fatman.reload");

    public static final RegistryObject<SoundEvent> ITEM_45MM_FIRE = register("item.pistol45mm.fire");
    public static final RegistryObject<SoundEvent> ITEM_45MM_ENCHANTED_FIRE = register("item.pistol45mm.enchanted_fire");
    public static final RegistryObject<SoundEvent> ITEM_45MM_SILENCED_FIRE = register("item.pistol45mm.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_45MM_COCK = register("item.pistol45mm.cock");
    public static final RegistryObject<SoundEvent> ITEM_45MM_RELOAD = register("item.pistol45mm.reload");

    public static final RegistryObject<SoundEvent> NUCLEAR_EXPLOSION = register("misc.nuke.mininuke_explosion");
    public static final RegistryObject<SoundEvent> NUCLEAR_EXPLOSION_RUMBLE = register("misc.nuke.nuclear_explosion_rumble");
    public static final RegistryObject<SoundEvent> NUCLEAR_EXPLOSION_RINGING = register("misc.nuke.nuclear_explosion_ringing");

    public static final RegistryObject<SoundEvent> PIPBOY_UP = register("gui.pipboy.pipboy_up");
    public static final RegistryObject<SoundEvent> PIPBOY_DOWN = register("gui.pipboy.pipboy_down");
    public static final RegistryObject<SoundEvent> PIPBOY_TAB = register("gui.pipboy.pipboy_tab");

    public static RegistryObject<SoundEvent> register(String key) {
        return SOUNDS.register(key, () -> SoundEvent.createVariableRangeEvent(nukaResource(key)));
    }
}
