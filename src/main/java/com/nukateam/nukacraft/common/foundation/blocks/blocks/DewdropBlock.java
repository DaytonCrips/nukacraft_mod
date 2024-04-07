package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CocoaBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class DewdropBlock extends CocoaBlock {
    protected static final VoxelShape WEST_AABB = Block.box(0.09999999999999964, 0.1, 0.09999999999999892, 2.0999999999999996, 15.9, 15.9);
    protected static final VoxelShape EAST_AABB = Block.box(13.9, 0.1, 0.09999999999999892, 15.9, 15.9, 15.9);
    protected static final VoxelShape SOUTH_AABB = Block.box(0.1, 0.1, 13.9, 15.9, 15.9, 15.9);
    protected static final VoxelShape NORTH_AABB = Block.box(0.1, 0.1, 0.1999999999999993, 15.9, 15.9, 2.1999999999999993);

    public DewdropBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState blockstate = pLevel.getBlockState(pPos.relative(pState.getValue(FACING)));
        return blockstate.is(ModBlocks.CRANBERRYWOOD.get());
    }

//    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
//        int i = state.getValue(AGE);
//        boolean flag = i == 2;
//        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
//            return InteractionResult.PASS;
//        } else if (i > 1) {
//            int j = 1 + level.random.nextInt(2);
//            popResource(level, pos, new ItemStack(ModItems.GLOWINGRES.get(), j + (flag ? 1 : 0)));
//            level.playSound((Player)null, pos, SoundEvents.HONEY_BLOCK_HIT, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
//            level.setBlock(pos, state.setValue(AGE, Integer.valueOf(0)), 2);
//            return InteractionResult.sidedSuccess(level.isClientSide);
//        } else {
//            return super.use(state, level, pos, player, hand, result);
//        }
//    }

    public void animateTick(BlockState p_154704_, Level p_154705_, BlockPos p_154706_, Random p_154707_) {
        int i = p_154706_.getX();
        int j = p_154706_.getY();
        int k = p_154706_.getZ();
        double d0 = (double) i + p_154707_.nextDouble();
        double d1 = (double) j + 0.7D;
        double d2 = (double) k + p_154707_.nextDouble();
        p_154705_.addParticle(ParticleTypes.FALLING_SPORE_BLOSSOM, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int l = 0; l < 14; ++l) {
            blockpos$mutableblockpos.set(i + Mth.nextInt(p_154707_, -10, 10), j - p_154707_.nextInt(10), k + Mth.nextInt(p_154707_, -10, 10));
            BlockState blockstate = p_154705_.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.isCollisionShapeFullBlock(p_154705_, blockpos$mutableblockpos)) {
                p_154705_.addParticle(ParticleTypes.SPORE_BLOSSOM_AIR, (double) blockpos$mutableblockpos.getX() + p_154707_.nextDouble(), (double) blockpos$mutableblockpos.getY() + p_154707_.nextDouble(), (double) blockpos$mutableblockpos.getZ() + p_154707_.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, Random pRand, BlockPos pPos, BlockState pState) {
        return true;
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        //int i = pState.getValue(AGE);
        switch ((Direction) pState.getValue(FACING)) {
            case SOUTH:
                return SOUTH_AABB;
            case NORTH:
            default:
                return NORTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:
                return EAST_AABB;
        }
    }
}
