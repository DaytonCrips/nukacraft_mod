package com.nukateam.nukacraft.guns.jei;

import com.nukateam.guns.common.foundation.crafting.WorkbenchRecipe;
import com.nukateam.guns.common.foundation.crafting.WorkbenchRecipes;
import com.nukateam.guns.common.jei.WorkbenchCategory;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.registery.ModBlocks;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

/**
 * Author: MrCrayfish
 */
@JeiPlugin
public class GunModPlugin implements IModPlugin {
    public static final RecipeType<WorkbenchRecipe> WORKBENCH = RecipeType.create(NukaCraftMod.MOD_ID, "workbench", WorkbenchRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(NukaCraftMod.MOD_ID, "crafting");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper helper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new WorkbenchCategory(helper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        ClientLevel world = Objects.requireNonNull(Minecraft.getInstance().level);
        registration.addRecipes(WORKBENCH, WorkbenchRecipes.getAll(world));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.WORKBENCH.get()), WORKBENCH);
    }
}
