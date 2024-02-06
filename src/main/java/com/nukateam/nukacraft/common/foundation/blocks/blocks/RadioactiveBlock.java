package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import net.minecraft.world.level.block.Block;

public class RadioactiveBlock extends Block {
    private float radiation;

    public RadioactiveBlock(Properties pProperties, float radiation) {
        super(pProperties);
        this.radiation = radiation;
    }

    public float getRadiation() {
        return radiation;
    }
}
