package com.nukateam.nukacraft.client.helpers;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.nukateam.nukacraft.common.data.utils.ExplosionType;
import com.nukateam.nukacraft.common.foundation.entities.misc.NuclearExplosionEffectEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;
import static com.nukateam.nukacraft.common.registery.EntityTypes.NUCLEAR_EXPLOSION;
import static com.nukateam.nukacraft.common.registery.EntityTypes.NUCLEAR_EXPLOSION_EFFECT;

public class ExplosionUtils {
    public static final ResourceLocation BOMB_FLASH = nukaResource("textures/misc/bomb_flash.png");
    public static final int EXPLOSION_SEARCH_DISTANCE = 45;
    public static int lastTremorTick = -1;

    @OnlyIn(Dist.CLIENT)
    public static void preScreenRender(float partialTick) {
        var screenEffectIntensity = Minecraft.getInstance().options.screenEffectScale().get();

        getNukesAround().forEach((nuke) -> {
            float nukeFlashAmount = getNukeFlashAmount(nuke, partialTick);
            createFlash(screenEffectIntensity, nukeFlashAmount);
        });
    }

    public static void createNuclearExplosion(Entity entity, ExplosionType type) {
        var level = entity.level();
        var explosion = NUCLEAR_EXPLOSION.get().create(level);
        explosion.copyPosition(entity);
        explosion.setSize(type.size());
        level.addFreshEntity(explosion);

        var explosionEffect = NUCLEAR_EXPLOSION_EFFECT.get().create(level);
        explosionEffect.copyPosition(entity);
        explosionEffect.setType(type);
        level.addFreshEntity(explosionEffect);
    }

    @OnlyIn(Dist.CLIENT)
    public static ArrayList<NuclearExplosionEffectEntity> getNukesAround() {
        var minecraft = Minecraft.getInstance();
        var result = new ArrayList<NuclearExplosionEffectEntity>();
        if (minecraft.player == null) return result;

        var explosions = minecraft.level.getEntities(minecraft.player,
                minecraft.player.getBoundingBox().inflate(EXPLOSION_SEARCH_DISTANCE),
                (entity -> entity instanceof NuclearExplosionEffectEntity));

        explosions.forEach((entity) -> result.add((NuclearExplosionEffectEntity) entity));

        return result;
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public static Double getDistanceToNearestExplosion() {
        var nukes = getNukesAround();
        if (nukes.isEmpty()) return null;
        return min(nukes, (nuke) -> nuke.getDistanceToPlayer());
    }

    public static <T> Double min(List<T> list, Function<T, Double> comparator) {
        var min = comparator.apply(list.get(0));

        for (T t : list) {
            var num = comparator.apply(t);
            if (num < min) min = num;
        }

        return min;
    }

    @OnlyIn(Dist.CLIENT)
    public static float getNukeFlashAmount(NuclearExplosionEffectEntity entity, float partialTicks) {
        return entity.prevNukeFlashAmount + (entity.nukeFlashAmount - entity.prevNukeFlashAmount) * partialTicks;
    }

    @OnlyIn(Dist.CLIENT)
    private static void createFlash(double screenEffectIntensity, float nukeFlashAmount) {
        if (nukeFlashAmount > 0) {
            int screenWidth = Minecraft.getInstance().getWindow().getGuiScaledWidth();
            int screenHeight = Minecraft.getInstance().getWindow().getGuiScaledHeight();
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, nukeFlashAmount * (float) screenEffectIntensity);
            RenderSystem.setShaderTexture(0, BOMB_FLASH);
            Tesselator tesselator = Tesselator.getInstance();
            BufferBuilder bufferbuilder = tesselator.getBuilder();
            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
            bufferbuilder.vertex(0.0D, screenHeight, -90.0D).uv(0.0F, 1.0F).endVertex();
            bufferbuilder.vertex(screenWidth, screenHeight, -90.0D).uv(1.0F, 1.0F).endVertex();
            bufferbuilder.vertex(screenWidth, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
            bufferbuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
            tesselator.end();
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
