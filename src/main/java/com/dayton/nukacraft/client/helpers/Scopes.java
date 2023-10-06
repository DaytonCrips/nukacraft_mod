package com.dayton.nukacraft.client.helpers;

import com.dayton.nukacraft.common.ExtraGunModifiers;
import com.dayton.nukacraft.guns.item.attachment.impl.Scope;
public class Scopes {
    public static final Scope OLD_SCOPE = Scope.builder().aimFovModifier(0.6F).modifiers(ExtraGunModifiers.QUICK_ADS_LVL1).build();
    public static final Scope HUNTING_SCOPE = Scope.builder().aimFovModifier(0.9F).modifiers(ExtraGunModifiers.HUNTING).build();
    public static final Scope HANDMADE_COLL = Scope.builder().aimFovModifier(0.5F).modifiers(ExtraGunModifiers.QUICK_ADS_LVL1).build();

}
