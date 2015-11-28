package com.armadio.wormholes.lib;

import com.armadio.wormholes.Wormholes;
import cpw.mods.fml.common.FMLCommonHandler;

/**
 * Created by armaDio on 28/03/2015.
 */
public class Configurations {
    public static double probability;
    public static final double PROBABILITY_DEFAULT = 0.005;
    public static final String PROBABILITY_DESC = "Probability a wormhole generates in a specific chunk (keep it over 50)";

    public static void syncConfig(){
        //configuration init
        FMLCommonHandler.instance().bus().register(Wormholes.instance);


        //categoria
        final String WORLDGEN = Wormholes.config.CATEGORY_GENERAL + Wormholes.config.CATEGORY_SPLITTER + "WORLDGEN";
        Wormholes.config.addCustomCategoryComment(WORLDGEN,"Worldgen settings");

        //impostazione in quella categoria
        probability = Wormholes.config.get(WORLDGEN, "Probability",PROBABILITY_DEFAULT,PROBABILITY_DESC).getDouble(PROBABILITY_DEFAULT);

        //salvo in base alle modifiche
        if(Wormholes.config.hasChanged())
            Wormholes.config.save();
    }

}
