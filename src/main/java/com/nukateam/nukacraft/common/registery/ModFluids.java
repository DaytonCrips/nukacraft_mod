package com.nukateam.nukacraft.common.registery;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.blocks.fluids.AcidFluidBlock;
import com.nukateam.nukacraft.common.foundation.materials.BlockMaterials;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.*;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;
import oshi.util.tuples.Pair;

import javax.annotation.Nullable;
import java.util.*;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;
import static java.util.Map.*;

@SuppressWarnings({"Convert2MethodRef", "FunctionalExpressionCanBeFolded"})
public class ModFluids {
//    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
//    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
//    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final ResourceLocation ACID_STILL_RL   = nukaResource("fluid/acid_still"  );
    public static final ResourceLocation ACID_FLOWING_RL = nukaResource("fluid/acid_flow"   );
    public static final ResourceLocation ACID_OVERLAY_RL = nukaResource("fluid/acid_overlay");

//    public static final ResourceLocation WATER_STILL_RL   = nukaResource("block/creosote_still");
//    public static final ResourceLocation WATER_FLOWING_RL = nukaResource("block/creosote_flow" );

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> ACID_FLUID
            = FLUIDS.register("acid_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.ACID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> ACID_FLOWING
            = FLUIDS.register("acid_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.ACID_PROPERTIES));

//    public static final Material ACID = (new Material.Builder(MaterialColor.WATER)).noCollider().nonSolid().replaceable().liquid().destroyOnPush().notSolidBlocking().build();

    public static final ForgeFlowingFluid.Properties ACID_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> ACID_FLUID.get(), () -> ACID_FLOWING.get(), FluidAttributes.builder(ACID_STILL_RL, ACID_FLOWING_RL)
            .density(20)
            .luminosity(2)
            .viscosity(5)
            .sound(SoundEvents.HONEY_DRINK)
            .overlay(ACID_OVERLAY_RL)
//            .color(0xA1E038FF)
    )
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.ACID_BLOCK.get()).bucket(() -> ModItems.ACID_BUCKET.get());

    public static final RegistryObject<LiquidBlock> ACID_BLOCK = ModBlocks.BLOCKS.register("acid",
            () -> new AcidFluidBlock(BlockBehaviour.Properties.of(BlockMaterials.ACID_MATERIAL).noCollission().strength(100f).noDrops()));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

//    private static final Map<FlowingFluid, Pair<Block, Block>> lavaInteractions = ofEntries(
//            entry(ACID_FLUID.get(), new Pair<>(Blocks.TUFF, Blocks.CRYING_OBSIDIAN))
//    );

//    private static final ArrayList<Tuple<FlowingFluid, Block, Block>> lavaInteractions = new ArrayList<>;

    @Nullable
    public static Pair<Block, Block> getLavaInteraction(FluidState fluidState) {
        var fluid = fluidState.getType();
        if (fluid.isSame(ACID_FLUID.get()))
            return new Pair<>(Blocks.CRYING_OBSIDIAN, Blocks.TUFF);
        return null;
    }
}