package com.dayton.nukacraft.common.items.custom;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.client.gui.pipboy.PipBoy;
import com.dayton.nukacraft.client.gui.pipboy.PipBoyMenu;
import com.dayton.nukacraft.common.items.ModItemsClass;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import io.netty.buffer.Unpooled;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PipBoyItem extends Item {
    private String skin;
    public PipBoyItem(String skin, Properties pProperties) {
        super(pProperties);
        this.skin = skin;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if ((stack.getOrCreateTag().getString("screen")).equals("")) {
            stack.getOrCreateTag().putString("screen", "green");}
        if (pPlayer instanceof ServerPlayer _ent && pPlayer.getOffhandItem().getItem() instanceof PipBoyItem && pPlayer.isShiftKeyDown()) {
            BlockPos _bpos = new BlockPos(0, 0, 0);
            PipBoy.start(stack, skin);
            NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return new TextComponent("Sadzxc");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    return new PipBoyMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                }
            }, _bpos);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
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
}
