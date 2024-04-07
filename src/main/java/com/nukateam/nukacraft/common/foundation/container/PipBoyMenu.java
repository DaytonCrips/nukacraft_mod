package com.nukateam.nukacraft.common.foundation.container;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.nukateam.nukacraft.common.registery.ContainerRegistry.PIPBOY;

public class PipBoyMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
    public final Level world;
    public final Player entity;
    private final Map<Integer, Slot> customSlots = new HashMap<>();

    public PipBoyMenu(int i, Inventory playerInventory) {
        this(i, playerInventory, null);
    }

    public PipBoyMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        super(PIPBOY.get(), id);
        this.entity = inv.player;
        this.world = inv.player.level;
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    public Map<Integer, Slot> get() {
        return customSlots;
    }
}
