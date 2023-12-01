package com.nukateam.nukacraft.client.events;

import com.jetug.chassis_core.common.input.CommonInputHandler;
import com.jetug.chassis_core.common.input.InputKey;
import com.jetug.chassis_core.common.input.KeyAction;
import com.jetug.chassis_core.common.network.actions.InputAction;
import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoyScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import static com.jetug.chassis_core.client.ClientConfig.OPTIONS;
import static com.jetug.chassis_core.common.network.PacketSender.doServerAction;
import static com.jetug.chassis_core.common.util.helpers.PlayerUtils.getLocalPlayer;
import static com.nukateam.nukacraft.client.KeyBindings.KEY_MAP;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class InputEvents {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent()
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if(event.getAction() == GLFW.GLFW_PRESS) {
            if (KEY_MAP.isDown()) {
                PipBoyScreen.openMap();
            }
        }
    }
}
