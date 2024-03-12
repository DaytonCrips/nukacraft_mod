package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.nukacraft.common.data.utils.VoxelShapeHelper;
import com.nukateam.nukacraft.common.foundation.entities.blocks.OwnableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import com.nukateam.example.common.data.interfaces.IExplosiveOnHit;

import java.util.*;

public class LandMineBlock extends BaseEntityBlock implements IExplosiveOnHit {
    public static final int EXPLODE_CHANCE = 60;
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();
    private final Random random = new Random();

    public LandMineBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        var blockEntity = pLevel.getBlockEntity(pPos);

        if (!pLevel.isClientSide && blockEntity instanceof OwnableBlockEntity ownable) {
            if (!(ownable.getOwner().equals(pEntity.getUUID().toString()))) {
                explode(pLevel, pPos);
            }
        }
    }

    public void explode(Level pLevel, BlockPos pPos) {
        pLevel.destroyBlock(pPos, false);
        pLevel.explode(null, pPos.getX(), pPos.getY(),pPos.getZ(),2.0f, Explosion.BlockInteraction.NONE);
    }

    @Override
    public void explodeOnHit(Level level, BlockPos pos) {
        int i = random.nextInt(99);
        if (i < EXPLODE_CHANCE) {
            if (!level.isClientSide) {
                level.destroyBlock(pos, false);
                level.explode(null, pos.getX(), pos.getY(), pos.getZ(),6.0f, Explosion.BlockInteraction.NONE);
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
        var shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(pState, shape);
        return shape;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        if (pPlacer instanceof Player player) {
            var uuid = player.getGameProfile().getId().toString();
            var entity = pLevel.getBlockEntity(pPos);

            if (entity instanceof OwnableBlockEntity ownable)
                ownable.setOwner(uuid);
        }
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new OwnableBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}
