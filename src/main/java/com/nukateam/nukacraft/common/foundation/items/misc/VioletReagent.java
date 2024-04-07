package com.nukateam.nukacraft.common.foundation.items.misc;

import com.nukateam.nukacraft.common.data.utils.PlantMutationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

public class VioletReagent extends Item {
    public VioletReagent(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        var player = context.getPlayer();
        var posOld = context.getClickedPos();
        var state = context.getLevel().getBlockState(posOld);
        var isMutablePlant = state.getBlock().defaultBlockState().is(BlockTags.create(new ResourceLocation("nukacraft:mutable_plants")));

        if (isMutablePlant) {
            PlantMutationUtils.mutationSuccess(state, posOld, context.getLevel());
            if (!player.isCreative())
                player.getMainHandItem().shrink(1);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
