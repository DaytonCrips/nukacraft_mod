package com.dayton.nukacraft.common.helpers.event;

import com.dayton.nukacraft.init.blocks.ModBlocksClass;
import com.dayton.nukacraft.init.blocks.custom.blocks.MutationFloraClass;
import com.dayton.nukacraft.init.gui.RadiationHudOverlay;
import com.dayton.nukacraft.init.items.ModItemsClass;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber
public class ModWorldEvents {

    @SubscribeEvent
    public static void onBlockRightClicked(final PlayerInteractEvent.RightClickBlock event) {
        Player playerEntity = event.getPlayer();
        BlockState state = event.getWorld().getBlockState(event.getPos());
        BlockPos blockPos = event.getPos();
        Level level = event.getWorld();
        if (playerEntity.getMainHandItem().getItem() == ModItemsClass.VIOPLEX.get() && state.getBlock().defaultBlockState().is(BlockTags.create(
                new ResourceLocation("nukacraft:mutable_plants")))) {
            MutationFloraClass.mutatePlants(state, blockPos, level);
            if (!playerEntity.isCreative()) {playerEntity.getMainHandItem().shrink(1);}
        }
        if (playerEntity.getMainHandItem().getItem() == ModItemsClass.NUCMAT.get()) {
            MutationFloraClass.mutatePlants(state, playerEntity, blockPos, level);
            if (!playerEntity.isCreative()) playerEntity.getMainHandItem().shrink(1);
        }
    }

}
