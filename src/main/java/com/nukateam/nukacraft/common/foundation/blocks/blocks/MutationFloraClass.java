package com.nukateam.nukacraft.common.foundation.blocks.blocks;


import com.nukateam.nukacraft.common.registery.ModParticles;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Map;

import static java.util.Map.entry;


public class MutationFloraClass {
    //TODO make json file for this
    private static final Map<Block, Block> mutations = Map.ofEntries(
            entry(ModBlocks.ASTER.get(), ModBlocks.RADASTER.get()),
            entry(ModBlocks.DEAD_PLANT.get(), ModBlocks.DEATH_FLOWER.get()),
            entry(ModBlocks.FIREMUSHROOM.get(), ModBlocks.BLASTCAP.get()),
            entry(ModBlocks.ASHROSE.get(), ModBlocks.RADROSE.get()),
            entry(ModBlocks.FEVERBLOSSOM.get(), ModBlocks.BOOMBLOSSOM.get()),
            entry(ModBlocks.SOOTFLOWER.get(), ModBlocks.GEIGERBLOSSOM.get()),
            entry(ModBlocks.BLOODLEAF_BUSH.get(), ModBlocks.QUANTUMLEAF_BUSH.get()),
            entry(ModBlocks.BBLOODLEAF_BUSH.get(), ModBlocks.GAMMALEAF_BUSH.get()),
            entry(ModBlocks.CRACKBERRY_BUSH.get(), ModBlocks.BOMBBERRY_BUSH.get()),
            entry(ModBlocks.MUTTFRUIT_BUSH.get(), ModBlocks.FUSFRUIT_BUSH.get()),
            entry(ModBlocks.SITTBEAN_BUSH.get(), ModBlocks.NEUTRON_BUSH.get()),
            entry(ModBlocks.CRANBERRY.get(), ModBlocks.GOLD_CRANBERRY.get()),
            entry(ModBlocks.BRAINFUNGUS.get(), ModBlocks.MINDFUNGUS.get()),
            entry(ModBlocks.GLOWFUNGUS.get(), ModBlocks.MUTTSHOOTFUNGUS.get()),
            entry(ModBlocks.AGAVE.get(), ModBlocks.NEOAGAVE.get()),
            entry(ModBlocks.CORALLEAF.get(), ModBlocks.PRISMLEAF.get()),
            entry(ModBlocks.BROC.get(), ModBlocks.INVERT.get()),
            entry(ModBlocks.GINSENG.get(), ModBlocks.NUKAROOT.get()),
            entry(ModBlocks.HATTER.get(), ModBlocks.MEGAHATTER.get()),

            entry(Blocks.MELON, ModBlocks.NUKAMELON.get()),
            entry(Blocks.WHEAT, ModBlocks.GIGAWHEAT.get()),
            entry(Blocks.POTATOES, ModBlocks.TATO.get()),
            entry(Blocks.BEETROOTS, ModBlocks.IRRADROOT.get()),
            entry(Blocks.CARROTS, ModBlocks.UFCARROT.get()),
            entry(Blocks.DANDELION, ModBlocks.DEAD_PLANT.get()),
            entry(Blocks.POPPY, ModBlocks.DEAD_PLANT.get()),
            entry(Blocks.BLUE_ORCHID, ModBlocks.DEAD_PLANT.get()),
            entry(Blocks.ORANGE_TULIP, ModBlocks.DEAD_PLANT.get()),
            entry(Blocks.PINK_TULIP, ModBlocks.DEAD_PLANT.get()),
            entry(Blocks.RED_TULIP, ModBlocks.DEAD_PLANT.get()),
            entry(Blocks.ALLIUM, ModBlocks.DEAD_PLANT.get()),
            entry(Blocks.WHITE_TULIP, ModBlocks.DEAD_PLANT.get()),
            entry(Blocks.OXEYE_DAISY, ModBlocks.DEAD_PLANT.get()),
            entry(Blocks.CORNFLOWER, ModBlocks.DEAD_PLANT.get()),
            entry(Blocks.LILY_OF_THE_VALLEY, ModBlocks.DEAD_PLANT.get())
            // и так далее
    );

    public static void mutationFailed(BlockPos pos, Level level) {
        createGammaParticles(level, pos);
        level.setBlock(pos, ModBlocks.DEAD_PLANT.get().defaultBlockState(), 3);
    }

    public static void mutationSuccess(BlockState state, BlockPos pos, Level level) {
        var mutatedState = mutations.get(state.getBlock());
        if (mutatedState != null) {
            mutationStart(level, pos, state, mutatedState.defaultBlockState());
        }
    }

    public static void mutationStart(Level level, BlockPos pos, BlockState state, BlockState newstate) {
        createGammaParticles(level, pos);
        for (Map.Entry<Property<?>, Comparable<?>> entry : state.getValues().entrySet()) {
            var property = newstate.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
            newstate = newstate.setValue(property, (Comparable) entry.getValue());
        }
        level.setBlock(pos, newstate, 3);
    }

    private static void createGammaParticles(Level level, BlockPos pos) {
        for (int i = 0; i < 360; i++) {
            if(i % 20 == 0) {
                level.addParticle(ModParticles.GAMMA_PARTICLE.get(),
                        pos.getX() + 0.5d, pos.getY() + 0.2d, pos.getZ() + 0.5d, Math.cos(i) * 0.15d, 0.15d, Math.sin(i) * 0.1d);
            }
        }
    }
}
