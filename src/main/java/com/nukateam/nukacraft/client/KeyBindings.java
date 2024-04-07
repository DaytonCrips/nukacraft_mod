package com.nukateam.nukacraft.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import org.lwjgl.glfw.GLFW;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class KeyBindings {
    public static final KeyMapping KEY_MAP = new KeyMapping("key.open_map", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_M, "key.categories.nukacraft");
    public static final KeyMapping KEY_RADIO = new KeyMapping("key.open_radio", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_B, "key.categories.nukacraft");
    public static final KeyMapping KEY_ARCHIVE = new KeyMapping("key.open_archive", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_N, "key.categories.nukacraft");

    public static List<KeyMapping> getKeys() {
        List<KeyMapping> keys = new ArrayList<>();

        for (Field field : KeyBindings.class.getFields())
            try {
                if (field.get(null) instanceof KeyMapping)
                    keys.add((KeyMapping) field.get(null));
            } catch (IllegalAccessException ignored) {
            }

        return keys;
    }

    public static void register() {
        for (KeyMapping key : getKeys())
            ClientRegistry.registerKeyBinding(key);
    }
}
