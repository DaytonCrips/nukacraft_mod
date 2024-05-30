package com.nukateam.nukacraft.client.helpers;

import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier LOWSTEEL = new ForgeTier(2, 140, 1.5f,
            1f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.STEELING.get()));
    public static final ForgeTier SCRAP = new ForgeTier(1, 60, 1.1f,
            1f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.STEELING.get()));
}
