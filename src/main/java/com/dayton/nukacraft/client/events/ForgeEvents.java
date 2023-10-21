package com.dayton.nukacraft.client.events;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.client.models.endity.core.ClientProxy;
import com.dayton.nukacraft.common.foundation.entities.NuclearExplosionEffectEntity;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.advancements.AdvancementsScreen;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.dayton.nukacraft.client.models.endity.core.ClientProxy.getNukesAround;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeEvents {
    @SubscribeEvent
    public static void computeCameraAngles(EntityViewRenderEvent.CameraSetup event) {
        var player = Minecraft.getInstance().getCameraEntity();
        var partialTick = Minecraft.getInstance().getFrameTime();
        var nukes = getNukesAround();

        if(player == null || nukes.isEmpty()) return;

        var tremorAmount = nukes.get(0).renderNukeSkyDarkFor > 0 ? 1.5F : 0F;

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
        var minecraft = Minecraft.getInstance();
        if(minecraft.player == null) return;

        if (event.phase != TickEvent.Phase.END) return;
        var explosions = getNukesAround();

        for (var explosion : explosions) {
            explosion.prevNukeFlashAmount = explosion.nukeFlashAmount;
            if (explosion.renderNukeSkyDarkFor > 0) {
                explosion.renderNukeSkyDarkFor--;
            }
            if (explosion.muteNonNukeSoundsFor > 0) {
                explosion.muteNonNukeSoundsFor--;
                if (explosion.masterVolumeNukeModifier < 1.0F) {
                    explosion.masterVolumeNukeModifier += 0.1F;
                }
            } else if (explosion.masterVolumeNukeModifier > 0.0F) {
                explosion.masterVolumeNukeModifier -= 0.1F;
            }
            if (explosion.renderNukeFlashFor > 0) {
                if (explosion.nukeFlashAmount < 1F) {
                    explosion.nukeFlashAmount = Math.min(explosion.nukeFlashAmount + 0.4F, 1F);
                }
                explosion.renderNukeFlashFor--;
            } else if (explosion.nukeFlashAmount > 0F) {
                explosion.nukeFlashAmount = Math.max(explosion.nukeFlashAmount - 0.05F, 0F);
            }
            else if (explosion.possessionStrengthAmount > 0F) {
                explosion.possessionStrengthAmount = Math.max(explosion.possessionStrengthAmount - 0.05F, 0F);
            }
        }
    }
}
