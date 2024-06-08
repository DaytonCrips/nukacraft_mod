package com.nukateam.nukacraft;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.registries.RegistryObject;

public class ModSetup {
    public static void flowerPotSetup() {
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
        addPlant(ModBlocks.GUTFUNGI.getId(), ModBlocks.POTTED_GUTSHROOM);
        addPlant(ModBlocks.MARYGOLD.getId(), ModBlocks.POTTED_MARYGOLD);
        addPlant(ModBlocks.BROC.getId(), ModBlocks.POTTED_BROC);
        addPlant(ModBlocks.INVERT.getId(), ModBlocks.POTTED_INVERT);
        addPlant(ModBlocks.GLOWFUNGUS.getId(), ModBlocks.POTTED_GLOWFUNGUS);
        addPlant(ModBlocks.MUTTSHOOTFUNGUS.getId(), ModBlocks.POTTED_MUTTSHOOTFUNGUS);
        addPlant(ModBlocks.MEGAHATTERFUNGI.getId(), ModBlocks.POTTED_MEGAHATTERFUNGI);
        addPlant(ModBlocks.HATTERFUNGI.getId(), ModBlocks.POTTED_HATTER);
    }

    static void addPlant(ResourceLocation resourceLocation, RegistryObject<Block> registryObject) {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(resourceLocation, registryObject);
    }
}
