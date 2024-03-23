package com.nukateam.nukacraft.common.foundation.world;

import com.mojang.blaze3d.systems.RenderSystem;
import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.ticks.TickPriority;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.CLIENT)
public class FogHandler {


    @SubscribeEvent
    public static void onRenderFog(EntityViewRenderEvent.RenderFogEvent event) {
        Level world = event.getCamera().getEntity().level;
        BlockPos pos = event.getCamera().getBlockPosition();
        if (world.getBiome(pos).is(ResourceLocation.tryParse("nukacraft:glow_sea"))) {
            RenderSystem.setShaderTexture(0,0);
            RenderSystem.setShaderFogStart(9f);
            RenderSystem.setShaderFogEnd(65f);
        }
        if (world.getBiome(pos).is(ResourceLocation.tryParse("nukacraft:ash_heap"))) {
            RenderSystem.setShaderTexture(0,0);
            RenderSystem.setShaderFogStart(12f);
            RenderSystem.setShaderFogEnd(87f);
        }
    }
}
