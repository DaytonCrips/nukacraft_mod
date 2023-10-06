package com.dayton.nukacraft.client;

import com.dayton.nukacraft.*;
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



    MINIGUN("minigun/minigun"),
    MINIGUN_BARREL("minigun/minigun_barrel"),

    PIPEREVOLVER("piperevolver/piperevolver"),
    PIPEREVOLVER_CYLINDER("piperevolver/piperevolver_cylinder"),


    PISTOL10mm("pistol10mm/pistol10mm"),
    PISTOL10mm_t1("pistol10mm/pistol10mmt1"),
    PISTOL10mm_t2("pistol10mm/pistol10mmt2"),
    PISTOL10mm_t3("pistol10mm/pistol10mmt3"),
    PISTOL10mm_SLIDE("pistol10mm/pistol10mm_slide"),


    SCOUT10mm("scout10mm/scout10mm"),
    SCOUT10mm_t1("scout10mm/scout10mmt1"),
    SCOUT10mm_t2("scout10mm/scout10mmt2"),
    SCOUT10mm_t3("scout10mm/scout10mmt3"),
    SCOUT10mm_t0("scout10mm/scout10mmt0"),

    CLASSIC10mm("classic10mm/classic10mm"),
    CLASSIC10mm_t1("classic10mm/classic10mmt1"),
    CLASSIC10mm_t2("classic10mm/classic10mmt2"),
    CLASSIC10mm_t3("classic10mm/classic10mmt3"),
    CLASSIC10mm_SLIDE("classic10mm/classic10mm_slide"),

    CLASSIC10mmZap("classic10mmzap/classic10mmzap"),
    CLASSIC10mm_t1Zap("classic10mmzap/classic10mmt1zap"),
    CLASSIC10mm_t2Zap("classic10mmzap/classic10mmt2zap"),
    CLASSIC10mm_t3Zap("classic10mmzap/classic10mmt3zap"),
    CLASSIC10mm_SLIDEZap("classic10mmzap/classic10mm_slidezap"),


    PIPE_PISTOL("pipepistol/pipepistol"),
    PIPE_PISTOL_t0("pipepistol/pipepistolt0"),
    PIPE_PISTOL_t1("pipepistol/pipepistolt1"),
    PIPE_PISTOL_t2("pipepistol/pipepistolt2"),
    PIPE_PISTOL_t3("pipepistol/pipepistolt3"),
    PIPE_PISTOL_SLIDE("pipepistol/pipepistol_slide"),

    FATMAN("fatman/fatman"),
    FATMAN_CART("fatman/fatman_cart"),
    FATMAN_NUKE("fatman/fatman_nuke");










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
        this.modelLocation = new ResourceLocation(NukaCraftMod.MOD_ID, "special/gun/" + modelName);
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
