package com.nukateam.nukacraft.common.foundation.items.misc;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.nukateam.example.common.data.interfaces.IMeleeWeapon;
import com.nukateam.nukacraft.client.render.renderers.items.SimpleMeleeRenderer;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.client.IItemRenderProperties;

import java.util.function.Consumer;

public class SimpleMeleeWeapon extends SwordItem implements GeoItem, IMeleeWeapon {
    private final float attackDamage;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private String skin;

    public SimpleMeleeWeapon(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.attackDamage = (float) pAttackDamageModifier + pTier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double) this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double) pAttackSpeedModifier, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    public String getName() {
        String name = getRegistryName().toString().substring(10);
        return name;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            private SimpleMeleeRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                if (this.renderer == null) {
                    renderer = new SimpleMeleeRenderer();
                }
                return this.renderer;
            }
        });
    }

}
