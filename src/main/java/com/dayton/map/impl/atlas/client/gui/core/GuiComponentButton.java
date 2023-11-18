package com.dayton.map.impl.atlas.client.gui.core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

import java.util.ArrayList;
import java.util.List;

/**
 * A GuiComponent that can act like a button.
 */
public class GuiComponentButton extends GuiComponent {
    private final List<IButtonListener<?>> listeners = new ArrayList<>();

    private boolean enabled = true;
    private SoundEvent clickSound = SoundEvents.UI_BUTTON_CLICK;

    public void setEnabled(boolean value) {
        enabled = value;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setClickSound(SoundEvent clickSound) {
        this.clickSound = clickSound;
    }

    /**
     * Makes the button produce no sound when clicked on.
     */
    public void mute() {
        clickSound = null;
    }

    @Override
    public boolean mouseClicked(double x, double y, int mouseButton) {
        if (mouseButton == 0 /*left-click*/ && enabled && isMouseOver) {
            onClick();
            return true;
        }

        return super.mouseClicked(x, y, mouseButton);
    }

    /**
     * Called when the user left-clicks on this component.
     */
    @SuppressWarnings("unchecked")
    void onClick() {
        if (clickSound != null) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(clickSound, 1.0F));
        }

        for (IButtonListener listener : listeners) {
            listener.onClick(this);
        }
    }

    public void addListener(IButtonListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IButtonListener listener) {
        listeners.remove(listener);
    }
}
