package com.nukateam.nukacraft.common.foundation.items.armor;

import com.nukateam.example.common.data.interfaces.IResourceProvider;
import com.nukateam.example.common.data.utils.ResourceUtils;
import com.nukateam.nukacraft.client.render.renderers.armor.ArmorRenderer;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

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

    private ResourceLocation getRegistryName(){
        return ForgeRegistries.ITEMS.getKey(this);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private ArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (renderer == null)
                    return new ArmorRenderer();
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
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
