package com.nukateam.map.impl.atlas.client.gui.core;

/**
 * Listener for left click on a button.
 */
public interface IButtonListener<B extends GuiComponentButton> {
    /**
     * Called when the button was left-clicked on.
     *
     * @param button the button which was clicked on.
     */
    void onClick(B button);
}
