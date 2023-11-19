package com.dayton.nukacraft.common.foundation.entities;

import com.dayton.guns.client.handler.ShootingHandler;
import com.dayton.nukacraft.common.data.interfaces.IGunUser;
import com.dayton.nukacraft.common.foundation.goals.GunAttackGoal;
import com.dayton.nukacraft.common.foundation.goals.RidePowerArmorGoal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import static com.dayton.nukacraft.common.data.utils.Resources.nukaResource;

public class RaiderEntity extends PathfinderMob implements RangedAttackMob, IGunUser {
    protected RaiderEntity(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setCanPickUpLoot(true);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new GunAttackGoal<>(this, 1.0D, 10.0F));
        this.goalSelector.addGoal(4, new RidePowerArmorGoal(this, 1.0D, 8.0F));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.ATTACK_DAMAGE, 3.0D)
                .add(Attributes.ARMOR, 2.0D);
    }

    @Override
    public boolean isInvisible() {
        if(getVehicle() instanceof PowerArmorFrame)
            return true;
        return super.isInvisible();
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        var s = level.isClientSide;
        var item = getMainHandItem();
        ShootingHandler.get().fire(this, item);
    }

    public String getVariant(){
        return "0";
    }

    public ResourceLocation getTexture(){
        return nukaResource("textures/entity/raider.png");
    }
}
