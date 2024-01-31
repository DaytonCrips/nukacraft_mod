package com.nukateam.nukacraft;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer;

public class ModSetup {
    public static void renderTypeSetup() {
        setRenderLayer(ModBlocks.CRACKBERRY_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.BLOODLEAF_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.BBLOODLEAF_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.GLOW_GRASS.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.ASTER.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_ASTER.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.RADASTER.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_RADASTER.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_DEATH_FLOWER.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.DEAD_PLANT.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.REDLIGHT.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.DEATH_FLOWER.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.FIREMUSHROOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_FIREMUSHROOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.BLASTCAP.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_BLASTCAP.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.ASHROSE.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_ASHROSE.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.RADROSE.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_RADROSE.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.FEVERBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_FEVERBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.BOOMBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_BOOMBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.SOOTFLOWER.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_SOOTFLOWER.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.GEIGERBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_GEIGERBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.ASHGRASS.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.CRANBERRY_GRASS.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.THISTLE.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.GAMMALEAF_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.QUANTUMLEAF_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.BOMBBERRY_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.MUTTFRUIT_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.FUSFRUIT_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.SITTBEAN_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.NEUTRON_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.WILDTATO.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.CRANBERRY.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.STARBERRY.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.GUTSHROOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_GUTSHROOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.BBLIGHT.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_BBLIGHT.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.GOLD_CRANBERRY.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.GIGAWHEAT.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.BRAINFUNGUS.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.ZANDER.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.MINDFUNGUS.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.GLOWFUNGUS.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.MUTTSHOOTFUNGUS.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.HOLLYHOCK.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.MARYGOLD.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_MARYGOLD.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.DATURAN.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.AGAVE.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.PUNGA.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.NEOAGAVE.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.GINSENG.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.NUKAROOT.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.CORALLEAF.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.PRISMLEAF.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.BROC.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.INVERT.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_BROC.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.POTTED_INVERT.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.TATO.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.IRRADROOT.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.UFCARROT.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.DEAD_PUNGA.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.DEAD_DATURAN.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.ARMEDGLASS.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.DEAD_CORALLEAF.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.RREDDOOR.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.DECAYDOOR.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.STEELBARS.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.SHELTERBARS.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.HATTER.get(), RenderType.cutout());
        setRenderLayer(ModBlocks.MEGAHATTER.get(), RenderType.cutout());

    }

    public static void flowerPotSetup()
    {
        addPlant(ModBlocks.ASTER.getId(), ModBlocks.POTTED_ASTER);
        addPlant(ModBlocks.RADASTER.getId(), ModBlocks.POTTED_RADASTER);
        addPlant(ModBlocks.DEATH_FLOWER.getId(), ModBlocks.POTTED_DEATH_FLOWER);
        addPlant(ModBlocks.FIREMUSHROOM.getId(), ModBlocks.POTTED_FIREMUSHROOM);
        addPlant(ModBlocks.BLASTCAP.getId(), ModBlocks.POTTED_BLASTCAP);
        addPlant(ModBlocks.ASHROSE.getId(), ModBlocks.POTTED_ASHROSE);
        addPlant(ModBlocks.RADROSE.getId(), ModBlocks.POTTED_RADROSE);
        addPlant(ModBlocks.FEVERBLOSSOM.getId(), ModBlocks.POTTED_FEVERBLOSSOM);
        addPlant(ModBlocks.BOOMBLOSSOM.getId(), ModBlocks.POTTED_BOOMBLOSSOM);
        addPlant(ModBlocks.SOOTFLOWER.getId(), ModBlocks.POTTED_SOOTFLOWER);
        addPlant(ModBlocks.GEIGERBLOSSOM.getId(), ModBlocks.POTTED_GEIGERBLOSSOM);
        addPlant(ModBlocks.GUTSHROOM.getId(), ModBlocks.POTTED_GUTSHROOM);
        addPlant(ModBlocks.BBLIGHT.getId(), ModBlocks.POTTED_BBLIGHT);
        addPlant(ModBlocks.MARYGOLD.getId(), ModBlocks.POTTED_MARYGOLD);
        addPlant(ModBlocks.BROC.getId(), ModBlocks.POTTED_BROC);
        addPlant(ModBlocks.INVERT.getId(), ModBlocks.POTTED_INVERT);
    }

    static void addPlant(ResourceLocation resourceLocation, RegistryObject<Block> registryObject){
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(resourceLocation, registryObject);
    }
}
