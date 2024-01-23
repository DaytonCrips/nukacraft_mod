package com.nukateam.nukacraft.client.events;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.client.render.renderers.MiniNukeRenderer;
import com.nukateam.nukacraft.common.data.utils.SlotUtils;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityTypes.MININUKE.get(), MiniNukeRenderer::new);
    }
}

