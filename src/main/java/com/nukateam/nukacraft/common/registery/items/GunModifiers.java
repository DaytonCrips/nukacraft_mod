package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.ntgl.common.base.gun.GripType;
import com.nukateam.ntgl.common.data.interfaces.IGunModifier;
import net.minecraft.util.Mth;

public class GunModifiers {
    public static final IGunModifier SILENCED = new IGunModifier() {
        @Override
        public boolean silencedFire() {
            return true;
        }

        @Override
        public double modifyFireSoundRadius(double radius) {
            return radius * 0.25;
        }
    };

    public static final IGunModifier REDUCED_DAMAGE_lvl3 = new IGunModifier() {
        @Override
        public float modifyProjectileDamage(float damage) {
            return damage * 0.8F;
        }
    };

    public static final IGunModifier REDUCED_DAMAGE_lvl2 = new IGunModifier() {
        @Override
        public float modifyProjectileDamage(float damage) {
            return damage * 0.7F;
        }
    };
    public static final IGunModifier REDUCED_DAMAGE_lvl1 = new IGunModifier() {
        @Override
        public float modifyProjectileDamage(float damage) {
            return damage * 0.5F;
        }
    };

    public static final IGunModifier EXTEND_DAMAGE_lvl3 = new IGunModifier() {
        @Override
        public float modifyProjectileDamage(float damage) {
            return damage * 1.6F;
        }
    };

    public static final IGunModifier EXTEND_DAMAGE_lvl2 = new IGunModifier() {
        @Override
        public float modifyProjectileDamage(float damage) {
            return damage * 1.4F;
        }
    };
    public static final IGunModifier EXTEND_DAMAGE_lvl1 = new IGunModifier() {
        @Override
        public float modifyProjectileDamage(float damage) {
            return damage * 1.2F;
        }
    };

    public static final IGunModifier REDUCED_DISTANCE_LVL3 = new IGunModifier() {
        @Override
        public double modifyProjectileSpeed(double speed) {
            return speed * 0.2;
        }

        @Override
        public int modifyProjectileLife(int life) {
            return (int) (life * 0.2d);
        }
    };
    public static final IGunModifier EXTEND_DISTANCE_LVL3 = new IGunModifier() {
        @Override
        public double modifyProjectileSpeed(double speed) {
            return speed * 1.7;
        }
        @Override
        public int modifyProjectileLife(int life) {
            return (int) (life * 1.7);
        }
    };
    public static final IGunModifier EXTEND_DISTANCE_LVL2 = new IGunModifier() {
        @Override
        public double modifyProjectileSpeed(double speed) {
            return speed * 1.4;
        }
        @Override
        public int modifyProjectileLife(int life) {
            return (int) (life * 1.4);
        }
    };
    public static final IGunModifier EXTEND_DISTANCE_LVL1 = new IGunModifier() {
        @Override
        public double modifyProjectileSpeed(double speed) {
            return speed * 1.2;
        }
        @Override
        public int modifyProjectileLife(int life) {
            return (int) (life * 1.2);
        }
    };
    public static final IGunModifier REDUCED_DISTANCE_LVL2 = new IGunModifier() {
        @Override
        public double modifyProjectileSpeed(double speed) {
            return speed * 0.5;
        }
    };


    public static final IGunModifier REDUCED_DISTANCE_LVL1 = new IGunModifier() {
        @Override
        public double modifyProjectileSpeed(double speed) {
            return speed * 0.9;
        }
    };



    public static final IGunModifier EXTENDED_MAG = new IGunModifier() {
        @Override
        public int modifyMaxAmmo(int maxAmmo) {
            return (int) (maxAmmo * 1.5);
        }
    };

    public static final IGunModifier HUGE_MAG = new IGunModifier() {
        @Override
        public int modifyMaxAmmo(int maxAmmo) {
            return (int) (maxAmmo * 2.5);
        }
    };

    public static final IGunModifier DRUM_MAG = new IGunModifier() {
        @Override
        public int modifyMaxAmmo(int maxAmmo) {
            return maxAmmo * 4;
        }


    };

    public static final IGunModifier QUICK_MAG = new IGunModifier() {
        @Override
        public int modifyReloadTime(int reloadTime) {
            return (int)(reloadTime * 0.75);
        }

    };

    public static final IGunModifier REDUCED_KICKING_LVL2 = new IGunModifier() {
        @Override
        public float kickModifier() {
            return 0.6F;
        }
    };

    public static final IGunModifier REDUCED_KICKING_LVL3 = new IGunModifier() {
        @Override
        public float kickModifier() {
            return 0.9F;
        }
    };




    public static final IGunModifier REDUCED_KICKING_LVL1 = new IGunModifier() {
        @Override
        public float kickModifier() {
            return 0.3F;
        }
    };

    public static final IGunModifier EXTEND_KICKING_LVL1 = new IGunModifier() {
        @Override
        public float kickModifier() {
            return 1.4F;
        }
    };
    public static final IGunModifier EXTEND_KICKING_LVL2 = new IGunModifier() {
        @Override
        public float kickModifier() {
            return 1.2F;
        }
    };
    public static final IGunModifier EXTEND_KICKING_LVL3 = new IGunModifier() {
        @Override
        public float kickModifier() {
            return 1.5F;
        }
    };

    public static final IGunModifier EXTEND_RECOIL_LVL1 = new IGunModifier() {
        @Override
        public float modifyProjectileSpread(float spread) {
            return spread * 1.2F;
        }
        @Override
        public float recoilModifier() {
            return 1.5F;
        }
    };

    public static final IGunModifier EXTEND_RECOIL_LVL2 = new IGunModifier() {
        @Override
        public float modifyProjectileSpread(float spread) {
            return spread * 1.6F;
        }
        @Override
        public float recoilModifier() {
            return 1.9F;
        }
    };

    public static final IGunModifier REDUCED_RECOIL_LVL2 = new IGunModifier() {
        @Override
        public float modifyProjectileSpread(float spread) {
            return spread * 0.5F;
        }
        @Override
        public float recoilModifier() {
            return 0.5F;
        }
    };

    public static final IGunModifier REDUCED_RECOIL_LVL1 = new IGunModifier() {
        @Override
        public float modifyProjectileSpread(float spread) {
            return spread * 0.7F;
        }
        @Override
        public float recoilModifier() {
            return 0.7F;
        }
    };

    public static final IGunModifier FLASH_HIDER = new IGunModifier() {
        @Override
        public float modifyProjectileSpread(float spread) {
            return spread * 1.2F;
        }
        @Override
        public float recoilModifier() {
            return 1.2F;
        }
    };


    public static final IGunModifier REDUCED_RECOIL_LVL3 = new IGunModifier() {
        @Override
        public float modifyProjectileSpread(float spread) {
            return spread * 0.2F;
        }
        @Override
        public float recoilModifier() {
            return 0.2F;
        }
    };

    public static final IGunModifier TRANSFORM_CARBINE = new IGunModifier() {
        @Override
        public GripType modifyGripType(GripType gripType) {
            return GripType.TWO_HANDED;
        }
    };

}
