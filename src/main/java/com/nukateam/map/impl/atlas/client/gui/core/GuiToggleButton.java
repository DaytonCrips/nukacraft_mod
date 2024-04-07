package com.nukateam.map.impl.atlas.client.gui.core;

/**
 * A button that can be toggled on, and only toggled off by selecting
 * a different ToggleButton.
 */
@SuppressWarnings("rawtypes")
public class GuiToggleButton extends GuiComponentButton {
    private boolean selected;

    private ToggleGroup radioGroup;

    protected boolean isSelected() {
        return selected;
    }

    /**
     * Sets the button selected state. If the button is part of a RadioGroup,
     * use the RadioGroup's setSelected method instead!
     */
    public void setSelected(boolean value) {
        this.selected = value;
    }

    public ToggleGroup getRadioGroup() {
        return radioGroup;
    }

    void setRadioGroup(ToggleGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    @Override
    protected void onClick() {
        if (isEnabled()) {
            setSelected(!isSelected());
        }
        super.onClick();
    }
}
