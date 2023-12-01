package com.nukateam.nukacraft.client.events;

import com.jetug.chassis_core.common.input.KeyAction;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoyScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import static com.nukateam.nukacraft.client.KeyBindings.KEY_MAP;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEventBus {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
//        GeoArmorRenderer.registerArmorRenderer(WoodenArmorItem.class, WoodenArmorRenderer::new);
    }
}
