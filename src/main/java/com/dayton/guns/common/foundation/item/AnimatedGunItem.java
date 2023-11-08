package com.dayton.guns.common.foundation.item;

import com.dayton.guns.client.handler.ReloadHandler;
import com.dayton.guns.common.base.Gun;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;

import static com.dayton.guns.common.foundation.item.GunItem.bannedTransforms;
import static com.dayton.nukacraft.common.data.constants.Animations.RELOAD;
import static com.dayton.nukacraft.common.data.constants.Animations.SHOT;
import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.core.animation.Animation.LoopType.LOOP;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;
import static mod.azure.azurelib.util.AzureLibUtil.createInstanceCache;

public class AnimatedGunItem extends GunItemBase {
    public AnimatedGunItem(ItemStack stack, ItemTransforms.TransformType transformType) {
        super(stack, transformType);
    }

    @Override
    public void registerControllers(ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, animate()));
    }

    private AnimationController.AnimationStateHandler<AnimatedGunItem> animate() {
        return event -> {

            try{
                var controller = event.getController();
                controller.setAnimationSpeed(1);
//                var stack = event.getData(DataTickets.ITEMSTACK);
//                var transformType = event.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);

                if (bannedTransforms.contains(transformType)) {
                    return PlayState.STOP;
                }

                var tracker = Minecraft.getInstance().player.getCooldowns();
                float cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
                float reloadProgress = ReloadHandler.get().getReloadProgress(Minecraft.getInstance().getFrameTime());

                RawAnimation animation;

                if(reloadProgress > 0){
                    animation = begin().then(RELOAD, LOOP);
                }
                else if(Gun.hasAmmo(stack) && cooldown > 0) {
                    animation = begin().then(SHOT, LOOP);
                }
                else{
                    return PlayState.STOP;
                }

                if (controller.hasAnimationFinished())
                    controller.forceAnimationReset();

                return event.setAndContinue(animation);
            }
            catch (Exception e){
                return PlayState.STOP;
            }
        };
    }
}
