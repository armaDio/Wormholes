package com.armadio.wormholes.blocks;

import com.armadio.wormholes.ModItemsBlocks;
import com.armadio.wormholes.Wormholes;
import com.armadio.wormholes.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by Michele on 11/28/2015.
 */
    public class Dust extends Block
    {
        public Dust()
        {
            super(Wormholes.dustMaterial);
            setHardness(0.3F);
            this.setStepSound(soundTypeCloth);
            this.setBlockName("dust");
            setBlockTextureName(Reference.MOD_ID+":dust");
            this.setCreativeTab(CreativeTabs.tabMisc);
        }

        @Override
        public void onEntityCollidedWithBlock (World world, int x, int y, int z, Entity entity)
        {
            if (entity.motionY < 0.0D)
            {
                entity.motionY *= 0.005D;
            }
            entity.fallDistance = 0.0F;
        }


        @Override
        public int getRenderBlockPass ()
        {
            return 1;
        }

        @Override
        public boolean shouldSideBeRendered (IBlockAccess iblockaccess, int x, int y, int z, int side)
        {
            Block block = iblockaccess.getBlock(x, y, z);
            if (block == ModItemsBlocks.dust)
            {
                return false;
            }
            else
            {
                return super.shouldSideBeRendered(iblockaccess, x, y, z, side);
            }
        }

        @Override
        public boolean renderAsNormalBlock ()
        {
            return false;
        }

        @Override
        public boolean isOpaqueCube ()
        {
            return false;
        }


        @Override
        public boolean isBlockSolid (IBlockAccess iblockaccess, int x, int y, int z, int l)
        {
            Block block = iblockaccess.getBlock(x, y, z);
            if (block == ModItemsBlocks.dust)
            {
                return false;
            }
            else
            {
                return super.isBlockSolid(iblockaccess, x, y, z, l);
            }
        }

        @Override
        public AxisAlignedBB getCollisionBoundingBoxFromPool (World world, int x, int y, int z)
        {
            if (world.getBlock(x, y - 1, z) == ModItemsBlocks.dust)
            {
                return null;
            }
            else
            {
                return AxisAlignedBB.getBoundingBox(x, y, z, x + 1.0D, y + 0.0625D, z + 1.0D);
            }
        }


    /* Explosions! */
    }