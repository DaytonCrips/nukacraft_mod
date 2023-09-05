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
}
