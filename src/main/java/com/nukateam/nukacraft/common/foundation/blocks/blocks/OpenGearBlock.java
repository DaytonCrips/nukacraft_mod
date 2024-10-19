package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.ntgl.common.data.util.VoxelShapeHelper;
import com.nukateam.nukacraft.common.data.utils.PipBoyUtils;
import com.nukateam.nukacraft.common.foundation.entities.blocks.OpenGearEntity;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenGearBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();

    public OpenGearBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.SOUTH));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState pState) {
        return new OpenGearEntity(pos, pState);
    }

    protected void fillFrame(BlockState block, Level world, BlockState baseState, int base_x, int base_y, int base_z) {
        switch (baseState.getValue(FACING)) {
            case NORTH:
                for (var posBlocks = 1; posBlocks < 4; posBlocks++) {
                    world.setBlock(new BlockPos(base_x - posBlocks, base_y, base_z), block, 3);
                    world.setBlock(new BlockPos(base_x, base_y + posBlocks, base_z), block, 3);
                    for (var cordBlock = 1; cordBlock < 4; cordBlock++) {
                        world.setBlock(new BlockPos(base_x - posBlocks, base_y + cordBlock, base_z), block, 3);
                    }
                }
                break;
            case EAST:
                for (var posBlocks = 1; posBlocks < 4; posBlocks++) {
                    world.setBlock(new BlockPos(base_x, base_y, base_z - posBlocks), block, 3);
                    world.setBlock(new BlockPos(base_x, base_y + posBlocks, base_z), block, 3);
                    for (var cordBlock = 1; cordBlock < 4; cordBlock++) {
                        world.setBlock(new BlockPos(base_x, base_y + cordBlock, base_z - posBlocks), block, 3);
                    }
                }
                break;
            case WEST:
                for (var posBlocks = 1; posBlocks < 4; posBlocks++) {
                    world.setBlock(new BlockPos(base_x, base_y, base_z + posBlocks), block, 3);
                    world.setBlock(new BlockPos(base_x, base_y + posBlocks, base_z), block, 3);
                    for (var cordBlock = 1; cordBlock < 4; cordBlock++) {
                        world.setBlock(new BlockPos(base_x, base_y + cordBlock, base_z + posBlocks), block, 3);
                    }
                }
                break;
            case SOUTH:
                for (var posBlocks = 1; posBlocks < 4; posBlocks++) {
                    world.setBlock(new BlockPos(base_x + posBlocks, base_y, base_z), block, 3);
                    world.setBlock(new BlockPos(base_x, base_y + posBlocks, base_z), block, 3);
                    for (var cordBlock = 1; cordBlock < 4; cordBlock++) {
                        world.setBlock(new BlockPos(base_x + posBlocks, base_y + cordBlock, base_z), block, 3);
                    }
                }
        }

    }

    protected void filledEraser(Level world, BlockState baseState, int base_x, int base_y, int base_z) {
        BlockState air = Blocks.AIR.defaultBlockState();
        BlockState stairs = ModBlocks.HALFBARRIER.get().defaultBlockState();
        switch (baseState.getValue(FACING)) {
            case NORTH:
                world.setBlock(new BlockPos(base_x - 1, base_y + 1, base_z), air, 3);
                world.setBlock(new BlockPos(base_x - 2, base_y + 1, base_z), air, 3);
                world.setBlock(new BlockPos(base_x - 1, base_y + 2, base_z), air, 3);
                world.setBlock(new BlockPos(base_x - 2, base_y + 2, base_z), air, 3);
                world.setBlock(new BlockPos(base_x - 1, base_y, base_z), stairs, 3);
                world.setBlock(new BlockPos(base_x - 2, base_y, base_z), stairs, 3);
                break;
            case SOUTH:
                world.setBlock(new BlockPos(base_x + 1, base_y + 1, base_z), air, 3);
                world.setBlock(new BlockPos(base_x + 2, base_y + 1, base_z), air, 3);
                world.setBlock(new BlockPos(base_x + 1, base_y + 2, base_z), air, 3);
                world.setBlock(new BlockPos(base_x + 2, base_y + 2, base_z), air, 3);
                world.setBlock(new BlockPos(base_x + 1, base_y, base_z), stairs, 3);
                world.setBlock(new BlockPos(base_x + 2, base_y, base_z), stairs, 3);
                break;
            case WEST:
                world.setBlock(new BlockPos(base_x, base_y + 1, base_z + 1), air, 3);
                world.setBlock(new BlockPos(base_x, base_y + 1, base_z + 2), air, 3);
                world.setBlock(new BlockPos(base_x, base_y + 2, base_z + 1), air, 3);
                world.setBlock(new BlockPos(base_x, base_y + 2, base_z + 2), air, 3);
                world.setBlock(new BlockPos(base_x, base_y, base_z + 1), stairs, 3);
                world.setBlock(new BlockPos(base_x, base_y, base_z + 2), stairs, 3);
                break;
            case EAST:
                world.setBlock(new BlockPos(base_x, base_y + 1, base_z - 1), air, 3);
                world.setBlock(new BlockPos(base_x, base_y + 1, base_z - 2), air, 3);
                world.setBlock(new BlockPos(base_x, base_y + 2, base_z - 1), air, 3);
                world.setBlock(new BlockPos(base_x, base_y + 2, base_z - 2), air, 3);
                world.setBlock(new BlockPos(base_x, base_y, base_z - 1), stairs, 3);
                world.setBlock(new BlockPos(base_x, base_y, base_z - 2), stairs, 3);
                break;
        }
    }



    public void doorOpenInteraction(Player pPlayer, BlockState pState, Level pLevel, BlockPos pos) {
        pLevel.playSound(pPlayer, pos, ModSounds.VAULT_DOOR_INTERACT.get(), SoundSource.BLOCKS, 0.2f, 1);
        fillFrame(ModBlocks.FILLERBARRIER.get().defaultBlockState(), pLevel, pState, pos.getX(), pos.getY(), pos.getZ());
        if (PipBoyUtils.hasPipboy()) {
            var newState = ModBlocks.GEAR_DOOR.get().defaultBlockState();
            for (var entry : pState.getValues().entrySet()) {
                Property property = newState
                        .getBlock()
                        .getStateDefinition()
                        .getProperty(entry.getKey().getName());

                newState = newState.setValue(property, (Comparable) entry.getValue());
            }
            pLevel.setBlock(pos, newState, 3);
        }
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        filledEraser(pLevel, pState, pos.getX(), pos.getY(), pos.getZ());
        super.setPlacedBy(pLevel, pos, pState, pPlacer, pStack);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        fillFrame(Blocks.AIR.defaultBlockState(), level, state, pos.getX(), pos.getY(), pos.getZ());
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pos, CollisionContext pContext) {
        if (SHAPES.containsKey(pState)) {
            return SHAPES.get(pState);
        }
        List<VoxelShape> shapes = new ArrayList<>();
        switch (pState.getValue(FACING)) {
            case NORTH:
                shapes.add(box(-48, 0, 0, 16, 64, 16));
                break;
            case EAST:
                shapes.add(box(0, 0, -48, 16, 64, 16));
                break;
            case WEST:
                shapes.add(box(0, 0, 0, 16, 64, 64));
                break;
            default:
                shapes.add(box(0, 0, 0, 64, 64, 16));
        }
        //shapes.add(box(-48, 0, 0, 16, 64, 16));
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
    public VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pos) {
        return super.getOcclusionShape(pState, pLevel, pos);
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }
}
