package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.ntgl.common.data.util.VoxelShapeHelper;
import com.nukateam.nukacraft.common.foundation.entities.blocks.GearDoorEntity;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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

import static com.nukateam.nukacraft.common.registery.items.ModArmorItems.PIP_BOY_D;

public class GearDoorBlock extends BaseEntityBlock {
    private static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();

    public GearDoorBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.SOUTH));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new GearDoorEntity(pPos, pState);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockState newstate = ModBlocks.OPENGEAR.get().defaultBlockState();
        if (pPlayer.getOffhandItem().getItem() == PIP_BOY_D.get()) {
            filledEraser(pLevel, pState, pPos.getX(), pPos.getY(), pPos.getZ());
            for (Map.Entry<Property<?>, Comparable<?>> entry : pState.getValues().entrySet()) {
                Property _property = newstate.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                newstate = newstate.setValue(_property, (Comparable) entry.getValue());
            }
            pLevel.setBlock(pPos, newstate, 3);
            return InteractionResult.SUCCESS;
        } else return InteractionResult.FAIL;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        filledFrame(ModBlocks.FILLERBARRIER.get().defaultBlockState(), pLevel, pState, pPos.getX(), pPos.getY(), pPos.getZ());
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        filledFrame(Blocks.AIR.defaultBlockState(), level, state, pos.getX(), pos.getY(), pos.getZ());
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
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

    @Override
    public VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return super.getOcclusionShape(pState, pLevel, pPos);
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
