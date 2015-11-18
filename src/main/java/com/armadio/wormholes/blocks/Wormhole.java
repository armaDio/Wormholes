package com.armadio.wormholes.blocks;

import com.armadio.wormholes.ModItemsBlocks;
import com.armadio.wormholes.tileentity.TileEntityWormhole;
import com.google.common.collect.HashBiMap;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
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
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        super.onEntityCollidedWithBlock(world, x, y, z, entity);
        TileEntityWormhole te = (TileEntityWormhole) world.getTileEntity(x, y,z);
        entity.setPosition(te.x+2,te.y, te.z+2);
        if(entity instanceof EntityPlayer){
            ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.jump.id,20*10,9));
        }
    }
}
