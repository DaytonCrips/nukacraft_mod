package com.dayton.nukacraft.common.blocks.custom.blocks;


import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.blocks.ModBlocksClass;
import com.dayton.nukacraft.client.particles.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Map;


public class MutationFloraClass {



    public static void mutationFailed(BlockState state, BlockPos pos, Level level) {
        diedMutation(level, pos, ModBlocksClass.DEATH_PLANT.get().defaultBlockState());
    }


    public static void mutationSucces(BlockState state, BlockPos pos, Level level) {
        if (state.getBlock().defaultBlockState() == ModBlocksClass.ASTER.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.RADASTER.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.DEATH_PLANT.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.DEATH_FLOWER.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.FIREMUSHROOM.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.BLASTCAP.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.ASHROSE.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.RADROSE.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.FEVERBLOSSOM.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.BOOMBLOSSOM.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.SOOTFLOWER.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.GEIGERBLOSSOM.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.BLOODLEAF_BUSH.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.QUANTUMLEAF_BUSH.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.BBLOODLEAF_BUSH.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.GAMMALEAF_BUSH.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.CRACKBERRY_BUSH.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.BOMBBERRY_BUSH.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.MUTTFRUIT_BUSH.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.FUSFRUIT_BUSH.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.SITTBEAN_BUSH.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.NEUTRON_BUSH.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.CRANBERRY.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.GOLD_CRANBERRY.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.BRAINFUNGUS.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.MINDFUNGUS.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.GLOWFUNGUS.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.MUTTSHOOTFUNGUS.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.MELON.defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.NUKAMELON.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.WHEAT.defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.GIGAWHEAT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.AGAVE.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.NEOAGAVE.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.CORALLEAF.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.PRISMLEAF.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.BROC.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.INVERT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == ModBlocksClass.GINSENG.get().defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.NUKAROOT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.POTATOES.defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.TATO.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.BEETROOTS.defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.IRRADROOT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.CARROTS.defaultBlockState()) {
            mutationStart(level, pos, state, ModBlocksClass.UFCARROT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.DANDELION.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocksClass.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.POPPY.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocksClass.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.BLUE_ORCHID.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocksClass.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.ORANGE_TULIP.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocksClass.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.PINK_TULIP.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocksClass.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.RED_TULIP.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocksClass.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.ALLIUM.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocksClass.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.WHITE_TULIP.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocksClass.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.OXEYE_DAISY.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocksClass.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.CORNFLOWER.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocksClass.DEATH_PLANT.get().defaultBlockState());
        }
        if (state.getBlock().defaultBlockState() == Blocks.LILY_OF_THE_VALLEY.defaultBlockState()) {
            MutationFloraClass.mutationStart(level, pos, state, ModBlocksClass.DEATH_PLANT.get().defaultBlockState());
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
