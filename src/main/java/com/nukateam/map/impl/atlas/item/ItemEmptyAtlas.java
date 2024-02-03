package com.nukateam.map.impl.atlas.item;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.core.AtlasData;
import com.nukateam.map.impl.atlas.marker.MarkersData;
import com.nukateam.map.impl.atlas.registry.AntiqueAtlasItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemEmptyAtlas extends Item {
    public ItemEmptyAtlas(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level.isClientSide) {
            level.playSound(player, player.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1F, 1F);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
        }

        int atlasID = MapCore.getGlobalAtlasData(level).getNextAtlasId();
        ItemStack atlasStack = new ItemStack(AntiqueAtlasItems.ATLAS.get());

        atlasStack.getOrCreateTag().putInt("atlasID", atlasID);

        AtlasData atlasData = MapCore.tileData.getData(atlasID, level);
        atlasData.getWorldData(player.getCommandSenderWorld().dimension()).setBrowsingPositionTo(player);
        atlasData.setDirty();

        MarkersData markersData = MapCore.markersData.getMarkersData(atlasID, level);
        markersData.setDirty();

        stack.shrink(1);
        if (stack.isEmpty()) {
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, atlasStack);
        } else {
            if (!player.getInventory().add(atlasStack.copy())) {
                player.drop(atlasStack, true);
            }

            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
        }
    }
}
