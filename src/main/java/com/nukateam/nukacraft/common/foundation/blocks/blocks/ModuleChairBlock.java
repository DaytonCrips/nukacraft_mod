package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.nukacraft.common.data.utils.VoxelShapeHelper;
import com.nukateam.nukacraft.common.foundation.entities.blocks.ChairBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
public class ModuleChairBlock extends StairBlock{
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();


    public ModuleChairBlock(BlockState pBaseState, Properties pProperties) {
        super(pBaseState, pProperties);
    }


    private VoxelShape getShape(BlockState state)
    {
        if(SHAPES.containsKey(state))
        {
            return SHAPES.get(state);
        }
        Direction direction = state.getValue(FACING);
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(box(0.1, 0, 0.1, 15.9, 6.9, 15.9));
        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(state, shape);
        return shape;
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        return this.getShape(state);
    }
    public boolean isChair(BlockState state) {
        return true;
    }
    public float seatY() {
        return 0.25F;
    }

    public BlockPos Dismount(Level level, BlockState state, BlockPos pos) {
        return pos;
    }

    public float setPassangerRotation(BlockState state, Entity entity) {
        return entity.getYRot();
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if(!isChair(state) || player.isPassenger() || player.isCrouching())
            return InteractionResult.PASS;


        List<ChairBlockEntity> seats = level.getEntitiesOfClass(ChairBlockEntity.class, new AABB(pos, pos.offset(1, 1, 1)));
        if(seats.isEmpty()) {
            ChairBlockEntity seat = new ChairBlockEntity(level, pos, this.seatY());
            level.addFreshEntity(seat);
            player.startRiding(seat);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

//    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
//        if (!pState.is(pState.getBlock())) {
//            pLevel.neighborChanged(this.baseState, pPos, Blocks.AIR, pPos, false);
//            this.base.onPlace(this.baseState, pLevel, pPos, pOldState, false);
//        }
//    }

}
