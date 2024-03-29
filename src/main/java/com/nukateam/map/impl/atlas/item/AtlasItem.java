package com.nukateam.map.impl.atlas.item;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.AntiqueAtlasModClient;
import com.nukateam.map.impl.atlas.core.AtlasData;
import com.nukateam.map.impl.atlas.core.TileInfo;
import com.nukateam.map.impl.atlas.marker.MarkersData;
import com.nukateam.map.impl.atlas.network.packet.s2c.play.DimensionUpdateS2CPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.maps.MapBanner;

import java.util.Collection;

public class AtlasItem extends Item {

    public AtlasItem(Properties settings) {
        super(settings);
    }

    public static int getAtlasID(ItemStack stack) {
        return stack.getOrCreateTag().getInt("atlasID");
    }

    @Override
    public Component getName(ItemStack stack) {
        return new TranslatableComponent(this.getDescriptionId(), getAtlasID(stack));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerEntity, InteractionHand hand) {
        ItemStack stack = playerEntity.getItemInHand(hand);

        if (level.isClientSide) {
            AntiqueAtlasModClient.openAtlasGUI(stack);
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide()) {
            return super.useOn(context);
        }

        var blockState = context.getLevel().getBlockState(context.getClickedPos());
        if (blockState.is(BlockTags.BANNERS)) {
            AntiqueAtlasModClient.openAtlasGUI(context.getItemInHand());
            var mapBannerMarker = MapBanner.fromWorld(context.getLevel(), context.getClickedPos());
            AntiqueAtlasModClient.getAtlasGUI().openMarkerFinalizer(mapBannerMarker.getName());
            context.getLevel().playSound(context.getPlayer(), context.getClickedPos(), SoundEvents.BOOK_PAGE_TURN, SoundSource.BLOCKS, 1f, 1f);

            return InteractionResult.SUCCESS;
        }

        return super.useOn(context);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean isEquipped) {
        AtlasData data = MapCore.tileData.getData(stack, world);
        if (data == null || !(entity instanceof Player)) return;

        int atlasId = getAtlasID(stack);

        // On the first run send the map from the server to the client:
        Player player = (Player) entity;
        if (!world.isClientSide && !data.isSyncedOnPlayer(player) && !data.isEmpty()) {
            data.syncOnPlayer(atlasId, player);
        }

        // Same thing with the local markers:
        MarkersData markers = MapCore.markersData.getMarkersData(stack, world);
        if (!world.isClientSide && !markers.isSyncedOnPlayer(player) && !markers.isEmpty()) {
            markers.syncOnPlayer(atlasId, (ServerPlayer) player);
        }

        if (!world.isClientSide) {
        	// Updating map around player
        	Collection<TileInfo> newTiles = MapCore.worldScanner.updateAtlasAroundPlayer(data, player);
            if (!newTiles.isEmpty()) {
                new DimensionUpdateS2CPacket(atlasId, player.getCommandSenderWorld().dimension(), newTiles).send((ServerLevel) world);
            }
        }
    }

}
