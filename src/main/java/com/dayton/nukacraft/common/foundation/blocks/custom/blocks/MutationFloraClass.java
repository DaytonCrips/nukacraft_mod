package com.dayton.nukacraft.common.foundation.blocks.custom.blocks;


import com.dayton.nukacraft.common.registery.ModParticles;
import com.dayton.nukacraft.common.foundation.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Map;


public class MutationFloraClass {



    public static void mutationFailed(BlockState state, BlockPos pos, Level level) {
        diedMutation(level, pos, ModBlocks.DEATH_PLANT.get().defaultBlockState());
    }


    public static void mutationSucces(BlockState state, BlockPos pos, Level level) {
        if (state.getBlock().defaultBlockState() == ModBlocks.ASTER.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.RADASTER.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.DEATH_PLANT.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.DEATH_FLOWER.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.FIREMUSHROOM.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.BLASTCAP.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.ASHROSE.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.RADROSE.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.FEVERBLOSSOM.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.BOOMBLOSSOM.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.SOOTFLOWER.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.GEIGERBLOSSOM.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.BLOODLEAF_BUSH.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.QUANTUMLEAF_BUSH.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.BBLOODLEAF_BUSH.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.GAMMALEAF_BUSH.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.CRACKBERRY_BUSH.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.BOMBBERRY_BUSH.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.MUTTFRUIT_BUSH.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.FUSFRUIT_BUSH.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.SITTBEAN_BUSH.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.NEUTRON_BUSH.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.CRANBERRY.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.GOLD_CRANBERRY.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.BRAINFUNGUS.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.MINDFUNGUS.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.GLOWFUNGUS.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.MUTTSHOOTFUNGUS.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.MELON.defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.NUKAMELON.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.WHEAT.defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.GIGAWHEAT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.AGAVE.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.NEOAGAVE.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.CORALLEAF.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.PRISMLEAF.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.BROC.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.INVERT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.GINSENG.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.NUKAROOT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.POTATOES.defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.TATO.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.BEETROOTS.defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.IRRADROOT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.CARROTS.defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocks.UFCARROT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.DANDELION.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocks.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.POPPY.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocks.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.BLUE_ORCHID.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocks.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.ORANGE_TULIP.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocks.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.PINK_TULIP.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocks.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.RED_TULIP.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocks.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.ALLIUM.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocks.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.WHITE_TULIP.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocks.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.OXEYE_DAISY.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocks.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.CORNFLOWER.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocks.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.LILY_OF_THE_VALLEY.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocks.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocks.HATTER.get().defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocks.MEGAHATTER.get().defaultBlockState());
        }
    }


    public static void diedMutation(Level level, BlockPos pos, BlockState state) {
        for (int i = 0; i < 360; i++) {
            if(i % 20 == 0) {
                level.addParticle(ModParticles.GAMMA_PARTICLE.get(),
                        pos.getX() + 0.5d, pos.getY() + 0.2d, pos.getZ() + 0.5d, Math.cos(i) * 0.15d, 0.15d, Math.sin(i) * 0.1d);
            }
        }
        level.setBlock(pos, state, 3);
    }

    public static void mutationStart(Level level, BlockPos pos, BlockState state, BlockState newstate) {
        for (int i = 0; i < 360; i++) {
            if(i % 20 == 0) {
                level.addParticle(ModParticles.GAMMA_PARTICLE.get(),
                        pos.getX() + 0.5d, pos.getY() + 0.2d, pos.getZ() + 0.5d, Math.cos(i) * 0.15d, 0.15d, Math.sin(i) * 0.1d);
            }
        }
        for (Map.Entry<Property<?>, Comparable<?>> entry : state.getValues().entrySet()) {
            Property _property = newstate.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
            newstate = newstate.setValue(_property, (Comparable) entry.getValue());
        }
        level.setBlock(pos, newstate, 3);
    }
}
