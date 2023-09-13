package com.dayton.nukacraft.client.helpers;
import com.dayton.nukacraft.common.ExtraGunModifiers;
import com.mrcrayfish.guns.item.attachment.impl.Scope;
import com.mrcrayfish.guns.common.GunModifiers;
public class Scopes {
    public static final Scope OLD_SCOPE = Scope.builder().aimFovModifier(0.9F).modifiers(ExtraGunModifiers.QUICK_ADS_LVL1).build();
    public static final Scope HUNTING_SCOPE = Scope.builder().aimFovModifier(0.6F).modifiers(ExtraGunModifiers.HUNTING).build();

}
