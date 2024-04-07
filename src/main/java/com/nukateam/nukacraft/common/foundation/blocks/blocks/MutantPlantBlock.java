package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.utils.PlantMutationUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import static com.nukateam.nukacraft.common.data.utils.BiomeUtils.isInGlowSea;

@Mod.EventBusSubscriber
public class MutantPlantBlock extends FlowerBlock {
    public MutantPlantBlock(MobEffect effect, int val, Properties prop) {
        super(effect, val, prop);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        if (isInGlowSea(level, pos, state)) {
            PlantMutationUtils.mutationSuccess(state, pos, level);
        }
        super.setPlacedBy(level, pos, state, entity, stack);
    }
}
