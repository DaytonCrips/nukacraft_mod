package com.dayton.nukacraft.client.models.endity;

import com.dayton.nukacraft.client.models.endity.core.AdvancedModelBox;
import com.dayton.nukacraft.client.models.endity.core.Animation;
import com.dayton.nukacraft.client.models.endity.core.IAnimatedEntity;
import com.dayton.nukacraft.client.models.endity.core.Transform;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Iterator;

@OnlyIn(Dist.CLIENT)
public class ModelAnimator {
    private int tempTick = 0;
    private int prevTempTick;
    private boolean correctAnimation = false;
    private IAnimatedEntity entity;
    private HashMap<AdvancedModelBox, Transform> transformMap = new HashMap();
    private HashMap<AdvancedModelBox, Transform> prevTransformMap = new HashMap();

    public ModelAnimator() {
    }

    public static ModelAnimator create() {
        return new ModelAnimator();
    }

    public IAnimatedEntity getEntity() {
        return this.entity;
    }

    public void update(IAnimatedEntity entity) {
        this.tempTick = this.prevTempTick = 0;
        this.correctAnimation = false;
        this.entity = entity;
        this.transformMap.clear();
        this.prevTransformMap.clear();
    }

    public boolean setAnimation(Animation animation) {
        this.tempTick = this.prevTempTick = 0;
        this.correctAnimation = this.entity.getAnimation() == animation;
        return this.correctAnimation;
    }

    public void startKeyframe(int duration) {
        if (this.correctAnimation) {
            this.prevTempTick = this.tempTick;
            this.tempTick += duration;
        }
    }

    public void setStaticKeyframe(int duration) {
        this.startKeyframe(duration);
        this.endKeyframe(true);
    }

    public void resetKeyframe(int duration) {
        this.startKeyframe(duration);
        this.endKeyframe();
    }

    public void rotate(AdvancedModelBox box, float x, float y, float z) {
        if (this.correctAnimation) {
            this.getTransform(box).addRotation(x, y, z);
        }
    }

    public void move(AdvancedModelBox box, float x, float y, float z) {
        if (this.correctAnimation) {
            this.getTransform(box).addOffset(x, y, z);
        }
    }

    private Transform getTransform(AdvancedModelBox box) {
        return (Transform)this.transformMap.computeIfAbsent(box, (b) -> {
            return new Transform();
        });
    }

    public void endKeyframe() {
        this.endKeyframe(false);
    }

    private void endKeyframe(boolean stationary) {
        if (this.correctAnimation) {
            int animationTick = this.entity.getAnimationTick();
            if (animationTick >= this.prevTempTick && animationTick < this.tempTick) {
                AdvancedModelBox box;
                Transform transform;
                if (stationary) {
                    for(Iterator var3 = this.prevTransformMap.keySet().iterator(); var3.hasNext(); box.rotationPointZ += transform.getOffsetZ()) {
                        box = (AdvancedModelBox)var3.next();
                        transform = (Transform)this.prevTransformMap.get(box);
                        box.rotateAngleX += transform.getRotationX();
                        box.rotateAngleY += transform.getRotationY();
                        box.rotateAngleZ += transform.getRotationZ();
                        box.rotationPointX += transform.getOffsetX();
                        box.rotationPointY += transform.getOffsetY();
                    }
                } else {
                    float tick = ((float)(animationTick - this.prevTempTick) + Minecraft.getInstance().getFrameTime()) / (float)(this.tempTick - this.prevTempTick);
                    float inc = Mth.sin((float)((double)tick * Math.PI / 2.0));
                    float dec = 1.0F - inc;

                    Iterator var6;
//                    AdvancedModelBox box2;
//                    Transform transform;
                    for(var6 = this.prevTransformMap.keySet().iterator(); var6.hasNext(); box.rotationPointZ += dec * transform.getOffsetZ()) {
                        box = (AdvancedModelBox)var6.next();
                        transform = (Transform)this.prevTransformMap.get(box);
                        box.rotateAngleX += dec * transform.getRotationX();
                        box.rotateAngleY += dec * transform.getRotationY();
                        box.rotateAngleZ += dec * transform.getRotationZ();
                        box.rotationPointX += dec * transform.getOffsetX();
                        box.rotationPointY += dec * transform.getOffsetY();
                    }

                    for(var6 = this.transformMap.keySet().iterator(); var6.hasNext(); box.rotationPointZ += inc * transform.getOffsetZ()) {
                        box = (AdvancedModelBox)var6.next();
                        transform = this.transformMap.get(box);
                        box.rotateAngleX += inc * transform.getRotationX();
                        box.rotateAngleY += inc * transform.getRotationY();
                        box.rotateAngleZ += inc * transform.getRotationZ();
                        box.rotationPointX += inc * transform.getOffsetX();
                        box.rotationPointY += inc * transform.getOffsetY();
                    }
                }
            }

            if (!stationary) {
                this.prevTransformMap.clear();
                this.prevTransformMap.putAll(this.transformMap);
                this.transformMap.clear();
            }

        }
    }
}