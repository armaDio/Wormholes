package com.armadio.wormholes.tileentity;

import com.armadio.wormholes.Wormholes;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

import java.util.Random;

/**
 * Created by armaDio on 21/07/2015.
 */
public class TileEntityWormhole extends TileEntity {

    private int x,y,z;

    public int getZ() {
        return z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TileEntityWormhole(){

    }

    public TileEntityWormhole(Random r){
        x = (r.nextBoolean()?(-1):1) * r.nextInt(3000);
        y = 100 + r.nextInt(100);
        z = (r.nextBoolean()?(-1):1) * r.nextInt(3000);

        getDescriptionPacket();

        if(FMLCommonHandler.instance().getEffectiveSide().isServer())
        Wormholes.log.error("POSITION  "+ x+" "+y+" "+z, "POSITION");
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        NBTTagList tagList = tagCompound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = tagList.getCompoundTagAt(i);

            x=tag.getInteger("x");
            z=tag.getInteger("z");
            y=tag.getInteger("y");
        }

        if(FMLCommonHandler.instance().getEffectiveSide().isServer())
            Wormholes.log.error("READ" + x +" " + y + " "+ z," ");
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        NBTTagList itemList = new NBTTagList();

        NBTTagCompound tag = new NBTTagCompound();

        tag.setInteger("x",x);
        tag.setInteger("z",z);
        tag.setInteger("y",y);

        itemList.appendTag(tag);
        tagCompound.setTag("coords",itemList);

        if(FMLCommonHandler.instance().getEffectiveSide().isServer())
            Wormholes.log.error("WRITTEN" + x +" " + y + " "+ z," ");
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tileTag = new NBTTagCompound();
        this.writeToNBT(tileTag);
        return new S35PacketUpdateTileEntity(this.xCoord,this.yCoord,this.zCoord,0,tileTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.func_148857_g());
    }
}
