package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.ntgl.common.data.util.VoxelShapeHelper;
import com.nukateam.nukacraft.common.foundation.entities.blocks.OpenGearEntity;
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

public class OpenGearBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();

    public OpenGearBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.SOUTH));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new OpenGearEntity(pPos, pState);
    }

    protected void filledFrame(BlockState block, Level world, BlockState baseState, int base_x, int base_y, int base_z) {


        switch (baseState.getValue(FACING)) {
            case NORTH:
                for (double posBlocks = 1.0; posBlocks < 4.0; posBlocks++) {
                    world.setBlock(new BlockPos(base_x - posBlocks, base_y, base_z), block, 3);
                    world.setBlock(new BlockPos(base_x, base_y + posBlocks, base_z), block, 3);
                    for (double cordBlock = 1.0; cordBlock < 4.0; cordBlock++) {
                        world.setBlock(new BlockPos(base_x - posBlocks, base_y + cordBlock, base_z), block, 3);
                    }
                }
                break;
            case EAST:
                for (double posBlocks = 1.0; posBlocks < 4.0; posBlocks++) {
                    world.setBlock(new BlockPos(base_x, base_y, base_z - posBlocks), block, 3);
                    world.setBlock(new BlockPos(base_x, base_y + posBlocks, base_z), block, 3);
                    for (double cordBlock = 1.0; cordBlock < 4.0; cordBlock++) {
                        world.setBlock(new BlockPos(base_x, base_y + cordBlock, base_z - posBlocks), block, 3);
                    }
                }
                break;
            case WEST:
                for (double posBlocks = 1.0; posBlocks < 4.0; posBlocks++) {
                    world.setBlock(new BlockPos(base_x, base_y, base_z + posBlocks), block, 3);
                    world.setBlock(new BlockPos(base_x, base_y + posBlocks, base_z), block, 3);
                    for (double cordBlock = 1.0; cordBlock < 4.0; cordBlock++) {
                        world.setBlock(new BlockPos(base_x, base_y + cordBlock, base_z + posBlocks), block, 3);
                    }
                }
                break;
            case SOUTH:
                for (double posBlocks = 1.0; posBlocks < 4.0; posBlocks++) {
                    world.setBlock(new BlockPos(base_x + posBlocks, base_y, base_z), block, 3);
                    world.setBlock(new BlockPos(base_x, base_y + posBlocks, base_z), block, 3);
                    for (double cordBlock = 1.0; cordBlock < 4.0; cordBlock++) {
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


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        filledFrame(ModBlocks.FILLERBARRIER.get().defaultBlockState(), pLevel, pState, pPos.getX(), pPos.getY(), pPos.getZ());
        BlockState newstate = ModBlocks.GEARDOOR.get().defaultBlockState();
        if (pPlayer.getOffhandItem().getItem() == ModItems.PIP_BOY_D.get()) {
            for (Map.Entry<Property<?>, Comparable<?>> entry : pState.getValues().entrySet()) {
                Property _property = newstate.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                newstate = newstate.setValue(_property, (Comparable) entry.getValue());
            }
            pLevel.setBlock(pPos, newstate, 3);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        //BlockEntity block = pLevel.getBlockEntity(pPos);
        //var block = new GearDoorEntity(pPos, pState);
        //((GearDoorEntity) block).setState(false);

        filledEraser(pLevel, pState, pPos.getX(), pPos.getY(), pPos.getZ());
        //filledFrame(ModBlocks.FILLERBARRIER.get().defaultBlockState(), pLevel, pState, pPos.getX(), pPos.getY(), pPos.getZ());
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
                shapes.add(box(-48.0, 0.0, 0.0, 16.0, 64.0, 16.0));
                break;
            case EAST:
                shapes.add(box(0.0, 0.0, -48.0, 16.0, 64.0, 16.0));
                break;
            case WEST:
                shapes.add(box(0.0, 0.0, 0.0, 16.0, 64.0, 64.0));
                break;
            default:
                shapes.add(box(0.0, 0.0, 0.0, 64.0, 64.0, 16.0));
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
