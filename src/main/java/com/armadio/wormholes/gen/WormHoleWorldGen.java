package com.armadio.wormholes.gen;

import com.armadio.wormholes.ModItemsBlocks;
import com.armadio.wormholes.Wormholes;
import com.armadio.wormholes.blocks.Wormhole;
import com.armadio.wormholes.tileentity.TileEntityWormhole;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
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
        if(random.nextDouble() < 0.1){
            int x1 = xChunk * 16 + random.nextInt(16);
            int z1 = zChunk * 16 + random.nextInt(16);
            int y1 = world.getHeightValue(x1, z1);

            int x2 = x1 + ((random.nextBoolean()?(-1):1) * (random.nextInt(10000) + 5000));
            int y2 = 100 + random.nextInt(100);
            int z2 = z1 + ((random.nextBoolean()?(-1):1) * (random.nextInt(10000) + 5000));

            world.setBlock(x1,y1,z1, ModItemsBlocks.wormhole);
            world.setBlock(x2,y2,z2, ModItemsBlocks.wormhole);

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
}