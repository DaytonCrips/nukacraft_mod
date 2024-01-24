package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.guns.common.data.util.VoxelShapeHelper;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.foundation.blocks.entity.GearDoorEntity;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
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

import java.util.*;

public class GearDoorBlock extends  BaseEntityBlock{
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;



    public GearDoorBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.SOUTH));
//        north = new BlockPos[]{
//                new BlockPos(-1.0, 0, 0),
//                new BlockPos(-2.0, 0, 0),
//                new BlockPos(-3.0, 0, 0),
//                new BlockPos(0, 1.0, 0),
//                new BlockPos(0, 2.0, 0),
//                new BlockPos(0, 3.0, 0),
//                new BlockPos(-1.0, 1.0, 0),
//                new BlockPos(-2.0, 1.0, 0),
//                new BlockPos(-3.0, 1.0, 0),
//                new BlockPos(-1.0, 2.0, 0),
//                new BlockPos(-2.0, 2.0, 0),
//                new BlockPos(-3.0, 2.0, 0),
//                new BlockPos(-1.0, 3.0, 0),
//                new BlockPos(-2.0, 3.0, 0),
//                new BlockPos(-3.0, 3.0, 0)
//        };

        //this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new GearDoorEntity(pPos, pState);
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
//        Block block = pState.getBlock();
//        BlockEntity gears = pLevel.getBlockEntity(pPos);
//        if (pLevel.isClientSide) {
//            return InteractionResult.SUCCESS;
//        } else {
//            if (block instanceof GearDoorBlock) {
//                boolean state = ((GearDoorBlock) block).getState();
//                pPlayer.sendMessage(new TextComponent("" + state), pPlayer.getUUID());
//                if (state) {
//                    ((GearDoorBlock) block).setState(false);
//                    filledFrame(ModBlocks.FILLERBARRIER.get().defaultBlockState(), pLevel, pState, pPos.getX(), pPos.getY(), pPos.getZ());
//                } else {
//                    ((GearDoorBlock) block).setState(true);
//                    filledEraser(pLevel, pState, pPos.getX(), pPos.getY(), pPos.getZ());
//                }
//                if (gears instanceof GearDoorEntity) {
//                    ((GearDoorEntity) gears).setState(((GearDoorBlock) block).getState());
//                }
//                return InteractionResult.SUCCESS;
//            } else return InteractionResult.FAIL;
//        }

        BlockState newstate = ModBlocks.OPENGEAR.get().defaultBlockState();
        if (pPlayer.getOffhandItem().getItem() == ModItems.PIP_BOY_D.get()) {
            filledEraser(pLevel, pState, pPos.getX(), pPos.getY(), pPos.getZ());
            for (Map.Entry<Property<?>, Comparable<?>> entry : pState.getValues().entrySet()) {
                Property _property = newstate.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                newstate = newstate.setValue(_property, (Comparable) entry.getValue());
            }
            pLevel.setBlock(pPos, newstate, 3);
            return InteractionResult.SUCCESS;
        } else return InteractionResult.FAIL;
        //BlockEntity block = pLevel.getBlockEntity(pPos);
//        if (pLevel.isClientSide) {
//            return InteractionResult.SUCCESS;
//        } else {
//            if (block instanceof GearDoorEntity) {
//                //((GearDoorEntity) block).changeState();
//                block.getUpdateTag().putBoolean("state", true);
//                boolean state = (block.getUpdateTag().getBoolean("state"));
//                pPlayer.sendMessage(new TextComponent("" + state), pPlayer.getUUID());
//                if (state) {
//                    //((GearDoorEntity) block).setState(false);
//                    block.getUpdateTag().putBoolean("state", false);
//                    filledFrame(ModBlocks.FILLERBARRIER.get().defaultBlockState(), pLevel, pState, pPos.getX(), pPos.getY(), pPos.getZ());
//                } else {
//                    //((GearDoorEntity) block).setState(true);
//                    block.getUpdateTag().putBoolean("state", true);
//                    filledEraser(pLevel, pState, pPos.getX(), pPos.getY(), pPos.getZ());
//                }
//
//                return InteractionResult.SUCCESS;
//            } else return InteractionResult.FAIL;
//
//        }
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        super.tick(pState, pLevel, pPos, pRandom);
    }

    //    protected boolean checkThisOut(Level world, int base_x, int base_y, int base_z){
//
//
//
//        for (int x = 1; x == 4; x++) {
//            for (double t = 1.0; t < 4.0; t++) {
//                if (!(world.getBlockState(new BlockPos(base_x - t, base_y + x, base_z)).getBlock() == Blocks.AIR)) {
//                    return false;
//                } else if (!(world.getBlockState(new BlockPos(base_x-x, base_y, base_z)).getBlock() == Blocks.AIR)) {
//                    return false;
//                } if (!(world.getBlockState(new BlockPos(base_x, base_y+x, base_z)).getBlock() == Blocks.AIR)) {
//                    return false;
//                } else return true;
//            }
////            for (double t = 1.0; t < 4.0; t++) {
////
////            }
//        }
//    }

    protected void filledFrame(BlockState block, Level world, BlockState baseState, int base_x, int base_y, int base_z) {


        switch (baseState.getValue(FACING)) {
            case NORTH:
                for (double posBlocks = 1.0; posBlocks < 4.0; posBlocks++) {
                    world.setBlock(new BlockPos(base_x-posBlocks, base_y, base_z), block, 3);
                    world.setBlock(new BlockPos(base_x, base_y+ posBlocks, base_z), block, 3);
                    for (double cordBlock = 1.0; cordBlock < 4.0; cordBlock++) {
                        world.setBlock(new BlockPos(base_x-posBlocks, base_y+cordBlock, base_z), block, 3);
                    }
                }
                break;
            case EAST:
                for (double posBlocks = 1.0; posBlocks < 4.0; posBlocks++) {
                    world.setBlock(new BlockPos(base_x, base_y, base_z-posBlocks), block, 3);
                    world.setBlock(new BlockPos(base_x, base_y+posBlocks, base_z), block, 3);
                    for (double cordBlock = 1.0; cordBlock < 4.0; cordBlock++) {
                        world.setBlock(new BlockPos(base_x, base_y+cordBlock, base_z-posBlocks), block, 3);
                    }
                }
                break;
            case WEST:
                for (double posBlocks = 1.0; posBlocks < 4.0; posBlocks++) {
                    world.setBlock(new BlockPos(base_x, base_y, base_z+posBlocks), block, 3);
                    world.setBlock(new BlockPos(base_x, base_y+posBlocks, base_z), block, 3);
                    for (double cordBlock = 1.0; cordBlock < 4.0; cordBlock++) {
                        world.setBlock(new BlockPos(base_x, base_y+cordBlock, base_z+posBlocks), block, 3);
                    }
                }
                break;
            case SOUTH:
                for (double posBlocks = 1.0; posBlocks < 4.0; posBlocks++) {
                    world.setBlock(new BlockPos(base_x+posBlocks, base_y, base_z), block, 3);
                    world.setBlock(new BlockPos(base_x, base_y+posBlocks, base_z), block, 3);
                    for (double cordBlock = 1.0; cordBlock < 4.0; cordBlock++) {
                        world.setBlock(new BlockPos(base_x+posBlocks, base_y+cordBlock, base_z), block, 3);
                    }
                }
        }

    }


    protected void filledEraser(Level world, BlockState baseState, int base_x, int base_y, int base_z) {
        BlockState air = Blocks.AIR.defaultBlockState();
        BlockState stairs = ModBlocks.HALFBARRIER.get().defaultBlockState();
        switch (baseState.getValue(FACING)) {
            case NORTH:
                world.setBlock(new BlockPos(base_x-1, base_y+1, base_z), air, 3);
                world.setBlock(new BlockPos(base_x-2, base_y+1, base_z), air, 3);
                world.setBlock(new BlockPos(base_x-1, base_y+2, base_z), air, 3);
                world.setBlock(new BlockPos(base_x-2, base_y+2, base_z), air, 3);
                world.setBlock(new BlockPos(base_x-1, base_y, base_z), stairs, 3);
                world.setBlock(new BlockPos(base_x-2, base_y, base_z), stairs, 3);
                break;
            case SOUTH:
                world.setBlock(new BlockPos(base_x+1, base_y+1, base_z), air, 3);
                world.setBlock(new BlockPos(base_x+2, base_y+1, base_z), air, 3);
                world.setBlock(new BlockPos(base_x+1, base_y+2, base_z), air, 3);
                world.setBlock(new BlockPos(base_x+2, base_y+2, base_z), air, 3);
                world.setBlock(new BlockPos(base_x+1, base_y, base_z), stairs, 3);
                world.setBlock(new BlockPos(base_x+2, base_y, base_z), stairs, 3);
                break;
            case WEST:
                world.setBlock(new BlockPos(base_x, base_y+1, base_z+1), air, 3);
                world.setBlock(new BlockPos(base_x, base_y+1, base_z+2), air, 3);
                world.setBlock(new BlockPos(base_x, base_y+2, base_z+1), air, 3);
                world.setBlock(new BlockPos(base_x, base_y+2, base_z+2), air, 3);
                world.setBlock(new BlockPos(base_x, base_y, base_z+1), stairs, 3);
                world.setBlock(new BlockPos(base_x, base_y, base_z+2), stairs, 3);
                break;
            case EAST:
                world.setBlock(new BlockPos(base_x, base_y+1, base_z-1), air, 3);
                world.setBlock(new BlockPos(base_x, base_y+1, base_z-2), air, 3);
                world.setBlock(new BlockPos(base_x, base_y+2, base_z-1), air, 3);
                world.setBlock(new BlockPos(base_x, base_y+2, base_z-2), air, 3);
                world.setBlock(new BlockPos(base_x, base_y, base_z-1), stairs, 3);
                world.setBlock(new BlockPos(base_x, base_y, base_z-2), stairs, 3);
                break;
        }
    }




    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {

        //BlockEntity block = pLevel.getBlockEntity(pPos);
        //var block = new GearDoorEntity(pPos, pState);
        //((GearDoorEntity) block).setState(false);
        //block.getUpdateTag().putBoolean("state", false);
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
