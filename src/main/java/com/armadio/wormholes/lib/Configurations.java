package com.armadio.wormholes.lib;

/**
 * Created by armaDio on 28/03/2015.
 */
public class Configurations {
/*
    public static boolean areaEffect;
    public static final boolean AREAEFFECT_DEFAULT = true;
    public static final String AREAEFFECT_DESCRIPTION = "Activates the potion effects in an area around the player or just to him";
    public static int t1duration;
    public static final int T1DURATION_DEFAULT = 1200;
    public static final String T1DURATION_DESCRIPTION = "Duration of the effect for T1 Instruments in ticks (20 in one second)";
    public static int t2duration;
    public static final int T2DURATION_DEFAULT = 3000;
    public static final String T2DURATION_DESCRIPTION = "Duration of the effect for T2 Instruments in ticks (20 in one second)";
    public static int t3duration;
    public static final int T3DURATION_DEFAULT = 6000;
    public static final String T3DURATION_DESCRIPTION = "Duration of the effect for T3 Instruments in ticks (20 in one second)";
    public static int t1durability;
    public static final int T1DURABILITY_DEFAULT = 4;
    public static final String T1DURABILITY_DESCRIPTION = "Number of Uses for T1 Instruments";
    public static int t2durability;
    public static final int T2DURABILITY_DEFAULT = 6;
    public static final String T2DURABILITY_DESCRIPTION = "Number of Uses for T2 Instruments";
    public static int t3durability;
    public static final int T3DURABILITY_DEFAULT = 8;
    public static final String T3DURABILITY_DESCRIPTION = "Number of Uses for T3 Instruments";

    public static void syncConfig(){
        //configuration init
        FMLCommonHandler.instance().bus().register(MagicalInstrument.instance);


        //categoria
        final String MISC = MagicalInstrument.config.CATEGORY_GENERAL + MagicalInstrument.config.CATEGORY_SPLITTER + "MISC";
        MagicalInstrument.config.addCustomCategoryComment(MISC,"Enable or disable various options");

        final String INST_SET = MagicalInstrument.config.CATEGORY_GENERAL + MagicalInstrument.config.CATEGORY_SPLITTER + "INSTRUMENTS_SETTINGS";
        MagicalInstrument.config.addCustomCategoryComment(INST_SET,"Change settings for the various instruments");

        //impostazione in quella categoria
        areaEffect = MagicalInstrument.config.get(MISC, "AREA_EFFECT",AREAEFFECT_DEFAULT,AREAEFFECT_DESCRIPTION).getBoolean(AREAEFFECT_DEFAULT);

        t1durability = MagicalInstrument.config.get(INST_SET, "T1_DURABILITY",T1DURABILITY_DEFAULT,T1DURABILITY_DESCRIPTION).getInt(T1DURABILITY_DEFAULT)-1;
        t2durability = MagicalInstrument.config.get(INST_SET, "T2_DURABILITY",T2DURABILITY_DEFAULT,T2DURABILITY_DESCRIPTION).getInt(T2DURABILITY_DEFAULT)-1;
        t3durability = MagicalInstrument.config.get(INST_SET, "T3_DURABILITY",T3DURABILITY_DEFAULT,T3DURABILITY_DESCRIPTION).getInt(T3DURABILITY_DEFAULT)-1;

        t1duration = MagicalInstrument.config.get(INST_SET, "T1_DURATION",T1DURATION_DEFAULT,T1DURATION_DESCRIPTION).getInt(T1DURATION_DEFAULT);
        t2duration = MagicalInstrument.config.get(INST_SET, "T2_DURATION",T2DURATION_DEFAULT,T2DURATION_DESCRIPTION).getInt(T2DURATION_DEFAULT);
        t3duration = MagicalInstrument.config.get(INST_SET, "T3_DURATION",T3DURATION_DEFAULT,T3DURATION_DESCRIPTION).getInt(T3DURATION_DEFAULT);


        //salvo in base alle modifiche
        if(MagicalInstrument.config.hasChanged())
            MagicalInstrument.config.save();
    }
    */
}
