package com.nukateam.nukacraft.client.render.renderers.projectile;

import com.nukateam.ntgl.client.render.renderers.projectiles.LaserProjectileRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.joml.Vector3f;

public class AssaultronLaserRenderer extends LaserProjectileRenderer {
    private static final float LASER_RADIUS = 0.05F / 1.5f;
    private static final float LASER_GLOW_RADIUS = 0.055F / 1.5f;

    public AssaultronLaserRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected Vector3f getBeamOffset(){
        return new Vector3f(0.0f, 0.0f, -0.05f);
    }

    @Override
    protected float getLaserRadius(){
        return LASER_RADIUS;
    }

    @Override
    protected float getLaserGlowRadius(){
        return LASER_GLOW_RADIUS;
    }

}
