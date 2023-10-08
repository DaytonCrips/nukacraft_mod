package com.dayton.nukacraft.client.render.gui.pipboy;


import com.dayton.nukacraft.client.render.gui.ModMenuClass;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PipBoyMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>>{
    public final static HashMap<String, Object> guiState = new HashMap<>();
    public final Level world;
    public final Player entity;
    public int x, y, z;
    private IItemHandler internal;
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    private boolean bound = false;

    public PipBoyMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        super(ModMenuClass.PIPBOY, id);
        this.entity = inv.player;
        this.world = inv.player.level;
        this.internal = new ItemStackHandler(0);
        if (extraData != null) {
            var pos = extraData.readBlockPos();
            this.x = pos.getX();
            this.y = pos.getY();
            this.z = pos.getZ();
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    public Map<Integer, Slot> get() {
        return customSlots;
    }
}
