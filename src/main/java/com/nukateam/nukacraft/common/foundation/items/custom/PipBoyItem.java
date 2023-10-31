package com.nukateam.nukacraft.common.foundation.items.custom;

import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoy;
import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoyMenu;
import com.nukateam.nukacraft.common.foundation.entities.PipBoyRenderer;
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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class PipBoyItem extends Item implements GeoItem {
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private String skin;
    public PipBoyItem(String skin, Properties pProperties) {
        super(pProperties);
        this.skin = skin;
    }

    public String getSkin() {
        return skin;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        if ((stack.getOrCreateTag().getString("screen")).equals("")) {
            stack.getOrCreateTag().putString("screen", "green");
        }
        if (player instanceof ServerPlayer serverPlayer
                && player.getOffhandItem().getItem() instanceof PipBoyItem
                && player.isShiftKeyDown()) {

            var blockPos = new BlockPos(0, 0, 0);
            PipBoy.start(stack, skin);
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
        return super.use(level, player, usedHand);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        if (item.getOrCreateTag().getString("screen").equals("")) {
            list.add(new TranslatableComponent("pipboy.nukacraft.screencolor").append(new TranslatableComponent("color.display.green")));
        } else {
            list.add(new TranslatableComponent("pipboy.nukacraft.screencolor").append(new TranslatableComponent("color.display." + item.getOrCreateTag().getString("screen"))));
        }
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
