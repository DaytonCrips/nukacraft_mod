package com.dayton.nukacraft.common.container.screen;

import com.dayton.nukacraft.common.container.menu.PowerChassisMenu;
import com.dayton.nukacraft.common.entities.PowerArmorFrame;
import com.dayton.nukacraft.common.network.PacketHandler;
import com.dayton.nukacraft.common.network.actions.FramePickupAction;
import com.dayton.nukacraft.common.network.packets.FramePickupPacket;
import com.google.common.collect.Lists;
import com.jetug.chassis_core.common.data.enums.ActionType;
import com.jetug.chassis_core.common.foundation.container.screen.ChassisScreen;
import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import com.jetug.chassis_core.common.network.PacketSender;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

import static com.dayton.nukacraft.common.data.utils.Resources.nukaResource;
import static com.dayton.nukacraft.common.items.PowerArmorItems.FRAME_ITEM;
import static com.jetug.chassis_core.Global.referenceMob;
import static com.jetug.chassis_core.common.foundation.EntityHelper.entityToItem;
import static com.jetug.chassis_core.common.network.PacketSender.doServerAction;
import static com.jetug.chassis_core.common.util.helpers.PlayerUtils.getLocalPlayer;

@OnlyIn(Dist.CLIENT)
public class PowerArmorScreen extends ChassisScreen<PowerChassisMenu> {
    public static final ResourceLocation POWER_ARMOR_GUI = nukaResource("textures/gui/power_armor_inventory.png");
    private final List<ScreenButton> beaconButtons = Lists.newArrayList();

    public PowerArmorScreen(PowerChassisMenu container, Inventory inventory, Component name) {
        super(container, inventory, name, POWER_ARMOR_GUI);
    }

    @Override
    protected void init() {
        super.init();
        this.addButton(new ConfirmButton(this.leftPos + 133, this.topPos + 49));
    }

    private <T extends ScreenButton> void addButton(T pBeaconButton) {
        this.addRenderableWidget(pBeaconButton);
        this.beaconButtons.add(pBeaconButton);
    }

    @Override
    protected void renderEntity(WearableChassis powerArmor) {
        float scale = 1.0F / Math.max(1.0E-4F, powerArmor.getScale());
        InventoryScreen.renderEntityInInventory(this.leftPos + 32, this.topPos + 73, (int)(scale * 23.0F),
                (float)(this.leftPos + 51) - this.mousePosX, (float)(this.topPos + 75 - 50) - this.mousePosY, powerArmor);
    }

    protected void renderLabels(PoseStack pPoseStack, int pX, int pY) {
        for(var button : this.beaconButtons) {
            if (button.isShowingTooltip()) {
                button.renderToolTip(pPoseStack, pX - this.leftPos, pY - this.topPos);
                break;
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    class ConfirmButton extends SpriteScreenButton {
        public ConfirmButton(int pX, int pY) {
            super(pX, pY, 88, 166, CommonComponents.GUI_DONE);
        }

        public void onPress() {
//            PacketSender.doServerAction(new FramePickupAction(), referenceMob.getId());
            PacketHandler.sendToServer(new FramePickupPacket(referenceMob.getId()));
//            doServerAction(ActionType.DISMOUNT);
//            var stack = new ItemStack(FRAME_ITEM.get());
//            var entity = (PowerArmorFrame)referenceMob;
//            entityToItem(stack, entity);
//            getLocalPlayer().getInventory().add(stack);
        }
    }

    @OnlyIn(Dist.CLIENT)
    abstract class SpriteScreenButton extends ScreenButton {
        private final int iconX;
        private final int iconY;

        protected SpriteScreenButton(int pX, int pY, int pIconX, int pIconY, Component pMessage) {
            super(pX, pY, pMessage);
            this.iconX = pIconX;
            this.iconY = pIconY;
        }

        protected void renderIcon(PoseStack pPoseStack) {
            this.blit(pPoseStack, this.x + 2, this.y + 2, this.iconX, this.iconY, 18, 18);
        }

        public void renderToolTip(PoseStack pPoseStack, int pMouseX, int pMouseY) {

        }
    }

    @SuppressWarnings("PointlessArithmeticExpression")
    @OnlyIn(Dist.CLIENT)
    abstract static class ScreenButton extends AbstractButton {

        private boolean selected;

        protected ScreenButton(int pX, int pY) {
            super(pX, pY, 22, 22, TextComponent.EMPTY);
        }

        protected ScreenButton(int pX, int pY, Component pMessage) {
            super(pX, pY, 22, 22, pMessage);
        }

        public void renderButton(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, POWER_ARMOR_GUI);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            int j = 0;
            if (!this.active) {
                j += this.width * 2;
            } else if (this.selected) {
                j += this.width * 1;
            } else if (this.isHoveredOrFocused()) {
                j += this.width * 3;
            }

            this.blit(pPoseStack, this.x, this.y, j, 219, this.width, this.height);
            this.renderIcon(pPoseStack);
        }

        protected abstract void renderIcon(PoseStack pPoseStack);

        public boolean isSelected() {
            return this.selected;
        }

        public void setSelected(boolean pSelected) {
            this.selected = pSelected;
        }

        public boolean isShowingTooltip() {
            return this.isHovered;
        }
        public void updateNarration(NarrationElementOutput pNarrationElementOutput) {
            this.defaultButtonNarrationText(pNarrationElementOutput);
        }
    }
}