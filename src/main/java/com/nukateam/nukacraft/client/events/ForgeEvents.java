package com.nukateam.nukacraft.client.events;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.utils.ExplosionType;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.jetug.chassis_core.common.util.helpers.MathHelper.getFraction;
import static com.nukateam.nukacraft.client.helpers.ExplosionUtils.*;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeEvents {
    @SubscribeEvent
    public static void computeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
        var minecraft = Minecraft.getInstance();
        var player = minecraft.getCameraEntity();
        var nukes = getNukesAround();
        if (player == null || nukes.isEmpty()) return;
        var nuke = nukes.get(0);
        var explosionType = nuke.getExplosionType();
        var tremorAmount = nuke.tremorFor > 0 ? explosionType.getTremorIntensity() : 0F;

        if (tremorAmount > 0) {
            if (lastTremorTick != player.tickCount)
                lastTremorTick = player.tickCount;
            var intensity = scaleTremor(tremorAmount, explosionType) * minecraft.options.screenEffectScale().get();
            intensity *= nuke.getTremorIntensity();
            var camera = event.getCamera();
            var rng = player.level().random;

            try {
                var move = Camera.class.getDeclaredMethod("move", double.class, double.class, double.class);
                move.setAccessible(true);
                move.invoke(camera,
                        rng.nextFloat() * 0.2F * intensity,
                        rng.nextFloat() * 0.2F * intensity,
                        rng.nextFloat() * 0.5F * intensity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static double scaleTremor(double tremor, ExplosionType explosionType) {
        var distance = getDistanceToNearestExplosion();
        if (distance == null) return 0;
        return tremor - tremor * getFraction(distance, explosionType.getTremorDistance());
    }
}
