package com.nukateam.nukacraft.common.data.utils;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.items.ModFood;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

import static com.nukateam.nukacraft.common.registery.items.ModBlockItems.*;
import static java.util.Map.entry;

public class HarvestUtils {

    private static final Map<Block, Item> harvestlist = Map.ofEntries(
            entry(ModBlocks.AGAVE.get(), ModFood.AGAVE.get()),
            entry(ModBlocks.NEOAGAVE.get(), ModFood.NEOAGAVE.get()),
            entry(ModBlocks.BBLOODLEAF_BUSH.get(), ModItems.BBLOODLEAF.get()),
            entry(ModBlocks.BLOODLEAF_BUSH.get(), ModItems.BLOODLEAF.get()),
            entry(ModBlocks.QUANTUMLEAF_BUSH.get(), ModItems.QUANTLEAF.get()),
            entry(ModBlocks.GAMMALEAF_BUSH.get(), ModItems.GAMMA_LEAF.get()),
            entry(ModBlocks.BLASTCAP.get(), BLASTCAPFUNGI.get()),
            entry(ModBlocks.FIREMUSHROOM.get(), FIREFUNGI.get()),
            entry(ModBlocks.BOMBBERRY_BUSH.get(), ModFood.BOMBBERRY.get()),
            entry(ModBlocks.BRAINFUNGUS.get(), ModItems.BRAINFUNGUS.get()),
            entry(ModBlocks.CRANBERRY.get(), ModFood.CRANBERRY.get()),
            entry(ModBlocks.GOLD_CRANBERRY.get(), ModFood.GOLD_CRANBERRY.get()),
            entry(ModBlocks.GLOWFUNGUS.get(), GLOWMUSHROOM.get()),
            entry(ModBlocks.GUTFUNGI.get(), GUTMUSHROOM.get()),
            entry(ModBlocks.CRACKBERRY_BUSH.get(), ModFood.CRACKBERRY.get()),
            entry(ModBlocks.HATTERFUNGI.get(), HATTER.get()),
            entry(ModBlocks.MEGAHATTERFUNGI.get(), MEGAHATTER.get()),
            entry(ModBlocks.MINDFUNGUS.get(), ModItems.MINDFUNGUS.get()),
            entry(ModBlocks.MUTTSHOOTFUNGUS.get(), MUTSHMUSHROOM.get()),
            entry(ModBlocks.STARBERRY.get(), ModFood.STARBERRY.get()),
            entry(ModBlocks.WILDTATO.get(), ModFood.WILD_TATO.get())
    );

    public static Item getFinishItem(BlockState state) {
        var harvetsResult = harvestlist.get(state.getBlock());
        return harvetsResult.asItem();
    }
}
