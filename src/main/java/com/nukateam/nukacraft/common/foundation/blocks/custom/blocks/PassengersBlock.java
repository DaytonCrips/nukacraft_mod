package com.nukateam.nukacraft.common.foundation.blocks.custom.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class PassengersBlock extends CustomModelBlock{
    public PassengersBlock(Properties pProperties) {
        super(pProperties);
    }
    public float seatY() {
        return 0.25F;
    }
    public boolean isSeat(BlockState state) {
        return true;
    }

    public Vec3i dismountLocationOffset() {
        return new Vec3i(0, seatY(), 0);
    }
    public BlockPos PassengersDismountLocation(Level level, BlockState state, BlockPos pos) {
        return pos;
    }
    public float setPassengersRotation(BlockState state, Entity entity) {
        return entity.getYRot();
    }
//    @Override
//    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
//        if(!isSeat(state) || player.isPassenger() || player.isCrouching())
//            return InteractionResult.PASS;
//
////        if(!level.getBlockState(pos.above()).getCollisionShape(level, pos).isEmpty() && !level.getBlockState(pos.above()).is(AFBlockTags.NO_SEAT_COLLISION_CHECK))
////            return InteractionResult.PASS;
//
//
//        List<PassengersEntity> seats = level.getEntitiesOfClass(PassengersEntity.class, new AABB(pos, pos.offset(1, 1, 1)));
//        if(seats.isEmpty()) {
//            PassengersEntity seat = new PassengersEntity(level, pos, this.seatY());
//            level.addFreshEntity(seat);
//            player.startRiding(seat);
//            return InteractionResult.CONSUME;
//        }
//        return InteractionResult.PASS;
//    }
}
