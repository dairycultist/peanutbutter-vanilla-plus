package net.bluebunnex.peanutbutter.mixin;

import net.bluebunnex.peanutbutter.src.TestFeature;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.gen.chunk.OverworldChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
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

        // test structure
        if (Math.random() > 0.9) {

            int featureX = x * 16 + this.random.nextInt(16) + 8;
            int featureZ = z * 16 + this.random.nextInt(16) + 8;

            Feature feature = new TestFeature();
            feature.prepare(1.0, 1.0, 1.0);
            feature.generate(this.world, this.random, featureX, this.world.getTopY(featureX, featureZ), featureZ);
        }
    }
}
