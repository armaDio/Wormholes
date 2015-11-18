package com.armadio.wormholes;


import com.armadio.wormholes.gen.WormHoleWorldGen;
import com.armadio.wormholes.lib.BlockRecipes;
import com.armadio.wormholes.lib.ItemRecipes;
import com.armadio.wormholes.lib.Reference;
import com.armadio.wormholes.proxy.ClientProxy;
import com.armadio.wormholes.proxy.CommonProxy;
import com.armadio.wormholes.proxy.ServerProxy;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Logger;

/**
 * Created by armaDio on 27/03/2015.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Wormholes {

    @SidedProxy(clientSide = Reference.CLIENTSIDE_PROXY ,serverSide = Reference.SERVERSIDE_PROXY)
    public static CommonProxy proxy;
    public static ClientProxy cproxy;
    public static ServerProxy sproxy;

    public static Configuration config;

    public static WormHoleWorldGen wormHoleWorldGen = new WormHoleWorldGen();

    @Mod.Instance(Reference.MOD_ID)
    public static Wormholes instance;

    public static Logger log = FMLLog.getLogger();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        config = new Configuration(event.getSuggestedConfigurationFile());
        //Configurations.syncConfig();


        ModItemsBlocks.initBlocks();
        ModItemsBlocks.initItems();
        BlockRecipes.initShapedRecipes();
        ItemRecipes.initShapedRecipes();
        ItemRecipes.initShapelessRecipes();
        ItemRecipes.initSmeltingRecipes();
        log.info("Wormholes is pre initializating");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        //registra blocchi, etc
        proxy.registerRenders();
        log.info("Wormholes is initializating");
        GameRegistry.registerWorldGenerator(wormHoleWorldGen, 0);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        log.info("Wormholes has been loaded");
    }



    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        /*if(event.modID==Reference.MOD_ID) {
            Configurations.syncConfig();
        }*/
    }

}
