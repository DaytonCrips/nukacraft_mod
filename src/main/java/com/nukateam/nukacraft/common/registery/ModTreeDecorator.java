package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.treedecorator.*;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModTreeDecorator{

    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, NukaCraftMod.MOD_ID);
    public static final RegistryObject<TreeDecoratorType<?>> RESIN_TREE_DECORATOR = TREE_DECORATORS.register("resin_deco", () ->
            new TreeDecoratorType<>(ResinDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<?>> SAP_TREE_DECORATOR = TREE_DECORATORS.register("sap_deco", () ->
            new TreeDecoratorType<>(SapDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<?>> MEGASLOTH_DECORATOR = TREE_DECORATORS.register("megasloth", () ->
            new TreeDecoratorType<>(MegaSlothDecorator.CODEC));

    public static final RegistryObject<TreeDecoratorType<?>> DEWDROPDECORATOR = TREE_DECORATORS.register("dewdropdeco", () ->
            new TreeDecoratorType<>(DewdropDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<?>> BBLIGHT_DECORATOR = TREE_DECORATORS.register("bblightdeco", () ->
            new TreeDecoratorType<>(BBlightDecorator.CODEC));


    public static void register(IEventBus eventBus){
        TREE_DECORATORS.register(eventBus);
    }
}
