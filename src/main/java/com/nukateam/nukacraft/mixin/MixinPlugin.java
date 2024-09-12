package com.nukateam.nukacraft.mixin;

import net.minecraftforge.fml.loading.FMLEnvironment;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {
    private boolean isFrameworkInstalled;
    private static boolean betterCombatLoaded;

    @Override
    public void onLoad(String mixinPackage) {
        isFrameworkInstalled = isClassLoaded("com.mrcrayfish.framework.Framework");
        betterCombatLoaded = isClassLoaded("net.bettercombat.client.collision.TargetFinder");
    }

    private boolean isClassLoaded(String name) {
        var result = false;
        try {
            Class.forName(name, false, this.getClass().getClassLoader());
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        var isDevelopmentEnvironment = !FMLEnvironment.production;
        var betterCombatCheck = true; //!targetClassName.contains("bettercombat") || betterCombatLoaded;

        if (mixinClassName.contains("mixin.dev") && !isDevelopmentEnvironment && betterCombatCheck)
            return false;
        else return !mixinClassName.contains("mixin.prod") || !isDevelopmentEnvironment;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
