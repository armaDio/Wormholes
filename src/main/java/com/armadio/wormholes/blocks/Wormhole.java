package com.armadio.wormholes.blocks;

import com.armadio.wormholes.ModItemsBlocks;
import com.armadio.wormholes.lib.Reference;
import com.armadio.wormholes.particles.WormholeParticleFX;
import com.armadio.wormholes.tileentity.TileEntityWormhole;
import com.google.common.collect.HashBiMap;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapData;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by armaDio on 21/07/2015.
 */
public class Wormhole extends BlockContainer{

    private static  Random r = new Random();
    public Wormhole() {
        super(Material.grass);

        this.setBlockUnbreakable();

        this.setBlockName("wormhole");
        setBlockTextureName(Reference.MOD_ID+":"+"wormhole");
        //this.setCreativeTab(CreativeTabs.tabDecorations);
        }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityWormhole();
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }


    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random r) {
        double fx = r.nextGaussian();
        double dx = -0.5 + r.nextDouble()*2;
        double fz = r.nextGaussian();
        double dz = -0.5 + r.nextDouble()*2;
        //TODO fix particle rotation
        //Minecraft.getMinecraft().effectRenderer.addEffect(new WormholeParticleFX(world , x + fx + dx , y , z + fz + dz ));
    }


    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        super.onEntityCollidedWithBlock(world, x, y, z, entity);
        TileEntityWormhole te = (TileEntityWormhole) world.getTileEntity(x, y,z);
        entity.setPosition(te.x,te.y-2, te.z);
    }
}
