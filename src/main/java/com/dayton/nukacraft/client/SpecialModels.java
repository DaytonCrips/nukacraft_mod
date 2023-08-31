package com.dayton.nukacraft.client;

import com.dayton.nukacraft.NukaCraftMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public enum SpecialModels {
    PISTOL10mm("gun/pistol10mm"),
    PISTOL10mm_SLIDE("gun/pistol10mm_slide"),
    CLASSIC10mm("gun/classic10mm"),
    CLASSIC10mm_SLIDE("gun/classic10mm_slide"),
    PIPE_PISTOL("gun/pipepistol"),
    PIPE_PISTOL_SLIDE("gun/pipepistol_slide");

    /**
     * The location of an item model in the [MOD_ID]/models/special/[NAME] folder
     */
    private final ResourceLocation modelLocation;

    /**
     * Cached model
     */
    private BakedModel cachedModel;

    /**
     * Sets the model's location
     *
     * @param modelName name of the model file
     */
    SpecialModels(String modelName)
    {
        this.modelLocation = new ResourceLocation(NukaCraftMod.MOD_ID, "special/" + modelName);
    }

    /**
     * Gets the model
     *
     * @return isolated model
     */
    public BakedModel getModel()
    {
        if(this.cachedModel == null)
        {
            this.cachedModel = Minecraft.getInstance().getModelManager().getModel(this.modelLocation);
        }
        return this.cachedModel;
    }

    /**
     * Registers the special models into the Forge Model Bakery. This is only called once on the
     * load of the game.
     */
    @SubscribeEvent
    public static void register(ModelRegistryEvent event)
    {
        for(SpecialModels model : values())
        {
            ForgeModelBakery.addSpecialModel(model.modelLocation);
        }
    }

    /**
     * Clears the cached BakedModel since it's been rebuilt. This is needed since the models may
     * have changed when a resource pack was applied, or if resources are reloaded.
     */
    @SubscribeEvent
    public static void onBake(ModelBakeEvent event)
    {
        for(SpecialModels model : values())
        {
            model.cachedModel = null;
        }
    }
}
