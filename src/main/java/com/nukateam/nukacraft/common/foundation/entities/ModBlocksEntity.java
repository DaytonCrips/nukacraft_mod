package com.nukateam.nukacraft.common.foundation.entities;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.blocks.ModBlocks;
import com.nukateam.nukacraft.common.foundation.blocks.entity.GearDoorEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocksEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, NukaCraftMod.MOD_ID);



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
