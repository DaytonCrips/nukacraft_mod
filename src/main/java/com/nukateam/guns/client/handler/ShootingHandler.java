package com.nukateam.guns.client.handler;

import com.nukateam.guns.common.base.GripType;
import com.nukateam.guns.common.base.Gun;
import com.nukateam.guns.common.data.interfaces.CurrentFpsGetter;
import com.nukateam.guns.common.event.GunFireEvent;
import com.nukateam.guns.common.foundation.item.GunItem;
import com.nukateam.guns.common.helpers.PlayerReviveHelper;
import com.nukateam.guns.common.network.PacketHandler;
import com.nukateam.guns.common.network.message.*;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.HashMap;

import static net.minecraftforge.event.TickEvent.Type.RENDER;

/**
 * Author: MrCrayfish
 */
public class ShootingHandler {
    public static final String COOLDOWN = "Cooldown";
    private static ShootingHandler instance;
    public HashMap<LivingEntity, Float> entityShootGaps = new HashMap<>();
    private static float shootTickGapLeft = 0F;
    public static float shootMsGap = 0F;

    public static ShootingHandler get() {
        if (instance == null) {
            instance = new ShootingHandler();
        }
        return instance;
    }

    private boolean shooting;

    public boolean isShooting() {
        return shooting;
    }

    private ShootingHandler() {
    }

    private boolean isInGame() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.getOverlay() != null)
            return false;
        if (mc.screen != null)
            return false;
        if (!mc.mouseHandler.isMouseGrabbed())
            return false;
        return mc.isWindowActive();
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onMouseClick(InputEvent.ClickInputEvent event) {
        if (event.isCanceled())
            return;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null)
            return;

        if (PlayerReviveHelper.isBleeding(player))
            return;

        if (event.isAttack()) {
            ItemStack heldItem = player.getMainHandItem();
            if (heldItem.getItem() instanceof GunItem gunItem) {
                event.setSwingHand(false);
                event.setCanceled(true);
                this.fire(player, heldItem);
                Gun gun = gunItem.getModifiedGun(heldItem);
                if (!gun.getGeneral().isAuto()) {
                    mc.options.keyAttack.setDown(false);
                }
            }
        } else if (event.isUseItem()) {
            ItemStack heldItem = player.getMainHandItem();
            if (heldItem.getItem() instanceof GunItem gunItem) {
                if (event.getHand() == InteractionHand.OFF_HAND) {
                    // Allow shields to be used if weapon is one-handed
                    if (player.getOffhandItem().getItem() == Items.SHIELD) {
                        Gun modifiedGun = gunItem.getModifiedGun(heldItem);
                        if (modifiedGun.getGeneral().getGripType() == GripType.ONE_HANDED) {
                            return;
                        }
                    }
                    event.setCanceled(true);
                    event.setSwingHand(false);
                    return;
                }
                if (AimingHandler.get().isZooming() && AimingHandler.get().isLookingAtInteractableBlock()) {
                    event.setCanceled(true);
                    event.setSwingHand(false);
                }
            }
        }
    }

//    @SubscribeEvent
//    public void onHandleShooting(TickEvent.ClientTickEvent event) {
//        if (event.phase != TickEvent.Phase.START)
//            return;
//
//        if (!this.isInGame())
//            return;
//
//        Minecraft mc = Minecraft.getInstance();
//        Player player = mc.player;
//        if (player != null) {
//            ItemStack heldItem = player.getMainHandItem();
//            if (heldItem.getItem() instanceof GunItem && (Gun.hasAmmo(heldItem) || player.isCreative()) && !PlayerReviveHelper.isBleeding(player)) {
//                boolean shooting = mc.options.keyAttack.isDown();
//                if (GunMod.controllableLoaded) {
//                    shooting |= ControllerHandler.isShooting();
//                }
//                if (shooting) {
//                    if (!this.shooting) {
//                        this.shooting = true;
//                        PacketHandler.getPlayChannel().sendToServer(new MessageShooting(true));
//                    }
//                } else if (this.shooting) {
//                    this.shooting = false;
//                    PacketHandler.getPlayChannel().sendToServer(new MessageShooting(false));
//                }
//            } else if (this.shooting) {
//                this.shooting = false;
//                PacketHandler.getPlayChannel().sendToServer(new MessageShooting(false));
//            }
//        } else {
//            this.shooting = false;
//        }
//    }

    @SubscribeEvent
    public void onHandleShooting(TickEvent.ClientTickEvent evt) {
        if (evt.phase != TickEvent.Phase.START)
            return;

        if (!this.isInGame())
            return;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player != null) {
            // CHECK HERE: Reduce by 1F in each tick until it is less than 0F
//            shootTickGapLeft -= shootTickGapLeft > 0F ? 1F : 0F;
            reduceGaps();

            ItemStack heldItem = player.getMainHandItem();
            if (heldItem.getItem() instanceof GunItem && (Gun.hasAmmo(heldItem) || player.isCreative())) {
//                final float dist = Math.abs(player.zza) / 2.5F
//                        + Math.abs(player.xxa) / 1.25F
//                        + (player.getDeltaMovement().y > 0D ? 0.5F : 0F);
//                PacketHandler.getPlayChannel().sendToServer(new MessageUpdateMoveInacc(dist));

                // Update #shooting state if it has changed
//                final boolean shooting = Keys.PULL_TRIGGER.isDown() && GunRenderingHandler.get().sprintTransition == 0;
                boolean shooting = mc.options.keyAttack.isDown();
                if (shooting ^ this.shooting) {
                    this.shooting = shooting;
                    PacketHandler.getPlayChannel().sendToServer(new MessageShooting(shooting));
                }
            } else if (this.shooting) {
                this.shooting = false;
                PacketHandler.getPlayChannel().sendToServer(new MessageShooting(false));
            }
        } else {
            this.shooting = false;
        }
    }

    private void reduceGaps(){
        entityShootGaps.forEach( (key, val) -> {
            val -= val > 0F ? 1F : 0F;
            entityShootGaps.put(key, val);
        } );
    }

    @SubscribeEvent
    public void onPostClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END)
            return;

        if (!isInGame())
            return;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player != null) {
            if (PlayerReviveHelper.isBleeding(player))
                return;

            ItemStack heldItem = player.getMainHandItem();
            if (heldItem.getItem() instanceof GunItem) {
                if (mc.options.keyAttack.isDown()) {
                    Gun gun = ((GunItem) heldItem.getItem()).getModifiedGun(heldItem);
                    if (gun.getGeneral().isAuto()) {
                        this.fire(player, heldItem);
                    }
                }
            }
        }
    }

//    public static HashMap<ItemStack, Integer> gunCooldown = new HashMap<>();
    public static ArrayList<ItemStack> gunCooldown = new ArrayList<>();

    public static int getCooldown(ItemStack itemStack) {
        var tag =  itemStack.getOrCreateTag();
        return tag.getInt(COOLDOWN);
    }

//    public void fire(Player player, ItemStack heldItem) {
//        if (!(heldItem.getItem() instanceof GunItem) || player.isSpectator()) return;
//        if (!Gun.hasAmmo(heldItem) && !player.isCreative()) return;
//        if (player.getUseItem().getItem() == Items.SHIELD) return;
//
//        var tracker = player.getCooldowns();
////        var cooldown = gunCooldown.get(heldItem);
//        var tag =  heldItem.getOrCreateTag();
//
////        if(!gunCooldown.contains(heldItem))
////            gunCooldown.add(heldItem);
//
//        if (tag.getInt(COOLDOWN) == 0) {
//            var gunItem = (GunItem) heldItem.getItem();
//            var modifiedGun = gunItem.getModifiedGun(heldItem);
//
//            if (MinecraftForge.EVENT_BUS.post(new GunFireEvent.Pre(player, heldItem)))
//                return;
//
////            int rate = GunEnchantmentHelper.getRate(heldItem, modifiedGun);
////            rate = GunModifierHelper.getModifiedRate(heldItem, rate);
////            tag.putInt(COOLDOWN, rate);
//
//            PacketHandler.getPlayChannel().sendToServer(new MessageShoot(player));
//            MinecraftForge.EVENT_BUS.post(new GunFireEvent.Post(player, heldItem));
//        }
//    }

    private static float visualCooldownMultiplier() {
        int fps = ((CurrentFpsGetter) Minecraft.getInstance()).getCurrentFps();
        if (fps < 11)
            return 8f;
        else if (fps < 21)
            return 6.25f;
        else if (fps < 31)
            return 1.25f;
        else if (fps < 61)
            return 0.95f;
        else if (fps < 121)
            return 0.625f;
        else if (fps < 181)
            return 0.425f;
        else if (fps < 201)
            return 0.35f;
        else
            return 0.25f;
    }


    @SubscribeEvent(priority = EventPriority.LOW)
    public void renderTickLow(TickEvent.RenderTickEvent evt) {
        if (!evt.type.equals(RENDER) || evt.phase.equals(TickEvent.Phase.START))
            return;
        
        if (shootMsGap > 0F) {
            shootMsGap -= evt.renderTickTime * visualCooldownMultiplier();
        } else if (shootMsGap < -0.05F)
            shootMsGap = 0F;
    }

//    @SubscribeEvent(priority = EventPriority.HIGHEST)
//    public void renderTick(TickEvent.RenderTickEvent evt) {
//        // Upper is to handle rendering, bellow is handling animation calls and burst tracking
//
//        if (Minecraft.getInstance().player == null || !Minecraft.getInstance().player.isAlive() || Minecraft.getInstance().player.getMainHandItem().getItem() instanceof GunItem)
//            return;
//        GunAnimationController controller = GunAnimationController.fromItem(Minecraft.getInstance().player.getMainHandItem().getItem());
//        if (controller == null)
//            return;
//        else if (controller.isAnimationRunning() && (shootMsGap < 0F && this.burstTracker != 0)) {
//            if (controller.isAnimationRunning(GunAnimationController.AnimationLabel.PUMP) || controller.isAnimationRunning(GunAnimationController.AnimationLabel.PULL_BOLT))
//                return;
//            if (Config.CLIENT.controls.burstPress.get())
//                this.burstTracker = 0;
//            this.clickUp = true;
//        }
//    }

//    public int burstTracker = 0;

    public float getShootTickGapLeft(LivingEntity entity) {
        return entityShootGaps.getOrDefault(entity, 0f);
    }

    public static float calcShootTickGap(int rpm) {
        float shootTickGap = 60F / rpm * 20F;
        return shootTickGap;
    }


    public void fire(LivingEntity shooter, ItemStack heldItem) {
        if (!(heldItem.getItem() instanceof GunItem)) return;
        if (!Gun.hasAmmo(heldItem)) return;
        if (!Gun.hasAmmo(heldItem) && shooter instanceof Player player && !player.isCreative()) return;
        if (shooter.isSpectator()) return;

        // CHECK HERE: Restrict the fire rate
//      if(!tracker.hasCooldown(heldItem.getItem()))

        var shootGap = entityShootGaps.getOrDefault(shooter, 0f);

        if (shootGap <= 0F) {
            var gunItem = (GunItem) heldItem.getItem();
            var modifiedGun = gunItem.getModifiedGun(heldItem);

            if (MinecraftForge.EVENT_BUS.post(new GunFireEvent.Pre(shooter, heldItem)))
                return;

            // CHECK HERE: Change this to test different rpm settings.
            // TODO: Test serverside, possible issues 0.3.4-alpha
            final float rpm = modifiedGun.getGeneral().getRate(); // Rounds per sec. Should come from gun properties in the end.
            shootGap += rpm;
            entityShootGaps.put(shooter, shootGap);
            shootMsGap = calcShootTickGap((int) rpm);
            RecoilHandler.get().lastRandPitch = RecoilHandler.get().lastRandPitch;
            RecoilHandler.get().lastRandYaw = RecoilHandler.get().lastRandYaw;
            PacketHandler.getPlayChannel().sendToServer(new MessageShoot(shooter.getId(), shooter.getViewYRot(1),
                            shooter.getViewXRot(1),
                            RecoilHandler.get().lastRandPitch, RecoilHandler.get().lastRandYaw));

//            if (Config.CLIENT.controls.burstPress.get()) this.burstTracker--;
//            else this.burstTracker++;
            MinecraftForge.EVENT_BUS.post(new GunFireEvent.Post(shooter, heldItem));
        }
    }

//    private boolean magError(Player player, ItemStack heldItem) {
//        int[] extraAmmo = ((GunItem) heldItem.getItem()).getGun().getReloads().getMaxAdditionalAmmoPerOC();
//        int magMode = GunModifierHelper.getAmmoCapacity(heldItem);
//        if (magMode < 0) {
//            if (heldItem.getItem() instanceof GunItem && heldItem.getTag().getInt("AmmoCount") - 1 > ((GunItem) heldItem.getItem()).getGun().getReloads().getMaxAmmo()) {
//                return true;
//            }
//        } else {
//            if (heldItem.getItem() instanceof GunItem && heldItem.getTag().getInt("AmmoCount") - 1 > ((GunItem) heldItem.getItem()).getGun().getReloads().getMaxAmmo() + extraAmmo[magMode]) {
//                return true;
//            }
//        }
//        return false;
//    }
}
