package com.nukateam.nukacraft.common.foundation.blocks.fluids;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;

public class RadWaterBlock extends LiquidBlock {
    public RadWaterBlock(java.util.function.Supplier<? extends FlowingFluid> fluid, Properties pProperties) {
        super(fluid, pProperties);
    }
}
