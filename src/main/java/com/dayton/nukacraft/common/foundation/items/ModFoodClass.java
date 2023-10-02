package com.dayton.nukacraft.common.foundation.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodClass {
    public static final FoodProperties COTTONCANDY = (new FoodProperties.Builder()).nutrition(4).alwaysEat().saturationMod(2.4f).build();
    public static final FoodProperties NUKAMELON = (new FoodProperties.Builder()).nutrition(1).alwaysEat().saturationMod(0.4f).build();
    public static final FoodProperties NASTY = (new FoodProperties.Builder()).nutrition(0).alwaysEat().saturationMod(0.2f).build();
    public static final FoodProperties NUKACOLA = (new FoodProperties.Builder()).nutrition(1).alwaysEat().saturationMod(0.1f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 0.3f).build();
    public static final FoodProperties NUKAFRUTTI = (new FoodProperties.Builder()).nutrition(1).alwaysEat().saturationMod(0.1f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 0.3f).build();
    public static final FoodProperties CRACKBERRY = (new FoodProperties.Builder()).nutrition(0).alwaysEat().saturationMod(0.1f).build();
    public static final FoodProperties BOMBBERRY = (new FoodProperties.Builder()).nutrition(0).alwaysEat().saturationMod(0.1f).build();
    public static final FoodProperties MUTTFRUIT = (new FoodProperties.Builder()).nutrition(1).alwaysEat().saturationMod(0.3f).build();
    public static final FoodProperties FUSFRUIT = (new FoodProperties.Builder()).nutrition(1).alwaysEat().saturationMod(0.3f).build();
    public static final FoodProperties SITTBEAN = (new FoodProperties.Builder()).nutrition(0).alwaysEat().saturationMod(0.1f).build();
    public static final FoodProperties NEUTRONROD = (new FoodProperties.Builder()).nutrition(0).alwaysEat().saturationMod(0.1f).build();
    public static final FoodProperties WILDTATO = (new FoodProperties.Builder()).nutrition(2).alwaysEat().saturationMod(0.6f).build();
    public static final FoodProperties STARBERRY = (new FoodProperties.Builder()).nutrition(3).alwaysEat().saturationMod(0.9f).build();
    public static final FoodProperties CRANBERRY = (new FoodProperties.Builder()).nutrition(2).alwaysEat().saturationMod(0.2f).build();
    public static final FoodProperties APPLESP = (new FoodProperties.Builder()).nutrition(5).alwaysEat().saturationMod(1.2f).build();
    public static final FoodProperties CRAM = (new FoodProperties.Builder()).nutrition(4).alwaysEat().saturationMod(2.2f).build();
    public static final FoodProperties CHIPS = (new FoodProperties.Builder()).nutrition(3).alwaysEat().saturationMod(1.3f).build();
    public static final FoodProperties FCAKES = (new FoodProperties.Builder()).nutrition(4).alwaysEat().saturationMod(1.1f).build();
    public static final FoodProperties MCCHESSE = (new FoodProperties.Builder()).nutrition(6).alwaysEat().saturationMod(1.5f).build();
    public static final FoodProperties PURES = (new FoodProperties.Builder()).nutrition(6).alwaysEat().saturationMod(2.2f).build();
    public static final FoodProperties SPOILED = (new FoodProperties.Builder()).alwaysEat().nutrition(1).saturationMod(0.0f).effect(new MobEffectInstance(MobEffects.POISON, 140, 0), 0.3f).build();
    //public static final FoodProperties COTTONCANDY = (new FoodProperties.Builder()).nutrition(4).alwaysEat().saturationMod(1.7f).build();
    public static final FoodProperties BUBBLEAPPLE = (new FoodProperties.Builder()).nutrition(0).alwaysEat().saturationMod(0.4f).build();
    public static final FoodProperties TEA = (new FoodProperties.Builder()).nutrition(1).fast().saturationMod(0.5f).build();
    public static final FoodProperties THISTLE = (new FoodProperties.Builder()).alwaysEat().fast().nutrition(3).saturationMod(1.4f).build();
    public static final FoodProperties VEGSOUP = (new FoodProperties.Builder()).nutrition(4).alwaysEat().saturationMod(2.4f).build();
    public static final FoodProperties TATOSALAD = (new FoodProperties.Builder()).nutrition(5).alwaysEat().saturationMod(2.7f).build();
    public static final FoodProperties SITTSOUP = (new FoodProperties.Builder()).nutrition(4).alwaysEat().saturationMod(1.4f).build();
    public static final FoodProperties SITTPUREE = (new FoodProperties.Builder()).nutrition(5).alwaysEat().saturationMod(2.1f).build();
    public static final FoodProperties FMSOUP = (new FoodProperties.Builder()).nutrition(4).alwaysEat().saturationMod(1.4f).build();
    public static final FoodProperties FMPUREE = (new FoodProperties.Builder()).nutrition(5).alwaysEat().saturationMod(2.1f).build();

    public static final FoodProperties MED = (new FoodProperties.Builder()).alwaysEat().nutrition(0).saturationMod(0.0f).build();


}
