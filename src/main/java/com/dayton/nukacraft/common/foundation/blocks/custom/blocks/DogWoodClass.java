package com.dayton.nukacraft.common.foundation.blocks.custom.blocks;

import com.dayton.nukacraft.common.foundation.blocks.ModBlocksClass;
import com.dayton.nukacraft.common.foundation.items.ModItemsClass;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class DogWoodClass extends RotatedPillarBlock {
    public DogWoodClass(Properties prop) {
        super(prop);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (state.getBlock() == ModBlocksClass.ASHWOOD.get()) {
            if (player.getMainHandItem().getItem() instanceof AxeItem || player.getOffhandItem().getItem() instanceof AxeItem) {
                level.playSound(null, pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.strip")), SoundSource.NEUTRAL, 1, 1);
                BlockState strip = ModBlocksClass.STRIPPED_ASHWOOD.get().defaultBlockState();
                BlockState blockOld = level.getBlockState(pos);
                for (Map.Entry<Property<?>, Comparable<?>> entry : blockOld.getValues().entrySet()) {
                    Property _property = strip.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                    strip = strip.setValue(_property, (Comparable) entry.getValue());
                }
                ItemEntity itemSpawn = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItemsClass.DOGWOOD.get()));
                itemSpawn.setPickUpDelay(10);
                level.addFreshEntity(itemSpawn);
                level.setBlock(pos, strip, 3);
                return InteractionResult.SUCCESS;

            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 6;
    }

    @Override
    public void onCaughtFire(BlockState state, Level level, BlockPos pos, @Nullable Direction direction, @Nullable LivingEntity igniter) {
        super.onCaughtFire(state, level, pos, direction, igniter);
    }
}
