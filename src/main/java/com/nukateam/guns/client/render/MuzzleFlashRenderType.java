package com.nukateam.guns.client.render;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

//public class MuzzleFlashRenderType extends RenderType {
//    public MuzzleFlashRenderType(String name, VertexFormat vertexFormat, VertexFormat.Mode drawMode,
//                                 int expectedBufferSize, boolean hasCrumbling, boolean translucent,
//                                 Runnable startAction, Runnable endAction) {
//        super(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, startAction, endAction);
//
//    }
//
//    private static final RenderType MUZZLE_FLASH = create(NukaCraftMod.MOD_ID + ":muzzle_flash",
//            DefaultVertexFormat.POSITION_COLOR_TEX_LIGHTMAP, VertexFormat.Mode.QUADS, 256,
//            true, false,
//            RenderType.CompositeState.builder().setShaderState(RenderStateShard.POSITION_COLOR_TEX_LIGHTMAP_SHADER)
//                    .setTextureState(new RenderPhase.Texture(new ResourceLocation(NukaCraftMod.MOD_ID, "textures/misc/muzzleflash_01.png"), false, false))
//                    .transparency(TRANSLUCENT_TRANSPARENCY).lightmap(DISABLE_LIGHTMAP).build(false));
//
//
//    create("solid", DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 2097152, true, false,
//           RenderType.CompositeState.builder().setLightmapState(LIGHTMAP).setShaderState(RENDERTYPE_SOLID_SHADER).setTextureState(BLOCK_SHEET_MIPPED).createCompositeState(true));
//    public static RenderType getMuzzleFlash() {
//        return MUZZLE_FLASH;
//    }
//
//}
