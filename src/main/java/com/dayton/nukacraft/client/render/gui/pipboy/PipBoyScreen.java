package com.dayton.nukacraft.client.render.gui.pipboy;


import com.dayton.map.impl.atlas.AntiqueAtlasModClient;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class PipBoyScreen extends PipBoyScreenBase<PipBoyMenu>{

    public PipBoyScreen(PipBoyMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.imageWidth = 0;
        this.imageHeight = 0;
    }

    private static final ResourceLocation texture = new ResourceLocation("nukacraft:textures/screens/pipboy_template.png");
    private static ResourceLocation pipboy = new ResourceLocation("nukacraft:textures/screens/pimpboy.png");
    private static final ResourceLocation pipboy_screen = new ResourceLocation("nukacraft:textures/screens/pipboy_screen.png");

    @Override
    public void init() {
        pipboy = PipBoy.pipboy_name;
        super.init();
        menu = true;
        if (PipBoy.content.size() == 0) {
            warningPipboy();
        } else {
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            buttonMenu();
            renderArchiveNavigation();
        }
        minecraft.keyboardHandler.setSendRepeatsToGui(true);
//        addRenderableWidget(new MainPipBoyButton(leftPos + -114, topPos + 58, 30, 20, new TextComponent("X"), e -> {
//        }));
    }

    @Override
    public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
        this.renderTooltip(ms, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(PipBoy.bred, PipBoy.bgreen, PipBoy.bblue, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, texture);
        blit(ms, leftPos, topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        RenderSystem.setShaderTexture(0, pipboy_screen); //Pip Boy Skin
        blit(ms, leftPos + -116, topPos + -113, 0, 0, 235, 207, 235, 207);

        if (!(image == null)) {
            RenderSystem.setShaderTexture(0, image); //Pip Boy Skin
            blit(ms, leftPos + cords[0], topPos + cords[1], 0, 0, 106, 65, 106, 65);
        }

        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, pipboy); //Pip Boy Skin
        blit(ms, leftPos + -116, topPos + -113, 0, 0, 235, 207, 235, 207);
    }

    public void warningPipboy() {
        page_buffer = PipBoy.warning_screen;
        image = PipBoy.warning_image;
        cords = PipBoy.warn_cords;
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    public void containerTick() {
        super.containerTick();
    }

    @Override
    protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
        for (int xt = 0; xt < 10; xt++) {
            font.draw(poseStack, new TranslatableComponent(page_buffer[xt]), -102, -87 + (xt * 13), PipBoy.fontColor);
        }

        if (menu)
            font.draw(poseStack, new TranslatableComponent("   [" + current_archive_page + "/" + archive_pages + "]"), 33, 64, -1);
        else font.draw(poseStack, new TranslatableComponent("   [" + current_page + "/" + (page_count-1) + "]"), 33, 64, -1);

    }

    @Override
    public void onClose() {
        super.onClose();
        Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
        menu = true;
    }
}
