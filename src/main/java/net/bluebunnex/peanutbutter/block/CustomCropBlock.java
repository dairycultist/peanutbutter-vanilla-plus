package net.bluebunnex.peanutbutter.block;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.template.block.TemplateCropBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class CustomCropBlock extends TemplateCropBlock {

    private Item product, seed;

    public CustomCropBlock(Identifier identifier) {
        super(identifier, 88);

        this.setSoundGroup(Block.DIRT_SOUND_GROUP);
    }

    public void setProductAndSeed(Item product, Item seed) {

        this.product = product;
        this.seed = seed;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }

    @Override
    public void dropStacks(World world, int x, int y, int z, int meta, float luck) {

        if (!world.isRemote && meta == 7) {

            int count;

            if (product != null) {

                count = world.random.nextInt(2, 5);

                for (int i = 0; i < count; i++) {

                    this.dropStack(world, x, y, z, new ItemStack(product, 1, 0));
                }
            }

            if (seed != null) {

                count = world.random.nextInt(2, 4);

                for (int i = 0; i < count; i++) {

                    this.dropStack(world, x, y, z, new ItemStack(seed, 1, 0));
                }
            }
        }
    }

    @Override
    public boolean onBonemealUse(World world, int x, int y, int z, BlockState state) {

        if (world.getBlockMeta(x, y, z) != 7) {

            this.applyFullGrowth(world, x, y, z);
            return true;

        } else {

            return false;
        }
    }
}
