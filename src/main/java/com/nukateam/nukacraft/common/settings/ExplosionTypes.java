package com.nukateam.nukacraft.common.settings;

import com.nukateam.nukacraft.common.data.utils.ExplosionType;

public class ExplosionTypes {
    public static ExplosionType MINI_NUKE = new ExplosionType()
            .size(1)
            .duration(140)
            .tremorDistance(45)
            .tremorDuration(120)
            .tremorIntensity(1.5f)
            .flashDistance(50)
            .flashDuration(16);
}
