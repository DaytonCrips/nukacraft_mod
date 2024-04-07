package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.example.common.data.interfaces.IExplosiveOnHit;
import com.nukateam.nukacraft.common.data.utils.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.*;

public class ExplosiveBarrel extends Block implements IExplosiveOnHit {
    public static final int EXPLODE_CHANCE = 24;
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();
    private final Random random = new Random();

    public ExplosiveBarrel(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void wasExploded(Level pLevel, BlockPos pPos, Explosion pExplosion) {
        if (!pLevel.isClientSide) {
            pLevel.explode(null, pPos.getX(), pPos.getY(), pPos.getZ(), 3.5f, Explosion.BlockInteraction.DESTROY);
        }
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (!player.isCreative())
            explode(level, pos);
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return this.getShape(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos) {
        return this.getShape(state);
    }

    @Override
    public void explodeOnHit(Level level, BlockPos blockPos) {
        explode(level, blockPos);
    }

    public void explode(Level level, BlockPos pos) {
        int i = random.nextInt(99);
        if (i < EXPLODE_CHANCE) {
            if (!level.isClientSide) {
                level.destroyBlock(pos, false);
                level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 6.0f, Explosion.BlockInteraction.DESTROY);
            }
        }
    }

    private VoxelShape getShape(BlockState state) {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(box(1, 0.01, 1, 15, 15.99, 15));
        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(state, shape);
        return shape;
    }
}
