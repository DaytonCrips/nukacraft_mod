package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.ntgl.common.data.util.VoxelShapeHelper;
import com.nukateam.nukacraft.common.data.utils.PipBoyUtils;
import com.nukateam.nukacraft.common.foundation.entities.blocks.GearDoorEntity;
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

public class GearDoorBlock extends BaseEntityBlock {
    private static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();

    public GearDoorBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.SOUTH));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState pState) {
        return new GearDoorEntity(pos, pState);
    }

//    @Override
//    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pos, Player player, InteractionHand pHand, BlockHitResult pHit) {
//        if (PipBoyUtils.hasPipboy(player)) {
//
//            return InteractionResult.SUCCESS;
//        } else return InteractionResult.FAIL;
//    }


    public void doorCloseInteraction(Player pPlayer, BlockState state, Level pLevel, BlockPos pos) {

        if (PipBoyUtils.hasPipboy()) {
            pLevel.playSound(pPlayer, pos, ModSounds.VAULT_DOOR_INTERACT.get(), SoundSource.BLOCKS, 0.2f, 1);
            var newState = ModBlocks.OPENGEAR.get().defaultBlockState();
            filledEraser(pLevel, state, pos.getX(), pos.getY(), pos.getZ());

            for (var entry : state.getValues().entrySet()) {
                Property property = newState.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                newState = newState.setValue(property, (Comparable) entry.getValue());
            }

            pLevel.setBlock(pos, newState, 3);
        }
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        filledFrame(ModBlocks.FILLERBARRIER.get().defaultBlockState(), pLevel, pState, pos.getX(), pos.getY(), pos.getZ());
        super.setPlacedBy(pLevel, pos, pState, pPlacer, pStack);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        filledFrame(Blocks.AIR.defaultBlockState(), level, state, pos.getX(), pos.getY(), pos.getZ());
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pos, CollisionContext pContext) {
        if (SHAPES.containsKey(pState)) {
            return SHAPES.get(pState);
        }
        List<VoxelShape> shapes = new ArrayList<>();
        switch (pState.getValue(FACING)) {
            case NORTH -> shapes.add(box(-48, 0, 0, 16, 64, 16));
            case EAST -> shapes.add(box(0, 0, -48, 16, 64, 16));
            case WEST -> shapes.add(box(0, 0, 0, 16, 64, 64));
            default -> shapes.add(box(0, 0, 0, 64, 64, 16));
        }
        //shapes.add(box(-48, 0, 0, 16, 64, 16));
        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(pState, shape);
        return shape;
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

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    protected void filledFrame(BlockState block, Level world, BlockState baseState, int x, int y, int z) {
        switch (baseState.getValue(FACING)) {
            case NORTH:
                for (var posBlocks = 1; posBlocks < 4; posBlocks++) {
                    world.setBlock(new BlockPos(x - posBlocks, y, z), block, 3);
                    world.setBlock(new BlockPos(x, y + posBlocks, z), block, 3);
                    for (var cordBlock = 1; cordBlock < 4; cordBlock++) {
                        world.setBlock(new BlockPos(x - posBlocks, y + cordBlock, z), block, 3);
                    }
                }
                break;
            case EAST:
                for (var posBlocks = 1; posBlocks < 4; posBlocks++) {
                    world.setBlock(new BlockPos(x, y, z - posBlocks), block, 3);
                    world.setBlock(new BlockPos(x, y + posBlocks, z), block, 3);
                    for (var cordBlock = 1; cordBlock < 4; cordBlock++) {
                        world.setBlock(new BlockPos(x, y + cordBlock, z - posBlocks), block, 3);
                    }
                }
                break;
            case WEST:
                for (var posBlocks = 1; posBlocks < 4; posBlocks++) {
                    world.setBlock(new BlockPos(x, y, z + posBlocks), block, 3);
                    world.setBlock(new BlockPos(x, y + posBlocks, z), block, 3);
                    for (var cordBlock = 1; cordBlock < 4; cordBlock++) {
                        world.setBlock(new BlockPos(x, y + cordBlock, z + posBlocks), block, 3);
                    }
                }
                break;
            case SOUTH:
                for (var posBlocks = 1; posBlocks < 4; posBlocks++) {
                    world.setBlock(new BlockPos(x + posBlocks, y, z), block, 3);
                    world.setBlock(new BlockPos(x, y + posBlocks, z), block, 3);
                    for (var cordBlock = 1; cordBlock < 4; cordBlock++) {
                        world.setBlock(new BlockPos(x + posBlocks, y + cordBlock, z), block, 3);
                    }
                }
        }
    }

    protected void filledEraser(Level world, BlockState baseState, int x, int y, int z) {
        BlockState air = Blocks.AIR.defaultBlockState();
        BlockState stairs = ModBlocks.HALFBARRIER.get().defaultBlockState();
        switch (baseState.getValue(FACING)) {
            case NORTH:
                world.setBlock(new BlockPos(x - 1, y + 1, z), air, 3);
                world.setBlock(new BlockPos(x - 2, y + 1, z), air, 3);
                world.setBlock(new BlockPos(x - 1, y + 2, z), air, 3);
                world.setBlock(new BlockPos(x - 2, y + 2, z), air, 3);
                world.setBlock(new BlockPos(x - 1, y, z), stairs, 3);
                world.setBlock(new BlockPos(x - 2, y, z), stairs, 3);
                break;
            case SOUTH:
                world.setBlock(new BlockPos(x + 1, y + 1, z), air, 3);
                world.setBlock(new BlockPos(x + 2, y + 1, z), air, 3);
                world.setBlock(new BlockPos(x + 1, y + 2, z), air, 3);
                world.setBlock(new BlockPos(x + 2, y + 2, z), air, 3);
                world.setBlock(new BlockPos(x + 1, y, z), stairs, 3);
                world.setBlock(new BlockPos(x + 2, y, z), stairs, 3);
                break;
            case WEST:
                world.setBlock(new BlockPos(x, y + 1, z + 1), air, 3);
                world.setBlock(new BlockPos(x, y + 1, z + 2), air, 3);
                world.setBlock(new BlockPos(x, y + 2, z + 1), air, 3);
                world.setBlock(new BlockPos(x, y + 2, z + 2), air, 3);
                world.setBlock(new BlockPos(x, y, z + 1), stairs, 3);
                world.setBlock(new BlockPos(x, y, z + 2), stairs, 3);
                break;
            case EAST:
                world.setBlock(new BlockPos(x, y + 1, z - 1), air, 3);
                world.setBlock(new BlockPos(x, y + 1, z - 2), air, 3);
                world.setBlock(new BlockPos(x, y + 2, z - 1), air, 3);
                world.setBlock(new BlockPos(x, y + 2, z - 2), air, 3);
                world.setBlock(new BlockPos(x, y, z - 1), stairs, 3);
                world.setBlock(new BlockPos(x, y, z - 2), stairs, 3);
                break;
        }
    }
}
