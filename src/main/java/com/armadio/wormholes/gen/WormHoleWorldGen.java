package com.armadio.wormholes.gen;

import com.armadio.wormholes.ModItemsBlocks;
import com.armadio.wormholes.Wormholes;
import com.armadio.wormholes.blocks.Wormhole;
import com.armadio.wormholes.lib.Configurations;
import com.armadio.wormholes.tileentity.TileEntityWormhole;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by armaDio on 21/07/2015.
 */
public class WormHoleWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int xChunk, int zChunk, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        if(random.nextDouble() < Configurations.probability){
            int x1 = xChunk * 16 + random.nextInt(16);
            int z1 = zChunk * 16 + random.nextInt(16);
            int y1 = 10 + random.nextInt(240);//world.getHeightValue(x1, z1);

            int x2 = x1 + ((random.nextBoolean()?(-1):1) * (random.nextInt(10000) + 5000));
            int y2 = 10 + random.nextInt(240);
            int z2 = z1 + ((random.nextBoolean()?(-1):1) * (random.nextInt(10000) + 5000));

            structure(world,x1,y1,z1);
            structure(world,x2,y2,z2);

            setCoord(world, x1, y1, z1, x2, y2, z2);
            setCoord(world, x2, y2, z2, x1, y1, z1);
        }
    }

    private void setCoord(World world, int x1, int y1, int z1, int x2, int y2, int z2){
        TileEntityWormhole tileEntityWormhole = (TileEntityWormhole)world.getTileEntity(x1, y1, z1);
        tileEntityWormhole.x = x2;
        tileEntityWormhole.y = y2;
        tileEntityWormhole.z = z2;
    }
    private void structure(World world, int xW, int yW, int zW){
        Block air = Blocks.air;
        Block wormhole = ModItemsBlocks.wormhole;
        Block dust = ModItemsBlocks.dust;


        for (int i = -1; i<2; i++)
            for(int j = -1;j<2;j++) {
                world.setBlock(xW + i, yW + 2, zW + j, dust);
                world.setBlock(xW + i, yW -4, zW + j, dust);
            }

        for (int i = -2;i<3;i++)
            for(int j = -2;j<3;j++)
                if(Math.abs(i)== 2 || Math.abs(j)==2) {
                    world.setBlock(xW + i, yW + 1, zW + j, dust);
                    world.setBlock(xW+i,yW-3, zW + j, dust);
                } else {
                    world.setBlock(xW + i, yW + 1, zW + j, air);
                    world.setBlock(xW + i, yW -3, zW + j, air);
                }

        for (int i = -3;i<4;i++)
            for(int j = -3;j<4;j++)
                for(int k = 0; k>-3;k--)
                    if(i==j&& j==k&& k==0)
                        world.setBlock(xW,yW,zW, wormhole);
                    else if(Math.abs(i)== 3 ^ Math.abs(j)==3)
                        world.setBlock(xW+i,yW+k,zW+j, dust);
                    else if(Math.abs(i)== 3 && Math.abs(j)==3);
                    else
                        world.setBlock(xW+i,yW+k,zW+j, air);
    }
}