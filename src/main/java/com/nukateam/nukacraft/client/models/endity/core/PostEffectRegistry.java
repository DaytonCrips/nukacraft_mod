package com.nukateam.nukacraft.client.models.endity.core;

import com.google.gson.JsonSyntaxException;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.util.*;

public class PostEffectRegistry {
    private static List<ResourceLocation> registry = new ArrayList();
    private static Map<ResourceLocation, PostEffect> postEffects = new HashMap();

    public PostEffectRegistry() {
    }

    public static void clear() {
        Iterator var0 = postEffects.values().iterator();

        while(var0.hasNext()) {
            PostEffect postEffect = (PostEffect)var0.next();
            postEffect.close();
        }

        postEffects.clear();
    }

    public static void registerEffect(ResourceLocation resourceLocation) {
        registry.add(resourceLocation);
    }

    public static void onInitializeOutline() {
        clear();
        Minecraft minecraft = Minecraft.getInstance();

        ResourceLocation resourceLocation;
        PostChain postChain;
        RenderTarget renderTarget;
        for(Iterator var1 = registry.iterator(); var1.hasNext(); postEffects.put(resourceLocation, new PostEffect(postChain, renderTarget, false))) {
            resourceLocation = (ResourceLocation)var1.next();

            try {
                postChain = new PostChain(minecraft.getTextureManager(), minecraft.getResourceManager(), minecraft.getMainRenderTarget(), resourceLocation);
                postChain.resize(minecraft.getWindow().getWidth(), minecraft.getWindow().getHeight());
                renderTarget = postChain.getTempTarget("final");
            } catch (IOException var6) {
                postChain = null;
                renderTarget = null;
            } catch (JsonSyntaxException var7) {
                postChain = null;
                renderTarget = null;
            }
        }

    }

    public static void resize(int x, int y) {
        Iterator var2 = postEffects.values().iterator();

        while(var2.hasNext()) {
            PostEffect postEffect = (PostEffect)var2.next();
            postEffect.resize(x, y);
        }

    }

    public static PostChain getPostChainFor(ResourceLocation resourceLocation) {
        PostEffect effect = (PostEffect)postEffects.get(resourceLocation);
        return effect == null ? null : effect.getPostChain();
    }

    public static RenderTarget getRenderTargetFor(ResourceLocation resourceLocation) {
        PostEffect effect = (PostEffect)postEffects.get(resourceLocation);
        return effect == null ? null : effect.getRenderTarget();
    }

    public static void renderEffectForNextTick(ResourceLocation resourceLocation) {
        PostEffect effect = (PostEffect)postEffects.get(resourceLocation);
        if (effect != null) {
            effect.setEnabled(true);
        }

    }

    public static void blitEffects() {
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        Iterator var0 = postEffects.values().iterator();

        while(var0.hasNext()) {
            PostEffect postEffect = (PostEffect)var0.next();
            if (postEffect.getPostChain() != null && postEffect.isEnabled()) {
                postEffect.getRenderTarget().blitToScreen(Minecraft.getInstance().getWindow().getWidth(), Minecraft.getInstance().getWindow().getHeight(), false);
                postEffect.setEnabled(false);
                postEffect.getRenderTarget().clear(Minecraft.ON_OSX);
                Minecraft.getInstance().getMainRenderTarget().bindWrite(false);
            }
        }

        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    }

    public static void copyDepth(RenderTarget mainTarget) {
        Iterator var1 = postEffects.values().iterator();

        while(var1.hasNext()) {
            PostEffect postEffect = (PostEffect)var1.next();
            if (postEffect.getPostChain() != null && postEffect.isEnabled()) {
                postEffect.getRenderTarget().clear(Minecraft.ON_OSX);
                postEffect.getRenderTarget().copyDepthFrom(mainTarget);
            }
        }

    }

    public static void processEffects(RenderTarget mainTarget, float f) {
        Iterator var2 = postEffects.values().iterator();

        while(var2.hasNext()) {
            PostEffect postEffect = (PostEffect)var2.next();
            if (postEffect.isEnabled() && postEffect.postChain != null) {
                postEffect.postChain.process(Minecraft.getInstance().getFrameTime());
                mainTarget.bindWrite(false);
            }
        }

    }

    private static class PostEffect {
        private PostChain postChain;
        private RenderTarget renderTarget;
        private boolean enabled;

        public PostEffect(PostChain postChain, RenderTarget renderTarget, boolean enabled) {
            this.postChain = postChain;
            this.renderTarget = renderTarget;
            this.enabled = enabled;
        }

        public PostChain getPostChain() {
            return this.postChain;
        }

        public RenderTarget getRenderTarget() {
            return this.renderTarget;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public void close() {
            if (this.postChain != null) {
                this.postChain.close();
            }

        }

        public void resize(int x, int y) {
            if (this.postChain != null) {
                this.postChain.resize(x, y);
            }

        }
    }
}