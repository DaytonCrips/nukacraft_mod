package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.events.RadiationTracker;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModAttributesClass {
    public static final DeferredRegister<Attribute> ATTRIBUTE = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, NukaCraftMod.MOD_ID);

    public static final RegistryObject<Attribute> RADIATION = registryAttribute("radiation",
            () -> new RangedAttribute("nukacraft_radiation", 0, 0, 100).setSyncable(true));

    private static <T extends Attribute>RegistryObject<T> registryAttribute(String name, Supplier<T> attribute) {
        RegistryObject<T> toReturn = ATTRIBUTE.register(name, attribute);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        ATTRIBUTE.register(eventBus);
    }

    @SubscribeEvent
    public static void addAttributes(EntityAttributeModificationEvent event) {
        if (!event.has(EntityType.PLAYER, ModAttributesClass.RADIATION.get())) {
            event.add(EntityType.PLAYER, ModAttributesClass.RADIATION.get());
        }
        event.add(EntityType.PLAYER, ModAttributesClass.RADIATION.get());
    }
}
