package com.nukateam.nukacraft.common.registery.fluid;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import oshi.util.tuples.Pair;

import javax.annotation.Nullable;

import static com.nukateam.nukacraft.common.registery.fluid.ModFluidTypes.*;

@SuppressWarnings({"Convert2MethodRef", "FunctionalExpressionCanBeFolded"})
public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, NukaCraftMod.MOD_ID);

    @Nullable
    public static Pair<Block, Block> getLavaInteraction(FluidState fluidState) {
        var fluid = fluidState.getType();
        if (fluid.isSame(ACID_FLUID.get()))
            return new Pair<>(Blocks.CRYING_OBSIDIAN, Blocks.TUFF);
        return null;
    }

    public static final RegistryObject<FlowingFluid> ACID_FLUID
            = FLUIDS.register("acid_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.ACID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> ACID_FLOWING
            = FLUIDS.register("acid_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.ACID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> DIRTY_WATER_FLUID
            = FLUIDS.register("dirty_water_still", () -> new ForgeFlowingFluid.Source(ModFluids.DIRTY_WATER_PROPERTIES));

    public static final RegistryObject<FlowingFluid> DIRTY_WATER_FLOWING
            = FLUIDS.register("dirty_water_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.DIRTY_WATER_PROPERTIES));

    public static final RegistryObject<FlowingFluid> POISONOUS_WATER_FLUID
            = FLUIDS.register("poisonous_water_still", () -> new ForgeFlowingFluid.Source(ModFluids.POISONOUS_WATER_PROPERTIES));

    public static final RegistryObject<FlowingFluid> POISONOUS_WATER_FLOWING
            = FLUIDS.register("poisonous_water_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.POISONOUS_WATER_PROPERTIES));


    //BLOCKS
    public static final RegistryObject<LiquidBlock> ACID_BLOCK = ModBlocks.BLOCKS.register("acid",
            () -> new LiquidBlock(ModFluids.POISONOUS_WATER_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> DIRTY_WATER_BLOCK = ModBlocks.BLOCKS.register("dirty_water",
            () -> new LiquidBlock(ModFluids.DIRTY_WATER_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> POISONOUS_WATER_BLOCK = ModBlocks.BLOCKS.register("poisonous_water",
            () -> new LiquidBlock(ModFluids.POISONOUS_WATER_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));


    //PROPERTIES
    public static final ForgeFlowingFluid.Properties ACID_PROPERTIES =
            new ForgeFlowingFluid.Properties(ACID_FLUID_TYPE, ACID_FLUID, ACID_FLOWING)
                    .slopeFindDistance(2)
                    .levelDecreasePerBlock(2)
                    .block(() -> ModFluids.ACID_BLOCK.get()).bucket(() -> ModItems.ACID_BUCKET.get());

    public static final ForgeFlowingFluid.Properties DIRTY_WATER_PROPERTIES =
            new ForgeFlowingFluid.Properties(DIRTY_WATER_FLUID_TYPE, DIRTY_WATER_FLUID, DIRTY_WATER_FLOWING)
                    .slopeFindDistance(2).levelDecreasePerBlock(2)
                    .block(() -> ModFluids.DIRTY_WATER_BLOCK.get()).bucket(() -> ModItems.DIRTY_WATER_BUCKET.get());

    public static final ForgeFlowingFluid.Properties POISONOUS_WATER_PROPERTIES =
            new ForgeFlowingFluid.Properties(POISONOUS_WATER_FLUID_TYPE, POISONOUS_WATER_FLUID, POISONOUS_WATER_FLOWING)
                    .slopeFindDistance(2).levelDecreasePerBlock(2)
                    .block(() -> ModFluids.POISONOUS_WATER_BLOCK.get()).bucket(() -> ModItems.POISONOUS_WATER_BUCKET.get());


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}