package com.dayton.nukacraft.client.gui.pipboy;



import com.dayton.nukacraft.NukaCraftMod;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PipBoyScreen extends AbstractContainerScreen<PipBoyMenu>{
    private final static HashMap<String, Object> guistate = PipBoyMenu.guistate;
    private static boolean menu = true;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
//Шо? ☢
    public static String[] page_buffer = new String[]{

            "", //string1
            "", //string2
            "", //string3
            "", //string4
            "", //string5
            "", //string6
            "", //string7
            "", //string8
            "", //string9
            "", //string10
            "", //catalogue name
            "nukacraft:textures/screens/radhearth." //resourceLocation
    };
    public static Integer[] cords = new Integer[]{0, 0};

    public PipBoyScreen(PipBoyMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 0;
        this.imageHeight = 0;
    }


    private static final ResourceLocation texture = new ResourceLocation("nukacraft:textures/screens/pipboy_template.png");

    @Override
    public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
        this.renderTooltip(ms, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, texture);
        this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

        RenderSystem.setShaderTexture(0, new ResourceLocation("nukacraft:textures/screens/pipboy.png")); //Pip Boy Skin
        this.blit(ms, this.leftPos + -116, this.topPos + -113, 0, 0, 235, 207, 235, 207);

//        RenderSystem.setShaderTexture(0, ); //Pip Boy Skin
//        this.blit(ms, this.leftPos + cords[0], this.topPos + cords[1], 0, 0, 235, 207, 235, 207);


    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
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
        this.font.draw(poseStack, new TranslatableComponent(page_buffer[10]), 33, 64, -1);
        this.font.draw(poseStack, new TranslatableComponent(page_buffer[0]), -102, -87, -6684775);
        this.font.draw(poseStack, new TranslatableComponent(page_buffer[1]), -102, -74, -6684775);
        this.font.draw(poseStack, new TranslatableComponent(page_buffer[2]), -102, -61, -6684775);
        this.font.draw(poseStack, new TranslatableComponent(page_buffer[3]), -102, -48, -6684775);
        this.font.draw(poseStack, new TranslatableComponent(page_buffer[4]), -102, -35, -6684775);
        this.font.draw(poseStack, new TranslatableComponent(page_buffer[5]), -102, -22, -6684775);
        this.font.draw(poseStack, new TranslatableComponent(page_buffer[6]), -102, -9, -6684775);
        this.font.draw(poseStack, new TranslatableComponent(page_buffer[7]), -102, 4, -6684775);
        this.font.draw(poseStack, new TranslatableComponent(page_buffer[8]), -102, 17, -6684775);
        this.font.draw(poseStack, new TranslatableComponent(page_buffer[9]), -102, 30, -6684775);
        //this.font.draw(poseStack, new TranslatableComponent(page_buffer[10]), -102, 43, -6684775);
    }

    @Override
    public void onClose() {
        super.onClose();
        Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
    }


    public void pageNavigation() {
        this.addRenderableWidget(new MainPipBoyButton(this.leftPos + -112, this.topPos + 58, 30, 20,
                new TextComponent("◀"), e -> {

        }));
        this.addRenderableWidget(new MainPipBoyButton(this.leftPos + -24, this.topPos + 58, 30, 20,
                new TextComponent("▶"), e -> {
        }));
    }

    public void archiveNavigation(){
        this.addRenderableWidget(new MainPipBoyButton(this.leftPos + -112, this.topPos + 58, 30, 20,
                new TextComponent("◀"), e -> {

        }));
        this.addRenderableWidget(new MainPipBoyButton(this.leftPos + -24, this.topPos + 58, 30, 20,
                new TextComponent("▶"), e -> {
        }));
    }

    public void buttonMenu() {
        if (!(PipBoy.content.size() == 0)) {
            for (int t = 0; t < PipBoy.content.size(); t++) {
                page_buffer[t] = PipBoy.content.get(t).getName();
                //int posCord = (t == 0) ? 13 : (t * 13);
                int finalT = t;

                this.addRenderableWidget(new TextPipBoyButton(this.leftPos + -102, this.topPos + (-89 + (t * 13)),  205, 11,
                        new TextComponent(""), e -> {
                    this.clearWidgets();
                    this.pageNavigation();
                }));
            }
        }


    }

    @Override
    public void init() {
        super.init();

        if (menu) {
            buttonMenu();
            archiveNavigation();
        }
        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);

//        this.addRenderableWidget(new MainPipBoyButton(this.leftPos + -114, this.topPos + 58, 30, 20, new TextComponent("X"), e -> {
//        }));
    }

}
