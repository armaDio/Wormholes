package com.armadio.wormholes;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * Created by Michele on 11/28/2015.
 */
public class DustMaterial  extends Material {
        public DustMaterial()
        {
            super(MapColor.snowColor);
            //this.setReplaceable();
            this.setNoPushMobility();
        }

        /**
         * Returns if blocks of these materials are liquids.
         */
        @Override
        public boolean isLiquid ()
        {
            return false;
        }

        /**
         * Returns if this material is considered solid or not
         */
        @Override
        public boolean blocksMovement ()
        {
            return true;
        }

        @Override
        public boolean isSolid ()
        {
            return false;
        }

        @Override
        public boolean getCanBlockGrass ()
        {
            return false;
        }
    }
