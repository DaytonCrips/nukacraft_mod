package com.dayton.nukacraft.client;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.client.renderers.gun.model.*;
import com.dayton.nukacraft.common.foundation.items.ModGunsClass;
import com.mrcrayfish.guns.client.render.gun.ModelOverrides;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.CLIENT)
public class ClientHandler {

    public static void setup()
    {
        registerModelOverrides();
    }
    private static void registerModelOverrides()
    {
        ModelOverrides.register(ModGunsClass.PISTOL10MM.get(), new Pistol10MM());
        ModelOverrides.register(ModGunsClass.CLASSIC10MM.get(), new Classic10MM());
        ModelOverrides.register(ModGunsClass.PIPE_PISTOL.get(), new PipePistol());
        ModelOverrides.register(ModGunsClass.SCOUT10MM.get(), new Scout10MM());
        ModelOverrides.register(ModGunsClass.CLASSIC10MM_ZAP.get(), new Classic10MMZap());
        ModelOverrides.register(ModGunsClass.PIPEREVOLVER.get(), new PipeRevolver());
        ModelOverrides.register(ModGunsClass.FATMAN.get(), new Fatman());
        ModelOverrides.register(ModGunsClass.MINIGUN.get(), new Minigun());
    }
}
