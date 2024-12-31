package net.bluebunnex.peanutbutter.worldgen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public abstract class ConditionalFeature extends Feature {

    private int rarity;

    public ConditionalFeature(int rarity) {

        this.rarity = rarity;
    }

    public boolean shouldGenerate(Random random, Biome biome) {

        return random.nextInt(rarity) == 0;
    }
}
