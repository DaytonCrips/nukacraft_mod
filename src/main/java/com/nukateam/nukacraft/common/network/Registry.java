package com.nukateam.nukacraft.common.network;

import com.nukateam.nukacraft.common.network.actions.FramePickupAction;
import com.jetug.chassis_core.common.network.ActionRegistry;

public class Registry {
    static {
        ActionRegistry.addAction(new FramePickupAction());
        //ActionRegistry.addAction(new CastingStatusAction());
    }
}
