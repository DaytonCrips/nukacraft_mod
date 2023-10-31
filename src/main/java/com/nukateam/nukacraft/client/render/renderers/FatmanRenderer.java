package com.nukateam.nukacraft.client.render.renderers;


import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;

import static com.nukateam.guns.common.foundation.item.GunItem.*;
import static com.nukateam.nukacraft.common.data.constants.Animations.SHOT;

public class FatmanRenderer extends GunRenderer {

    @Override
    protected void animate(ItemStack stack){
        var tracker = Minecraft.getInstance().player.getCooldowns();
        float cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());

        if(1 >= cooldown && cooldown >= 0.9) {
            doAnim(stack, SHOT);
        }
        else{
            resetAnim(stack);
        }
    }

}
