package com.nukateam.nukacraft.common.foundation.items.misc;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.item.AtlasItem;
import com.nukateam.nukacraft.common.data.utils.PipBoyUtils;
import com.nukateam.nukacraft.common.foundation.container.PipBoyMenu;
import com.nukateam.nukacraft.client.render.renderers.items.PipBoyRenderer;
import io.netty.buffer.Unpooled;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class PipBoyItem extends AtlasItem implements GeoItem {
    public static final String ATLAS_ID = "atlasID";
    public static final String SCREEN = "screen";

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private final String skin;

    public PipBoyItem(String skin, Properties pProperties) {
        super(pProperties);
        this.skin = skin;
    }

    public String getSkin() {
        return skin;
    }

    public static ResourceLocation getPipboyFrame(PipBoyItem pipBoyItem){
        return new ResourceLocation("nukacraft:textures/screens/" + pipBoyItem.skin + "_pipboy.png");
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        var stack = player.getItemInHand(usedHand);
        var stackTag = stack.getOrCreateTag();

        if(!level.isClientSide && !stackTag.contains(ATLAS_ID)) {
            var atlasID = MapCore.getGlobalAtlasData(level).getNextAtlasId();
            stackTag.putInt(ATLAS_ID, atlasID);

            var atlasData = MapCore.tileData.getData(atlasID, level);
            atlasData.getWorldData(player.getCommandSenderWorld().dimension()).setBrowsingPositionTo(player);
            atlasData.setDirty();

            var markersData = MapCore.markersData.getMarkersData(atlasID, level);
            markersData.setDirty();
        }
        if ((stackTag.getString(SCREEN)).equals("")) {
            stackTag.putString(SCREEN, "green");
        }

        if (player instanceof ServerPlayer serverPlayer
                && player.getOffhandItem().getItem() instanceof PipBoyItem
                && player.isShiftKeyDown()) {
            openPipboyScreen(serverPlayer);
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }

    public static void openPipboyScreen(ServerPlayer player) {
        if(!PipBoyUtils.hasPipboy(player)) return;
//        PipBoyUtils.start(SlotUtils.getPipboyStack(player), getPipboy(player).getSkin(), player);
        PipBoyItem.openPipboyScreen(player, new BlockPos(0, 0, 0));
    }

    public static void openPipboyScreen(ServerPlayer serverPlayer, BlockPos blockPos) {
        NetworkHooks.openGui(serverPlayer, new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return new TextComponent("Sadzxc");
            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                return new PipBoyMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(blockPos));
            }
        }, blockPos);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
//        if (item.getOrCreateTag().getString(COLOR).equals("")) {
//            list.add(new TranslatableComponent("pipboy.nukacraft.screencolor").append(new TranslatableComponent("color.display.green")));
//        } else {
//            list.add(new TranslatableComponent("pipboy.nukacraft.screencolor").append(new TranslatableComponent("color.display." + item.getOrCreateTag().getString(COLOR))));
//        }
        list.add(new TranslatableComponent("pipboy.nukacraft.handselect"));
        list.add(new TranslatableComponent("pipboy.nukacraft.clicks"));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            private PipBoyRenderer renderer;
            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                if (this.renderer == null) {
                    renderer = new PipBoyRenderer();
                }
                return this.renderer;
            }
        });
    }
}
