package com.nukateam.nukacraft.mixin.client;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

@OnlyIn(Dist.CLIENT)
@Mixin({AbstractContainerScreen.class})
public class AbstractContainerScreenMixin {
    @Shadow
    public static final ResourceLocation INVENTORY_LOCATION = nukaResource("textures/gui/screen/player_inventory.png");
}
