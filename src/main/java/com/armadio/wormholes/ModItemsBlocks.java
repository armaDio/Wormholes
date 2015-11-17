package com.armadio.wormholes;

import com.armadio.wormholes.blocks.Wormhole;
import com.armadio.wormholes.tileentity.TileEntityWormhole;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * Created by armaDio on 27/03/2015.
 */
public class ModItemsBlocks {

    public static Block wormhole;

    public static void initItems(){

    }
    public static void initBlocks() {
        wormhole = new Wormhole();
        GameRegistry.registerBlock(wormhole, "wormhole");
        GameRegistry.registerTileEntity(TileEntityWormhole.class,"TileEntityWormhole");
    }

}
