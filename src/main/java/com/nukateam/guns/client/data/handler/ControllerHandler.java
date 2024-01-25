package com.nukateam.guns.client.data.handler;

import com.nukateam.guns.Config;
import com.nukateam.guns.client.input.GunButtonBindings;
import com.nukateam.guns.client.screen.WorkbenchScreen;
import com.nukateam.guns.common.base.gun.Gun;
import com.nukateam.guns.common.data.util.GunEnchantmentHelper;
import com.nukateam.guns.common.foundation.init.ModSyncedDataKeys;
import com.nukateam.guns.common.foundation.item.GunItem;
import com.nukateam.guns.common.foundation.item.attachment.impl.Scope;
import com.nukateam.guns.common.network.PacketHandler;
import com.nukateam.guns.common.network.message.C2SMessageAttachments;
import com.nukateam.guns.common.network.message.C2SMessageUnload;
import com.mrcrayfish.controllable.Controllable;
import com.mrcrayfish.controllable.client.Action;
import com.mrcrayfish.controllable.client.Controller;
import com.mrcrayfish.controllable.client.gui.navigation.BasicNavigationPoint;
import com.mrcrayfish.controllable.event.ControllerEvent;
import com.mrcrayfish.controllable.event.GatherActionsEvent;
import com.mrcrayfish.controllable.event.GatherNavigationPointsEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Author: MrCrayfish
 */
public class ControllerHandler {
    private int reloadCounter = -1;

    @SubscribeEvent
    public void onButtonInput(ControllerEvent.ButtonInput event) {
        Player player = Minecraft.getInstance().player;
        Level world = Minecraft.getInstance().level;
        if (player != null && world != null && Minecraft.getInstance().screen == null) {
            ItemStack heldItem = player.getMainHandItem();
            int button = event.getButton();
            if (button == GunButtonBindings.SHOOT.getButton()) {
                if (heldItem.getItem() instanceof GunItem) {
                    event.setCanceled(true);
                    if (event.getState()) {
                        ShootingHandler.get().fire(player, heldItem);
                    }
                }
            } else if (button == GunButtonBindings.AIM.getButton()) {
                if (heldItem.getItem() instanceof GunItem) {
                    event.setCanceled(true);
                }
            } else if (button == GunButtonBindings.STEADY_AIM.getButton()) {
                if (heldItem.getItem() instanceof GunItem) {
                    event.setCanceled(true);
                }
            } else if (button == GunButtonBindings.RELOAD.getButton()) {
                if (heldItem.getItem() instanceof GunItem) {
                    event.setCanceled(true);
                    if (event.getState()) {
                        this.reloadCounter = 0;
                    }
                }
            } else if (button == GunButtonBindings.OPEN_ATTACHMENTS.getButton()) {
                if (heldItem.getItem() instanceof GunItem && Minecraft.getInstance().screen == null) {
                    event.setCanceled(true);
                    if (event.getState()) {
                        PacketHandler.getPlayChannel().sendToServer(new C2SMessageAttachments());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onControllerTurn(ControllerEvent.Turn event) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            ItemStack heldItem = player.getMainHandItem();
            if (heldItem.getItem() instanceof GunItem && AimingHandler.get().isAiming()) {
                double adsSensitivity = Config.CLIENT.controls.aimDownSightSensitivity.get();
                event.setYawSpeed(10.0F * (float) adsSensitivity);
                event.setPitchSpeed(7.5F * (float) adsSensitivity);

                Scope scope = Gun.getScope(heldItem);
                if (scope != null && scope.isStable() && Controllable.isButtonPressed(GunButtonBindings.STEADY_AIM.getButton())) {
                    event.setYawSpeed(event.getYawSpeed() / 2.0F);
                    event.setPitchSpeed(event.getPitchSpeed() / 2.0F);
                }
            }
        }
    }

    @SubscribeEvent
    public void updateAvailableActions(GatherActionsEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen != null) return;

        Player player = Minecraft.getInstance().player;
        if (player != null) {
            ItemStack heldItem = player.getMainHandItem();
            if (heldItem.getItem() instanceof GunItem) {
                event.getActions().put(GunButtonBindings.AIM, new Action(new TranslatableComponent("nukacraft.action.aim"), Action.Side.RIGHT));
                event.getActions().put(GunButtonBindings.SHOOT, new Action(new TranslatableComponent("nukacraft.action.shoot"), Action.Side.RIGHT));

                GunItem gunItem = (GunItem) heldItem.getItem();
                Gun modifiedGun = gunItem.getModifiedGun(heldItem);
                CompoundTag tag = heldItem.getTag();
                if (tag != null && tag.getInt("AmmoCount") < GunEnchantmentHelper.getAmmoCapacity(heldItem, modifiedGun)) {
                    event.getActions().put(GunButtonBindings.RELOAD, new Action(new TranslatableComponent("nukacraft.action.reload"), Action.Side.LEFT));
                }

                Scope scope = Gun.getScope(heldItem);
                if (scope != null && scope.isStable() && AimingHandler.get().isAiming()) {
                    event.getActions().put(GunButtonBindings.STEADY_AIM, new Action(new TranslatableComponent("nukacraft.action.steady_aim"), Action.Side.RIGHT));
                }
            }
        }
    }

    @SubscribeEvent
    public void onRender(TickEvent.RenderTickEvent event) {
        Controller controller = Controllable.getController();
        if (controller == null)
            return;

        if (event.phase == TickEvent.Phase.END)
            return;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null)
            return;

        if (Controllable.isButtonPressed(GunButtonBindings.SHOOT.getButton()) && Minecraft.getInstance().screen == null) {
            ItemStack heldItem = player.getMainHandItem();
            if (heldItem.getItem() instanceof GunItem) {
                Gun gun = ((GunItem) heldItem.getItem()).getModifiedGun(heldItem);
                if (gun.getGeneral().isAuto()) {
                    ShootingHandler.get().fire(player, heldItem);
                }
            }
        }

        if (mc.screen == null && this.reloadCounter != -1) {
            if (Controllable.isButtonPressed(GunButtonBindings.RELOAD.getButton())) {
                this.reloadCounter++;
            }
        }

        if (this.reloadCounter > 40) {
            ReloadHandler.get().setReloading(false);
            PacketHandler.getPlayChannel().sendToServer(new C2SMessageUnload());
            this.reloadCounter = -1;
        } else if (this.reloadCounter > 0 && !Controllable.isButtonPressed(GunButtonBindings.RELOAD.getButton())) {
            ReloadHandler.get().setReloading(!ModSyncedDataKeys.RELOADING.getValue(player));
            this.reloadCounter = -1;
        }
    }

    public static boolean isAiming() {
        Controller controller = Controllable.getController();
        return controller != null && Controllable.isButtonPressed(GunButtonBindings.AIM.getButton());
    }

    public static boolean isShooting() {
        Controller controller = Controllable.getController();
        return controller != null && Controllable.isButtonPressed(GunButtonBindings.SHOOT.getButton());
    }

    @SubscribeEvent
    public void onGatherNavigationPoints(GatherNavigationPointsEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen instanceof WorkbenchScreen) {
            WorkbenchScreen workbench = (WorkbenchScreen) mc.screen;
            int startX = workbench.getGuiLeft();
            int startY = workbench.getGuiTop();

            for (int i = 0; i < workbench.getTabs().size(); i++) {
                int tabX = startX + 28 * i + (28 / 2);
                int tabY = startY - (28 / 2);
                event.addPoint(new BasicNavigationPoint(tabX, tabY));
            }

            for (int i = 0; i < 6; i++) {
                int itemX = startX + 172 + (80 / 2);
                int itemY = startY + i * 19 + 63 + (19 / 2);
                event.addPoint(new BasicNavigationPoint(itemX, itemY));
            }
        }
    }
}
