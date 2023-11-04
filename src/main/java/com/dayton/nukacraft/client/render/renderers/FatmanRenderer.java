package com.dayton.nukacraft.client.render.renderers;


import com.dayton.guns.common.foundation.item.GunItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;

import static com.dayton.guns.common.foundation.item.GunItem.*;
import static com.dayton.nukacraft.common.data.constants.Animations.SHOT;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;

public class FatmanRenderer extends GunRenderer<GunItem> {
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
