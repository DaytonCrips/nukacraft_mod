package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.blocks.fluids.AcidFluidBlock;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

@SuppressWarnings({"Convert2MethodRef", "FunctionalExpressionCanBeFolded"})
public class ModFluids {
//    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
//    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

//    public static final ResourceLocation WATER_STILL_RL   = nukaResource("block/acid_still");
//    public static final ResourceLocation WATER_FLOWING_RL = nukaResource("block/acid_flow" );

    public static final ResourceLocation WATER_STILL_RL   = nukaResource("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = nukaResource("block/water_flow" );

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> ACID_FLUID
            = FLUIDS.register("acid_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.ACID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> ACID_FLOWING
            = FLUIDS.register("acid_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.ACID_PROPERTIES));

//    public static final Material ACID = (new Material.Builder(MaterialColor.WATER)).noCollider().nonSolid().replaceable().liquid().destroyOnPush().notSolidBlocking().build();

    public static final ForgeFlowingFluid.Properties ACID_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> ACID_FLUID.get(), () -> ACID_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(20)
            .luminosity(2)
            .viscosity(5)
            .sound(SoundEvents.HONEY_DRINK)
            .overlay(WATER_OVERLAY_RL)
//            .color(0xbffcba03)
    )
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.ACID_BLOCK.get()).bucket(() -> ModItems.ACID_BUCKET.get());

    public static final RegistryObject<LiquidBlock> ACID_BLOCK = ModBlocks.BLOCKS.register("acid",
            () -> new AcidFluidBlock(BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}