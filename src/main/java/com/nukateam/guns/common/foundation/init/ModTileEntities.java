package com.nukateam.guns.common.foundation.init;

import com.nukateam.guns.common.foundation.blockentity.WorkbenchBlockEntity;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.blocks.ModBlocks;
import com.nukateam.nukacraft.common.foundation.blocks.entity.GearDoorEntity;
import com.nukateam.nukacraft.common.foundation.entities.blocks.BasicStorageEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModTileEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, NukaCraftMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<WorkbenchBlockEntity>> WORKBENCH = register("workbench", WorkbenchBlockEntity::new, () -> new Block[]{ModBlocks.WORKBENCH.get()});
    public static final RegistryObject<BlockEntityType<BasicStorageEntity>> STORAGE = register("storage", BasicStorageEntity::new, () -> new Block[]{ModBlocks.STORAGE1.get()});


    public static final RegistryObject<BlockEntityType<GearDoorEntity>> GEARDOOR_ENTITY =
            REGISTER.register("animated_block_entity", () ->
                    BlockEntityType.Builder.of(GearDoorEntity::new,
                            ModBlocks.GEARDOOR.get()).build(null));





    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String id, BlockEntityType.BlockEntitySupplier<T> factoryIn, Supplier<Block[]> validBlocksSupplier) {
        return REGISTER.register(id, () -> BlockEntityType.Builder.of(factoryIn, validBlocksSupplier.get()).build(null));
    }
}
