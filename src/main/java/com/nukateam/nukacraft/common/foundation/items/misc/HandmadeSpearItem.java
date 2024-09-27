package com.nukateam.nukacraft.common.foundation.items.misc;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.nukateam.nukacraft.client.render.renderers.entity.HandmadeSpearRenderer;
import com.nukateam.nukacraft.client.render.renderers.items.PipBoyRenderer;
import com.nukateam.nukacraft.common.foundation.entities.misc.HandmadeSpearEntity;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class HandmadeSpearItem extends SwordItem implements Vanishable, GeoAnimatable, GeoItem {
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer((GeoItem) this);
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    EntityType<? extends HandmadeSpearEntity> type;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public HandmadeSpearItem(Tier tier, int p_43270_, float p_43271_, Item.Properties properties) {
        super(tier, p_43270_, p_43271_, properties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 2.0, Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -3.200000047683716, Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.SPEAR;
    }

    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack $$3 = pPlayer.getItemInHand(pHand);
        if ($$3.getDamageValue() >= $$3.getMaxDamage() - 1) {
            return InteractionResultHolder.fail($$3);
        } else if (EnchantmentHelper.getRiptide($$3) > 0 && !pPlayer.isInWaterOrRain()) {
            return InteractionResultHolder.fail($$3);
        } else {
            pPlayer.startUsingItem(pHand);
            return InteractionResultHolder.consume($$3);
        }
    }

    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player $$4) {
            int $$5 = this.getUseDuration(pStack) - pTimeLeft;
            if ($$5 >= 10) {
                int $$6 = EnchantmentHelper.getRiptide(pStack);
                if ($$6 <= 0 || $$4.isInWaterOrRain()) {
                    if (!pLevel.isClientSide) {
                        pStack.hurtAndBreak(1, $$4, (p_43388_) -> {
                            p_43388_.broadcastBreakEvent(pEntityLiving.getUsedItemHand());
                        });
                        if ($$6 == 0) {
                            HandmadeSpearEntity $$7 = new HandmadeSpearEntity(pLevel, $$4, pStack);
                            $$7.shootFromRotation($$4, $$4.getXRot(), $$4.getYRot(), 0.0F, 2.5F + (float)$$6 * 0.5F, 1.0F);
                            if ($$4.getAbilities().instabuild) {
                                $$7.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                            }

                            pLevel.addFreshEntity($$7);
                            pLevel.playSound((Player)null, $$7, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                            if (!$$4.getAbilities().instabuild) {
                                $$4.getInventory().removeItem(pStack);
                            }
                        }
                    }

                    $$4.awardStat(Stats.ITEM_USED.get(this));
                    if ($$6 > 0) {
                        float $$8 = $$4.getYRot();
                        float $$9 = $$4.getXRot();
                        float $$10 = -Mth.sin($$8 * 0.017453292F) * Mth.cos($$9 * 0.017453292F);
                        float $$11 = -Mth.sin($$9 * 0.017453292F);
                        float $$12 = Mth.cos($$8 * 0.017453292F) * Mth.cos($$9 * 0.017453292F);
                        float $$13 = Mth.sqrt($$10 * $$10 + $$11 * $$11 + $$12 * $$12);
                        float $$14 = 3.0F * ((1.0F + (float)$$6) / 4.0F);
                        $$10 *= $$14 / $$13;
                        $$11 *= $$14 / $$13;
                        $$12 *= $$14 / $$13;
                        $$4.push((double)$$10, (double)$$11, (double)$$12);
                        $$4.startAutoSpinAttack(20);
                        if ($$4.onGround()) {
                            float $$15 = 1.1999999F;
                            $$4.move(MoverType.SELF, new Vec3(0.0, 1.1999999284744263, 0.0));
                        }

                        SoundEvent $$18;
                        if ($$6 >= 3) {
                            $$18 = SoundEvents.TRIDENT_RIPTIDE_3;
                        } else if ($$6 == 2) {
                            $$18 = SoundEvents.TRIDENT_RIPTIDE_2;
                        } else {
                            $$18 = SoundEvents.TRIDENT_RIPTIDE_1;
                        }

                        pLevel.playSound((Player)null, $$4, $$18, SoundSource.PLAYERS, 1.0F, 1.0F);
                    }

                }
            }
        }
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object o) {
        return 0;
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private HandmadeSpearRenderer renderer = null;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    renderer = new HandmadeSpearRenderer();
                return this.renderer;
            }
        });
    }


    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }
}
