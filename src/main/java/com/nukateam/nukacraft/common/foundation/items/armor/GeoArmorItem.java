package com.nukateam.nukacraft.common.foundation.items.armor;

import com.nukateam.nukacraft.client.render.renderers.armor.ArmorRenderer;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;

import java.util.function.Consumer;

import com.nukateam.example.common.data.interfaces.IResourceProvider;


public class GeoArmorItem extends ArmorItem implements GeoItem, IResourceProvider {
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private final String name;

    public GeoArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, String skin, Properties builder) {
        super(materialIn, slot, builder);
        this.name = skin;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNamespace() {
        return getRegistryName().getNamespace();
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            private ArmorRenderer renderer;

            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (renderer == null)
                    renderer = new ArmorRenderer();

                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}

}
