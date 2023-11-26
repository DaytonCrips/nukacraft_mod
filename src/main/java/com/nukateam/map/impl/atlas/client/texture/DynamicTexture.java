package com.nukateam.map.impl.atlas.client.texture;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * A generic texture, which needs the size of the texture at construction time.
 */
@OnlyIn(Dist.CLIENT)
public class DynamicTexture extends Texture {
    public final int width;
    public final int height;

    public DynamicTexture(ResourceLocation texture, int width, int height) {
        super(texture, width, height);
        this.width = width;
        this.height = height;
    }

    @Override
    public void bind() {
        RenderSystem.setShaderTexture(0, getTexture());
    }

    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }
}
