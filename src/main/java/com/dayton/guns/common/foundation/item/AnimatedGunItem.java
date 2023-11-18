package com.dayton.guns.common.foundation.item;

import com.dayton.guns.client.handler.ReloadHandler;
import com.dayton.guns.client.handler.ShootingHandler;
import com.dayton.guns.common.base.Gun;
import com.dayton.nukacraft.common.data.interfaces.IResourceProvider;
import com.dayton.nukacraft.common.foundation.entities.PowerArmorFrame;
import com.jetug.chassis_core.common.data.json.ItemConfig;
import com.jetug.chassis_core.common.foundation.item.IConfigProvider;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.Lazy;

import javax.annotation.Nullable;
import java.util.List;

import static com.dayton.guns.client.handler.ShootingHandler.*;
import static com.dayton.guns.client.render.renderers.GunRenderer.*;
import static com.dayton.guns.common.foundation.item.GunItem.*;
import static com.dayton.nukacraft.client.ClientConfig.*;
import static com.dayton.nukacraft.common.data.constants.Animations.*;
import static com.jetug.chassis_core.client.ClientConfig.*;
import static mod.azure.azurelib.core.animation.AnimatableManager.*;
import static mod.azure.azurelib.core.animation.Animation.LoopType.*;
import static mod.azure.azurelib.core.animation.RawAnimation.*;

public class AnimatedGunItem extends GunItemBase implements IResourceProvider, IConfigProvider {
    protected final ItemTransforms.TransformType transformType;
    private final Lazy<ItemConfig> config = Lazy.of(() -> modResourceManager.getItemConfig(getName()));

    public AnimatedGunItem(ItemTransforms.TransformType transformType) {
        this.transformType = transformType;
    }

    @Override
    public void registerControllers(ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, animate()));
    }

    @Override
    public String getName() {
        return ((IResourceProvider)renderStack.getItem()).getName();
    }

    @Override
    public String getNamespace() {
        return ((IResourceProvider)renderStack.getItem()).getNamespace();
    }

    @Override
    @Nullable
    public ItemConfig getConfig() {
        return config.get();
    }

    private AnimationController.AnimationStateHandler<AnimatedGunItem> animate() {
        return event -> {
            try{
                var controller = event.getController();
                controller.setAnimationSpeed(1);
//                var stack = event.getData(DataTickets.ITEMSTACK);
//                var transformType = event.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
                var player = Minecraft.getInstance().player;
//                var playerHasNotStack = !player.getInventory().items.contains(stack);

//                var stack = event.getData(DataTickets.ITEMSTACK);
//                var transformType = event.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);

                var stack = renderStack;

                var entity = entityForStack.get(stack);
                if(entity == null) entity = player;

                if (bannedTransforms.contains(transformType) || (entity != player && !(entity instanceof PowerArmorFrame))) {
                    return PlayState.STOP;
                }

                float cooldown = ShootingHandler.getShootTickGapLeft(); // getCooldown(stack);//tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
                float reloadProgress = ReloadHandler.get().getReloadProgress(Minecraft.getInstance().getFrameTime());

                RawAnimation animation;

//                if(reloadProgress > 0){
//                    animation = begin().then(RELOAD, LOOP);
//                }
////                Gun.hasAmmo(stack) &&
//                else
                if(cooldown > 0) {
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
