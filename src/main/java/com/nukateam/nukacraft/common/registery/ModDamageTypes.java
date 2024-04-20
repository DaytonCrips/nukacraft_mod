package com.nukateam.nukacraft.common.registery;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

/**
 * Author: MrCrayfish
 */
public class ModDamageTypes {
    public static final ResourceKey<DamageType> ULTRACITE_STEP =
            ResourceKey.create(Registries.DAMAGE_TYPE, nukaResource("ultracite_step"));

    public static class Sources {
        private static Holder.Reference<DamageType> getHolder(RegistryAccess access, ResourceKey<DamageType> damageTypeKey) {
            return access.registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(damageTypeKey);
        }

        public static class UltraciteDamageSource extends DamageSource {
            private static final String[] msgSuffix = {
                    "nukacraft.death.killed",
                    "nukacraft.death.eliminated",
                    "nukacraft.death.executed",
                    "nukacraft.death.annihilated",
                    "nukacraft.death.decimated"
            };

            public UltraciteDamageSource(Holder<DamageType> pType, Entity pDirectEntity, Entity pCausingEntity) {
                super(pType, pDirectEntity, pCausingEntity);
            }

            public static DamageSource source(RegistryAccess access) {
                return new UltraciteDamageSource(getHolder(access, ModDamageTypes.ULTRACITE_STEP), null, null);
            }

            @Override
            public Component getLocalizedDeathMessage(LivingEntity pLivingEntity) {
                final String s = "death.attack." + this.getMsgId();

                if (this.getEntity() == null && this.getDirectEntity() == null) {
                    LivingEntity living = pLivingEntity.getKillCredit();
                    return living != null ?
                            Component.translatable(s + ".player", pLivingEntity.getDisplayName(), living.getDisplayName()) :
                            Component.translatable(s, pLivingEntity.getDisplayName());
                } else {
                    final var component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
                    final var stack = this.getEntity() instanceof LivingEntity livingentity ? livingentity.getMainHandItem() : ItemStack.EMPTY;
                    return !stack.isEmpty() && stack.hasCustomHoverName() ?
                            Component.translatable(
                                    s + ".item",
                                    pLivingEntity.getDisplayName(),
                                    component,
                                    stack.getDisplayName()) :
                            Component.translatable(s, pLivingEntity.getDisplayName(), component);
                }
            }

            @Override
            public String getMsgId() {
                return msgSuffix[ThreadLocalRandom.current().nextInt(msgSuffix.length)];
            }
        }
    }
}
