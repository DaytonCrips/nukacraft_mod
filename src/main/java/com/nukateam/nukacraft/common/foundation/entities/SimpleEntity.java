package com.nukateam.nukacraft.common.foundation.entities;

import net.minecraft.nbt.*;
import net.minecraft.network.protocol.*;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;

import static net.minecraftforge.network.NetworkHooks.*;

public class SimpleEntity extends Entity {
    public SimpleEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override protected void defineSynchedData() {}
    @Override protected void readAdditionalSaveData(CompoundTag pCompound) {}
    @Override protected void addAdditionalSaveData(CompoundTag pCompound) {}

    @Override public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return (Packet<ClientGamePacketListener>) getEntitySpawningPacket(this);
    }
}
