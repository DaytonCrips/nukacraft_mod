package com.dayton.nukacraft.guns.init;

import com.dayton.nukacraft.common.foundation.blocks.ModBlocksClass;
import com.dayton.nukacraft.guns.Reference;
import com.dayton.nukacraft.guns.blockentity.WorkbenchBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class ModTileEntities
{
    public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Reference.MOD_ID);

    public static final RegistryObject<BlockEntityType<WorkbenchBlockEntity>> WORKBENCH = register("workbench", WorkbenchBlockEntity::new, () -> new Block[]{ModBlocksClass.WORKBENCH.get()});

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String id, BlockEntityType.BlockEntitySupplier<T> factoryIn, Supplier<Block[]> validBlocksSupplier)
    {
        return REGISTER.register(id, () -> BlockEntityType.Builder.of(factoryIn, validBlocksSupplier.get()).build(null));
    }
}
