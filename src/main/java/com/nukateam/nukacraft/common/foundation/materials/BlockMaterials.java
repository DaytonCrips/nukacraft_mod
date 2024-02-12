package com.nukateam.nukacraft.common.foundation.materials;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;

public class BlockMaterials {
    public static final Material ACID_MATERIAL =
            new Material(MaterialColor.COLOR_LIGHT_GREEN, true, false, false,
                    false, false, true, PushReaction.DESTROY);

}
