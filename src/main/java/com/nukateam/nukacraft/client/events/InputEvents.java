package com.nukateam.nukacraft.client.events;

import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoyScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import static com.nukateam.nukacraft.client.KeyBindings.*;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class InputEvents {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent()
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (event.getAction() == GLFW.GLFW_PRESS) {
            if (KEY_MAP.isDown()) {
                PipBoyScreen.openMap();
            }
            if (KEY_RADIO.isDown()) {
                PipBoyScreen.openRadio();
            }
            if (KEY_ARCHIVE.isDown()) {
                PipBoyScreen.openArchive();
            }
        }
    }
}
