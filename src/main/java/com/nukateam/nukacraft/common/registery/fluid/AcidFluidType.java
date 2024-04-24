package com.nukateam.nukacraft.common.registery.fluid;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.function.Consumer;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class AcidFluidType extends FluidType {

    public static final ResourceLocation ACID_STILL_RL = nukaResource("block/fluid/acid_still");
    public static final ResourceLocation ACID_FLOWING_RL = nukaResource("block/fluid/acid_flow");
    public static final ResourceLocation ACID_OVERLAY_RL = nukaResource("block/fluid/acid_overlay");
    public static final Vector3f FOG_COLOR = new Vector3f(104f / 255f, 86f / 255f, 54f / 255f);

    public AcidFluidType(Properties properties) {
        super(properties);
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ACID_STILL_RL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ACID_FLOWING_RL;
            }

            @Override
            public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
                return ACID_OVERLAY_RL;
            }

            public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level,
                                                    int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return FOG_COLOR;
            }
        });
    }

    public boolean move(FluidState state, LivingEntity entity, Vec3 movementVector, double gravity) {
        double d9 = entity.getY();
        float f4 = 0.8F;
        float f5 = 0.02F;
        float f6 = (float) EnchantmentHelper.getDepthStrider(entity);
        double d0 = 0.08D;
        boolean flag = entity.getDeltaMovement().y <= 0.0D;
        if (f6 > 3.0F) {
            f6 = 3.0F;
        }

        if (!entity.onGround()) {
            f6 *= 0.5F;
        }

        if (f6 > 0.0F) {
            f4 += (0.54600006F - f4) * f6 / 3.0F;
            f5 += (entity.getSpeed() - f5) * f6 / 3.0F;
        }

        if (entity.hasEffect(MobEffects.DOLPHINS_GRACE)) {
            f4 = 0.96F;
        }

        f5 *= (float) entity.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).getValue();
        entity.moveRelative(f5, movementVector);
        entity.move(MoverType.SELF, entity.getDeltaMovement());
        Vec3 vec36 = entity.getDeltaMovement();
        if (entity.horizontalCollision && entity.onClimbable()) {
            vec36 = new Vec3(vec36.x, 0.2D, vec36.z);
        }

        entity.setDeltaMovement(vec36.multiply((double) f4, (double) 0.8F, (double) f4));
        Vec3 vec32 = entity.getFluidFallingAdjustedMovement(d0, flag, entity.getDeltaMovement());
        entity.setDeltaMovement(vec32);
        if (entity.horizontalCollision && entity.isFree(vec32.x, vec32.y + (double) 0.6F - entity.getY() + d9, vec32.z)) {
            entity.setDeltaMovement(vec32.x, (double) 0.3F, vec32.z);
        }
        return true;
    }

    @Override
    public boolean isVaporizedOnPlacement(Level level, BlockPos pos, FluidStack stack) {
        return level.dimensionType().ultraWarm();
    }

}
