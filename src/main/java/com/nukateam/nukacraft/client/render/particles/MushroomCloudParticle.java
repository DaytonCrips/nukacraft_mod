package com.nukateam.nukacraft.client.render.particles;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.nukacraft.common.foundation.sounds.NuclearExplosionSound;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

import static com.nukateam.nukacraft.common.registery.ModParticles.MUSHROOM_CLOUD_EXPLOSION;
import static com.nukateam.nukacraft.common.registery.ModParticles.MUSHROOM_CLOUD_SMOKE;
import static com.nukateam.nukacraft.common.registery.ModSounds.*;

public class MushroomCloudParticle extends Particle {
    private static final int BALL_FOR = 10;
    private static final int FADE_SPEED = 10;
    private final float scale;

    private boolean playedRinging;
    private boolean playedExplosion;
    private boolean playedRumble;

    protected MushroomCloudParticle(ClientLevel level, double x, double y, double z, float scale) {
        super(level, x, y, z);
        this.gravity = 0.0F;

        this.lifetime = (int) Math.ceil(133.33F * scale);
        this.scale = scale + 0.2F;
        this.setSize(3.0F, 3.0F);
    }

    public boolean shouldCull() {
        return false;
    }

    public void tick() {
        if (age > 0) {
            if (!playedExplosion) {
                playedExplosion = true;
                playSound(NUCLEAR_EXPLOSION.get(), lifetime - 20, lifetime, 0.2F, false);
            }
        }
        if (age < BALL_FOR) {
            if (!playedRinging /*&& AlexsCaves.CLIENT_CONFIG.nuclearBombFlash.get()*/) {
                playedRinging = true;
                playSound(NUCLEAR_EXPLOSION_RINGING.get(), 100, 50, 0.05F, true);
            }
//            ClientProxy.renderNukeFlashFor = 16;
        } else if (age < lifetime - FADE_SPEED) {
            float life = (float) (Math.log(1 + (age - BALL_FOR) / (float) (lifetime - BALL_FOR))) * 2F;
            float explosionSpread = (12 * life + 4F) * scale;
            for (int i = 0; i < (1 + random.nextInt(2)) * scale; i++) {
                Vec3 from = new Vec3(level.random.nextFloat() - 0.5F, level.random.nextFloat() - 0.5F, level.random.nextFloat() - 0.5F).scale(scale * 1.4F).add(this.x, this.y, this.z);
                Vec3 away = new Vec3(level.random.nextFloat() - 0.5F, level.random.nextFloat() - 0.5F, level.random.nextFloat() - 0.5F).scale(2.34F);
                this.level.addParticle(MUSHROOM_CLOUD_SMOKE.get(), from.x, from.y, from.z, away.x, away.y, away.z);
            }
            for (int j = 0; j < scale * scale; j++) {
                Vec3 explosionBase = new Vec3((level.random.nextFloat() - 0.5F) * explosionSpread, (-0.6F + level.random.nextFloat() * 0.5F) * explosionSpread * 0.1F, (level.random.nextFloat() - 0.5F) * explosionSpread).add(this.x, this.y, this.z);
                this.level.addParticle(MUSHROOM_CLOUD_EXPLOSION.get(), explosionBase.x, explosionBase.y, explosionBase.z, 0, 0, 0);
            }
            if (age > BALL_FOR) {
                if (!playedRumble) {
                    playedRumble = true;
                    playSound(NUCLEAR_EXPLOSION_RUMBLE.get(), lifetime + 100, lifetime, 0.1F, true);
                }
            }
        }
        super.tick();
    }

    private void playSound(SoundEvent soundEvent, int duration, int fadesAt, float fadeInBy, boolean looping) {
        Minecraft.getInstance().getSoundManager()
                .queueTickingSound(new NuclearExplosionSound(soundEvent, this.x, this.y, this.z, duration, fadesAt, fadeInBy, looping));
    }

    public void render(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
        var vec3 = camera.getPosition();
        var x = (float) (Mth.lerp(partialTick, this.xo, this.x) - vec3.x());
        var y = (float) (Mth.lerp(partialTick, this.yo, this.y) - vec3.y());
        var z = (float) (Mth.lerp(partialTick, this.zo, this.z) - vec3.z());
        PoseStack posestack = new PoseStack();
        posestack.pushPose();
        posestack.translate(x, y - 0.5F, z);
        posestack.scale(-scale, -scale, scale);
        posestack.popPose();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    public static class Factory implements ParticleProvider<SimpleParticleType> {
        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            if (xSpeed == 0.0) {
                xSpeed = 1.0F;
            }
            return new MushroomCloudParticle(worldIn, x, y, z, (float) Math.max(0.5F, xSpeed));
        }
    }
}
