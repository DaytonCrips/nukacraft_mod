package com.dayton.guns.client;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import org.lwjgl.glfw.GLFW;

/**
 * Author: MrCrayfish
 */
public class KeyBinds
{
    public static final KeyMapping KEY_RELOAD = new KeyMapping("key.nukacraft.reload", GLFW.GLFW_KEY_R, "key.categories.nukacraft");
    public static final KeyMapping KEY_UNLOAD = new KeyMapping("key.nukacraft.unload", GLFW.GLFW_KEY_U, "key.categories.nukacraft");
    public static final KeyMapping KEY_ATTACHMENTS = new KeyMapping("key.nukacraft.attachments", GLFW.GLFW_KEY_Z, "key.categories.nukacraft");

    public static void register()
    {
        ClientRegistry.registerKeyBinding(KEY_RELOAD);
        ClientRegistry.registerKeyBinding(KEY_UNLOAD);
        ClientRegistry.registerKeyBinding(KEY_ATTACHMENTS);
    }
}
