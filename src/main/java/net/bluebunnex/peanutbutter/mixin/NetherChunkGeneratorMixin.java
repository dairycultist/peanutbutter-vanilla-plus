package net.bluebunnex.peanutbutter.mixin;

import net.bluebunnex.peanutbutter.Peanutbutter;
import net.bluebunnex.peanutbutter.worldgen.ConditionalFeature;
import net.bluebunnex.peanutbutter.worldgen.PyramidFeature;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.gen.chunk.NetherChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(NetherChunkGenerator.class)
public class NetherChunkGeneratorMixin {

    @Shadow
    private Random random;

    @Shadow
    private World world;

    @Inject(method = "decorate", at = @At("TAIL"))
    private void decorateMixin(ChunkSource source, int x, int z, CallbackInfo ci) {

        final int blockX = x * 16, blockZ = z * 16;

        int featureX, featureY, featureZ;

        // hematite ore
        for (int i = 0; i < 25; i++) {

            featureX = blockX + this.random.nextInt(16) + 8;
            featureY = this.random.nextInt(128);
            featureZ = blockZ + this.random.nextInt(16) + 8;

            // slight problem: OreFeature only replaces stone, not netherrack
            // also: might make hematite only generate around lava? idk
            if (this.world.getBlockId(featureX, featureY, featureZ) == Block.NETHERRACK.id)
                this.world.setBlock(featureX, featureY, featureZ, Peanutbutter.HEMATITE_ORE.id);
        }

        // structures
        ConditionalFeature[] features = {
                new PyramidFeature(256, Biome.HELL)
        };

        for (ConditionalFeature feature : features) {

            if (feature.shouldGenerate(random, Biome.HELL)) {

                // start at y=80 (if it's air), go down until the block below isn't air, then spawn
                featureX = blockX + this.random.nextInt(16) + 8;
                featureY = 80;
                featureZ = blockZ + this.random.nextInt(16) + 8;

                if (this.world.getBlockId(featureX, featureY, featureZ) == 0) {

                    while (this.world.getBlockId(featureX, featureY - 1, featureZ) == 0)
                        featureY--;

                    feature.prepare(1.0, 1.0, 1.0);
                    feature.generate(this.world, this.random, featureX, featureY, featureZ);
                }
            }
        }
    }
}
