package com.nukateam.nukacraft.common.foundation.entities.mobs;

import com.nukateam.guns.client.data.handler.ShootingHandler;
import com.nukateam.guns.common.foundation.item.GunItem;
import com.nukateam.nukacraft.common.data.interfaces.IGunUser;
import com.nukateam.nukacraft.common.foundation.entities.misc.PowerArmorFrame;
import com.nukateam.nukacraft.common.foundation.entities.variants.RaiderVariant;
import com.nukateam.nukacraft.common.foundation.goals.GunAttackGoal;
import com.nukateam.nukacraft.common.foundation.goals.RidePowerArmorGoal;
import com.nukateam.nukacraft.common.registery.items.ModGuns;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import static com.nukateam.nukacraft.common.data.utils.PowerArmorUtils.*;
import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class Raider extends PathfinderMob implements RangedAttackMob, IGunUser {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(Raider.class, EntityDataSerializers.INT);

    public PowerArmorFrame armorTarget = null;

    public Raider(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setCanPickUpLoot(true);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new GunAttackGoal<>(this, 1.0D, 20.0F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(7, new RidePowerArmorGoal(this, 1.0D, 20.0F));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(Raider.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Monster.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Radroach.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.ARMOR, 2.0D);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    @Override
    public void rideTick() {
        super.rideTick();
        if(isWearingPowerArmor(this) && !getPowerArmor(this).hasEnergy())
            stopRiding();
    }

    private GunItem[] guns = new GunItem[]{
            ModGuns.PISTOL10MM.get(),
            ModGuns.PIPEREVOLVER.get(),
            ModGuns.PIPE_PISTOL.get(),
            ModGuns.SCOUT10MM.get(),
            ModGuns.MINIGUN.get(),
    };

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason,
                                        @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        setVariant(Util.getRandom(RaiderVariant.values(), random));
        var id = random.nextInt(guns.length);
        setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(guns[id]));
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setTypeVariant(pCompound.getInt("Variant"));
    }

    private void setTypeVariant(int pTypeVariant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, pTypeVariant);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(RaiderVariant variant) {
        this.setTypeVariant(variant.getId() & 255);
    }

    public RaiderVariant getVariant() {
        return RaiderVariant.byId(this.getTypeVariant() & 255);
    }

//    @Override
//    public boolean canHoldItem(ItemStack pStack) {
//        return pStack.getItem() instanceof GunItem;
//    }

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

    public ResourceLocation getTexture(){
        return nukaResource("textures/entity/raider/raider_"+ getTypeVariant() +".png");
    }
}
