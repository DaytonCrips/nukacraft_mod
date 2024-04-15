package com.nukateam.nukacraft.common.foundation.blocks.plants;

import com.nukateam.nukacraft.common.registery.items.ModFood;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FusFruitBlock extends BaseBushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    public static final VoxelShape BUSHLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    public static final VoxelShape GROWING_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    int ticks = 0;

    public FusFruitBlock(Properties p_51021_) {
        super(p_51021_);
    }


    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(ModFood.FUSFRUIT.get());
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if (state.getValue(AGE) == 0) {
            return BUSHLING_SHAPE;
        } else {
            return state.getValue(AGE) < 2 ? GROWING_SHAPE : super.getShape(state, getter, pos, context);
        }
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 2;
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int i = state.getValue(AGE);
        if (i < 2 && level.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt(5) == 0)) {
            level.setBlock(pos, state.setValue(AGE, Integer.valueOf(i + 1)), 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
        }
    }


    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        int i = state.getValue(AGE);
        boolean flag = i == 2;
        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(ModFood.FUSFRUIT.get(), j + (flag ? 1 : 0)));
            level.playSound((Player) null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(AGE, Integer.valueOf(1)), 2);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(state, level, pos, player, hand, result);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(AGE);
    }

    public boolean isValidBonemealTarget(LevelReader getter, BlockPos pos, BlockState state, boolean pIsClient) {
        return state.getValue(AGE) < 2;
    }

    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, RandomSource random, BlockPos pos, BlockState state) {
        int i = Math.min(3, state.getValue(AGE) + 1);
        serverLevel.setBlock(pos, state.setValue(AGE, Integer.valueOf(i)), 2);
    }
}
