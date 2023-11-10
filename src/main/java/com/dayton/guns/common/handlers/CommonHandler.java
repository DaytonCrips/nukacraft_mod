package com.dayton.guns.common.handlers;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.client.render.particles.GammaParticles;
import com.dayton.nukacraft.client.render.particles.MushroomCloudParticle;
import com.dayton.nukacraft.client.render.particles.SmallExplosionParticle;
import com.dayton.nukacraft.common.foundation.entities.Deathclaw;
import com.dayton.nukacraft.common.foundation.entities.EntityTypes;
import com.dayton.nukacraft.common.foundation.entities.PowerArmorFrame;
import com.dayton.nukacraft.common.network.PacketHandler;
import com.dayton.nukacraft.common.registery.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.ArrayList;

import static com.dayton.guns.client.handler.ShootingHandler.gunCooldown;
import static com.dayton.nukacraft.common.registery.ModParticles.*;

@Mod.EventBusSubscriber
public class CommonHandler {
    @SubscribeEvent
    public static void tick(final TickEvent event) {
        if((event.type == TickEvent.Type.SERVER || event.type == TickEvent.Type.CLIENT)
                && event.phase == TickEvent.Phase.END){
            var remove = new ArrayList<ItemStack>();

            for (var item : gunCooldown) {
                var tag =  item.getOrCreateTag();
                var cool = tag.getInt("Cooldown");
                if(cool > 0)
                    tag.putInt("Cooldown", --cool);
                else remove.add(item);
            }
            gunCooldown.removeAll(remove);
        }
    }
}
