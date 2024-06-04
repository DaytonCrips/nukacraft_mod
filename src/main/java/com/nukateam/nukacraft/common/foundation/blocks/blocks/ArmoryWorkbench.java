package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.ntgl.common.data.util.VoxelShapeHelper;
import com.nukateam.ntgl.common.foundation.block.WorkbenchBlock;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

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
//    @Override
//    public void setPlacedBy(Level pLevel, BlockPos pos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
//        filledEraser(pLevel, pState, pos.getX(), pos.getY(), pos.getZ());
//        super.setPlacedBy(pLevel, pos, pState, pPlacer, pStack);
//    }
//
//
//    @Override
//    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
//        destroyer(level, state, pos.getX(), pos.getY(), pos.getZ());
//        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
//    }
//
//    protected void destroyer(Level world, BlockState baseState, int base_x, int base_y, int base_z) {
//        BlockState barrier = Blocks.AIR.defaultBlockState();
//        switch (baseState.getValue(FACING)) {
//            case NORTH:
//                world.setBlock(new BlockPos(base_x - 1, base_y, base_z), barrier, 3);
//                break;
//            case SOUTH:
//                world.setBlock(new BlockPos(base_x + 1, base_y, base_z), barrier, 3);
//                break;
//            case WEST:
//                world.setBlock(new BlockPos(base_x, base_y, base_z + 1), barrier, 3);
//
//                break;
//            case EAST:
//
//                world.setBlock(new BlockPos(base_x, base_y, base_z - 1), barrier, 3);
//
//                break;
//        }
//    }
//
//    protected void filledEraser(Level world, BlockState baseState, int base_x, int base_y, int base_z) {
//        BlockState barrier = Blocks.STONE.defaultBlockState();
//        switch (baseState.getValue(FACING)) {
//            case NORTH:
//                world.setBlock(new BlockPos(base_x - 1, base_y, base_z), barrier, 3);
//                break;
//            case SOUTH:
//                world.setBlock(new BlockPos(base_x + 1, base_y, base_z), barrier, 3);
//                break;
//            case WEST:
//                world.setBlock(new BlockPos(base_x, base_y, base_z + 1), barrier, 3);
//
//                break;
//            case EAST:
//
//                world.setBlock(new BlockPos(base_x, base_y, base_z - 1), barrier, 3);
//
//                break;
//        }
//    }
}
