package com.dayton.nukacraft.common.items.custom;

import com.dayton.nukacraft.client.gui.ModMenuClass;
import com.dayton.nukacraft.client.gui.pipboy.PipBoyMenu;
import com.dayton.nukacraft.common.items.ModItemsClass;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import io.netty.buffer.Unpooled;

public class PipBoyItem extends Item {

    public PipBoyItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pPlayer instanceof ServerPlayer _ent && pPlayer.getOffhandItem().getItem() == ModItemsClass.PIP_BOY_D.get() && pPlayer.isShiftKeyDown()) {
            BlockPos _bpos = new BlockPos(0, 0, 0);

            NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return new TextComponent("Sadzsd");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    return new PipBoyMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                }
            }, _bpos);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
