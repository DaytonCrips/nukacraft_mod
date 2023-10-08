package com.dayton.nukacraft.client;

import com.dayton.guns.client.render.gun.ModelOverrides;
import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.client.models.guns.*;
import com.dayton.nukacraft.client.render.renderers.GunRenderer;
import com.dayton.nukacraft.client.render.renderers.StaticGunRenderer;
import com.dayton.nukacraft.common.foundation.items.ModGuns;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

//@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.CLIENT)
public class ClientConfig {
    public static GunRenderer gunRenderer = new GunRenderer();
    public static StaticGunRenderer staticGunRenderer = new StaticGunRenderer();

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
