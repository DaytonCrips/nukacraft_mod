package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.guns.common.data.util.VoxelShapeHelper;
import com.nukateam.nukacraft.common.foundation.blocks.entity.OwnableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.MinecraftForge;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class LandMineBlock extends BaseEntityBlock {
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();
//    private UUID owner;

    public LandMineBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {

        var blockEntity = pLevel.getBlockEntity(pPos);
        if (!pLevel.isClientSide && blockEntity instanceof OwnableBlockEntity ownable) {
            if (!(ownable.getOwner().equals(pEntity.getUUID().toString()))) {
                pLevel.destroyBlock(pPos, false);
                pLevel.explode(null, pPos.getX(), pPos.getY(),pPos.getZ(),6.0f, Explosion.BlockInteraction.NONE);
            }
        }

//        if (!pLevel.isClientSide) {
//            if (!(owner == pEntity.getUUID())) {
//                pLevel.destroyBlock(pPos, false);
//                pLevel.explode(null, pPos.getX(), pPos.getY(),pPos.getZ(),6.0f, Explosion.BlockInteraction.NONE);
//            }
//        }
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
        if (pPlacer instanceof Player player) {
//            owner = pPlacer.getUUID();
            var uuid = player.getGameProfile().getId().toString();
            var entity = pLevel.getBlockEntity(pPos);
            if (entity instanceof OwnableBlockEntity ownable) {
                ownable.setOwner(uuid);
            }
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
