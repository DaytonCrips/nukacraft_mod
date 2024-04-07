package com.nukateam.nukacraft.common.foundation.entities.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import static com.nukateam.nukacraft.common.registery.ModTileEntities.OWNABLE_BLOCK_ENTITY;

public class OwnableBlockEntity extends BlockEntity {
    private static final String OWNER = "owner";
    private String owner = "";

    public OwnableBlockEntity(BlockPos pos, BlockState state) {
        this(OWNABLE_BLOCK_ENTITY.get(), pos, state);
    }

    public OwnableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (owner != null)
            tag.putString(OWNER, owner);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        owner = tag.getString(OWNER);
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        load(tag);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet) {
        handleUpdateTag(packet.getTag());
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String uuid) {
        owner = uuid;
        setChanged();
    }
}
