package com.armadio.wormholes.particles;

import com.armadio.wormholes.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Michele on 11/19/2015.
 */
public class WormholeParticleFX extends EntityFX {

    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/particles/wormhole.png");
    private int rotation = 0;



    public WormholeParticleFX(World world, double x, double y, double z){
        super(world,x,y,z);
        Random r = new Random();
        setGravity(0.2f);
        setMaxAge(10+r.nextInt(21));
        rotation = 0;
    }

    @Override
    public void renderParticle(Tessellator tess, float partialTicks, float par3, float par4, float par5, float par6, float par7) {
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        glDepthMask(false);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glAlphaFunc(GL_GREATER,0.003921569F);
        tess.startDrawingQuads();
        tess.setBrightness(getBrightnessForRender(partialTicks));
        float scale = 0.1F*particleScale;
        float x = (float)(prevPosX+(posX-prevPosX)*partialTicks-interpPosX);
        float y = (float)(prevPosY+(posY-prevPosY)*partialTicks-interpPosY);
        float z = (float)(prevPosZ+(posZ-prevPosZ)*partialTicks-interpPosZ);
        tess.addVertexWithUV(x-par3*scale-par6*scale,y-par4*scale,z-par5*scale-par7*scale,0,0);
        tess.addVertexWithUV(x-par3*scale+par6*scale,y+par4*scale,z-par5*scale+par7*scale,1,0);
        tess.addVertexWithUV(x+par3*scale+par6*scale,y+par4*scale,z-par5*scale+par7*scale,1,1);
        tess.addVertexWithUV(x+par3*scale-par6*scale,y-par4*scale,z-par5*scale-par7*scale,0,1);
        setRotation(0,rotation);
        rotation+=15;
        tess.draw();
        glDisable(GL_BLEND);
        glDepthMask(true);
        glAlphaFunc(GL_GREATER,0.1F);
    }


    @Override
    public int getFXLayer() {
        return 3;
    }

    public WormholeParticleFX setMaxAge(int maxAge){
        particleMaxAge = maxAge;
        return this;
    }

    public WormholeParticleFX setGravity(float gravity){
        particleGravity = gravity;
        return this;
    }

    public WormholeParticleFX setScale(int scale){
        particleScale = scale;
        return this;
    }
}
