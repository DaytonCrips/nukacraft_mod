package com.dayton.guns.common.debug;

import com.dayton.guns.client.ClientHandler;
import com.dayton.guns.common.base.Gun;
import com.dayton.guns.common.debug.screen.widget.DebugButton;
import com.dayton.guns.common.debug.screen.widget.DebugToggle;
import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.guns.common.foundation.item.ScopeItem;
import com.dayton.guns.common.foundation.item.attachment.impl.Scope;
import com.dayton.nukacraft.NukaCraftMod;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID)
public class Debug {
    private static final Map<Item, Gun> GUNS = new HashMap<>();
    private static final Map<Item, Scope> SCOPES = new HashMap<>();
    private static boolean forceAim = false;

    @SubscribeEvent
    public static void onServerStarting(ServerStartedEvent event) {
        // Resets the cache every time when joining a world
        event.getServer().execute(() ->
        {
            GUNS.clear();
            SCOPES.clear();
        });
    }

    public static Gun getGun(GunItem item) {
        return GUNS.computeIfAbsent(item, item1 -> item.getGun().copy());
    }

    public static Scope getScope(ScopeItem item) {
        return SCOPES.computeIfAbsent(item, item1 -> item.getProperties().copy());
    }

    public static boolean isForceAim() {
        return forceAim;
    }

    public static void setForceAim(boolean forceAim) {
        Debug.forceAim = forceAim;
    }

    public static class Menu implements IEditorMenu {
        @Override
        public Component getEditorLabel() {
            return new TextComponent("Editor Menu");
        }

        @Override
        public void getEditorWidgets(List<Pair<Component, Supplier<IDebugWidget>>> widgets) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                ItemStack heldItem = Objects.requireNonNull(Minecraft.getInstance().player).getMainHandItem();
                if (heldItem.getItem() instanceof GunItem gunItem) {
                    widgets.add(Pair.of(new TranslatableComponent(gunItem.getDescriptionId()), () -> new DebugButton(new TextComponent("Edit"), btn -> {
                        Minecraft.getInstance().setScreen(ClientHandler.createEditorScreen(getGun(gunItem)));
                    })));
                }
                widgets.add(Pair.of(new TextComponent("Settings"), () -> new DebugButton(new TextComponent(">"), btn -> {
                    Minecraft.getInstance().setScreen(ClientHandler.createEditorScreen(new Settings()));
                })));
            });
        }
    }

    public static class Settings implements IEditorMenu {
        @Override
        public Component getEditorLabel() {
            return new TextComponent("Settings");
        }

        @Override
        public void getEditorWidgets(List<Pair<Component, Supplier<IDebugWidget>>> widgets) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                widgets.add(Pair.of(new TextComponent("Force Aim"), () -> new DebugToggle(Debug.forceAim, value -> Debug.forceAim = value)));
            });
        }
    }
}
