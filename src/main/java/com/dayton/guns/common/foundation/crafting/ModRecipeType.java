package com.dayton.guns.common.foundation.crafting;

import net.minecraft.world.item.crafting.RecipeType;

/**
 * Author: MrCrayfish
 */
public class ModRecipeType {
    public static final RecipeType<WorkbenchRecipe> WORKBENCH = RecipeType.register("nukacraft:workbench");

    // Does nothing but trigger loading of static fields
    public static void init() {
    }
}
