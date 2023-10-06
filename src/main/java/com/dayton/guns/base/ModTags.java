package com.dayton.guns.base;

import com.dayton.nukacraft.NukaCraftMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags
{
    public static class Blocks
    {
        public static final TagKey<Block> FRAGILE = tag("fragile");

        private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation(NukaCraftMod.MOD_ID, name));
        }
    }
}
