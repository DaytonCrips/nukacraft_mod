package com.dayton.guns.common.foundation.item;

import com.dayton.guns.GunMod;
import com.dayton.guns.client.GunItemStackRenderer;
import com.dayton.guns.common.base.Gun;
import com.dayton.guns.common.base.NetworkGunManager;
import com.dayton.guns.common.data.util.GunEnchantmentHelper;
import com.dayton.guns.common.data.util.GunModifierHelper;
import com.dayton.guns.common.debug.Debug;
import com.dayton.guns.common.foundation.enchantment.EnchantmentTypes;
import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.client.render.renderers.GunRenderer;
import com.dayton.nukacraft.common.data.interfaces.INameable;
import com.jetug.chassis_core.client.render.utils.ResourceHelper;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.AnimationController.AnimationStateHandler;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.KeybindComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Consumer;

import static com.dayton.nukacraft.client.ClientConfig.*;
import static com.jetug.chassis_core.common.util.extensions.Collection.arrayListOf;
import static java.util.Objects.requireNonNull;
import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.core.animation.Animation.LoopType.LOOP;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;
import static mod.azure.azurelib.util.AzureLibUtil.*;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.*;

public class StaticGunItem implements INameable, GeoEntity {
    private final AnimatableInstanceCache cache = createInstanceCache(this);
    private final String name;

    public StaticGunItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNamespace() {
        return NukaCraftMod.MOD_ID;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, animate()));
    }

    private AnimationStateHandler<StaticGunItem> animate() {
        return event -> PlayState.STOP;
    }
}
