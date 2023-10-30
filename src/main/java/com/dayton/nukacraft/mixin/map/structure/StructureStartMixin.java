package com.dayton.nukacraft.mixin.map.structure;

import com.dayton.map.impl.atlas.structure.StructureAddedCallback;
import com.dayton.map.impl.atlas.structure.StructurePieceAddedCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.pieces.PiecesContainer;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(StructureStart.class)
public class StructureStartMixin {
    @Shadow
    protected PiecesContainer pieceContainer;


    @Redirect(method = "placeInChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/" +
            "structure/StructurePiece;postProcess(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/" +
            "level/StructureFeatureManager;Lnet/minecraft/world/level/chunk/ChunkGenerator;Ljava/util/Random;" +
            "Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Lnet/minecraft/world/level/ChunkPos;Lnet/minecraft/core/BlockPos;)V"))
    private void structurePieceGenerated(StructurePiece structurePiece, WorldGenLevel serverWorldAccess, StructureFeatureManager structureAccessor, ChunkGenerator chunkGenerator, Random random, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
        ServerLevel world;

        if (serverWorldAccess instanceof ServerLevel) {
            world = (ServerLevel) serverWorldAccess;
        } else {
            world = serverWorldAccess.getLevel();
        }

        MinecraftForge.EVENT_BUS.post(new StructurePieceAddedCallback.TheEvent(structurePiece, world));
        structurePiece.postProcess(serverWorldAccess, structureAccessor, chunkGenerator, random, boundingBox, chunkPos, blockPos);
    }

    @Inject(method = "placeInChunk", at = @At("RETURN"))
    private void structureGenerated(WorldGenLevel serverWorldAccess, StructureFeatureManager structureAccessor, ChunkGenerator chunkGenerator, Random random, BoundingBox blockBox, ChunkPos chunkPos, CallbackInfo ci) {
        ServerLevel world;

        if (serverWorldAccess instanceof ServerLevel) {
            world = (ServerLevel) serverWorldAccess;
        } else {
            world = ((WorldGenRegion) serverWorldAccess).getLevel();
        }

        synchronized (this.pieceContainer.pieces()) {
            if(this.pieceContainer.pieces().isEmpty()) return;
            MinecraftForge.EVENT_BUS.post(new StructureAddedCallback.TheEvent((StructureStart) (Object) this, world));
        }
    }
}
