package com.nukateam.nukacraft.common.foundation.entities;

import com.nukateam.nukacraft.common.foundation.blocks.custom.blocks.PassengersBlock;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

//public class PassengersEntity extends Entity {
//    public PassengersEntity(Level level) {
//        //super(EntityTypes.PASSENGERS_ENTITY.get(), level);
//        this.noPhysics = true;
//    }
//
//    public PassengersEntity(Level level, BlockPos source, double yOffset) {
//        this(level);
//        this.setPos(source.getX() + 0.5, source.getY() + yOffset, source.getZ() + 0.5);
//    }
//
//
//
//
//    @Override
//    public void tick() {
//        super.tick();
//        if(!this.level.isClientSide) {
//            BlockState state = this.level.getBlockState(this.blockPosition());
//            boolean remove = true;
//            if(state.getBlock() instanceof PassengersBlock seatBlock) remove = !seatBlock.isSeat(state);
//            if(this.getPassengers().isEmpty() || remove) {
//                this.remove(RemovalReason.DISCARDED);
//                this.level.updateNeighbourForOutputSignal(blockPosition(), this.level.getBlockState(blockPosition()).getBlock());
//            }
//        }
//    }
//
//    @Override
//    protected void defineSynchedData() {}
//
//    @Override
//    protected void readAdditionalSaveData(CompoundTag compound) {}
//
//    @Override
//    protected void addAdditionalSaveData(CompoundTag compound) {}
//
//    @Override
//    public double getPassengersRidingOffset()
//    {
//        return 0.0;
//    }
//
//    @Override
//    protected boolean canRide(Entity entity)
//    {
//        return true;
//    }
//
//    @Override
//    public Packet<?> getAddEntityPacket() {
//        return new ClientboundAddEntityPacket(this);
//    }
//
//    @Override
//    public Vec3 getDismountLocationForPassenger(LivingEntity entity) {
//        BlockPos pos = this.blockPosition();
//        Vec3 safeVec;
//        BlockState state = this.level.getBlockState(pos);
//        if (state.getBlock() instanceof PassengersBlock seatBlock) {
//            //pos = pos.offset(seatBlock.dismountLocationOffset());
//            safeVec = DismountHelper.findSafeDismountLocation(entity.getType(), this.level, seatBlock.PassengersDismountLocation(this.level, state, pos), false);
//            if (safeVec != null) {
//                return safeVec.add(0, 0.25, 0);
//            }
//        }
//
//        Direction original = this.getDirection();
//        Direction[] offsets = {original, original.getClockWise(), original.getCounterClockWise(), original.getOpposite()};
//        for(Direction dir : offsets) {
//            safeVec = DismountHelper.findSafeDismountLocation(entity.getType(), this.level, pos.relative(dir), false);
//            if (safeVec != null) {
//                return safeVec.add(0, 0.25, 0);
//            }
//        }
//        return super.getDismountLocationForPassenger(entity);
//    }
//
//    @Override
//    protected void addPassenger(Entity passenger) {
//        BlockPos pos = this.blockPosition();
//        BlockState state = this.level.getBlockState(pos);
//        if (state.getBlock() instanceof PassengersBlock seatBlock) {
//            passenger.setYRot(seatBlock.setPassengersRotation(state, passenger));
//        }
//        super.addPassenger(passenger);
//    }
//}
