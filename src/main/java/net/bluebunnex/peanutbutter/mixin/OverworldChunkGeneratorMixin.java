package net.bluebunnex.peanutbutter.mixin;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.bluebunnex.peanutbutter.worldgen.PyramidFeature;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.gen.chunk.OverworldChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.PlantPatchFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(OverworldChunkGenerator.class)
public class OverworldChunkGeneratorMixin {

    @Shadow
    private Random random;

    @Shadow
    private World world;

    @Inject(method = "decorate", at = @At("HEAD"))
    private void decorateMixin(ChunkSource source, int x, int z, CallbackInfo ci) {

        final int blockX = x * 16, blockZ = z * 16;

        final Biome biome = this.world.method_1781().getBiome(blockX + 16, blockZ + 16);

        int featureX, featureY, featureZ;

        // copper ore (generates between [32,64) with veins of 6)
        for (int i = 0; i < 12; i++) {

            featureX = blockX + this.random.nextInt(16);
            featureY = this.random.nextInt(32) + 32;
            featureZ = blockZ + this.random.nextInt(16);

            new OreFeature(Peanutbutter.COPPER_ORE.id, 6).generate(this.world, this.random, featureX, featureY, featureZ);
        }

        // dahlias
        if (this.random.nextInt(2) == 0) {

            featureX = blockX + this.random.nextInt(16) + 8;
            featureY = this.random.nextInt(128);
            featureZ = blockZ + this.random.nextInt(16) + 8;

            new PlantPatchFeature(Peanutbutter.DAHLIA.id).generate(this.world, this.random, featureX, featureY, featureZ);
        }

        // test structure
        if ((biome == Biome.PLAINS || biome == Biome.DESERT) && this.random.nextInt(64) == 0) {

            featureX = blockX + this.random.nextInt(16) + 8;
            featureZ = blockZ + this.random.nextInt(16) + 8;

            featureY = this.world.getTopY(featureX, featureZ);

            Feature feature = new PyramidFeature(biome == Biome.PLAINS ? Peanutbutter.STONE_BRICKS.id : Block.SANDSTONE.id);
            feature.prepare(1.0, 1.0, 1.0);
            feature.generate(this.world, this.random, featureX, featureY, featureZ);
        }
    }
}
