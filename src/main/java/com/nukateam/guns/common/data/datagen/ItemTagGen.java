package com.nukateam.guns.common.data.datagen;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTagGen extends ItemTagsProvider {
    public ItemTagGen(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, NukaCraftMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
    }
}
