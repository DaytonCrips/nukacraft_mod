package com.dayton.nukacraft.common.foundation.items.custom.armor;

import com.dayton.nukacraft.common.foundation.entities.armors.WoodenArmorRenderer;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;

import java.util.function.Consumer;

public class WoodenArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private final String skin;

    public WoodenArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, String skin, Properties builder) {
        super(materialIn, slot, builder);
        this.skin = skin;
    }

    public String getSkin() {
        return skin;
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            private WoodenArmorRenderer renderer;

            @Override
            public  HumanoidModel<?> getArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (renderer == null)
                    renderer = new WoodenArmorRenderer();

                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }

//    @Nullable
//    @Override
//    public final String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
//        Class<? extends ArmorItem> clazz = this.getClass();
//        GeoArmorRenderer renderer = GeoArmorRenderer.getRenderer(clazz, entity);
//        return renderer.getTextureLocation((ArmorItem) stack.getItem()).toString();
//    }

//    @Override
//    public void createRenderer(Consumer<Object> consumer) {
//        consumer.accept(new RenderProvider() {
//            private YourItemRender renderer;
//
//            @Override
//            public HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
//                if (renderer == null)
//                    renderer = new YourItemRender();
//
//                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
//                return renderer;
//            }
//        });
//    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controllerName", 0, event ->
        {
            var stack = event.getData(DataTickets.ITEMSTACK);
            var s = stack;
            return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
        }
        ));
    }
}
