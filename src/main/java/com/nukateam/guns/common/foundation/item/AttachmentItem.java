package com.nukateam.guns.common.foundation.item;

import com.nukateam.guns.client.handler.GunRenderingHandler;
import com.nukateam.nukacraft.common.data.interfaces.IResourceProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.loading.FMLEnvironment;

import static com.jetug.chassis_core.client.render.utils.ResourceHelper.*;

/**
 * Author: MrCrayfish
 */
public class AttachmentItem extends Item implements IMeta, IResourceProvider {
    private final Lazy<String> name = Lazy.of(() -> getResourceName(getRegistryName()));

    public AttachmentItem(Properties properties) {
        super(properties);
    }

    /* Dirty hack to apply enchant effect to attachments if gun is enchanted */
    @Override
    public boolean isFoil(ItemStack stack) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            ItemStack weapon = GunRenderingHandler.get().getRenderingWeapon();
            if (weapon != null) {
                return weapon.getItem().isFoil(weapon);
            }
        }
        return super.isFoil(stack);
    }

    @Override
    public String getName() {
        return name.get();
    }

    @Override
    public String getNamespace() {
        return getRegistryName().getNamespace();
    }
}
