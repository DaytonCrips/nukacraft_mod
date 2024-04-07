package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.blocks.fluids.AcidFluidBlock;
import com.nukateam.nukacraft.common.foundation.blocks.fluids.RadWaterBlock;
import com.nukateam.nukacraft.common.foundation.materials.BlockMaterials;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import oshi.util.tuples.Pair;

import javax.annotation.Nullable;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

@SuppressWarnings({"Convert2MethodRef", "FunctionalExpressionCanBeFolded"})
public class ModFluids {
//    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
//    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
//    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final ResourceLocation ACID_STILL_RL = nukaResource("fluid/acid_still");
    public static final ResourceLocation ACID_FLOWING_RL = nukaResource("fluid/acid_flow");
    public static final ResourceLocation ACID_OVERLAY_RL = nukaResource("fluid/acid_overlay");

    public static final ResourceLocation POISONOUS_WATER_STILL_RL = nukaResource("fluid/acid_still");
    public static final ResourceLocation POISONOUS_WATER_FLOWING_RL = nukaResource("fluid/acid_flow");
    public static final ResourceLocation POISONOUS_WATER_OVERLAY_RL = nukaResource("fluid/acid_overlay");

    public static final ResourceLocation DIRTY_WATER_STILL_RL = nukaResource("fluid/acid_still");
    public static final ResourceLocation DIRTY_WATER_FLOWING_RL = nukaResource("fluid/acid_flow");
    public static final ResourceLocation DIRTY_WATER_OVERLAY_RL = nukaResource("fluid/acid_overlay");

//    public static final ResourceLocation WATER_STILL_RL   = nukaResource("block/creosote_still");
//    public static final ResourceLocation WATER_FLOWING_RL = nukaResource("block/creosote_flow" );

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, NukaCraftMod.MOD_ID);
    public static final RegistryObject<LiquidBlock> ACID_BLOCK = ModBlocks.BLOCKS.register("acid",
            () -> new AcidFluidBlock(BlockBehaviour.Properties.of(BlockMaterials.ACID_MATERIAL).noCollission().strength(100f).noDrops()));    public static final RegistryObject<FlowingFluid> ACID_FLUID
            = FLUIDS.register("acid_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.ACID_PROPERTIES));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }    public static final RegistryObject<FlowingFluid> ACID_FLOWING
            = FLUIDS.register("acid_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.ACID_PROPERTIES));

    @Nullable
    public static Pair<Block, Block> getLavaInteraction(FluidState fluidState) {
        var fluid = fluidState.getType();
        if (fluid.isSame(ACID_FLUID.get()))
            return new Pair<>(Blocks.CRYING_OBSIDIAN, Blocks.TUFF);
        return null;
    }    public static final RegistryObject<FlowingFluid> DIRTY_WATER_FLUID
            = FLUIDS.register("dirty_water_still", () -> new ForgeFlowingFluid.Source(ModFluids.DIRTY_WATER_PROPERTIES));

    public static final RegistryObject<FlowingFluid> DIRTY_WATER_FLOWING
            = FLUIDS.register("dirty_water_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.DIRTY_WATER_PROPERTIES));

    public static final RegistryObject<FlowingFluid> POISONOUS_WATER_FLUID
            = FLUIDS.register("poisonous_water_still", () -> new ForgeFlowingFluid.Source(ModFluids.POISONOUS_WATER_PROPERTIES));

    public static final RegistryObject<FlowingFluid> POISONOUS_WATER_FLOWING
            = FLUIDS.register("poisonous_water_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.POISONOUS_WATER_PROPERTIES));




    public static final RegistryObject<LiquidBlock> DIRTY_WATER_BLOCK = ModBlocks.BLOCKS.register("dirty_water",
            () -> new RadWaterBlock(() -> ModFluids.DIRTY_WATER_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));

    public static final RegistryObject<LiquidBlock> POISONOUS_WATER_BLOCK = ModBlocks.BLOCKS.register("poisonous_water",
            () -> new RadWaterBlock(() -> ModFluids.POISONOUS_WATER_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));


    public static final ForgeFlowingFluid.Properties ACID_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> ACID_FLUID.get(), () -> ACID_FLOWING.get(), FluidAttributes.builder(ACID_STILL_RL, ACID_FLOWING_RL)
            .density(20)
            .luminosity(2)
            .viscosity(5)
            .sound(SoundEvents.HONEY_DRINK)
            .rarity(Rarity.UNCOMMON)
            .gaseous()
            .overlay(ACID_OVERLAY_RL)
//            .color(0xA1E038FF)
    )
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.ACID_BLOCK.get()).bucket(() -> ModItems.ACID_BUCKET.get());

    public static final ForgeFlowingFluid.Properties DIRTY_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> DIRTY_WATER_FLUID.get(), () -> DIRTY_WATER_FLOWING.get(), FluidAttributes.builder(DIRTY_WATER_STILL_RL, DIRTY_WATER_FLOWING_RL)
            .density(20)
            .luminosity(2)
            .viscosity(5)
            .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY)
            .overlay(DIRTY_WATER_OVERLAY_RL))
            .canMultiply()
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.DIRTY_WATER_BLOCK.get()).bucket(() -> ModItems.DIRTY_WATER_BUCKET.get());

    public static final ForgeFlowingFluid.Properties POISONOUS_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> POISONOUS_WATER_FLUID.get(), () -> POISONOUS_WATER_FLOWING.get(), FluidAttributes.builder(POISONOUS_WATER_STILL_RL, POISONOUS_WATER_FLOWING_RL)
            .density(20)
            .luminosity(2)
            .viscosity(5)
            .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY)
            .overlay(POISONOUS_WATER_OVERLAY_RL))
            .canMultiply()
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.POISONOUS_WATER_BLOCK.get()).bucket(() -> ModItems.POISONOUS_WATER_BUCKET.get());





}