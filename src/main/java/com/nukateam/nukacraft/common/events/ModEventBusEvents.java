package com.nukateam.nukacraft.common.events;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.entities.misc.PowerArmorFrame;
import com.nukateam.nukacraft.common.foundation.entities.mobs.*;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
//        var registeredEntities = EntityTypes.ENTITY_TYPES.getEntries();
        event.put(EntityTypes.DEATHCLAW.get(), Deathclaw.createAttributes().build());
        event.put(EntityTypes.POWER_ARMOR_FRAME.get(), PowerArmorFrame.createAttributes().build());
        event.put(EntityTypes.RAIDER.get(), Raider.createAttributes().build());
        event.put(EntityTypes.RADROACH.get(), Radroach.createAttributes().build());
        event.put(EntityTypes.BRAHMIN.get(), Brahmin.createAttributes().build());
        event.put(EntityTypes.BLOATFLY.get(), Bloatfly.createAttributes().build());
        event.put(EntityTypes.MOLERAT.get(), Molerat.createAttributes().build());
        event.put(EntityTypes.ASSAULTRON.get(), Assaultron.createAttributes().build());

    }
}