package com.nukateam.nukacraft.common.foundation.items.misc;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.data.utils.PlantMutationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;

public class NuclearMaterialItem extends Item {
    public NuclearMaterialItem(Properties prop) {
        super(prop);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        var player = context.getPlayer();
        var level = context.getLevel();
        var posOld = context.getClickedPos();
        var state = level.getBlockState(posOld);
        var blockState = state.getBlock().defaultBlockState();

        var isNotMelon = blockState != Blocks.MELON.defaultBlockState();
        var isNotDead = blockState != ModBlocks.DEAD_PLANT.get().defaultBlockState();

        if (isNotMelon && isNotDead && blockState.is(BlockTags.create(new ResourceLocation("nukacraft:mutable_plants")))) {
            if (level.getRandom().nextInt(100) < 20)
                PlantMutationUtils.mutationSuccess(state, posOld, level);

            else PlantMutationUtils.mutationFailed(posOld, level);

            if (!player.isCreative())
                player.getMainHandItem().shrink(1);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
