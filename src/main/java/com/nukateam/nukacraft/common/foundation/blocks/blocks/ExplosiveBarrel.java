package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.nukacraft.common.data.utils.VoxelShapeHelper;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TargetBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.*;

public class ExplosiveBarrel extends Block {
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();
    Random rand = new Random();
    public ExplosiveBarrel(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public void wasExploded(Level pLevel, BlockPos pPos, Explosion pExplosion) {
        if (!pLevel.isClientSide) {
            pLevel.explode(null, pPos.getX(), pPos.getY(),pPos.getZ(), 6.0f, Explosion.BlockInteraction.DESTROY);
        }

    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        explosive(level, pos);
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    public int explosive(Level level, BlockPos pos) {
        int i = rand.nextInt(99);
        if (i < 24) {
            if (!level.isClientSide) {
                level.destroyBlock(pos, false);
                level.explode(null, pos.getX(), pos.getY(),pos.getZ(), 6.0f, Explosion.BlockInteraction.DESTROY);
            }
        }
        return i;
    }
    private VoxelShape getShape(BlockState state)
    {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(box(1, 0.01, 1, 15, 15.99, 15));
        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(state, shape);
        return shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        return this.getShape(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos)
    {
        return this.getShape(state);
    }
}
