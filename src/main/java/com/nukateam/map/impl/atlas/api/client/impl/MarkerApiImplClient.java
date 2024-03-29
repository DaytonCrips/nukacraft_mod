package com.nukateam.map.impl.atlas.api.client.impl;

import com.nukateam.map.api.MarkerAPI;
import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.marker.Marker;
import com.nukateam.map.impl.atlas.network.packet.c2s.play.AddMarkerC2SPacket;
import com.nukateam.map.impl.atlas.network.packet.c2s.play.DeleteMarkerRequestC2SPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


@OnlyIn(Dist.CLIENT)
public class MarkerApiImplClient implements MarkerAPI {
    @Nullable
    @Override
    public Marker putMarker(@NotNull Level world, boolean visibleAhead, int atlasID, ResourceLocation marker, Component label, int x, int z) {
        new AddMarkerC2SPacket(atlasID, marker, x, z, visibleAhead, label).send();
        return null;
    }

    @Nullable
    @Override
    public Marker putGlobalMarker(@NotNull Level world, boolean visibleAhead, ResourceLocation marker, Component label, int x, int z) {
        MapCore.LOG.warn("Client tried to add a global marker");

        return null;
    }

    @Override
    public void deleteMarker(@NotNull Level world, int atlasID, int markerID) {
        new DeleteMarkerRequestC2SPacket(atlasID, markerID).send();
    }

    @Override
    public void deleteGlobalMarker(@NotNull Level world, int markerID) {
        MapCore.LOG.warn("Client tried to delete a global marker");
    }
}
