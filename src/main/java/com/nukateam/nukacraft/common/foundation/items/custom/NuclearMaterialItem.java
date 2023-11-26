package com.nukateam.nukacraft.common.foundation.items.custom;

import com.nukateam.nukacraft.common.foundation.blocks.ModBlocks;
import com.nukateam.nukacraft.common.foundation.blocks.custom.blocks.MutationFloraClass;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class NuclearMaterialItem extends Item {
    public NuclearMaterialItem(Properties prop) {
        super(prop);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        BlockPos posOld = context.getClickedPos();
        BlockState state = level.getBlockState(posOld);
        if (!(state.getBlock().defaultBlockState() == Blocks.MELON.defaultBlockState()) && !(state.getBlock().defaultBlockState() == ModBlocks.DEATH_PLANT.get().defaultBlockState())) {
            if (state.getBlock().defaultBlockState().is(BlockTags.create(new ResourceLocation("nukacraft:mutable_plants")))) {
                if (level.getRandom().nextInt(100) < 20) {
                    MutationFloraClass.mutationSucces(state, posOld, level);
                } else MutationFloraClass.mutationFailed(state, posOld, level);
                if (!player.isCreative()) {player.getMainHandItem().shrink(1);}
                return InteractionResult.SUCCESS;
            }
        } else return InteractionResult.SUCCESS;

        //if (!player.isCreative()) {player.getMainHandItem().shrink(1);}
        return InteractionResult.FAIL;
    }
}
