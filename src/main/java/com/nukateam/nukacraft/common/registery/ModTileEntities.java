package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.entities.blocks.BasicStorageEntity;
import com.nukateam.nukacraft.common.foundation.entities.blocks.GearDoorEntity;
import com.nukateam.nukacraft.common.foundation.entities.blocks.OpenGearEntity;
import com.nukateam.nukacraft.common.foundation.entities.blocks.OwnableBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModTileEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NukaCraftMod.MOD_ID);

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String id, BlockEntityType.BlockEntitySupplier<T> factoryIn,
                                                                                       Supplier<Block[]> validBlocksSupplier) {
        return REGISTER.register(id, () -> BlockEntityType.Builder.of(factoryIn, validBlocksSupplier.get()).build(null));
    }

    public static final RegistryObject<BlockEntityType<GearDoorEntity>> GEARDOOR_ENTITY = register("geardoor_tile_entity",
            GearDoorEntity::new, () -> new Block[]{ModBlocks.GEARDOOR.get()});

    public static final RegistryObject<BlockEntityType<OpenGearEntity>> OPENGEAR_ENTITY = register("opengear_tile_entity",
            OpenGearEntity::new, () -> new Block[]{ModBlocks.OPENGEAR.get()});

    public static final RegistryObject<BlockEntityType<OwnableBlockEntity>> OWNABLE_BLOCK_ENTITY = register("ownable_tile_entity",
            OwnableBlockEntity::new, () -> new Block[]{ModBlocks.LANDMINE.get()});

    public static final RegistryObject<BlockEntityType<BasicStorageEntity>> STORAGE_ENTITY = register("storage",
            BasicStorageEntity::new, () -> new Block[]{ModBlocks.STORAGE.get()});


}
