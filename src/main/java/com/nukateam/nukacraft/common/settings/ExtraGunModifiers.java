package com.nukateam.nukacraft.common.settings;
import com.nukateam.ntgl.common.data.interfaces.IGunModifier;
import net.minecraft.util.Mth;
public class ExtraGunModifiers {
    public static final IGunModifier MAGAZINES = new IGunModifier() {};



    public static final IGunModifier HANDMADE_FLASHER = new IGunModifier() {
        @Override
        public double modifyMuzzleFlashScale(double scale)
        {
            return 0.15F;
        }
    };


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

    public static final IGunModifier HANDMADE_STOCK = new IGunModifier()
    {

        @Override
        public int modifyProjectileLife(int life) {
            return 2;
        }

        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.35F;
        }
        @Override
        public float kickModifier()
        {
            return 0.15F;
        }
    };
}
