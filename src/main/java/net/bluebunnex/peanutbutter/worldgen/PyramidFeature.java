package net.bluebunnex.peanutbutter.worldgen;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.minecraft.block.Block;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Random;

public class PyramidFeature extends ConditionalFeature {

    private final Biome biome;
    private final int baseBlockId;

    public PyramidFeature(int rarity, Biome biome) {
        super(rarity);

        this.biome = biome;

        if (biome == Biome.PLAINS) {

            this.baseBlockId = Peanutbutter.STONE_BRICKS.id;

        } else if (biome == Biome.DESERT) {

            this.baseBlockId = Block.SANDSTONE.id;

        } else { // Biome.hell

            this.baseBlockId = Peanutbutter.CARVED_BONE.id;
        }
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {

        int groundBlockId = world.getBlockId(x, y - 1, z);

        if (
                   (this.biome == Biome.PLAINS && groundBlockId != Block.GRASS_BLOCK.id)
                || (this.biome == Biome.DESERT && groundBlockId != Block.SAND.id)
                || (this.biome == Biome.HELL   && groundBlockId != Block.NETHERRACK.id)
            )
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

        // gold cap when in nether
        if (biome == Biome.HELL)
            world.setBlock(x, y + 9, z, Block.GOLD_BLOCK.id);

        // chests on sides doors aren't
        // (stolen from DungeonFeature)
        ChestBlockEntity chest;

        world.setBlock(x + 6, y, z, Block.CHEST.id);
        chest = (ChestBlockEntity) world.getBlockEntity(x + 6, y, z);

        for (int i = 0; i < 12; i++) {

            chest.setStack(random.nextInt(chest.size()), Peanutbutter.getRandomChestItem(random, this.biome));
        }

        world.setBlock(x - 6, y, z, Block.CHEST.id);
        chest = (ChestBlockEntity) world.getBlockEntity(x - 6, y, z);

        for (int i = 0; i < 12; i++) {

            chest.setStack(random.nextInt(chest.size()), Peanutbutter.getRandomChestItem(random, this.biome));
        }

        // floor center
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {

                world.setBlock(x + dx, y - 1, z + dz, Block.COBBLESTONE.id);
            }
        }

        // TODO change spawned mob if this is a nether pyramid (to what idk)
        world.setBlock(x, y, z, Block.SPAWNER.id);
        ((MobSpawnerBlockEntity) world.getBlockEntity(x, y, z)).setSpawnedEntityId("Creeper");

        return true;
    }

    @Override
    public boolean shouldGenerate(Random random, Biome biome) {

        if (biome != Biome.PLAINS && biome != Biome.DESERT && biome != Biome.HELL)
            return false;

        return super.shouldGenerate(random, biome);
    }
}
