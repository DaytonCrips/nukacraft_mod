package com.dayton.nukacraft.client.models.endity.core;

import com.dayton.nukacraft.common.foundation.entities.NuclearExplosionEffectEntity;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.client.event.*;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

import static com.dayton.nukacraft.NukaCraftMod.MOD_EVENT_BUS;
import static com.dayton.nukacraft.common.data.utils.Resources.nukaResource;
import static com.dayton.nukacraft.common.foundation.entities.NuclearExplosionEffectEntity.SHAKE_DISTANCE;

public class ClientProxy {
    public static final ResourceLocation BOMB_FLASH = nukaResource( "textures/misc/bomb_flash.png");
    public static final ResourceLocation WATCHER_EFFECT = nukaResource( "textures/misc/watcher_effect.png");
    public static final ResourceLocation IRRADIATED_SHADER = nukaResource( "shaders/post/irradiated.json");
    public static final ResourceLocation HOLOGRAM_SHADER = nukaResource( "shaders/post/hologram.json");
    public static int lastTremorTick = -1;
    public static float[] randomTremorOffsets = new float[3];

    public static void clientInit() {
//        MOD_EVENT_BUS.addListener(ClientLayerRegistry::addLayers);
        MOD_EVENT_BUS.addListener(ClientProxy::registerShaders);
    }

    private static void registerShaders(final RegisterShadersEvent e) {
        try {
            e.registerShader(new ShaderInstance(e.getResourceManager(), nukaResource( "rendertype_ferrouslime_gel"),
                    DefaultVertexFormat.NEW_ENTITY), ACInternalShaders::setRenderTypeFerrouslimeGelShader);

            e.registerShader(new ShaderInstance(e.getResourceManager(), nukaResource( "rendertype_hologram"),
                    DefaultVertexFormat.POSITION_COLOR), ACInternalShaders::setRenderTypeHologramShader);

            e.registerShader(new ShaderInstance(e.getResourceManager(), nukaResource( "rendertype_irradiated"),
                    DefaultVertexFormat.POSITION_COLOR_TEX), ACInternalShaders::setRenderTypeIrradiatedShader);

            e.registerShader(new ShaderInstance(e.getResourceManager(), nukaResource( "rendertype_bubbled"),
                    DefaultVertexFormat.NEW_ENTITY), ACInternalShaders::setRenderTypeBubbledShader);

            e.registerShader(new ShaderInstance(e.getResourceManager(), nukaResource( "rendertype_sepia"),
                    DefaultVertexFormat.NEW_ENTITY), ACInternalShaders::setRenderTypeSepiaShader);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static ArrayList<NuclearExplosionEffectEntity> getNukesAround(){
        var minecraft = Minecraft.getInstance();
        var result = new ArrayList<NuclearExplosionEffectEntity>();
        if(minecraft.player == null) return result;

        var explosions = minecraft.level.getEntities(minecraft.player,
                minecraft.player.getBoundingBox().inflate(SHAKE_DISTANCE, SHAKE_DISTANCE, SHAKE_DISTANCE),
                (entity -> entity instanceof NuclearExplosionEffectEntity));

        explosions.forEach((entity) -> result.add((NuclearExplosionEffectEntity)entity));

        return result;
    }

    @Nullable
    public static Double getDistanceToNearestExplosion(){
        var nukes = getNukesAround();
        if(nukes.isEmpty()) return null;
        return min(nukes,(nuke) -> nuke.getDistanceToPlayer());
    }

    public static <T> Double min(List<T> list, Function<T, Double> comparator){
        var min = comparator.apply(list.get(0));

        for (T t : list) {
            var num = comparator.apply(t);
            if (num < min) min = num;
        }

        return min;
    }

    public static float getNukeFlashAmount(NuclearExplosionEffectEntity entity, float partialTicks) {
        return entity.prevNukeFlashAmount + (entity.nukeFlashAmount - entity.prevNukeFlashAmount) * partialTicks;
    }

    public static float getPossessionStrengthAmount(NuclearExplosionEffectEntity entity,float partialTicks) {
        return entity.prevPossessionStrengthAmount + (entity.possessionStrengthAmount - entity.prevPossessionStrengthAmount) * partialTicks;
    }

    public static float getPartialTicks() {
        return Minecraft.getInstance().getFrameTime();
    }

    public static void preScreenRender(float partialTick) {
        float screenEffectIntensity = Minecraft.getInstance().options.screenEffectScale;

        getNukesAround().forEach((nuke) -> {

            float watcherPossessionStrength = getPossessionStrengthAmount(nuke, partialTick);
            float nukeFlashAmount = getNukeFlashAmount(nuke, partialTick);
            createFlash(screenEffectIntensity, watcherPossessionStrength, nukeFlashAmount);
        });
    }

    private static void createFlash(float screenEffectIntensity, float watcherPossessionStrength, float nukeFlashAmount) {
        if (nukeFlashAmount > 0) {
            int screenWidth = Minecraft.getInstance().getWindow().getGuiScaledWidth();
            int screenHeight = Minecraft.getInstance().getWindow().getGuiScaledHeight();
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, nukeFlashAmount * screenEffectIntensity);
            RenderSystem.setShaderTexture(0, ClientProxy.BOMB_FLASH);
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
        if (watcherPossessionStrength > 0) {
            int screenWidth = Minecraft.getInstance().getWindow().getGuiScaledWidth();
            int screenHeight = Minecraft.getInstance().getWindow().getGuiScaledHeight();
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, watcherPossessionStrength * screenEffectIntensity);
            RenderSystem.setShaderTexture(0, ClientProxy.WATCHER_EFFECT);
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

    public boolean isFirstPersonPlayer(Entity entity) {
        return entity.equals(Minecraft.getInstance().cameraEntity) && Minecraft.getInstance().options.getCameraType().isFirstPerson();
    }
}

