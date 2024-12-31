package net.bluebunnex.peanutbutter.worldgen;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class SmallRuinFeature extends Feature {

    // basically a procedurally generated structure (as opposed to more-or-less preset)

    // creates a ring of stone/cobblestone with random gaps, then above that does the same except
    // only placing blocks where there is a block below to support it

    // also the floor is brick

    // steal from DungeonFeature

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        return false;
    }
}
