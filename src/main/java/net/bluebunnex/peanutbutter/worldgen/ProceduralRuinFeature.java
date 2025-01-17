package net.bluebunnex.peanutbutter.worldgen;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.minecraft.block.Block;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.world.World;

import java.util.Random;

public class ProceduralRuinFeature extends ConditionalFeature {

    // basically a procedurally generated structure (as opposed to more-or-less preset)

    public ProceduralRuinFeature(int rarity) {
        super(rarity);
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {

        double radius = random.nextDouble(5, 10);

        int groundBlockId = world.getBlockId(x, y - 1, z);

        if (groundBlockId != Block.GRASS_BLOCK.id && groundBlockId != Block.SAND.id)
            return false;

        // creates a ring of stone/cobblestone with random gaps, then above that does the same except
        // only placing blocks where there is a block below to support it
        for (double a = 0; a <= Math.PI; a += 0.1) {

            int dx = (int) (Math.cos(a) * radius);
            int dz = (int) (Math.sin(a) * radius);

            for (int dy = -8; dy < 3; dy++) {

                if (dy == -1) {

                    world.setBlock(x + dx, y + dy, z + dz, Peanutbutter.RUNIC_STONE.id);
                    world.setBlock(x - dx, y + dy, z - dz, Peanutbutter.RUNIC_STONE.id);

                } else {

                    int blockID = random.nextInt(10) > 3 ? Peanutbutter.STONE_BRICKS.id
                                : random.nextInt(2) == 0 ? Block.COBBLESTONE.id : Block.STONE.id;

                    if (dy > -1) {

                        if (world.getMaterial(x + dx, y + dy - 1, z + dz).isSolid() && random.nextInt(10) > 2 + dy)
                            world.setBlock(x + dx, y + dy, z + dz, blockID);

                        if (world.getMaterial(x - dx, y + dy - 1, z - dz).isSolid() && random.nextInt(10) > 2 + dy)
                            world.setBlock(x - dx, y + dy, z - dz, blockID);

                    } else {

                        if (!world.getMaterial(x + dx, y + dy, z + dz).isSolid())
                            world.setBlock(x + dx, y + dy, z + dz, blockID);

                        if (!world.getMaterial(x - dx, y + dy, z - dz).isSolid())
                            world.setBlock(x - dx, y + dy, z - dz, blockID);
                    }
                }
            }
        }

        // chest
        world.setBlock(x, y, z, Block.CHEST.id);
        ChestBlockEntity chest = (ChestBlockEntity) world.getBlockEntity(x, y, z);

        for (int i = 0; i < 6; i++) {

            chest.setStack(random.nextInt(chest.size()), Peanutbutter.getRandomChestItem(random, null));
        }

        return true;
    }
}
