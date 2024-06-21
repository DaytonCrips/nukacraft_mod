package com.nukateam.nukacraft.common.events;

import com.mojang.blaze3d.systems.RenderSystem;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.ModBiomes;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.CLIENT)
public class FogEventHandler {
//    @SubscribeEvent
//    public void onGetFogColor(EntityViewRenderEvent.FogColors event) {
//        if (!MiscConfigurationHandler.enableFogColours) {
//            return;
//        }
//
//        if (event.getEntity() instanceof EntityPlayer) {
//            EntityPlayer player = (EntityPlayer) event.getEntity();
//            World world = player.world;
//
//            int x = MathHelper.floor(player.posX);
//            int y = MathHelper.floor(player.posY);
//            int z = MathHelper.floor(player.posZ);
//
//            IBlockState stateAtEyes = ActiveRenderInfo.getBlockStateAtEntityViewpoint(world, event.getEntity(), (float) event.getRenderPartialTicks());
//            if (stateAtEyes.getMaterial() == Material.LAVA) {
//                return;
//            }
//
//            Vec3d mixedColor;
//            if (stateAtEyes.getMaterial() == Material.WATER) {
//                mixedColor = getFogBlendColorWater(world, player, x, y, z, event.getRenderPartialTicks());
//            } else {
//                mixedColor = getFogBlendColour(world, player, x, y, z, event.getRed(), event.getGreen(), event.getBlue(), event.getRenderPartialTicks());
//            }
//
//            event.setRed((float) mixedColor.x);
//            event.setGreen((float) mixedColor.y);
//            event.setBlue((float) mixedColor.z);
//        }
//    }

    private static double fogX, fogZ;

    private static boolean fogInit;
    private static float fogFarPlaneDistance;

    @SubscribeEvent
    public static void onRenderFog(ViewportEvent.RenderFog event) {
        var entity = event.getCamera().getEntity();
        var world = entity.level();

        int playerX = Mth.floor((float)entity.position().x());
        int playerY = Mth.floor((float)entity.position().y());
        int playerZ = Mth.floor((float)entity.position().z());

        if (playerX == fogX && playerZ == fogZ && fogInit) {
            renderFog(event.getMode(), fogFarPlaneDistance, 0.75f);
            return;
        }

        fogInit = true;
        var distance = 20;
        var fpDistanceBiomeFog = 0F;
        var weightBiomeFog = 0;
        var pos = new BlockPos.MutableBlockPos(0, 0, 0);

        for (int x = -distance; x <= distance; ++x) {
            for (int z = -distance; z <= distance; ++z) {
                pos.set(playerX + x, 0, playerZ + z);
                var biome = world.getBiome(pos);

                if (biome.is(ModBiomes.POISON_VALLEY.location())) {
                    float distancePart = 0.2f;//((BOPBiome) biome).getSettings(pos);
                    float weightPart = 1;

                    // Check if fog density is enabled for this biome
                    if (x == -distance) {
                        double xDiff = 1 - (entity.position().x() - playerX);
                        distancePart *= xDiff;
                        weightPart *= xDiff;
                    } else if (x == distance) {
                        double xDiff = (entity.position().x() - playerX);
                        distancePart *= xDiff;
                        weightPart *= xDiff;
                    }

                    if (z == -distance) {
                        double zDiff = 1 - (entity.position().z() - playerZ);
                        distancePart *= zDiff;
                        weightPart *= zDiff;
                    } else if (z == distance) {
                        double zDiff = (entity.position().z()  - playerZ);
                        distancePart *= zDiff;
                        weightPart *= zDiff;
                    }

                    fpDistanceBiomeFog += distancePart;
                    weightBiomeFog += weightPart;
                }
            }
        }

        float weightMixed = (distance * 2) * (distance * 2);
        float weightDefault = weightMixed - weightBiomeFog;

        float fpDistanceBiomeFogAvg = (weightBiomeFog == 0) ? 0 : fpDistanceBiomeFog / weightBiomeFog;

        float farPlaneDistance = (fpDistanceBiomeFog * 240 + event.getFarPlaneDistance() * weightDefault) / weightMixed;
        float farPlaneDistanceScaleBiome = (0.1f * (1 - fpDistanceBiomeFogAvg) + 0.75f * fpDistanceBiomeFogAvg);
        float farPlaneDistanceScale = (farPlaneDistanceScaleBiome * weightBiomeFog + 0.75f * weightDefault) / weightMixed;

        fogX = entity.position().x();
        fogZ = entity.position().z() ;
        fogFarPlaneDistance = Math.min(farPlaneDistance, event.getFarPlaneDistance());

        renderFog(event.getMode(), fogFarPlaneDistance, farPlaneDistanceScale);
    }

    private static void renderFog(FogRenderer.FogMode fogMode, float farPlaneDistance, float farPlaneDistanceScale) {
        if (fogMode == FogRenderer.FogMode.FOG_SKY) {
//            GL11.glFogf(GL11.GL_FOG_START, 0.0F);
//            GL11.glFogf(GL11.GL_FOG_END, farPlaneDistance);
            RenderSystem.setShaderTexture(0, 0);
            RenderSystem.setShaderFogStart(0.0F);
            RenderSystem.setShaderFogEnd(farPlaneDistance);
        } else {
//            GL11.glFogf(GL11.GL_FOG_START, farPlaneDistance * farPlaneDistanceScale);
//            GL11.glFogf(GL11.GL_FOG_END, farPlaneDistance);
            RenderSystem.setShaderTexture(0, 0);
            RenderSystem.setShaderFogStart(farPlaneDistance * farPlaneDistanceScale);
            RenderSystem.setShaderFogEnd(farPlaneDistance);
        }
    }

//    private static Vec3d postProcessColor(World world, EntityLivingBase player, double r, double g, double b, double renderPartialTicks) {
//        double darkScale = (player.lastTickPosY + (player.posY - player.lastTickPosY) * renderPartialTicks) * world.provider.getVoidFogYFactor();
//
//        if (player.isPotionActive(MobEffects.BLINDNESS)) {
//            int duration = player.getActivePotionEffect(MobEffects.BLINDNESS).getDuration();
//            darkScale *= (duration < 20) ? (1 - duration / 20f) : 0;
//        }
//
//        if (darkScale < 1) {
//            darkScale = (darkScale < 0) ? 0 : darkScale * darkScale;
//            r *= darkScale;
//            g *= darkScale;
//            b *= darkScale;
//        }
//
//        if (player.isPotionActive(MobEffects.NIGHT_VISION)) {
//            // Get night vision brightness, accounting for wavering at end of potion effect
//            int duration = player.getActivePotionEffect(MobEffects.NIGHT_VISION).getDuration();
//            float brightness = (duration > 200) ? 1 : 0.7f + MathHelper.sin((float) ((duration - renderPartialTicks) * Math.PI * 0.2f)) * 0.3f;
//
//            // Find scale to bring r, g, or b to 1.0
//            // Vanilla will actually set the colors to +Infinity if all components are 0, explaining the terrible
//            // interaction between the blindness and night vision potion effects.
//            double scale = 1 / r;
//            scale = Math.min(scale, 1 / g);
//            scale = Math.min(scale, 1 / b);
//
//            r = r * (1 - brightness) + r * scale * brightness;
//            g = g * (1 - brightness) + g * scale * brightness;
//            b = b * (1 - brightness) + b * scale * brightness;
//        }
//
//        if (Minecraft.getMinecraft().gameSettings.anaglyph) {
//            double aR = (r * 30 + g * 59 + b * 11) / 100;
//            double aG = (r * 30 + g * 70) / 100;
//            double aB = (r * 30 + b * 70) / 100;
//
//            r = aR;
//            g = aG;
//            b = aB;
//        }
//
//        return new Vec3d(r, g, b);
//    }
//
//    private static Vec3d getFogBlendColorWater(World world, EntityLivingBase playerEntity, int playerX, int playerY, int playerZ, double renderPartialTicks) {
//        int distance = 2;
//        float rBiomeFog = 0;
//        float gBiomeFog = 0;
//        float bBiomeFog = 0;
//        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(0, 0, 0);
//
//        for (int x = -distance; x <= distance; ++x) {
//            for (int z = -distance; z <= distance; ++z) {
//                pos.setPos(playerX + x, 0, playerZ + z);
//                Biome biome = world.getBiome(pos);
//                int waterColorMult = biome.getWaterColor();
//
//                float rPart = (waterColorMult & 0xFF0000) >> 16;
//                float gPart = (waterColorMult & 0x00FF00) >> 8;
//                float bPart = waterColorMult & 0x0000FF;
//
//                if (x == -distance) {
//                    double xDiff = 1 - (playerEntity.posX - playerX);
//                    rPart *= xDiff;
//                    gPart *= xDiff;
//                    bPart *= xDiff;
//                } else if (x == distance) {
//                    double xDiff = playerEntity.posX - playerX;
//                    rPart *= xDiff;
//                    gPart *= xDiff;
//                    bPart *= xDiff;
//                }
//
//                if (z == -distance) {
//                    double zDiff = 1 - (playerEntity.posZ - playerZ);
//                    rPart *= zDiff;
//                    gPart *= zDiff;
//                    bPart *= zDiff;
//                } else if (z == distance) {
//                    double zDiff = playerEntity.posZ - playerZ;
//                    rPart *= zDiff;
//                    gPart *= zDiff;
//                    bPart *= zDiff;
//                }
//
//                rBiomeFog += rPart;
//                gBiomeFog += gPart;
//                bBiomeFog += bPart;
//            }
//        }
//
//        rBiomeFog /= 255f;
//        gBiomeFog /= 255f;
//        bBiomeFog /= 255f;
//
//        float weight = (distance * 2) * (distance * 2);
//        float respirationLevel = (float) EnchantmentHelper.getRespirationModifier(playerEntity) * 0.2F;
//
//        float rMixed = (rBiomeFog * 0.02f + respirationLevel) / weight;
//        float gMixed = (gBiomeFog * 0.02f + respirationLevel) / weight;
//        float bMixed = (bBiomeFog * 0.2f + respirationLevel) / weight;
//
//        return postProcessColor(world, playerEntity, rMixed, gMixed, bMixed, renderPartialTicks);
//    }
//
//    private static Vec3d getFogBlendColour(World world, EntityLivingBase playerEntity, int playerX, int playerY, int playerZ, float defR, float defG, float defB, double renderPartialTicks) {
//        GameSettings settings = Minecraft.getMinecraft().gameSettings;
//        int[] ranges = ForgeModContainer.blendRanges;
//        int distance = 6;
//        if (settings.fancyGraphics && settings.renderDistanceChunks >= 0 && settings.renderDistanceChunks < ranges.length) {
//            distance = ranges[settings.renderDistanceChunks];
//        }
//
//        double rBiomeFog = 0;
//        double gBiomeFog = 0;
//        double bBiomeFog = 0;
//        double weightBiomeFog = 0;
//        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(0, 0, 0);
//
//        for (int x = -distance; x <= distance; ++x) {
//            for (int z = -distance; z <= distance; ++z) {
//                pos.setPos(playerX + x, 0, playerZ + z);
//                Biome biome = world.getBiome(pos);
//
//                if (biome instanceof BOPBiome) {
//                    int fogColour = ((BOPBiome) biome).getFogColor(pos);
//
//                    // Ensure fog colouring is enabled for this biome
//                    if (fogColour >= 0) {
//                        double rPart = (fogColour & 0xFF0000) >> 16;
//                        double gPart = (fogColour & 0x00FF00) >> 8;
//                        double bPart = fogColour & 0x0000FF;
//                        float weightPart = 1;
//
//                        if (x == -distance) {
//                            double xDiff = 1 - (playerEntity.posX - playerX);
//                            rPart *= xDiff;
//                            gPart *= xDiff;
//                            bPart *= xDiff;
//                            weightPart *= xDiff;
//                        } else if (x == distance) {
//                            double xDiff = playerEntity.posX - playerX;
//                            rPart *= xDiff;
//                            gPart *= xDiff;
//                            bPart *= xDiff;
//                            weightPart *= xDiff;
//                        }
//
//                        if (z == -distance) {
//                            double zDiff = 1 - (playerEntity.posZ - playerZ);
//                            rPart *= zDiff;
//                            gPart *= zDiff;
//                            bPart *= zDiff;
//                            weightPart *= zDiff;
//                        } else if (z == distance) {
//                            double zDiff = playerEntity.posZ - playerZ;
//                            rPart *= zDiff;
//                            gPart *= zDiff;
//                            bPart *= zDiff;
//                            weightPart *= zDiff;
//                        }
//
//                        rBiomeFog += rPart;
//                        gBiomeFog += gPart;
//                        bBiomeFog += bPart;
//                        weightBiomeFog += weightPart;
//                    }
//                }
//            }
//        }
//
//        if (weightBiomeFog == 0 || distance == 0) {
//            return new Vec3d(defR, defG, defB);
//        }
//
//        rBiomeFog /= 255f;
//        gBiomeFog /= 255f;
//        bBiomeFog /= 255f;
//
//        // Calculate day / night / weather scale for BiomeFog component
//        float celestialAngle = world.getCelestialAngle((float) renderPartialTicks);
//        float baseScale = MathHelper.clamp(MathHelper.cos(celestialAngle * (float) Math.PI * 2.0F) * 2.0F + 0.5F, 0, 1);
//
//        double rScale = baseScale * 0.94F + 0.06F;
//        double gScale = baseScale * 0.94F + 0.06F;
//        double bScale = baseScale * 0.91F + 0.09F;
//
//        float rainStrength = world.getRainStrength((float) renderPartialTicks);
//        if (rainStrength > 0) {
//            rScale *= 1 - rainStrength * 0.5f;
//            gScale *= 1 - rainStrength * 0.5f;
//            bScale *= 1 - rainStrength * 0.4f;
//        }
//
//        float thunderStrength = world.getThunderStrength((float) renderPartialTicks);
//        if (thunderStrength > 0) {
//            rScale *= 1 - thunderStrength * 0.5f;
//            gScale *= 1 - thunderStrength * 0.5f;
//            bScale *= 1 - thunderStrength * 0.5f;
//        }
//
//        // Apply post-processing to BiomeFog component.  Default color was already processed by Vanilla.
//        rBiomeFog *= rScale / weightBiomeFog;
//        gBiomeFog *= gScale / weightBiomeFog;
//        bBiomeFog *= bScale / weightBiomeFog;
//
//        Vec3d processedColor = postProcessColor(world, playerEntity, rBiomeFog, gBiomeFog, bBiomeFog, renderPartialTicks);
//        rBiomeFog = processedColor.x;
//        gBiomeFog = processedColor.y;
//        bBiomeFog = processedColor.z;
//
//        // Mix default fog component with BiomeFog component
//        double weightMixed = (distance * 2) * (distance * 2);
//        double weightDefault = weightMixed - weightBiomeFog;
//
//        double rFinal = (rBiomeFog * weightBiomeFog + defR * weightDefault) / weightMixed;
//        double gFinal = (gBiomeFog * weightBiomeFog + defG * weightDefault) / weightMixed;
//        double bFinal = (bBiomeFog * weightBiomeFog + defB * weightDefault) / weightMixed;
//
//        return new Vec3d(rFinal, gFinal, bFinal);
//    }
}