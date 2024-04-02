package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.ntgl.common.data.util.VoxelShapeHelper;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VaultSupportBlock extends Block {
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private String type;
    public VaultSupportBlock(Properties pProperties, String type) {
        super(pProperties);
        this.type = type;
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.SOUTH));
    }
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (SHAPES.containsKey(pState)) {
            return SHAPES.get(pState);
        }
        List<VoxelShape> shapes = new ArrayList<>();
        if (this.type.equals("wall")) {
            switch (pState.getValue(FACING)) {
                case NORTH ->
                        shapes.add(box(5.399999999999999, 0, 0, 10.599999999999987, 16, 4));
                case EAST ->
                        shapes.add(box(12, 0, 5.399999999999999, 16, 16, 10.599999999999987));
                case WEST ->
                        shapes.add(box(0, 0, 5.399999999999999, 4, 16, 10.599999999999987));
                default ->
                        shapes.add(box(5.399999999999999, 0, 12, 10.599999999999987, 16, 16));
            }
        } else if (this.type.equals("walltop")) {
            switch (pState.getValue(FACING)) {
                case NORTH ->
                        shapes.add(box(5.4, 10.000000000000004, 0, 10.599999999999994, 15.999999999999993, 16));
                case EAST ->
                        shapes.add(box(-2.6645352591003757e-15, 10.000000000000004, 5.400000000000002, 15.999999999999996, 15.999999999999993, 10.599999999999998));
                case WEST ->
                        shapes.add(box(-2.6645352591003757e-15, 10.000000000000004, 5.400000000000002, 15.999999999999996, 15.999999999999993, 10.599999999999998));
                default ->
                        shapes.add(box(5.4, 10.000000000000004, 0, 10.599999999999994, 15.999999999999993, 16));
            }
        } else if (this.type.equals("top")) {
            switch (pState.getValue(FACING)) {
                case NORTH:
                    shapes.add(box(5.4, 0.05, 0.1, 10.6, 15.95, 4.700000000000001));
                    shapes.add(box(5.4, 9.750000000000004, 4.699999999999999, 10.6, 15.949999999999998, 15.89999999999999));
                    break;
                case WEST:
                    shapes.add(box(0.15000000000000158,
                            0.05,
                            5.450000000000003,
                            4.750000000000009,
                            15.95,
                            10.650000000000002));
                    shapes.add(box(4.750000000000005,
                            9.750000000000004,
                            5.450000000000003,
                            15.949999999999976,
                            15.949999999999998,
                            10.650000000000002));
                    break;
                case EAST:
                    shapes.add(box(11.249999999999991,
                            0.05, 5.450000000000003,
                            15.849999999999998,
                            15.95,
                            10.650000000000002));
                    shapes.add(box(0.0500000000000238,
                            9.750000000000004,
                            5.450000000000003,
                            11.249999999999995,
                            15.949999999999998,
                            10.650000000000002));
                    break;
                default:
                    shapes.add(box(5.400000000000001,
                            0.05,
                            11.299999999999992,
                            10.6,
                            15.95,
                            15.899999999999995));
                    shapes.add(box(5.400000000000001,
                            9.750000000000004,
                            0.10000000000000364,
                            10.6,
                            15.949999999999998,
                            11.299999999999995));
            }
        }

        //shapes.add(box(-48.0, 0.0, 0.0, 16.0, 64.0, 16.0));
        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(pState, shape);
        return shape;
    }
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }
    @Override
    public VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return super.getOcclusionShape(pState, pLevel, pPos);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }
}
