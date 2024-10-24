package com.nukateam.nukacraft.common.foundation.items.misc;

import com.nukateam.geo.interfaces.DynamicGeoItem;
import com.nukateam.geo.render.DynamicGeoItemRenderer;
import com.nukateam.ntgl.Ntgl;
import com.nukateam.ntgl.client.render.renderers.DefaultGunRendererGeo;
import com.nukateam.nukacraft.client.render.renderers.items.PipBoyRenderer;
import com.nukateam.nukacraft.common.data.utils.PipBoyUtils;
import com.nukateam.nukacraft.common.foundation.container.PipBoyMenu;
import io.netty.buffer.Unpooled;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PipBoyItem extends Item implements DynamicGeoItem {
    public static final String ATLAS_ID = "atlasID";
    public static final String SCREEN = "screen";
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private final String skin;
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    private final Lazy<PipBoyRenderer> RENDERER = Lazy.of(() -> new PipBoyRenderer());

    public PipBoyItem(String skin, Properties pProperties) {
        super(pProperties);
        this.skin = skin;
    }

    public static ResourceLocation getPipboyFrame(PipBoyItem pipBoyItem) {
        return new ResourceLocation("nukacraft:textures/screens/" + pipBoyItem.skin + "_pipboy.png");
    }

    @Override
    public DynamicGeoItemRenderer getRenderer() {
        return RENDERER.get();
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        var stack = player.getItemInHand(usedHand);
        var stackTag = stack.getOrCreateTag();

//        if (!level.isClientSide && !stackTag.contains(ATLAS_ID)) {
//            var atlasID = MapCore.getGlobalAtlasData(level).getNextAtlasId();
//            stackTag.putInt(ATLAS_ID, atlasID);
//
//            var atlasData = MapCore.tileData.getData(atlasID, level);
//            atlasData.getWorldData(player.getCommandSenderWorld().dimension()).setBrowsingPositionTo(player);
//            atlasData.setDirty();
//
//            var markersData = MapCore.markersData.getMarkersData(atlasID, level);
//            markersData.setDirty();
//        }
        if ((stackTag.getString(SCREEN)).equals("")) {
            stackTag.putString(SCREEN, "green");
        }

        if (player instanceof ServerPlayer serverPlayer
                && player.getOffhandItem().getItem() instanceof PipBoyItem
                && player.isShiftKeyDown()) {
            if(Ntgl.isDebugging())
                openPipboyScreen(serverPlayer);
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
//        if (item.getOrCreateTag().getString(COLOR).equals("")) {
//            list.add(Component.translatable("pipboy.nukacraft.screencolor").append(Component.translatable("color.display.green")));
//        } else {
//            list.add(Component.translatable("pipboy.nukacraft.screencolor").append(Component.translatable("color.display." + item.getOrCreateTag().getString(COLOR))));
//        }
        if(Ntgl.isDebugging()) {
            list.add(Component.translatable("pipboy.nukacraft.handselect"));
            list.add(Component.translatable("pipboy.nukacraft.clicks"));
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

//    @Override
//    public void createRenderer(Consumer<Object> consumer) {
//        consumer.accept(new RenderProvider() {
//            private PipBoyRenderer renderer = null;
//
//            @Override
//            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
//                if (renderer == null)
//                    renderer = new PipBoyRenderer();
//                return this.renderer;
//            }
//        });
//    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    public String getSkin() {
        return skin;
    }

    public static void openPipboyScreen(ServerPlayer player) {
        if (!PipBoyUtils.hasPipboy(player)) return;
//        PipBoyUtils.start(SlotUtils.getPipboyStack(player), getPipboy(player).getSkin(), player);
        if(Ntgl.isDebugging())
            PipBoyItem.openPipboyScreen(player, new BlockPos(0, 0, 0));
    }

    public static void openPipboyScreen(ServerPlayer serverPlayer, BlockPos blockPos) {
        NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return Component.literal("Sadzxc");
            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                return new PipBoyMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(blockPos));
            }
        }, blockPos);
    }
}
