package com.nukateam.nukacraft.client;

import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;

//@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.CLIENT)
public class ClientConfig {
    public static LivingEntity currentEntity;
    public static HashMap<ItemStack, LivingEntity> entityForStack = new HashMap<>();
    public static ItemStack currentStack;
    public static ItemTransforms.TransformType currentTransform;

//    public static void setup() {
//        registerModelOverrides();
//    }
//
//    private static void registerModelOverrides() {
//        ModelOverrides.register(ModGuns.PISTOL10MM.get(), new Pistol10MM());
//        ModelOverrides.register(ModGuns.CLASSIC10MM.get(), new Classic10MM());
//        ModelOverrides.register(ModGuns.PIPE_PISTOL.get(), new PipePistol());
//        ModelOverrides.register(ModGuns.SCOUT10MM.get(), new Scout10MM());
//        ModelOverrides.register(ModGuns.CLASSIC10MM_ZAP.get(), new Classic10MMZap());
//        ModelOverrides.register(ModGuns.PIPEREVOLVER.get(), new PipeRevolver());
//        ModelOverrides.register(ModGuns.FATMAN.get(), new Fatman());
//        ModelOverrides.register(ModGuns.MINIGUN.get(), new Minigun());
//    }
}
