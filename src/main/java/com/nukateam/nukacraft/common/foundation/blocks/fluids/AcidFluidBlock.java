package com.nukateam.nukacraft.common.foundation.blocks.fluids;

import com.nukateam.nukacraft.common.registery.ModFluids;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

@SuppressWarnings({"Convert2MethodRef", "FunctionalExpressionCanBeFolded"})
public class AcidFluidBlock extends LiquidBlock {
    public AcidFluidBlock(Properties pProperties) {
        super(() -> ModFluids.ACID_FLUID.get(), pProperties);
    }

    @Override
    public void entityInside(BlockState pState, Level level, BlockPos pPos, Entity entity) {
        if (!level.isClientSide && entity instanceof LivingEntity living) {
            living.hurt(DamageSource.GENERIC, 1);
        }
    }
}
