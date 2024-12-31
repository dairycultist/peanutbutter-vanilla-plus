package net.bluebunnex.peanutbutter.worldgen;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class ProceduralRuinFeature extends ConditionalFeature {

    public ProceduralRuinFeature(int rarity) {
        super(rarity);
    }

    // basically a procedurally generated structure (as opposed to more-or-less preset)

    // creates a ring of stone/cobblestone with random gaps, then above that does the same except
    // only placing blocks where there is a block below to support it

    // also the floor is brick + dirt

    // steal from DungeonFeature

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {

        double radius = random.nextDouble(5, 10);

        int groundBlockId = world.getBlockId(x, y - 1, z);

        if (groundBlockId != Block.GRASS_BLOCK.id && groundBlockId != Block.SAND.id)
            return false;

        // floor
        for (double r = 0; r <= radius; r += 0.1) {
            for (double a = 0; a <= Math.PI; a += 0.1) {
                for (int dy = -8; dy < 5; dy++) {

                    int dx = (int) (Math.cos(a) * r);
                    int dz = (int) (Math.sin(a) * r);

                    if (dy == -1) {

                        world.setBlock(x + dx, y + dy, z + dz, Peanutbutter.STONE_BRICKS.id);
                        world.setBlock(x - dx, y + dy, z - dz, Peanutbutter.STONE_BRICKS.id);

                    } else if (dy > -1) {

                        world.setBlock(x + dx, y + dy, z + dz, 0);
                        world.setBlock(x - dx, y + dy, z - dz, 0);

                    } else {

                        if (!world.getMaterial(x + dx, y + dy, z + dz).isSolid())
                            world.setBlock(x + dx, y + dy, z + dz, Peanutbutter.STONE_BRICKS.id);

                        if (!world.getMaterial(x - dx, y + dy, z - dz).isSolid())
                            world.setBlock(x - dx, y + dy, z - dz, Peanutbutter.STONE_BRICKS.id);
                    }
                }
            }
        }

        return true;
    }
}
