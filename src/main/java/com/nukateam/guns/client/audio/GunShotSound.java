package com.nukateam.guns.client.audio;

import com.nukateam.guns.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;

/**
 * Author: MrCrayfish
 */
public class GunShotSound extends AbstractSoundInstance {
    public GunShotSound(ResourceLocation soundIn, SoundSource categoryIn, float x, float y, float z, float volume, float pitch, boolean reload) {
        super(soundIn, categoryIn);
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.attenuation = Attenuation.NONE;

        var player = Minecraft.getInstance().player;
        if (player != null) {
            float distance = reload ? Config.SERVER.reloadMaxDistance.get().floatValue() : Config.SERVER.gunShotMaxDistance.get().floatValue();
            this.volume = volume * (1.0F - Math.min(1.0F, (float) Math.sqrt(player.distanceToSqr(x, y, z)) / distance));
            this.volume *= this.volume; //Ease the volume instead of linear
        }
    }

    public GunShotSound(ResourceLocation soundIn, SoundSource categoryIn, Vec3 position, float volume, float pitch, boolean reload) {
        super(soundIn, categoryIn);
        this.x = position.x;
        this.y = position.y;
        this.z = position.z;
        this.pitch = pitch;
        this.attenuation = Attenuation.NONE;


        var player = Minecraft.getInstance().player;
        if (player != null) {
            float distance = reload ? Config.SERVER.reloadMaxDistance.get().floatValue() : Config.SERVER.gunShotMaxDistance.get().floatValue();
            this.volume = volume * (1.0F - Math.min(1.0F, (float) Math.sqrt(player.distanceToSqr(x, y, z)) / distance));
            this.volume *= this.volume; //Ease the volume instead of linear
        }
    }
}
