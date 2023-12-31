package com.nukateam.map.impl.atlas.client.texture;

import com.nukateam.map.impl.atlas.client.SubTile;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * A specialized class for textures used as tiles in the atlas map.
 * It has a special method to draw SubTile instances give a size of the map.
 * By default, TileTextures DO NOT bind the texture. This is on purpose to allow
 * the performance optimization shown in the SetTileRenderer.
 */
@OnlyIn(Dist.CLIENT)
public class TileTexture extends ATexture {
    public TileTexture(ResourceLocation texture) {
        super(texture, false);
    }

    @Override
    public int width() {
        return 32;
    }

    @Override
    public int height() {
        return 48;
    }

    public void drawSubTile(PoseStack matrices, SubTile subtile, int tileHalfSize) {
        draw(matrices, subtile.x * tileHalfSize, subtile.y * tileHalfSize, tileHalfSize, tileHalfSize, subtile.getTextureU() * 8, subtile.getTextureV() * 8, 8, 8);
    }
}
