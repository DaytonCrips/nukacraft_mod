package com.nukateam.nukacraft.common.foundation.blocks.custom.blocks;

import com.nukateam.guns.common.data.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class LandMineBlock extends Block {
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();
    private UUID owner;

    public LandMineBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (!pLevel.isClientSide) {
            if (!(owner == pEntity.getUUID())) {
                    pLevel.destroyBlock(pPos, false);
                    pLevel.explode(null, pPos.getX(), pPos.getY(),pPos.getZ(),6.0f, Explosion.BlockInteraction.NONE);
                }
            }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (SHAPES.containsKey(pState)) {
            return SHAPES.get(pState);
        }
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(box(5, 0, 5, 11, 1.0999999999999992, 11));
        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(pState, shape);
        return shape;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        if (pPlacer instanceof Player) {
            owner = pPlacer.getUUID();
        }
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
    }
}
