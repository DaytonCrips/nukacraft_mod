package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.ntgl.common.data.util.VoxelShapeHelper;
import com.nukateam.ntgl.common.foundation.block.WorkbenchBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArmoryWorkbench extends WorkbenchBlock {
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap();
    public ArmoryWorkbench(Properties properties) {
        super(properties);
    }

    private VoxelShape getShape(BlockState state) {
        List<VoxelShape> shapes = new ArrayList<>();
        switch (state.getValue(FACING)) {
            case NORTH:
                shapes.add(box(-14.5, 0, 0, 15.7, 13, 16));
                break;
            case EAST:
                shapes.add(box(0, 0, -14.5, 16, 13, 15.7));
                break;
            case WEST:
                shapes.add(box(0, 0, 0, 16, 13, 30.7));
                break;
            default:
                shapes.add(box(0, 0, 0, 30.7, 13, 16));
        }
        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(state, shape);
        return shape;
    }

    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return this.getShape(state);
    }
}
