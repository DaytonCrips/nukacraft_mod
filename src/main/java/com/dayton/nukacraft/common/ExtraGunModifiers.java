package com.dayton.nukacraft.common;
import com.mrcrayfish.guns.interfaces.IGunModifier;
import net.minecraft.util.Mth;
public class ExtraGunModifiers {
    public static final IGunModifier MAGAZINES = new IGunModifier() {};

    public static final IGunModifier ARMY_SILENCER = new IGunModifier()
    {
        @Override
        public double modifyFireSoundRadius(double radius)
        {
            return radius * 0.6;
        }

        @Override
        public double modifyMuzzleFlashScale(double scale)
        {
            return 0.45F;
        }
        @Override
        public boolean silencedFire()
        {
            return true;
        }
    };

    public static final IGunModifier OLD_SILENCER = new IGunModifier()
    {
        @Override
        public double modifyFireSoundRadius(double radius)
        {
            return radius * 0.9;
        }

        @Override
        public float modifyProjectileSpread(float spread) {
            return spread + 0.6f;
        }

        @Override
        public boolean silencedFire()
        {
            return true;
        }
    };

    public static final IGunModifier QUICK_ADS_LVL1 = new IGunModifier()
    {
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.45F;
        }
    };

    public static final IGunModifier HUNTING = new IGunModifier()
    {
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.45F;
        }
        @Override
        public int modifyFireRate(int rate)
        {
            return Mth.clamp((int) (rate * 1.55), rate + 1, Integer.MAX_VALUE);
        }
    };
}
