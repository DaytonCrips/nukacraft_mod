package com.dayton.nukacraft.client.models.endity.core;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.mojang.math.Vector4f;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.mojang.math.Vector3f.*;

@OnlyIn(Dist.CLIENT)
public class AdvancedModelBox extends BasicModelPart {
    public float defaultRotationX;
    public float defaultRotationY;
    public float defaultRotationZ;
    public float defaultOffsetX;
    public float defaultOffsetY;
    public float defaultOffsetZ;
    public float defaultPositionX;
    public float defaultPositionY;
    public float defaultPositionZ;
    public float scaleX;
    public float scaleY;
    public float scaleZ;
    public int textureOffsetX;
    public int textureOffsetY;
    public boolean scaleChildren;
    private AdvancedEntityModel model;
    private AdvancedModelBox parent;
    private int displayList;
    private boolean compiled;
    public ObjectList<TabulaModelRenderUtils.ModelBox> cubeList;
    public ObjectList<BasicModelPart> childModels;
    private float textureWidth;
    private float textureHeight;
    public float offsetX;
    public float offsetY;
    public float offsetZ;
    public String boxName;

    public AdvancedModelBox(AdvancedEntityModel model, String name) {
        super(model);
        this.scaleX = 1.0F;
        this.scaleY = 1.0F;
        this.scaleZ = 1.0F;
        this.boxName = "";
        this.textureWidth = (float)model.texWidth;
        this.textureHeight = (float)model.texHeight;
        this.model = model;
        this.cubeList = new ObjectArrayList();
        this.childModels = new ObjectArrayList();
        this.boxName = name;
    }

    public AdvancedModelBox(AdvancedEntityModel model) {
        this(model, (String)null);
        this.textureWidth = (float)model.texWidth;
        this.textureHeight = (float)model.texHeight;
        this.cubeList = new ObjectArrayList();
        this.childModels = new ObjectArrayList();
    }

    public AdvancedModelBox(AdvancedEntityModel model, int textureOffsetX, int textureOffsetY) {
        this(model);
        this.textureWidth = (float)model.texWidth;
        this.textureHeight = (float)model.texHeight;
        this.setTextureOffset(textureOffsetX, textureOffsetY);
        this.cubeList = new ObjectArrayList();
        this.childModels = new ObjectArrayList();
    }

    public BasicModelPart setTexSize(int p_78787_1_, int p_78787_2_) {
        this.textureWidth = (float)p_78787_1_;
        this.textureHeight = (float)p_78787_2_;
        return this;
    }

    public BasicModelPart addBox(String p_217178_1_, float p_217178_2_, float p_217178_3_, float p_217178_4_, int p_217178_5_, int p_217178_6_, int p_217178_7_, float p_217178_8_, int p_217178_9_, int p_217178_10_) {
        this.setTextureOffset(p_217178_9_, p_217178_10_);
        this.addBox(this.textureOffsetX, this.textureOffsetY, p_217178_2_, p_217178_3_, p_217178_4_, (float)p_217178_5_, (float)p_217178_6_, (float)p_217178_7_, p_217178_8_, p_217178_8_, p_217178_8_, this.mirror, false);
        return this;
    }

    public BasicModelPart addBox(float p_228300_1_, float p_228300_2_, float p_228300_3_, float p_228300_4_, float p_228300_5_, float p_228300_6_) {
        this.addBox(this.textureOffsetX, this.textureOffsetY, p_228300_1_, p_228300_2_, p_228300_3_, p_228300_4_, p_228300_5_, p_228300_6_, 0.0F, 0.0F, 0.0F, this.mirror, false);
        return this;
    }

    public BasicModelPart addBox(float p_228304_1_, float p_228304_2_, float p_228304_3_, float p_228304_4_, float p_228304_5_, float p_228304_6_, boolean p_228304_7_) {
        this.addBox(this.textureOffsetX, this.textureOffsetY, p_228304_1_, p_228304_2_, p_228304_3_, p_228304_4_, p_228304_5_, p_228304_6_, 0.0F, 0.0F, 0.0F, p_228304_7_, false);
        return this;
    }

    public void addBox(float p_228301_1_, float p_228301_2_, float p_228301_3_, float p_228301_4_, float p_228301_5_, float p_228301_6_, float p_228301_7_) {
        this.addBox(this.textureOffsetX, this.textureOffsetY, p_228301_1_, p_228301_2_, p_228301_3_, p_228301_4_, p_228301_5_, p_228301_6_, p_228301_7_, p_228301_7_, p_228301_7_, this.mirror, false);
    }

    public void addBox(float p_228302_1_, float p_228302_2_, float p_228302_3_, float p_228302_4_, float p_228302_5_, float p_228302_6_, float p_228302_7_, float p_228302_8_, float p_228302_9_) {
        this.addBox(this.textureOffsetX, this.textureOffsetY, p_228302_1_, p_228302_2_, p_228302_3_, p_228302_4_, p_228302_5_, p_228302_6_, p_228302_7_, p_228302_8_, p_228302_9_, this.mirror, false);
    }

    public void addBox(float p_228303_1_, float p_228303_2_, float p_228303_3_, float p_228303_4_, float p_228303_5_, float p_228303_6_, float p_228303_7_, boolean p_228303_8_) {
        this.addBox(this.textureOffsetX, this.textureOffsetY, p_228303_1_, p_228303_2_, p_228303_3_, p_228303_4_, p_228303_5_, p_228303_6_, p_228303_7_, p_228303_7_, p_228303_7_, p_228303_8_, false);
    }

    private void addBox(int p_228305_1_, int p_228305_2_, float p_228305_3_, float p_228305_4_, float p_228305_5_, float p_228305_6_, float p_228305_7_, float p_228305_8_, float p_228305_9_, float p_228305_10_, float p_228305_11_, boolean p_228305_12_, boolean p_228305_13_) {
        this.cubeList.add(new TabulaModelRenderUtils.ModelBox(p_228305_1_, p_228305_2_, p_228305_3_, p_228305_4_, p_228305_5_, p_228305_6_, p_228305_7_, p_228305_8_, p_228305_9_, p_228305_10_, p_228305_11_, p_228305_12_, this.textureWidth, this.textureHeight));
    }

    public void setShouldScaleChildren(boolean scaleChildren) {
        this.scaleChildren = scaleChildren;
    }

    public void setScale(float scaleX, float scaleY, float scaleZ) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
    }

    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }

    public void setScaleZ(float scaleZ) {
        this.scaleZ = scaleZ;
    }

    public void updateDefaultPose() {
        this.defaultRotationX = this.rotateAngleX;
        this.defaultRotationY = this.rotateAngleY;
        this.defaultRotationZ = this.rotateAngleZ;
        this.defaultPositionX = this.rotationPointX;
        this.defaultPositionY = this.rotationPointY;
        this.defaultPositionZ = this.rotationPointZ;
    }

    public void setPos(float xIn, float yIn, float zIn) {
        this.rotationPointX = xIn;
        this.rotationPointY = yIn;
        this.rotationPointZ = zIn;
    }

    public void resetToDefaultPose() {
        this.rotateAngleX = this.defaultRotationX;
        this.rotateAngleY = this.defaultRotationY;
        this.rotateAngleZ = this.defaultRotationZ;
        this.rotationPointX = this.defaultPositionX;
        this.rotationPointY = this.defaultPositionY;
        this.rotationPointZ = this.defaultPositionZ;
    }

    public void addChild(BasicModelPart child) {
        super.addChild(child);
        this.childModels.add(child);
        if (child instanceof AdvancedModelBox advancedChild) {
            advancedChild.setParent(this);
        }

    }

    public AdvancedModelBox getParent() {
        return this.parent;
    }

    public void setParent(AdvancedModelBox parent) {
        this.parent = parent;
    }

    public void parentedPostRender(float scale) {
        if (this.parent != null) {
            this.parent.parentedPostRender(scale);
        }

    }

    public void renderWithParents(float scale) {
        if (this.parent != null) {
            this.parent.renderWithParents(scale);
        }

    }

    public void translateAndRotate(PoseStack matrixStackIn) {
        matrixStackIn.translate(
                this.rotationPointX / 16.0F,
                this.rotationPointY / 16.0F,
                this.rotationPointZ / 16.0F);

        if (this.rotateAngleZ != 0.0F) matrixStackIn.mulPose(ZP.rotation(this.rotateAngleZ));
        if (this.rotateAngleY != 0.0F) matrixStackIn.mulPose(YP.rotation(this.rotateAngleY));
        if (this.rotateAngleX != 0.0F) matrixStackIn.mulPose(XP.rotation(this.rotateAngleX));

        matrixStackIn.scale(this.scaleX, this.scaleY, this.scaleZ);
    }

    public void render(PoseStack p_228309_1_, VertexConsumer p_228309_2_, int p_228309_3_, int p_228309_4_, float p_228309_5_, float p_228309_6_, float p_228309_7_, float p_228309_8_) {
        if (this.showModel && (!this.cubeList.isEmpty() || !this.childModels.isEmpty())) {
            p_228309_1_.pushPose();
            this.translateAndRotate(p_228309_1_);
            this.doRender(p_228309_1_.last(), p_228309_2_, p_228309_3_, p_228309_4_, p_228309_5_, p_228309_6_, p_228309_7_, p_228309_8_);
            ObjectListIterator var9 = this.childModels.iterator();
            if (!this.scaleChildren) {
                p_228309_1_.scale(1.0F / Math.max(this.scaleX, 1.0E-4F), 1.0F / Math.max(this.scaleY, 1.0E-4F), 1.0F / Math.max(this.scaleZ, 1.0E-4F));
            }

            while(var9.hasNext()) {
                BasicModelPart lvt_10_1_ = (BasicModelPart)var9.next();
                lvt_10_1_.render(p_228309_1_, p_228309_2_, p_228309_3_, p_228309_4_, p_228309_5_, p_228309_6_, p_228309_7_, p_228309_8_);
            }

            p_228309_1_.popPose();
        }

    }

    private void doRender(PoseStack.Pose pose, VertexConsumer vertexConsumer,
                          int p_228306_3_, int p_228306_4_, float p_228306_5_,
                          float p_228306_6_, float p_228306_7_, float p_228306_8_) {
        var matrix4f = pose.pose();
        var matrix3f = pose.normal();

        for (TabulaModelRenderUtils.ModelBox lvt_12_1_ : this.cubeList) {
            var texturedQuads = lvt_12_1_.quads;

            for (var item : texturedQuads) {
                var vec = new Vector3f(new Vec3(item.normal));
//                vec.mul(matrix3f);
                vec.mul(20);

                for (int i = 0; i < 4; ++i) {
                    var vertexPosition = item.vertexPositions[i];
                    var x = vertexPosition.position.x() / 16.0F;
                    var y = vertexPosition.position.y() / 16.0F;
                    var z = vertexPosition.position.z() / 16.0F;
                    var vec4 = new Vector4f(x, y, z, 1.0F);

//                    vec4.mul(matrix4f);
                    vec4.mul(20);
                    vertexConsumer.vertex(
                            vec4.x(), vec4.y(), vec4.z(),
                            p_228306_5_, p_228306_6_, p_228306_7_, p_228306_8_,
                            vertexPosition.textureU, vertexPosition.textureV,
                            p_228306_4_, p_228306_3_, vec.x(), vec.y(), vec.z());
                }
            }
        }
    }

    public AdvancedEntityModel getModel() {
        return this.model;
    }

    private float calculateRotation(float speed, float degree, boolean invert, float offset, float weight, float f, float f1) {
        float movementScale = this.model.getMovementScale();
        float rotation = Mth.cos(f * speed * movementScale + offset) * degree * movementScale * f1 + weight * f1;
        return invert ? -rotation : rotation;
    }

    public void walk(float speed, float degree, boolean invert, float offset, float weight, float walk, float walkAmount) {
        this.rotateAngleX += this.calculateRotation(speed, degree, invert, offset, weight, walk, walkAmount);
    }

    public void flap(float speed, float degree, boolean invert, float offset, float weight, float flap, float flapAmount) {
        this.rotateAngleZ += this.calculateRotation(speed, degree, invert, offset, weight, flap, flapAmount);
    }

    public void swing(float speed, float degree, boolean invert, float offset, float weight, float swing, float swingAmount) {
        this.rotateAngleY += this.calculateRotation(speed, degree, invert, offset, weight, swing, swingAmount);
    }

    public void bob(float speed, float degree, boolean bounce, float f, float f1) {
        float movementScale = this.model.getMovementScale();
        degree *= movementScale;
        speed *= movementScale;
        float bob = (float)(Math.sin((double)(f * speed)) * (double)f1 * (double)degree - (double)(f1 * degree));
        if (bounce) {
            bob = (float)(-Math.abs(Math.sin((double)(f * speed)) * (double)f1 * (double)degree));
        }

        this.rotationPointY += bob;
    }

    public AdvancedModelBox setTextureOffset(int textureOffsetX, int textureOffsetY) {
        this.textureOffsetX = textureOffsetX;
        this.textureOffsetY = textureOffsetY;
        return this;
    }

    public void transitionTo(AdvancedModelBox to, float timer, float maxTime) {
        this.rotateAngleX += (to.rotateAngleX - this.rotateAngleX) / maxTime * timer;
        this.rotateAngleY += (to.rotateAngleY - this.rotateAngleY) / maxTime * timer;
        this.rotateAngleZ += (to.rotateAngleZ - this.rotateAngleZ) / maxTime * timer;
        this.rotationPointX += (to.rotationPointX - this.rotationPointX) / maxTime * timer;
        this.rotationPointY += (to.rotationPointY - this.rotationPointY) / maxTime * timer;
        this.rotationPointZ += (to.rotationPointZ - this.rotationPointZ) / maxTime * timer;
        this.offsetX += (to.offsetX - this.offsetX) / maxTime * timer;
        this.offsetY += (to.offsetY - this.offsetY) / maxTime * timer;
        this.offsetZ += (to.offsetZ - this.offsetZ) / maxTime * timer;
    }
}
