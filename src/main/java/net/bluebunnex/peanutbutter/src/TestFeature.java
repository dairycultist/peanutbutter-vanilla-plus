package net.bluebunnex.peanutbutter.src;

import net.minecraft.block.Block;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class TestFeature extends Feature {

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {

        // steal from DungeonFeature

        if (world.getBlockId(x, y - 1, z) != Block.GRASS_BLOCK.id)
            return false;

        for (int dx = -2; dx <= 2; dx++) {
            for (int dz = -2; dz <= 2; dz++) {
                for (int dy = -2; dy <= 0; dy++) {

                    if (!world.getMaterial(x + dx, y + dy, z + dz).isSolid())
                        world.setBlock(x + dx, y + dy, z + dz, Block.COBBLESTONE.id);
                }
            }
        }

        world.setBlock(x, y + 1, z, Block.CHEST.id);
        ChestBlockEntity chest = (ChestBlockEntity) world.getBlockEntity(x, y + 1, z);

        for (int i = 0; i < 8; i++) {

            chest.setStack(random.nextInt(chest.size()), this.getRandomChestItem(random));
        }

        return true;
    }

    private ItemStack getRandomChestItem(Random random) {

        int i = random.nextInt(4);

        return switch (i) {
            case 0 -> new ItemStack(Item.GOLDEN_APPLE);
            case 1 -> new ItemStack(Item.APPLE);
            case 2 -> new ItemStack(Item.ARROW, random.nextInt(10) + 5);
            default -> new ItemStack(Item.IRON_INGOT, random.nextInt(4) + 1);
        };
    }
}
