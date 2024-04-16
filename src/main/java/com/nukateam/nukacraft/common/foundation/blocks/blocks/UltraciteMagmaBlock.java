package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.nukacraft.common.registery.ModDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class UltraciteMagmaBlock extends Block {
    public UltraciteMagmaBlock(Properties pProperties) {
        super(pProperties);
    }

    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (pEntity instanceof LivingEntity) {
            pEntity.hurt(ModDamageTypes.Sources.UltraciteDamageSource.source(pLevel.registryAccess()), 4.0F);
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        int i = pPos.getX();
        int j = pPos.getY();
        int k = pPos.getZ();
        double d0 = (double) i + pRandom.nextDouble();
        double d1 = (double) j + 0.7D;
        double d2 = (double) k + pRandom.nextDouble();
        pLevel.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        super.animateTick(pState, pLevel, pPos, pRandom);
    }

}
