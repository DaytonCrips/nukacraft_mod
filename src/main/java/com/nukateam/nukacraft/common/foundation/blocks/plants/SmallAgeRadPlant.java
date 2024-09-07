package com.nukateam.nukacraft.common.foundation.blocks.plants;

import com.nukateam.nukacraft.common.data.utils.HarvestUtils;
import com.nukateam.nukacraft.common.data.utils.PlantMutationUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

import static com.nukateam.nukacraft.common.data.utils.BiomeUtils.isInGlowSea;
import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class SmallAgeRadPlant extends BaseBushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static final VoxelShape BUSHLING_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    public static final VoxelShape GROWING_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    //Item finalItem;
    Random rand = new Random();

    public SmallAgeRadPlant(Properties properties) {
        super(properties);
        //this.finalItem = stack;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
    }


    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(BlockTags.DIRT) || pState.is(Blocks.FARMLAND);
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return BUSHLING_SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    public BlockBehaviour.OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XZ;
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 3;
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        var isMutablePlant = state
                .getBlock()
                .defaultBlockState()
                .is(BlockTags.create(nukaResource("mutable_plants")));

        var chance = rand.nextFloat();
        var age = state.getValue(AGE);

        if (age < 3 && level.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt(5) == 0)) {
            if (isInGlowSea(level, pos, state)) {
                if (isMutablePlant && chance < 0.5) {
                    PlantMutationUtils.mutationSuccess(state, pos, level);
                } else {
                    level.setBlock(pos, state.setValue(AGE, Integer.valueOf(age + 1)), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
                }
            } else {
                level.setBlock(pos, state.setValue(AGE, Integer.valueOf(age + 1)), 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
            }
        }
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(HarvestUtils.getFinishItem(state), j + (flag ? 1 : 0)));
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
        return state.getValue(AGE) < 3;
    }

    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, RandomSource random, BlockPos pos, BlockState state) {
        int i = Math.min(3, state.getValue(AGE) + 1);
        serverLevel.setBlock(pos, state.setValue(AGE, Integer.valueOf(i)), 2);
    }
}
