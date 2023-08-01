package com.dayton.nukacraft.init.blocks.custom.plants;

import com.dayton.nukacraft.init.items.ModItemsClass;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Random;

public class PungaBlock extends BushBlock implements BonemealableBlock, LiquidBlockContainer, net.minecraftforge.common.IForgeShearable{
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
    public static final VoxelShape BUSHLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    public static final VoxelShape GROWING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);

    public PungaBlock(Properties p_51021_) {
        super(p_51021_);
    }


    public BlockBehaviour.OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XZ;
    }

    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(ModItemsClass.PUNGA.get());
    }
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if (state.getValue(AGE) == 0) {
            return BUSHLING_SHAPE;
        } else {
            return state.getValue(AGE) < 5 ? GROWING_SHAPE : super.getShape(state, getter, pos, context);
        }
    }
    @Override
    public FluidState getFluidState(BlockState p_154537_) {
        return Fluids.WATER.getSource(false);
    }
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 5;
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        BlockPos detect = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
        if (level.canSeeSky(detect)) {
            int i = state.getValue(AGE);
            if (i < 3 && level.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt(5) == 0)) {
                level.setBlock(pos, state.setValue(AGE, Integer.valueOf(i + 1)), 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
            }
        }
    }
    @Override
    public BlockState updateShape(BlockState p_154530_, Direction p_154531_, BlockState p_154532_, LevelAccessor p_154533_, BlockPos p_154534_, BlockPos p_154535_) {
        BlockState blockstate = super.updateShape(p_154530_, p_154531_, p_154532_, p_154533_, p_154534_, p_154535_);
        if (!blockstate.isAir()) {
            p_154533_.scheduleTick(p_154534_, Fluids.WATER, Fluids.WATER.getTickDelay(p_154533_));
        }

        return blockstate;
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter p_54766_, BlockPos p_54767_, BlockState p_54768_, Fluid p_54769_) {
        return false;
    }


    public InteractionResult use(BlockState p_57275_, Level p_57276_, BlockPos p_57277_, Player p_57278_, InteractionHand p_57279_, BlockHitResult p_57280_) {
        int i = p_57275_.getValue(AGE);
        boolean flag = i == 5;
        if (!flag && p_57278_.getItemInHand(p_57279_).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + p_57276_.random.nextInt(2);
            popResource(p_57276_, p_57277_, new ItemStack(ModItemsClass.PUNGA.get(), j + (flag ? 1 : 0)));
            p_57276_.playSound((Player)null, p_57277_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
            p_57276_.setBlock(p_57277_, p_57275_.setValue(AGE, Integer.valueOf(1)), 2);
            return InteractionResult.sidedSuccess(p_57276_.isClientSide);
        } else {
            return super.use(p_57275_, p_57276_, p_57277_, p_57278_, p_57279_, p_57280_);
        }
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57282_) {
        p_57282_.add(AGE);
    }

    public boolean isValidBonemealTarget(BlockGetter p_57260_, BlockPos p_57261_, BlockState p_57262_, boolean p_57263_) {
        return p_57262_.getValue(AGE) < 5;
    }

    public boolean isBonemealSuccess(Level p_57265_, Random p_57266_, BlockPos p_57267_, BlockState p_57268_) {
        return true;
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_154503_) {
        FluidState fluidstate = p_154503_.getLevel().getFluidState(p_154503_.getClickedPos());
        return fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8 ? super.getStateForPlacement(p_154503_) : null;
    }


    public void performBonemeal(ServerLevel p_57251_, Random p_57252_, BlockPos p_57253_, BlockState p_57254_) {
        int i = Math.min(3, p_57254_.getValue(AGE) + 1);
        p_57251_.setBlock(p_57253_, p_57254_.setValue(AGE, Integer.valueOf(i)), 2);
    }
    @Override
    public boolean placeLiquid(LevelAccessor p_54770_, BlockPos p_54771_, BlockState p_54772_, FluidState p_54773_) {
        return false;
    }
}
