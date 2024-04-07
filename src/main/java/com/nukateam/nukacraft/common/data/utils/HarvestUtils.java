package com.nukateam.nukacraft.common.data.utils;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

import static java.util.Map.entry;

public class HarvestUtils {

    private static final Map<Block, Item> harvestlist = Map.ofEntries(
            entry(ModBlocks.AGAVE.get(), ModItems.AGAVE.get()),
            entry(ModBlocks.NEOAGAVE.get(), ModItems.NEOAGAVE.get()),
            entry(ModBlocks.BBLOODLEAF_BUSH.get(), ModItems.BBLOODLEAF.get()),
            entry(ModBlocks.BLOODLEAF_BUSH.get(), ModItems.BLOODLEAF.get()),
            entry(ModBlocks.QUANTUMLEAF_BUSH.get(), ModItems.QUANTLEAF.get()),
            entry(ModBlocks.GAMMALEAF_BUSH.get(), ModItems.GAMMALEAF.get()),
            entry(ModBlocks.BLASTCAP.get(), ModItems.BLASTCAPFUNGI.get()),
            entry(ModBlocks.FIREMUSHROOM.get(), ModItems.FIREFUNGI.get()),
            entry(ModBlocks.BOMBBERRY_BUSH.get(), ModItems.BOMBBERRY.get()),
            entry(ModBlocks.BRAINFUNGUS.get(), ModItems.BRAINFUNGUS.get()),
            entry(ModBlocks.CRANBERRY.get(), ModItems.CRANBERRY.get()),
            entry(ModBlocks.GOLD_CRANBERRY.get(), ModItems.GOLD_CRANBERRY.get()),
            entry(ModBlocks.GLOWFUNGUS.get(), ModItems.GLOWMUSHROOM.get()),
            entry(ModBlocks.GUTFUNGI.get(), ModItems.GUTMUSHROOM.get()),
            entry(ModBlocks.CRACKBERRY_BUSH.get(), ModItems.CRACKBERRY.get()),
            entry(ModBlocks.HATTERFUNGI.get(), ModItems.HATTER.get()),
            entry(ModBlocks.MEGAHATTERFUNGI.get(), ModItems.MEGAHATTER.get()),
            entry(ModBlocks.MINDFUNGUS.get(), ModItems.MINDFUNGUS.get()),
            entry(ModBlocks.MUTTSHOOTFUNGUS.get(), ModItems.MUTSHMUSHROOM.get()),
            entry(ModBlocks.STARBERRY.get(), ModItems.STARBERRY.get()),
            entry(ModBlocks.WILDTATO.get(), ModItems.WILDTATO.get())
    );

    public static Item getFinishItem(BlockState state) {
        var harvetsResult = harvestlist.get(state.getBlock());
        return harvetsResult.asItem();
    }
}
