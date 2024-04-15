package com.nukateam.nukacraft.client.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class RenderEvents {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void renderPipboy(RenderPlayerEvent event) {
//        var player = event.getPlayer();
//        var stack = SlotUtils.getPipboyStack(player);
//        var itemRenderer = Minecraft.getInstance().getItemInHandRenderer();
//        if (stack.isEmpty()) return;
//
//        try {
//            var method = ItemInHandLayer.class.getDeclaredMethod("renderArmWithItem",
//                    LivingEntity.class, ItemStack.class, ItemDisplayContext.class,
//                    HumanoidArm.class, PoseStack.class, MultiBufferSource.class, int.class);
//
//            method.setAccessible(true);
//
//            method.invoke(itemRenderer,
//                    player,
//                    stack,
//                    ItemDisplayContext.THIRD_PERSON_LEFT_HAND,
//                    HumanoidArm.LEFT,
//                    event.getPoseStack(),
//                    event.getMultiBufferSource(),
//                    event.getPackedLight());
//
//        } catch (Exception e) {}

//        Minecraft.getInstance().getItemInHandRenderer().renderItem(
//                player,
//                stack,
//                ItemDisplayContext.THIRD_PERSON_LEFT_HAND,
//                true,
//                event.getPoseStack(),
//                event.getMultiBufferSource(),
//                event.getPackedLight()
//        );
    }
}
