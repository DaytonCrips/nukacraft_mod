package com.dayton.nukacraft.client.events;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.client.models.endity.core.ClientProxy;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.advancements.AdvancementsScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Method;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeEvents {
    @SubscribeEvent
    public static void computeCameraAngles(EntityViewRenderEvent.CameraSetup event) {
        var player = Minecraft.getInstance().getCameraEntity();
        var partialTick = Minecraft.getInstance().getFrameTime();
        var tremorAmount = ClientProxy.renderNukeSkyDarkFor > 0 ? 1.5F : 0F;

//        if (player instanceof PossessesCamera watcherEntity) {
//            Minecraft.getInstance().options.setCameraType(CameraType.FIRST_PERSON);
//            tremorAmount = watcherEntity.isPossessionBreakable() ? AlexsCaves.PROXY.getPossessionStrengthAmount(partialTick) : 0F;
//        }

        if(player == null) return;

        float shakeDistanceScale = 20F;
        double distance = Double.MAX_VALUE;

//        if (tremorAmount == 0) {
//            var aabb = player.getBoundingBox().inflate(shakeDistanceScale);
//            for (Mob screenShaker : Minecraft.getInstance().level.getEntitiesOfClass(Mob.class, aabb, (mob -> mob instanceof ShakesScreen))) {
//                if (((ShakesScreen) screenShaker).canFeelShake(player) && screenShaker.distanceTo(player) < distance) {
//                    distance = screenShaker.distanceTo(player);
//                    tremorAmount = (1F - (float) (distance / shakeDistanceScale)) * Math.max(((ShakesScreen) screenShaker).getScreenShakeAmount(partialTick), 0F);
//                }
//            }
//        }
        if (tremorAmount > 0) {
            if (ClientProxy.lastTremorTick != player.tickCount) {
                var rng = player.level.random;
                ClientProxy.randomTremorOffsets[0] = rng.nextFloat();
                ClientProxy.randomTremorOffsets[1] = rng.nextFloat();
                ClientProxy.randomTremorOffsets[2] = rng.nextFloat();
                ClientProxy.lastTremorTick = player.tickCount;
            }
            double intensity = tremorAmount * Minecraft.getInstance().options.screenEffectScale;

            var camera = event.getCamera();

            try {
                Method move = Camera.class.getDeclaredMethod("move", double.class, double.class, double.class);
                move.setAccessible(true);
                move.invoke(camera,
                        ClientProxy.randomTremorOffsets[0] * 0.2F * intensity,
                        ClientProxy.randomTremorOffsets[1] * 0.2F * intensity,
                        ClientProxy.randomTremorOffsets[2] * 0.5F * intensity);

            } catch (Exception e) {e.printStackTrace();}

//
//            event.getCamera().move(
//                    ClientProxy.randomTremorOffsets[0] * 0.2F * intensity,
//                    ClientProxy.randomTremorOffsets[1] * 0.2F * intensity,
//                    ClientProxy.randomTremorOffsets[2] * 0.5F * intensity);
        }


//        if (player instanceof LivingEntity livingEntity && livingEntity.hasEffect(ACEffectRegistry.STUNNED.get())) {
//            event.setRoll((float) (Math.sin((player.tickCount + partialTick) * 0.2F) * 10F));
//        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            ClientProxy.prevNukeFlashAmount = ClientProxy.nukeFlashAmount;
            if (ClientProxy.renderNukeSkyDarkFor > 0) {
                ClientProxy.renderNukeSkyDarkFor--;
            }
            if (ClientProxy.muteNonNukeSoundsFor > 0) {
                ClientProxy.muteNonNukeSoundsFor--;
                if (ClientProxy.masterVolumeNukeModifier < 1.0F) {
                    ClientProxy.masterVolumeNukeModifier += 0.1F;
                }
            } else if (ClientProxy.masterVolumeNukeModifier > 0.0F) {
                ClientProxy.masterVolumeNukeModifier -= 0.1F;
            }
            if (ClientProxy.renderNukeFlashFor > 0) {
                if (ClientProxy.nukeFlashAmount < 1F) {
                    ClientProxy.nukeFlashAmount = Math.min(ClientProxy.nukeFlashAmount + 0.4F, 1F);
                }
                ClientProxy.renderNukeFlashFor--;
            } else if (ClientProxy.nukeFlashAmount > 0F) {
                ClientProxy.nukeFlashAmount = Math.max(ClientProxy.nukeFlashAmount - 0.05F, 0F);
            }
            else if (ClientProxy.possessionStrengthAmount > 0F) {
                ClientProxy.possessionStrengthAmount = Math.max(ClientProxy.possessionStrengthAmount - 0.05F, 0F);
            }
        }
    }
}
