package com.nukateam.nukacraft.common.events;

import com.mojang.blaze3d.systems.RenderSystem;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.ModBiomes;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.material.FogType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.CLIENT)
public class FogHandler {
    private static float timer = 0;
    private static Holder<Biome> lastBiome = null;

//    @SubscribeEvent
    public static void onRenderFog(ViewportEvent.RenderFog event) {
        var world = event.getCamera().getEntity().level();
        var pos = event.getCamera().getBlockPosition();
        var biome = world.getBiome(pos);

        timer += 0.05f;
        if(timer > 1) {
            timer = 1;
            lastBiome = biome;
        }

        var start = 1000f;
        var end   = 1000f;

        if (biome.is(ModBiomes.POISON_VALLEY.location())) {
            start = 9f;
//            end   = 65f;

        }
        else if (biome.is(ModBiomes.ASH_HEAP.location())) {
            start = 12f;
//            end   = 87f;
        }
//        renderFog(start, end);
        renderFog(event, start);

    }

    private static void renderFog(float pShaderFogStart, float pShaderFogEnd) {
        RenderSystem.setShaderTexture(0, 0);
        RenderSystem.setShaderFogStart(pShaderFogStart);
        RenderSystem.setShaderFogEnd(pShaderFogEnd);
    }

    public static void renderFog(ViewportEvent.RenderFog event, float density) {
        var world = event.getCamera().getEntity().level();
        var pos = event.getCamera().getBlockPosition();
        var biome = world.getBiome(pos).get();

        var fogtype = event.getCamera().getFluidInCamera();
        var entity = event.getCamera().getEntity();

        float configFogDensity = density;
        float start;
        float end;
        if (fogtype == FogType.LAVA) {
            if (entity.isSpectator()) {
                start = -8.0F;
                end = configFogDensity * 0.5F;
            } else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(MobEffects.FIRE_RESISTANCE)) {
                start = 0.0F;
                end = 3.0F;
            } else {
                start = 0.25F;
                end = 1.0F;
            }
        } else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(MobEffects.BLINDNESS)) {
            int i = Objects.requireNonNull(((LivingEntity) entity).getEffect(MobEffects.BLINDNESS)).getDuration();
            float f1 = Mth.lerp(Math.min(1.0F, (float) i / 20.0F), configFogDensity, 5.0F);
            if (event.getMode() == FogRenderer.FogMode.FOG_SKY) {
                start = 0.0F;
                end = f1 * 0.8F;
            } else {
                start = f1 * 0.25F;
                end = f1;
            }
        } else if (fogtype == FogType.POWDER_SNOW) {
            if (entity.isSpectator()) {
                start = -8.0F;
                end = configFogDensity * 0.5F;
            } else {
                start = 0.0F;
                end = 2.0F;
            }
        } else if (event.getMode() == FogRenderer.FogMode.FOG_SKY) {
            start = 0.0F;
            end = configFogDensity;
        } else {
            float f4 = Mth.clamp(configFogDensity / 10.0F, 4.0F, 64.0F);
            start = configFogDensity - f4;
            end = configFogDensity;
        }
        RenderSystem.setShaderFogStart(start);
        RenderSystem.setShaderFogEnd(end);

        //Particles
//        if (!FogTweaker.BIOME_OVERRIDES.contains(biome)) {
//            if (Configuration.getFogParticlesEnabled() &&
//                    BiomeConfig.getBiomeConfigFor(biome).isParticlesEnabled() &&
//                    !Minecraft.getInstance().isPaused()) {
//                var random = event.getCamera().getEntity().level().getRandom();
//                for (int i = 0; i < BiomeConfig.getBiomeConfigFor(biome).getParticleAmount(); i++) {
//                    Vec3 vec = event.getCamera().getEntity().position().add(0, random.nextDouble() * 3D, 0).add(new Vec3(random.nextDouble() * 3D, 0D, 0D).yRot((float) Math.toRadians(random.nextInt(360))));
//                    event.getCamera().getEntity().level.addParticle((ParticleOptions) Objects.requireNonNull(ForgeRegistries.PARTICLE_TYPES.getValue(new ResourceLocation(BiomeConfig.getBiomeConfigFor(biome).getParticleType()))), vec.x, vec.y, vec.z, 0, 0, 0);
//                }
//            }
//        }
    }
}
