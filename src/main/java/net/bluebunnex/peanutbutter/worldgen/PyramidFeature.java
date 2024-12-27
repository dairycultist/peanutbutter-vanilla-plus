package net.bluebunnex.peanutbutter.worldgen;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.minecraft.block.Block;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class PyramidFeature extends Feature {

    private final int baseBlockId;

    public PyramidFeature(int baseBlockId) {

        this.baseBlockId = baseBlockId;
    }

    // steal from DungeonFeature

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {

        int groundBlockId = world.getBlockId(x, y - 1, z);

        if (groundBlockId != Block.GRASS_BLOCK.id && groundBlockId != Block.SAND.id)
            return false;

        // floor
        for (int dx = -9; dx <= 9; dx++) {
            for (int dz = -9; dz <= 9; dz++) {

                world.setBlock(x + dx, y - 1, z + dz, baseBlockId);
            }
        }

        // floor foundation
        for (int dx = -9; dx <= 9; dx++) {
            for (int dz = -9; dz <= 9; dz++) {
                for (int dy = -3; dy <= -2; dy++) {

                    if (!world.getMaterial(x + dx, y + dy, z + dz).isSolid())
                        world.setBlock(x + dx, y + dy, z + dz, baseBlockId);
                }
            }
        }

        // actual pyramid part
        for (int dy = 0; dy <= 9; dy++) {

            int min = dy - 9;
            int max = 9 - dy;

            for (int dx = min; dx <= max; dx++) {
                for (int dz = min; dz <= max; dz++) {

                    if ((dx == min || dx == max || dz == min || dz == max) && !(Math.abs(dx) < 2 && dy < 3)) {
                        world.setBlock(x + dx, y + dy, z + dz, baseBlockId);
                    } else {
                        world.setBlock(x + dx, y + dy, z + dz, 0);
                    }
                }
            }
        }

        ChestBlockEntity chest;

        // chests on sides doors aren't
        world.setBlock(x + 6, y, z, Block.CHEST.id);
        chest = (ChestBlockEntity) world.getBlockEntity(x + 6, y, z);

        for (int i = 0; i < 8; i++) {

            chest.setStack(random.nextInt(chest.size()), this.getRandomChestItem(random));
        }

        world.setBlock(x - 6, y, z, Block.CHEST.id);
        chest = (ChestBlockEntity) world.getBlockEntity(x - 6, y, z);

        for (int i = 0; i < 8; i++) {

            chest.setStack(random.nextInt(chest.size()), this.getRandomChestItem(random));
        }

        // floor center
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {

                world.setBlock(x + dx, y - 1, z + dz, Block.COBBLESTONE.id);
            }
        }

        world.setBlock(x, y, z, Block.SPAWNER.id);
        ((MobSpawnerBlockEntity) world.getBlockEntity(x, y, z)).setSpawnedEntityId("Creeper");

        return true;
    }

    private ItemStack getRandomChestItem(Random random) {

        int i = random.nextInt(5);

        return switch (i) {
            case 0 -> random.nextInt(12) == 0 ? new ItemStack(Item.GOLDEN_APPLE) : new ItemStack(Item.APPLE);
            case 1 -> new ItemStack(Item.ARROW, random.nextInt(10) + 5);
            case 2 -> new ItemStack(Peanutbutter.COPPER_INGOT, random.nextInt(3) + 1);
            case 3 -> new ItemStack(random.nextInt(2) == 0 ? Item.STONE_SWORD : Item.STONE_PICKAXE, 1, random.nextInt(ToolMaterial.STONE.getDurability() / 2, ToolMaterial.STONE.getDurability()));
            default -> random.nextInt(8) == 0 ? Peanutbutter.getRareLoot(random) : null;
        };
    }
}
