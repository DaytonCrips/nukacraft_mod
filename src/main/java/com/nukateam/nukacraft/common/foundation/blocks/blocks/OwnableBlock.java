//package com.nukateam.nukacraft.common.foundation.blocks.blocks;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.BaseEntityBlock;
//import net.minecraft.world.level.block.RenderShape;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.common.MinecraftForge;
//
//public class OwnableBlock extends BaseEntityBlock {
//    public OwnableBlock(BlockBehaviour.Properties properties) {
//        super(properties);
//    }
//
//    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
//        if (placer instanceof Player player) {
//            MinecraftForge.EVENT_BUS.post(new OwnershipEvent(level, pos, player));
//        }
//
//        if (stack.hasCustomHoverName()) {
//            BlockEntity var7 = level.getBlockEntity(pos);
//            if (var7 instanceof INameSetter) {
//                INameSetter nameable = (INameSetter)var7;
//                nameable.setCustomName(stack.getHoverName());
//            }
//        }
//
//    }
//
//    public RenderShape getRenderShape(BlockState state) {
//        return RenderShape.MODEL;
//    }
//
//    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return new OwnableBlockEntity(pos, state);
//    }
//}
