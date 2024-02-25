package com.nukateam.nukacraft.common.foundation.blocks.fluids;

import com.nukateam.nukacraft.common.registery.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class RadWaterBlock extends LiquidBlock {
    public RadWaterBlock(java.util.function.Supplier<? extends FlowingFluid> fluid, Properties pProperties) {
        super(fluid, pProperties);
    }
}
