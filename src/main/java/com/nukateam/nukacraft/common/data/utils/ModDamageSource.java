package com.nukateam.nukacraft.common.data.utils;

import net.minecraft.world.damagesource.DamageSource;

public class ModDamageSource extends DamageSource {
    public static final DamageSource ULTRACITE_STEP = new DamageSource("ultracite_step");
    public ModDamageSource(String pMessageId) {
        super(pMessageId);
    }
}
