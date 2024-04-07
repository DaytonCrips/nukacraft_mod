package com.nukateam.nukacraft.common.foundation.world;

import com.mojang.blaze3d.systems.RenderSystem;
import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.CLIENT)
public class FogHandler {


    @SubscribeEvent
    public static void onRenderFog(ViewportEvent.RenderFog event) {
        var world = event.getCamera().getEntity().level;
        var pos = event.getCamera().getBlockPosition();

        if (world.getBiome(pos).is(ResourceLocation.tryParse(NukaCraftMod.MOD_ID + ":glow_sea"))) {
            RenderSystem.setShaderTexture(0, 0);
            RenderSystem.setShaderFogStart(9f);
            RenderSystem.setShaderFogEnd(65f);
        }

        if (world.getBiome(pos).is(ResourceLocation.tryParse(NukaCraftMod.MOD_ID + ":ash_heap"))) {
            RenderSystem.setShaderTexture(0, 0);
            RenderSystem.setShaderFogStart(12f);
            RenderSystem.setShaderFogEnd(87f);
        }
    }
}
