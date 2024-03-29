package com.nukateam.map.impl.atlas.client.gui.core;

import com.nukateam.map.impl.atlas.client.Textures;

public class GuiScrollingContainer extends GuiComponent {
    private final GuiViewport viewport;
    private final GuiHScrollbar scrollbarHor;
    private final GuiVScrollbar scrollbarVer;
    private boolean renderBar = true;
    private boolean isVertical = false;

    public GuiScrollingContainer() {
        viewport = new GuiViewport();
        scrollbarHor = new GuiHScrollbar(viewport);
        scrollbarHor.setTexture(Textures.SCROLLBAR_HOR, 8, 7, 2);
        scrollbarVer = new GuiVScrollbar(viewport);
        scrollbarVer.setTexture(Textures.SCROLLBAR_VER, 7, 8, 2);
        setWheelScrollsVertically();
        this.addChild(viewport);
        this.addChild(scrollbarHor);
        this.addChild(scrollbarVer);
    }

    @Override
    protected void validateSize() {
        super.validateSize();
        scrollbarHor.updateContent();
        scrollbarVer.updateContent();
    }

    @Override
    public int getWidth() {
        return super.getWidth() - (scrollbarVer.visible ? 0 : scrollbarVer.getWidth());
    }

    @Override
    public int getHeight() {
        return super.getHeight() - (scrollbarHor.visible ? 0 : scrollbarHor.getHeight());
    }

    /**
     * Add scrolling content. Use removeContent to remove it.
     *
     * @return the child added
     */
    public GuiComponent addContent(GuiComponent child) {
        return viewport.addContent(child);
    }

    /**
     * @return the child removed
     */
    public GuiComponent removeContent(GuiComponent child) {
        return viewport.removeContent(child);
    }

    public void removeAllContent() {
        viewport.removeAllContent();
    }

    public GuiScrollingContainer setViewportSize(int width, int height) {
        viewport.setSize(width, height);
        if(isVertical) {
            if (renderBar)
                viewport.setRelativeCoords(7, 0);
            else viewport.setRelativeCoords(0, 0);
        }
        scrollbarHor.setRelativeCoords(0, height);
        scrollbarHor.setSize(width, scrollbarHor.getHeight());
        scrollbarVer.setRelativeCoords(0, 0);
        scrollbarVer.setSize(scrollbarVer.getWidth(), height);
        return this;
    }

    public GuiScrollingContainer renderBar(boolean renderBar) {
        this.renderBar = renderBar;
        scrollbarVer.renderBar(renderBar);
        return this;
    }

    /**
     * Mouse wheel will affect <b>horizontal</b> scrolling and not vertical.
     * This is the default behavior.
     */
    public GuiScrollingContainer setWheelScrollsHorizontally() {
        isVertical = false;
        scrollbarHor.setUsesWheel(true);
        scrollbarVer.setUsesWheel(false);
        return this;
    }

    /**
     * Mouse wheel will affect <b>vertical</b> scrolling and not horizontal.
     */
    public GuiScrollingContainer setWheelScrollsVertically() {
        isVertical = true;
        scrollbarHor.setUsesWheel(false);
        scrollbarVer.setUsesWheel(true);
        return this;
    }

    /**
     * Scroll to the specified point relative to the content's top left corner.
     * The container attempts to place the specified point at the top left
     * corner of the viewport as well.
     */
    public void scrollTo(int x, int y) {
        scrollbarHor.setScrollPos(x);
        scrollbarVer.setScrollPos(y);
    }
}
