package com.nukateam.nukacraft.client.helpers;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public class NbtColor implements INBTSerializable<CompoundTag> {
    public float red   = 0.443f;
    public float green = 0.749f;
    public float blue  = 0.459f;

    public NbtColor(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public NbtColor() {}

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compound = new CompoundTag();
        compound.putFloat("r", red);
        compound.putFloat("g", green);
        compound.putFloat("b", blue);

        return compound;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        red   = nbt.getFloat("r");
        green = nbt.getFloat("g");
        blue  = nbt.getFloat("b");
    }

    public int getIntColor(){
        int R = Math.round(255 * red);
        int G = Math.round(255 * green);
        int B = Math.round(255 * blue);

        R = (R << 16) & 0x00FF0000;
        G = (G << 8) & 0x0000FF00;
        B = B & 0x000000FF;

        return 0xFF000000 | R | G | B;
    }
}
