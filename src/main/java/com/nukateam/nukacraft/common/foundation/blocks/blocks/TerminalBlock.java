package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.ntgl.common.foundation.block.RotatedObjectBlock;
import com.nukateam.nukacraft.common.data.utils.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nukateam.nukacraft.common.registery.world.ModDimensions.WASTELAND_DIMENSION;


public class TerminalBlock extends RotatedObjectBlock {
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();

    public TerminalBlock(Properties properties) {
        super(properties);
    }

    private VoxelShape getShape(BlockState state) {
        if (SHAPES.containsKey(state)) {
            return SHAPES.get(state);
        }
        Direction direction = state.getValue(FACING);
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(box(0.1, 0, 0.1, 15.9, 15.9, 15.9));
        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(state, shape);
        return shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return getShape(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos) {
        return getShape(state);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) {

        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            if (!pPlayer.isCrouching()) {
                MinecraftServer server = pLevel.getServer();

                if (server != null) {
                    if (pLevel.dimension() == WASTELAND_DIMENSION) {
                        ServerLevel overWorld = server.getLevel(Level.OVERWORLD);
                        if (overWorld != null) {
                            pPlayer.changeDimension(overWorld, new WastelandTeleporter(pPos, false));
                        }
                    } else {
                        ServerLevel kjDim = server.getLevel(WASTELAND_DIMENSION);
                        if (kjDim != null) {
                            pPlayer.changeDimension(kjDim, new WastelandTeleporter(pPos, true));
                        }
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (!pLevel.isClientSide()) {
            if (pEntity instanceof LivingEntity) {
                LivingEntity entity = ((LivingEntity) pEntity);
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}