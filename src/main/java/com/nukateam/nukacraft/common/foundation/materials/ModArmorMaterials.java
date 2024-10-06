package com.nukateam.nukacraft.common.foundation.materials;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Map;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    WOOD("wood", 3, new int[]{1, 3, 2, 1}, 0, SoundEvents.ARMOR_EQUIP_TURTLE,
            0.0F, 0.0F, () -> Ingredient.of(Items.OAK_LOG)),
    CLOTH("cloth", 3, new int[]{1, 1, 1, 1}, 0, SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> Ingredient.of(Items.OAK_LOG)),
    HARDLEATHER("leather", 3, new int[]{2, 3, 3, 2}, 2, SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> Ingredient.of(ModItems.LEATHERHARD.get())),
    RAIDER("raider", 3, new int[]{2, 4, 3, 3}, 5, SoundEvents.ARMOR_EQUIP_IRON,
            0.0F, 0.0F, () -> Ingredient.of(ModItems.SCRAP.get())),
    METAL("metal", 4, new int[]{3, 4, 4, 3}, 6, SoundEvents.ARMOR_EQUIP_IRON,
            0.2F, 0.1F, () -> Ingredient.of(ModItems.STEELING.get())),
    TRAPPER("trapper", 4, new int[]{4, 5, 5, 3}, 6, SoundEvents.ARMOR_EQUIP_CHAIN,
            0.1F, 0.1F, () -> Ingredient.of(ModItems.STEELING.get())),

    SCOUT("scout", 4, new int[]{5, 6, 6, 4}, 6, SoundEvents.ARMOR_EQUIP_CHAIN,
            0.2F, 0.2F, () -> Ingredient.of(ModItems.STEELING.get())),

    COMBAT("combat", 4, new int[]{7, 8, 8, 6}, 6, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.3F, 0.3F, () -> Ingredient.of(ModItems.STEELING.get())),

    ROBOT("robot", 4, new int[]{8, 9, 9, 7}, 6, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.6F, 0.3F, () -> Ingredient.of(ModItems.STEELING.get()));

    public static final Map<ArmorItem.Type, Integer> TYPE_ID = Map.of(
            ArmorItem.Type.HELMET, 0,
            ArmorItem.Type.CHESTPLATE, 1,
            ArmorItem.Type.LEGGINGS, 2,
            ArmorItem.Type.BOOTS, 3
    );

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModArmorMaterials(String p_40474_, int p_40475_, int[] p_40476_, int p_40477_,
                      SoundEvent p_40478_, float p_40479_, float p_40480_, Supplier<Ingredient> p_40481_) {
        this.name = p_40474_;
        this.durabilityMultiplier = p_40475_;
        this.slotProtections = p_40476_;
        this.enchantmentValue = p_40477_;
        this.sound = p_40478_;
        this.toughness = p_40479_;
        this.knockbackResistance = p_40480_;
        this.repairIngredient = new LazyLoadedValue<>(p_40481_);
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return HEALTH_PER_SLOT[TYPE_ID.get(pType)] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.slotProtections[TYPE_ID.get(pType)];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return NukaCraftMod.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
