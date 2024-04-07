package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.nukacraft.common.data.utils.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VentTubeBlock extends CustomModelBlock {
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();

    public VentTubeBlock(Properties properties) {
        super(properties);
    }

    private VoxelShape getShape(BlockState state) {
        if (SHAPES.containsKey(state)) {
            return SHAPES.get(state);
        }
        List<VoxelShape> shapes = new ArrayList<>();
        switch (state.getValue(FACING)) {
            case NORTH -> shapes.add(box(3, 3, 0.1, 13, 13, 16));
            case EAST -> shapes.add(box(0.05000000000000071, 3, 3.0500000000000007, 15.950000000000001, 13, 13.05));
            case WEST -> shapes.add(box(0.05000000000000071, 3, 3.0500000000000007, 15.950000000000001, 13, 13.05));
            default -> shapes.add(box(3, 3, 0.1, 13, 13, 16));
        }
        Direction direction = state.getValue(FACING);
        shapes.add(box(0.1, 0, 0.1, 15.9, 15.9, 15.9));
        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(state, shape);
        return shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return this.getShape(state);
    }
}
