package com.dayton.nukacraft.common.blocks.custom.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

@Mod.EventBusSubscriber
public class MutantPlantBlock extends FlowerBlock {



    public MutantPlantBlock(MobEffect p_53512_, int p_53513_, Properties p_53514_) {
        super(p_53512_, p_53513_, p_53514_);

    }
        //BLOCKSTATE_LIST.put(ModBlocksClass.ASTER.get(), ModBlocksClass.RADASTER.get());}




//    @Override
//    public boolean isRandomlyTicking(BlockState state) {
//        if (isMutated) {
//            if (new ResourceLocation("nukacraft:glow_sea").equals(level.getBiome(pos).value().getRegistryName())) {
//            ticks++;
//            if (ticks >= 12) {
//                isMutated = false;
//                MutationFloraClass.mutatePlants(state, pos, level);
//                ticks = 0;}
//        }}
//        return super.isRandomlyTicking(state);
//    }

    @Override
    public void setPlacedBy(Level p_49847_, BlockPos p_49848_, BlockState p_49849_, @Nullable LivingEntity p_49850_, ItemStack p_49851_) {
        if (new ResourceLocation("nukacraft:glow_sea").equals(p_49847_.getBiome(p_49848_).value().getRegistryName())) {
            MutationFloraClass.mutatePlants(p_49849_, p_49848_, p_49847_);
        }
        super.setPlacedBy(p_49847_, p_49848_, p_49849_, p_49850_, p_49851_);
    }


    //    @Override
//    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
//        BlockState newstate = null;
//        if (state.getBlock() == ModBlocksClass.ASTER.get()) {
//            newstate = ModBlocksClass.RADASTER.get().defaultBlockState();
//        }
//        if (player.getMainHandItem().getItem() == ModItemsClass.NUCMAT.get() && !(newstate == null)) {
//            MutationFloraClass.mutationOnTimeStart(level, pos, state, newstate);
//            player.getMainHandItem().shrink(1);
//            return InteractionResult.SUCCESS;
//        }
//        return InteractionResult.PASS;
//    }


}
