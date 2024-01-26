package com.nukateam.nukacraft.common.foundation.items.misc;

import com.nukateam.nukacraft.common.foundation.blocks.blocks.MutationFloraClass;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class VioletReagent extends Item {
    public VioletReagent(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        BlockPos posOld = context.getClickedPos();
        BlockState state = level.getBlockState(posOld);
        if (state.getBlock().defaultBlockState().is(BlockTags.create(new ResourceLocation("nukacraft:mutable_plants")))) {
            MutationFloraClass.mutationSucces(state, posOld, level);
            if (!player.isCreative()) {player.getMainHandItem().shrink(1);}
            return InteractionResult.SUCCESS;
        }
        //if (!player.isCreative()) {player.getMainHandItem().shrink(1);}
        return InteractionResult.FAIL;
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
