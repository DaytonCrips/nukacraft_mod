package com.nukateam.guns.common.data.datagen;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageGen extends LanguageProvider {
    public LanguageGen(DataGenerator gen) {
        super(gen, NukaCraftMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
    }
}
